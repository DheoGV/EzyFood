package com.hfad.ezyfood.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hfad.ezyfood.R;

public class MenuFoodActivity extends AppCompatActivity {
    public static final String Item
            = "com.hfad.ezyfood.Item";

    public void pilFriedRice(View view) {
        String item = "Fried Rice";
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra(Item, item);
        startActivity(intent);
    }
    public void pilSteak(View view) {
        String item = "Steak";
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra(Item, item);
        startActivity(intent);
    }
    public void pilRamen(View view) {
        String item = "Ramen";
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra(Item, item);
        startActivity(intent);
    }
    public void pilSoup(View view) {
        String item = "Soup";
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
        setContentView(R.layout.activity_menu_food);
    }
}