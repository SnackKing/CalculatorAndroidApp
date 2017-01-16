package com.example.zach.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.LinkedList;
import java.util.Queue;


public class BooleanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boolean);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final TextView calc = (TextView) findViewById(R.id.calc);
        final TextView result = (TextView) findViewById(R.id.result);
        Button tru = (Button) findViewById(R.id.tru);
        Button fals = (Button) findViewById(R.id.fals);
        Button and = (Button) findViewById(R.id.and);
        Button or = (Button) findViewById(R.id.or);
        Button nand = (Button) findViewById(R.id.nand);
        Button nor = (Button) findViewById(R.id.nor);
        Button xor = (Button) findViewById(R.id.xor);
        Button leftPar = (Button) findViewById(R.id.leftPar);
        Button rightPar = (Button) findViewById(R.id.rightPar);
        Button not = (Button) findViewById(R.id.not);
        Button equals = (Button) findViewById(R.id.equals);
        Button clear = (Button) findViewById(R.id.clear);

        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display = calc.getText().toString();
                display = display + "T ";
                calc.setText(display);
            }
        });
        fals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display = calc.getText().toString();
                display = display + "F ";
                calc.setText(display);
            }
        });
        not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display = calc.getText().toString();
                display = display + "NOT(";
                calc.setText(display);
            }
        });
        and.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display = calc.getText().toString();
                display = display + "AND ";
                calc.setText(display);
            }
        });
        or.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display = calc.getText().toString();
                display = display + "OR ";
                calc.setText(display);
            }
        });
        nand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display = calc.getText().toString();
                display = display + "NAND ";
                calc.setText(display);
            }
        });
        nor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display = calc.getText().toString();
                display = display + "NOR ";
                calc.setText(display);
            }
        });
        xor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display = calc.getText().toString();
                display = display + "XOR ";
                calc.setText(display);
            }
        });
        leftPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display = calc.getText().toString();
                display = display + "(";
                calc.setText(display);
            }
        });
        rightPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display = calc.getText().toString();
                if(display.charAt(display.length()-1) == ' '){
                    display = display.substring(0,display.length()-1);
                }
                display = display + ")";
                calc.setText(display);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.setText("");
            }
        });
    equals.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String display = calc.getText().toString();
            result.setText("Calculating...");
            Queue<String> tokens = new LinkedList<>();
            String last = tokenize(tokens, display);
            if(last != "AND" && last != "OR" && last != "NAND" && last != "NOR" && last != "XOR"){
                result.setText("Calculating");
                if(tokens.size() > 0){
                    boolean answer = parse(tokens);
                    result.setText(String.valueOf(answer));
                }

            }
            else{
                result.setText("Invalid Input");
            }


        }
    });

    }
    private static boolean parse(Queue<String> tokens){
        return valueOfExpression(tokens);
    }
    private static boolean valueOfExpression(Queue<String> tokens){
        boolean val = true;
        boolean val1 = true;
        if(tokens.peek().equals("(") || tokens.peek().equals(")")){
            tokens.remove();
        }
        if(tokens.size() > 0){
            String bool = tokens.remove();
            if(bool.equals("T")){
                val1 = true;
            }
            else if(bool.equals("F")){
                val1 = false;
            }
            else if(bool.equals("NOT")){
                tokens.remove();
                val1 = !valueOfExpression(tokens);
                tokens.remove();
            }
            val = val1;
            //handle operation if it exists

            if(tokens.size() > 0 && (!tokens.peek().equals("T") || !tokens.peek().equals("F")) && !tokens.peek().equals(")")) {
                String op = tokens.remove();
                boolean val2 = valueOfExpression((tokens));
                if (op.equals("AND")) {
                    val = val1 && val2;
                } else if (op.equals("OR")) {
                    val = val1 || val2;
                } else if (op.equals("NOR")) {
                    val = !(val1 || val2);
                } else if (op.equals("NAND")) {
                    val = !(val1 && val2);
                } else if (op.equals("XOR")) {
                    val = (val1 ^ val2);
                }
            }
        }
        return val;
    }
    private static String tokenize(Queue<String> tokens, String input){
        int i = 0;
        String word = "";
        String lastWord = "";
        while(i < input.length()){
            if(input.charAt(i) != ' ' && input.charAt(i) != '(' && input.charAt(i) != ')'){
                word = word + input.charAt(i);
                i++;
            }
            else{
                if(!word.equals("")) {
                    tokens.add(word);
                    lastWord = word;
                }
                word = "";
                if(input.charAt(i) == ' '){
                 i++;
                }
                if(i < input.length() && (input.charAt(i) == '(' || input.charAt(i) == ')')){
                    tokens.add(String.valueOf(input.charAt(i)));
                    i++;
                }

            }
        }
        return lastWord;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.boolean_main, menu);
        MenuItem item = menu.findItem(R.id.spinnerBoolean);
        final Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.booleanModes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner.getItemAtPosition(position).equals("Numerical")) { //change this later
                    startActivity(new Intent(BooleanActivity.this, MainActivity.class));
                }
                else if(spinner.getItemAtPosition(position).equals("Derivative")){
                    startActivity(new Intent(BooleanActivity.this,derivative.class));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                startActivity(new Intent(BooleanActivity.this, BooleanActivity.class));
            }
        });
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


}
