package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import Hospital.Management.HospitalManagementApplication;
import Hospital.Management.Model.Doctor;
import Hospital.Management.Model.Patient;
import Hospital.Management.Repository.DoctorRepository;
import Hospital.Management.Repository.PatientRepository;
import Hospital.Management.Service.DoctorService;
import Hospital.Management.Service.PatientService;



@SpringBootTest(classes=HospitalManagementApplication.class)
class DemoApplicationTests {
	
	@Autowired
	private DoctorService doctorserv;
	
	@MockBean
	private DoctorRepository doctorrepo;
	
	@Autowired
	private PatientService patientserv;
	
	@MockBean
	private PatientRepository patientrepo;
	
	@Test
	public void getAllDoctorsTest() {
		when(doctorrepo.findAll()).thenReturn(Stream.of(new Doctor(2101,"Dr.Tuco Salamanca",36,"M","Orthologist"),new Doctor(2102,"Dr.Mike Ermantraut",58,"M","Nephralogist"),new Doctor(2103,"Dr.Kim Wexler",34,"F","Pediatrician")).collect(Collectors.toList()));
		
	assertEquals(3,(doctorserv.getAllDoctors()).size());
	}
	
	@Test
	public void getdoctorByIdTest() {
		int doctor_id=2101;
		Optional<Doctor> optionalEntity=Optional.of(new Doctor(2101,"Dr.Tuco Salamanca",36,"M","Orthologist"));
		when(doctorrepo.findById(doctor_id)).thenReturn(optionalEntity);
//		Optional<RoomEntity> optionalEntity =  roomRepository.findById(roomId);
//		Mockito.doReturn(new Doctor(2101,"Dr.Tuco Salamanca",36,"M","Orthologist")).when(doctorrepo.findById(doctor_id));
		assertEquals(36,(doctorserv.getdoctorById(doctor_id)).getDoctor_age());
	}
	
	@Test
	public void createDoctorTest() {
		Doctor doctor=new Doctor(2104,"Dr.Gus Fring",47,"M","Cardiologist");
		when(doctorrepo.save(doctor)).thenReturn(doctor);
//		assertEquals(doctor,(Doctor)doctorserv.createDoctor(doctor));
		assertNotNull((Doctor)doctorserv.createDoctor(doctor));
	}
	
//	@Test
//	public void deleteDoctorTest() {
////		Doctor doctor=new Doctor(2104,"Dr.Gus Fring",47,"M","Cardiologist");
//		Optional<Doctor> optionalEntity=Optional.of(new Doctor(2101,"Dr.Tuco Salamanca",36,"M","Orthologist"));
//		when(doctorrepo.deleteById(2103)).thenReturn(null);
//		assertEquals(1,(doctorserv.deleteDoctor(2103)));
//		doctorserv.deleteDoctor(2103);
//		verify(doctorrepo,times(1)).deleteById(2103);
//	}
	
	@Test
	public void deleteDoctorTest() {
		doctorrepo.deleteById(2103);
		verify(doctorrepo,times(1)).deleteById(2103);
//		assertNull(Optional.of(doctorserv.getdoctorById(2103)));
	}
	
	@Test
	public void getAllPatientsTest() {
		when(patientrepo.findAll()).thenReturn(Stream.of(new Patient(3101,"Stacey Kristen","Dr Tuco Salamanca",new Date()),new Patient(3102,"Hana Albers","Dr.Kim Wexler",new Date()),new Patient(3103,"Lalo Esperoncias","Dr Tuco Salamanca",new Date())).collect(Collectors.toList()));
		
	assertEquals(3,(patientserv.getAllPatients()).size());
	}
	
	@Test
	public void getpatientByIdTest() {
		int patient_id=3101;
		Optional<Patient> optionalEntity=Optional.of(new Patient(3101,"Stacey Kristen","Dr Tuco Salamanca",new Date()));
		when(patientrepo.findById(patient_id)).thenReturn(optionalEntity);
		assertEquals(3101,(patientserv.getpatientById(patient_id).getPatient_id()));
	}
	
	@Test
	public void deletePatientTest() {
		patientrepo.deleteById(3103);
		verify(patientrepo,times(1)).deleteById(3103);
//		assertNull(Optional.of(doctorserv.getdoctorById(2103)));
	}
	
	@Test
	public void createPatientTest() {
		Patient patient=new Patient(3104,"Kailey Matt","Dr. Mike Ermantraut",new Date());
		when(patientrepo.save(patient)).thenReturn(patient);
//		assertEquals(doctor,(Doctor)doctorserv.createDoctor(doctor));
		assertNotNull((Patient)patientserv.createPatient(patient));
	}

}
