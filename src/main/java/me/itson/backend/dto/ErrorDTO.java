package me.itson.backend.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {

	private int code;
	private String message;
	@Builder.Default
	private Date timestamp = new Date();
	
}
