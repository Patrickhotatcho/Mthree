package com.mthree.DVDLib.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mthree.DVDLib.DVD.DVD;

@Repository(value="inmemory")
public class Dao implements IDao {
	private static List<DVD> dvds = new ArrayList(); 
	private int dvdCount = 3; 
	static {
		dvds.add(new DVD(1,"Comedy",new Date(),4.5,"Patrick","Maverl"));
		dvds.add(new DVD(2,"Comedy1",new Date(),4.5,"Patrick","Maverl"));
		dvds.add(new DVD(3,"Comedy2",new Date(),4.5,"Patrick","Maverl"));
	}
	
	public static void updateId() {
		int i=1;
		for(DVD d: dvds) {
			d.setId(i);
			i++;
		}
	}

	public List<DVD> findAll(){
		System.out.println("Inside findAll() of Dao");
		return dvds;
	}
	
	public DVD save(DVD dvd) {
		
		System.out.println("Inside addDVD() of Dao");
		dvds.add(dvd);
		updateId();
		return dvd;
	}
	
	public DVD deleteById(int id) {
		System.out.println("Inside deleteById() of Dao");
		DVD dvd = findById(id);
		if(dvd!=null) {
			dvds.remove(dvd);
			updateId();
			return dvd;
		}
		return null;
	}
	
	public DVD findById(int id) {
		System.out.println("Inside findById() of Dao");
		Iterator<DVD> itr = dvds.iterator();
		while(itr.hasNext()) {
			DVD dvd = itr.next();
			if(dvd.getId() == id) {
				dvds.remove(dvd);
				return dvd;
			}
			
		}
		return null;
	}
	
	
	public List<DVD> findByTitle(String title) {
		System.out.println("Inside findByTitle() of Dao");
		List<DVD> dvdList = new ArrayList(); 
		Iterator<DVD> itr = dvds.iterator();
		while(itr.hasNext()) {
			DVD dvd = itr.next();
			if(dvd.getTitle().equals(title)) {
				dvdList.add(dvd);
			}
			
		}
		return dvdList;
	}
	
}
