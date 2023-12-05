package br.com.univali.projetomvc.model.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import br.com.univali.projetomvc.model.dtos.*;
import br.com.univali.projetomvc.model.entities.*;
import br.com.univali.projetomvc.model.repositories.*;

public class FilmeService {
  private FilmeRepository filmeRepository;
	private AtorRepository atorRepository;
	private DiretorRepository diretorRepository;
	
	public FilmeService() {
		this.filmeRepository = new FilmeRepository();
		this.atorRepository = new AtorRepository();
		this.diretorRepository = new DiretorRepository();
	}

  public boolean addFilme(String nome, String nomeDiretor, String atores[], double nota){
    Diretor diretor = new Diretor(nomeDiretor);

    this.diretorRepository.addDiretor(diretor);
    Set<Ator> elenco = new HashSet<Ator>();

    for(String nomeAtor: atores){
      Ator ator = new Ator(nomeAtor);
      this.atorRepository.addAtor(ator);
      elenco.add(ator);
    }

    Filme filme = new Filme(nomeDiretor, diretor, elenco, nota);

    return this.filmeRepository.addFilme(filme);
  }

  public boolean addFilme(FilmeDto filmeDto) {
		return this.addFilme(filmeDto.getNome(), filmeDto.getDiretor(),
				filmeDto.getElenco(), filmeDto.getNota());
	}
	
	public List<FilmeDto> listaFilmesPorNome(){
		List<Filme> filmesFiltrados = new ArrayList<Filme>(
				this.filmeRepository.getFilmes() );
		
		filmesFiltrados.sort((o1, o2) -> {
				return o1.getNome().compareTo(o2.getNome());
		});
		
		return converteListaFilmeParaDto(filmesFiltrados);
	}
	
	public List<FilmeDto> listaFilmesPorDiretor(String diretor){
		
		ArrayList<Filme> filmesFiltrados = new ArrayList<Filme>();
		
		HashSet<Filme> filmes = this.filmeRepository.getFilmes();
		
		Iterator<Filme> i = filmes.iterator();
		
		while(i.hasNext()) {
			Filme f = i.next();
			
			if(f.getDiretor().getNome().equals(diretor)) {
				filmesFiltrados.add(new Filme(f));
			}
		}
		
		return converteListaFilmeParaDto(filmesFiltrados);
	}
	
	public List<FilmeDto> listaFilmesPorAtor(String ator){
		
		ArrayList<Filme> filmesFiltrados = new ArrayList<Filme>();
		
		HashSet<Filme> filmes = this.filmeRepository.getFilmes();
		
		Iterator<Filme> i = filmes.iterator();
		
		while(i.hasNext()) {
			Filme f = i.next();
			
			Iterator<Ator> j = f.getElenco().iterator();
			
			while(j.hasNext()) {				
				Ator a = j.next();
				
				if(a.getNome().equals(ator)) {
					filmesFiltrados.add(new Filme(f));
					break;
				}				
			}
		}
		
		return converteListaFilmeParaDto(filmesFiltrados);
	}
	
	public List<FilmeDto> listaFilmesPorNota(double nota){
		ArrayList<Filme> filmesFiltrados = new ArrayList<Filme>();
		
		HashSet<Filme> filmes = this.filmeRepository.getFilmes();
		
		for(Filme f : filmes) {
			if(f.getNota() >= nota)
				filmesFiltrados.add(f);
		}
		
		return converteListaFilmeParaDto(filmesFiltrados);
	}
	
	private List<FilmeDto> converteListaFilmeParaDto(List<Filme> filmes){
		List<FilmeDto> filmesDto = new ArrayList<FilmeDto>();
		
		for(Filme f : filmes) {
			filmesDto.add(new FilmeDto(f));
		}
		
		return filmesDto;		
	}
	
	public boolean addAtor(String nome) {
		return this.atorRepository.addAtor(new Ator(nome));
	}
	
	public boolean removeAtor(String nome) {
		return this.atorRepository.removeAtor(new Ator(nome));
	}
	
	public Ator getAtor(String nome) {
		return atorRepository.getAtor(nome);
	}
	
	public List<String> listaAtores(){
		Set<Ator> atoresArray = this.atorRepository.getAtores();	
		
		ArrayList<String> atores = new ArrayList<>();
		
		for(Ator a : atoresArray)
			atores.add(a.getNome());
		
		return atores;
	}
	
	public boolean addDiretor(String nome) {
		return this.diretorRepository.addDiretor(new Diretor(nome));
	}
	
	public boolean removeDiretor(String nome) {
		return this.diretorRepository.removeDiretor(new Diretor(nome));
	}
	
	public List<String> listaDiretores(){
		
		Set<Diretor> diretoresArray = this.diretorRepository.getDiretores();
		
		ArrayList<String> diretores = new ArrayList<String>();
		
		for(Diretor d : diretoresArray)
			diretores.add(d.getNome());
		
		return diretores;
	}
	
}
