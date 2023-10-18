package entities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Sugestao extends Manifestacao {

	public Sugestao(String tipo, String texto, Pessoa pessoa) {
		super(tipo, texto, pessoa);
		this.setTipo("Sugestão");

	}

	@Override
	public String toString() {
		return "Sugestão / Aluno = " + super.pessoa.getNome() + "- texto =" + super.getTexto() + "";

	}

}
