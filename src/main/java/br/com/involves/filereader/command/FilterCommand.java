package br.com.involves.filereader.command;

import br.com.involves.filereader.repository.CsvRepository;

public class FilterCommand implements Command {

	private CsvRepository repository;
	private String coluna;
	private String valor;

	public FilterCommand(CsvRepository repo, String coluna, String valor) {
		super();
		this.repository = repo;
		this.coluna = coluna;
	}

	@Override
	public void execute() {
		long count;
		switch (coluna) {
		case CsvRepository.ID_IBGE:
			count = repository.getCidades().stream().filter(c -> c.getId().toString().equals(valor)).count();
			break;
		case CsvRepository.UF:
			count = repository.getCidades().stream().filter(c -> c.getUf().equals(valor)).count();
			break;
		case CsvRepository.NOME:
			count = repository.getCidades().stream().filter(c -> c.getNome().equals(valor)).count();
			break;
		case CsvRepository.CAPITAL:
			count = repository.getCidades().stream().filter(c -> c.getCapital().equals(valor)).count();
			break;
		case CsvRepository.LONGITUDE:
			count = repository.getCidades().stream().filter(c -> c.getLongitude().toString().equals(valor)).count();
			break;
		case CsvRepository.LATITUDE:
			count = repository.getCidades().stream().filter(c -> c.getLatitude().toString().equals(valor)).count();
			break;
		case CsvRepository.NOME_SEM_ACENTO:
			count = repository.getCidades().stream().filter(c -> c.getNomeSemAcento().equals(valor)).count();
			break;
		case CsvRepository.NOME_ALTERNATIVO:
			count = repository.getCidades().stream().filter(c -> c.getNomeAlternativo().equals(valor)).count();
			break;
		case CsvRepository.MICROREGIAO:
			count = repository.getCidades().stream().filter(c -> c.getMicroRegiao().equals(valor)).count();
			break;
		case CsvRepository.MESOREGIAO:
			count = repository.getCidades().stream().filter(c -> c.getMesoRegiao().equals(valor)).count();
			break;
		default:
			count = 0L;
			break;
		}
		System.out.println("Total: " + count);
	}

}
