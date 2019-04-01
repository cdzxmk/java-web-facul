package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Pais {

	private int id;
	private String nome;
	private long populacao;
	private double area;

	public Pais() {
	}
	
	public Pais(int id) {
		this.id = id;
	}

	public Pais(int id, String nome, long populacao, double area) {
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}
	
	@Override
	public String toString() {
		return "Dados: [ID:" + getId() + " | Nome: " + getNome() + " | População: " + populacao + " | Área: " + getArea() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais outro = (Pais) obj;
		if (nome == null) {
			if (outro.nome != null)
				return false;
		} else if (!nome.equals(outro.nome))
			return false;
		if (populacao != outro.populacao)
			return false;
		if (id != outro.id)
			return false;
		if (area != outro.area)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

}
