package ca.sheridancollege.database;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.beans.Book;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate Jdbc;

	public void addBookDavis(Book book) {

		MapSqlParameterSource para = new MapSqlParameterSource();
		String query = "INSERT INTO  brampton (course_code, title, author, price, bquantity) "
				+ "VALUES(:course_code, :title, :author, :price, :Quantity)";

		para.addValue("course_code", book.getCourse_code());
		para.addValue("title", book.getTitle());
		para.addValue("author", book.getAuthor());
		para.addValue("price", book.getPrice());
		para.addValue("Quantity", book.getQuantity());

		Jdbc.update(query, para);
	}

	public ArrayList<Book> getBookDavis() {
		String query = "Select * from brampton";

		ArrayList<Book> book_info = (ArrayList<Book>) Jdbc.query(query, new BeanPropertyRowMapper<Book>(Book.class));
		return book_info;

	}

	public Book getBookByBrampID(int BrampID) {
		MapSqlParameterSource para = new MapSqlParameterSource();
		String query = "SELECT * FROM brampton WHERE BrampID=:BrampID";
		para.addValue("BrampID", BrampID);
		ArrayList<Book> cont = (ArrayList<Book>) Jdbc.query(query, para, new BeanPropertyRowMapper<Book>(Book.class));

		if (cont.size() > 0)
			return cont.get(0);
		return null;

	}

	public void setBookByBrampId(int BrampID, String course_code, String title, String author, double price,
			int bquantity) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String q = "update brampton set course_code=:course_code, title=:title, author=:author, price=:price, bquantity=:Quantity where BrampID=:BrampID";
		param.addValue("BrampID", BrampID);
		param.addValue("course_code", course_code);
		param.addValue("title", title);
		param.addValue("author", author);
		param.addValue("price", price);
		param.addValue("Quantity", bquantity);
		Jdbc.update(q, param);
	}

	public void deleteBookByBrampId(int BrampID) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String q = "delete from brampton where BrampID=:BrampID";
		param.addValue("BrampID", BrampID);
		Jdbc.update(q, param);
	}

	public void purchaseBookBrampton(int BrampID, int bquantity) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String q = "UPDATE brampton SET bquantity=:Quantity where BrampID=:BrampID";
		param.addValue("BrampID", BrampID);
		param.addValue("Quantity", String.valueOf(bquantity));
		System.out.println(q);
		Jdbc.update(q, param);
	}

	public void addBookOakville(Book book) {

		MapSqlParameterSource para = new MapSqlParameterSource();
		String query = "INSERT INTO oakville (course_code, title, author, price, oquantity) VALUES(:course_code, :title, :author, :price, :Quantity)";

		para.addValue("course_code", book.getCourse_code());
		para.addValue("title", book.getTitle());
		para.addValue("author", book.getAuthor());
		para.addValue("price", book.getPrice());
		para.addValue("Quantity", book.getQuantity());

		Jdbc.update(query, para);
	}

	public ArrayList<Book> getBookOakville() {
		String query = "Select * from oakville";

		ArrayList<Book> book_info = (ArrayList<Book>) Jdbc.query(query, new BeanPropertyRowMapper<Book>(Book.class));
		return book_info;

	}

	public Book getBookByOakID(int OakID) {
		MapSqlParameterSource para = new MapSqlParameterSource();
		String query = "SELECT * FROM oakville WHERE OakID=:OakID";
		para.addValue("OakID", OakID);
		ArrayList<Book> cont = (ArrayList<Book>) Jdbc.query(query, para, new BeanPropertyRowMapper<Book>(Book.class));

		if (cont.size() > 0)
			return cont.get(0);
		return null;

	}

	public void setBookByOakId(int OakID, String course_code, String title, String author, double price,
			int oquantity) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String q = "update oakville set course_code=:course_code, title=:title, author=:author, price=:price, oquantity=:Quantity where OakID=:OakID";
		param.addValue("OakID", OakID);
		param.addValue("course_code", course_code);
		param.addValue("title", title);
		param.addValue("author", author);
		param.addValue("price", price);
		param.addValue("Quantity", oquantity);
		Jdbc.update(q, param);
	}

	public void deleteBookByOakId(int OakID) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String q = "delete from oakville where OakID=:OakID";
		param.addValue("OakID", OakID);
		Jdbc.update(q, param);
	}

	public void purchaseBookOakville(int OakID, int oquantity) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String q = "UPDATE oakville SET oquantity=:Quantity where OakID=:OakID";
		param.addValue("OakID", OakID);
		param.addValue("Quantity", String.valueOf(oquantity));
		System.out.println(q);
		Jdbc.update(q, param);
	}


	public void addBookMissussaga(Book book) {

		MapSqlParameterSource para = new MapSqlParameterSource();
		String query = "INSERT INTO  missussaga (course_code, title, author, price, mquantity) VALUES(:course_code, :title, :author, :price, :Quantity)";

		para.addValue("course_code", book.getCourse_code());
		para.addValue("title", book.getTitle());
		para.addValue("author", book.getAuthor());
		para.addValue("price", book.getPrice());
		para.addValue("Quantity", book.getQuantity());

		Jdbc.update(query, para);
	}

	public ArrayList<Book> getBookMissussaga() {
		String query = "Select * from missussaga";

		ArrayList<Book> book_info = (ArrayList<Book>) Jdbc.query(query, new BeanPropertyRowMapper<Book>(Book.class));
		return book_info;

	}

	public Book getBookByMissID(int MissID) {
		MapSqlParameterSource para = new MapSqlParameterSource();
		String query = "SELECT * FROM missussaga WHERE MissID=:MissID";
		para.addValue("MissID", MissID);
		ArrayList<Book> cont = (ArrayList<Book>) Jdbc.query(query, para, new BeanPropertyRowMapper<Book>(Book.class));

		if (cont.size() > 0)
			return cont.get(0);
		return null;

	}

	public void setBookByMissId(int MissID, String course_code, String title, String author, double price,
			int mquantity) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String q = "update missussaga set course_code=:course_code, title=:title, author=:author, price=:price, mquantity=:Quantity where MissID=:MissID";
		param.addValue("MissID", MissID);
		param.addValue("course_code", course_code);
		param.addValue("title", title);
		param.addValue("author", author);
		param.addValue("price", price);
		param.addValue("Quantity", mquantity);
		Jdbc.update(q, param);
	}

	public void deleteBookByMissId(int MissID) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String q = "delete from missussaga where MissID=:MissID";
		param.addValue("MissID", MissID);
		Jdbc.update(q, param);
	}


	public void purchaseBookMissussaga(int MissID, int mquantity) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String q = "UPDATE missussaga SET mquantity=:Quantity where MissID=:MissID";
		param.addValue("MissID", MissID);
		param.addValue("Quantity", String.valueOf(mquantity));
		System.out.println(q);
		Jdbc.update(q, param);
	}

	
	public ArrayList<Book> searchBramptonBook(String field, String value) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		String q = "select * from brampton ";
		if(field.equals("BrampID")) {
			q+="where BrampID=:BrampID";
			param.addValue("BrampID", value);
	
		}else if (field.equals("Title")){
			q+="where Title like :Title";
			param.addValue("Title", "%" + value +"%");

		}else if (field.equals("Author")){
			q+="where Author like :Author" ;
			param.addValue("Author","%"+ value +"%");
	
		}else if (field.equals("Course_code")){
			q+="where Course_code like :Course_code";
			param.addValue("Course_code", "%"+ value +"%");
	
		}else if (field.equals("bquantity")){
			q+="where bquantity=:bquantity";
			param.addValue("bquantity", value);
	
		}
		ArrayList<Book> list = (ArrayList<Book>) Jdbc.query(q, param, new BeanPropertyRowMapper<Book>(Book.class));
       return list;
	}
	
	public ArrayList<Book> searchMissussagaBook(String field, String value) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		String q = "select * from missussaga ";
		if(field.equals("MissID")) {
			q+="where MissID=:MissID";
			param.addValue("MissID", value);
	
		}else if (field.equals("Title")){
			q+="where Title like :Title";
			param.addValue("Title", "%" +  value +"%");

		}else if (field.equals("Author")){
			q+="where Author like :Author" ;
			param.addValue("Author","%"+ value +"%");
	
		}else if (field.equals("Course_code")){
			q+="where Course_code like :Course_code";
			param.addValue("Course_code", "%"+ value +"%");
	
		}else if (field.equals("mquantity")){
			q+="where mquantity=:mquantity";
			param.addValue("mquantity", value);
	
		}
		ArrayList<Book> list = (ArrayList<Book>) Jdbc.query(q, param, new BeanPropertyRowMapper<Book>(Book.class));
       return list;
	}
	
	public ArrayList<Book> searchOakvilleBook(String field, String value) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		String q = "select * from oakville ";
		if(field.equals("OakID")) {
			q+="where OakID=:OakID";
			param.addValue("OakID", value);
	
		}else if (field.equals("Title")){
			q+="where Title like :Title";
			param.addValue("Title", "%" +  value +"%");

		}else if (field.equals("Author")){
			q+="where Author like :Author" ;
			param.addValue("Author", "%"+ value +"%");
	
		}else if (field.equals("Course_code")){
			q+="where Course_code like :Course_code";
			param.addValue("Course_code", "%"+ value +"%");
	
		}else if (field.equals("oquantity")){
			q+="where oquantity=:oquantity";
			param.addValue("oquantity", value);
	
		}
		ArrayList<Book> list = (ArrayList<Book>) Jdbc.query(q, param, new BeanPropertyRowMapper<Book>(Book.class));
       return list;
	}
}
