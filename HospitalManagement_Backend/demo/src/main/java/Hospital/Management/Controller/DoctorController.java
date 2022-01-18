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

import Hospital.Management.Model.Doctor;
import Hospital.Management.Service.DoctorService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class DoctorController {
	
	private DoctorService doctorService;

	public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}
	@PostMapping("/doctors")
	public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(doctorService.createDoctor(doctor), HttpStatus.CREATED);
	}
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();
	}
	@GetMapping("/doctors/{doctor_id}")
	public ResponseEntity<Doctor> getdoctorById(@PathVariable int doctor_id){
		return new ResponseEntity<Doctor>(doctorService.getdoctorById(doctor_id), HttpStatus.OK);
	}
	@PutMapping("/doctors/{doctor_id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable int doctor_id, @RequestBody Doctor doctorDetails){
		return new ResponseEntity<Doctor>(doctorService.updateDoctor(doctorDetails, doctor_id), HttpStatus.OK);
	}
	@DeleteMapping("/doctors/{doctor_id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable int doctor_id){
		doctorService.deleteDoctor(doctor_id);
		return new ResponseEntity<String>("Doctor data Deleted Successfully!", HttpStatus.OK);
	}
}
