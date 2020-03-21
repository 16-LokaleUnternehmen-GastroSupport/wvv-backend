package me.itson.backend.database.entity;

import java.util.Currency;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class Dish {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	private String name;
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Asset asset;
	private Currency price;
	
}
