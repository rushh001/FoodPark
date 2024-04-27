package com.example.foodpark;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;

public class adapterMenu extends RecyclerView.Adapter<adapterMenu.MyViewHolder> {

    ArrayList<menuDetails> menu_detail;
     buttonClickListner buttonClickListner;

    public adapterMenu(ArrayList<menuDetails> menu_detail,buttonClickListner buttonClickListner) {
        this.menu_detail = menu_detail;
        this.buttonClickListner=buttonClickListner;

    }

    @NonNull
    @Override
    public adapterMenu.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_menu, parent, false);
        return new adapterMenu.MyViewHolder(v,buttonClickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterMenu.MyViewHolder holder, int position) {
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
    TextView dishname,protein,carb,fat,price;
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


        }

    }
}
