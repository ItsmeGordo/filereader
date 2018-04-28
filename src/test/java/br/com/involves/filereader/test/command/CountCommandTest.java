package br.com.involves.filereader.test.command;

import java.io.ByteArrayOutputStream;

import org.junit.Assert;
import org.junit.Test;

import br.com.involves.filereader.command.CommandExecuter;
import br.com.involves.filereader.repository.CsvRepository;

public class CountCommandTest extends AbstractCommandTest {

	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	CsvRepository repo;
    CommandExecuter executer;

	@Test
	public void CountCommmandTest() {
		executer.executeCommand("count *");
	    Assert.assertEquals("Total: 70", output.toString().trim());
	}

}
