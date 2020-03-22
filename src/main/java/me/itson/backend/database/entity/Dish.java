package me.itson.backend.database.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.itson.backend.dto.DishDTO;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	private String name;
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Asset asset;
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name = "dish_id", nullable=false)
	private Location location;
	
	public Dish(DishDTO dishDto) {
		name = dishDto.getName();
		description = dishDto.getDescription();
		price = dishDto.getPrice();
		location = Location.builder().id(dishDto.getLocationId()).build();
	}
	
}
