package br.usjt.temperatura;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.usjt.temperatura.model.Cidade;
import br.usjt.temperatura.repository.CidadeRepository;


@RunWith(SpringRunner.class)
@SpringBootTest

public class CidadeTest {
	
		@Autowired
		private CidadeRepository cidadeRepository;

		@Test
		public void testInsertCidade() {
			Cidade c = new Cidade();
			c.setCidade("São Paulo");
			c.setLongitude("-23,5505");
			c.setLatitude("-46,6333");
			c = cidadeRepository.save(c);
			System.out.println(c.getId());
		}
		
		@Test
		public void testInsertCidadeI() {
			Cidade c = new Cidade();
			c.setCidade("Maua");
			c.setLongitude("-46.4614");
			c.setLatitude("-23.6687");
			c = cidadeRepository.save(c);
			System.out.println(c.getId());
		}

	@Test
		public void testBuscaPorNome() {
			Optional<Cidade> c = cidadeRepository.findByNome(null);
			System.out.println(c.get());
		}

		@Test
		public void testBuscaTodos() {
			List<Cidade> list = cidadeRepository.findAll();
			System.out.println(list);
		}

		@Test
		public void testQuantidade() {
			System.out.println(cidadeRepository.count());
		}

		//@Test
		//public void testDeletePorNome() {
			//Cidade c = new Cidade();
			//c.setNome(1L);
			//cidadeRepository.delete(c);
		//}
	}


