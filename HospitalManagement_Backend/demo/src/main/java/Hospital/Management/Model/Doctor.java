package Hospital.Management.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int doctor_id;
	
	@Column(name="doctor_name")
	private String doctor_name;
	
	@Column(name="doctor_age")
	private int doctor_age;
	
	@Column(name="doctor_gender")
	private String doctor_gender;
	
	@Column(name="doctor_specialistFields")
	private String doctor_specialistFields;

	public Doctor() {
		
	}
	public Doctor(int doctor_id, String doctor_name, int doctor_age, String doctor_gender,
			String doctor_specialistFields) {
		super();
		this.doctor_id = doctor_id;
		this.doctor_name = doctor_name;
		this.doctor_age = doctor_age;
		this.doctor_gender = doctor_gender;
		this.doctor_specialistFields = doctor_specialistFields;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public int getDoctor_age() {
		return doctor_age;
	}
	public void setDoctor_age(int doctor_age) {
		this.doctor_age = doctor_age;
	}
	public String getDoctor_gender() {
		return doctor_gender;
	}
	public void setDoctor_gender(String doctor_gender) {
		this.doctor_gender = doctor_gender;
	}
	public String getDoctor_specialistFields() {
		return doctor_specialistFields;
	}
	public void setDoctor_specialistFields(String doctor_specialistFields) {
		this.doctor_specialistFields = doctor_specialistFields;
	}
	
}
