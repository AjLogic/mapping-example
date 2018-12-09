package hibernet.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hibernet.example.demo.db.entity.Activity;
import hibernet.example.demo.db.entity.EsActivity;
import hibernet.example.demo.db.entity.EsDocumentConversionParserExceptions;
import hibernet.example.demo.db.entity.Provider;
import hibernet.example.demo.service.CustomDbService;

@SpringBootApplication
@RestController
public class ExampleApplication {

	@Autowired
	CustomDbService customDbService;

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);

	}

	@GetMapping(value = "/get")
	public List<EsActivity> getEsActivity(){
		List<Provider> providers = customDbService.getActiveActivity();
		List<EsActivity> esActivities = new ArrayList<>();
		providers.forEach(x -> {
			esActivities.addAll(getListofEsActivities(x));
		});
		return esActivities;
	}

	private List<EsActivity> getListofEsActivities(Provider provider){
		List<EsActivity> esActivity = new ArrayList<>();
		
		provider.getActivity().forEach((activity) -> {
			EsActivity esObject = new EsActivity();
			esObject.setActivityId(activity.getActivityId());
			esObject.setProviderId(provider.getProviderId().toString());
			esObject.setActivityName(activity.getActivityName());
			System.out.println(activity.getInclusion().getGender());
			esObject.setGender(convertStringToObject(activity.getInclusion().getGender(),"Inclusion.gender"));
			esActivity.add(esObject);
		});
		return esActivity;
	}

	
	@SuppressWarnings("unchecked")
	private List<String> convertStringToObject(String value, String field) {
		
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(value, List.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
