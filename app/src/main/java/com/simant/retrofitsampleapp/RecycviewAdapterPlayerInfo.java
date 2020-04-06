package com.simant.retrofitsampleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class RecycviewAdapterPlayerInfo extends RecyclerView.Adapter<RecycviewAdapterPlayerInfo.MyViewHolder> {

    Context context;
    List<PlayerInfoModalClass> playerInfoModalClasses;

    public RecycviewAdapterPlayerInfo(Context context, List<PlayerInfoModalClass> playerInfoModalClasses) {
        this.context = context;
        this.playerInfoModalClasses = playerInfoModalClasses;
    }

    @NonNull
    @Override
    public RecycviewAdapterPlayerInfo.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_info_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycviewAdapterPlayerInfo.MyViewHolder holder, int position) {
        final PlayerInfoModalClass playerInfoModalClass = playerInfoModalClasses.get(position);
        holder.txt_name.setText(playerInfoModalClass.getName());
        holder.txt_country.setText(playerInfoModalClass.getCountry());
        Picasso.get()
                .load(playerInfoModalClass.getImgURL())
                .into(holder.img_player);
    }

    @Override
    public int getItemCount() {
        return playerInfoModalClasses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_name, txt_country;
        ImageView img_player;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_name = itemView.findViewById(R.id.fullname);
            txt_country = itemView.findViewById(R.id.country);
            img_player = itemView.findViewById(R.id.playerImage);
        }
    }
}