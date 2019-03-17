/*
 * Teste de 18.Jan.2018.
 */
package gerealuguer;

import java.io.Serializable;
import java.util.Objects;

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
     */
    public boolean aluga(int dataOut) {
        boolean sucesso = false;
        if(!alugado) {
            alugado = true;
            dataSaida = dataOut;
            dataEntrada = noDias = 0;
            System.out.println(matricula + " Foi Alugado");
            sucesso = true;
        }
        else
            System.out.println(matricula + " Está Alugado");
        return sucesso;
    }
    
    /**
     * Devolve o veículo alugado e estabelece a data da devolução
     * @param dataIn Data da devolução
     * @return true em caso de sucesso e 
     *         false caso não esteja alugado ou data inválida
     */
    public boolean devolve(int dataIn) {
        boolean sucesso = false;
        if(alugado) {
            if(dataIn > dataSaida) {
                alugado = false;
                dataEntrada = dataIn;
                noDias = dataEntrada - dataSaida;
                System.out.println(matricula + " foi devolvido. " + 
                        noDias + " dias alugado.");
                sucesso = true;
            } else {
                System.out.println("Data de entrada inválida para " + matricula);
            }
        } else {
            System.out.println(matricula + " não estava alugado.");
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
        return matricula + " - Estado:" + (alugado?"Alugado":"Livre");
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
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }
    
    
}
