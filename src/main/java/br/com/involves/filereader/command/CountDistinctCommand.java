package br.com.involves.filereader.command;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import br.com.involves.filereader.repository.CsvRepository;

public class CountDistinctCommand implements Command {

	private CsvRepository repository;
	private String coluna;
	
	public CountDistinctCommand(CsvRepository repository, String coluna) {
		super();
		this.repository = repository;
		this.coluna = coluna;
	}

	@Override
	public void execute() {
		long count;
		switch (coluna) {
		case  CsvRepository.ID_IBGE:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getId())).count();
			break;
		case  CsvRepository.UF:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getUf())).count();
			break;
		case  CsvRepository.NOME:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getNome())).count();
			break;
		case  CsvRepository.CAPITAL:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getCapital())).count();
			break;
		case  CsvRepository.LONGITUDE:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getLongitude())).count();
			break;
		case  CsvRepository.LATITUDE:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getLatitude())).count();
			break;
		case  CsvRepository.NOME_SEM_ACENTO:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getNomeSemAcento())).count();
			break;
		case  CsvRepository.NOME_ALTERNATIVO:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getNomeAlternativo())).count();
			break;
		case  CsvRepository.MICROREGIAO:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getMicroRegiao())).count();
			break;
		case  CsvRepository.MESOREGIAO:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getMesoRegiao())).count();
			break;
		default:
			count = 0L;
			break;
		}
		System.out.println("Total: " + count);
	}

	private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> map = new ConcurrentHashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
}
