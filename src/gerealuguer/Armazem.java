/*
 * Teste de 18.Jan.2018
 */
package gerealuguer;

import erros.*;
import java.io.*;
import java.util.*;

/**
 * Classe Aramazém - serve para gerir veículos de aluguer
 * Contém um array de veículos com a dimensão correspondente ao nº máximo de veículos
 * @author Romero
 */ 
public class Armazem implements Serializable {
    private Set<Veiculo> veiculos;
    private final int maxVeiculos;
    
    /**
     * Construtor - Cria o array de veículos com a dimensão máxima de veículos 
     * que o armazém pode conter
     * @param maxV No máximo de veículos no armazém
     */
    public Armazem(int maxV){
        veiculos = new HashSet<>();
        maxVeiculos = maxV;
    }
    
    /**
     * Construtor - Cria o array de veículos com uma dimensão máxima de veículos 
     * que o armazém pode conter por defeito. Esta dimensão é de 10 veículos.
     */
    public Armazem(){
        this(10);
    }

    /**
     * Método para obter um veículo através da sua matrícula
     * @param m matricula do veículo
     * @return Rereferencia do objecto encontrado ou null se não encontrado
     */
    public Veiculo getVeiculo(String m){
        String mt;
        for(Veiculo v: veiculos){
            mt = v.getMatricula();
            if(mt.compareTo(m) == 0) 
                return v;
        }
        return null;
    }
    
    /**
     * Insere um novo veículo no armazém
     * @param m Matricula do novo vículo
     * @param c Custo diário do aluguer do veículo
     * @throws MatriculaExistenteException Matricula já existe.
     */
    public void novoVeiculo(String m, float c) throws MatriculaExistenteException {
        if(maxVeiculos>=veiculos.size()) {
            if(m.length() == 8 && getVeiculo(m)==null) {
                veiculos.add(new Veiculo(m,c));
            } else
                throw new MatriculaExistenteException(m);
        }
    }
    
    /**
     * Insere um novo veículo no armazém
     * @param v O novo vículo
     * @throws MatriculaExistenteException Matricula já existe.
     */
    public void novoVeiculo(Veiculo v){
        if(maxVeiculos>=veiculos.size()) {
            if(!veiculos.contains(v))
                veiculos.add(v); 
            else 
                throw new MatriculaExistenteException(v.getMatricula());
        }
    }
    
    /**
     * Remove um veículo do armazém
     * @param m Matricula do veículo
     * @throws MatriculaInexistenteException Matricula não existe.
     */
    public void removeVeiculo(String m) throws MatriculaInexistenteException {
        Veiculo v = getVeiculo(m);
        if(v != null && veiculos.contains(v))
            veiculos.remove(v);
        else
            throw new MatriculaInexistenteException(m);
    }
    
    /**
     * Aluga um veículo existente no armazém
     * @param m Matricula do veículo
     * @param dataOut Data do inicio do aluguer
     * @throws VeiculoAlugadoException Veículo está alugado e indisponível.
     * @throws MatriculaInexistenteException Matricula não existe.
     */
    public void alugaVeiculo(String m, int dataOut) throws VeiculoAlugadoException, MatriculaInexistenteException {
        Veiculo v = getVeiculo(m);
        if(v!=null)
            v.aluga(dataOut);
        else
            throw new MatriculaInexistenteException(m);
    }
    
    /**
     * Devolução dum veículo alugado
     * @param m Matricula do veículo
     * @param dataIn Data de entrada do veículo alugado
     * @return Custo do aluguer
     * @throws VeiculoNaoAlugadoException O veiculo não está alugado
     * @throws DataInvalidaException A data de devolução é inválida
     * @throws MatriculaInexistenteException A matricula nã existe.
     */
    public float recebeVeiculo(String m, int dataIn) throws VeiculoNaoAlugadoException, DataInvalidaException, MatriculaInexistenteException {
        Veiculo v = getVeiculo(m);
        if(v!=null) {
            if(v.devolve(dataIn))
                return v.custo();
        }
        else
            throw new MatriculaInexistenteException(m);
        return 0F;
    }
    
    /**
     * Método para obter o nº de veículos alugados
     * @return o nº de veículos alugados
     */
    public int noVeiculosAlugados(){
        int ct = 0;
        for(Veiculo v:veiculos){
            if(v.getAlugado())
                ct++;
        }
        return ct;
    }
    
    /**
     * Lista todos o veículos existentes no armazém
     */
    public void listVeiculos(){
        System.out.println("Veiculos --------------------------");
        for(Veiculo v:veiculos){
            System.out.println(v); 
        }
        System.out.println("-----------------------------------");
    }

    /**
     * Lista todos o veículos existentes no armazém
     * @param out Stream de saída
     */
    public void listVeiculos(PrintWriter out){
        out.println("Veiculos --------------------------");
        for(Veiculo v:veiculos){
            out.println(v); 
        }
        out.println("-----------------------------------");
    }

    /**
     * Lista todos os veículos livres (não alugados) no armazém
     */
    public void listVeiculosLivres(){
        System.out.println("Veiculos Livres -------------------");
        for(Veiculo v:veiculos){
            if(!v.getAlugado())
                System.out.println(v); 
        }
        System.out.println("-----------------------------------");
    }

    /**
     * Lista todos os veículos livres (não alugados) no armazém
     * @param out Stream de saída
     */
    public void listVeiculosLivres(PrintWriter out){
        out.println("Veiculos Livres -------------------");
        for(Veiculo v:veiculos){
            if(!v.getAlugado())
                out.println(v); 
        }
        out.println("-----------------------------------");
    }

    /**
     * Lista todos os veículos alugados do armazém
     */
    public void listVeiculosAlugados(){
        System.out.println("Veiculos Alugados -----------------");
        for(Veiculo v:veiculos){
            if(v.getAlugado())
                System.out.println(v); 
        }
        System.out.println("-----------------------------------");
    }

    /**
     * Lista todos os veículos alugados do armazém
     * @param out Stream de saída
     * @throws IOException Na escrita no ficheiro
     */
    public void listVeiculosAlugados(BufferedWriter out) throws IOException {
        out.write("Veiculos Alugados -----------------\n");
        for(Veiculo v:veiculos){
            if(v.getAlugado())
                out.write(v.toString() + "\n"); 
        }
        out.write("-----------------------------------\n");
    }
}
