package palvelinohjelmointi.harjoitustyo.autotalli.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Kuva {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long kuvaid;
	private String nimi;
	private String tyyppi;
	@ManyToOne
	@JoinColumn(name = "id")
	private Auto auto;
	@Lob
	private byte[] tiedosto;
	
	public Kuva() {}
	
	public Kuva(String nimi, String tyyppi, byte[] tiedosto, Auto auto) {
		this.nimi = nimi;
		this.tyyppi = tyyppi;
		this.tiedosto = tiedosto;
		this.auto = auto;
	}

	public long getKuvaid() {
		return kuvaid;
	}

	public void setKuvaid(long kuvaid) {
		this.kuvaid = kuvaid;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}

	public byte[] getTiedosto() {
		return tiedosto;
	}

	public void setTiedosto(byte[] tiedosto) {
		this.tiedosto = tiedosto;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}
}