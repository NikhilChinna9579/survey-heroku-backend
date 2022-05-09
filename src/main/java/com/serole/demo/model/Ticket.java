package com.serole.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Ticket")



public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 
	private double amount;
	private String categeroy;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCategeroy() {
		return categeroy;
	}
	public void setCategeroy(String categeroy) {
		this.categeroy = categeroy;
	}
	
	

}
