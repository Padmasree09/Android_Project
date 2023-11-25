package com.example.mad_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    private List<Item> itemList;
    private static List<Item> cartItems = new ArrayList<>();
    public MyAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemName;
        TextView itemPrice;
        Button addToCartButton;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemName = itemView.findViewById(R.id.item_name);
            itemPrice = itemView.findViewById(R.id.item_price);
            addToCartButton = itemView.findViewById(R.id.add_to_cart_button);

            addToCartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        // Get the clicked item
                        Item item = cartItems.get(position);

                        // Add the item to the cart
                        cartItems.add(item);
                        addToCartButton.setVisibility(View.INVISIBLE);}


                }
            });

        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item currentItem = itemList.get(position);

        holder.itemImage.setImageResource(Integer.parseInt(currentItem.getImageResource()));
        holder.itemName.setText(currentItem.getName());
        holder.itemPrice.setText("Price: $" + currentItem.getPrice());



    }
    public void filterList(List<Item> filteredList){
        itemList = filteredList;
        notifyDataSetChanged();

    }
    public int getItemCount() {
        return itemList.size();
    }
    public static List<Item> getCartItems(){
        return cartItems;
    }
}
