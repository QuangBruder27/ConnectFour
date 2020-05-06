package com.quangbruder.connectfour.controller;

import android.widget.Toast;

import com.quangbruder.connectfour.R;
import com.quangbruder.connectfour.models.Gameboard;
import com.quangbruder.connectfour.views.BoardColumnsAdapter;

public class GameController {

    static void drawCircle(Gameboard.Player player, BoardColumnsAdapter.ViewHolder holder, int row){
        if(player == Gameboard.Player.ONE) {
            holder.imgViewList[row].setImageResource(R.drawable.yellow);
        } else {
            holder.imgViewList[row].setImageResource(R.drawable.red);
        }
    }

    static void statusNoti(Gameboard gameboard, BoardColumnsAdapter.ViewHolder holder){
        if(gameboard.isVictory()){
            Toast.makeText(holder.itemView.getContext(), "Is Victory", Toast.LENGTH_SHORT).show();
        }
        if (gameboard.isDrawn()){
            Toast.makeText(holder.itemView.getContext(), "Is Drawn", Toast.LENGTH_SHORT).show();
        }
    }

    public static void boardClick(Gameboard gameboard,boolean hasTurn, BoardColumnsAdapter.ViewHolder holder, int col_nr){
        if (gameboard.isMovable(col_nr) && hasTurn && !gameboard.isFinished()){
            int row = gameboard.makeMove(col_nr);
            drawCircle(gameboard.getCurrentPlayer(), holder ,row);
            statusNoti(gameboard, holder);
        } else {
            Toast.makeText(holder.itemView.getContext(), "Not movable", Toast.LENGTH_SHORT).show();
        }
    }
}
