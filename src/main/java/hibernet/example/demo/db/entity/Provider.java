package hibernet.example.demo.db.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "provider")
@NamedQuery(name = "Provider.findActiveProvider", query = "SELECT p FROM Provider p  LEFT JOIN FETCH p.activity a where p.crc=1 and  p.active=1 and a.active=1")
public class Provider implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 778370725703647297L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "provider_id")
	private Integer providerId;

	@OneToMany(mappedBy = "providerId",fetch=FetchType.EAGER)
	private Set<Activity> activity;

	public Set<Activity> getActivity() {
		return activity;
	}

	public void setActivity(Set<Activity> activity) {
		this.activity = activity;
	}

	@Column(name = "crc")
	private String crc;

	@Column(name = "active")
	private Boolean active;

	@Column(name = "name")
	private Boolean name;

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public String getCrc() {
		return crc;
	}

	public void setCrc(String crc) {
		this.crc = crc;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getName() {
		return name;
	}

	public void setName(Boolean name) {
		this.name = name;
	}

	

}
