package com.quangbruder.connectfour.models;

import java.util.ArrayList;

/**
 * The game board is divided into columns.
 */
public class BoardColumn {
    private int no;

    public BoardColumn(int number){
        no = number;
    }

    /**
     * @return a number of column
     */
    public int getNumber(){
        return this.no;
    }

    /**
     * create a  arraylist containing all of the columns.
     * @return a arraylist containing all of the columns.
     */
    public static ArrayList<BoardColumn> createBoardColumnList(){
        ArrayList<BoardColumn> result = new ArrayList<BoardColumn>();
        for (int i=0;i < 7; i++) {
            result.add(new BoardColumn(i));
        }
        return result;
    }

}
