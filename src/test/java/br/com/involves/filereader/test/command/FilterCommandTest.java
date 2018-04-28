package br.com.involves.filereader.test.command;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.involves.filereader.command.CommandExecuter;
import br.com.involves.filereader.reader.CSVReader;
import br.com.involves.filereader.repository.CsvRepository;

public class FilterCommandTest {

	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	CsvRepository repo;
    CommandExecuter executer;

	@Before
	public void init() {
		CSVReader csvReader = new CSVReader();
		BufferedReader br = csvReader.reader("cidades.csv", "UTF-8");
		repo = csvReader.process(br);
		executer = new CommandExecuter(repo);
	    System.setOut(new PrintStream(output));

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
	public void FilterCommmandNomeTest() {
		executer.executeCommand("filter name Três Barras");
	    Assert.assertEquals("4218301,SC,Três Barras,,-50.305419368,-26.1140963368,Tres Barras,,Canoinhas,Norte Catarinense", output.toString().trim());
	}

	@Test
	public void FilterCommmandCapitalTest() {
		executer.executeCommand("filter capital true");
	    Assert.assertEquals("1100205,RO,Porto Velho,true,-63.8314456544,-8.76889179,Porto Velho,,Porto Velho,Madeira-Guaporé", output.toString().trim());
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

	@Test
	public void FilterCommmandSemAcentoTest() {
		executer.executeCommand("filter no_accents Alta Floresta D'Oeste");
	    Assert.assertEquals("1100015,RO,Alta Floresta D'Oeste,,-61.9998238963,-11.9355403048,Alta Floresta D'Oeste,,Cacoal,Leste Rondoniense", output.toString().trim());
	}

	@Test
	public void FilterCommmandNomeAlternativoTest() {
		executer.executeCommand("filter alternative_names Assu");
	    Assert.assertEquals("2400208,RN,Açu,,-36.91792322,-5.5719459992,Acu,Assu,Vale do Açu,Oeste Potiguar", output.toString().trim());
	}

	@Test
	public void FilterCommmandMicroRegiaoTest() {
		executer.executeCommand("filter microregion Canoinhas");
	    Assert.assertEquals("4218301,SC,Três Barras,,-50.305419368,-26.1140963368,Tres Barras,,Canoinhas,Norte Catarinense", output.toString().trim());
	}

	@Test
	public void FilterCommmandMesoRegiaoTest() {
		executer.executeCommand("filter mesoregion Norte Catarinense");
	    Assert.assertEquals("4218301,SC,Três Barras,,-50.305419368,-26.1140963368,Tres Barras,,Canoinhas,Norte Catarinense", output.toString().trim());
	}

	@Test
	public void FilterCommmandInvalidParamTest() {
		executer.executeCommand("filter mesoregion aaaaaaa");
	    Assert.assertEquals("", output.toString().trim());
	}

}
