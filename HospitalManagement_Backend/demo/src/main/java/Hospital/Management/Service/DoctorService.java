package Hospital.Management.Service;

import java.util.List;

import Hospital.Management.Model.Doctor;

public interface DoctorService {
	Doctor createDoctor(Doctor doctor);
	List<Doctor> getAllDoctors();
	Doctor getdoctorById(int doctor_id);
	Doctor updateDoctor(Doctor doctor, int doctor_id);
	void deleteDoctor(int doctor_id);
}
