package br.usjt.temperatura.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Temperatura {
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String dia;
	private Double temperaturaMinima;
	private Double temperaturaMaxima;
	private Double humidade;
	private Double chuva;
	private String descricao;
	
	public Long getId() 
	{
		return id;
	}
	
	public void setId(Long id) 
	{
		this.id = id;
	}
	
	public String getDia() 
	{
		return dia;
	}
	
	public void setDia(String dia) 
	{
		this.dia = dia;
	}
	
	public Double getTemperaturaMinima() 
	{
		return temperaturaMinima;
	}
	
	public void setTemperaturaMinima(Double temperaturaMinima) 
	{
		this.temperaturaMinima = temperaturaMinima;
	}
	
	public Double getTemperaturaMaxima() 
	{
		return temperaturaMaxima;
	}
	
	public void setTemperaturaMaxima(Double temperaturaMaxima) 
	{
		this.temperaturaMaxima = temperaturaMaxima;
	}
	
	public Double getHumidade() 
	{
		return humidade;
	}
	
	public void setHumidade(Double humidade) 
	{
		this.humidade = humidade;
	}
	
	public String getDescricao() 
	{
		return descricao;
	}
	
	public void setDescricao(String descricao) 
	{
		this.descricao = descricao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Double getChuva() {
		return chuva;
	}

	public void setChuva(Double chuva) {
		this.chuva = chuva;
	}
}
