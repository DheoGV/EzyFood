package com.hfad.ezyfood.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hfad.ezyfood.R;

public class MenuSnackActivity extends AppCompatActivity {
    public static final String Item
            = "com.hfad.ezyfood.Item";

    public void pilPotatoChip(View view) {
        String item = "Potato Chip";
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra(Item, item);
        startActivity(intent);
    }
    public void pilFrenchFries(View view) {
        String item = "French Fries";
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra(Item, item);
        startActivity(intent);
    }
    public void pilChocoBar(View view) {
        String item = "Choco Bar";
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra(Item, item);
        startActivity(intent);
    }
    public void pilGarlicBread(View view) {
        String item = "Garlic Bread";
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra(Item, item);
        startActivity(intent);
    }
    public void pilMyorder(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        startActivity(intent);
    }
    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_snack);
    }
}