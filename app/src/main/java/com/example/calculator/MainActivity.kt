package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*;
import android.util.Log;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        val button0: Button = findViewById(R.id.button0);
        val button1: Button = findViewById(R.id.button1);
        val button2: Button = findViewById(R.id.button2);
        val button3: Button = findViewById(R.id.button3);
        val button4: Button = findViewById(R.id.button4);
        val button5: Button = findViewById(R.id.button5);
        val button6: Button = findViewById(R.id.button6);
        val button7: Button = findViewById(R.id.button7);
        val button8: Button = findViewById(R.id.button8);
        val button9: Button = findViewById(R.id.button9);
        val buttonplus: Button = findViewById(R.id.buttonplus);
        val buttonminus: Button = findViewById(R.id.buttonminus);
        val buttonmultiply: Button = findViewById(R.id.buttonmultiply);
        val buttondivide: Button = findViewById(R.id.buttondivide);
        val buttonequal: Button = findViewById(R.id.buttonequal);
        var buttondel: Button = findViewById(R.id.buttondel);
        val outputdisplay: TextView = findViewById(R.id.output);
        var s: String = "";
        outputdisplay.setText(s);
        button0.setOnClickListener {
            s += "0";
            outputdisplay.setText(s);
        }
        button1.setOnClickListener {
            s += "1";
            outputdisplay.setText(s);
        }
        button2.setOnClickListener {
            s += "2";
            outputdisplay.setText(s);
        }
        button3.setOnClickListener {
            s += "3";
            outputdisplay.setText(s);
        }
        button4.setOnClickListener {
            s += "4";
            outputdisplay.setText(s);
        }
        button5.setOnClickListener {
            s += "5";
            outputdisplay.setText(s);
        }
        button6.setOnClickListener {
            s += "6";
            outputdisplay.setText(s);
        }
        button7.setOnClickListener {
            s += "7";
            outputdisplay.setText(s);
        }
        button8.setOnClickListener {
            s += "8";
            outputdisplay.setText(s);
        }
        button9.setOnClickListener {
            s += "9";
            outputdisplay.setText(s);
        }
        buttonplus.setOnClickListener {
            s += "+";
            outputdisplay.setText(s);
        }
        buttonminus.setOnClickListener {
            s += "-";
            outputdisplay.setText(s);
        }
        buttonmultiply.setOnClickListener {
            s += "*";
            outputdisplay.setText(s);
        }
        buttondivide.setOnClickListener {
            s += "/";
            outputdisplay.setText(s);
        }
        buttondel.setOnClickListener {
            if(s.length > 0){
                s = s.substring(0, s.length-1);
            }
            outputdisplay.setText(s);
        }
        buttonequal.setOnClickListener {
            try {
                outputdisplay.setText(operate(s).toString());
            }catch(e: Exception){
                outputdisplay.setText("Error");
            }
            s="";
        }
    }
    fun operate(s: String): Double{
        var expression: Array<String> = Array(s.length){i->""};
        var operators: String = "+-*/";
        var start: Int = 0;
        var expressionCounter: Int = 0;
        for(i in 0..s.length-1){
            if(operators.contains(s.substring(i, i+1))){
                expression.set(expressionCounter++, s.substring(start, i));
                expression.set(expressionCounter++, s.substring(i, i+1));
                start = i+1;
            }
        }
        expression.set(expressionCounter, s.substring(start, s.length));

        var x: Double = expression.get(0).toDouble();

        for(i in 1..expression.size-2 step 2){
            if(expression.get(i).equals("+")){
                x += expression.get(i+1).toDouble();
            }
            else if(expression.get(i).equals("-")){
                x -= expression.get(i+1).toDouble();
            }
            else if(expression.get(i).equals("*")){
                x *= expression.get(i+1).toDouble();
            }
            else if(expression.get(i).equals("/")){
                x /= expression.get(i+1).toDouble();
            }
        }

        return x;
    }
}