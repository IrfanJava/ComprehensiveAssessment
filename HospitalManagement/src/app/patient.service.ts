import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Patient } from './patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private baseURL = "http://localhost:9090/patients";

  constructor(private httpClient: HttpClient) { }
  
  getPatientsList(): Observable<Patient[]>{
    return this.httpClient.get<Patient[]>(`${this.baseURL}`);
  }

  createPatient(patient: Patient): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, patient);
  }

  getPatientById(id: number): Observable<Patient>{
    return this.httpClient.get<Patient>(`${this.baseURL}/${id}`);
  }

  updatePatient(id: number, patient: Patient): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, patient);
  }

  deletePatient(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}































// import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';  
// import { Observable } from 'rxjs'; 

// @Injectable({
//   providedIn: 'root'
// })
// export class PatientService {

//   private baseUrl = 'http://localhost:8080/api/';  
  
//   constructor(private http:HttpClient) { }  
  
//   getPatientList(): Observable<any> {  
//     return this.http.get(`${this.baseUrl}`+'patients-list');  
//   }  
  
//   createPatient(patient: object): Observable<object> {  
//     return this.http.post(`${this.baseUrl}`+'save-student', patient);  
//   }  
  
//   deletePatient(id: number): Observable<any> {  
//     return this.http.delete(`${this.baseUrl}/delete-patient/${id}`, { responseType: 'text' });  
//   }  
  
//   getPatient(id: number): Observable<Object> {  
//     return this.http.get(`${this.baseUrl}/patient/${id}`);  
//   }  
  
//   updatePatient(id: number, value: any): Observable<Object> {  
//     return this.http.post(`${this.baseUrl}/update-patient/${id}`, value);  
//   }  

// }
