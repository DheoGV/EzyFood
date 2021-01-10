package com.hfad.ezyfood.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.hfad.ezyfood.Item.History;
import com.hfad.ezyfood.Menu.DetailHistoryActivity;
import com.hfad.ezyfood.R;

import java.util.ArrayList;

public class AdapterHistory extends BaseAdapter {

    @Override
    public int getCount() {
        return history.size();
    }

    @Override
    public Object getItem(int position) {
        return history.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    ArrayList<History> history = new ArrayList<>();
    Context cont;
    public static final String historyID = "com.hfad.ezyfood.historyID";

    public AdapterHistory(Context cont, ArrayList<History> history) {
        this.cont = cont;
        this.history = history;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(cont).inflate(R.layout.activity_list_of_history,parent,false);
        }

        History historyOrder = (History) getItem(position);
        Button btndetails = (Button)convertView.findViewById(R.id.btnDetails);
        TextView txtdate = (TextView)convertView.findViewById(R.id.txtDateTime);
        TextView txtaddress = (TextView)convertView.findViewById(R.id.txtAdress);


        txtdate.setText(historyOrder.getDate());
        txtaddress.setText(historyOrder.getAddress());

        btndetails.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cont, DetailHistoryActivity.class);
                int itemid = (int) getItemId(position);
                intent.putExtra(historyID, itemid);
                cont.startActivity(intent);
            }
        });

        return convertView;
    }


}
