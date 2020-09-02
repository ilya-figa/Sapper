package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerRC implements MouseListener{

    private int[][] arrCell;
    private JButton[][] arrButton;
    private int[][] arrBool;

    private int rows;
    private int column;
    private Form panel;

    private String path = new java.io.File("Sapper").getAbsolutePath() + "\\";


    public MouseListenerRC(Form panel,int[][] arrCell,JButton[][] arrButton, int[][] arrBool, int rows, int column){
        this.arrCell = arrCell;
        this.arrButton = arrButton;
        this.rows = rows;
        this.column = column;
        this.arrBool = arrBool;
        this.panel = panel;
    }

    private ImageIcon imageCell(String str){
        ImageIcon icon = new ImageIcon(path + str + ".png");
        Image img = icon.getImage() ;
        Image newimg = img.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon(newimg);
        return icon;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            switch (arrCell[column][rows]) {
                case 0:
                    if (arrBool[column][rows] == 0) {

                        arrButton[column][rows].setIcon(imageCell("OpenCell"));
                        arrBool[column][rows] = 1;

                        MouseListenerRC rek;

                        if (rows + 1 < arrCell[column].length) {
                            rek = new MouseListenerRC(panel, arrCell, arrButton, arrBool, rows + 1, column);
                            rek.mouseClicked(e);
                        }
                        if (rows - 1 >= 0) {
                            rek = new MouseListenerRC(panel, arrCell, arrButton, arrBool, rows - 1, column);
                            rek.mouseClicked(e);
                        }
                        if (column + 1 < arrCell.length) {
                            rek = new MouseListenerRC(panel, arrCell, arrButton, arrBool, rows, column + 1);
                            rek.mouseClicked(e);
                        }
                        if (column - 1 >= 0) {
                            rek = new MouseListenerRC(panel, arrCell, arrButton, arrBool, rows, column - 1);
                            rek.mouseClicked(e);
                        }
                    }
                    break;
                case 1:
                    arrButton[column][rows].setIcon(imageCell("1"));
                    arrBool[column][rows] = 1;
                    break;
                case 2:
                    arrButton[column][rows].setIcon(imageCell("2"));
                    arrBool[column][rows] = 1;
                    break;
                case 3:
                    arrButton[column][rows].setIcon(imageCell("3"));
                    arrBool[column][rows] = 1;
                    break;
                case 4:
                    arrButton[column][rows].setIcon(imageCell("4"));
                    arrBool[column][rows] = 1;
                    break;
                case 5:
                    arrButton[column][rows].setIcon(imageCell("5"));
                    arrBool[column][rows] = 1;
                    break;
                case 6:
                    arrButton[column][rows].setIcon(imageCell("6"));
                    arrBool[column][rows] = 1;
                    break;
                case 7:
                    arrButton[column][rows].setIcon(imageCell("7"));
                    arrBool[column][rows] = 1;
                    break;
                case 8:
                    arrButton[column][rows].setIcon(imageCell("8"));
                    arrBool[column][rows] = 1;
                    break;
                case 9:
                    MouseListener mouseListener = new CheckedMouseListener(panel.checkButton, arrCell, arrButton, arrBool, rows, column);
                    mouseListener.mouseClicked(e);
                    break;
            }
        } else if(e.getButton() == MouseEvent.BUTTON3){

            if (arrBool[column][rows] == 0){
                arrButton[column][rows].setIcon(imageCell("Flag"));
                arrBool[column][rows] = 2;
            }else if(arrBool[column][rows] == 2){
                arrButton[column][rows].setIcon(imageCell("ClosedCell"));
                arrBool[column][rows] = 0;
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
}
