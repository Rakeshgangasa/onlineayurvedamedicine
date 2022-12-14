
  package com.cg.oam.exception;
  
  import org.springframework.http.HttpStatus; import
  org.springframework.web.bind.annotation.ResponseStatus;

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public class CategoryNotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public CategoryNotFoundException() {
			super();
		}

		public CategoryNotFoundException(String message) {
			super(message);

		}
	}
