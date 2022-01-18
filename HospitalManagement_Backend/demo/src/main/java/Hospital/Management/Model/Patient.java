package Hospital.Management.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int patient_id;
	
	@Column(name="patient_name")
	private String patient_name;
	
	@Column(name="Patient_visitedDoctor")
	private String Patient_visitedDoctor;
	
	@Column(name="patient_dateOfVisit")
	private Date patient_dateOfVisit;
	
	
	public Patient() {
		
	}
	
	public Patient(int patient_id, String patient_name, String patient_visitedDoctor, Date patient_dateOfVisit) {
		super();
		this.patient_id = patient_id;
		this.patient_name = patient_name;
		Patient_visitedDoctor = patient_visitedDoctor;
		this.patient_dateOfVisit = patient_dateOfVisit;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getPatient_visitedDoctor() {
		return Patient_visitedDoctor;
	}
	public void setPatient_visitedDoctor(String patient_visitedDoctor) {
		Patient_visitedDoctor = patient_visitedDoctor;
	}
	public Date getPatient_dateOfVisit() {
		return patient_dateOfVisit;
	}
	public void setPatient_dateOfVisit(Date patient_dateOfVisit) {
		this.patient_dateOfVisit = patient_dateOfVisit;
	}
}
