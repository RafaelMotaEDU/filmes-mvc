package br.com.univali.projetomvc.model.repositories;

import java.util.HashSet;
import java.util.Set;
import br.com.univali.projetomvc.model.entities.*;

public class DiretorRepository {
     private Set<Diretor> diretores;

  public DiretorRepository() {
    this.diretores = new HashSet<Diretor>();
  }

  public boolean addDiretor(Diretor diretor) {
		return this.diretores.add(diretor);
	}
	
	public Set<Diretor> getDiretores(){
		return new HashSet<Diretor>(this.diretores);
	}

  public boolean removeDiretor(Diretor diretor) {
		return this.diretores.remove(diretor);
	}

  public Diretor getDiretor(String nome){
    for(Diretor diretor : this.diretores){
      if(diretor.getNome().equals(nome)){
        return diretor;
      }
    }

    return null;
  }
}
