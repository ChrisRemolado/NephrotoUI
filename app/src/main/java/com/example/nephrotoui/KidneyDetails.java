package com.example.nephrotoui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class KidneyDetails extends AppCompatActivity {

    private static final String TAG = "KidneyDetails";
    private static final int REQUEST_CODE_CHECK = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kidney_details);

        setSupportActionBar((Toolbar)findViewById(R.id.view_kidney_metrics));
        setTitle("View Kidney Metrics");

        final TextView donorName = findViewById(R.id.view_donor_name);

        final TextView dimLengthActual = findViewById(R.id.view_kidney_length_actual);
        final TextView dimLengthCalc = findViewById(R.id.view_kidney_length_calc);
        final TextView dimLengthError = findViewById(R.id.view_kidney_length_error);
        final TextView dimWidthActual = findViewById(R.id.view_kidney_width_actual);
        final TextView dimWidthCalc = findViewById(R.id.view_kidney_width_calc);
        final TextView dimWidthError = findViewById(R.id.view_kidney_width_error);

        final TextView amtArteries = findViewById(R.id.view_num_of_arteries);

        final TextView distArteriesActual = findViewById(R.id.view_dist_of_arteries_actual);
        final TextView distArteriesCalc = findViewById(R.id.view_dist_of_arteries_calc);
        final TextView distArteriesError = findViewById(R.id.view_dist_of_arteries_error);

        final TextView boolAbnormalities = findViewById(R.id.view_bool_abnormalities);
        final TextView boolSurgDamage = findViewById(R.id.view_bool_surg_damage);

        Intent viewMetrics = getIntent();
        donorName.setText(viewMetrics.getStringExtra("View_Donor_Name"));

        dimLengthActual.setText("Actual value: " + viewMetrics.getStringExtra("View_Length") + " cm");
        dimLengthCalc.setText("Calculated value: " + viewMetrics.getStringExtra("View_Length_Calc") + " cm");
        dimLengthError.setText("Error margin: " + viewMetrics.getStringExtra("View_Length_Error"));
        dimWidthActual.setText("Actual value: " + viewMetrics.getStringExtra("View_Width") + " cm");
        dimWidthCalc.setText("Calculated value: " + viewMetrics.getStringExtra("View_Width_Calc") + " cm");
        dimWidthError.setText("Error margin: " + viewMetrics.getStringExtra("View_Width_Error"));

        amtArteries.setText(viewMetrics.getStringExtra("View_#_of_Arteries"));

        distArteriesActual.setText("Actual value: " + viewMetrics.getStringExtra("View_Dist_of_Arteries") + " cm");
        distArteriesCalc.setText("Calculated value: " + viewMetrics.getStringExtra("View_Dist_of_Arteries_Calc") + " cm");
        distArteriesError.setText("Error margin: " + viewMetrics.getStringExtra("View_Dist_of_Arteries_Error"));

        boolAbnormalities.setText(viewMetrics.getStringExtra("View_Abnormalities"));
        boolSurgDamage.setText(viewMetrics.getStringExtra("View_Surg_Damage"));

    }
}
