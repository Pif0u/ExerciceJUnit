package com.TPJunit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Map;

public class ProgrammeGUI {
    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton calculerButton;
    private JPanel panel1;

    public ProgrammeGUI() {

        calculerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Hashtable result = RacineCarre.racineCarre(Integer.parseInt(textField1.getText()), Integer.parseInt(textField2.getText()));

                DefaultTableModel dtm = new DefaultTableModel();
                String header[] = new String[] { "Nombre", "Racine carré"};
                dtm.setColumnIdentifiers(header);


                result.forEach((k, v) ->
                {
                    dtm.addRow(new Object[]{k, v});
                });

                table1.setModel(dtm);

            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Calcul racine");
        frame.setContentPane(new ProgrammeGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-dim.getSize().height/2);
        frame.setVisible(true);
    }
}
