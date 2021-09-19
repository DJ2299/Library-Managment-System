package ca.sheridancollege.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.Book;
import ca.sheridancollege.database.DatabaseAccess;

@Controller
public class HomeController {

	@Autowired
	private DatabaseAccess da;

	@GetMapping("/")
	public String home() {
		return "main.html";
	}


	@GetMapping("/createdummy")
	public String goCreateDummy() {

		GenerateRecord("D");
		GenerateRecord("M");
		GenerateRecord("T");

		return "redirect:/";
	}

	public void GenerateRecord(String string) {
		Book bk = null;
		String[] cc = { "MATH65678 ", "PROG19087", "PPROG19934", "SYST12653", "CULT87656", "SYST77565", "DABAS11435" };

		String[] sub = { "Core Java", "Java Beginner", "RDBMS", "Basic Databse", "Canadian Culture", "Fundamental Math",
				"Interface Design", "System Methodologies", "Computer Architecture", "Bsic Networking", "Cisco", "C#",
				"VB.net" };
		int c = 0;
		int q = 0;
		int s = 0;
		double p;
		for (int i = 0; i < 30; i++) {
			c = (int) (Math.random() * 6);
			s = (int) (Math.random() * 13);
			p = Math.random();
			q = (int) (Math.random() * 20);

			bk = new Book(cc[c], sub[s], "author" + i, p * 201.13, q);
			switch (string) {
			case "D":
				da.addBookDavis(bk);
				break;
			case "M":
				da.addBookMissussaga(bk);
				break;
			case "T":
				da.addBookOakville(bk);
				break;
			default:
				break;
			}
		}
	}

	@GetMapping("/viewbrampton")
	public String seebrampton(Model model, @RequestParam(defaultValue = "null") String field,
			@RequestParam(defaultValue = "null") String value) {

		ArrayList<Book> list = new ArrayList<Book>();
		list = da.getBookDavis();
		model.addAttribute("b", list);
		return "viewbrampton.html";
	}

	@GetMapping("/viewmissussaga")
	public String seemissussaga(Model model, @RequestParam(defaultValue = "null") String field,
			@RequestParam(defaultValue = "null") String value) {
		ArrayList<Book> list2 = new ArrayList<Book>();
		list2 = da.getBookMissussaga();
		model.addAttribute("m", list2);
		return "viewmissussaga.html";
	}

	@GetMapping("/viewoakville")
	public String seeoakville(Model model, @RequestParam(defaultValue = "null") String field,
			@RequestParam(defaultValue = "null") String value) {

		ArrayList<Book> list1 = new ArrayList<Book>();
		list1 = da.getBookOakville();
		model.addAttribute("o", list1);
		return "viewoakville.html";
	}

	@GetMapping("/addbookbrampton")
	public String viewBrampton() {
		return "brampton.html";
	}

	@GetMapping("/addbookoakville")
	public String viewOakville() {
		return "oakville.html";
	}

	@GetMapping("/addbookmissussaga")
	public String viewMissussaga() {
		return "missussaga.html";
	}

	@GetMapping("/addbrampton")
	public String addBookBrampton(@RequestParam String course_code, @RequestParam String title,
			@RequestParam String author, @RequestParam double price, @RequestParam int bquantity) {

		Book books = new Book(course_code, title, author, price, bquantity);
		da.addBookDavis(books);

		return "brampton.html";
	}

	@GetMapping("/editbramp/{BrampID}")
	public String editLinkBrampton(Model model, @PathVariable int BrampID) {
		Book books = da.getBookByBrampID(BrampID);
		model.addAttribute("b", books);
		return "modifybrampton.html";
	}

	@GetMapping("/modifybrampton")
	public String modifyBookBrampton(@RequestParam int BrampID, @RequestParam String course_code,
			@RequestParam String title, @RequestParam String author, @RequestParam double price,
			@RequestParam int bquantity, Model model) {

		da.setBookByBrampId(BrampID, course_code, title, author, price, bquantity);
		model.addAttribute("b", da.getBookDavis());
		return "redirect:/viewbrampton";

	}

	@GetMapping("/deletebramp/{BrampID}")
	public String DeleteBookBrampton(@PathVariable int BrampID, Model model) {
		da.deleteBookByBrampId(BrampID);
		model.addAttribute("b", da.getBookDavis());
		return "redirect:/viewbrampton";
	}

	@GetMapping("/purchasebramp/{BrampID}/{bquantity}")
	public String purchasebookb(@PathVariable int BrampID, @PathVariable int bquantity, Model model) {
		da.purchaseBookBrampton(BrampID, bquantity - 1);
		model.addAttribute("m", da.getBookByBrampID(BrampID));
		return "redirect:/viewbrampton";
	}

	@GetMapping("/addoakville")
	public String addBookOakville(@RequestParam String course_code, @RequestParam String title,
			@RequestParam String author, @RequestParam double price, @RequestParam int oquantity) {

		Book books = new Book(course_code, title, author, price, oquantity);
		da.addBookOakville(books);

		return "oakville.html";
	}

	@GetMapping("/editoak/{OakID}")
	public String editLinkOakville(Model model, @PathVariable int OakID) {
		Book books = da.getBookByOakID(OakID);
		model.addAttribute("o", books);
		return "modifyoakville.html";
	}

	@GetMapping("/modifyoakville")
	public String modifyBookOakville(@RequestParam int OakID, @RequestParam String course_code,
			@RequestParam String title, @RequestParam String author, @RequestParam double price,
			@RequestParam int oquantity, Model model) {

		da.setBookByOakId(OakID, course_code, title, author, price, oquantity);
		model.addAttribute("o", da.getBookOakville());
		return "redirect:/viewoakville";

	}

	@GetMapping("/deleteoak/{OakID}")
	public String DeleteBookOakville(@PathVariable int OakID, Model model) {
		da.deleteBookByOakId(OakID);
		model.addAttribute("o", da.getBookOakville());
		return "redirect:/viewoakville";
	}

	@GetMapping("/purchaseoak/{OakID}/{oquantity}")
	public String purchasebooko(@PathVariable int OakID, @PathVariable int oquantity, Model model) {
		da.purchaseBookOakville(OakID, oquantity - 1);
		model.addAttribute("m", da.getBookByOakID(OakID));
		return "redirect:/viewoakville";
	}

	@GetMapping("/addmissussaga")
	public String addBookMissussaga(@RequestParam String course_code, @RequestParam String title,
			@RequestParam String author, @RequestParam double price, @RequestParam int mquantity) {

		Book books = new Book(course_code, title, author, price, mquantity);
		da.addBookMissussaga(books);

		return "missussaga.html";
	}

	@GetMapping("/editmiss/{MissID}")
	public String editLinkMissussaga(Model model, @PathVariable int MissID) {
		Book books = da.getBookByMissID(MissID);
		model.addAttribute("m", books);
		return "modifymissussaga.html";
	}

	@GetMapping("/modifymissussaga")
	public String modifyBookMissussaga(@RequestParam int MissID, @RequestParam String course_code,
			@RequestParam String title, @RequestParam String author, @RequestParam double price,
			@RequestParam int mquantity, Model model) {

		da.setBookByMissId(MissID, course_code, title, author, price, mquantity);
		model.addAttribute("m", da.getBookMissussaga());
		return "redirect:/viewmissussaga";

	}

	@GetMapping("/deletemiss/{MissID}")
	public String DeleteBookMissussaga(@PathVariable int MissID, Model model) {
		da.deleteBookByMissId(MissID);
		model.addAttribute("m", da.getBookMissussaga());
		return "redirect:/viewmissussaga";
	}

	@GetMapping("/purchasemiss/{MissID}/{mquantity}")
	public String purchasebookm(@PathVariable int MissID, @PathVariable int mquantity, Model model) {
		da.purchaseBookMissussaga(MissID, mquantity - 1);
		model.addAttribute("m", da.getBookByMissID(MissID));
		return "redirect:/viewmissussaga";
	}
	
@GetMapping("/searchbramptonbook")
public String searchBookBrampton(Model model, @RequestParam(defaultValue = "0") String field, 
		@RequestParam (defaultValue = "0") String value){
	model.addAttribute("b", da.searchBramptonBook( field,value));
	return "viewbrampton.html";
	
	
	
}

@GetMapping("/searchmissussagabook")
public String searchBookMissussaga(Model model, @RequestParam(defaultValue = "0") String field, 
		@RequestParam (defaultValue = "0") String value){
	model.addAttribute("m", da.searchMissussagaBook( field,value));
	return "viewmissussaga.html";	
}

@GetMapping("/searchoakvillebook")
public String searchBookOakville(Model model, @RequestParam(defaultValue = "0") String field, 
		@RequestParam (defaultValue = "0") String value){
	model.addAttribute("o", da.searchOakvilleBook( field,value));
	return "viewoakville.html";
	
	
	
}

}

	


