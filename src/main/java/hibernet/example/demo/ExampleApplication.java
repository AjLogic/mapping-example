package hibernet.example.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hibernet.example.demo.db.entity.Activity;
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
	public Set<Activity> getEsActivity() {
		List<Provider> providers = customDbService.getActiveActivity();
		Set<Activity> activityies = new HashSet<>();
		providers.forEach(x -> {
			activityies.addAll(x.getActivity());
		});
		System.out.println("test");
		return activityies;
		
	}

}
