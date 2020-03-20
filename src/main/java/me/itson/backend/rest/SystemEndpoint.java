package me.itson.backend.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.itson.backend.dto.VersionDTO;

@RestController
@RequestMapping("system")
public class SystemEndpoint {

	@Value("${app.version:local}")
	private String versionNumber;

	@GetMapping(value = { "", "version" })
	public VersionDTO getRunningState() {
		VersionDTO version = new VersionDTO();
		version.setBuild(versionNumber);
		version.setCreatedAt(new Date());
		return version;
	}

}
