package bigsoftwareschool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Zefanias Tembe
 */
public class Arquivos {
    // Metodo de gravacao de dados, recebe a lista que contem os dados e a caminho do espaco a ser ocupado
    public static void escrever(ArrayList<Object> lista, String caminho){
        
        File arquivo = new File(caminho);
        try {
            if (!arquivo.exists()){
                arquivo.mkdirs();
            }
            // apaga o arquivo antigo
            arquivo.delete();
            // cria um novo arquivo
            arquivo.createNewFile();
            
            // escreve os novos dados no arquivo...
            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(arquivo));
            escritor.writeObject(lista);
            escritor.close();
        } catch (Exception e) {
            System.out.println("Ocorreu uma exepcao: "+e);
        }
        
    }
    
    // Metodo de leitura de dados a partir do arquivo, recebe o caminho do arquivo
    public static ArrayList<Object> ler(String caminho){
        ArrayList<Object> lista = new ArrayList<>();
        try {
            File arquivo = new File(caminho);
            
            if (arquivo.exists() == true) {
                ObjectInputStream leitor = new ObjectInputStream(new FileInputStream(arquivo));
                lista = (ArrayList<Object>)leitor.readObject();
            }
            
        } catch (Exception e) {
            System.out.println("Erro encontrado: "+e);
        }
        return(lista);
    }
    
    /**
     * @param nomePorApagar recebe a referencia do produto a ser removido
     */
    public static void remover(String nomePorApagar, String caminho) {
        
        try {
            // Leitura dos dados guardados no arquivo
            ArrayList<Object> lista = ler(caminho);

            // remove o objecto informado
            for (Object produtoArquivado : lista) {
                Estudante p = (Estudante) produtoArquivado;
                if (p.getNome().equalsIgnoreCase(nomePorApagar)) {
                    lista.remove(p);
                    break;
                }
            }
            // adiciona a lista com os novos dados
            escrever(lista, caminho);
            
        } catch (Exception e) {
        }
    }
    
    public static void editar(Estudante temp, String nomeAnterior, String caminho) {
           
        try {
            // Leitura dos dados guardados no arquivo
            ArrayList<Object> lista = ler(caminho);
            // Modificando os dados no arquivo
            for (int i =0; i<lista.size();i++) {
                Estudante p = (Estudante) lista.get(i);
                if (nomeAnterior.equalsIgnoreCase(p.getNome())) {
                    // Funcao que determina o que sera alterado
                    lista.remove(i);
                    lista.add(i, temp);
                    break;
                } 
            }
            // adiciona a lista com os novos dados
            escrever(lista, caminho);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao encontrado");
        }
    }
    
    public static ArrayList<Estudante> filtrar(String situacao, String caminho) {
        ArrayList<Estudante> filtrados = null;   
        try {
            // Leitura dos dados guardados no arquivo
            ArrayList<Object> lista = ler(caminho);
            
            // Modificando os dados no arquivo
            for (int i =0; i<lista.size();i++) {
                Estudante p = (Estudante) lista.get(i);
                if (situacao.equalsIgnoreCase(p.getSituacao())) {
                    filtrados.add(p);
                } 
            }
            // adiciona a lista com os novos dados
            escrever(lista, caminho);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao encontrado");
        }
        
        return filtrados;
    }
    
    
}

