/*
 * Cronometro.java
 * 
 * Created on 16/09/2007, 10:02:37
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrancada.Cronometro;

import arrancada.Exceptions.MyException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



/**
 *Classe Criada para a leitura de um arquivo TXT contendo os códigos e tempos dos competidores da última 
 *Puxada realizada.
 * Data última alteração: 4/01/2008 
 * @author Bessa
 */
public class Cronometro {
    
    public Cronometro()
    {
     //Constructor Vazio   
    }
    
    private String [] tempo= {null,null};
    private String path = "C:\\Arquivos de programas\\Arrancada\\Tempo\\tempo.txt";

    // Setters e Getters
    public void setPath(String path)
    {
       this.path=path; 
    }
    
       public String gettPath()
    {
      return this.path; 
    }
    
    
    
    /**
     * Método para ler TXT que retorna um vetor de String, este método retorna uma vetor de String contendo o piloto e o tempo de acordo com o seguinte layout:
     * piloto;tempo <p>
     * Ex: 1;350 <p>
     *     2;300 <p>
     * Em caso do arquivo não existir, ele retornarão o vetor contendo null, por�m se estiver vazio o arquivo ele deve retornar vazio para as duas posições do vertor;
     * <p>
     * Ao final da operação o arquivo é deletado.
     * @param não tem
     * @throws retornam exeções mais personalizadas tratadas nas classes do pacote arrancada.Exceptions
     */
    public String[] lerTXT() throws MyException
    {
        try {
            
            int i=0;
            
           
            File file = new File(path);
            //Criando um leitor de arquivo
            if(file.isFile())
            {
            FileReader reader = null;
            //Criando objeto para entra em modo leitura
            reader = new FileReader(file);
            //Criando objeto de Buffered de Leitura
            BufferedReader leitor = new BufferedReader(reader);
            String linha = null;          

            while ((linha = leitor.readLine()) != null)
            {           
                              
                tempo[i] = linha= (linha.replace("[","")).replaceFirst("]",";").replaceAll("]","").trim();                              
                i++;     
        
            }
            
            leitor.close();
            reader.close();
            file.delete();
            }else{
          
            
                return tempo;
            }
            }
        catch (IOException ex)
        {
            throw new MyException("Erro na leitura do arquivo - (Exception:"+ex.getMessage()+")");
        }
          catch (Exception ex)
        {
            throw new MyException("Erro Desconhecido - (Exception:"+ex.getMessage()+")");
        }
        
        
        return tempo;
    }
    
    
    }// Fim da classe


