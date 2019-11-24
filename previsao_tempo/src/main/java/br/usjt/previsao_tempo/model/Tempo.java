package br.usjt.previsao_tempo.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Entity
@Table(name = "tb_tempo")
@Getter @Setter 
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "id_semana", foreignKey = @ForeignKey(name = "FK_tb_tempo_tb_semana"))
    private DiaSemana diaSemana;

    @Column(name = "tempmin_tempo")
    private Double temperaturaMin;
    @Column(name = "tempmax_tempo")
    private Double temperaturaMax;
    @Column(name = "humidade_tempo")
    private Double humidade;
    @Column(name = "datahora_tempo")
    private String dataHora;
    @Column(name = "desc_tempo")
    private String discricao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "id_cidade", foreignKey = @ForeignKey(name = "FK_tb_tempo_tb_cidade"))
    private Cidade cidade;
    
    @Override
    public String toString() {
        return diaSemana.getDia() + " "
                + "Temperatura minima: " + getTemperaturaMin() + "ºC "
                + "Temperatura maxima: " + getTemperaturaMax() + "ºC "
                + "Humidade: " + getHumidade() + "%";
    }
}
