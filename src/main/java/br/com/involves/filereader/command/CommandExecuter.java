package br.com.involves.filereader.command;

import java.util.List;
import java.util.Map;

import br.com.involves.filereader.exception.InvalidCommandException;
import br.com.involves.filereader.exception.InvalidFilterException;

public class CommandExecuter {

	List<Map<String, String>> dados;

    public CommandExecuter(List<Map<String, String>> dados) {
        this.dados = dados;
    }
    
	public void executeCommand(String commandIn) { 

		String[] splitCommand = commandIn.split(" ");
		Command command = null;

		if (splitCommand.length < 2) {
			throw new InvalidCommandException("O comando " + commandIn + " não é um comando conhecido pelo sistema!");
		} else if ("count".equalsIgnoreCase(splitCommand[0])) {
			if ("*".equals(splitCommand[1])) {
				command = new CountCommand(dados);
			} else if ("distinct".equalsIgnoreCase(splitCommand[1])) {
				if (splitCommand.length > 2 && splitCommand[2] != null)
					if (propertyValidator(splitCommand[2]))
						command = new CountDistinctCommand(dados, splitCommand[2]);
					else 
						throw new InvalidFilterException("A coluna especificada não existe!");
				else
					throw new InvalidCommandException("O comando correto seria count distinct [coluna]");
			}
		} else if ("filter".equals(splitCommand[0]) && splitCommand.length >= 3) {
			StringBuffer buffer = new StringBuffer();
			if (propertyValidator(splitCommand[1])) {
				for (int i = 2; i < splitCommand.length; i++) {
					buffer.append(splitCommand[i]);
					buffer.append(" ");
				}
				command = new FilterCommand(dados, splitCommand[1], buffer.toString().trim());
			} else {
				throw new InvalidFilterException("A coluna especificada como filtro não existe!");
			}
		}
		
		if (command != null)
			command.execute();
		else
			throw new InvalidCommandException("O comando " + commandIn + " não é um comando conhecido pelo sistema!");
	}

	private boolean propertyValidator(String property) {
		return dados.get(0).keySet().contains(property);
	}
}
