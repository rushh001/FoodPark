package com.example.foodpark;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodpark.databinding.FragmentBasketBinding;
import com.example.foodpark.databinding.FragmentFavouriteBinding;
import com.example.foodpark.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class FavouriteFragment extends Fragment implements buttonClickListner {

    FragmentFavouriteBinding binding;
    //ArrayList<basketDetails> basket_Details= new ArrayList<>();
    adapterFavourite adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavouriteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //getFragmentManager().beginTransaction().detach(FavouriteFragment.this).attach(FavouriteFragment.this).commit();
        //menu_details=new ArrayList<>();
        getroomdata();
        adapter.notifyDataSetChanged();
    }

    private void getroomdata() {
        AppDatabase db = Room.databaseBuilder(getContext(),
                AppDatabase.class, "like_db").allowMainThreadQueries().build();
        itemsDAO itemsDAO=db.iteamDAO();
        List<Items> items=itemsDAO.getallitems();
        adapter=new adapterFavourite(items,this);
        binding.menuRecyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        binding.menuRecyclerview.setLayoutManager(layoutManager);


    }

    @Override
    public void onButtonClick(int position) {
        Toast.makeText(getActivity(),"Removed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLikeClick(int position) {
       // Toast.makeText(getActivity(),"Unliked",Toast.LENGTH_SHORT).show();
    }
}