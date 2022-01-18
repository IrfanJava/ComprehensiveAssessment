import { Component, OnInit } from '@angular/core';
import { Patient } from '../patient';
import { ActivatedRoute } from '@angular/router';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css']
})
export class PatientDetailsComponent implements OnInit {

  id: number = 0;
  patient: Patient = {
    patient_id:0,  
    patient_name:"",  
    patient_visitedDoctor:"",  
    patient_dateOfVisit:new Date("")
};
  constructor(private route: ActivatedRoute, private patientService: PatientService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.patient = new Patient();
    this.patientService.getPatientById(this.id).subscribe( data => {
      this.patient = data;
    });
  }
}
// import { Component, OnInit } from '@angular/core';

// @Component({
//   selector: 'app-patient-details',
//   templateUrl: './patient-details.component.html',
//   styleUrls: ['./patient-details.component.css']
// })
// export class PatientDetailsComponent implements OnInit {

//   constructor() { }

//   ngOnInit(): void {
//   }

// }
