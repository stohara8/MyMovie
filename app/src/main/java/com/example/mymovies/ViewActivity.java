package com.example.mymovies;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewActivity extends AppCompatActivity {

    private TextView titleView;
    private TextView directorView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        titleView = findViewById(R.id.titleView);
        directorView = findViewById(R.id.directorView);

        DatabaseManager dbm = new DatabaseManager(this);
        Intent i = getIntent();
        String title = i.getStringExtra("TITLE");
        String[] entry = dbm.get(title);
        titleView.setText(entry[0]);
        directorView.setText(entry[1]);

    }

    public void onPause(){ super.onPause(); }

    public void onResume() { super.onResume(); }

    public void onBackPressed(){
        finish();
    }


}
