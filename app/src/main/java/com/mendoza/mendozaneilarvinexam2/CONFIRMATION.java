package com.mendoza.mendozaneilarvinexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CONFIRMATION extends AppCompatActivity {
    TextView[] listTV = new TextView[8];
    String selActivity[] = new String[8];
    TextView comment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        setTitle("CONFIRMATION");

        listTV[0] = findViewById(R.id.textView5);
        listTV[1] = findViewById(R.id.textView6);
        listTV[2] = findViewById(R.id.textView7);
        listTV[3] = findViewById(R.id.textView8);
        listTV[4] = findViewById(R.id.textView9);
        listTV[5] = findViewById(R.id.textView12);
        listTV[6] = findViewById(R.id.textView11);
        listTV[7] = findViewById(R.id.textView10);
        comment = findViewById(R.id.textView14);

        FileInputStream reader = null;
        String data="";
        try {
            reader = openFileInput("activities.txt");
            int token;
            while((token = reader.read()) != -1){
                data = data + (char)token;
            }
        } catch (FileNotFoundException e) {
            Log.d("error", "File not found");
        } catch (IOException e) {
            Log.d("error", "IO error");
        }

        String userComment ="";
        try {
            reader = openFileInput("comments.txt");
            int token;
            while((token = reader.read()) != -1){
                userComment = userComment + (char)token;
            }
        } catch (FileNotFoundException e) {
            Log.d("error", "File not found");
        } catch (IOException e) {
            Log.d("error", "IO error");
        }

        selActivity = data.split("-");

        for(int x=0;x<selActivity.length;x++){
            listTV[x].setText(selActivity[x]);
        }

        comment.setText(userComment);

    }

    public void sendSummary(View v){
        Toast.makeText(this, "Registration Sent", Toast.LENGTH_LONG).show();
    }

    public void prevPage(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
