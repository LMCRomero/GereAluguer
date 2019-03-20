/*
 * Teste de 18.Jan.2018.
 */
package gerealuguer;

import erros.*;
import java.io.*;
import java.text.*;
import java.util.*;

/**
 * Classe veiculo define um veículo e gere o seu aluguer
 * @author Romero
 */
public class Veiculo implements Serializable {
    private String matricula;
    private float custoDia;
    private boolean alugado;
    private int dataSaida, dataEntrada, noDias;
    
    /**
     * Construtor
     * Inicializa o novo veículo com datas nulas e não alugado
     * @param m Matrícula do novo veículo
     * @param c Custo diário do aluguer
     */
    public Veiculo(String m, float c){
        setMatricula(m);
        custoDia = c;
        alugado = false;
        dataSaida = dataEntrada = noDias = 0;
    }
    
    private final void setMatricula(String m){
        if(m.length() == 8)
            matricula = m;
        else
            matricula="00-AA-00";
    }
    
    /**
     * Obtem a matricula do veículo
     * @return Matricula do veículo
     */
    public String getMatricula(){
        return matricula;
    }
    
    /**
     * Aluga o veículo estabelecendo a data de inicio do aluguer
     * @param dataOut Data de inicio do aluguer
     * @return true em caso de sucesso e false caso esteja alugado
     * @throws VeiculoAlugadoException Quando o veiculo já está alugado e não disponível
     */
    public boolean aluga(int dataOut) throws VeiculoAlugadoException {
        boolean sucesso = false;
        if(!alugado) {
            alugado = true;
            dataSaida = dataOut;
            dataEntrada = noDias = 0;
            sucesso = true;
        }
        else
            throw new VeiculoAlugadoException(matricula);
        
        return sucesso;
    }
    
    /**
     * Devolve o veículo alugado e estabelece a data da devolução
     * @param dataIn Data da devolução
     * @return true em caso de sucesso e 
     *         false caso não esteja alugado ou data inválida
     * @throws VeiculoNaoAlugadoException Quando o veiculo não está alugado
     * @throws DataInvalidaException Quando a data de devolução não é válida
     */
    public boolean devolve(int dataIn) throws VeiculoNaoAlugadoException, DataInvalidaException {
        boolean sucesso = false;
        if(alugado) {
            if(dataIn > dataSaida) {
                alugado = false;
                dataEntrada = dataIn;
                noDias = calculaDias(dataEntrada, dataSaida);
//                System.out.println(matricula + " foi devolvido. " + 
//                        noDias + " dias alugado.");
                sucesso = true;
            } else {
                throw new DataInvalidaException(""+dataIn);
            }
        } else {
            throw new VeiculoNaoAlugadoException(matricula);
        }
        return sucesso;
    }
    
    /**
     * Calcula o custo do último aluguer
     * @return Custo do aluguer
     */
    public float custo(){
        float custo = (float) noDias * custoDia;
        if(!alugado) return custo;
        else return 0F;
    }
    
    /**
     * Obtem o estado de aluguer do veículo
     * @return true se estiver alugado e false caso contrario
     */
    public boolean getAlugado(){
        return alugado;
    }
    
    @Override
    public String toString(){
        return matricula + " - Estado:" + (alugado?"Alugado" + "(" + dataSaida + ")":"Livre") + " Custo(" + custoDia + ")";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.matricula);
        hash = 53 * hash + Float.floatToIntBits(this.custoDia);
        hash = 53 * hash + (this.alugado ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Veiculo other = (Veiculo) obj;
        return this.matricula.equals(other.matricula);
    }

    private int calculaDias(int dataEntra, int dataSai) {
        int dias, aI, aO, mI, mO, dI, dO;
        String anoIn, anoOut, mesIn, mesOut, diaIn, diaOut;
        
        anoIn = Integer.toString(dataEntra).substring(0, 2); aI = Integer.parseInt(anoIn);
        anoOut = Integer.toString(dataSai).substring(0, 2); aO = Integer.parseInt(anoOut);
        mesIn = Integer.toString(dataEntra).substring(2, 4); mI = Integer.parseInt(mesIn);
        mesOut = Integer.toString(dataSai).substring(2, 4); mO = Integer.parseInt(mesOut);
        diaIn = Integer.toString(dataEntra).substring(4); dI = Integer.parseInt(diaIn);
        diaOut = Integer.toString(dataSai).substring(4); dO = Integer.parseInt(diaOut);

        Date dIn = new GregorianCalendar(2000+aI, mI, dI).getTime();
        Date dOut = new GregorianCalendar(2000+aO, mO, dO).getTime();
        long diff = dIn.getTime() - dOut.getTime(  );
        dias = (int)(diff / (1000*60*60*24));
        //System.out.println("dias = " + dias);
        
        return dias;
    }
    
    
}
