package com.bynalab.xtable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText xtable;
    EditText upto;
    TextView output;
    TextView courtesy;
    TextView error;
    Button submit;
    Button clear;
    ScrollView scroll;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //start here...
        xtable = (EditText) findViewById(R.id.x);
        upto = (EditText) findViewById(R.id.to);
        output = (TextView) findViewById(R.id.output);
        courtesy = (TextView) findViewById(R.id.courtesy);
        error = (TextView)findViewById(R.id.error);
        submit = (Button) findViewById(R.id.submit);
        clear = (Button)findViewById(R.id.clear);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ed_text_x = xtable.getText().toString().trim();
                String ed_text_to = upto.getText().toString().trim();

                if (ed_text_x.isEmpty() || ed_text_x.length() == 0 || ed_text_x.equals("") || ed_text_x == null) {
                    error.setText("Field 1 required");
                } else if (ed_text_to.isEmpty() || ed_text_to.length() == 0 || ed_text_to.equals("") || ed_text_to == null) {
                    error.setText("Field 2 required");

                } else {

                    error.setText("");
                    int table_x = Integer.parseInt(xtable.getText().toString());
                    int upto_x = Integer.parseInt(upto.getText().toString());
                    StringBuilder x = new StringBuilder();
                    for (int i = 0; i <= upto_x; i++) {
                        x.append(table_x + " * " + i + " = " + table_x * i + "\n");

                    }
                    output.setText(x.toString());
                    //output.setText(table_x + " * " + i + " = " + table_x * i);
                }
            }
        });

        output.setMovementMethod(new ScrollingMovementMethod());



        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setText("");
            }
        });




    }
/*
        private void scrollToBottom()
        {
            scroll.post(new Runnable()
            {
                public void run()
                {
                    scroll.smoothScrollTo(100, output.getBottom());
                }
            });
        }
        */

    }

