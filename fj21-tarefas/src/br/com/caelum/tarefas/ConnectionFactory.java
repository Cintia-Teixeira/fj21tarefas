package br.com.caelum.tarefas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

	public Connection getConnection() throws SQLException {
		System.out.println("conectando ...");

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}

		Connection connection = DriverManager
				.getConnection("jdbc:sqlite:C:/Users/cmtsi/eclipse-workspace/fj21-tarefas/banco.db");

		Statement statement = connection.createStatement();

		// criando uma tabela
		String tabelaTarefas = "CREATE TABLE IF NOT EXISTS tarefas ("
				+ " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," + " descricao VARCHAR(255),"
				+ " finalizado BOOLEAN," + " dataFinalizacao DATE" + ")";

		statement.execute(tabelaTarefas);

		// criando usuário
		String tabelaUsuarios = "CREATE TABLE IF NOT EXISTS usuarios (" + " login VARCHAR(255)," + " senha VARCHAR(255)"
				+ " usuario VARCHAR(255)"
				+ ")"; 
		statement.execute(tabelaUsuarios);



		// lendo os registros
		PreparedStatement stmt = connection.prepareStatement("select * from usuarios");
		ResultSet resultSet = stmt.executeQuery();

		while (resultSet.next()) {
			String login = resultSet.getString("login");
			String senha = resultSet.getString("senha");
			String usuario = resultSet.getString("usuario");

			System.out.println(login + " - " + senha + " - " + usuario);
		}

		return connection;
	}

}