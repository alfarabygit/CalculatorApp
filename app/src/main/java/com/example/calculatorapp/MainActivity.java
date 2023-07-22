package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int firstNum;
    String operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //memanggil id button
        Button num0=findViewById(R.id.num0);
        Button num1=findViewById(R.id.num1);
        Button num2=findViewById(R.id.num2);
        Button num3=findViewById(R.id.num3);
        Button num4=findViewById(R.id.num4);
        Button num5=findViewById(R.id.num5);
        Button num6=findViewById(R.id.num6);
        Button num7=findViewById(R.id.num7);
        Button num8=findViewById(R.id.num8);
        Button num9=findViewById(R.id.num9);

        Button on=findViewById(R.id.on);
        Button off=findViewById(R.id.off);
        Button ac=findViewById(R.id.ac);
        Button del=findViewById(R.id.del);
        Button div=findViewById(R.id.div);
        Button time=findViewById(R.id.times);
        Button min=findViewById(R.id.min);
        Button plus=findViewById(R.id.plus);
        Button equals=findViewById(R.id.equal);
        Button points=findViewById(R.id.point);

        TextView screen =findViewById(R.id.screen);

        //event ketika klik tombol on
        ac.setOnClickListener(view -> {
            firstNum=0;
            screen.setText("0");
        });

        off.setOnClickListener(view -> screen.setVisibility(View.GONE));//event ketika klik tombol off
        on.setOnClickListener(view -> {
            screen.setVisibility(view.VISIBLE);
            screen.setText("0");
        });//event ketika klik tombol on

        //membuat array list utk tombol angka kalkulator
        ArrayList<Button> nums = new ArrayList<>();
        nums.add(num0);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        nums.add(num4);
        nums.add(num5);
        nums.add(num6);
        nums.add(num7);
        nums.add(num8);
        nums.add(num9);
    //membuat looping for in utk event ketika mengklik tombol angka
        for(Button b:nums){
            b.setOnClickListener(view -> {
                if(!screen.getText().toString().equals("0")){
                    screen.setText(screen.getText().toString()+b.getText().toString());
                }else{
                    screen.setText(b.getText().toString());
                }
            });
        }
        //membuat array list utk tombol operasi aritmatika
        ArrayList<Button> operators = new ArrayList<>();
        operators.add(div);
        operators.add(time);
        operators.add(min);
        operators.add(plus);
        //membuat looping for in utk event ketika mengklik tombol operator aritmatika
        for(Button b:operators){
            b.setOnClickListener(view -> {
              firstNum=Integer.parseInt(screen.getText().toString());
              operation=b.getText().toString();
              screen.setText("0");
            });
        }
        //event ketika klik tombol delete
        del.setOnClickListener(view -> {
            String num=screen.getText().toString();
            if(num.length()>1){
                screen.setText(num.substring(0, num.length()-1));
            }else if(num.length()==1 && !num.equals("0")){
                screen.setText("0");
            }
        });
        //event ketika klik tombol point(titik)
        points.setOnClickListener(view -> {
            if(!screen.getText().toString().contains(".")){
                screen.setText(screen.getText().toString()+".");
            }
        });

        //event utk melakukan operasi aritmatika
        equals.setOnClickListener(view -> {
            int secondNum =Integer.parseInt(screen.getText().toString());
            int result;
            switch(operation){
                case "/":
                    result=firstNum/secondNum;
                    break;
                case "X":
                    result=firstNum*secondNum;
                    break;
                case "-":
                    result=firstNum-secondNum;
                    break;
                case "+":
                    result=firstNum+secondNum;
                    break;
                default:
                    result=firstNum+secondNum;

            }
            screen.setText(String.valueOf(result));
            firstNum=result;
        });
    }
}