package ca.sheridancollege.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2980877132637072815L;
	private int BookID;
	private String course_code;
	private String title;
	private String author;
	private Double price;
	private int bquantity;
	private int oquantity;
	private int mquantity;
	private int OakID;
	private int MissID;
	private int BrampID;
	private int Quantity;
	public Book(String course_code, String title, String author, Double price, int quantity) {
		this.course_code = course_code;
		this.title = title;
		this.author = author;
		this.price = price;
		Quantity = quantity;
	}
	

	

	
}
