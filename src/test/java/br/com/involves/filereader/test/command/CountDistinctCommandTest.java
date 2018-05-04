package br.com.involves.filereader.test.command;

import org.junit.Assert;
import org.junit.Test;

import br.com.involves.filereader.exception.InvalidCommandException;
import br.com.involves.filereader.exception.InvalidFilterException;

public class CountDistinctCommandTest extends AbstractCommandTest {

	@Test
	public void CountDistinctCommmandIdTest() {
		executer.executeCommand("count distinct ibge_id");
	    Assert.assertEquals("Total: 70", output.toString().trim());
	}

	@Test
	public void CountDistinctCommmandUfTest() {
	    executer.executeCommand("count distinct uf");
	    Assert.assertEquals("Total: 4", output.toString().trim());
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

	@Test
	public void CountDistinctCommmandLonTest() {
		executer.executeCommand("count distinct lon");
	    Assert.assertEquals("Total: 70", output.toString().trim());
	}

	@Test
	public void CountDistinctCommmandLatTest() {
		executer.executeCommand("count distinct lat");
	    Assert.assertEquals("Total: 70", output.toString().trim());
	}

	@Test
	public void CountDistinctCommmandSemAcentoTest() {
		executer.executeCommand("count distinct no_accents");
	    Assert.assertEquals("Total: 70", output.toString().trim());
	}

	@Test
	public void CountDistinctCommmandNomeAlternativoTest() {
		executer.executeCommand("count distinct alternative_names");
	    Assert.assertEquals("Total: 2", output.toString().trim());
	}

	@Test
	public void CountDistinctCommmandMicroRegiaoTest() {
		executer.executeCommand("count distinct microregion");
	    Assert.assertEquals("Total: 15", output.toString().trim());
	}

	@Test
	public void CountDistinctCommmandMesoRegiaoTest() {
		executer.executeCommand("count distinct mesoregion");
	    Assert.assertEquals("Total: 6", output.toString().trim());
	}

	@Test
	public void CountDistinctCommmandErroTest() {
		try {
			executer.executeCommand("count distinct erro");
		} catch (InvalidFilterException e) {
		    Assert.assertEquals("A coluna especificada não existe!", e.getMessage());
		}
	}

	@Test(expected = InvalidCommandException.class)
	public void CountDistinctCommandWithoutProperty() {
	    executer.executeCommand("count distinct");
	}

}
