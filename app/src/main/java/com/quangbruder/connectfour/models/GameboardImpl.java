package com.quangbruder.connectfour.models;

public class GameboardImpl implements Gameboard{


    public int movesCounter = 0;
    public int lastColumn = 0;
    public int lastRow = 0;
    public Player currentPlayer = Player.ONE;

    /**
     *  print the current game board in console
     */
    @Override
    public void printBoard() {
        Player cfPlayer;
        for (int i = ROWS - 1; i > -1; i--) {
            for (int j = 0; j < COLUMNS; j++) {
                cfPlayer = board[i][j];
                if (cfPlayer == Player.NONE) {
                    System.out.print("-");
                } else if (cfPlayer == Player.ONE) {
                    System.out.print("x");
                } else {
                    System.out.print("o");
                }
            }
            System.out.println("");
        }
    }

    /**
     * all places in board are set to NONE to start a new game.
     */
    @Override
    public void cleanBoard(){
        for (int i=0; i< ROWS;i++){
            for (int j=0; j< COLUMNS;j++){
                this.board[i][j] = Player.NONE;
            }
        }
        System.out.println("Board is ready for a new game!");
    }

    /**
     * make multi moves. Used to test.
     * @param columns
     */
    @Override
    public void makeMultiMoves(int[] columns){
        for (int i=0; i< columns.length;i++){
            makeMove(columns[i]);
        }
    }

    /**
     * make a move
     * @param column_nr
     * @return the number of row if successful; -1 if failed.
     */
    @Override
    public int makeMove(int column_nr){
        if (!isMovable(column_nr)) return -1;
        for (int i= 0; i< ROWS; i++){
            if(this.board[i][column_nr] == Player.NONE){
                this.board[i][column_nr] = this.currentPlayer;
                changeCurrentPlayer();
                this.movesCounter++;
                this.lastColumn = column_nr;
                this.lastRow = i;
                return i;
            }
        }
        return -1;
    }

    /**
     * @param column_nr
     * @return true if this column can be filled.
     */
    @Override
    public boolean isMovable(int column_nr){
        if (this.movesCounter >= (COLUMNS*ROWS) || column_nr < 0  || column_nr >= COLUMNS) return false;
        if(this.board[ROWS-1][column_nr] == Player.NONE){
            return true;
        } else {
            System.out.println("Not movable column="+column_nr);
            return false;
        }
    }

    /**
     * @return true, if the player is victory in vertical lines.
     */
    @Override
    public boolean isVerticalWin(){
        int lastRow = this.lastRow;
        int lastColumn = this.lastColumn;
        if(lastRow>2 && isSamePlayer(this.board[lastRow-3][lastColumn], this.board[lastRow-2][lastColumn],
                this.board[lastRow-1][lastColumn],this.board[lastRow][lastColumn])
                && this.board[lastRow][lastColumn] != Player.NONE){
            System.out.println("Vertical Winner");
            return true;
        }
        return false;
    }

    /**
     * @return true, if the player is victory in horizontal lines.
     */
    @Override
    public boolean isHorizontalWin(){
        int lastRow = this.lastRow;
        int lastColumn = this.lastColumn;
        Player[][] board = this.board;
        for (int i= lastColumn; i< lastColumn+4 ; i++){
            if(i-3 >= 0  && i<COLUMNS && null != board[lastRow][i-3] && null != board[lastRow][i-2] && null != board[lastRow][i-1]) {
                if(isSamePlayer(board[lastRow][i-3], board[lastRow][i-2],
                        board[lastRow][i-1], board[lastRow][i])
                        && board[lastRow][i] != Player.NONE){
                    System.out.println("i = "+i+", row="+ lastRow + "Horizontal Winner");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return true, if the player is victory in diogonal lines with the upward direction.
     */
    @Override
    public boolean isDiogonalUpWin(){
        int lastRow = this.lastRow;
        int lastColumn = this.lastColumn;
        Player[][] board = this.board;

        int i = lastRow;
        int j = lastColumn;
        while( i< lastRow+4){
            if(i-3>= 0 && j-3>=0 && i< ROWS && j< COLUMNS && null != board[i-3][j-3] && null != board[i-2][j-2] && null != board[i-1][j-1]) {
                if(isSamePlayer(board[i-3][j-3], board[i-2][j-2],
                        board[i-1][j-1], board[i][j])
                        && board[i][j] != Player.NONE){
                    System.out.println("Diogonal Up Winner");
                    return true;
                }
            }
            i++;
            j++;
        }
        return false;
    }

    /**
     * @return true, if the player is victory in diogonal lines with the downward direction.
     */
    @Override
    public boolean isDiogonalDownWin(){
        int lastRow = this.lastRow;
        int lastColumn = this.lastColumn;
        Player[][] board = this.board;

        int i = lastRow+3;
        int j = lastColumn-3;
        while( i>= lastRow ){
            if(i-3>=0 && i<ROWS && j+3< COLUMNS && j>= 0 && null != board[i-3][j+3] && null != board[i-2][j+2] && null != board[i-1][j+1]) {
                if(isSamePlayer(board[i-3][j+3], board[i-2][j+2],
                        board[i-1][j+1], board[i][j])
                        && board[i][j] != Player.NONE){
                    System.out.println("Diogonal Down Winner");
                    return true;
                }
            }
            i--;
            j++;
        }
        return false;
    }

    /**
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return true, if all four places with the same player.
     */
    @Override
    public boolean isSamePlayer(Player p1, Player p2, Player p3, Player p4){
        if(p1==p2 && p2==p3 && p3==p4){
            return true;
        }
        return false;
    }

    /**
     * change to the next player.
     */
    @Override
    public void  changeCurrentPlayer(){
        if (this.currentPlayer == Player.ONE){
            this.currentPlayer = Player.TWO;
        } else {
            this.currentPlayer = Player.ONE;
        }
    }

    /**
     * All types of victory are checked.
     * @return true, if a type of victory happens.
     */
    @Override
    public boolean isVictory(){
        if(isVerticalWin() || isHorizontalWin() || isDiogonalDownWin() || isDiogonalUpWin()){
            return true;
        }
        return false;
    }

    /**
     * @return true, if the game is drawn.
     */
    @Override
    public boolean isDrawn(){
        if(!this.isVictory() && this.movesCounter >= 42){
            return true;
        }
        return false;
    }

    /**
     * @return true, if the game is finished.
     */
    @Override
    public boolean isFinished(){
        if (isDrawn() || isVictory()){
            return true;
        }
        return false;
    }

    /**
     * @return the next player.
     */
    @Override
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    /**
     * @return the number of moves.
     */
    @Override
    public int getMovesCounter(){
        return movesCounter;
    }


}
