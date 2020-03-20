package me.itson.backend.dto;

import java.util.Date;

import lombok.Data;

@Data
public class VersionDTO {

	private String profile;
	private String build;
	private Date createdAt;

}
