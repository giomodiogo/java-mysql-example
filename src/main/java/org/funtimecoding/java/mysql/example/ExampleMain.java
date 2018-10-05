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
	static String PASS = "1234qwer";
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
			ResultSet resultSet = statement.executeQuery("SELECT a.ra, a.nome, c.nome as cidade FROM aluno a "
					+ "INNER JOIN cidade c ON (a.cod_cidade = c.codigo);");

			StringBuilder sb = new StringBuilder();
			while (resultSet.next()) {
				String nome = resultSet.getString("nome");
				String ra = resultSet.getString("ra");
				String cidade = resultSet.getString("cidade");

				sb.append("RA: ").append(ra).append("\n").append("Nome: ").append(nome).append("\n").append("Cidade: ")
						.append(cidade).append("\n\n");
			}

			JOptionPane.showMessageDialog(null, sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
