package com.example.jubayed.demosurvey.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jubayed.demosurvey.R;
import com.example.jubayed.demosurvey.database.DatabaseHelper;

public class LevelActivity extends AppCompatActivity {

    private TextView tv_progress;
    private ProgressBar pb_percentage;
    private SeekBar sb_level;
    private Button buttonLevel;
    String user_name;
    Integer user_id;
    String user_feel;
    String user_stress;
    Integer user_stress_level;
    Toast toast;
    private DatabaseHelper db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        db = new DatabaseHelper(this);

        buttonLevel=(Button)findViewById(R.id.buttonLevel);

        Intent intent = getIntent();
        //get the attached bundle from the intent
        Bundle extras = intent.getExtras();
        //Extracting the stored data from the bundle
        user_name = extras.getString("USER_NAME");
        user_id = extras.getInt("USER_ID");
        user_feel=extras.getString("USER_FEEL");
        user_stress=extras.getString("USER_STRESS");


        toast=Toast.makeText(getApplicationContext(),user_name,Toast.LENGTH_SHORT);
        toast.show();
        toast=Toast.makeText(getApplicationContext(),user_id.toString(),Toast.LENGTH_SHORT);
        toast.show();
        toast=Toast.makeText(getApplicationContext(),user_feel,Toast.LENGTH_SHORT);
        toast.show();
        toast=Toast.makeText(getApplicationContext(),user_stress,Toast.LENGTH_SHORT);
        toast.show();



        tv_progress=(TextView)findViewById(R.id.textViewProgress);
        pb_percentage=(ProgressBar)findViewById(R.id.progressBar);
        sb_level=(SeekBar)findViewById(R.id.seekBar);

        sb_level.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pb_percentage.setProgress(progress);
                tv_progress.setText(""+progress+"%");
                user_stress_level=progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        buttonLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toast=Toast.makeText(getApplicationContext(),((String.valueOf(user_stress_level))),Toast.LENGTH_SHORT);
                toast.show();

                long id = db.insertSurvey(user_id,user_name,user_feel,user_stress,user_stress_level);
                toast=Toast.makeText(getApplicationContext(), ((String.valueOf(id))),Toast.LENGTH_SHORT);
                toast.show();
                toast=Toast.makeText(getApplicationContext(), "Survey data saved",Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(LevelActivity.this, MainActivity.class);
                //attach the bundle to the Intent object

                //finally start the activity
                startActivity(intent);

            }
        });

    }


}
