package palvelinohjelmointi.harjoitustyo.autotalli.model;

import org.springframework.data.repository.CrudRepository;

public interface KayttajaRepository extends CrudRepository<Kayttaja, Long> {
	Kayttaja findByTunnus(String tunnus);
}