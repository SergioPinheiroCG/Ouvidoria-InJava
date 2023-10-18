// Unifacisa - Centro Universitário
// Sistemas de Informação
// Disciplina..: Programar em Linguagem Orientada a Objetos Básica
// Período.....: 1º Semestre 2023
// Professor...: Diego Braga Viana
// Aluno.......: Sérgio Magno Castor Pinheiro

package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DB;
import entities.Elogio;
import entities.Menu;
import entities.Pessoa;
import entities.Reclamacao;
import entities.Sugestao;
import entities.Manifestacao;

public class Program {

	public static void main(String[] args) {
		Connection con = DB.getConnection(); //CONCXAO COM BANCO
		Scanner sc = new Scanner(System.in);

		// INSTANCIAR MENU NA CLASSE MENU
		Menu menu = new Menu();

		menu.login();
		System.out.print("Digite seu matricula: ");
		String matricula = sc.nextLine();
		System.out.print("Digite seu nome: ");
		String nome = sc.nextLine();
		System.out.print("Digite seu email: ");
		String email = sc.nextLine();
		Pessoa pessoa = new Pessoa(nome, matricula, email);
		pessoa.inserir(con);

		
		String opcao = "1";
		while (opcao != "0") {
			menu.menuPrincipal();
			opcao = sc.nextLine();
			switch (opcao) {

			case "1": //PARA INSERIR textoS O CODIGO VAI CHAMAR AS CLASSSES MENU/MANIFESTACAO

				menu.menuInserir();
				String tipotexto = sc.nextLine();

				if (tipotexto.equals("1")) {
					System.out.print("Digite Seu Elogio: ");
					String elogioInput = sc.nextLine();
					Elogio elogio = new Elogio(tipotexto, elogioInput, pessoa);
					Manifestacao.inserirtexto(con);
					break;
				}

				if (tipotexto.equals("2")) {
					System.out.print("Digite Sua Sugestão: ");
					String sugestaoInput = sc.nextLine();
					Sugestao sugestao = new Sugestao(tipotexto, sugestaoInput, pessoa);
					Manifestacao.inserirtexto(con);
					break;

				}

				if (tipotexto.equals("3")) {
					System.out.print("Digite Sua Reclamacao: ");
					String reclamacaoInput = sc.nextLine();
					Reclamacao reclamacao = new Reclamacao(tipotexto, reclamacaoInput, pessoa);
					Manifestacao.inserirtexto(con);
					break;
					
				} else {
					System.out.println("Por favor Digite um Valor Válido!");
					System.out.println("Tecla Enter para Continuar!");
					sc.nextLine();
					break;
				}

			case "2": //PARA LISTAR AS textoS VAI CHAMAR AS CLASSES MENU / MANIFESTACAO
				menu.menuListar();
				Manifestacao.listar(con);

				
				System.out.println("Tecla Enter para Continuar!");
				sc.nextLine();
				break;

			case "3": // PARA EXCLUIR UMA texto PRIMEIRO PRECISA PASSAR UMA SENHA DE PERMISSAO (987654321) APOS ISSO O SISTEMA
					  // LIBERA PARA APAGAR texto CASO NAO O SISTEMA VOLTA PARA O MENU
					  // VAI UTILIZAR AS CLASSES MENU / MANIFESTACAO
				
				if (pessoa.getmatricula().equals("987654321")) {

					menu.menuRemover();
					System.out.print("Digite sua Opção: ");
					Manifestacao.listar(con);
					Manifestacao.apagar(con, 0);
					break;
									
					
				} else {
					System.out.println("Usuario sem permissao para remover Ocorrencias!");
					System.out.println("Tecla Enter para Continuar!");
					sc.nextLine();
				}
				break;

			case "4": // CONDICAO DE SAIDA DO SISTEMA - UTILIZA A CLASSE MENU PARA CHAMAR TELA DE SAIDA
				opcao = "0";
				menu.logout();
				break;

			default:
				System.out.println("Por favor Digite um Valor Válido!");
				System.out.println("Tecla Enter para Continuar!");
				sc.nextLine();
				break;

			}
		}

		sc.close();

	}

}
