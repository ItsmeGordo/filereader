package br.com.involves.filereader.test.reader;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import br.com.involves.filereader.dto.Cidade;
import br.com.involves.filereader.reader.CSVReader;
import br.com.involves.filereader.repository.CsvRepository;

public class CSVReaderTest {

	@Test
	public void readerTest() throws IOException {
		CSVReader csvReader = new CSVReader();
		BufferedReader br = csvReader.reader("cidades.csv");
		String line = br.readLine();

		Assert.assertNotNull(line);

		String[] colunas = line.split(",");
		Assert.assertEquals("Número de colunas não é o esperado", 10, colunas.length);
	}

	@Test
	public void readerTestError() {
		CSVReader csvReader = new CSVReader();
		BufferedReader br = csvReader.reader("cidadess.csv");
		Assert.assertNull(br);

	}

	@Test
	public void processTest() {
		CSVReader csvReader = new CSVReader();
		BufferedReader br = csvReader.reader("cidades.csv");
		CsvRepository repo = csvReader.process(br);

		Assert.assertNotNull("Objeto cidade retornou nulo", repo.getCidades());
		Assert.assertEquals("A quantidade de linhas não é a esperada", 70, repo.getCidades().size());

		Cidade cidade = repo.getCidades().get(0);
		Cidade cidadeExpected = new Cidade.Builder().id(1100015L).uf("RO").nome("Alta Floresta D'Oeste")
				.longitude(new Double("-61.9998238963")).latitude(new Double("-11.9355403048"))
				.nomeSemAcento("Alta Floresta D'Oeste").microRegiao("Cacoal").mesoRegiao("Leste Rondoniense").build();

		Assert.assertEquals("O id ibge da primeira linha não é o esperado", cidadeExpected.getId(), cidade.getId());
		Assert.assertEquals("O UF da primeira linha não é o esperado", cidadeExpected.getUf(), cidade.getUf());
		Assert.assertEquals("O nome da primeira linha não é o esperado", cidadeExpected.getNome(), cidade.getNome());
		Assert.assertEquals("A latitude da primeira linha não é o esperado", cidadeExpected.getLatitude(),
				cidade.getLatitude());
		Assert.assertEquals("A longitude da primeira linha não é o esperado", cidadeExpected.getLongitude(),
				cidade.getLongitude());
		Assert.assertEquals("O nome sem acento da primeira linha não é o esperado", cidadeExpected.getNomeSemAcento(),
				cidade.getNomeSemAcento());
		Assert.assertEquals("A microRegiao da primeira linha não é o esperado", cidadeExpected.getMicroRegiao(),
				cidade.getMicroRegiao());
		Assert.assertEquals("A mesoRegiao da primeira linha não é o esperado", cidadeExpected.getMesoRegiao(),
				cidade.getMesoRegiao());

	}
}
