package br.com.involves.dto;

public class Cidade {

	private Long id;
	private String uf;
	private String nome;
	private String capital;
	private Double latitude;
	private Double longitude;
	private String nomeSemAcento;
	private String nomeAlternativo;
	private String microRegiao;
	private String mesoRegiao;

	private Cidade(Builder builder) {
		this.id = builder.id;
		this.uf = builder.uf;
		this.nome = builder.nome;
		this.capital = builder.capital;
		this.latitude = builder.latitude;
		this.longitude = builder.longitude;
		this.nomeSemAcento = builder.nomeSemAcento;
		this.nomeAlternativo = builder.nomeAlternativo;
		this.microRegiao = builder.microRegiao;
		this.mesoRegiao = builder.mesoRegiao;
	}

	public static class Builder {

		private Long id;
		private String uf;
		private String nome;
		private String capital;
		private Double latitude;
		private Double longitude;
		private String nomeSemAcento;
		private String nomeAlternativo;
		private String microRegiao;
		private String mesoRegiao;

		public Cidade build() {
			return new Cidade(this);
		}

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder uf(String uf) {
			this.uf = uf;
			return this;
		}

		public Builder nome(String nome) {
			this.nome = nome;
			return this;
		}

		public Builder capital(String capital) {
			this.capital = capital;
			return this;
		}

		public Builder latitude(Double latitude) {
			this.latitude = latitude;
			return this;
		}

		public Builder longitude(Double longitude) {
			this.longitude = longitude;
			return this;
		}

		public Builder nomeSemAcento(String nomeSemAcento) {
			this.nomeSemAcento = nomeSemAcento;
			return this;
		}

		public Builder nomeAlternativo(String nomeAlternativo) {
			this.nomeAlternativo = nomeAlternativo;
			return this;
		}

		public Builder microRegiao(String microRegiao) {
			this.microRegiao = microRegiao;
			return this;
		}

		public Builder mesoRegiao(String mesoRegiao) {
			this.mesoRegiao = mesoRegiao;
			return this;
		}

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getNomeSemAcento() {
		return nomeSemAcento;
	}

	public void setNomeSemAcento(String nomeSemAcento) {
		this.nomeSemAcento = nomeSemAcento;
	}

	public String getNomeAlternativo() {
		return nomeAlternativo;
	}

	public void setNomeAlternativo(String nomeAlternativo) {
		this.nomeAlternativo = nomeAlternativo;
	}

	public String getMicroRegiao() {
		return microRegiao;
	}

	public void setMicroRegiao(String microRegiao) {
		this.microRegiao = microRegiao;
	}

	public String getMesoRegiao() {
		return mesoRegiao;
	}

	public void setMesoRegiao(String mesoRegiao) {
		this.mesoRegiao = mesoRegiao;
	}

}
