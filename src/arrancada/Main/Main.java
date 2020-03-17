/*
 * Main.java
 * 
 * Iniciado em  14/08/2007, 08:12:13
 * Este software busca atender a solicitação de um controle informatizado para a realização de 
 * controle e monitoramento de disputas de Arrancadas de carros e motos.
 * Implementadores : André Bessa,Filipe Rangel,Vitor Rodrigues e Wesley Breda
 */

package arrancada.Main;

import arrancada.Formularios.Principal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author monitor
 */
public class Main {

    /**
     *Método Principal do projeto Arrancada
     */
    public static void main(String[] args) {
        try 
        {
            // Garbage Collection "Limpa" as referências nao utilizadas na memoria e cria as novas instancias do programa.
            System.gc();
            // Chamando o Splash que em 8 segundos se auto-destruira
            new Splash().setVisible(true);
           //startanto o serviço do postgree
            Runtime.getRuntime().exec("C:\\WINDOWS\\system32\\net.exe  start pgsql-8.1" );
            // Chamando o arrancada
            new Principal().setVisible(true);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

}
