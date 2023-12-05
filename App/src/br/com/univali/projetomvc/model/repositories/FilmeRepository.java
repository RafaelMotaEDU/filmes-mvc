package br.com.univali.projetomvc.model.repositories;

import java.util.HashSet;
import java.util.Set;
import br.com.univali.projetomvc.model.entities.*;

public class FilmeRepository {
  private Set<Filme> filmes;
	
	public FilmeRepository() {
		this.filmes = new HashSet<Filme>();
	}
	
	public boolean addFilme(Filme filme) {	
		return this.filmes.add(filme);
	}
	
	public HashSet<Filme> getFilmes(){
		return new HashSet<Filme>(this.filmes);
	}
    
}
