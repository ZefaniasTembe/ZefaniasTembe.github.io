/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigsoftwareschool;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tembe
 */
public class Painel extends JPanel{
//    public void add(String label, JComponent componente) {
//        setLayout(new GridBagLayout());
//        GridBagConstraints cons = new GridBagConstraints();
//        
//        cons.fill = GridBagConstraints.NONE;
//        cons.anchor = GridBagConstraints.NORTHWEST;
//        cons.insets = new Insets(4, 4, 4, 4);
//        cons.weightx = 0;
//        cons.gridwidth = 1;
//        add(new JLabel(label), cons);
//
//        cons.fill = GridBagConstraints.BOTH;
//        cons.weightx = 1;
//        cons.gridwidth = GridBagConstraints.REMAINDER;
//        add(componente, cons);
//    }
    
    public void add(String label, JComponent componente) {
        GridBagConstraints cons = new GridBagConstraints();
        
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.NORTHWEST;
        cons.insets = new Insets(4, 4, 4, 4);
        cons.weightx = 0;
        cons.gridwidth = 1;
        add(new JLabel(label), cons);

        cons.fill = GridBagConstraints.BOTH;
        cons.weightx = 1;
        cons.gridwidth = GridBagConstraints.NONE;
        add(componente, cons);
    }
}
