package br.com.involves.filereader.command;

import java.util.List;
import java.util.Map;

public class CountCommand implements Command {

	List<Map<String, String>> dados;	
	
	public CountCommand(List<Map<String, String>> dados) {
		super();
		this.dados = dados;
	}


	@Override
	public void execute() {
		long count = dados.size();
		System.out.println("Total: " + count);
	}

}
