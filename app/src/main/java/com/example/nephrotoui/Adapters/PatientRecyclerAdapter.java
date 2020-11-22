package com.example.nephrotoui.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nephrotoui.Models.Patient;
import com.example.nephrotoui.R;

import java.util.ArrayList;

public class PatientRecyclerAdapter extends  RecyclerView.Adapter<PatientRecyclerAdapter.ViewHolder>{

    private ArrayList<Patient> mPatients = new ArrayList<>();
    private OnPatientListener mOnPatientListener;

    public PatientRecyclerAdapter(ArrayList<Patient> patients, OnPatientListener onPatientListener) {
        this.mPatients = patients;
        this.mOnPatientListener = onPatientListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_patient_list_item, parent, false);
        return new ViewHolder(view, mOnPatientListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.timestamp.setText(mPatients.get(position).getTimestamp());
        holder.patient_id.setText(mPatients.get(position).getPatient_id());

    }

    @Override
    public int getItemCount() {
        return mPatients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView patient_id, timestamp;
        OnPatientListener onPatientListener;

        public ViewHolder(@NonNull View itemView, OnPatientListener onPatientListener) {
            super(itemView);
            patient_id = itemView.findViewById(R.id.patient_id);
            timestamp = itemView.findViewById(R.id.patient_timestap);
            this.onPatientListener = onPatientListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onPatientListener.onPatientClick(getAdapterPosition());
        }
    }

    public interface OnPatientListener{
        void onPatientClick(int position);
    }
}
