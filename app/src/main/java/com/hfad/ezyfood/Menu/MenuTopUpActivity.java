package com.hfad.ezyfood.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.ezyfood.R;
import com.hfad.ezyfood.Storage.MoneyStorage;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MenuTopUpActivity extends AppCompatActivity {
    MoneyStorage money = MoneyStorage.getInstance();

    public void pilTopUp(View view) {
        EditText eTxt = findViewById(R.id.inputBiPay);
        if(eTxt.getText().toString().isEmpty()){
            Toast.makeText(this,"Insert the amount!",Toast.LENGTH_SHORT).show();
        }else{
            double amount = Double.parseDouble(eTxt.getText().toString());
            if(amount < 1){
                Toast.makeText(this, "Insert the amount!", Toast.LENGTH_SHORT).show();
            }else if(amount > 10000000){
                Toast.makeText(this, "Maximum Top Up 10 million", Toast.LENGTH_SHORT).show();
            } else{
                amount += money.getMoney();
                money.setMoney(amount);
                Toast.makeText(this, "Money successfully added to your balance!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MenuTopUpActivity.class);
                startActivity(intent);
            }
        }
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
        setContentView(R.layout.activity_menu_top_up);
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
}