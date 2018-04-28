package br.com.involves.filereader.test.command;

import org.junit.Test;

import br.com.involves.filereader.exception.InvalidCommandException;

public class CommandExecuterTest extends AbstractCommandTest {

	@Test(expected = InvalidCommandException.class)
	public void comandoPequenoTest() {
		executer.executeCommand("count");
	}

	@Test(expected = InvalidCommandException.class)
	public void commandoErradoTest() {
		executer.executeCommand("comando todo errado");
	}

}
