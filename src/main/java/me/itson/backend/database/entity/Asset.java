package me.itson.backend.database.entity;

import java.nio.file.Path;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.itson.backend.database.converter.PathConverter;
import me.itson.backend.dto.AssetDTO;

@Entity
@Data
@NoArgsConstructor
public class Asset {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Convert(converter = PathConverter.class)
	private Path pathToFile;
	private String originalName;
	private String suffix;
	
	public Asset(AssetDTO assetDto) {
		pathToFile = assetDto.getPathToFile();
		originalName = assetDto.getOriginalName();
		suffix = assetDto.getSuffix();
	}
	
}
