package com.example.demo.objectclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    String damka;
    String doctorname;

    @OneToMany(mappedBy="doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("doctor")
    private Set<Timeslot> timeslots= new HashSet<>();

    @OneToMany
    @JoinTable(name="Vaccinations",
            joinColumns = @JoinColumn(name="doctor_amka"),
            inverseJoinColumns = @JoinColumn(name="patient_amka"))
    private List<Patient> patients;

    //default constructor
    public Doctor() {
    }
    //constructor
    public Doctor(String doctorAmka,String doctorName){
        this.damka=doctorAmka;
        this.doctorname=doctorName;

    }
    //getter for doctor variables
    public String getDamka() {
        return damka;
    }
    public String getDoctorname() {
        return doctorname;
    }
    //setter for doctor variables
    public void setDamka(String damka) {this.damka = damka;}
    public void setDoctorname(String doctorname) {this.doctorname = doctorname;}

    //getters and setters for timeslots


    public Set<Timeslot> getTimeslots() {return timeslots;}
    public void setTimeslots(Set<Timeslot> timeslots) {this.timeslots = timeslots;}

    //add timeslot
    public void addTimeslot(Timeslot t) {timeslots.add(t);}



}
