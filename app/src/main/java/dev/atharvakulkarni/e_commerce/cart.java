package dev.atharvakulkarni.e_commerce;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class cart extends AppCompatActivity
{
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        recyclerView = findViewById(R.id.recyclerview);

        cart_product_adapter myAdapter = new cart_product_adapter(recyclerView,cart.this,new ArrayList<Integer>(),new ArrayList<String>(),new ArrayList<String>());
        recyclerView.setAdapter(myAdapter);

        ((cart_product_adapter) recyclerView.getAdapter()).update(R.drawable.shoes1,"Asian WNDR-13 Running Shoes for Men(Green, Grey)","₹300.00");
        ((cart_product_adapter) recyclerView.getAdapter()).update(R.drawable.shoes2,"Asian WNDR-13 Running Shoes for Men(Green, Grey)","₹500.00");


        linearLayoutManager = new LinearLayoutManager(cart.this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}