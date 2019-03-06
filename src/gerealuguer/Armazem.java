/*
 * Teste de 18.Jan.2018
 */
package gerealuguer;

/**
 * Classe Aramazém - serve para gerir veículos de aluguer
 * Contém um array de veículos com a dimensão correspondente ao nº máximo de veículos
 * @author Romero
 */ 
public class Armazem {
    private Veiculo[] veiculos;
    private int noVeiculos;
    
    /**
     * Construtor - Cria o array de veículos com a dimensão máxima de veículos 
     * que o armazém pode conter
     * @param maxV No máximo de veículos no armazém
     */
    public Armazem(int maxV){
        veiculos = new Veiculo[maxV];
        noVeiculos = 0;
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
        Veiculo v = null;
        String mt;
        for(int i=0;i<noVeiculos && v == null; i++){
            mt = veiculos[i].getMatricula();
            if(mt.compareTo(m) == 0) 
                v = veiculos[i];
        }
        return v;
    }
    
    /**
     * Insere um novo veículo no armazém
     * @param m Matricula do novo vículo
     * @param c Custo diário do aluguer do veículo
     */
    public void novoVeiculo(String m, float c){
        if(noVeiculos<veiculos.length) {
            if(m.length() == 8 && getVeiculo(m)==null) {
                veiculos[noVeiculos] = new Veiculo(m,c);
                noVeiculos++;                
            }
        }
    }
    
    /**
     * Aluga um veículo existente no armazém
     * @param m Matricula do veículo
     * @param dataOut Data do inicio do aluguer
     */
    public void alugaVeiculo(String m, int dataOut) {
        Veiculo v = getVeiculo(m);
        if(v!=null)
            v.aluga(dataOut);
    }
    
    /**
     * Devolução dum veículo alugado
     * @param m Matricula do veículo
     * @param dataIn Data de entrada do veículo alugado
     * @return Custo do aluguer
     */
    public float recebeVeiculo(String m, int dataIn){
        Veiculo v = getVeiculo(m);
        if(v!=null) {
            if(v.devolve(dataIn))
                return v.custo();
        }
        return 0F;
    }
    
    /**
     * Método para obter o nº de veículos alugados
     * @return o nº de veículos alugados
     */
    public int noVeiculosAlugados(){
        int ct = 0;
        for(int i=0;i<noVeiculos;i++){
            if(veiculos[i].getAlugado())
                ct++;
        }
        return ct;
    }
    
    /**
     * Lista todos o veículos existentes no armazém
     */
    public void listVeiculos(){
        System.out.println("Veiculos -------------------------");
        for(int i=0; i<noVeiculos;i++){
            System.out.println(veiculos[i]); 
        }
        System.out.println("----------------------------------");
    }

    /**
     * Lista todos os veículos livres (não alugados) no armazém
     */
    public void listVeiculosLivres(){
        System.out.println("Veiculos Livres -------------------");
        for(int i=0; i<noVeiculos;i++){
            if(!veiculos[i].getAlugado())
                System.out.println(veiculos[i].getMatricula()); 
        }
        System.out.println("-----------------------------------");
    }
}
