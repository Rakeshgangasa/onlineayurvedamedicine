package com.cg.oam.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {

	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(MedicineNotFoundException.class)
    public ResponseEntity<String> handleMedicineNotFoundException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
       return responseEntity;
}
	@ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> handleCategoryNotFoundException1(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
       return responseEntity;
}
	@ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerNotFoundException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
       return responseEntity;
       
}
	@ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<String> handleOrderNotFoundException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
       return responseEntity;
}


  @ExceptionHandler(CategoryAlreadyExistsException.class) public
  ResponseEntity<String> handleCategoryAlreadyExistsException(Exception e) {
  ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),
  HttpStatus.NOT_FOUND); return responseEntity; }
 
	@ExceptionHandler(AppUserNotFoundException.class)
	public ResponseEntity<Object> handleAppUserNotFoundException(AppUserNotFoundException e) {
		String exceptionMessage = e.getMessage();
		LOG.error(exceptionMessage);
		HttpHeaders headers = new HttpHeaders();
		headers.add("exceptionMessage", exceptionMessage);
		ResponseEntity<Object> response = new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
		return response;
	}
	
}