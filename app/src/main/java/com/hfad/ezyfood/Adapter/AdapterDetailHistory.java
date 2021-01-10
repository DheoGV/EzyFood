package com.hfad.ezyfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.ezyfood.Item.Item;
import com.hfad.ezyfood.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class AdapterDetailHistory extends BaseAdapter {

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    ArrayList<Item> item = new ArrayList<>();
    Context cont;


    public AdapterDetailHistory(Context cont, ArrayList<Item> item) {
        this.cont = cont;
        this.item = item;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(cont).inflate(R.layout.activity_listof_order_complete,parent,false);
        }

        Item itemOrder = (Item) getItem(position);
        ImageView imgOrder = (ImageView)convertView.findViewById(R.id.imgOrderList);
        TextView namaOrder = (TextView)convertView.findViewById(R.id.txtNameOrderList);
        TextView qtyOrder = (TextView)convertView.findViewById(R.id.txtQuantityOrderList);
        TextView priceOrder = (TextView)convertView.findViewById(R.id.txtPriceOrderList);

        DecimalFormat decimal = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols Rp = new DecimalFormatSymbols();
        Rp.setCurrencySymbol("Rp");
        Rp.setMonetaryDecimalSeparator(',');
        Rp.setGroupingSeparator('.');
        decimal.setDecimalFormatSymbols(Rp);

        String quantity = String.valueOf(itemOrder.getQuantity());
        //String price = "Rp." + String.valueOf(itemOrder.getPrice());
        double price = itemOrder.getPrice();
        String priceFormat = decimal.format(price);


        if(itemOrder.getName().equals("Air Mineral")){
            imgOrder.setImageResource(R.drawable.mineral1);
        }else if(itemOrder.getName().equals("Jus Mangga")){
            imgOrder.setImageResource(R.drawable.mango);
        }else if(itemOrder.getName().equals("Jus Apel")){
            imgOrder.setImageResource(R.drawable.apple);
        }else if(itemOrder.getName().equals("Jus Alpukat")){
            imgOrder.setImageResource(R.drawable.alpukatdoang);
        }else if(itemOrder.getName().equals("Fried Rice")){
            imgOrder.setImageResource(R.drawable.friedricedoang);
        }else if(itemOrder.getName().equals("Steak")){
            imgOrder.setImageResource(R.drawable.steakdoang);
        }else if(itemOrder.getName().equals("Ramen")){
            imgOrder.setImageResource(R.drawable.ramendoang);
        }else if(itemOrder.getName().equals("Soup")){
            imgOrder.setImageResource(R.drawable.soupdoang);
        }else if(itemOrder.getName().equals("Potato Chip")){
            imgOrder.setImageResource(R.drawable.potatochipsdoang);
        }else if(itemOrder.getName().equals("French Fries")){
            imgOrder.setImageResource(R.drawable.frenchfriesdoang);
        }else if(itemOrder.getName().equals("Choco Bar")){
            imgOrder.setImageResource(R.drawable.chocolatedoang);
        }else if(itemOrder.getName().equals("Garlic Bread")){
            imgOrder.setImageResource(R.drawable.garlicbreaddoang);
        }

        namaOrder.setText(itemOrder.getName());
        qtyOrder.setText(quantity);
        priceOrder.setText(priceFormat);

        return convertView;
    }
}
