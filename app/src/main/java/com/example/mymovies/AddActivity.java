package com.example.mymovies;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    private EditText titleBox;
    private EditText directorBox;
    private Button addButton;
    private boolean add;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        titleBox = findViewById(R.id.titleBox);
        directorBox = findViewById(R.id.directorBox);
        addButton = findViewById(R.id.addButton);
        Intent i = getIntent();
        boolean add = i.getBooleanExtra("ADD", true);
        if(add){
            addButton.setText("ADD");
        }
        else{
            addButton.setText("EDIT");
            titleBox.setText(i.getStringExtra("TITLE"));
            directorBox.setText(i.getStringExtra("DIRECTOR"));
        }

    }

    public void addPressed(View v){
        String title = titleBox.getText().toString();
        String director = directorBox.getText().toString();
        DatabaseManager dbm = new DatabaseManager(this);
        dbm.insert(title, director);
        if(add){
            dbm.insert(title, director);
        }
        else{
            dbm.updateByTitle(title, director);
        }

        finish();
    }

    public void onPause(){ super.onPause(); }

    public void onResume() { super.onResume(); }

    public void onBackPressed(){
        finish();
    }

}
