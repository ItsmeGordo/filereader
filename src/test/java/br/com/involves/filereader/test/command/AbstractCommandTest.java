package br.com.involves.filereader.test.command;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import org.junit.Before;

import br.com.involves.filereader.command.CommandExecuter;
import br.com.involves.filereader.reader.CSVReader;

public abstract class AbstractCommandTest {

	protected final ByteArrayOutputStream output = new ByteArrayOutputStream();
	List<Map<String, String>> dados;
    CommandExecuter executer;

	@Before
	public void init() {
		CSVReader csvReader = new CSVReader();
		BufferedReader br = csvReader.reader("cidades.csv", "UTF-8");
		dados = csvReader.process(br);
		executer = new CommandExecuter(dados);
	    System.setOut(new PrintStream(output));

	}


}
