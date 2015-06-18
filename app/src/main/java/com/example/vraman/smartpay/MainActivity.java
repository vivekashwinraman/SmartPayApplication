package com.example.vraman.smartpay;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;

import java.util.ArrayList;

import fragments.AccountsFragment;
import fragments.NavigationDrawerFragment;
import fragments.AddPayFragment;
import fragments.TransactionsFragment;
import modelObjects.AccountObject;
import modelObjects.TransactionObject;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch(position) {
            case 0:
                ArrayList<AccountObject> accountObjectList = new ArrayList<AccountObject>();
                accountObjectList.add(new AccountObject("Test Account 1","1"));
                accountObjectList.add(new AccountObject("Test Account 2", "1"));
                fragmentManager.beginTransaction()
                        .replace(R.id.container, AccountsFragment.newInstance(position + 1, accountObjectList))
                        .commit();
                break;
            case 1:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, AddPayFragment.newInstance(position + 1))
                        .commit();
                break;
            case 2:
                ArrayList<TransactionObject> transactionObjectList = new ArrayList<TransactionObject>();
                transactionObjectList.add(new TransactionObject("Transaction 1","20","Account 1",""));
                transactionObjectList.add(new TransactionObject("Transaction 2", "30", "Account 2", ""));
                fragmentManager.beginTransaction()
                        .replace(R.id.container, TransactionsFragment.newInstance(position + 1, transactionObjectList))
                        .commit();
                break;
            default:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, AddPayFragment.newInstance(position + 1))
                        .commit();
                break;

        }
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.accounts);
                break;
            case 2:
                mTitle = getString(R.string.pay_now);
                break;
            case 3:
                mTitle = getString(R.string.transactions);
                break;
            case 4:
                mTitle = getString(R.string.logout);
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
