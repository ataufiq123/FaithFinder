package com.example.taufik.masjid.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.taufik.masjid.Gereja;
import com.example.taufik.masjid.Masjid;
import com.example.taufik.masjid.R;
import com.example.taufik.masjid.Wihara;
import com.example.taufik.masjid.adapters.UsersRecyclerAdapter;
import com.example.taufik.masjid.model.User;
import com.example.taufik.masjid.sql.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ginan on 4/28/2017.
 */

public class UsersListActivity extends AppCompatActivity {
    private AppCompatActivity activity = UsersListActivity.this;
    private AppCompatTextView textViewName;
    private RecyclerView recyclerViewUsers;
    private List<User> listUsers;
    private UsersRecyclerAdapter usersRecyclerAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        getSupportActionBar().setTitle("");
        initViews();
        initObjects();

    }
    public void wihara(View view) {
        Intent wihara = new Intent(this, Wihara.class);
        startActivity(wihara);
    }
    //Pindah screen ke masjid
    public void masjid(View view) {
        Intent masjid = new Intent(this, Masjid.class);
        startActivity(masjid);
    }
    //Pindah Screen ke gereja
    public void gereja(View view) {
        Intent gereja = new Intent(this, Gereja.class);
        startActivity(gereja);
    }

    /**
     * This method is to initialize views
     */
    private void initViews() {
        textViewName = (AppCompatTextView) findViewById(R.id.textViewName);
        //recyclerViewUsers = (RecyclerView) findViewById(R.id.recyclerViewUsers);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        listUsers = new ArrayList<>();
        usersRecyclerAdapter = new UsersRecyclerAdapter(listUsers);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewUsers.setLayoutManager(mLayoutManager);
        recyclerViewUsers.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUsers.setHasFixedSize(true);
        recyclerViewUsers.setAdapter(usersRecyclerAdapter);
        databaseHelper = new DatabaseHelper(activity);

        String nameFromIntent = getIntent().getStringExtra("USERNAME");
        textViewName.setText(nameFromIntent);

//        getDataFromSQLite();
    }

    /**
     * This method is to fetch all user records from SQLite
     */
//    private void getDataFromSQLite() {
//        // AsyncTask is used that SQLite operation not blocks the UI Thread.
//        new AsyncTask<Void, Void, Void>() {
//            @Override
//            protected Void doInBackground(Void... params) {
//                listUsers.clear();
//                listUsers.addAll(databaseHelper.getAllUser());
//
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Void aVoid) {
//                super.onPostExecute(aVoid);
//                usersRecyclerAdapter.notifyDataSetChanged();
//            }
//        }.execute();
//    }
}
