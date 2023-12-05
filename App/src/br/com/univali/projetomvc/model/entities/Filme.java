package br.com.univali.projetomvc.model.entities;

import java.util.HashSet;
import java.util.Set;

public class Filme {
  private String nome;
  private Diretor diretor;
  private Set<Ator> elenco;
  private double nota;

  public Filme(String nome, Diretor diretor, Set<Ator> elenco, double nota) {
    this.nome = nome;
    this.diretor = diretor;
    this.elenco = elenco;
    this.nota = nota;
  }

  public Filme(Filme filme) {
		this.nome = filme.getNome();
		this.diretor = new Diretor(filme.getDiretor());
		this.elenco = filme.getElenco();
		this.nota = filme.getNota();
	}

  public String getNome() { 
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Diretor getDiretor() { 
    return this.diretor;
  }

  public void setDiretor(Diretor diretor) {
    this.diretor = new Diretor(diretor);
  }

  public Set<Ator> getElenco(){
    return new HashSet<Ator>(elenco);
  }

   public void getElenco(Set<Ator> ator){
    this.elenco.add((Ator) ator);
  }

  public double getNota() { 
    return this.nota;
  }

  public void setNota(double nota) {
    this.nota = nota;
  }

}
