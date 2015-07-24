package com.example.vraman.smartpay;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import adapters.TransactionAdapter;
import modelObjects.TransactionObject;

public class MainActivity extends BaseActivity {

    private TransactionAdapter transactionAdapter;
    private ListView mainListView;

    private ArrayList<TransactionObject> transactionObjectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_main, frameLayout);

        mainListView = (ListView) frameLayout.findViewById(R.id.main_list);
        transactionObjectList = new ArrayList<TransactionObject>();
        transactionObjectList.add(new TransactionObject("Transaction 1", "20", "Account 1", ""));
        transactionObjectList.add(new TransactionObject("Transaction 2", "30", "Account 2", ""));

        transactionAdapter = new TransactionAdapter(this,
                R.layout.main_list_row, R.id.row_text, transactionObjectList);

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter(transactionAdapter);
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                handleOnItemOnSettings(position);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        restoreActionBar();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.app_name);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void handleOnItemOnSettings(int position) {
        switch (position) {
            case 0:
                break;
            default:
                break;
        }
    }

}
