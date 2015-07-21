package com.example.vraman.smartpay;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

public class AddPayActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        navDrawerIcon = R.drawable.back;
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_add_pay, frameLayout);
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
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Pay now");
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
