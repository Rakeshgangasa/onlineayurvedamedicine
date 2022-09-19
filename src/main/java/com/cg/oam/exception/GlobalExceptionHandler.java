package com.cg.oam.exception;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

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
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
 
        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("timestamp", new Date());
        body.put("status", status.value());
 
        // Get all errors
        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
 
        body.put("errors", errors);
 
        return new ResponseEntity<>(body, headers, status);
    }
	
}