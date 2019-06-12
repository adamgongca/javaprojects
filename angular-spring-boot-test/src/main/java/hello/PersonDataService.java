package hello;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDataService {

	@Autowired
	private PersonRepository personRepository;

	@PostConstruct
	public void InitPersonTable() {

		Person p1 = new Person("Anna", randomAlpha(6));
		personRepository.save(p1);
		Person p2 = new Person("Benny", randomAlpha(6));
		personRepository.save(p2);
		Person p3 = new Person("Charles", randomAlpha(6));
		personRepository.save(p3);
		Person p4 = new Person("Denial", randomAlpha(6));
		personRepository.save(p4);
		Person p5 = new Person("Eella", randomAlpha(6));
		personRepository.save(p5);
		Person p6 = new Person("Felix", randomAlpha(6));
		personRepository.save(p6);
		Person p7 = new Person("Gina", randomAlpha(6));
		personRepository.save(p7);
		Person p8 = new Person("Helen", randomAlpha(6));
		personRepository.save(p8);
		Person p9 = new Person("Ian", randomAlpha(6));
		personRepository.save(p9);
		Person p10 = new Person("Jack", randomAlpha(6));
		personRepository.save(p10);

	}

	public List<Person> list() {
		return personRepository.findAll();
	}

	public List<Person> search(String firstname, String lastname) {

		if (firstname != null && !firstname.isEmpty() && lastname != null && !lastname.isEmpty()) {
			return personRepository.findByFirstNameAndLastName("%" + firstname + "%", "%" + lastname + "%");
		} else if (firstname != null && !firstname.isEmpty())
			return personRepository.findByFirstName("%" + firstname + "%");
		else if (lastname != null && !lastname.isEmpty())
			return personRepository.findByLastName("%" + lastname + "%");
		else
			return null;
	}

	private static final String ALPHA_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private String randomAlpha(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_STRING.length());
			builder.append(ALPHA_STRING.charAt(character));
		}
		return builder.toString();
	}

}
