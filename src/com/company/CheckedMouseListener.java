package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CheckedMouseListener implements MouseListener {
    private int[][] arrCell;
    private JButton[][] arrButton;
    private int[][] arrBool;

    private JButton checkButton;
    private int rows;
    private int column;

    private String path = new java.io.File("Sapper").getAbsolutePath() + "\\";

    public CheckedMouseListener(JButton checkButton, int[][] arrCell, JButton[][] arrButton, int[][] arrBool){
        this.arrCell = arrCell;
        this.arrButton = arrButton;
        this.arrBool = arrBool;
        this.checkButton = checkButton;
    }
    public CheckedMouseListener(JButton checkButton, int[][] arrCell, JButton[][] arrButton, int[][] arrBool, int rows, int column){
        this.arrCell = arrCell;
        this.arrButton = arrButton;
        this.arrBool = arrBool;
        this.checkButton = checkButton;
        this.rows = rows;
        this.column = column;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        checkButton.setIcon(imageCell("SadSmile"));

        for (int i = 0; i < arrCell.length; i++) {
            for (int j = 0; j < arrCell[i].length; j++) {
                switch (arrBool[i][j]) {
                    case 0:
                        if (arrCell[i][j] == 9) {
                            if (i == column && j == rows) {
                                arrButton[i][j].setIcon(imageCell("NotGuessedBomb"));
                                arrBool[i][j] = 5;
                            } else {
                                arrButton[i][j].setIcon(imageCell("Bomb"));
                                arrBool[i][j] = 5;
                            }

                        }
                        break;
                    case 2:
                        if (arrCell[i][j] == 9) {
                            arrButton[i][j].setIcon(imageCell("GuessedBomb"));
                            arrBool[i][j] = 4;
                        }
                        break;
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private ImageIcon imageCell(String str){
        ImageIcon icon = new ImageIcon(path + str + ".png");
        Image img = icon.getImage() ;
        Image newimg = img.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon(newimg);
        return icon;
    }

}
