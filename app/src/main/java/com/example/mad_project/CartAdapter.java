package com.example.mad_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mad_project.Item;
import com.example.mad_project.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<Item> cartItems;

    public CartAdapter(List<Item> cartItems) {
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Item currentItem = cartItems.get(position);

        // Set item details in the view holder
        holder.itemNameTextView.setText(currentItem.getName());
        holder.itemPriceTextView.setText("Price: $" + currentItem.getPrice());
        // Set the item image (assuming getImageResource() returns the image resource ID)
        holder.itemImageView.setImageResource(Integer.parseInt(currentItem.getImageResource()));

        // Implement logic for increment/decrement buttons (example, you can use onClickListeners)
        holder.decrementButton.setOnClickListener(view -> {
            // Handle decrement logic here
        });

        holder.incrementButton.setOnClickListener(view -> {
            // Handle increment logic here
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImageView;
        TextView itemNameTextView;
        TextView itemPriceTextView;
        Button decrementButton;
        Button incrementButton;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize views from item_cart.xml
            itemImageView = itemView.findViewById(R.id.itemImage);
            itemNameTextView = itemView.findViewById(R.id.itemName);
            itemPriceTextView = itemView.findViewById(R.id.itemPrice);
            decrementButton = itemView.findViewById(R.id.decrementButton);
            incrementButton = itemView.findViewById(R.id.incrementButton);
        }
    }
}
