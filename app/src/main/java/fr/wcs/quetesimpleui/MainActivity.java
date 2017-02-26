package com.example.marion.wcs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button  = (Button) findViewById(R.id.button);
        final EditText editText1 = (EditText) findViewById(R.id.editText1);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox) ;
        final TextView textView3 = (TextView) findViewById(R.id.textView3);



        editText1.setEnabled(false);
        editText2.setEnabled(false);
        button.setEnabled(false);
        textView3.setVisibility(View.INVISIBLE);




        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editText1.setEnabled(checkBox.isChecked());
                editText1.setText("");
                editText2.setEnabled(checkBox.isChecked());
                editText2.setText("");
                button.setEnabled(checkBox.isChecked());

                if (!isChecked){

                    textView3.setVisibility(View.INVISIBLE);
                    editText1.setText(null);
                    editText2.setText(null);

                }


            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText1.length() == 0 || editText2.length() == 0) {
                    Toast.makeText(MainActivity.this, getString(R.string.Toast), Toast.LENGTH_LONG).show();
                    textView3.setVisibility(View.INVISIBLE);

                }

                else {
                    textView3.setVisibility(View.VISIBLE);
                    textView3.setText(getString(R.string.Bravo) + " " + editText1.getText() + " " + editText2.getText());

                }

            }
        });}}