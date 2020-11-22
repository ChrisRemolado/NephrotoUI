package com.example.nephrotoui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.nephrotoui.Adapters.PatientRecyclerAdapter;
import com.example.nephrotoui.Models.Patient;
import com.example.nephrotoui.Utils.VerticalSpacingItemDecorator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PatientRecyclerAdapter.OnPatientListener, View.OnClickListener {

    private static final String TAG = "MainActivity";
    private static final int REQUEST_CODE_CHECK = 1;

    //UI Components
    private RecyclerView mRecyclerView;


    //Variables
    private ArrayList<Patient> mPatients = new ArrayList<>();
    private PatientRecyclerAdapter mPatientRecyclerAdapter;
    private String mDonorName = "";
    private String mDimLength = "";
    private String mDimWidth = "";
    private String mAmtArteries = "";
    private String mDistArteries = "";
    private String mAbnormalities = "";
    private String mSurgDamage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);

        findViewById(R.id.fab).setOnClickListener(this);

        initRecyclerView();
        insertFakePatients();

        setSupportActionBar((Toolbar)findViewById(R.id.patients_toolbar));
        setTitle("Donor List");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_CHECK){
            if(resultCode == Activity.RESULT_OK){
                mDonorName = data.getStringExtra("Donor_Name");
                mDimLength = data.getStringExtra("Length");
                mDimWidth = data.getStringExtra("Width");
                mAmtArteries = data.getStringExtra("#_of_Arteries");
                mDistArteries = data.getStringExtra("Distance_of_Arteries");
                mAbnormalities = data.getStringExtra("Abnormalities");
                mSurgDamage = data.getStringExtra("Surg_Damage");

                Patient patient = new Patient();
                patient.setPatient_id(mDonorName);
                patient.setTimestamp("Apr 2020");
                patient.setKidney_length(mDimLength);
                patient.setKidney_width(mDimWidth);
                patient.setNum_of_arteries(mAmtArteries);
                patient.setDist_of_arteries(mDistArteries);
                patient.setBool_abnormalities(mAbnormalities);
                patient.setBool_surg_damage(mSurgDamage);
                mPatients.add(patient);
            }
        }
        mPatientRecyclerAdapter.notifyDataSetChanged();
    }

    private void insertFakePatients(){

        Patient donor_1 = new Patient("John Smith", "Mar 2020", "11", "6",
                                    "2", "4", "No", "No");
        Patient donor_2 = new Patient("Jane Doe", "Mar 2020", "12", "6",
                "2", "3.75", "No", "Yes");
        Patient donor_3 = new Patient("Barry McDonald", "Mar 2020", "15", "13.24","11.73%", "7", "6.03","13.86%",
                "2", "3.75","3.04","18.93%", "No", "Yes");

        mPatients.add(donor_1);
        mPatients.add(donor_2);
        mPatients.add(donor_3);
        mPatientRecyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(20);
        mRecyclerView.addItemDecoration(itemDecorator);
        mPatientRecyclerAdapter = new PatientRecyclerAdapter(mPatients, this);
        mRecyclerView.setAdapter(mPatientRecyclerAdapter);
    }

    @Override
    public void onPatientClick(int position) {
        Log.d(TAG, "onPatientClick: clicked " + position);

        Intent viewMetrics = new Intent(this, KidneyDetails.class);
        viewMetrics.putExtra("View_Donor_Name", mPatients.get(position).getPatient_id());
        viewMetrics.putExtra("View_Length", mPatients.get(position).getKidney_length());
        viewMetrics.putExtra("View_Length_Calc", mPatients.get(position).getKidney_length_calc());
        viewMetrics.putExtra("View_Length_Error", mPatients.get(position).getKidney_length_error());
        viewMetrics.putExtra("View_Width", mPatients.get(position).getKidney_width());
        viewMetrics.putExtra("View_Width_Calc", mPatients.get(position).getKidney_width_calc());
        viewMetrics.putExtra("View_Width_Error", mPatients.get(position).getKidney_width_error());
        viewMetrics.putExtra("View_#_of_Arteries", mPatients.get(position).getNum_of_arteries());
        viewMetrics.putExtra("View_Dist_of_Arteries", mPatients.get(position).getDist_of_arteries());
        viewMetrics.putExtra("View_Dist_of_Arteries_Calc", mPatients.get(position).getDist_of_arteries_calc());
        viewMetrics.putExtra("View_Dist_of_Arteries_Error", mPatients.get(position).getDist_of_arteries_error());
        viewMetrics.putExtra("View_Abnormalities", mPatients.get(position).getBool_abnormalities());
        viewMetrics.putExtra("View_Surg_Damage", mPatients.get(position).getBool_surg_damage());

        startActivity(viewMetrics);
        //Log.d(TAG, mPatients.get(position).getBool_abnormalities());
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, InputNewKidney.class);
        startActivityForResult(intent, REQUEST_CODE_CHECK);
    }
}
