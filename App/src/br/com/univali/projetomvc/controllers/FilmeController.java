package br.com.univali.projetomvc.controllers;

import java.util.List;

import br.com.univali.projetomvc.model.dtos.*;
import br.com.univali.projetomvc.model.services.*;;


public class FilmeController {
	
	private FilmeService filmeService;
	
	public FilmeController() {
		this.filmeService = new FilmeService();
	}
	
	public boolean addFilme(FilmeDto filmeDto) {
		
		if(!filmeDto.validate())
			return false;
		
		return filmeService.addFilme(filmeDto);		
	}
	
	public List<FilmeDto> listaFilmesPorNome(){
		return filmeService.listaFilmesPorNome();
	}
	
	public List<FilmeDto> listaFilmesPorDiretor(String diretor){
		return filmeService.listaFilmesPorDiretor(diretor);
	}
	
	public List<FilmeDto> listaFilmesPorAtor(String ator){
		return filmeService.listaFilmesPorAtor(ator);
	}
	
	public List<FilmeDto> listaFilmesPorNota(double nota){
		return filmeService.listaFilmesPorNota(nota);
	}
	
	public List<String> listaAtores(){
		return filmeService.listaAtores();
	}
	
	public List<String> listaDiretores() {
		return filmeService.listaDiretores();
	}
	
}