package br.usjt.temperatura.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.mapping.List;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name = "tb_cidade")

public class Cidade {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false, length=150)
	private String Cidade;
	
	@Column(nullable=false, length=100)
	private double longitude;
	
	@Column(nullable=false, length=100)
	private double lagitude;
	
	@OneToMany(mappedBy= "cidade", cascade = CascadeType.ALL)
	private List temperaturas;
	

}
