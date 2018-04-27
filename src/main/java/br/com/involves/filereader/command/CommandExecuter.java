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
				command = new CountCommand(repository.getCidades());
			}
		} else if ("filter".equals(splitCommand[0]) && splitCommand.length == 3 && repository.getHeader().values().contains(splitCommand[1])) {
			command = new FilterCommand(repository, splitCommand[1], splitCommand[2]);
		}
		
		if (command != null)
			command.execute();
		else
			throw new InvalidCommandException("O comando " + commandIn + " não é um comando conhecido pelo sistema!");
	}
}
