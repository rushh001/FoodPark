package com.example.foodpark;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodpark.databinding.FragmentAllTrendBinding;
import com.example.foodpark.databinding.FragmentTrendingBinding;

import java.util.ArrayList;


public class AllTrendFragment extends Fragment implements buttonClickListner {
    FragmentAllTrendBinding binding;
    ArrayList<menuDetails> menu_details = new ArrayList<>();
    adapterMenu adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAllTrendBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpMenu();
        //menu_details=new ArrayList<>();
        adapter = new adapterMenu(menu_details, this);
        binding.menuRecyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.menuRecyclerview.setLayoutManager(layoutManager);
        adapter.notifyDataSetChanged();



    }
    private void setUpMenu() {
        String dishes_names[] = getResources().getStringArray(R.array.trenddish);
        String protein_gram[] = getResources().getStringArray(R.array.trendprotein);
        String carb_gram[] = getResources().getStringArray(R.array.trendcarb);
        String fat_gram[] = getResources().getStringArray(R.array.trendfat);
        String prices_quantity[] = getResources().getStringArray(R.array.trendprices);
        String dish_ids[] = getResources().getStringArray(R.array.trendids);

        for (int i = 0; i < dishes_names.length; i++) {
            menu_details.add(new menuDetails(dishes_names[i], protein_gram[i], carb_gram[i],
                    fat_gram[i], prices_quantity[i], dish_ids[i]));

        }
    }


    @Override
    public void onButtonClick(int position) {
        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "basket_db").allowMainThreadQueries().build();
        itemsDAO itemsDAO = db.iteamDAO();
        Boolean check = itemsDAO.is_exist(Integer.parseInt(menu_details.get(position).getRecipeIds()));
        if (check == false) {
            int pid = Integer.parseInt(menu_details.get(position).getRecipeIds());
            String dishname = menu_details.get(position).getRecipeName();
            String dishprotein = menu_details.get(position).getRecipeProtein();
            String dishcarb = menu_details.get(position).getRecipeCarb();
            String dishfat = menu_details.get(position).getRecipeFat();
            int dishprice = Integer.parseInt(menu_details.get(position).getRecipePrice());
            int dishqty = 1;

            itemsDAO.insertitems(new Items(pid, dishname, dishprotein, dishcarb, dishfat, dishprice, dishqty));
            Toast.makeText(getActivity(), "Added", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getActivity(), "Already in basket", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLikeClick(int position) {
        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "like_db").allowMainThreadQueries().build();
        itemsDAO itemsDAO = db.iteamDAO();
        Boolean check = itemsDAO.is_exist(Integer.parseInt(menu_details.get(position).getRecipeIds()));
        if (check == false) {
            int pid = Integer.parseInt(menu_details.get(position).getRecipeIds());
            String dishname = menu_details.get(position).getRecipeName();
            String dishprotein = menu_details.get(position).getRecipeProtein();
            String dishcarb = menu_details.get(position).getRecipeCarb();
            String dishfat = menu_details.get(position).getRecipeFat();
            int dishprice = Integer.parseInt(menu_details.get(position).getRecipePrice());
            int dishqty = 1;

            itemsDAO.insertitems(new Items(pid, dishname, dishprotein, dishcarb, dishfat, dishprice, dishqty));
            Toast.makeText(getActivity(), "liked", Toast.LENGTH_SHORT).show();

        }

        else {
            Toast.makeText(getActivity(), "Already liked", Toast.LENGTH_SHORT).show();
        }

    }
}