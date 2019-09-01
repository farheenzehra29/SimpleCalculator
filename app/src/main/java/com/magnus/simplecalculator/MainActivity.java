package com.magnus.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private RadioButton sumordiff;

    private TextView result;
    private RadioGroup option;
    private Button submitButton;
    private int output=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listener();

    }
public void listener(){
    num1=(EditText)findViewById(R.id.input1);
    num2=(EditText)findViewById(R.id.input2);
    option=(RadioGroup)findViewById(R.id.operation);
    result=(TextView)findViewById(R.id.ans);
    testForValues();
    submitButton=(Button)findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int selectedId = option.getCheckedRadioButtonId();
                sumordiff = (RadioButton) findViewById(selectedId);
                int number1= Integer.parseInt(num1.getText().toString());
                int number2= Integer.parseInt(num2.getText().toString());
                String name = sumordiff.getText().toString();
                if(number1<Integer.MAX_VALUE &&number2<Integer.MAX_VALUE) {
                    if (name.equals("Addition")) {
                        output = number1 + number2;
                    } else {

                        output = number1 - number2;
                    }
                }
                result.setText("Answer: " + String.valueOf(output));
            }
        });


    }
    public void testForValues(){

        if (num1.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter the first value", Toast.LENGTH_LONG).show();
        }
        if (num2.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter the second value", Toast.LENGTH_LONG).show();
        }
    }
}


