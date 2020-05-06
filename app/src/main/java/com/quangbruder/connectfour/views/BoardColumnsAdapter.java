package com.quangbruder.connectfour.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quangbruder.connectfour.controller.GameController;
import com.quangbruder.connectfour.models.Gameboard;
import com.quangbruder.connectfour.models.GameboardImpl;
import com.quangbruder.connectfour.R;
import com.quangbruder.connectfour.models.BoardColumn;

import java.util.List;

public class BoardColumnsAdapter extends RecyclerView.Adapter<BoardColumnsAdapter.ViewHolder> {

    List<BoardColumn> columnList;
    boolean hasTurn = false;

    public BoardColumnsAdapter(List<BoardColumn> mList, boolean aTurn){
        columnList = mList;
        hasTurn = aTurn;
    }

    /**
     *  a static class to hold the recycler view
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgView;
        public ImageView imgView1;
        public ImageView imgView2;
        public ImageView imgView3;
        public ImageView imgView4;
        public ImageView imgView5;
        public ImageView imgView6;
        public ImageView imgView7;
        public ImageView[] imgViewList;

        public ViewHolder(View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.imgView);
            imgView1 = itemView.findViewById(R.id.imgView1);
            imgView2 = itemView.findViewById(R.id.imgView2);
            imgView3 = itemView.findViewById(R.id.imgView3);
            imgView4 = itemView.findViewById(R.id.imgView4);
            imgView5 = itemView.findViewById(R.id.imgView5);
            imgViewList = new ImageView[]{imgView5,imgView4 ,imgView3,imgView2,imgView1,imgView};
        }
    }

    Gameboard gameboard = new GameboardImpl();

    /**
     * create a view holder.
     * @param parent
     * @param viewType
     * @return a view holder.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        gameboard.cleanBoard();

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_boardcolumn, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        //--------------- Size for imageView
        int displayHeight = context.getResources().getDisplayMetrics().heightPixels;
        int displayWidth = context.getResources().getDisplayMetrics().widthPixels;

        for (int i=0; i< 6;i++){
            viewHolder.imgViewList[i].setLayoutParams(new LinearLayout.LayoutParams(displayWidth/7,
                    displayWidth/7));
        }

        return viewHolder;
    }

    /**
     * set OnClick-Event for the view
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final BoardColumn column = columnList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               GameController.boardClick(gameboard,hasTurn,holder, position);
            }
        });
    }

    /**
     * @return length of the list of object.
     */
    @Override
    public int getItemCount() {
        return columnList.size();
    }




}
