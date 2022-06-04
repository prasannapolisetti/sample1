package com.namedparameterjdbctemplate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;import org.springframework.web.bind.annotation.RequestBody;

import com.namedparameterjdbctemplate.registration.Registration;

@Service
public class RegistrationService {
@Autowired
NamedParameterJdbcTemplate namedjdbc;
public int insert(Registration reg) {
	String sql="insert into registration463 values(:name,:gmail,:password,:address)";
	SqlParameterSource param=new  MapSqlParameterSource()
			.addValue("name",reg.getName())
			.addValue("gmail",reg.getGmail())
			.addValue("password",reg.getPassword())
			.addValue("address",reg.getAddress());
		return namedjdbc.update(sql,param);	
}
public int update(Registration reg) {
String sql="update registration463 set name=:name where address=:address";
SqlParameterSource param=new  MapSqlParameterSource()
           .addValue("name",reg.getName())
           .addValue("address",reg.getAddress());
       return namedjdbc.update(sql,param);
}
public int delete(Registration reg) {
String sql="delete from  registration463 where address=:address";
SqlParameterSource param=new  MapSqlParameterSource()
           .addValue("address",reg.getAddress());
       return namedjdbc.update(sql,param);
}
public List get() {
	String sql="select * from registration463";
	SqlParameterSource param=new  MapSqlParameterSource();
	return namedjdbc.queryForList(sql,param);
}
}