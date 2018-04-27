package br.com.involves.filereader.dto;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((mesoRegiao == null) ? 0 : mesoRegiao.hashCode());
		result = prime * result + ((microRegiao == null) ? 0 : microRegiao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeAlternativo == null) ? 0 : nomeAlternativo.hashCode());
		result = prime * result + ((nomeSemAcento == null) ? 0 : nomeSemAcento.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (mesoRegiao == null) {
			if (other.mesoRegiao != null)
				return false;
		} else if (!mesoRegiao.equals(other.mesoRegiao))
			return false;
		if (microRegiao == null) {
			if (other.microRegiao != null)
				return false;
		} else if (!microRegiao.equals(other.microRegiao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeAlternativo == null) {
			if (other.nomeAlternativo != null)
				return false;
		} else if (!nomeAlternativo.equals(other.nomeAlternativo))
			return false;
		if (nomeSemAcento == null) {
			if (other.nomeSemAcento != null)
				return false;
		} else if (!nomeSemAcento.equals(other.nomeSemAcento))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", uf=" + uf + ", nome=" + nome + ", capital=" + capital + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", nomeSemAcento=" + nomeSemAcento + ", nomeAlternativo="
				+ nomeAlternativo + ", microRegiao=" + microRegiao + ", mesoRegiao=" + mesoRegiao + "]";
	}

}
