package br.usjt.previsao_tempo.model;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonBackReference;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "tb_tempo")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@NamedQuery(query = "select p from Tempo p inner join p.cidade c where c.id = p.id and upper(c.nome) = upper(:nome)",
        name = "Tempo.BuscaPeloCidadeNome")
@NamedQuery(query = "select p from Tempo p inner join p.cidade c where c.id = p.id and c.latitude = :latitude and c.longitude = :longitude",
        name = "Tempo.BuscaPeloLatELon")
public class Tempo implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tempo")
    private Long id;
    
    //    @Column(name = "dia_periodo")
//    private String diaDaSemana;
    
    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "id_semana", foreignKey = @ForeignKey(name = "FK_tb_tempo_tb_semana"))
    private DiaSemana diaSemana;

    @Column(name = "tempmin_tempo")
    @JsonAlias("temp_min")
    private Double temperaturaMin;
    
    @Column(name = "tempmax_tempo")
    @JsonAlias("temp_max")
    private Double temperaturaMax;
    
    @Column(name = "humidade_tempo")
    @JsonAlias("humidity")
    private Double humidade;
    
    @Column(name = "datahora_tempo")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date dataHora;
    @Column(name = "desc_tempo")
    private String discricao;
    
    private String iconName;
	
	public String getIcone() {
		return "http://openweathermap.org/img/w/" + iconName + ".png";
	}
	
	@JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "id_cidade", foreignKey = @ForeignKey(name = "FK_tb_tempo_tb_cidade"))
    private Cidade cidade;
    
    @Override
    public String toString() {
        return ((DiaSemana) diaSemana).getDia() + " "
                + "Temperatura minima: " + getTemperaturaMin() + "ºC "
                + "Temperatura maxima: " + getTemperaturaMax() + "ºC "
                + "Humidade: " + getHumidade() + "%";
    }

	public Tempo(Object id2, DiaSemana diaSemana2, Date data, double temperaturaMax2, double humidade2, Double humidity,
			String description, String icon, Cidade cidade2) {
		// TODO Auto-generated constructor stub
	}
}
