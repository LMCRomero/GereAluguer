/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erros;

/**
 *
 * @author LuisRomero
 */
public class VeiculoAlugadoException extends RuntimeException {

    public VeiculoAlugadoException(String matricula) {
        super("Veiculo " + matricula + " está alugado!");
    }
    
}
