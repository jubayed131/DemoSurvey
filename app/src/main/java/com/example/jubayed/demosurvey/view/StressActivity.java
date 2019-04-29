package com.example.jubayed.demosurvey.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.jubayed.demosurvey.R;

public class StressActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button stressButton;
    String user_name;
    Integer user_id;
    String user_feel;
    Toast toast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stress);

        Intent intent = getIntent();
        //get the attached bundle from the intent
        Bundle extras = intent.getExtras();
        //Extracting the stored data from the bundle
        user_name = extras.getString("USER_NAME");
        user_id = extras.getInt("USER_ID");
        user_feel=extras.getString("USER_FEEL");

//        toast=Toast.makeText(getApplicationContext(),user_name,Toast.LENGTH_SHORT);
//        toast.show();
//        toast=Toast.makeText(getApplicationContext(),user_id.toString(),Toast.LENGTH_SHORT);
//        toast.show();
//        toast=Toast.makeText(getApplicationContext(),user_feel,Toast.LENGTH_SHORT);
//        toast.show();


        radioGroup=(RadioGroup)findViewById(R.id.radioStress);
        stressButton=(Button)findViewById(R.id.stressButton);

        addListenerOnButton();

    }

    public void addListenerOnButton() {

        radioGroup = (RadioGroup) findViewById(R.id.radioStress);
        stressButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Bundle extras = new Bundle();
                //Adding key value pairs to this bundle
                //there are quite a lot data types you can store in a bundle


                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);
                Toast.makeText(StressActivity.this,radioButton.getText(), Toast.LENGTH_SHORT).show();

                extras.putString("USER_NAME",user_name);
                extras.putInt("USER_ID", user_id);
                extras.putString("USER_FEEL", user_feel);
                extras.putString("USER_STRESS",radioButton.getText().toString());

                Intent intent = new Intent(StressActivity.this, LevelActivity.class);
                //attach the bundle to the Intent object
                intent.putExtras(extras);
                //finally start the activity
                startActivity(intent);



            }

        });

    }
}
