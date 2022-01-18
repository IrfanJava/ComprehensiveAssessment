package Hospital.Management.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import Hospital.Management.Exception.ResourceNotFoundException;
import Hospital.Management.Model.Doctor;
import Hospital.Management.Repository.DoctorRepository;
import Hospital.Management.Service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

	private DoctorRepository doctorRepository;
	
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}

	@Override
	public Doctor createDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getdoctorById(int doctor_id) {
		return doctorRepository.findById(doctor_id).orElseThrow(
				() -> new ResourceNotFoundException("Doctor", "Id", doctor_id));
	}

	@Override
	public Doctor updateDoctor(Doctor doctor, int doctor_id) {
		Doctor existingDoctor = doctorRepository.findById(doctor_id).orElseThrow(
				() -> new ResourceNotFoundException("Doctor", "Id", doctor_id));
		existingDoctor.setDoctor_id(doctor.getDoctor_id());
		existingDoctor.setDoctor_name(doctor.getDoctor_name());
		existingDoctor.setDoctor_age(doctor.getDoctor_age());
		existingDoctor.setDoctor_gender(doctor.getDoctor_gender());
		existingDoctor.setDoctor_specialistFields(doctor.getDoctor_specialistFields());
		doctorRepository.save(existingDoctor);
		return existingDoctor;
	}

	@Override
	public void deleteDoctor(int doctor_id) {
		doctorRepository.findById(doctor_id).orElseThrow(
				() -> new ResourceNotFoundException("Doctor", "Id", doctor_id));
		doctorRepository.deleteById(doctor_id);
		
	}

}
