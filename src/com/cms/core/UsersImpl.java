package com.cms.core;

import java.io.BufferedReader;
import java.sql.ResultSet;

import com.cms.utils.JDBC_Connectivity;
import com.mysql.jdbc.PreparedStatement;

public class UsersImpl implements Users {
	
	@Override
	public String signIn(String value){
		String msg = "0-username or password is invalid!";
		String[] credentials = value.split(",");		
		System.out.println("Username: " + credentials[0]);
		System.out.println("Password: " + credentials[1]);
		
		try {
			String query = "select `id` from `users` where `username` = ? and `password` = ?;";
			PreparedStatement ps = JDBC_Connectivity.getPreparedStatement(query);
			ps.setString(1, credentials[0]);
			ps.setString(2, credentials[1]);			
			ResultSet rs = (ResultSet) ps.executeQuery();
			if (rs.next()){
				msg = rs.getString("id");
			}			
		} catch (Exception e){
			e.printStackTrace();
			msg = "00-Error:" + e.toString();
		}
		
		return msg;
	}
}
