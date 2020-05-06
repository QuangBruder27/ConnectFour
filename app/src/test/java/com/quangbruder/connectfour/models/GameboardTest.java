package com.quangbruder.connectfour.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameboardTest {

    Gameboard gameboard;

    @BeforeEach
    void setUp() {
        gameboard = new GameboardImpl();
        gameboard.cleanBoard();
    }

    @Test
    void makeMove() {
        gameboard.makeMove(0);
        assert(gameboard.getMovesCounter() >0);
    }

    @Test
    void isDiogonalUpWin1(){
        int [] columns = {5,1,1,2,3,2,2,3,3,4,3,5,0};
        gameboard.makeMultiMoves(columns);
        assert (gameboard.isDiogonalUpWin());
    }

    @Test
    void isDiogonalUpWin2(){
        int [] columns = {1,0,0,1,1,2,2,2,5,3,3,3,3,4,3,5,2};
        gameboard.makeMultiMoves(columns);
        //game.printBoard();
        assert (gameboard.isDiogonalUpWin());
    }

    @Test
    void isDiogonalDownWin1(){
        int [] columns = {2,2,2,3,3,1,1,1,1,0,4};
        gameboard.makeMultiMoves(columns);
        gameboard.printBoard();
        assert (gameboard.isDiogonalDownWin());
    }

    @Test
    void isDiogonalDownWin2(){
        int [] columns = {0,0,0,1,1,2,1,4,2,5,3,6,0};
        gameboard.makeMultiMoves(columns);
        gameboard.printBoard();
        assert (gameboard.isDiogonalDownWin());
    }

    @Test
    void isHorizontalWin1(){
        int [] columns = {0,4,1,4,2,4,3};
        gameboard.makeMultiMoves(columns);
        //game.printBoard();
        assert (gameboard.isHorizontalWin());
    }

    @Test
    void isHorizontalWin2(){
        int [] columns = {1,0,2,0,4,0,3};
        gameboard.makeMultiMoves(columns);
        //game.printBoard();
        assert (gameboard.isHorizontalWin());
    }

    @Test
    void isVerticalWin1(){
        int [] columns = {0,0,0,1,0,1,0,1,0};
        gameboard.makeMultiMoves(columns);
        //game.printBoard();
        assert (gameboard.isVerticalWin());
    }

    @Test
    void isVerticalWin2(){
        int [] columns = {6,1,6,1,6,1,6};
        gameboard.makeMultiMoves(columns);
        //game.printBoard();
        assert (gameboard.isVerticalWin());
    }

    @Test
    void isVictoryTest(){
        int [] columns = {6,1,6,1,6,1,6};
        gameboard.makeMultiMoves(columns);
        assert (gameboard.isVictory());
    }

}