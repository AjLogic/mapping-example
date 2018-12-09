package hibernet.example.demo.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exclusion")
public class Exclusion {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="exclusion_id")
	public Integer exclusionId;
	
	
	@Column(name="email")
	public String email;
	
	@Column(name="age_group")
	public String ageGroup;
	
	@Column(name="gender")
	public String gender;
	
	@Column(name="offender")
	public Boolean offender;

	public Integer getExclusionId() {
		return exclusionId;
	}

	public void setExclusionId(Integer exclusionId) {
		this.exclusionId = exclusionId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getOffender() {
		return offender;
	}

	public void setOffender(Boolean offender) {
		this.offender = offender;
	}
	
}
