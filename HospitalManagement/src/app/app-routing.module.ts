import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DoctorListComponent } from './doctor-list/doctor-list.component';
import { CreateDoctorComponent } from './create-doctor/create-doctor.component';
import { UpdateDoctorComponent } from './update-doctor/update-doctor.component';
import { DoctorDetailsComponent } from './doctor-details/doctor-details.component';

import { PatientListComponent } from './patient-list/patient-list.component';
import { CreatePatientComponent } from './create-patient/create-patient.component';
import { UpdatePatientComponent } from './update-patient/update-patient.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AuthGuard } from './auth.guard';
// canActivate:[AuthGuard]
const routes: Routes = [
  {path: 'doctors', component: DoctorListComponent,canActivate:[AuthGuard]},
  {path: 'create-doctor', component: CreateDoctorComponent,canActivate:[AuthGuard]},
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'update-doctor/:id', component: UpdateDoctorComponent},
  {path: 'doctor-details/:id', component: DoctorDetailsComponent},

  {path: 'patients', component: PatientListComponent,canActivate:[AuthGuard]},
  {path: 'create-patient', component: CreatePatientComponent,canActivate:[AuthGuard]},
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'update-patient/:id', component: UpdatePatientComponent},
  {path: 'patient-details/:id', component: PatientDetailsComponent},

  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],                                                                                                                                                                                                                                                                                                          
  exports: [RouterModule]
})
export class AppRoutingModule { }