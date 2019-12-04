package br.usjt.previsao_tempo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_semana")
@Getter @Setter @ToString @Data @AllArgsConstructor @NoArgsConstructor
public class DiaSemana {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_semana", nullable=false)
    private Long id;
    @Column(name = "dia_semana")
    private String dia;
    
    @OneToOne(optional=true,  cascade = CascadeType.ALL)
	@JoinColumn (name = "tempo")
	private Tempo tempo;

  }
