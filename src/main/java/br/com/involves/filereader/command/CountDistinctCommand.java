package br.com.involves.filereader.command;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class CountDistinctCommand implements Command {

	private List<Map<String, String>> dados;
	private String coluna;
	
	public CountDistinctCommand(List<Map<String, String>> dados, String coluna) {
		super();
		this.dados = dados;
		this.coluna = coluna;
	}

	@Override
	public void execute() {
		long count;
		count = dados.stream().filter(distinctByKey(c -> c.get(coluna))).count();
		System.out.println("Total: " + count);
	}

	private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> map = new ConcurrentHashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
}
