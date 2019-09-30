package palvelinohjelmointi.harjoitustyo.autotalli.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Auto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	@Size(min=3, max=30)
	private String merkki;
	@NotNull
	@Size(min=1, max=20)
	private String malli;
	@NotNull
	@Size(min=3, max=7)
	private String rekisterinumero;
	@NotNull
	@Min(1900)
	@Max(2019)
	private Integer vuosimalli;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "auto")
	private List<Kuva> kuvat;
	
	public Auto() {}
	
	public Auto(String merkki, String malli, String rekisterinumero, Integer vuosimalli) {
		super();
		this.merkki = merkki;
		this.malli = malli;
		this.rekisterinumero = rekisterinumero;
		this.vuosimalli = vuosimalli;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getMerkki() {
		return merkki;
	}
	
	public void setMerkki(String merkki) {
		this.merkki = merkki;
	}
	
	public String getMalli() {
		return malli;
	}
	
	public void setMalli(String malli) {
		this.malli = malli;
	}
	
	public String getRekisterinumero() {
		return rekisterinumero;
	}
	
	public void setRekisterinumero(String rekisterinumero) {
		this.rekisterinumero = rekisterinumero;
	}
	
	public Integer getVuosimalli() {
		return vuosimalli;
	}
	
	public void setVuosimalli(Integer vuosimalli) {
		this.vuosimalli = vuosimalli;
	}

	public List<Kuva> getKuvat() {
		return kuvat;
	}

	public void setKuvat(List<Kuva> kuvat) {
		this.kuvat = kuvat;
	}
}