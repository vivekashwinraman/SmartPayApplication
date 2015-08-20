package com.example.vraman.smartpay;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import adapters.CardAdapter;
import modelObjects.CardObject;

public class CardsActivity extends BaseActivity {

    private CardAdapter cardAdapter;
    private ListView mainListView;

    private ArrayList<CardObject> cardObjectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_cards, frameLayout);
        mainListView = (ListView) frameLayout.findViewById(R.id.main_list);
        cardObjectList = new ArrayList<CardObject>();
        cardObjectList.add(new CardObject("Test Card 1", "1"));
        cardObjectList.add(new CardObject("Test Card 2", "1"));
        cardAdapter = new CardAdapter(this,
                R.layout.main_list_row, R.id.row_text, cardObjectList);

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter(cardAdapter);
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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.cards);
    }

    @Override
    public void onBackPressed() {
        callMainActivity();
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
