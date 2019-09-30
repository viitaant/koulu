package palvelinohjelmointi.harjoitustyo.autotalli.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import palvelinohjelmointi.harjoitustyo.autotalli.model.Kayttaja;
import palvelinohjelmointi.harjoitustyo.autotalli.model.KayttajaRepository;

@Service
public class KayttajaService implements UserDetailsService  {
	private final KayttajaRepository repository;

	@Autowired
	public KayttajaService(KayttajaRepository kayttajaRepository) {
		this.repository = kayttajaRepository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
    	Kayttaja kayttaja = repository.findByTunnus(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, kayttaja.getSalasana(), 
        		AuthorityUtils.createAuthorityList(kayttaja.getRooli()));
        return user;
    }   
} 