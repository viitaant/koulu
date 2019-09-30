package palvelinohjelmointi.harjoitustyo.autotalli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kayttaja {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "tunnus", nullable = false, unique = true)
    private String tunnus;

    @Column(name = "salasana", nullable = false)
    private String salasana;

    @Column(name = "rooli", nullable = false)
    private String rooli;
    
    public Kayttaja() {
    }

	public Kayttaja(String tunnus, String salasana, String rooli) {
		super();
		this.tunnus = tunnus;
		this.salasana = salasana;
		this.rooli = rooli;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTunnus() {
		return tunnus;
	}

	public void setTunnus(String tunnus) {
		this.tunnus = tunnus;
	}

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}

	public String getRooli() {
		return rooli;
	}

	public void setRooli(String rooli) {
		this.rooli = rooli;
	}
}