package com.example.nephrotoui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class InputNewKidney extends AppCompatActivity {

    //private static final String TAG = "InputNewKidney";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_new_kidney);

        setSupportActionBar((Toolbar)findViewById(R.id.kidney_metrics));
        setTitle("Input Kidney Metrics");

        final Button addKidney = findViewById(R.id.add_kidney);
        final EditText donorName = findViewById(R.id.donor_name);
        final EditText dimLength = findViewById(R.id.input_length);
        final EditText dimWidth = findViewById(R.id.input_width);
        final EditText amtArteries = findViewById(R.id.input_arteries);
        final EditText distArteries = findViewById(R.id.input_distance_of_arteries);
        final CheckBox yes_abnormalities = findViewById(R.id.abnormalities_yes);
        final CheckBox no_abnormalities = findViewById(R.id.abnormalities_no);
        final CheckBox yes_surg_damage = findViewById(R.id.surg_damage_yes);
        final CheckBox no_surg_damage = findViewById(R.id.surg_damage_no);

        addKidney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mDonorName = donorName.getText().toString();
                String mDimLength = dimLength.getText().toString();
                String mDimWidth = dimWidth.getText().toString();
                String mAmtArteries = amtArteries.getText().toString();
                String mDistArteries = distArteries.getText().toString();
                String mAbnormalities = "";
                String mSurgDamage = "";

                if(yes_abnormalities.isChecked()){
                    mAbnormalities = "Yes";
                }
                else{
                    mAbnormalities = "No";
                }

                if(yes_surg_damage.isChecked()){
                    mSurgDamage = "Yes";
                }
                else{
                    mSurgDamage = "No";
                }

                Intent returnResults = new Intent();
                returnResults.putExtra("Donor_Name", mDonorName);
                returnResults.putExtra("Length", mDimLength);
                returnResults.putExtra("Width", mDimWidth);
                returnResults.putExtra("#_of_Arteries", mAmtArteries);
                returnResults.putExtra("Distance_of_Arteries", mDistArteries);
                returnResults.putExtra("Abnormalities", mAbnormalities);
                returnResults.putExtra("Surg_Damage", mSurgDamage);
                setResult(Activity.RESULT_OK, returnResults);
                finish();

                //Log.d(TAG, "Donor name: " + mDonorName);

            }
        });
    }
}
