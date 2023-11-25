package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText search = findViewById(R.id.searchEditText);
        ImageView cart = findViewById(R.id.cartImageView);


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(String.valueOf(R.drawable.pizza), "Pizza", "10"));
        itemList.add(new Item(String.valueOf(R.drawable.burger), "Burger","15"));
        itemList.add(new Item(String.valueOf(R.drawable.burger), "Biryani","15"));
        itemList.add(new Item(String.valueOf(R.drawable.burger), "Salad","15"));
        itemList.add(new Item(String.valueOf(R.drawable.burger), "Icecreams","15"));
        itemList.add(new Item(String.valueOf(R.drawable.burger), "Pasta","15"));
        itemList.add(new Item(String.valueOf(R.drawable.burger), "Rotis and Curries","15"));
        MyAdapter adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(adapter);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String query = charSequence.toString().toLowerCase();
                List<Item> filteredList = new ArrayList<>();

                for (Item item : itemList) {
                    if (item.getName().toLowerCase().contains(query)) {
                        filteredList.add(item);
                    }

                }
                adapter.filterList(filteredList);
            }
                @Override
                public void afterTextChanged(Editable editable) {
                }
            });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Item> cartItems = MyAdapter.getCartItems();
                Intent intent = new Intent((MainActivity.this), CartActivity.class);
                intent.putParcelableArrayListExtra("cartItems", (ArrayList<? extends Parcelable>) cartItems);
                startActivity(intent);

            }
        });

    }
}