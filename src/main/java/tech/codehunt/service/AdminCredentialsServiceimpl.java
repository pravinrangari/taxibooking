package tech.codehunt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tech.codehunt.dao.Admindao;
import tech.codehunt.model.Admin;

@Service
public class AdminCredentialsServiceimpl implements AdminCredentialsService {

	    private Admindao adminDao;
	    private PasswordEncoder passwordEncoder;

	    @Autowired
	    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
	        this.passwordEncoder = passwordEncoder;
	    }

	    @Autowired
	    public void setAdminDao(Admindao adminDao) {
	        this.adminDao = adminDao;
	    }
	

	@Override
	public String checkAdminCredentials(String oldusername, String oldpassword) {
		
		Optional<Admin> byUsername = adminDao.findByUsername(oldusername);
		if (byUsername.isPresent()) {
		       
			Admin admin = byUsername.get(); //sn password username
			boolean matches = passwordEncoder.matches(oldpassword, admin.getPassword());
			if (matches) {
				return "SUCCESS";
			}else {
				return "Wrong Old Credentials";
			}
		}else {
			return "Wrong  Old Credentials";
		}
		
	}

	@Override
	public String updateAdminCredentials(String newusername, String newpassword, String oldusername) {
		
		int updateCredentials = adminDao.updateCredentials(newusername,passwordEncoder.encode(newpassword), oldusername);
		if (updateCredentials==1) {
			return "CREDENTIAL UPDATED SUCCESSFULLY";
		}else {
			return "FAIL TO UPDATE";
		}
		
	}

}
     