package com.hfad.ezyfood.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.ezyfood.R;

public class OrderActivity extends AppCompatActivity {
    public String name;
    public String price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        String item = intent.getStringExtra(MenuDrinkActivity.Item);

        ImageView imageView = findViewById(R.id.imgOrder);
        TextView txtOrder = findViewById(R.id.txtOrder);
        txtOrder.setText(item);
        TextView priceOrder = findViewById(R.id.priceOrder);

        if(item.equals("Air Mineral")){
            name = item;
            price = "5000";
            priceOrder.setText("Rp5.000");
            imageView.setImageResource(R.drawable.mineral1);
        }else if(item.equals("Jus Mangga")){
            name = item;
            price = "8000";
            priceOrder.setText("Rp8.000");
            imageView.setImageResource(R.drawable.mango);
        }else if(item.equals("Jus Apel")){
            name = item;
            price = "9000";
            priceOrder.setText("Rp9.000");
            imageView.setImageResource(R.drawable.apple);
        }else if(item.equals("Jus Alpukat")){
            name = item;
            price = "10000";
            priceOrder.setText("Rp10.000");
            imageView.setImageResource(R.drawable.alpukatdoang);
        }else if(item.equals("Fried Rice")){
            name = item;
            price = "30000";
            priceOrder.setText("Rp30.000");
            imageView.setImageResource(R.drawable.friedricedoang);
        }else if(item.equals("Steak")){
            name = item;
            price = "40000";
            priceOrder.setText("Rp40.000");
            imageView.setImageResource(R.drawable.steakdoang);
        }else if(item.equals("Ramen")){
            name = item;
            price = "28000";
            priceOrder.setText("Rp28.000");
            imageView.setImageResource(R.drawable.ramendoang);
        }else if(item.equals("Soup")){
            name = item;
            price = "20000";
            priceOrder.setText("Rp20.000");
            imageView.setImageResource(R.drawable.soupdoang);
        }else if(item.equals("Potato Chip")){
            name = item;
            price = "11000";
            priceOrder.setText("Rp11.000");
            imageView.setImageResource(R.drawable.potatochipsdoang);
        }else if(item.equals("French Fries")){
            name = item;
            price = "18000";
            priceOrder.setText("Rp18.000");
            imageView.setImageResource(R.drawable.frenchfriesdoang);
        }else if(item.equals("Choco Bar")){
            name = item;
            price = "20000";
            priceOrder.setText("Rp10.000");
            imageView.setImageResource(R.drawable.chocolatedoang);
        }else if(item.equals("Garlic Bread")){
            name = item;
            price = "19500";
            priceOrder.setText("Rp19.500");
            imageView.setImageResource(R.drawable.garlicbreaddoang);
        }
    }

    public void pilMyorder(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        startActivity(intent);
    }

    public void pilOrderMore(View view) {
        Intent intent = new Intent(this, MenuDrinkActivity.class);
        startActivity(intent);
    }

    public static final String Name
            = "com.hfad.ezyfood.Name";
    public static final String Price
            = "com.hfad.ezyfood.Price";
    public static final String Quantity
            = "com.hfad.ezyfood.Quantity";

    public void pilOrder(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        EditText eTxt = findViewById(R.id.inputQty);
        String quantity = eTxt.getText().toString();
        if(quantity.isEmpty()){
            Toast toast = Toast.makeText(getApplicationContext(),"Please insert at least 1 item",Toast.LENGTH_SHORT);toast.show();
        }else{
            intent.putExtra(Name, name);
            intent.putExtra(Quantity, quantity);
            intent.putExtra(Price, price);
            startActivity(intent);
        }
    }
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}