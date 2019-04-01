package JUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runners.MethodSorters;

import DAO.PaisDAO;
import connectionFactory.ConnectionFactory;
import model.Pais;

import org.junit.jupiter.api.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class PaisTest {

	Pais pais, copia;
	PaisDAO p;
	static int id = 0;
	
	@BeforeEach
	void setUp() throws Exception {
		p = new PaisDAO();
		System.out.println("setup");
		pais = new Pais(11, "Fran�a", 65844000, 551500); 
		copia = new Pais(11, "Fran�a", 65844000, 551500); 
		System.out.println(pais);
		System.out.println(copia);
	}

	@Test
	void test00Carregar() {
		p = new PaisDAO();
		System.out.println("carregar");
		Pais p1 = new Pais(1, "Afeganist�o", 31108077, 652090);
		Pais p2 = new Pais(1);
		p.carregar(p2);
		assertEquals("Teste carregar", p2, p1);
	}
	
	@Test
	void test015ConexaoComBanco() throws SQLException {
		try {
			ConnectionFactory.obtemConexao();
			System.out.println("conectou");
			
		} catch (SQLException e) {
			
			System.out.println("N�o conectou");
		}
		
	}
	
	@Test
	public void test01Insert() {
		p = new PaisDAO();
		System.out.println("inserir");
		p.inserir(pais);
		id = pais.getId();
		System.out.println(id);
		copia.setId(id);
		assertEquals("Testa inclus�o", pais, copia);
	}
	
	@Test
	public void test02Atualizar() {
		p = new PaisDAO();
		System.out.println("atualizar");
		p.inserir(pais);
		pais.setPopulacao(55555);
		copia.setPopulacao(55555);
		p.atualizar(pais);
		p.carregar(pais);
		assertEquals("Testa atualiza��o", pais, copia);
	}
	
	@Test
	public void test03Excluir() {
		System.out.println("Excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0.0);
		p.excluir(pais);
		p.carregar(pais);
		assertEquals("testa exclus�o", pais, copia);
	}
	
	@Test
	public void test04maiorPopulacao() {
		System.out.println("Maior popula��o");
		p.maiorPopulacao(pais);
		copia.setId(10);
		p.carregar(copia);
		assertEquals("testa m�todo que retorna o pa�s com maior popula��o", pais, copia);
	}
	
	@Test
	public void test05menorArea() {
		System.out.println("Menor �rea");
		p.menorArea(pais);
		copia.setId(2);
		p.carregar(copia);
		assertEquals("testa m�todo que retorna o pa�s com a menor �rea", pais, copia);
	}
	
	@Test
	public void test06vetorTresPaises() {
		System.out.println("Vetor de tr�s pa�ses");
		Pais[] v1 = p.vetorTresPaises(pais);
		Pais[] v2 = new Pais[] {v1[0], v1[1], v1[2]};
		Assert.assertArrayEquals(v1, v2);
	}
	
	
	
}
