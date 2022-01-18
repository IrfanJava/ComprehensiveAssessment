package Hospital.Management.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import Hospital.Management.Exception.ResourceNotFoundException;
import Hospital.Management.Model.Patient;
import Hospital.Management.Repository.PatientRepository;
import Hospital.Management.Service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	private PatientRepository patientRepository;
	
	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	@Override
	public Patient createPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient getpatientById(int patient_id) {
		return patientRepository.findById(patient_id).orElseThrow(() -> 
		new ResourceNotFoundException("Patient", "Id", patient_id));
	}

	@Override
	public Patient updatePatient(Patient patient, int patient_id) {
		Patient existingPatient = patientRepository.findById(patient_id).orElseThrow(
				() -> new ResourceNotFoundException("Patient", "Id", patient_id));
		existingPatient.setPatient_id(patient.getPatient_id());
		existingPatient.setPatient_name(patient.getPatient_name());
		existingPatient.setPatient_visitedDoctor(patient.getPatient_visitedDoctor());
		existingPatient.setPatient_dateOfVisit(patient.getPatient_dateOfVisit());
		patientRepository.save(existingPatient);
		return existingPatient;
	}

	@Override
	public void deletePatient(int patient_id) {
		patientRepository.findById(patient_id).orElseThrow(
				() -> new ResourceNotFoundException("Patient", "Id", patient_id));
		patientRepository.deleteById(patient_id);
		
	}


}
