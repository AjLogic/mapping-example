package hibernet.example.demo.db.entity;

import java.util.List;

public class EsActivity {

	private Integer activityId;
	private String providerId;
	private String activityName;

	private List<String> gender;
	private List<AgeGroup> ageGroup;

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

	public List<String> getGender() {
		return gender;
	}

	public void setGender(List<String> gender) {
		this.gender = gender;
	}

	public List<AgeGroup> getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(List<AgeGroup> ageGroup) {
		this.ageGroup = ageGroup;
	}
}
