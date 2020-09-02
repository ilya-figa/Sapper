package com.company;

import java.util.Random;

public class GeneratingFields {
    private int countBomb;
    private int rows;
    private int column;
    private int[][] arrCell;

    public GeneratingFields(int rows, int column, int countBomb){
        this.rows = rows;
        this.column = column;
        this.countBomb = countBomb;
    }

    public GeneratingFields(){

    }

    public int getCountBomb(){
        return countBomb;
    }

    public void setCountBomb(int countBomb){
        this.countBomb = countBomb;
    }

    public int getRows(){
        return rows;
    }

    public void setRows(int rows){
        this.rows = rows;
    }

    public int getColumn(){
        return column;
    }

    public void setColumn(int column){
        this.column = column;
    }

    public int[][] generatingCell(){
        this.arrCell = new int[column][rows];

        for (int i = 0; i < countBomb; i++){
            generatingBomb();
        }

        for (int i = 0; i < arrCell.length; i++){
            for (int j = 0; j < arrCell[i].length; j++){
                if (arrCell[i][j] == 9){
                    for (int smArrI = i - 1; smArrI < i + 2; smArrI++){
                        for (int smArrJ = j - 1; smArrJ < j + 2; smArrJ++){
                            if (smArrI >= 0 && smArrI < arrCell.length && smArrJ >= 0 && smArrJ < arrCell[i].length){
                                if (arrCell[smArrI][smArrJ] != 9){
                                    arrCell[smArrI][smArrJ]++;
                                }
                            }
                        }
                    }
                }
            }
        }

        return arrCell;
    }

    private void generatingBomb(){
        int countEmptyCell = 0;

        for (int i = 0; i < arrCell.length; i++){
            for (int j = 0; j < arrCell[i].length; j++){
                if (arrCell[i][j] != 9){
                    countEmptyCell++;
                }
            }
        }

        Random rnd = new Random();
        int selectedСell = rnd.nextInt(countEmptyCell);

        countEmptyCell = 0;
        for (int i = 0; i < arrCell.length; i++){
            for (int j = 0; j < arrCell[i].length; j++){
                if (selectedСell == countEmptyCell && arrCell[i][j] != 9){
                    arrCell[i][j] = 9;
                    countEmptyCell++;
                }
                if (arrCell[i][j] != 9){
                    countEmptyCell++;
                }

            }
        }
    }

    public void getArr(){
        for (int i = 0; i < arrCell.length; i++){
            for (int j = 0; j < arrCell[i].length; j++){
                System.out.print(arrCell[i][j] + " ");
            }
            System.out.println();
        }
    }
}
