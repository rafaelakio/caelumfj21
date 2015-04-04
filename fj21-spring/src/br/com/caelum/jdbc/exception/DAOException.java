package br.com.caelum.jdbc.exception;

import java.sql.SQLException;

public class DAOException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 25426843027973762L;

	public DAOException(SQLException m) {
		System.out.println(m.getErrorCode());
		System.out.println(m.getSQLState());
		System.out.println(m.getMessage());
		m.printStackTrace();
	}
	
	public DAOException(Exception m) {
		m.printStackTrace();
	}
}
