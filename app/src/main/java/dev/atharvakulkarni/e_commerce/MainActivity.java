package dev.atharvakulkarni.e_commerce;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
{
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

      /*  View decorView = getWindow().getDecorView();
// Hide both the navigation bar and the status bar.
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
// a general rule, you should design your app to hide the status bar whenever you
// hide the navigation bar.
        int uiOptions =  View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);*/

        Drawable background = getResources().getDrawable(R.drawable.gradient_home,getTheme());
       // getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent,getTheme()));
        getWindow().setBackgroundDrawable(background);



        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch(item.getItemId())
                {
                    case R.id.home:

                                        fragment = new Home();
                                        switchfragment(fragment);

                                    break;
                    case R.id.cart:

                                    break;
                    case R.id.wishlist:

                                    break;

                    case R.id.user:

                                        fragment = new User();
                                        switchfragment(fragment);

                                    break;

                }


                return false;
            }
        });

        if (savedInstanceState == null)
        {
            bottomNavigationView.setSelectedItemId(R.id.home); // change to whichever id should be default
        }
    }



    void switchfragment(Fragment fragment)
    {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.framelayout,fragment).commit();
    }
}