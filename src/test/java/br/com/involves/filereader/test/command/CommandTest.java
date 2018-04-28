package br.com.involves.filereader.test.command;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.involves.filereader.command.CommandExecuter;
import br.com.involves.filereader.exception.InvalidCommandException;
import br.com.involves.filereader.reader.CSVReader;
import br.com.involves.filereader.repository.CsvRepository;

public class CommandTest {

	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	CsvRepository repo;
    CommandExecuter executer;

	@Before
	public void init() {
		CSVReader csvReader = new CSVReader();
		BufferedReader br = csvReader.reader("cidades.csv");
		repo = csvReader.process(br);
		executer = new CommandExecuter(repo);
	    System.setOut(new PrintStream(output));

	}

	@Test
	public void CountCommmandTest() {
		executer.executeCommand("count *");
	    Assert.assertEquals("Total: 70", output.toString().trim());
	}

	@Test
	public void CountDistinctCommmandIdTest() {
		executer.executeCommand("count distinct ibge_id");
	    Assert.assertEquals("Total: 70", output.toString().trim());
	}

	@Test
	public void CountDistinctCommmandUfTest() {
	    executer.executeCommand("count distinct uf");
	    Assert.assertEquals("Total: 2", output.toString().trim());
	}

	@Test
	public void CountDistinctCommmandNomeTest() {
	    executer.executeCommand("count distinct name");
	    Assert.assertEquals("Total: 70", output.toString().trim());
	}

	@Test
	public void CountDistinctCommmandCapitalTest() {
		executer.executeCommand("count distinct capital");
	    Assert.assertEquals("Total: 2", output.toString().trim());
	}

	@Test(expected = InvalidCommandException.class)
	public void CountDistinctCommandWithoutProperty() {
	    executer.executeCommand("count distinct");
	}

	@Test
	public void FilterCommmandIdTest() {
		executer.executeCommand("filter ibge_id 1100023");
	    Assert.assertEquals("1100023,RO,Ariquemes,,-63.033269278,-9.9084628666,Ariquemes,,Ariquemes,Leste Rondoniense", output.toString().trim());
	}

	@Test
	public void FilterCommmandUFTest() {
		executer.executeCommand("filter uf SC");
	    Assert.assertEquals("4218301,SC,Três Barras,,-50.305419368,-26.1140963368,Tres Barras,,Canoinhas,Norte Catarinense", output.toString().trim());
	}

	@Test
	public void FilterCommmandLatTest() {
		executer.executeCommand("filter lat -9.9084628666");
	    Assert.assertEquals("1100023,RO,Ariquemes,,-63.033269278,-9.9084628666,Ariquemes,,Ariquemes,Leste Rondoniense", output.toString().trim());
	}

	@Test
	public void FilterCommmandLonTest() {
		executer.executeCommand("filter lon -63.033269278");
	    Assert.assertEquals("1100023,RO,Ariquemes,,-63.033269278,-9.9084628666,Ariquemes,,Ariquemes,Leste Rondoniense", output.toString().trim());
	}

}
