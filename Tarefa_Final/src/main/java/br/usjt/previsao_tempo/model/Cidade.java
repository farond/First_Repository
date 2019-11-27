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
    @Column(name = "id_cidade")
    private Long id;
    @Column(name = "nome_cidade")
    private String nome;
    @Column(name = "lat_cidade")
    private Double latitude;
    @Column(name = "lon_cidade")
    private Double longitude;

    @OneToMany (cascade = CascadeType.ALL,mappedBy= "cidade")
	private List<Tempo> tempos;

}
