package palvelinohjelmointi.harjoitustyo.autotalli;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import palvelinohjelmointi.harjoitustyo.autotalli.model.Auto;
import palvelinohjelmointi.harjoitustyo.autotalli.model.AutoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoRepositoryTest {

	@Autowired
	private AutoRepository repository;
	
	@Test
	public void findByLastnameShouldReturnStudent() {
		Optional<Auto> autot = repository.findById((long) 1);
		assertThat(autot.get().getMerkki()).isEqualTo("Audi");
	}
	
	@Test
	public void luoUusiAuto() {
		Auto auto = new Auto("Volksagen", "Polo", "ABC-123", 1980);
		repository.save(auto);
		assertThat(auto.getId()).isNotNull();
	}
}