package com.luv2code.EmployeeManagementSystemBackend.CustomExceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.luv2code.EmployeeManagementSystemBackend.Entity.ErrorDetails;


public class GlobalExceptions extends ResponseEntityExceptionHandler  {
		
		
		 @ExceptionHandler(ResourceNotFoundExceptions.class)
		    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundExceptions exception,
		                                                                        WebRequest webRequest){
		        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
		                webRequest.getDescription(false));
		        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
		    }

		    @ExceptionHandler(ApiExceptions.class)
		    public ResponseEntity<ErrorDetails> handleBlogAPIException(ApiExceptions exception,
		                                                                        WebRequest webRequest){
		        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
		                webRequest.getDescription(false));
		        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
		    }
		    // global exceptions
		    @ExceptionHandler(Exception.class)
		    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,
		                                                               WebRequest webRequest){
		        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
		                webRequest.getDescription(false));
		        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		    
		    
		    @ExceptionHandler(IllegalArgumentException.class)
		    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		    }

			@Override
			protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
					HttpHeaders headers, HttpStatusCode status, WebRequest request) {
				
				 Map<String, String> errors = new HashMap<>();
			        ex.getBindingResult().getAllErrors().forEach((error) ->{
			            String fieldName = ((FieldError)error).getField();
			            String message = error.getDefaultMessage();
			            errors.put(fieldName, message);
			        });

			        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
			}

		    

}
