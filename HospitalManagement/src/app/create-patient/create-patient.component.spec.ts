// import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HttpClientModule } from "@angular/common/http";
import { DebugElement } from "@angular/core";

import { By } from "@angular/platform-browser";

import { Patient } from "../patient";
import { PatientListComponent } from "../patient-list/patient-list.component";
import { CreatePatientComponent } from "./create-patient.component";
import{ HttpClientTestingModule,HttpTestingController} from '@angular/common/http/testing';
import { TestBed, async ,ComponentFixture } from '@angular/core/testing';


// import { CreatePatientComponent } from './create-patient.component';

// describe('CreatePatientComponent', () => {
//   let component: CreatePatientComponent;
//   let fixture: ComponentFixture<CreatePatientComponent>;

//   beforeEach(async () => {
//     await TestBed.configureTestingModule({
//       declarations: [ CreatePatientComponent ]
//     })
//     .compileComponents();
//   });

//   beforeEach(() => {
//     fixture = TestBed.createComponent(CreatePatientComponent);
//     component = fixture.componentInstance;
//     fixture.detectChanges();
//   });

//   it('should create', () => {
//     expect(component).toBeTruthy();
//   });
// });
describe('CreatePatientComponent', () => {
  let component: CreatePatientComponent;
  let fixture: ComponentFixture<CreatePatientComponent>;
  let de: DebugElement;
  let el: HTMLElement;

  beforeEach(async () => {
    TestBed.configureTestingModule({
      declarations: [ CreatePatientComponent ],
      imports:[
        HttpClientModule,
        HttpClientTestingModule,
        HttpTestingController,
        PatientListComponent
      ]
    }).compileComponents().then(() =>{
      fixture = TestBed.createComponent(CreatePatientComponent);
      component=fixture.componentInstance;

      de = fixture.debugElement.query(By.css('form'));
      el = de.nativeElement;
    });
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatePatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', async(() => {
    expect(component).toBeTruthy();
  }));
  it('should have savepatient', async(() => {
    const service: CreatePatientComponent = TestBed.get(CreatePatientComponent)
    expect(Patient).toBeTruthy();
  }));

  it('should have patientList', async(() => {
    component.contactForm.controls['id'].setValue('1');
    component.contactForm.controls['patient_visited_doctor'].setValue('Subba Rao');
    component.contactForm.controls['date'].setValue('22/12/21');
    component.contactForm.controls['patient_name'].setValue('keerthi');
    expect(component.valid).toBeTruthy();
  }));
  
  it('should call onSubmit method',async(() =>{
component.onSubmit();
expect(component.submitted).toBeTruthy
  }));

it('should be Onsubmit method', async(() => {
  fixture.detectChanges();
  spyOn(component,'onSubmit');
  el = fixture.debugElement.query(By.css('button')).nativeElement;
  el.click(); 
  expect(component.onSubmit).toHaveBeenCalledTimes(0);
 }));
});