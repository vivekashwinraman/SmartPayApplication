package com.example.vraman.smartpay;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import adapters.AccountAdapter;
import modelObjects.AccountObject;

public class AccountsActivity extends BaseActivity {

    private AccountAdapter accountAdapter;
    private ListView mainListView;

    private ArrayList<AccountObject> accountObjectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_accounts, frameLayout);
        mainListView = (ListView) frameLayout.findViewById(R.id.main_list);
        accountObjectList = new ArrayList<AccountObject>();
        accountObjectList.add(new AccountObject("Test Account 1", "1"));
        accountObjectList.add(new AccountObject("Test Account 2", "1"));
        accountAdapter = new AccountAdapter(this,
                R.layout.main_list_row, R.id.row_text, accountObjectList);

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter(accountAdapter);
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
        actionBar.setTitle(R.string.accounts);
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
