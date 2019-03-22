/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerealuguer;

import erros.*;

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
        try{ m = "12-FG-34"; c = 23.5F; armazem.novoVeiculo(new Veiculo(m,c));
         } catch(MatriculaExistenteException e){ System.out.println(e.getMessage()); }
        try{ m = "75-TR-78"; c = 15.7F; armazem.novoVeiculo(new Veiculo(m,c));
        } catch(MatriculaExistenteException e){ System.out.println(e.getMessage()); }
        try{ m = "56-KE-60"; c = 25.7F; armazem.novoVeiculo(new Veiculo(m,c));
        } catch(MatriculaExistenteException e){ System.out.println(e.getMessage()); }
        try{ m = "75-TR-78"; c = 15.7F; armazem.novoVeiculo(new Veiculo(m,c));
        } catch(MatriculaExistenteException e){ System.out.println(e.getMessage()); }
        try{ m = "78-TL-85"; c = 16.7F; armazem.novoVeiculo(new Veiculo(m,c));
        } catch(MatriculaExistenteException e){ System.out.println(e.getMessage()); }
        try{ m = "87-TL-58"; c = 16.7F; armazem.novoVeiculo(new Veiculo(m,c));            
        } catch(MatriculaExistenteException e){ System.out.println(e.getMessage()); }
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
