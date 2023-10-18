package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pessoa {
	private String nome;
	private String matricula;
	private String email;

	public Pessoa(String nome, String matricula, String email) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getmatricula() {
		return matricula;
	}

	public void setmatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "pessoa [nome=" + nome + ", matricula=" + matricula + ", email=" + email + "]";
	}


	public void inserir(Connection con) {
		try {
			// Verificar se a matrícula já existe no banco de dados
			String selectQuery = "SELECT COUNT(*) FROM pessoa WHERE matricula = ?";
			PreparedStatement verificaMatricula = con.prepareStatement(selectQuery);
			verificaMatricula.setString(1, getmatricula());	
			ResultSet resultSet = verificaMatricula.executeQuery();
			resultSet.next();
			int count = resultSet.getInt(1);

			if (count > 0) {
				System.out.println("Matrícula já existe no banco de dados.");
				// Aqui você pode tratar o caso em que a matrícula já existe,
				// por exemplo, lançar uma exceção ou retornar um valor indicando o erro.
			} else {
				// Inserir os dados no banco de dados
				String insertQuery = "INSERT INTO pessoa (nome, matricula, email) VALUES (?, ?, ?)";
				PreparedStatement inserirMatricula = con.prepareStatement(insertQuery);
				inserirMatricula.setString(1, nome);
				inserirMatricula.setString(2, matricula);
				inserirMatricula.setString(3, email);
				inserirMatricula.executeUpdate();
				System.out.println("Dados salvos no banco.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	
//	public void inserir(Connection con) {
//		String sql = "insert into pessoa(nome,matricula,email)values('" + nome + "','" + matricula + "','"
//				+ email + "')";
//		try {
//			Statement s = con.createStatement();
//			s.executeUpdate(sql);
//			System.out.println("dados salvos no banco");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public int getPessoaID(Connection con) {
		String sql = "select id from pessoa where matricula = (?)";
		try {
			PreparedStatement s = con.prepareStatement(sql);
			s.setString(1, this.matricula);
			ResultSet resultado = s.executeQuery();
			resultado.next();
			return resultado.getInt("id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public static String listarPessoabyID(Connection con, int id) {
		String sql = "select * from pessoa where id = (?)";
		try {
			PreparedStatement s = con.prepareStatement(sql);
			s.setInt(1, id);
			ResultSet resultado = s.executeQuery();
			resultado.next();
			return "Nome:" + resultado.getString("nome")+ ", Matricula:" + resultado.getString("matricula");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return "";
	}
	
	
	
}
