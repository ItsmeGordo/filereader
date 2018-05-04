package br.com.involves.filereader.test.command;

import org.junit.Assert;
import org.junit.Test;

import br.com.involves.filereader.exception.InvalidFilterException;

public class FilterCommandTest extends AbstractCommandTest {

	@Test
	public void FilterCommmandIdTest() {
		executer.executeCommand("filter ibge_id 1100023");
	    Assert.assertEquals("Ariquemes,RO,,Ariquemes,1100023,Ariquemes,-63.033269278,,-9.9084628666,Leste Rondoniense", output.toString().trim());
	}

	@Test
	public void FilterCommmandUFTest() {
		executer.executeCommand("filter uf SC");
	    Assert.assertEquals("Canoinhas,SC,,Tres Barras,4218301,Três Barras,-50.305419368,,-26.1140963368,Norte Catarinense", output.toString().trim());
	}

	@Test
	public void FilterCommmandNomeTest() {
		executer.executeCommand("filter name Três Barras");
	    Assert.assertEquals("Canoinhas,SC,,Tres Barras,4218301,Três Barras,-50.305419368,,-26.1140963368,Norte Catarinense", output.toString().trim());
	}

	@Test
	public void FilterCommmandCapitalTest() {
		executer.executeCommand("filter capital true");
	    Assert.assertEquals("Porto Velho,RO,true,Porto Velho,1100205,Porto Velho,-63.8314456544,,-8.76889179,Madeira-Guaporé", output.toString().trim());
	}
	
	@Test
	public void FilterCommmandLatTest() {
		executer.executeCommand("filter lat -9.9084628666");
	    Assert.assertEquals("Ariquemes,RO,,Ariquemes,1100023,Ariquemes,-63.033269278,,-9.9084628666,Leste Rondoniense", output.toString().trim());
	}

	@Test
	public void FilterCommmandLonTest() {
		executer.executeCommand("filter lon -63.033269278");
	    Assert.assertEquals("Ariquemes,RO,,Ariquemes,1100023,Ariquemes,-63.033269278,,-9.9084628666,Leste Rondoniense", output.toString().trim());
	}

	@Test
	public void FilterCommmandSemAcentoTest() {
		executer.executeCommand("filter no_accents Alta Floresta D'Oeste");
	    Assert.assertEquals("Cacoal,RO,,Alta Floresta D'Oeste,1100015,Alta Floresta D'Oeste,-61.9998238963,,-11.9355403048,Leste Rondoniense", output.toString().trim());
	}

	@Test
	public void FilterCommmandNomeAlternativoTest() {
		executer.executeCommand("filter alternative_names Assu");
	    Assert.assertEquals("Vale do Açu,RN,,Acu,2400208,Açu,-36.91792322,Assu,-5.5719459992,Oeste Potiguar", output.toString().trim());
	}

	@Test
	public void FilterCommmandMicroRegiaoTest() {
		executer.executeCommand("filter microregion Canoinhas");
	    Assert.assertEquals("Canoinhas,SC,,Tres Barras,4218301,Três Barras,-50.305419368,,-26.1140963368,Norte Catarinense", output.toString().trim());
	}

	@Test
	public void FilterCommmandMesoRegiaoTest() {
		executer.executeCommand("filter mesoregion Norte Catarinense");
	    Assert.assertEquals("Canoinhas,SC,,Tres Barras,4218301,Três Barras,-50.305419368,,-26.1140963368,Norte Catarinense", output.toString().trim());
	}

	@Test
	public void FilterCommmandInvalidParamTest() {
		executer.executeCommand("filter mesoregion aaaaaaa");
	    Assert.assertEquals("", output.toString().trim());
	}

	@Test
	public void FilterCommmandInvalidColumnTest() {
		try {
			executer.executeCommand("filter erro aaaaaaa");
		} catch (InvalidFilterException e) {
		    Assert.assertEquals("A coluna especificada como filtro não existe!", e.getMessage());

		}
	}

}
