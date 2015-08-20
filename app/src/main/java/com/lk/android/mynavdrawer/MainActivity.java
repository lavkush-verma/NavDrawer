package com.lk.android.mynavdrawer;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements NavDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavDrawerFragment mNavDrawerFragment;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private CharSequence mTitle;

    private void initViews() {
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        setActionBarWithDrawer();
    }

    private void setActionBarWithDrawer() {
        // Set the ActionBar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mNavDrawerFragment = (NavDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);

        // Set up the drawer.
        mNavDrawerFragment.setUp(R.id.fragment_drawer, mDrawerLayout, mToolbar);
        // populate the navigation drawer
        mNavDrawerFragment.setUserData("Lavkush Verma", "lavkush2oct@google.com", BitmapFactory.decodeResource(getResources(), R.drawable.avatar));
    }

    public void onFragmentAttached(int number) {
        switch (number) {
            case 0:
                mTitle = getString(R.string.action_settings);
                break;
        }
        restoreActionBar();
    }

    public void restoreActionBar() {
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle(mTitle);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle = getTitle();
        initViews();
    }

    @Override
    public void onNavDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onBackPressed() {
        if (mNavDrawerFragment.isDrawerOpen()) {
            mNavDrawerFragment.closeDrawer();
        } else {
            if (getFragmentManager().getBackStackEntryCount() > 1) {
                getFragmentManager().popBackStack();
            } else {
                super.onBackPressed();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
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
