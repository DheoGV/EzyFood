package com.hfad.ezyfood.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hfad.ezyfood.R;
import com.hfad.ezyfood.Storage.MoneyStorage;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MainActivity extends AppCompatActivity {

    public void pilDrink(View view) {
        Intent intent = new Intent(this, MenuDrinkActivity.class);
        startActivity(intent);
    }

    public void pilFood(View view) {
        Intent intent = new Intent(this, MenuFoodActivity.class);
        startActivity(intent);
    }

    public void pilTopUp(View view) {
        Intent intent = new Intent(this, MenuTopUpActivity.class);
        startActivity(intent);
    }

    public void pilSnack(View view) {
        Intent intent = new Intent(this, MenuSnackActivity.class);
        startActivity(intent);
    }


    public void pilMyorder(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtView = findViewById(R.id.txtMoney);

        double money = MoneyStorage.getInstance().getMoney();
        DecimalFormat decimal = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols Rp = new DecimalFormatSymbols();
        Rp.setCurrencySymbol("Rp");
        Rp.setMonetaryDecimalSeparator(',');
        Rp.setGroupingSeparator('.');
        decimal.setDecimalFormatSymbols(Rp);

        String newMoney = decimal.format(money);
        txtView.setText(newMoney);
    }


    public void pilHistory(View view) {
        Intent intent = new Intent(this, MenuHistoryActivity.class);
        startActivity(intent);
    }
}