package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.ArBinding;
import in.ashokit.service.ArService;

@RestController
public class ArController {
	
	@Autowired
	private ArService service;
	
	@PostMapping("/register")
	public String Registration(@RequestBody ArBinding data){
		return service.registrtion(data);
//		return new ResponseEntity<string>(string , HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public List<ArBinding> allUser(){
		return service.regUsers();
	}

}
