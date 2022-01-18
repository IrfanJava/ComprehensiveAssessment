import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { ActivatedRoute } from '@angular/router';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-doctor-details',
  templateUrl: './doctor-details.component.html',
  styleUrls: ['./doctor-details.component.css']
})
export class DoctorDetailsComponent implements OnInit {

  id: number = 0;
  doctor: Doctor = {
    doctor_id:0,  
    doctor_name:"",  
    doctor_age:0,  
    doctor_gender:"", 
    doctor_specialistFields:""
};
  constructor(private route: ActivatedRoute, private doctorService: DoctorService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.doctor = new Doctor();
    this.doctorService.getDoctorById(this.id).subscribe( data => {
      this.doctor = data;
    });
  }
}
// import { Component, OnInit } from '@angular/core';

// @Component({
//   selector: 'app-doctor-details',
//   templateUrl: './doctor-details.component.html',
//   styleUrls: ['./doctor-details.component.css']
// })
// export class DoctorDetailsComponent implements OnInit {

//   constructor() { }

//   ngOnInit(): void {
//   }

// }
