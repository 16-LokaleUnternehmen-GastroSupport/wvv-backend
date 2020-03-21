package me.itson.backend.dto;

import java.nio.file.Path;

import lombok.Data;
import me.itson.backend.database.entity.Asset;

@Data
public class AssetDTO {
	
	private Path pathToFile;
	private String originalName;
	private String suffix;
	
	public AssetDTO(Asset asset) {
		pathToFile = asset.getPathToFile();
		originalName = asset.getOriginalName();
		suffix = asset.getSuffix();
	}
}
