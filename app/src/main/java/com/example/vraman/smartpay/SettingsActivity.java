package com.example.vraman.smartpay;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import adapters.SettingsAdapter;
import modelObjects.SettingsObject;

public class SettingsActivity extends MainActivity {

    private SettingsAdapter settingsAdapter;
    private ListView mainListView;
    private ArrayList<SettingsObject> settingsObjectList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        navDrawerIcon = R.drawable.back;
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_settings, frameLayout);
        mainListView = (ListView) frameLayout.findViewById(R.id.main_list);
        settingsObjectList = new ArrayList<SettingsObject>();
        settingsObjectList.add(new SettingsObject("Smart Pay PIN", ""));
        settingsObjectList.add(new SettingsObject("Smart Pay Status", "30"));
        settingsAdapter = new SettingsAdapter(this,
                R.layout.main_list_row, R.id.row_text, settingsObjectList);

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter(settingsAdapter);
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
        switch (item.getItemId()) {
            case android.R.id.home:
                callMainActivity();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void restoreActionBar() {
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.settings);
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
