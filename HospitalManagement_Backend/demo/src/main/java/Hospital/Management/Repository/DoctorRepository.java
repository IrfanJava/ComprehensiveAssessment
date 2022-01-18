package Hospital.Management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Hospital.Management.Model.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
