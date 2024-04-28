package com.example.foodpark;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class adapterFavourite  extends RecyclerView.Adapter<adapterFavourite.MyViewHolder> {

    List<Items> items;
    buttonClickListner buttonClickListner;

    public adapterFavourite(List<Items> items,buttonClickListner buttonClickListne) {
        this.items= items;
        this.buttonClickListner=buttonClickListner;
    }

    @NonNull
    @NotNull
    @Override
    public adapterFavourite.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_favourite, parent, false);
        return new adapterFavourite.MyViewHolder(v,buttonClickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterFavourite.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.dishname.setText(items.get(position).getDishname());
        holder.protein.setText(items.get(position).getDishprotein());
        holder.carb.setText(items.get(position).getDishcarb());
        holder.fat.setText(items.get(position).getDishfat());
        holder.price.setText(String.valueOf(items.get(position).getDishprice()));
        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db = Room.databaseBuilder(holder.ids.getContext(),
                        AppDatabase.class, "like_db").allowMainThreadQueries().build();
                itemsDAO itemsDAO=db.iteamDAO();
                itemsDAO.deleteById(items.get(position).getPid());
                items.remove(position);
                notifyItemRemoved(position);
                // updateprice();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView dishname,protein,carb,fat,price,ids;
        Button button_delete;

        ImageView image;
        // buttonClickListner buttonClickListner;
        public MyViewHolder(@NonNull View itemView,buttonClickListner buttonClickListner ) {
            super(itemView);

            dishname=itemView.findViewById(R.id.dish_name);
            protein=itemView.findViewById(R.id.protein);
            carb=itemView.findViewById(R.id.carb);
            fat=itemView.findViewById(R.id.fat);
            price=itemView.findViewById(R.id.price);
            ids=itemView.findViewById(R.id.pids);
            button_delete=itemView.findViewById(R.id.delete_button);


        }

    }
}
