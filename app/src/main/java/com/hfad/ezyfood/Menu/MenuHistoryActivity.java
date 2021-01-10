package com.hfad.ezyfood.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.hfad.ezyfood.Adapter.AdapterHistory;
import com.hfad.ezyfood.Item.History;
import com.hfad.ezyfood.R;
import com.hfad.ezyfood.Storage.HistoryStorage;

import java.util.ArrayList;

public class MenuHistoryActivity extends AppCompatActivity {
    public static final String historyID
            = "com.hfad.ezyfood.historyID";
    ArrayList<History> hl = HistoryStorage.getInstance().history;
    AdapterHistory adapter;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_history);
        listview = (ListView)findViewById(R.id.listViewHistory);
        if(hl.isEmpty()){
            Toast.makeText(this, "There is no history transaction!", Toast.LENGTH_SHORT).show();
        }else{
            adapter = new AdapterHistory(this,hl);
            listview.setAdapter(adapter);
        }
    }
}