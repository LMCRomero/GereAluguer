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
public class MatriculaInexistenteException extends RuntimeException {

    public MatriculaInexistenteException(String matricula) {
        super("A " + matricula + " não existe!");
    }
    
}
