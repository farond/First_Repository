package br.usjt.temperatura.model;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "tb_temperatura")
@Getter @Setter @ToString

public class Temperatura {
	
	
	@Id 
	@GeneratedValue
	private long id;
	
	@Column(nullable=false, length=200)
	private Double maxima;
	@Column(nullable=false, length=200)
	private Double minima;
	@Column(nullable=false, length=200)
	private Double humidade;
	@Column(nullable=false, length=200)
	private Double chuva;
	@Column(nullable=false, length=200)
	private String descricao;
	
	@Column(nullable=false, length=200)
	//@OneToOne(optional=false)
	//@JoinColumn (name = "id_dia")
	private String data;
	
	@Column(nullable=false, length=200)
	private Double latitude;
	@Column(nullable=false, length=200)
	private Double longitude;
	

}
	