package br.com.involves.filereader.test.reader;

import java.io.BufferedReader;

import org.junit.Assert;
import org.junit.Test;

import br.com.involves.filereader.dto.Cidade;
import br.com.involves.filereader.reader.CSVReader;
import br.com.involves.filereader.repository.CsvRepository;

public class CSVReaderTest {

	@Test
	public void readerTest() {
		CSVReader csvReader = new CSVReader();
		try {
			BufferedReader br = csvReader.reader("cidades.csv");
			String line = br.readLine();
			
			Assert.assertNotNull(line);
			
			String[] colunas = line.split(",");
			Assert.assertEquals("N�mero de colunas n�o � o esperado", 10, colunas.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void processTest() {
		CSVReader csvReader = new CSVReader();
		try {
			BufferedReader br = csvReader.reader("cidades.csv");
			CsvRepository repo = csvReader.process(br);

			Assert.assertNotNull("Objeto cidade retornou nulo", repo.getCidades());
			Assert.assertEquals("A quantidade de linhas n�o � a esperada", 70, repo.getCidades().size());

			Cidade cidade = repo.getCidades().get(0);
			Long idIbge = 1100015L;
			Assert.assertNotNull("O id ibge n�o pode ser nulo", cidade.getId());
			Assert.assertEquals("O id ibge da primeira linha n�o � 1100015", idIbge, cidade.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
