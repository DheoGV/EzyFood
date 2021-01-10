package com.hfad.ezyfood.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hfad.ezyfood.R;

public class MenuDrinkActivity extends AppCompatActivity {
    public static final String Item
            = "com.hfad.ezyfood.Item";

    public void pilMineral(View view) {
        String item = "Air Mineral";
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra(Item, item);
        startActivity(intent);
    }
    public void pilMangga(View view) {
        String item = "Jus Mangga";
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra(Item, item);
        startActivity(intent);
    }
    public void pilApel(View view) {
        String item = "Jus Apel";
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra(Item, item);
        startActivity(intent);
    }
    public void pilAlpukat(View view) {
        String item = "Jus Alpukat";
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
        setContentView(R.layout.activity_menu_drink);
    }

}