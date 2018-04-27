package br.com.involves.filereader.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.involves.filereader.dto.Cidade;
import br.com.involves.filereader.repository.CsvRepository;

public class CSVReader extends AbstractFileReader {

	private static final String CSV_SPLITER = ",";

	@Override
	public CsvRepository process(BufferedReader br) {
		List<Cidade> cidades = new ArrayList<>();
		CsvRepository.Builder builder = new CsvRepository.Builder();
		String linha;
		try {
			builder.header(headerCsv(br.readLine()));
			while ((linha = br.readLine()) != null) {
				String[] split = linha.split(CSV_SPLITER);
				cidades.add(stringArrayToCidade(split));
			}
			builder.cidades(cidades);
			return builder.build();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private Cidade stringArrayToCidade(String[] array) {
		Cidade cidade = new Cidade.Builder().id(Long.parseLong(array[0])).uf(array[1]).nome(array[2]).capital(array[3])
				.longitude(Double.parseDouble(array[4])).latitude(Double.parseDouble(array[5])).nomeSemAcento(array[6])
				.nomeAlternativo(array[7]).microRegiao(array[8]).mesoRegiao(array[9]).build();
		return cidade;

	}
	
	private Map<Integer,String> headerCsv(String linha) {
		String[] array = linha.split(CSV_SPLITER);
		Map<Integer, String> header = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			header.put(i, array[i]);
		}
		return header;

	}
}
