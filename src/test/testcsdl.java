package test;

import java.sql.Connection;

import database.jdbc;

public class testcsdl {
	public static void main(String[] args) {
		Connection connection = jdbc.getConnection();
		System.out.println(connection);
		
	}

}
