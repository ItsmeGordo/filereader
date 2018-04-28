package br.com.involves.filereader.command;

import br.com.involves.filereader.dto.Cidade;
import br.com.involves.filereader.repository.CsvRepository;

public class FilterCommand implements Command {

	private CsvRepository repository;
	private String coluna;
	private String valor;

	public FilterCommand(CsvRepository repo, String coluna, String valor) {
		super();
		this.repository = repo;
		this.coluna = coluna;
		this.valor = valor;
	}

	@Override
	public void execute() {
		switch (coluna) {
		case CsvRepository.ID_IBGE:
			repository.getCidades().stream().filter(c -> c.getId().toString().equals(valor)).forEach(c -> repository.printCidadesFilter(c));
			break;
		case CsvRepository.UF:
			repository.getCidades().stream().filter(c -> c.getUf().equals(valor)).forEach(c -> repository.printCidadesFilter(c));
			break;
		case CsvRepository.NOME:
			repository.getCidades().stream().filter(c -> c.getNome().equals(valor)).forEach(c -> repository.printCidadesFilter(c));
			break;
		case CsvRepository.CAPITAL:
			repository.getCidades().stream().filter(c -> c.getCapital().equals(valor)).forEach(c -> repository.printCidadesFilter(c));
			break;
		case CsvRepository.LONGITUDE:
			repository.getCidades().stream().filter(c -> c.getLongitude().toString().equals(valor)).forEach(c -> repository.printCidadesFilter(c));
			break;
		case CsvRepository.LATITUDE:
			repository.getCidades().stream().filter(c -> c.getLatitude().equals(new Double(valor))).forEach(c -> repository.printCidadesFilter(c));
			break;
		case CsvRepository.NOME_SEM_ACENTO:
			repository.getCidades().stream().filter(c -> c.getNomeSemAcento().equals(valor)).forEach(c -> repository.printCidadesFilter(c));
			break;
		case CsvRepository.NOME_ALTERNATIVO:
			repository.getCidades().stream().filter(c -> c.getNomeAlternativo().equals(valor)).forEach(c -> repository.printCidadesFilter(c));
			break;
		case CsvRepository.MICROREGIAO:
			repository.getCidades().stream().filter(c -> c.getMicroRegiao().equals(valor)).forEach(c -> repository.printCidadesFilter(c));
			break;
		case CsvRepository.MESOREGIAO:
			repository.getCidades().stream().filter(c -> c.getMesoRegiao().equals(valor)).forEach(c -> repository.printCidadesFilter(c));
			break;
		default:
			System.out.println("A coluna especificada como filtro não existe!");
			break;
		}
	}
	

}
