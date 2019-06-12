package hello;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/api")
class PersonService {
	
	@Autowired
	private PersonDataService personDataService;
	
	private ObjectMapper Objmap = new ObjectMapper();

	@GetMapping(value = "/personList", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getPersonList() {
		personDataService.InitPersonTable();
		
		List<Person> ps = personDataService.list();

		try {
			String jsonStr = Objmap.writeValueAsString(ps);
			return jsonStr;
		} catch (IOException ex) {

		}
		return "";
	}

	
	@GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getSearch(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname ) {
		
		List<Person> ps = personDataService.search(firstname, lastname);
		try {
			String jsonStr = Objmap.writeValueAsString(ps);
			return jsonStr;
		} catch (IOException ex) {

		}

		return "";
	}

		
	
}
