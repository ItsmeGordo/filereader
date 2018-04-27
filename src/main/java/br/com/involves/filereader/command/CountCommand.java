package br.com.involves.filereader.command;

import java.util.List;

import br.com.involves.filereader.dto.Cidade;

public class CountCommand implements Command {

	private List<Cidade> cidades;
	
	
	public CountCommand(List<Cidade> cidades) {
		super();
		this.cidades = cidades;
	}


	@Override
	public void execute() {
		long count = cidades.size();
		System.out.println("Total: " + count);
	}

}
