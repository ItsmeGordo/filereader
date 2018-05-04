package br.com.involves.filereader;

import java.io.BufferedReader;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.involves.filereader.command.CommandExecuter;
import br.com.involves.filereader.reader.AbstractFileReader;
import br.com.involves.filereader.reader.CSVReader;
import br.com.involves.filereader.utils.PrintDataUtils;

public class App {

	
	public static void main(String[] args) {
		String file = "cidades.csv";
		if (args.length > 0) {
			file = args[0];
		}

		if (file.contains(".csv")) {
			initProgram(new CSVReader());
		} else {
			System.out.println("Arquivo não é um .csv");
		}
	}

	private static void initProgram(AbstractFileReader reader) {
		BufferedReader br = reader.reader("cidades.csv", "UTF-8");
		List<Map<String, String>> dados = reader.process(br);
		
		printCommands();
    	System.out.println("\nColunas disponiveis:");
    	PrintDataUtils.printCollectionData(dados.get(0).keySet());
    	waitCommand(dados);
	}
	
	private static void waitCommand(List<Map<String, String>> dados) {
        String commandIn;
        Scanner scanner = new Scanner(System.in);
        CommandExecuter executer = new CommandExecuter(dados);
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
