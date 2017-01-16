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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;

public class derivative extends AppCompatActivity {
    boolean enableZero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derivative);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Calculator");


        enableZero = false;
        final TextView calc = (TextView) findViewById(R.id.calc);
        final TextView result = (TextView) findViewById(R.id.result);
        Button zero = (Button) findViewById(R.id.zero);
        Button one = (Button) findViewById(R.id.one);
        Button two = (Button) findViewById(R.id.two);
        Button three = (Button) findViewById(R.id.three);
        Button four = (Button) findViewById(R.id.four);
        Button five = (Button) findViewById(R.id.five);
        Button six = (Button) findViewById(R.id.six);
        Button seven = (Button) findViewById(R.id.seven);
        Button eight = (Button) findViewById(R.id.eight);
        Button nine = (Button) findViewById(R.id.nine);
        Button add = (Button) findViewById(R.id.add);
        Button subtract = (Button) findViewById(R.id.subtract);
        Button multiply = (Button) findViewById(R.id.multiply);
        Button equal = (Button) findViewById(R.id.equal);
        Button divide = (Button) findViewById(R.id.divide);
        Button clear = (Button) findViewById(R.id.clear);
        Button delete = (Button) findViewById(R.id.delete);
        Button var = (Button) findViewById(R.id.var);
        Button percent = (Button) findViewById(R.id.percent);
        Button sqrt = (Button) findViewById(R.id.sqrt);
        Button power = (Button) findViewById(R.id.power);
        Button leftPar = (Button) findViewById((R.id.leftPar));
        Button rightPar = (Button) findViewById(R.id.rightPar);




        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(enableZero){
                    String display = calc.getText().toString();
                    display = display + "0";
                    calc.setText(display);

                }
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableZero = true;
                String display = calc.getText().toString();
                display = display + "1";
                calc.setText(display);

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableZero = true;
                String display = calc.getText().toString();
                display = display + "2";
                calc.setText(display);


            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableZero = true;
                String display = calc.getText().toString();
                display = display + "3";
                calc.setText(display);


            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableZero = true;
                String display = calc.getText().toString();
                display = display + "4";
                calc.setText(display);

            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableZero = true;
                String display = calc.getText().toString();
                display = display + "5";
                calc.setText(display);

            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableZero = true;
                String display = calc.getText().toString();
                display = display + "6";
                calc.setText(display);

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableZero = true;
                String display = calc.getText().toString();
                display = display + "7";
                calc.setText(display);

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableZero = true;
                String display = calc.getText().toString();
                display = display + "8";
                calc.setText(display);

            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableZero = true;
                String display = calc.getText().toString();
                display = display + "9";
                calc.setText(display);

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableZero = true;
                String display = calc.getText().toString();
                display = display + "+";
                calc.setText(display);


            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableZero = true;
                String display = calc.getText().toString();
                display = display + "-";
                calc.setText(display);

            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableZero = true;
                String display = calc.getText().toString();
                display = display + "X";
                calc.setText(display);

            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableZero = true;
                String display = calc.getText().toString();
                display = display + "/";
                calc.setText(display);

            }
        });
        var.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableZero = true;
                String display = calc.getText().toString();
                display = display + "x";
                calc.setText(display);

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableZero = false;
                calc.setText("");
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableZero = true;
                String display = calc.getText().toString();
                if(!display.equals("")) {
                    calc.setText(display.substring(0, display.length() - 1));
                }

            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableZero = true;
                String display = calc.getText().toString();
                display = display + "%";
                calc.setText(display);
            }
        });
        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableZero = false;
                String display = calc.getText().toString();
                display = display + "\u221A" + "(";
                calc.setText(display);
            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display = calc.getText().toString();
                display = display + "^(";
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
                display = display + ")";
                calc.setText(display);

            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display = calc.getText().toString();
                char last = display.charAt(display.length()-1);
                if( !(last == '+' || last == '-' || last == 'X' || last == '/' || last =='.' || last == '^')){
                    result.setText("Calculating...");
                    Queue<String> tokens = new LinkedList<>();
                    tokenize(tokens, display);
                    String val = "";
                    if(tokens.size() > 0) {
                        val = parse(tokens);
                    }
                    result.setText(val);
                }
                else{
                    result.setText("Invalid Input");
                }
            }
        });

    }
    public static void tokenize(Queue<String> tokens, String input){
        int i = 0;
        while(i < input.length()) {
            if (i < input.length() && (Character.isDigit(input.charAt(i)))) {
                String current = "";
                while((i < input.length()) && (Character.isDigit(input.charAt(i)))){
                    current = current + input.charAt(i);
                    i++;
                }
                tokens.add(current);
            } else {
                tokens.add(String.valueOf(input.charAt(i)));
                i++;
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.derivative_main, menu);
        MenuItem item = menu.findItem(R.id.spinner);
        final Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.derivativeModes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner.getItemAtPosition(position).equals("Boolean")) {
                    startActivity(new Intent(derivative.this, BooleanActivity.class));
                }
                else if(spinner.getItemAtPosition(position).equals("Numerical")) {
                    startActivity(new Intent(derivative.this, MainActivity.class));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                startActivity(new Intent(derivative.this, derivative.class));
            }
        });
        return true;
    }




    public String parse(Queue<String> tokens){
        return valueOfExpr(tokens);
    }
    private static String valueOfExpr(Queue<String> ts) {
        String value = valueOfTerm(ts);

        while (ts.size() != 0 && (ts.peek().equals(("+")) ||
                ts.peek().equals("-"))) {
            String op = ts.peek();
            ts.remove();
            if (op.equals("+")) {
                String term = valueOfTerm(ts);
                if(!term.equals("0")) {
                    value = value + "+" + term;
                }

            } else /* "-" */ {
                String term = valueOfTerm(ts);
                if(!term.equals("0")) {
                    value = value + "-" + term;
                }
            }
        }

        return value;
    }
    private static String valueOfTerm(Queue<String> ts){
        String value = valueOfFactor(ts);

        while (ts.size() != 0 && (ts.peek().equals("x") ||
                ts.peek().equals("/"))) {
            String op = ts.peek();
            ts.remove();
            if (op.equals("x")) {
                Queue<String> val = new LinkedList<>();
                tokenize(val,value);
                value = valueOfFactor(val) + "*" + ts + ts + "*" + valueOfFactor(ts);
            } else /* "/" */ {
//                value = value / valueOfFactor(ts);
            }
        }

        return value;
    }
    private static String valueOfFactor(Queue<String> ts) {
        String value = "";
        if (ts.peek().equals("(")) {
            ts.remove();
            value = valueOfExpr(ts);
            ts.remove();
        } else {
//            if(ts.size() != 0 && (ts.peek().equals("\u221A"))){
//                ts.remove();
//                double root = valueOfFactor(ts);
//                value = Math.sqrt(root);
//            }
//            else {
            int num = 1;
            if(!ts.peek().equals("x")){
                num = Integer.parseInt(ts.peek());
                ts.remove();
            }
            value = String.valueOf(num);
            if(ts.size() != 0 && ts.peek().equals("x")) {
                ts.remove();
                if (ts.size() != 0 && (ts.peek().equals("^"))) {
                    ts.remove();
                    ts.remove();
                    int pow = Integer.parseInt(ts.remove());
                    ts.remove();
                    num = num * pow;
                    value = Integer.toString(num) + "x";
                    if(pow != 1 && pow != 2){
                        value = value +  "^(" + Integer.toString(pow-1) + ")";
                    }
                }

            }
            else{
                value = "0";
            }

            }


        return value;
    }



}





