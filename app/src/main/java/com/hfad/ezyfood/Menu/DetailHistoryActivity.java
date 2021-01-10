package com.hfad.ezyfood.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.hfad.ezyfood.Adapter.AdapterDetailHistory;
import com.hfad.ezyfood.Item.History;
import com.hfad.ezyfood.Item.Item;
import com.hfad.ezyfood.R;
import com.hfad.ezyfood.Storage.HistoryStorage;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class DetailHistoryActivity extends AppCompatActivity {

    ArrayList<History> hl = HistoryStorage.getInstance().history;
    ArrayList<Item> list = new ArrayList<>();
    Intent intent;
    AdapterDetailHistory adapter;
    ListView listview;

    private String Total() {
        String totalPrice;
        double hargaTotal = 0;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_history);

        TextView txtAddress = findViewById(R.id.txtAdress);
        TextView txtDateTime = findViewById(R.id.txtDateTime);
        TextView txtTotalPrice = findViewById(R.id.txtTotalPrice);
        intent = getIntent();
        int hisid = intent.getIntExtra(MenuHistoryActivity.historyID, 0);
        list = hl.get(hisid).allItem;
        txtAddress.setText(hl.get(hisid).getAddress());
        txtDateTime.setText(hl.get(hisid).getDate());
        txtTotalPrice.setText(Total());
        listview = (ListView)findViewById(R.id.listHistoryDetail);
        adapter = new AdapterDetailHistory(this, list);
        listview.setAdapter(adapter);
    }

    public void pilMenuUtama(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}