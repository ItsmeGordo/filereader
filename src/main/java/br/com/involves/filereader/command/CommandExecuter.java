package br.com.involves.filereader.command;

import br.com.involves.filereader.exception.InvalidCommandException;
import br.com.involves.filereader.repository.CsvRepository;

public class CommandExecuter {

	private CsvRepository repository;

    public CommandExecuter(CsvRepository repository) {
        this.repository = repository;
    }
    
	public void executeCommand(String commandIn) { 

		String[] splitCommand = commandIn.split(" ");
		Command command = null;

		if (splitCommand.length < 2) {
			throw new InvalidCommandException("O comando " + commandIn + " não é um comando conhecido pelo sistema!");
		} else if ("count".equalsIgnoreCase(splitCommand[0])) {
			if ("*".equals(splitCommand[1])) {
				command = new CountCommand(repository.getCidades());
			} else if ("distinct".equalsIgnoreCase(splitCommand[1])) {
				if (splitCommand.length > 2 && splitCommand[2] != null)
					command = new CountDistinctCommand(repository, splitCommand[2]);
				else
					throw new InvalidCommandException("O comando correto seria count distinct [coluna]");
			}
		} else if ("filter".equals(splitCommand[0]) && splitCommand.length >= 3 && repository.getHeader().values().contains(splitCommand[1])) {
			StringBuffer buffer = new StringBuffer();
			for (int i = 2; i < splitCommand.length; i++) {
				buffer.append(splitCommand[i]);
				buffer.append(" ");
			}
			command = new FilterCommand(repository, splitCommand[1], buffer.toString().trim());
		}
		
		if (command != null)
			command.execute();
		else
			throw new InvalidCommandException("O comando " + commandIn + " não é um comando conhecido pelo sistema!");
	}
}
