package entities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Reclamacao extends Manifestacao {

	public Reclamacao(String tipo, String texto, Pessoa pessoa) {
		super(tipo, texto, pessoa);
		this.setTipo("Reclamacao");

	}

	@Override
	public String toString() {
		return "Reclamação / Aluno = " + super.pessoa.getNome() + "- texto =" + super.getTexto() + "";

	}
}