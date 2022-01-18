import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-doctor',
  templateUrl: './create-doctor.component.html',
  styleUrls: ['./create-doctor.component.css']
})
export class CreateDoctorComponent implements OnInit {

  doctor: Doctor = new Doctor();
  constructor(private doctorService: DoctorService,
    private router: Router) { }

  ngOnInit(): void {
  }

  // doctor_id=0;
  // doctor_name="";
  // doctor_age=0;
  // doctor_gender="";
  // doctor_specialistFields="";

  saveDoctor(){
    this.doctorService.createDoctor(this.doctor).subscribe( data =>{
      console.log(data);
      this.goToDoctorList();
    },
    error => console.log(error));
  }

  goToDoctorList(){
    this.router.navigate(['/doctors']);
  }
  
  onSubmit(){
    // const doctor = new Doctor();
    // doctor.doctor_id = this.doctor_id;
    // doctor.doctor_name = this.doctor_name;
    // doctor.doctor_age = this.doctor_age;
    // doctor.doctor_gender = this.doctor_gender;
    // doctor.doctor_specialistFields = this.doctor_specialistFields;
    // this.doctorService.createDoctor(doctor)
    // .subscribe(res => this.router.navigate(['/doctors']));

    console.log(this.doctor);
    this.saveDoctor();
    this.router.navigate(['/doctors']);
  }
}
