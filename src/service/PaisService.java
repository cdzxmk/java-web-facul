package service;

import DAO.PaisDAO;
import model.Pais;

public class PaisService {
	
	PaisDAO p = new PaisDAO();
	
	public void inserir(Pais pais) {
		p.inserir(pais);
	}
	
	public Pais carregar(Pais pais) {
		return p.carregar(pais);
	}
	
	public void excluir(Pais pais) {
		p.excluir(pais);

	}
	
	public void atualizar(Pais pais) {
		p.atualizar(pais);

	}
	
	public void maiorPopulacao(Pais pais) {
		p.maiorPopulacao(pais);

	}
	
	public void vetorTresPaises(Pais pais) {
		p.vetorTresPaises(pais);
	}
	
	public void menorArea(Pais pais) {
		p.menorArea(pais);
	}
	
	
	

}
