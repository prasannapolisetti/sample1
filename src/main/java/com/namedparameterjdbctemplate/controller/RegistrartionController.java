package com.namedparameterjdbctemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.namedparameterjdbctemplate.registration.Registration;
import com.namedparameterjdbctemplate.service.RegistrationService;

@RestController
public class RegistrartionController {
@Autowired
RegistrationService regserv;

@PostMapping("/inserting")
public String insert(@RequestBody Registration reg) {
	int i=regserv.insert(reg);
	if(i>0) {
		return "inserted";
	}
	else {
		return "not inserted";
	}
}
@PutMapping("/updating")
public String update(@RequestBody Registration reg) {
regserv.update(reg);
return "updated";
}
@DeleteMapping("/deleting")
public String delete(@RequestBody Registration reg) {
regserv.delete(reg);
return "deleted";
}
@GetMapping("/getting")
public List get() {
	
	return regserv.get();
}
}