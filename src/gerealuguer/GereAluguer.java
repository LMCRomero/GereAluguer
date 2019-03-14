/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerealuguer;

/**
* <h2>Gestão de Aluguer de Viaturas.</h2>
 * Classe de teste do sistema. 
 * <p>
 * 
 * Apenas contém o método main.
 * Testa algumas características do sistema como aluguer, receção, e outros.
 * </p>
 * <b>Note:</b> Comentar devidamente o código torna-o mais amigável e faz com que seja de alta qualidade.
 * 
 * @author LuisRomero
 * @version 1.0
 * @since   2019-02-10 
 */
public class GereAluguer {

    /**
     * Cria vários veiculos para efeitos de teste e insere-os no armazém.<p>
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Armazem a = new Armazem(10);
        String m = "12-FG-34";
        float c = 23.5F;
        float p=0F;
        
//        m = "12-FG-34"; c = 23.5F; a.novoVeiculo(m, c);
//        m = "75-TR-78"; c = 15.7F; a.novoVeiculo(m, c);
//        m = "56-KE-60"; c = 25.7F; a.novoVeiculo(m, c);
//        m = "75-TR-78"; c = 15.7F; a.novoVeiculo(m, c);
//        m = "78-TL-85"; c = 16.7F; a.novoVeiculo(m, c);
//        m = "87-TL-58"; c = 16.7F; a.novoVeiculo(m, c);

        m = "12-FG-34"; c = 23.5F; a.novoVeiculo(new Veiculo(m,c));
        m = "75-TR-78"; c = 15.7F; a.novoVeiculo(new Veiculo(m,c));
        m = "56-KE-60"; c = 25.7F; a.novoVeiculo(new Veiculo(m,c));
        m = "75-TR-78"; c = 15.7F; a.novoVeiculo(new Veiculo(m,c));
        m = "78-TL-85"; c = 16.7F; a.novoVeiculo(new Veiculo(m,c));
        m = "87-TL-58"; c = 16.7F; a.novoVeiculo(new Veiculo(m,c));
        a.listVeiculos();

        a.alugaVeiculo("12-FG-34", 180112);
        a.alugaVeiculo("56-KE-60", 180113);
        a.alugaVeiculo("12-FG-34", 180112);
        a.listVeiculosLivres();
        a.alugaVeiculo("78-TL-85", 180115);

        p = a.recebeVeiculo("12-FG-34", 180114);
        System.out.println("Preço = " + p);
        a.listVeiculos();
        p = a.recebeVeiculo("56-KE-60", 180122);
        System.out.println("Preço = " + p);
        p = a.recebeVeiculo("78-TL-85", 180222);
        System.out.println("Preço = " + p);
    }
    
}
