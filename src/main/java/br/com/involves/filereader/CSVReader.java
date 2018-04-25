package br.com.involves.filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.involves.dto.Cidade;
import br.com.involves.filereader.interfaces.AbstractFileReader;

public class CSVReader extends AbstractFileReader {

	private static final String CSV_SPLITER = ",";

	@Override
	public List<Cidade> process(String filePath) throws FileNotFoundException {
		List<Cidade> retorno = new ArrayList<Cidade>();
		BufferedReader reader = this.reader(filePath);
		String linha;
		try {
			while ((linha = reader.readLine()) != null) {
				String[] split = linha.split(CSV_SPLITER);
				retorno.add(StringArrayToCidade(split));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private Cidade StringArrayToCidade(String[] array) {
		Cidade cidade = new Cidade.Builder().id(Long.parseLong(array[0])).uf(array[1]).nome(array[2]).capital(array[3])
				.longitude(Double.parseDouble(array[4])).latitude(Double.parseDouble(array[5])).nomeSemAcento(array[6])
				.nomeAlternativo(array[7]).microRegiao(array[8]).mesoRegiao(array[9]).build();
		return cidade;

	}
}
