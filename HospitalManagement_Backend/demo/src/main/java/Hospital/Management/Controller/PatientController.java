package Hospital.Management.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Hospital.Management.Model.Patient;
import Hospital.Management.Service.PatientService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class PatientController {
	
	private PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
	@PostMapping("/patients")
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
		return new ResponseEntity<Patient>(patientService.createPatient(patient), HttpStatus.CREATED);
	}
	@GetMapping("/patients")
	public List<Patient> getAllPatients(){
		return patientService.getAllPatients();
	}
	@GetMapping("/patients/{patient_id}")
	public ResponseEntity<Patient> getpatientById(@PathVariable int patient_id){
		return new ResponseEntity<Patient>(patientService.getpatientById(patient_id), HttpStatus.OK);
	}
	@PutMapping("/patients/{patient_id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable int patient_id, @RequestBody Patient patientDetails){
		return new ResponseEntity<Patient>(patientService.updatePatient(patientDetails, patient_id), HttpStatus.OK);
	}
	@DeleteMapping("/patients/{patient_id}")
	public ResponseEntity<String> deletePatient(@PathVariable int patient_id){
		patientService.deletePatient(patient_id);
		return new ResponseEntity<String>("Patient data Deleted Successfully!", HttpStatus.OK);
	}	
}

