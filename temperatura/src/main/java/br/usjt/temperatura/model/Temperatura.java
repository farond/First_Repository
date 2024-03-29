package br.usjt.temperatura.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "tb_temperatura")
@Getter @Setter @ToString

public class Temperatura {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false, length=200)
	private String maxima;
	@Column(nullable=false, length=200)
	private String minima;
	@Column(nullable=false, length=200)
	private String umidade;
	@Column(nullable=false, length=200)
	private String chuva;
	@Column(nullable=false, length=200)
	private String descricao;
	
	@Column(nullable=false, length=200)
	private String data;
	
	//@Column(nullable=false, length=200)
	//private Double latitude;
	//@Column(nullable=false, length=200)
	//private Double longitude;
	
	@OneToOne(optional=true, cascade = CascadeType.ALL)
	@JoinColumn (name = "dia")
	private Dia dia;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name="id_cidade")
	private Cidade cidade;

	public void setHumidade(String humidade2) {
		// TODO Auto-generated method stub
		
	}
	

}
	