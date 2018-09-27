package org.funtimecoding.java.mysql.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ExampleMain {
	static String HOST = "localhost";
	static String PORT = "3306";
	static String USER = "root";
	static String PASS = "univel";
	// static String PASS = "univel";
	static String DATA_BASE = "example_java_mysql";

	public static void main(String[] args) {
		ExampleMain main = new ExampleMain();

		try {
			main.run();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private void run() throws SQLException, ClassNotFoundException {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			String connectionURL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATA_BASE
					+ "?autoReconnect=true&useSSL=false";

			Connection connection = DriverManager.getConnection(connectionURL, USER, PASS);

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM aluno");

			StringBuilder sb = new StringBuilder();
			while (resultSet.next()) {
				String codigo = resultSet.getString("codigo");
				String nome = resultSet.getString("nome");
				String ra = resultSet.getString("ra");

				sb.append(codigo).append(" | ").append(nome).append(" | ").append(ra).append("\n");
			}

			JOptionPane.showMessageDialog(null, sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
