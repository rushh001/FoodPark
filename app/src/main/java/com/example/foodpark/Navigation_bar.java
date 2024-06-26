package com.example.foodpark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class Navigation_bar extends AppCompatActivity {
    MeowBottomNavigation bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_bar);

        bottomNavigation= findViewById(R.id.bottom_navigation);
        replaceFragment(new HomeFragment());
        bottomNavigation.show(2,true);
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.icon_name_profile__style_false__size_64px));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.baseline_auto_graph_24));

        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {


                switch(model.getId())
                {
                    case 1:
                        replaceFragment(new ProfileFragment());
                        break;
                    case 2:
                        replaceFragment(new HomeFragment());
                        break;
                    case 3:
                        replaceFragment(new TrendingFragment());
                        break;


                }
                return null;
            }
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();

    }
}