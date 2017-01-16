package com.example.zach.calculator;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_about);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.spinner);
        final Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.aboutModes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner.getItemAtPosition(position).equals("Boolean")) {
                    startActivity(new Intent(about.this, BooleanActivity.class));
                }
                else if(spinner.getItemAtPosition(position).equals("Derivative")){
                    startActivity(new Intent(about.this,derivative.class));
                }
                else if(spinner.getItemAtPosition(position).equals("Numerical")){
                    startActivity(new Intent(about.this,MainActivity.class));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                startActivity(new Intent(about.this, about.class));
            }
        });
        return true;
    }
}
