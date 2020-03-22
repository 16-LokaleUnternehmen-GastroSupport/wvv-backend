package me.itson.backend.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.itson.backend.database.entity.Dish;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DishDTO {

	private String id;
	
	@NotEmpty
	@NotNull
	private String name;
	private String description;
	
	private AssetDTO asset;
	@NotEmpty
	@NotNull
	private BigDecimal price;

	@NotEmpty
	@NotNull
	private String locationId;
	
	public DishDTO(Dish dish) {
		id = dish.getId();
		name = dish.getName();
		asset = dish.getAsset() != null ? new AssetDTO(dish.getAsset()) : null;
		price = dish.getPrice();
		locationId = dish.getLocation() != null ? dish.getLocation().getId() : null;
	}
	
}
