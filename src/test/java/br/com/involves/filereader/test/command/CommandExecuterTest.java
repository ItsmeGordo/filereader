package br.com.involves.filereader.test.command;

import org.junit.Assert;
import org.junit.Test;

import br.com.involves.filereader.exception.InvalidCommandException;

public class CommandExecuterTest extends AbstractCommandTest {

	@Test
	public void comandoPequenoTest() {
		String command = "count";
		try {
			executer.executeCommand(command);
		} catch (InvalidCommandException e) {
			Assert.assertEquals("O comando " + command + " não é um comando conhecido pelo sistema!", e.getMessage());
		}
	}

	@Test
	public void commandoErradoTest() {
		String command = "comando todo errado";
		try {
			executer.executeCommand(command);
		} catch (InvalidCommandException e) {
			Assert.assertEquals("O comando " + command + " não é um comando conhecido pelo sistema!", e.getMessage());
		}
	}

}
