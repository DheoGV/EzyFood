package com.hfad.ezyfood.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.ezyfood.Adapter.AdapterOrder;
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
import java.util.Calendar;
import java.util.Date;

public class OrderComplete extends AppCompatActivity {
    ArrayList<Item> list = ItemStorage.getInstance().item;
    AdapterOrder adapterOrderComplete;
    ListView listView;
    private String address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);
        Intent intent = getIntent();
        address = intent.getStringExtra(MapsActivity.Address);

        TextView textView = findViewById(R.id.txtAdress);
        textView.setText(address);
        listView = (ListView)findViewById(R.id.listOrderComplete);
        TextView txtTotalPrice = (TextView)findViewById(R.id.txtTotalPrice);
        txtTotalPrice.setText(total());;
        adapterOrderComplete = new AdapterOrder(this, list);
        listView.setAdapter(adapterOrderComplete);
    }
    HistoryStorage hs = HistoryStorage.getInstance();
    MoneyStorage money = MoneyStorage.getInstance();
    private double hargaTotal;

    private String total() {
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

    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void pilMenuUtama(View view) {
        if (hargaTotal > money.getMoney()){
            Toast.makeText(this, "not enough money!", Toast.LENGTH_SHORT).show();
        }else{
            hargaTotal = money.getMoney() - hargaTotal;
            money.setMoney(hargaTotal);

            Date tempDate = Calendar.getInstance().getTime();
            String dateTime = tempDate.toString().substring(0,15);

           hs.history.add(new History(hs.history.size(),address, dateTime, list ));
           hs.history.get(hs.history.size()-1).allItem.addAll(list);

            list.clear();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }
}