package br.usjt.temperatura;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.temperatura.model.Cidade;
import br.usjt.temperatura.repository.JPAUtil;

public class TesteCriarCidade {
	public static void main(String[] args) {
	EntityManager manager = JPAUtil.getEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	transaction.begin();
	Cidade c = new Cidade();
	c.setCidade("São Paulo");
	c.setLongitude("-23,5505");
	c.setLatitude("-46,6333");

	manager.persist(c);
	transaction.commit();

	manager.close();
	JPAUtil.close();
	}
}
