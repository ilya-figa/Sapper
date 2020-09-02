package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class Form extends JFrame{

    String path = new java.io.File("Sapper").getAbsolutePath() + "\\";
    Boolean check = true;

    JButton checkButton;

    public Form() throws HeadlessException {
        Panel panel = new Panel();

        GeneratingFields field = new GeneratingFields(9, 9, 9);
        int[][] arrBool = new int[field.getColumn()][field.getRows()];

        for (int i = 0; i < arrBool.length; i++){
            for (int j = 0; j < arrBool[i].length; j++){
                arrBool[i][j] = 0;
            }
        }

        int[][] arrCell = field.generatingCell();
        field.getArr();

        setSize(465, 540);

        ImageIcon icon = new ImageIcon(path + "ClosedCell.png");
        Image img = icon.getImage() ;
        Image newimg = img.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon(newimg);

        JButton[][] arrButton = new JButton[9][9];

        for (int i = 0; i < arrButton.length; i++) {
            for (int j = 0; j < arrButton[i].length; j++) {
                arrButton[i][j] = new JButton(icon);
                MouseListener mouseListener = new MouseListenerRC(this, arrCell, arrButton, arrBool,j, i);

                arrButton[i][j].addMouseListener(mouseListener);
                arrButton[i][j].setSize(50, 50);
                arrButton[i][j].setLocation(j * 50, i * 50 + 50);

                add(arrButton[i][j]);
            }
        }

        icon = new ImageIcon(path + "FunnySmile.png");
        img = icon.getImage() ;
        newimg = img.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon(newimg);

        checkButton = new JButton(icon);

        MouseListener mouseListener = new CheckedMouseListener(checkButton, arrCell, arrButton, arrBool);

        checkButton.addMouseListener(mouseListener);

        checkButton.setSize(50, 50);
        checkButton.setLocation((arrButton.length / 2) == 0 ?
                (arrButton.length * 50) / 2 : (arrButton.length * 50 - 50) / 2
                ,  0);
        add(checkButton);

        add(panel);

        setVisible(true);
    }
}
