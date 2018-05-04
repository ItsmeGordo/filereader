package br.com.involves.filereader.command;

import java.util.List;
import java.util.Map;

import br.com.involves.filereader.utils.PrintDataUtils;

public class FilterCommand implements Command {

	private List<Map<String, String>> dados;
	private String coluna;
	private String valor;

	public FilterCommand(List<Map<String, String>> dados, String coluna, String valor) {
		super();
		this.dados = dados;
		this.coluna = coluna;
		this.valor = valor;
	}

	@Override
	public void execute() {
		dados.stream().filter(c -> c.get(coluna).toString().equals(valor)).forEach(c -> PrintDataUtils.printCollectionData(c.values()));

	}
	
}
