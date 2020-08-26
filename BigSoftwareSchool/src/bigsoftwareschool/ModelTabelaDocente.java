package bigsoftwareschool;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tembe
 */
public class ModelTabelaDocente extends AbstractTableModel {

    private ArrayList<Docente> lista = new ArrayList<>();
    private String[] colunas = {"CÓDIGO", "NOME", "GÉNERO","NÍVEL "};
    
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
            case 3: return lista.get(linha).getNivelAcademico();
        }
        return null;
    }
}