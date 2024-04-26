package com.example.foodpark;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodpark.databinding.FragmentBasketBinding;
import com.example.foodpark.databinding.FragmentMenuBinding;

import java.util.ArrayList;

public class MenuFragment extends Fragment {
    FragmentMenuBinding binding;
    ArrayList<menuDetails> menu_details=new ArrayList<>();
    adapterMenu adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        setUpMenu();
        //menu_details=new ArrayList<>();
        adapter=new adapterMenu(menu_details);
        binding.menuRecyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        binding.menuRecyclerview.setLayoutManager(layoutManager);


    }

    private void setUpMenu() {
        String dishes_names[]=getResources().getStringArray(R.array.dishes);
        String protein_gram[]=getResources().getStringArray(R.array.protein);
        String carb_gram[]=getResources().getStringArray(R.array.carbohydrate);
        String fat_gram[]=getResources().getStringArray(R.array.fat);
        String prices_quantity[]=getResources().getStringArray(R.array.prices);

        for (int i=0;i<dishes_names.length;i++)
        {
            menu_details.add(new menuDetails(dishes_names[i],protein_gram[i],carb_gram[i],
                    fat_gram[i],prices_quantity[i]));

        }
    }
}