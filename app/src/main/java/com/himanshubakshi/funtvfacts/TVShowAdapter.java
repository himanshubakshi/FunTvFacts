package com.himanshubakshi.funtvfacts;

/**
 * Created by hbakshi on 5/14/16.
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.MyViewHolder> {

    private List<TvShow> showList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView showName;
        public ImageView showImage;

        public MyViewHolder(View view) {
            super(view);
            showImage = (ImageView) view.findViewById(R.id.card_image);
            showName = (TextView) view.findViewById(R.id.card_show_name);
        }
    }

    public TvShowAdapter(List<TvShow> tvShowList) {
        this.showList = tvShowList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.show_card_row, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TvShow tvShow = showList.get(myViewHolder.getAdapterPosition());
                Intent intent = new Intent(parent.getContext(), FunFactDetailActivity.class);
                intent.putExtra(MainActivity.TV_SHOW_NAME, tvShow.getShowNameId());
                parent.getContext().startActivity(intent);
            }
        });

        myViewHolder.getAdapterPosition();
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TvShow show = showList.get(position);
        holder.showName.setText(holder.itemView.getContext().getText(show.getShowNameId()));
        holder.showImage.setImageResource(show.getShowImageId());
    }

    @Override
    public int getItemCount() {
        return showList.size();
    }
}