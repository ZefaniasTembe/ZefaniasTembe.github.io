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
import java.io.IOException;
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

public class Menu extends JFrame {
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
    private JButton btnRegistarEstudantes = new JButton("Registar Estudantes");
    private JButton btnListarEstudantes   = new JButton("Listar Estudantes ");
    private JButton btnRegistarDocentes   = new JButton("Registar Docentes ");
    private JButton btnListarDocentes     = new JButton("Listar Docentes ");
    private JButton btnFiltrarDispensados = new JButton("Dispensados ");
    private JButton btnFiltrarExcluidos   = new JButton("Excuidos ");
    private JButton btnFiltrarAdmitidos   = new JButton("Admitidos ");
    
    public Menu(){
        setTitle(" Menu - BigSoftwareSchoolSystem");
        setLayout(new GridBagLayout());
        accoesDosBotoes();
        adicionarBotoes();
        
        // Configuracoes Finais da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,500);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    // Manipulando o painel Que ficara no centro do Frame
    public void add(String label, JComponent componente) {
        GridBagConstraints cons = new GridBagConstraints();
        
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.NORTHWEST;
        cons.insets = new Insets(4, 4, 4, 4);
        cons.weightx = 0;
        cons.gridwidth = 1;
        getContentPane().add(new JLabel(label), cons);

        cons.fill = GridBagConstraints.BOTH;
        cons.weightx = 1;
        cons.gridwidth = GridBagConstraints.REMAINDER;
        getContentPane().add(componente, cons);
    }
    
    public void adicionarBotoes(){
        btnRegistarDocentes.setBackground(new java.awt.Color(50,84,200));
        btnRegistarDocentes.setForeground(new java.awt.Color(255,255,255));
        add("",btnRegistarDocentes);
        btnListarDocentes.setBackground(new java.awt.Color(30,198,104));
        btnListarDocentes.setForeground(new java.awt.Color(255,255,255));
        add("",btnListarDocentes);
        btnRegistarEstudantes.setBackground(new java.awt.Color(50,84,204));
        btnRegistarEstudantes.setForeground(new java.awt.Color(255,255,255));
        add("",btnRegistarEstudantes);
        btnListarEstudantes.setBackground(new java.awt.Color(0,204,100));
        btnListarEstudantes.setForeground(new java.awt.Color(255,255,255));
        add("",btnListarEstudantes);
        btnFiltrarExcluidos.setBackground(new java.awt.Color(0,100,204));
        btnFiltrarExcluidos.setForeground(new java.awt.Color(255,255,255));
        add("",btnFiltrarExcluidos);
        btnFiltrarAdmitidos.setBackground(new java.awt.Color(90,204,84));
        btnFiltrarAdmitidos.setForeground(new java.awt.Color(255,255,255));
        add("",btnFiltrarAdmitidos);
        btnFiltrarDispensados.setBackground(new java.awt.Color(50,84,114));
        btnFiltrarDispensados.setForeground(new java.awt.Color(255,255,255));
        add("",btnFiltrarDispensados);
    }
    
    public void accoesDosBotoes() {
         btnFiltrarAdmitidos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                dispose();
                RegistarEstudante regEst = new RegistarEstudante();
                regEst.lerTabelaEstudantes("Admitido");
                regEst.accoesDosBotoes();
            }
        });
        btnFiltrarDispensados.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                dispose();
                RegistarEstudante regEst = new RegistarEstudante();
                regEst.lerTabelaEstudantes("Dispensado");
                regEst.accoesDosBotoes();
            }
        });
        btnFiltrarExcluidos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                dispose();
                RegistarEstudante regEst = new RegistarEstudante();
                regEst.lerTabelaEstudantes("Excluido");
                regEst.accoesDosBotoes();
            }
        });
        
        btnListarDocentes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //4
                dispose();
                RegistarDocente regDoc = new RegistarDocente();
            }
        });
        btnListarEstudantes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //5
                dispose();
                RegistarEstudante regEst = new RegistarEstudante();
                regEst.accoesDosBotoes();
            }
        });
        btnRegistarDocentes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //6
                dispose();
                RegistarDocente regDoc = new RegistarDocente();
                
            }
        });
        btnRegistarEstudantes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //7
                dispose();
                RegistarEstudante regEst = new RegistarEstudante();
                regEst.accoesDosBotoes();
            }
        });
    }
    
    public static void main(String[] args) {
        Menu menu = new Menu();
    }
}
