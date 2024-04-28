package com.example.foodpark;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class adapterMenu extends RecyclerView.Adapter<adapterMenu.MyViewHolder> {

    public  ArrayList<menuDetails> menu_detail;
   // List<Items> items;
     buttonClickListner buttonClickListner;

    public adapterMenu(ArrayList<menuDetails> menu_detail,buttonClickListner buttonClickListner) {
        this.menu_detail = menu_detail;
        this.buttonClickListner=buttonClickListner;
        //this.items=items;

    }

    @NonNull
    @Override
    public adapterMenu.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_menu, parent, false);
        return new adapterMenu.MyViewHolder(v,buttonClickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterMenu.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
   holder.dishname.setText(menu_detail.get(position).getRecipeName());
   holder.protein.setText(menu_detail.get(position).getRecipeProtein());
   holder.carb.setText(menu_detail.get(position).getRecipeCarb());
   holder.fat.setText(menu_detail.get(position).getRecipeFat());
   holder.price.setText(menu_detail.get(position).getRecipePrice());

    }

    @Override
    public int getItemCount() {
        return menu_detail.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
    TextView dishname,protein,carb,fat,price,like,ids;
    Button button_basket;
    ImageView image;
   // buttonClickListner buttonClickListner;
        public MyViewHolder(@NonNull View itemView,buttonClickListner buttonClickListner ) {
            super(itemView);

            dishname=itemView.findViewById(R.id.dish_name);
            protein=itemView.findViewById(R.id.protein);
            carb=itemView.findViewById(R.id.carb);
            fat=itemView.findViewById(R.id.fat);
            price=itemView.findViewById(R.id.price);
            like=itemView.findViewById(R.id.like);
            ids=itemView.findViewById(R.id.pids);
            button_basket=itemView.findViewById(R.id.basket_button);
          button_basket.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if(buttonClickListner != null){
                      int pos = getAbsoluteAdapterPosition();
                      if(pos != RecyclerView.NO_POSITION)
                      {
                          buttonClickListner.onButtonClick(pos);
                      }
                  }
              }
          });
            like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(buttonClickListner != null){
                        int pos = getAbsoluteAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION)
                        {
                            buttonClickListner.onLikeClick(pos);
                        }
                    }
                }
            });


        }

    }
}
