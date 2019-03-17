/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerealuguer;

/**
 *
 * @author LuisRomero
 */
public class MainApp {
    
    public static void iniciaEstado(GereAluguer ga){
        Armazem armazem = ga.getArmazem();
        String m;
        float c;
        float p;
        
        m = "12-FG-34"; c = 23.5F; armazem.novoVeiculo(new Veiculo(m,c));
        m = "75-TR-78"; c = 15.7F; armazem.novoVeiculo(new Veiculo(m,c));
        m = "56-KE-60"; c = 25.7F; armazem.novoVeiculo(new Veiculo(m,c));
        m = "75-TR-78"; c = 15.7F; armazem.novoVeiculo(new Veiculo(m,c));
        m = "78-TL-85"; c = 16.7F; armazem.novoVeiculo(new Veiculo(m,c));
        m = "87-TL-58"; c = 16.7F; armazem.novoVeiculo(new Veiculo(m,c));

//        armazem.alugaVeiculo("12-FG-34", 180112);
//        armazem.alugaVeiculo("56-KE-60", 180113);
//        armazem.alugaVeiculo("12-FG-34", 180112);
//        armazem.alugaVeiculo("78-TL-85", 180115);

//        p = armazem.recebeVeiculo("12-FG-34", 180114);
//        p = armazem.recebeVeiculo("56-KE-60", 180122);
//        p = armazem.recebeVeiculo("78-TL-85", 180222);
    }
    
    /**
     * Cria vários veiculos para efeitos de teste e insere-os no armazém.<p>
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GereAluguer ga = new GereAluguer();
        
        iniciaEstado(ga);
        ga.menu_Principal();
    }
}
