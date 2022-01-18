import { Component, OnInit } from '@angular/core';
import { PatientService } from '../patient.service';
import { Patient } from '../patient';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrls: ['./update-patient.component.css']
})
export class UpdatePatientComponent implements OnInit {

  id: number = 0;
  patient: Patient = new Patient();
  constructor(private patientService: PatientService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.patientService.getPatientById(this.id).subscribe(data => {
      this.patient = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.patientService.updatePatient(this.id, this.patient).subscribe( data =>{
      this.goToPatientList();
    }
    , error => console.log(error));
  }

  goToPatientList(){
    this.router.navigate(['/patients']);
  }
}

