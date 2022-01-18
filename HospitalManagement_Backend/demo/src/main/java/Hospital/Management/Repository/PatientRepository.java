package Hospital.Management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Hospital.Management.Model.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
