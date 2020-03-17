/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrancada.Main;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.Timer;

/**
 *Classe que exibe uma tela de Splash para a inicialização do Software arrancada.
 * Última Alteração em 6/01/2008
 * @author Bessa
 */
public class Splash extends JWindow {

    
    /**
     * Cronstructor da classe Splash que monta a tela, com um default de 5 segundos.
     */
public Splash()
{
     // montando a tela
     Container tela =  getContentPane();
     tela.setLayout(new BorderLayout());
    // pegando a imagem que está dentro do pacote
     ImageIcon imagem = new ImageIcon(getClass().getResource("/arrancada.Imagens/Velozes%20principal.jpg"));
     JLabel label = new JLabel(imagem);
     
     // Criando label com texto a ser exibido durante o splash
     JLabel labelTextoSplash = new JLabel();
     labelTextoSplash.setFont(new Font("Tahoma", 3, 36));
     labelTextoSplash.setText("Carregando.............");
     
     // Add os label's na tela de acordo como gerenciador de layout
     tela.add(label,BorderLayout.CENTER);    
     tela.add(labelTextoSplash,BorderLayout.SOUTH);
  
    // Evento que esconde, e fecha a tela e por fim inicia o Arrancada.
     ActionListener fechar = new ActionListener(){
    public void actionPerformed(ActionEvent e){
    setVisible(false);
    dispose();

}};


// Crio um timer, passando em seu constructor o tempo, e o evento que ele deve executar;
Timer timer = new Timer(8000,fechar);

// Disparo o timer
timer.start();

//Redimensionando a tela de acordo com a imagem e setando a localização no centro da tela.
pack();
setLocationRelativeTo(null);

}

}// fim da classe
