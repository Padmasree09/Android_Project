package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
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
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener(){
            public void onItemClick(int position) {
                int[] cartLocation = new int[2];
                cart.getLocationOnScreen(cartLocation);
                RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForAdapterPosition(position);
                if (viewHolder instanceof MyAdapter.ViewHolder) {
                    ImageView doraemonImage = ((MyAdapter.ViewHolder) viewHolder).doraemonImage;

                    // Calculate the translation values for the animation
                    float translateX = cartLocation[0] - doraemonImage.getLeft();
                    float translateY = cartLocation[1] - doraemonImage.getTop();

                    // Start an ObjectAnimator to move Doraemon to the cart image position
                    ObjectAnimator moveX = ObjectAnimator.ofFloat(doraemonImage, "translationX", translateX);
                    ObjectAnimator moveY = ObjectAnimator.ofFloat(doraemonImage, "translationY", translateY);

                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(moveX, moveY);
                    animatorSet.setDuration(1000); // Set the duration as per your animation
                    animatorSet.start();
                }
            }
        });
            }
        }