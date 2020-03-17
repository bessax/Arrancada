/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrancada.Exceptions;

/**
 * Classe para tratar as Exception que podem a surgir em todo o programa
 * @author Bessa
 */
public class MyException extends Exception {
    
    	public MyException() {
		
	}

    public MyException(String string) {
        super(string);
    }
    

}
