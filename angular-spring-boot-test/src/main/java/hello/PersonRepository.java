package hello;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	@Query("SELECT p FROM PERSON p  WHERE p.lastName LIKE :lName")
	List<Person> findByLastName(@Param("lName") String lName);
	
	@Query("SELECT p FROM PERSON p  WHERE p.firstName LIKE :fName")
	List<Person> findByFirstName(@Param("fName") String fName);

	@Query("SELECT p FROM PERSON p  WHERE p.firstName LIKE :fName AND p.lastName LIKE :lName")
	List<Person> findByFirstNameAndLastName(@Param("fName") String fName,@Param("lName") String lName);
	

}
