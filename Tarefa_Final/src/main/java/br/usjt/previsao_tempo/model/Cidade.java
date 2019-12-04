package br.usjt.previsao_tempo.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_cidade")
@Getter @Setter @ToString @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cidade_id")
    private Long id;
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public List<Tempo> getTempos() {
		return tempos;
	}

	public void setTempos(List<Tempo> tempos) {
		this.tempos = tempos;
	}

	@Column(name = "nome_cidade")
    private String nome;
    @Column(name = "lat_cidade")
    private Double latitude;
    @Column(name = "lon_cidade")
    private Double longitude;

    @OneToMany (cascade = CascadeType.ALL,mappedBy= "cidade")
	private List<Tempo> tempos;

}
