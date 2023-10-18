package entities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Elogio extends Manifestacao {

	public Elogio(String tipo, String texto, Pessoa pessoa) {
		super(tipo, texto, pessoa);
		this.setTipo("Elogio");
		
	}

	@Override
	public String toString() {
		return "Elogio / Aluno = " + super.pessoa.getNome() + "- texto =" + super.getTexto() + "";
	}

}
