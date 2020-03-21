package me.itson.backend.rest.exception;

import java.util.Date;
import java.util.stream.Collectors;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import me.itson.backend.dto.ErrorDTO;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		// Get all errors
		String errorMessages = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.joining("\n"));

		ErrorDTO error = ErrorDTO.builder().code(status.value()).timestamp(new Date()).message(errorMessages).build();

		return new ResponseEntity<>(error, headers, status);
	}


	@ExceptionHandler({ NotImplementedException.class })
	@Nullable
	public ResponseEntity<Object> handleNotImplemented(NotImplementedException ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.NOT_IMPLEMENTED;
		
		// Get all errors
		String errorMessage = "Method is not implemented yet!";

		ErrorDTO error = ErrorDTO.builder().code(status.value()).timestamp(new Date()).message(errorMessage).build();

		return new ResponseEntity<>(error, headers, status);
	}
}
