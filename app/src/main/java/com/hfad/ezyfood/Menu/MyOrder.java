package com.hfad.ezyfood.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.ezyfood.Adapter.Adapter;
import com.hfad.ezyfood.Item.History;
import com.hfad.ezyfood.Item.Item;
import com.hfad.ezyfood.MapsActivity;
import com.hfad.ezyfood.R;
import com.hfad.ezyfood.Storage.HistoryStorage;
import com.hfad.ezyfood.Storage.ItemStorage;
import com.hfad.ezyfood.Storage.MoneyStorage;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class MyOrder extends AppCompatActivity {
    ArrayList<Item> list = ItemStorage.getInstance().item;
    private double hargaTotal;

    private String Total() {
        hargaTotal = 0;
        String totalPrice;
        for(Item item : list){
            hargaTotal += (item.getPrice()* item.getQuantity());
        }

        DecimalFormat decimal = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols Rp = new DecimalFormatSymbols();
        Rp.setCurrencySymbol("Rp");
        Rp.setMonetaryDecimalSeparator(',');
        Rp.setGroupingSeparator('.');
        decimal.setDecimalFormatSymbols(Rp);

        totalPrice = decimal.format(hargaTotal);
        return totalPrice;
    }

    ArrayList<History> historyList = HistoryStorage.getInstance().history;
    Adapter adapterItem;
    ListView listView;
    Intent intent;
    MoneyStorage money = MoneyStorage.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        listView = (ListView)findViewById(R.id.listView);
        TextView txtTotalPrice = (TextView)findViewById(R.id.txtTotalPrice);
        TextView txtView = findViewById(R.id.txtMoney);
        Button butt = (Button)findViewById(R.id.buttonPay);

        double money = MoneyStorage.getInstance().getMoney();
        DecimalFormat decimal = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols Rp = new DecimalFormatSymbols();
        Rp.setCurrencySymbol("Rp");
        Rp.setMonetaryDecimalSeparator(',');
        Rp.setGroupingSeparator('.');
        decimal.setDecimalFormatSymbols(Rp);

        String newMoney = decimal.format(money);
        txtView.setText(newMoney);

        if(getIntent().getExtras() != null){
            intent = getIntent();
            String name = intent.getStringExtra(OrderActivity.Name);

            String tempQty = intent.getStringExtra(OrderActivity.Quantity);
            int quantity = Integer.parseInt(tempQty);

            String tempPrice = intent.getStringExtra(OrderActivity.Price);
            int price = Integer.parseInt(tempPrice);

            list.add(new Item(name, quantity, price));

            txtTotalPrice.setText(Total());
            adapterItem = new Adapter(this, list);
            listView.setAdapter(adapterItem);
        }else{
            if(list.isEmpty()){
                butt.setVisibility(View.GONE);
                Toast toast = Toast.makeText(getApplicationContext(),"You don't choose anything!", Toast.LENGTH_SHORT);toast.show();
            }else{
                butt.setVisibility(View.VISIBLE);
                txtTotalPrice.setText("Rp" + Total());;
                adapterItem = new Adapter(this, list);
                listView.setAdapter(adapterItem);
            }
        }
    }


    public void pilPay(View view) {
        if(hargaTotal > money.getMoney()){
            Toast.makeText(this, "not enough money!", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}