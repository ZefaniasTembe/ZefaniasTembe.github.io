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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class RegistarEstudante extends JFrame{
    private JPanel painelGerirEstudantes = new JPanel(new GridBagLayout());
    private JPanel centro                = new JPanel(new GridLayout(2,1));
    
    private String nome;
    public static final String caminhoEstudantes ="C:\\Vendas\\Estudantes.dat";
    
    // Campos de testo
    private JTextField campNome   = new JTextField();
    private JTextField campNota1  = new JTextField();
    private JTextField campNota2  = new JTextField();
    private JTextField campCodigo = new JTextField();
    private JTextField campNivel  = new JTextField();
    private JTextField campGenero  = new JTextField(); // mudar para JComboBox
    
    // Criando uma forma de visualizar atraves da Tabela
    private String [] genero     = {"Masculino", "Feminino"} ;
    //private JComboBox campGenero = new JComboBox(genero);
    
    private String[] topEstudantes  = {"CÓDIGO", "NOME", "GÉNERO","NOTA 1 ", "NOTA 2 ", "MÉDIA", "SITUAÇÃO"};
    private JTable tabelaEstudantes = new JTable(new DefaultTableModel(topEstudantes, ABORT));
    private ArrayList<Object> listaEstudantes = new ArrayList<>();
    private ArrayList<Estudante> listaFiltro = new ArrayList<>();
    
    private JScrollPane verEstudantes = new JScrollPane(tabelaEstudantes);
    
    // Criando botoes 
    private JPanel  painelBotoes = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JButton btnGuardar  = new JButton("Guardar");
    private JButton btnRemover  = new JButton("Remover");
    private JButton btnEditar   = new JButton("Editar");
    private JButton btnCancelar = new JButton("Cancelar");
    
    
    // Botoes para mudanca de painel 
    private JPanel  painelMenu            = new JPanel(new GridLayout(9,1));
    private JButton btnVoltar = new JButton("Voltar ao Menu ");
    
    private JButton btnModaMedia = new JButton("Moda & Media ");
    private JButton btnFiltrarDispensados = new JButton("Dispensados ");
    private JButton btnFiltrarExcluidos   = new JButton("Excluidos ");
    private JButton btnFiltrarAdmitidos   = new JButton("Admitidos ");
    
    public RegistarEstudante(){
        lerTabelaEstudantes();
        setTitle(" BigSoftwareSchoolSystem ");
        setLayout(new BorderLayout());
        accoesDosBotoes();
        botoesMenu();
        gerirEstudantes();
        
        // Configuracoes Finais da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,500);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    // Manipulando o painel Que ficara no centro do Frame
    public void gerirEstudantes(){
        // adiciona os botoes
        painelBotoes.add(btnGuardar);
        painelBotoes.add(btnRemover);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnCancelar);
        
        // Adiciona os componentes ao painel responsavel pela entrada dos dados dos estudantes
        add("Nome", campNome, painelGerirEstudantes);
        add("Genero", campGenero,"Código ", campCodigo, painelGerirEstudantes);
        add("1ª Nota", campNota1,"2ª Nota", campNota2, painelGerirEstudantes);
        add("", painelBotoes, painelGerirEstudantes);
        
        centro.add(painelGerirEstudantes);
        centro.add(verEstudantes);
        add(centro,BorderLayout.CENTER);
    }
    
    public  void botoesMenu() {
        
        btnModaMedia.setBackground(new java.awt.Color(30,100,170));
        btnModaMedia.setForeground(new java.awt.Color(255,255,255));
        
        btnVoltar.setBackground(new java.awt.Color(255,100,20));
        btnVoltar.setForeground(new java.awt.Color(255,255,255));
        
        btnFiltrarExcluidos.setBackground(new java.awt.Color(0,100,204));
        btnFiltrarExcluidos.setForeground(new java.awt.Color(255,255,255));
        btnFiltrarAdmitidos.setBackground(new java.awt.Color(90,204,84));
        btnFiltrarAdmitidos.setForeground(new java.awt.Color(255,255,255));
        btnFiltrarDispensados.setBackground(new java.awt.Color(50,84,114));
        btnFiltrarDispensados.setForeground(new java.awt.Color(255,255,255));
        
        
        painelMenu.add(btnVoltar);
        painelMenu.add(new JLabel());
        painelMenu.add(btnModaMedia);
        painelMenu.add(new JLabel());
        painelMenu.add(btnFiltrarExcluidos);
        painelMenu.add(new JLabel());
        painelMenu.add(btnFiltrarAdmitidos);
        painelMenu.add(new JLabel());
        painelMenu.add(btnFiltrarDispensados);
        add(painelMenu, BorderLayout.WEST);
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
        // Ouvinte da tabela, retorna a linha seleccionada 
        tabelaEstudantes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e); 
                // Passando o conteudo da linha seleccionada para o campo de edicao
                campCodigo.setText(tabelaEstudantes.getValueAt(tabelaEstudantes.getSelectedRow(), 0).toString());
                campNome.setText(  tabelaEstudantes.getValueAt(tabelaEstudantes.getSelectedRow(), 1).toString());
                campGenero.setText(tabelaEstudantes.getValueAt(tabelaEstudantes.getSelectedRow(), 2).toString()); 
                campNota1.setText( tabelaEstudantes.getValueAt(tabelaEstudantes.getSelectedRow(), 3).toString()); 
                campNota2.setText( tabelaEstudantes.getValueAt(tabelaEstudantes.getSelectedRow(), 4).toString()); 
                nome = tabelaEstudantes.getValueAt(tabelaEstudantes.getSelectedRow(), 1).toString();
            }
        });
        
        btnGuardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = campNome.getText();
                    char gen = campGenero.getText().charAt(0);
                    int   codigo = Integer.parseInt(campCodigo.getText());
                    double nota_1 = Double.parseDouble(campNota1.getText());
                    double nota_2 = Double.parseDouble(campNota2.getText());
                     
                    if (( campCodigo != null)&&(nome != null)&&(campGenero != null) ) {
                        Estudante estudante = new Estudante(nome,gen, codigo, nota_1, nota_2);
                        listaEstudantes.add(estudante);
                        Arquivos.escrever(listaEstudantes, caminhoEstudantes);
                    }else{
                        JOptionPane.showMessageDialog(null, "Preenchimento obrigatorio");
                    }
                    limpar(); 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, " Formato não suportado, \n Verifique os numeros");
                }
                lerTabelaEstudantes();
                limpar();
            }
        });
        
        btnModaMedia.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                lerTabelaModa();
            }
        });
        btnFiltrarAdmitidos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                lerTabelaEstudantes("Admitido");
            }
        });
        btnFiltrarAdmitidos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                lerTabelaEstudantes("Admitido");
            }
        });
        btnFiltrarDispensados.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                
                lerTabelaEstudantes("Dispensado");
            }
        });
        btnFiltrarExcluidos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                
                
                lerTabelaEstudantes("Excluido");
            }
        });
        btnVoltar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                dispose();
                Menu menu = new Menu();
                
            }
        });
    }
    
    public void lerTabelaEstudantes(){
        DefaultTableModel modelo=(DefaultTableModel) tabelaEstudantes.getModel();
        initLista();
        modelo.setNumRows(0);
        for (Object  item : listaEstudantes) {
            Estudante est = (Estudante)item;
            modelo.addRow(new Object[]{ est.getCodigo(), 
                                        est.getNome(), 
                                        est.getGenero(),
                                        est.getNota_1(),
                                        est.getNota_2(),
                                        est.getMedia(), 
                                        est.getSituacao()});
        }
    }
    
    public void lerTabelaEstudantes(String situacao){
        DefaultTableModel modelo=(DefaultTableModel) tabelaEstudantes.getModel();
        initLista();
        modelo.setNumRows(0);
        for (Object  item : listaEstudantes) {
            Estudante est = (Estudante)item;
            if(! est.getSituacao().equalsIgnoreCase(situacao)) continue;
            modelo.addRow(new Object[]{ est.getCodigo(), 
                                        est.getNome(), 
                                        est.getGenero(),
                                        est.getNota_1(),
                                        est.getNota_2(),
                                        est.getMedia(), 
                                        est.getSituacao()});
        }
    }
    public void lerTabelaModa(){
        double media = 0.0;
        double vet[] = new double[listaEstudantes.size()];
        int divisor = 0;
        
        
        DefaultTableModel modelo=(DefaultTableModel) tabelaEstudantes.getModel();
        initLista();
        modelo.setNumRows(0);
        for (Object  item : listaEstudantes) {
            
            Estudante est = (Estudante)item;
            modelo.addRow(new Object[]{ est.getCodigo(), 
                                        est.getNome(), 
                                        est.getGenero(),
                                        est.getNota_1(),
                                        est.getNota_2(),
                                        est.getMedia(), 
                                        est.getSituacao()});
            media += est.getMedia();
            vet[divisor] = est.getMedia();
            divisor++;
        }
        
        double mod = moda(vet);
        JOptionPane.showMessageDialog(null, "Nota Media Geral: "+(media/divisor)+" \n MODA:  "+ mod);
    }
    
    
    public void limpar(){
        campCodigo.setText("");
        campNome.setText("");
        campGenero.setText("");
        campNota1.setText(""); 
        campNota2.setText(""); 
        campNivel.setText(""); 
    }
    
    public double moda( double vet[]) {
        int tamanho= listaEstudantes.size();
        int[] cont = new int[tamanho];
        int vezes = 0;
        int indice = 0;
        for (int i=0; i < (tamanho); i++) {
            for (int j=0;j < (tamanho); j++) {
                if(vet[i] == vet[j]) {
                    cont[i] = cont[i] + 1;
                }
            }
        }
        vezes = cont[0];
        for (int i=0; i < cont.length; i++) {
            if (cont[i] > vezes) {
                vezes = cont[i];
                indice = i;
            }
        }
        return vet[indice];
    }
    
    public void initLista() {
        listaEstudantes = Arquivos.ler(caminhoEstudantes);
        
    }
    
    
}
