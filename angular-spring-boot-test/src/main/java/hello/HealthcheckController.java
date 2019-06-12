package hello;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@RestController
class HealthcheckController {

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	void onIllegalArgumentException(IllegalArgumentException exception) {
	}
	
	
	@ExceptionHandler(IllegalStateException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	void onIllegalStateException(IllegalStateException exception) {
	}
	
		
    @GetMapping(value = "/healthcheck", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String healthcheck(@RequestParam("format") String format ) {
    	if ("short".equals(format))
    		return " { \"status\": \"OK\" }" ;
    	else if ("full".equals(format)) {
//    		Date date = Calendar.getInstance().getTime();
//    		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd'T'hh:mm:ss'Z'");
//    		String formatDateTime = dateFormat.format(date);
    		
    		DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-mm-dd'T'hh:mm:ss'Z'");    		 
    		LocalDateTime localDateTime = LocalDateTime.now();    		 
    		String formatDateTime = FOMATTER.format(localDateTime);
  		
    		return "{ \"currentTime\": \"" + formatDateTime + "\", \"application\": \"OK\" }";
    	}
    	else throw new IllegalArgumentException();
    }

    @PutMapping(value = "/healthcheck")
    public void healthcheckPut() {
        throw new IllegalStateException();
    }

    @PostMapping(value = "/healthcheck")
    public void healthcheckPost() {
        throw new IllegalStateException();
    }


    @DeleteMapping(value = "/healthcheck")
    public void healthcheckDelete() {
        throw new IllegalStateException();
    }
    
    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String sayHello() {
    	return "Greetings from Spring Boot!";
    }

}