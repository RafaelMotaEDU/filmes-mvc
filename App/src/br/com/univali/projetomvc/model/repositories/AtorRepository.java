package br.com.univali.projetomvc.model.repositories;

import java.util.HashSet;
import java.util.Set;
import br.com.univali.projetomvc.model.entities.*;

public class AtorRepository {
  private Set<Ator> atores;

  public AtorRepository() {
    this.atores = new HashSet<Ator>();
  }

  public Set<Ator> getAtores(){
    return new HashSet<Ator>(this.atores);
  }

  public boolean removeAtor(Ator ator) {
		return this.atores.remove(ator);
	}
	
  public boolean addAtor(Ator ator){
    return this.atores.add(ator);
  }

  public Ator getAtor(String nome){
    for(Ator ator : this.atores){
      if(ator.getNome().equals(nome)){
        return ator;
      }
    }

    return null;
  }
}
