package com.example.jubayed.demosurvey.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jubayed.demosurvey.R;

public class MainActivity extends AppCompatActivity {

    EditText editTextID;
    EditText editTextName;
    Button buttonToFeel;
    Button buttonTest;
    Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextID=(EditText)findViewById(R.id.editTextid);
        editTextName=(EditText)findViewById(R.id.editTextName);
        buttonToFeel=(Button)findViewById(R.id.buttonToFeel);
        buttonTest=(Button)findViewById(R.id.buttonTest);

        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast=Toast.makeText(getApplicationContext(), editTextName.getText().toString(),Toast.LENGTH_SHORT);
                toast.show();
                toast=Toast.makeText(getApplicationContext(), "You ID is "+editTextID.getText().toString(),Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        buttonToFeel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create a Bundle object
                Bundle extras = new Bundle();
                //Adding key value pairs to this bundle
                //there are quite a lot data types you can store in a bundle
                extras.putString("USER_NAME",editTextName.getText().toString());
                extras.putInt("USER_ID", Integer.parseInt(editTextID.getText().toString()));

                //create and initialize an intent
                Intent intent = new Intent(MainActivity.this, FeelActivity.class);
                //attach the bundle to the Intent object
                intent.putExtras(extras);
                //finally start the activity
                startActivity(intent);

            }
        });








    }
}
