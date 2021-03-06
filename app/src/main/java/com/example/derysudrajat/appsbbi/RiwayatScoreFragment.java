package com.example.derysudrajat.appsbbi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RiwayatScoreFragment extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragment);
        final ArrayList<Rwayat> rwayats = new ArrayList<>();
        rwayats.add(new Rwayat("1","9","Hard",1));
        rwayats.add(new Rwayat("9","1","Hard",9));
        rwayats.add(new Rwayat("6","4","Hard",6));
        RiwayatAdapter riwayatAdapter =  new RiwayatAdapter(this, rwayats);
        RecyclerView rv= findViewById(R.id.mainRV);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(riwayatAdapter);
    }


}
