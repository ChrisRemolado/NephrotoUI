package com.example.nephrotoui.Models;

public class Patient {

    private String patient_id;
    private String timestamp;
    private String kidney_length_actual, kidney_length_calc, kidney_length_error;
    private String kidney_width_actual, kidney_width_calc, kidney_width_error;
    private String num_of_arteries;
    private String dist_of_arteries_actual, dist_of_arteries_calc, dist_of_arteries_error;
    private String bool_abnormalities;
    private String bool_surg_damage;

    public Patient(String patient_id, String timestamp,
                   String kidney_length, String kidney_width,
                   String num_of_arteries, String dist_of_arteries,
                   String bool_abnormalities, String bool_surg_damage) {
        this.patient_id = patient_id;
        this.timestamp = timestamp;
        this.kidney_length_actual = kidney_length;
        this.kidney_width_actual = kidney_width;
        this.num_of_arteries = num_of_arteries;
        this.dist_of_arteries_actual = dist_of_arteries;
        this.bool_abnormalities = bool_abnormalities;
        this.bool_surg_damage = bool_surg_damage;
    }

    public Patient(String patient_id, String timestamp,
                   String kidney_length, String kidney_length_calc, String kidney_length_error, String kidney_width, String kidney_width_calc, String kidney_width_error,
                   String num_of_arteries, String dist_of_arteries, String dist_of_arteries_calc, String dist_of_arteries_error,
                   String bool_abnormalities, String bool_surg_damage) {
        this.patient_id = patient_id;
        this.timestamp = timestamp;
        this.kidney_length_actual = kidney_length;
        this.kidney_length_calc = kidney_length_calc;
        this.kidney_length_error = kidney_length_error;
        this.kidney_width_actual = kidney_width;
        this.kidney_width_calc = kidney_width_calc;
        this.kidney_width_error = kidney_width_error;
        this.num_of_arteries = num_of_arteries;
        this.dist_of_arteries_actual = dist_of_arteries;
        this.dist_of_arteries_calc = dist_of_arteries_calc;
        this.dist_of_arteries_error = dist_of_arteries_error;
        this.bool_abnormalities = bool_abnormalities;
        this.bool_surg_damage = bool_surg_damage;
    }

    public Patient(){
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getKidney_length(){
        return kidney_length_actual;
    }

    public void setKidney_length(String kidney_length){
        this.kidney_length_actual = kidney_length;
    }
    public String getKidney_length_calc(){
        return kidney_length_calc;
    }

    public void setKidney_length_calc(String kidney_length){
        this.kidney_length_calc = kidney_length;
    }
    public String getKidney_length_error(){
        return kidney_length_error;
    }

    public void setKidney_length_error(String kidney_length){
        this.kidney_length_error = kidney_length;
    }

    public String getKidney_width(){
        return kidney_width_actual;
    }

    public void setKidney_width(String kidney_width){
        this.kidney_width_actual = kidney_width;
    }
    public String getKidney_width_calc(){
        return kidney_width_calc;
    }

    public void setKidney_width_calc(String kidney_width){
        this.kidney_width_calc = kidney_width;
    }
    public String getKidney_width_error(){
        return kidney_width_error;
    }

    public void setKidney_width_error(String kidney_width){
        this.kidney_width_error = kidney_width;
    }

    public String getNum_of_arteries(){
        return num_of_arteries;
    }

    public void setNum_of_arteries(String num_of_arteries){
        this.num_of_arteries = num_of_arteries;
    }

    public String getDist_of_arteries() {
        return dist_of_arteries_actual;
    }

    public void setDist_of_arteries(String dist_of_arteries) {
        this.dist_of_arteries_actual = dist_of_arteries;
    }
    public String getDist_of_arteries_calc() {
        return dist_of_arteries_calc;
    }

    public void setDist_of_arteries_calc(String dist_of_arteries) {
        this.dist_of_arteries_calc = dist_of_arteries;
    }
    public String getDist_of_arteries_error() {
        return dist_of_arteries_error;
    }

    public void setDist_of_arteries_error(String dist_of_arteries) {
        this.dist_of_arteries_error = dist_of_arteries;
    }

    public String getBool_abnormalities() {
        return bool_abnormalities;
    }

    public void setBool_abnormalities(String bool_abnormalities) {
        this.bool_abnormalities = bool_abnormalities;
    }

    public String getBool_surg_damage() {
        return bool_surg_damage;
    }

    public void setBool_surg_damage(String bool_surg_damage) {
        this.bool_surg_damage = bool_surg_damage;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patient_id='" + patient_id + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
