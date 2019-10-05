package com.mendoza.mendozaneilarvinexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);
        cb5 = findViewById(R.id.checkBox5);
        cb6 = findViewById(R.id.checkBox6);
        cb7 = findViewById(R.id.checkBox7);
        cb8 = findViewById(R.id.checkBox8);
        et1 = findViewById(R.id.editText);
    }

    public void saveActivity(View v){
        String cbSave1 = cb1.getText().toString() + "-";
        String cbSave2 = cb2.getText().toString() + "-";
        String cbSave3 = cb3.getText().toString() + "-";
        String cbSave4 = cb4.getText().toString() + "-";
        String cbSave5 = cb5.getText().toString() + "-";
        String cbSave6 = cb6.getText().toString() + "-";
        String cbSave7 = cb7.getText().toString() + "-";
        String cbSave8 = cb8.getText().toString() + "-";
        String et1save = et1.getText().toString();
        FileOutputStream writer = null;
        try {
            writer = openFileOutput("activities.txt",MODE_PRIVATE);
            if (cb1.isChecked()){
                writer.write(cbSave1.getBytes());
            }
            if (cb2.isChecked()){
                writer.write(cbSave2.getBytes());
            }
            if (cb3.isChecked()){
                writer.write(cbSave3.getBytes());
            }
            if (cb4.isChecked()){
                writer.write(cbSave4.getBytes());
            }
            if (cb5.isChecked()){
                writer.write(cbSave5.getBytes());
            }
            if (cb6.isChecked()){
                writer.write(cbSave6.getBytes());
            }
            if (cb7.isChecked()){
                writer.write(cbSave7.getBytes());
            }
            if (cb8.isChecked()){
                writer.write(cbSave8.getBytes());
            }

        } catch (FileNotFoundException e) {
            Log.d("error", "File not found");
        } catch (IOException e) {
            Log.d("error", "IO error");
        }finally{
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("error", "File not found");
            }
        }

        try {
            writer = openFileOutput("comments.txt",MODE_PRIVATE);
            writer.write(et1save.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("error", "File not found");
        } catch (IOException e) {
            Log.d("error", "IO error");
        }finally{
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("error", "File not found");
            }
        }
        Toast.makeText(this, "Data saved...", Toast.LENGTH_LONG).show();
    }

    public void nextPage(View v){
        Intent i = new Intent(this, CONFIRMATION.class);
        startActivity(i);
    }
}
