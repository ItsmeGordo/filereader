package br.com.involves.filereader.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReader extends AbstractFileReader {

	private static final String CSV_SPLITER = ",";

	@Override
	public List<Map<String, String>> process(BufferedReader br) {
		String linha;
		List<Map<String, String>> retorno = new ArrayList<>();
		try {
			String[] cabecalho = br.readLine().split(CSV_SPLITER);
			while ((linha = br.readLine()) != null) {
				String[] dados = linha.split(CSV_SPLITER);
				retorno.add(stringArrayToMap(cabecalho, dados));
			}
			return retorno;
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return null;
	}

	private Map<String, String> stringArrayToMap(String[] cabecalho, String[] dados) {
		Map<String, String> mapLinha = new HashMap<>();
		for (int i = 0; i < cabecalho.length; i++) {
			mapLinha.put(cabecalho[i], dados[i]);
		}
		return mapLinha;

	}
	
}
