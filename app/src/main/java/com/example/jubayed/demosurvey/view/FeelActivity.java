package com.example.jubayed.demosurvey.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jubayed.demosurvey.R;


public class FeelActivity extends AppCompatActivity {
    private EditText et_feel;
    private Button buttonToStress;
    String user_name;
    Integer user_id;
    Bundle extras;

    String user_feel;
    Toast toast;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feel);

        et_feel=(EditText)findViewById(R.id.editTextFeel);
        buttonToStress=(Button)findViewById(R.id.buttonToStress);

        Intent intent = getIntent();
        //get the attached bundle from the intent
        extras = intent.getExtras();





        buttonToStress.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                extras.putString("USER_FEEL", et_feel.getText().toString());
                //Extracting the stored data from the bundle
                user_name = extras.getString("USER_NAME");
                user_id = extras.getInt("USER_ID");
                user_feel=extras.getString("USER_FEEL");

//                toast=Toast.makeText(getApplicationContext(),user_name,Toast.LENGTH_SHORT);
//                toast.show();
//                toast=Toast.makeText(getApplicationContext(),user_id.toString(),Toast.LENGTH_SHORT);
//                toast.show();
//                toast=Toast.makeText(getApplicationContext(),user_feel,Toast.LENGTH_SHORT);
//                toast.show();

                Bundle extras = new Bundle();
                //Adding key value pairs to this bundle
                //there are quite a lot data types you can store in a bundle
                extras.putString("USER_NAME",user_name);
                extras.putInt("USER_ID", user_id);
                extras.putString("USER_FEEL", user_feel);

                //create and initialize an intent
                Intent intent = new Intent(FeelActivity.this, StressActivity.class);
                //attach the bundle to the Intent object
                intent.putExtras(extras);
                //finally start the activity
                startActivity(intent);



            }
        });




    }
}
