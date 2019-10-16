package br.usjt.temperatura.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity

@Table (name = "tb_cidade")
@Getter @Setter @ToString
public class Cidade {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length=150)
	private String Cidade;
	
	@Column(nullable=false, length=100)
	private String longitude;
	
	
	@Column(nullable=false, length=100)
	private String latitude;
	
	@OneToMany (mappedBy= "cidade")
	private List<Temperatura> temperaturas;
	

}
