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
			System.out.println("Total: " + count);
			break;
		case  CsvRepository.UF:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getUf())).count();
			System.out.println("Total: " + count);
			break;
		case  CsvRepository.NOME:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getNome())).count();
			System.out.println("Total: " + count);
			break;
		case  CsvRepository.CAPITAL:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getCapital())).count();
			System.out.println("Total: " + count);
			break;
		case  CsvRepository.LONGITUDE:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getLongitude())).count();
			System.out.println("Total: " + count);
			break;
		case  CsvRepository.LATITUDE:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getLatitude())).count();
			System.out.println("Total: " + count);
			break;
		case  CsvRepository.NOME_SEM_ACENTO:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getNomeSemAcento())).count();
			System.out.println("Total: " + count);
			break;
		case  CsvRepository.NOME_ALTERNATIVO:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getNomeAlternativo())).count();
			System.out.println("Total: " + count);
			break;
		case  CsvRepository.MICROREGIAO:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getMicroRegiao())).count();
			System.out.println("Total: " + count);
			break;
		case  CsvRepository.MESOREGIAO:
			count = repository.getCidades().stream().filter(distinctByKey(c -> c.getMesoRegiao())).count();
			System.out.println("Total: " + count);
			break;
		default:
			System.out.println("A coluna especificada não existe!");
			break;
		}
	}

	private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> map = new ConcurrentHashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
}
