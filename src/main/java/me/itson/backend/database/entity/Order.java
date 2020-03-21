package me.itson.backend.database.entity;

import java.util.Currency;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity(name = "orders")
public class Order {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@OneToMany
	@JoinColumn(name = "order_id")
	private Set<OrderItem> items;

	private Currency totalAmount;
}
