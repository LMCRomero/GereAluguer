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
public class MatriculaExistenteException extends RuntimeException {

    public MatriculaExistenteException(String matricula) {
        super("A Matrícula " + matricula + " já existe no armazém!");
    }
    
}
