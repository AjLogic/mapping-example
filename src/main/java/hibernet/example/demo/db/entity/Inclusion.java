package hibernet.example.demo.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "inclusion")
public class Inclusion {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="inclusion_id")
	public Integer inclusionId;
	
	
	@Column(name="email")
	public String email;
	
	@Column(name="age_group")
	public String ageGroup;
	
	@Column(name="gender")
	public String gender;
	
	@Column(name="offender")
	public Boolean offender;

	public Integer getInclusionId() {
		return inclusionId;
	}

	public String getEmail() {
		return email;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public String getGender() {
		return gender;
	}

	public Boolean getOffender() {
		return offender;
	}

	
}
