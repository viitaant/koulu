package palvelinohjelmointi.harjoitustyo.autotalli;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import palvelinohjelmointi.harjoitustyo.autotalli.model.Auto;
import palvelinohjelmointi.harjoitustyo.autotalli.model.AutoRepository;
import palvelinohjelmointi.harjoitustyo.autotalli.model.Kayttaja;
import palvelinohjelmointi.harjoitustyo.autotalli.model.KayttajaRepository;

@SpringBootApplication
public class AutotalliApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutotalliApplication.class, args);
	}

	@Bean
	public CommandLineRunner studentDemo(AutoRepository autoRepository, KayttajaRepository kayttajaRepository) {
		return (args) -> {
			autoRepository.save(new Auto("Audi", "A1", "SNT-123", 2019));
			autoRepository.save(new Auto("Audi", "A3", "BNS-399", 2019));
			autoRepository.save(new Auto("Audi", "A4", "JFK-69", 2019));
			
			kayttajaRepository.save(new Kayttaja("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER"));
			kayttajaRepository.save(new Kayttaja("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN"));
		};
	}
}