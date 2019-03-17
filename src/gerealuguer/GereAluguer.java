/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerealuguer;

import comum.Le;

/**
* <h2>Gestão de Aluguer de Viaturas.</h2>
 * Classe de Menus do sistema. 
 * <p>
 * 
 * Contém gestão de menus da aplicação.
 * </p>
 * <b>Note:</b> Comentar devidamente o código torna-o mais amigável e faz com que seja de alta qualidade.
 * 
 * @author LuisRomero
 * @version 1.0
 * @since   2019-02-10 
 */
public class GereAluguer {
    
    Armazem armazem;
    
    public GereAluguer(){
        armazem = new Armazem(10);        
    }

    public Armazem getArmazem() {
        return armazem;
    }
    
    private void inserirVeiculo(){
        String m;
        float c;
        System.out.print("Matricula (CC-CC-CC): "); m = Le.umaString();
        System.out.print("Preço por dia: "); c = Le.umFloat();
        armazem.novoVeiculo(m, c);
    }
    
    private void removerVeiculo(){
        String m;
        System.out.print("Matricula (CC-CC-CC): "); m = Le.umaString();
        armazem.removeVeiculo(m);
    }
    
    public void menu_Veiculos(){
        int op;
        do {
            System.out.println("> Veiculos ----------------<");
            System.out.println("\t 1 - Inserir");
            System.out.println("\t 2 - Remover");
            System.out.println("\t 3 - Listar todos");
            System.out.println("\t 4 - Listar Livres");
            System.out.println("\t 0 - Sair");
            System.out.print("opção: "); op = Le.umInt();
            switch(op){
                case 1: 
                    inserirVeiculo();
                    break;
                case 2: 
                    removerVeiculo();
                    break;
                case 3: 
                    armazem.listVeiculos();
                    break;
                case 4: 
                    armazem.listVeiculosLivres();
                    break;
            }            
        }while (op!=0);
    }
    
    private void alugaVeiculo(){
        String m;
        int dOut;
        armazem.listVeiculosLivres();
        System.out.print("Matricula (CC-CC-CC): "); m = Le.umaString();
        System.out.print("Dia inicial: "); dOut = Le.umInt();
        armazem.alugaVeiculo(m, dOut);
    }
    
    private void devolveVeiculo(){
        String m;
        int dIn;
        float p;
        armazem.listVeiculosAlugados();
        System.out.print("Matricula (CC-CC-CC): "); m = Le.umaString();
        System.out.print("Dia final: "); dIn = Le.umInt();
        p = armazem.recebeVeiculo(m, dIn);
        System.out.println("Custo do aluguer: " + p); 
    }
    
    public void menu_Alugueres(){
        int op;
        do {
            System.out.println("> Alugueres ----------------<");
            System.out.println("\t 1 - Alugar");
            System.out.println("\t 2 - Devolver");
            System.out.println("\t 0 - Sair");
            System.out.print("opção: "); op = Le.umInt();
            switch(op){
                case 1: 
                    alugaVeiculo();
                    break;
                case 2: 
                    devolveVeiculo();
                    break;
            }            
        }while (op!=0);
    }
    
    public void menu_Principal(){
        int op;
        do {
            System.out.println("> Principal ----------------<");
            System.out.println("\t 1 - Veiculos");
            System.out.println("\t 2 - Alugueres");
            System.out.println("\t 0 - Sair");
            System.out.print("opção: "); op = Le.umInt();
            switch(op){
                case 1: 
                    menu_Veiculos();
                    break;
                case 2: 
                    menu_Alugueres();
                    break;
                case 0: 
                    break;
            }            
        } while(op!=0);
    }
    
}
