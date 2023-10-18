package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Manifestacao {

	private static String tipo;
	private static String texto;
	static Pessoa pessoa;

	public Manifestacao(String tipo, String texto, Pessoa pessoa) {
		super();
		this.tipo = tipo;
		this.texto = texto;
		this.pessoa = pessoa;

	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	// INSERIR textoS NO BANCO DE DADOS
	public static void inserirtexto(Connection con) {
		String sql = "insert into manifestacao(tipo,texto,pessoa_id) values (?,?,?)";
		try {
			PreparedStatement s = con.prepareStatement(sql);
			s.setString(1, tipo);
			s.setString(2, texto);
			s.setInt(3, pessoa.getPessoaID(con));
			s.executeUpdate();
			System.out.println("Manifestação Incluida om Sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void listar(Connection con) {
		Scanner sc = new Scanner(System.in);
		String sql = "";
		int tipo = sc.nextInt();
		sc.nextLine();
		if (tipo == 1) {
			sql = "select * from manifestacao where tipo = 'Elogio'";
		}
		if (tipo == 2) {
			sql = "select * from manifestacao where tipo = 'Sugestão'";
		}
		if (tipo == 3) {
			sql = "select * from manifestacao where tipo = 'Reclamação'";
		}
		if (tipo == 4) {
			sql = "select * from manifestacao";
		}

		try {
			PreparedStatement s = con.prepareStatement(sql);
			ResultSet resultado = s.executeQuery();
			while (resultado.next()) {
				System.out.printf("id: %d, Tipo: %s, Texto: %s, %s%n", resultado.getInt("id"),
						resultado.getString("tipo"), resultado.getString("texto"),
						Pessoa.listarPessoabyID(con, resultado.getInt("pessoa_id")));

			}
		} catch (SQLException e) {
			System.out.println("Banco de Dados Sem Informação.");
			e.printStackTrace();
		}
	}
		
	// APAGAR textoS NO BANCO DE DADOS

	public static void apagar(Connection con, int id) {

		System.out.print("Qual item deseja apagar: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String sql;
		// Se não for digitado nada sai da tela
		if (input.isEmpty()) {
			System.out.println("Tarefa interrompida. Nenhum valor digitado.");
			
			
		} else {
			try {
				id = Integer.parseInt(input); // Se não for inteiro sai da tela
											
				if (id == 0) { // Apaga todas as ocorrencias
					sql = "truncate manifestacao";
				} else { // Apaga ocorrencia especifica
					sql = "delete from manifestacao where id= " + id;
				}
				try { // Conecxao com o BD
					Statement s = con.createStatement();
					s.executeUpdate(sql);
					System.out.println("Ocorrencia Apagada com Sucesso!");
					System.out.println("Tecla Enter para Continuar!");
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (NumberFormatException e) { //Se nõ for inteiro interrompe a tarefa
				System.out.println("Valor inválido. O valor digitado não é um número inteiro.");
				
			}

		}
	}
}