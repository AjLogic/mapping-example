package hibernet.example.demo.db.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Table(name = "activity")
@Entity
public class Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6296161124290236095L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "activity_id")
	private Integer activityId;

	@Column(name = "provider_id")
	private String providerId;

	@Column(name = "activity_name")
	private String activityName;

	@Column(name = "active")
	private Boolean active;


	@OneToOne(fetch=FetchType.EAGER )
	@JoinTable(name = "exclusion_mapping", joinColumns = {
			@JoinColumn(table = "Activity", name = "activity_id")}
	, inverseJoinColumns = @JoinColumn(table = "exclusion", name = "exclusion_id"))
	public Exclusion exclusion;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinTable(name = "inclusion_mapping", joinColumns = {
			@JoinColumn(table = "Activity", name = "activity_id") }
	, inverseJoinColumns = @JoinColumn(table = "inclusion", name = "inclusion_id"))
	public Inclusion inclusion;

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Exclusion getExclusion() {
		return exclusion;
	}

	public void setExclusion(Exclusion exclusion) {
		this.exclusion = exclusion;
	}

	public Inclusion getInclusion() {
		return inclusion;
	}

	public void setInclusion(Inclusion inclusion) {
		this.inclusion = inclusion;
	}

	

}
