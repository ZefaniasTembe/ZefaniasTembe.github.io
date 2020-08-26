/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigsoftwareschool;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.ABORT;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zefanias Tembe
 */
public class RegistarDocente extends JFrame {
    private JPanel painelGerirDocentes   = new JPanel(new GridBagLayout());
    private JPanel centro                = new JPanel(new GridLayout(2,1));
    
    private String nome;
    public static final String caminhoDocentes   ="C:\\Vendas\\Docentes.dat";
    
    
    // Campos de testo
    private JTextField campNome   = new JTextField();
    private JTextField campCodigo = new JTextField();
    private JTextField campNivel  = new JTextField();
    private JTextField campGenero  = new JTextField(); // mudar para JComboBox
    
    // Criando uma forma de visualizar atraves da Tabela
    private String [] genero     = {"Masculino", "Feminino"} ;
    //private JComboBox campGenero = new JComboBox(genero);
    
    private String[] topDocentes    = {"CÓDIGO", "NOME", "GÉNERO","NÍVEL "};
    private JTable tabelaDocentes   = new JTable(new DefaultTableModel(topDocentes, ABORT));
    private ArrayList<Object> listaDocentes = new ArrayList<>();
    
    private JScrollPane verDocentes   = new JScrollPane(tabelaDocentes);
    
    // Criando botoes 
    private JPanel  painelBotoes = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    // Funcionalidades para docentes
    private JButton btnGuardar  = new JButton("Guardar");
    private JButton btnRemover  = new JButton("Remover");
    private JButton btnEditar   = new JButton("Editar");
    private JButton btnCancelar = new JButton("Voltar ao Menu");
    
    // Botoes para mudanca de painel 
    private JPanel  painelMenu            = new JPanel(new GridLayout(6,1));
    private JButton btnRegistoDocentes   = new JButton("R. Docentes");
    private JButton btnVerDocentes       = new JButton("Ver Docentes");
    
    
    public RegistarDocente(){
        
        lerTabelaDocentes();
        setTitle(" BigSoftwareSchoolSystem");
        setLayout(new BorderLayout());
        accoesDosBotoes();
        gerirDocentes();
        
        // Configuracoes Finais da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,500);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    // Manipulando o painel Que ficara no centro do Frame
    public void gerirDocentes(){
        painelBotoes.add(btnGuardar);
        painelBotoes.add(btnRemover);
        painelBotoes.add(btnEditar);
        
        btnCancelar.setBackground(new java.awt.Color(255,100,20));
        btnCancelar.setForeground(new java.awt.Color(255,255,255));
        painelBotoes.add(btnCancelar);
        add("Nome", campNome, "Código ", campCodigo, painelGerirDocentes);
        add("Genero", campGenero,"N. Académico", campNivel, painelGerirDocentes);
        add("", painelBotoes, painelGerirDocentes);
        
        centro.add(painelGerirDocentes);
        centro.add(verDocentes);
        add(centro,BorderLayout.CENTER);
    }
    
    public void add(String label, JComponent componente, JPanel painel) {
        GridBagConstraints cons = new GridBagConstraints();
        
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.NORTHWEST;
        cons.insets = new Insets(4, 4, 4, 4);
        cons.weightx = 0;
        cons.gridwidth = 1;
        painel.add(new JLabel(label), cons);

        cons.fill = GridBagConstraints.BOTH;
        cons.weightx = 1;
        cons.gridwidth = GridBagConstraints.REMAINDER;
        painel.add(componente, cons);
    }
    
    public void add(String label, JComponent componente, String label2, JComponent componente2, JPanel painel) {

        GridBagConstraints cons = new GridBagConstraints();
        cons.fill = GridBagConstraints.BOTH;
        cons.insets = new Insets(4, 4, 4, 4);
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.NORTHWEST;
        cons.weightx = 0;
        cons.gridwidth = 1;
        painel.add(new JLabel(label), cons);

        cons.weightx = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.BOTH;
        painel.add(componente, cons);
        
        cons.fill = GridBagConstraints.NONE;
        cons.weightx = 0;
        cons.gridwidth = 1;
        painel.add(new JLabel(label2), cons);

        cons.weightx = 1;
        cons.fill = GridBagConstraints.BOTH;
        cons.gridwidth = GridBagConstraints.REMAINDER;
        painel.add(componente2, cons);
    }
    
    public void accoesDosBotoes() {
        tabelaDocentes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e); 
                // Passando o conteudo da linha seleccionada para o campo de edicao
                campCodigo.setText(tabelaDocentes.getValueAt(tabelaDocentes.getSelectedRow(), 0).toString());
                campNome.setText(  tabelaDocentes.getValueAt(tabelaDocentes.getSelectedRow(), 1).toString());
                campGenero.setText(tabelaDocentes.getValueAt(tabelaDocentes.getSelectedRow(), 2).toString()); 
                campNivel.setText( tabelaDocentes.getValueAt(tabelaDocentes.getSelectedRow(), 3).toString()); 
                
                nome = tabelaDocentes.getValueAt(tabelaDocentes.getSelectedRow(), 1).toString();
            }
        });
        
        btnGuardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // 
                try {
                    String nome = campNome.getText();
                    char gen = campGenero.getText().charAt(0);
                    int   codigo = Integer.parseInt(campCodigo.getText());
                    String nivel = campNivel.getText();
                    
                    if (( campCodigo != null)&&(nome != null)&&(campGenero != null) ) {
                        listaDocentes.add(new Docente(nome,gen,nivel,codigo));
                        Arquivos.escrever(listaDocentes, caminhoDocentes);
                    }else{
                        JOptionPane.showMessageDialog(null, "Preenchimento obrigatorio");
                    }
                    limpar(); 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, " Formato não suportado, \n Verifique os numeros");
                }
                lerTabelaDocentes();
                limpar();
            }
        });
        btnCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                dispose();
                Menu menu = new Menu();
                
            }
        });
        
    }
    
    public void lerTabelaDocentes(){
        DefaultTableModel modelo=(DefaultTableModel) tabelaDocentes.getModel();
        initLista();
        modelo.setNumRows(0);
        for (Object  item : listaDocentes) {
            Docente d = (Docente)item;
            modelo.addRow(new Object[]{ d.getCodigo(), 
                                        d.getNome(), 
                                        d.getGenero(),
                                        d.getNivelAcademico()});
        }
    }
    
    public void limpar(){
        campCodigo.setText("");
        campNome.setText("");
        campGenero.setText("");
        campNivel.setText(""); 
    }
    
    public void initLista() {
        listaDocentes = Arquivos.ler(caminhoDocentes);
    }
    
}
