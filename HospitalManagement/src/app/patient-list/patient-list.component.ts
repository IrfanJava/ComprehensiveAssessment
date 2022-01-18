import { Component, OnInit } from '@angular/core';
import { Patient } from '../patient'
import { PatientService } from '../patient.service'
import { Router } from '@angular/router';
@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  patients: Patient[] = [
    
  ];

  constructor(private patientService: PatientService,
    private router: Router) { }

  ngOnInit(): void {
    this.getPatients();
  }

  private getPatients(){
    this.patientService.getPatientsList().subscribe(data => {
      this.patients = data;
    });
  }

  patientDetails(id: number){
    this.router.navigate(['patient-details', id]);
  }

  updatePatient(id: number){
    this.router.navigate(['update-patient', id]);
  }

  deletePatient(id: number){
    this.patientService.deletePatient(id).subscribe( data => {
      console.log(data);
      this.getPatients();
    })
  }

  logout(){
    localStorage.clear();
    this.router.navigate(['login']);
  }
}




// import { Component, OnInit } from '@angular/core';

// @Component({
//   selector: 'app-patient-list',
//   templateUrl: './patient-list.component.html',
//   styleUrls: ['./patient-list.component.css']
// })
// export class PatientListComponent implements OnInit {

//   constructor() { }

//   ngOnInit(): void {
//   }

// }
