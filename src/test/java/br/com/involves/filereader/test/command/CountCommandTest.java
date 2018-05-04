package br.com.involves.filereader.test.command;

import org.junit.Assert;
import org.junit.Test;

public class CountCommandTest extends AbstractCommandTest {

	@Test
	public void CountCommmandTest() {
		executer.executeCommand("count *");
	    Assert.assertEquals("Total: 70", output.toString().trim());
	}

}
