package br.com.involves.filereader.test.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.involves.filereader.reader.CSVReader;

public class CSVReaderTest {

	@Test
	public void readerTest() throws IOException {
		CSVReader csvReader = new CSVReader();
		BufferedReader br = csvReader.reader("cidades.csv", "UTF-8");
		String line = br.readLine();

		Assert.assertNotNull(line);

		String[] colunas = line.split(",");
		Assert.assertEquals("Número de colunas não é o esperado", 10, colunas.length);
	}

	@Test
	public void readerTestError() {
		CSVReader csvReader = new CSVReader();
		BufferedReader br = csvReader.reader("cidadess.csv", "UTF-8");
		Assert.assertNull(br);

		br = csvReader.reader("cidades.csv", "UTF888");
		Assert.assertNull(br);
	}

	@Test
	public void processTest() {
		CSVReader csvReader = new CSVReader();
		BufferedReader br = csvReader.reader("cidades.csv", "UTF-8");
		List<Map<String, String>> repo = csvReader.process(br);

		Assert.assertNotNull("Objeto reposit retornou nulo", repo);
		Assert.assertEquals("A quantidade de linhas não é a esperada", 70, repo.size());

		Map<String, String> city = repo.get(0);
		
		Map<String, String> cityExpected = cityExpected();

		Assert.assertEquals("O id ibge da primeira linha não é o esperado", cityExpected.get("ibge_id"), city.get("ibge_id"));
		Assert.assertEquals("O UF da primeira linha não é o esperado", cityExpected.get("uf"), city.get("uf"));
		Assert.assertEquals("O nome da primeira linha não é o esperado", cityExpected.get("name"), city.get("name"));
		Assert.assertEquals("A latitude da primeira linha não é o esperado", cityExpected.get("lat"), city.get("lat"));
		Assert.assertEquals("A longitude da primeira linha não é o esperado", cityExpected.get("lon"), city.get("lon"));
		Assert.assertEquals("O nome sem acento da primeira linha não é o esperado", cityExpected.get("no_accents"), city.get("no_accents"));
		Assert.assertEquals("A microRegiao da primeira linha não é o esperado", cityExpected.get("microregion"), city.get("microregion"));
		Assert.assertEquals("A mesoRegiao da primeira linha não é o esperado", cityExpected.get("mesoregion"), city.get("mesoregion"));

	}
	
	private Map<String, String> cityExpected() {
		Map<String, String> retorno = new HashMap<>();

		retorno.put("ibge_id", "1100015");
		retorno.put("uf", "RO");
		retorno.put("name", "Alta Floresta D'Oeste");
		retorno.put("capital", "");
		retorno.put("lon", "-61.9998238963");
		retorno.put("lat", "-11.9355403048");
		retorno.put("no_accents", "Alta Floresta D'Oeste");
		retorno.put("alternative_names", "");
		retorno.put("microregion", "Cacoal");
		retorno.put("mesoregion", "Leste Rondoniense");
		return retorno;
	}
}
