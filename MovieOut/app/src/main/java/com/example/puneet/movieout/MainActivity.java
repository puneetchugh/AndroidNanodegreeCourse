package com.example.puneet.movieout;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    int pos;
    ListView listView;
    ArrayAdapter<String> listAdapters;
    String fragments[] = {"Sort by popularity", "Sort by Rating", "Favorites"};
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.navList);

        listAdapters = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fragments);

        listView.setAdapter(listAdapters);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Fragment fragment;

                pos = position;
                switch (position) {

                    case 0:
                        fragment = new FragmentOne();
                        break;

                    case 1:
                        fragment = new FragmentTwo();
                        break;

                    case 2:
                        fragment = new FragmentThree();
                        break;

                    default:
                        fragment = new FragmentOne();
                }

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.relative_view_nav_drawer, fragment).commit();
                drawerLayout.closeDrawers();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    public int getPos(){
        return pos;
    }


}
