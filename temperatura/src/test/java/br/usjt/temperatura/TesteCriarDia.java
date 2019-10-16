package br.usjt.temperatura;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.temperatura.model.Dia;
import br.usjt.temperatura.model.Temperatura;
import br.usjt.temperatura.repository.JPAUtil;

public class TesteCriarDia {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Dia d = new Dia ();
		d.setDia("Terça");
		manager.persist(d);
		
		Temperatura t = new Temperatura();
		t.setChuva("50");
		t.setData("28/10/2019");
		t.setDescricao("Céu Coberto");
		t.setUmidade("Umidade de 50");
		t.setMaxima("28");
		t.setMinima("18");	
				
		manager.persist(t);
		transaction.commit();

		manager.close();
		JPAUtil.close();
		}
}


