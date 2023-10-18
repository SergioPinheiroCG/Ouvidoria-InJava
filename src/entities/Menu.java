package entities;

import java.util.Scanner;

public class Menu {

	Scanner sc = new Scanner(System.in);

	public void login() {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║             SEJA BEM VINDO!            ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║                                        ║");
		System.out.println("║     *   SISTEMA DE OUVIDORIA  *        ║");
		System.out.println("║                                        ║");
		System.out.println("║       POR FAVOR DIGITE SEU NOME        ║");
		System.out.println("║            E SUA MATRICULA             ║");
		System.out.println("║       PARA TER ACESSO AO SISTEMA       ║");
		System.out.println("║                                        ║");
		System.out.println("║                             Systems V.3║");
		System.out.println("╚════════════════════════════════════════╝");

	}

	public void menuPrincipal() {

		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║          SISTEMA DE OUVIDORIA          ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║            MENU DA OUVIDORIA           ║");
		System.out.println("║         O QUE VOCÊ DESEJA FAZER?       ║");
		System.out.println("║                                        ║");
		System.out.println("║ 1) Adicionar Ocorrências               ║");
		System.out.println("║ 2) Listar Ocorrências                  ║");
		System.out.println("║ 3) Remover Ocorrencias                 ║");
		System.out.println("║ 4) Sair do Sistema.                    ║");
		System.out.println("║                                        ║");
		System.out.println("║                             Systems V.3║");
		System.out.println("╚════════════════════════════════════════╝");
		System.out.print("Digite sua Opção: ");
	}

	public void menuInserir() {

		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║          SISTEMA DE OUVIDORIA          ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║QUAL TIPO DE OCORRENCIA  DESEJA INSERIR?║");
		System.out.println("║                                        ║");
		System.out.println("║ 1) Inserir - Elogio                    ║");
		System.out.println("║ 2) Inserir - Sugestão                  ║");
		System.out.println("║ 3) Inserir - Reclamação                ║");
		System.out.println("║                                        ║");
		System.out.println("║                                        ║");
		System.out.println("║                             Systems V.3║");
		System.out.println("╚════════════════════════════════════════╝");
		System.out.print("Digite sua Opção: ");

	}

	public void menuListar() {

		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║          SISTEMA DE OUVIDORIA          ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║ QUAL TIPO DE OCORRENCIA DESEJA LISTAR? ║");
		System.out.println("║                                        ║");
		System.out.println("║ 1) Listar Elogios                      ║");
		System.out.println("║ 2) Listar Sugestões                    ║");
		System.out.println("║ 3) Lisar Reclamações                   ║");
		System.out.println("║ 4) Listar Todas                        ║");
		System.out.println("║                                        ║");
		System.out.println("║                             Systems V.3║");
		System.out.println("╚════════════════════════════════════════╝");
		System.out.print("Digite sua Opção: ");
	}

	public void menuRemover() {

		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║          SISTEMA DE OUVIDORIA          ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║ QUAL TIPO DE OCORRENCIA DESEJA REMOVER?║");
		System.out.println("║                                        ║");
		System.out.println("║ 1) Remover Elogio                      ║");
		System.out.println("║ 2) Remover Sugestão                    ║");
		System.out.println("║ 3) Remover Relamação                   ║");
		System.out.println("║ 4) Remover Todas as Ocorrencias        ║");
		System.out.println("║                                        ║");
		System.out.println("║                             Systems V.3║");
		System.out.println("╚════════════════════════════════════════╝");

	}

	public void logout() {

		System.out.println("╔══════════════════════════════════════════╗");
		System.out.println("║      SISTEMA FINALIZADO COM SUCESSO!     ║");
		System.out.println("╠══════════════════════════════════════════╣");
		System.out.println("║ OBRIGADO POR UTILIZAR OS NOSSOS SISTEMAS ║");
		System.out.println("║         * SISTEMA DE OUVIDORIA *         ║");
		System.out.println("║               Version 3.0                ║");
		System.out.println("║                                          ║");
		System.out.println("║                                          ║");
		System.out.println("║           sermagpb@gmail.com             ║");
		System.out.println("║                                          ║");
		System.out.println("╚══════════════════════════════════════════╝");

	}

}
