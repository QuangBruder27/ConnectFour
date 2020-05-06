package com.quangbruder.connectfour.models;

public interface Gameboard {

    /**
     * Every place on the board is marked;
     * NONE: not filled,
     * ONE: filled by the first player,
     * TWO: filled by the second player,
     */
    enum Player {
        NONE,
        ONE,
        TWO
    }

    int COLUMNS = 7;
    int ROWS = 6;
    Player[][] board = new Player[ROWS][COLUMNS];

    void printBoard();
    void cleanBoard();
    void makeMultiMoves(int[] columns);
    int makeMove(int column_nr);
    boolean isMovable(int column_nr);
    boolean isVerticalWin();
    boolean isHorizontalWin();
    boolean isDiogonalUpWin();
    boolean isDiogonalDownWin();
    boolean isSamePlayer(Player p1, Player p2, Player p3, Player p4);
    void  changeCurrentPlayer();
    boolean isVictory();
    boolean isDrawn();
    boolean isFinished();
    int getMovesCounter();
    Player getCurrentPlayer();

}
