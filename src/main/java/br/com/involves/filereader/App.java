package br.com.involves.filereader;

import java.io.BufferedReader;
import java.util.Scanner;

import br.com.involves.filereader.command.CommandExecuter;
import br.com.involves.filereader.reader.CSVReader;
import br.com.involves.filereader.repository.CsvRepository;

public class App {

	
	public static void main(String[] args) {
		CSVReader csvReader = new CSVReader();
		BufferedReader br = csvReader.reader("cidades.csv");
		CsvRepository repository = csvReader.process(br);

		printCommands();
    	System.out.println("\nColunas disponiveis:");
    	repository.printColumns();
    	waitCommand(repository);

	}

	private static void waitCommand(CsvRepository repository) {
        String commandIn;
        Scanner scanner = new Scanner(System.in);
        CommandExecuter executer = new CommandExecuter(repository);
        System.out.println("Digite um comando:");
        while((commandIn = scanner.nextLine()) != null) {
            try {
                executer.executeCommand(commandIn);
                System.out.println("Digite um novo comando:");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Digite um novo comando:");
            }
        }
    }
	
    private static void printCommands() {
        System.out.println("\nComandos permitidos");
        System.out.println("count * ");
        System.out.println("count distinct [propriedade]");
        System.out.println("filter [propriedade] [valor]");
    }

}
