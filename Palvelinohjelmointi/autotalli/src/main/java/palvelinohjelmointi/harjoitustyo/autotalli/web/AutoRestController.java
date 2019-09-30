package palvelinohjelmointi.harjoitustyo.autotalli.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import palvelinohjelmointi.harjoitustyo.autotalli.model.Auto;
import palvelinohjelmointi.harjoitustyo.autotalli.model.AutoRepository;

@RestController
@RequestMapping("rest")
public class AutoRestController {
	
	@Autowired
	private AutoRepository repository; 
	
	@GetMapping(value="/lista")
	public List<Auto> listaaAutot(Model model) {
		return (List<Auto>) repository.findAll();
	}
	
	@GetMapping(value="/auto/{id}")
	public Optional<Auto> haeAuto(@PathVariable("id") Long id) {	
		return repository.findById(id);
	}  
	
	@PostMapping(value = "/auto")
	public List<Auto> tallennaAuto(@RequestBody Auto auto){
		repository.save(auto);
		return (List<Auto>) repository.findAll();
	}
}