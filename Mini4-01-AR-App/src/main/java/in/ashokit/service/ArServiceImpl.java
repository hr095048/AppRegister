package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.ashokit.binding.ArBinding;
import in.ashokit.entity.ArEntity;
import in.ashokit.repo.ArRepo;

@Service
public class ArServiceImpl implements ArService {

	@Autowired
	private ArRepo repo;

	@Override
	public String registrtion(ArBinding info) {
		Integer generator = generator();
//		int prefix = Integer.parseInt("AR");
		Integer ssn = info.getSsn();
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://ssa-web-api.herokuapp.com/state/" + ssn;
		String forObject = restTemplate.getForObject(url, String.class);
		if (forObject.equalsIgnoreCase("Kentucky")) {
			ArEntity entity = new ArEntity();
			BeanUtils.copyProperties(info, entity);
			entity.setRegnumber(generator);
			repo.save(entity);
			return "Registration successful";
		} else {
			return "invalid state";
		}

	}

	@Override
	public List<ArBinding> regUsers() {
		List<ArEntity> findAll = repo.findAll();

		List<ArBinding> list = new ArrayList<>();

		for (ArEntity all : findAll) {
			ArBinding arb = new ArBinding();
			BeanUtils.copyProperties(all, arb);
			list.add(arb);
		}

		return list;
	}
	
	public Integer generator() {
		Random rand = new Random();
		int maxNumber = 10;

		Integer randomNumber = rand.nextInt(maxNumber) + 1;

		return randomNumber;
	}
}
