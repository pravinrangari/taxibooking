package tech.codehunt.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import tech.codehunt.model.Admin;
import java.util.List;
import java.util.Optional;


public interface Admindao  extends JpaRepository<Admin, Integer>{
	
	Optional<Admin> findByUsername(String username);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE admin SET username = :newusername, password = :newpassword WHERE username = :oldusername", nativeQuery = true)
	public int updateCredentials(@Param("newusername") String newusername, 
	                             @Param("newpassword") String newpassword, 
	                             @Param("oldusername") String oldusername
	                         );


	
}
