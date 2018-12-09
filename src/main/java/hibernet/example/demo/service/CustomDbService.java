package hibernet.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernet.example.demo.db.entity.Provider;

@Service
public class CustomDbService {

	@Autowired
	EntityManager entityManager;
	Integer crc = 1;
	Integer code = 1;
	Boolean active = Boolean.TRUE;

	public List<Provider> getActiveActivity() {
		TypedQuery<Provider> typedQuery = entityManager.createNamedQuery("Provider.findActiveProvider", Provider.class);
		return typedQuery.getResultList();
	}

}
