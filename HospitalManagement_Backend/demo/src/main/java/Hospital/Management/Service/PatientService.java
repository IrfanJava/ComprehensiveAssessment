package Hospital.Management.Service;

import java.util.List;

import Hospital.Management.Model.Patient;

public interface PatientService {
	Patient createPatient(Patient patient);
	List<Patient> getAllPatients();
	Patient getpatientById(int patient_id);
	Patient updatePatient(Patient patient, int patient_id);
	void deletePatient(int patient_id);
}
