package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class ListItem {
//Don Erickson
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")//instance variables below
	private int id;
	@Column(name="STORE")
	private String store;
	@Column(name="ITEM")
	private String item;
	
	//default no arg con
	public ListItem() {
		super();
	}

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	//helper method sans id cause thats unique... unique new york.
	public ListItem(String store, String item) {
		super();
		this.store = store;
		this.item = item;
	}
	
	//another hamberder helper method but this one returns the goods
	public String returnItemDetails() {
		return store + ":" + item;
	}
	
	
	
}
