package palvelinohjelmointi.harjoitustyo.autotalli.web;

import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import palvelinohjelmointi.harjoitustyo.autotalli.model.Auto;
import palvelinohjelmointi.harjoitustyo.autotalli.model.Kuva;
import palvelinohjelmointi.harjoitustyo.autotalli.model.KuvaRepository;
import palvelinohjelmointi.harjoitustyo.autotalli.model.AutoRepository;

/**
 * Kontrolleri autojen käsittelyyn.
 * 
 * @author viitaant
 *
 */
@Controller
public class AutoController {

	@Autowired
	private AutoRepository repository;

	@Autowired
	private KuvaRepository kuvarepository;

	@GetMapping(value = "/kirjaudu")
	public String login() 
	{
		return "kirjaudu";
	}

	/**
	 * Listaa kaikki autot.
	 * 
	 * @param model - Mallin attribuutit.
	 * @return - Lista-näkymän.
	 */
	@GetMapping(value = "/autot")
	public String listaaAutot(Model model) 
	{
		model.addAttribute("autot", repository.findAll());
		return "autot";
	}

	/**
	 * Uuden auton lisääminen.
	 * 
	 * @param model - Mallin attribuutit.
	 * @return - Lisaa-näkymän.
	 */
	@GetMapping(value = "/auto")
	public String lisaaAuto(Model model) 
	{
		model.addAttribute("auto", new Auto());		
		return "auto";
	}
	
	/**
	 * Muokkaa auton tietoja. 
	 * 
	 * @param id    - Muokattava auton id.
	 * @param model - Mallin attribuutit.
	 * @return - Muokkaa-näkymä.
	 */
	@GetMapping(value = "/auto/{id}")
	public String muokkaaAutoa(@PathVariable("id") Long id, Model model) 
	{
		model.addAttribute("auto", repository.findById(id));		
		return "auto";
	}

	/**
	 * Tallentaa auton tiedot.
	 * 
	 * @param auto          - Auto-luokka.
	 * @param bindingResult - Sidonnan tulokset.
	 * @return - Validointi virheen saatuessa lisaa- tai muokkaa-näkymä.
	 *         Onnistuneesta tallennuksesta lista-näkymä.
	 */
	@PostMapping(value = "/tallenna")
	public String tallennaAuto(@Valid Auto auto, BindingResult bindingResult, @RequestParam("kuva") MultipartFile tiedosto) 
	{
		if (bindingResult.hasErrors()) {
			return "auto";
		}

		repository.save(auto);

		if (!tiedosto.isEmpty()) 
		{

			try 
			{
				kuvarepository.save(new Kuva(tiedosto.getOriginalFilename(), tiedosto.getContentType(),	tiedosto.getBytes(), auto));
			} 
			catch (IOException e) 
			{

				e.printStackTrace();
			}
		}
		return "redirect:autot";
	}	
	
	/**
	 * Poistaa auton.
	 * 
	 * @param id - Poistettavan auton id.
	 * @return - Lista-näkymä.
	 */
	@GetMapping(value = "/poista/{id}")  
	public String poistaAuto(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return "redirect:../autot";
	}	

	@GetMapping("/kuva/{id}")
	public ResponseEntity<byte[]> avaaKuva(@PathVariable Long id) 
	{
		Optional<Kuva> kuvaOptional = kuvarepository.findById(id);

		if (kuvaOptional.isPresent()) 
		{
			Kuva kuva = kuvaOptional.get();
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + kuva.getNimi() + "\"")
					.body(kuva.getTiedosto());
		}

		return ResponseEntity.status(404).body(null);
	}
}