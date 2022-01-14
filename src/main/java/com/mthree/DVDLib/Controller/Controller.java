package com.mthree.DVDLib.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.DVDLib.DVD.DVD;
import com.mthree.DVDLib.Service.DVDService;

@RestController
public class Controller {
	
	@Autowired
	private DVDService service;
	
	@GetMapping(path="/dvds")
	public List<DVD> retrieveAllDVD(){
		System.out.println("Inside retrieveAllDVD() of class Controller");
		return service.findAll();
	}
	@GetMapping(path="/dvds/id/{id}")
	public DVD retrieveDVD(@PathVariable("id") int id){
		System.out.println("Inside retrieveAllDVD() of class Controller");
		return service.findById(id);
	}
	@GetMapping(path="/dvds/title/{title}")
	public List<DVD> retrieveDVDByTitle(@PathVariable("title") String title){
		System.out.println("Inside retrieveDVDByTitle() of class Controller");
		return service.findByTitle(title);
	}
	@GetMapping(path="/dvds/save")
	public List<DVD> saveAllToFile(){
		System.out.println("Inside saveAllToFile() of class Controller");
		service.saveAllToFile();
		return service.findAll();
	}
	@GetMapping(path="/dvds/load")
	public List<DVD> loadAllToFile(){
		System.out.println("Inside loadAllToFile() of class Controller");
		service.loadAllToFile();
		return service.findAll();
	}
	
	@PostMapping(path="/dvds")
	public void createDVD(@RequestBody DVD dvd) {
		System.out.println("Iside createDVD() of class Controller");
		service.addDVD(dvd);
	}
	@PostMapping(path="/dvds/edit")
	public void editDVD(@RequestBody DVD dvd) {
		System.out.println("Iside editDVD() of class Controller");
		service.editById(dvd.getId(),dvd.getTitle(),dvd.getReleaseDate(),dvd.getMPAArating(),dvd.getDirector(),dvd.getStudio());
	}
	@DeleteMapping(path="/dvds/delete/{id}")
	public void deleteDVD(@PathVariable int id) {
		System.out.println("Iside deleteDVD() of class Controller");
		service.deleteById(id);
	}
	
	
	

}
