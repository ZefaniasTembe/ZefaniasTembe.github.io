package bigsoftwareschool;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Zefanias Tembe
 */
public class ModelTabelaEstudante extends AbstractTableModel {

    private ArrayList<Estudante> lista = new ArrayList<>();
    private String[] colunas = {"CÓDIGO", "NOME", "GÉNERO","NOTA 1 ", "NOTA 2 ", "MÉDIA", "SITUAÇÃO"};
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int col) {
        return colunas[col];
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public Object getValueAt(int linha, int col) {
        switch(col){
            case 0: return lista.get(linha).getCodigo();
            case 1: return lista.get(linha).getNome();
            case 2: return lista.get(linha).getGenero();
            case 3: return lista.get(linha).getNota_1();
            case 4: return lista.get(linha).getNota_2();
            case 5: return lista.get(linha).getMedia();
            case 6: return lista.get(linha).getSituacao();
        }
        return null;
    }
}
