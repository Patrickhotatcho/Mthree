package com.mthree.DVDLib.Service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mthree.DVDLib.DVD.DVD;
import com.mthree.DVDLib.Dao.IDao;

@Service
public class DVDService {
	@Autowired
	@Qualifier(value="inmemory")
	//@Qualifier(value="jparepos")
	IDao dao;
	//private ResourceLoader resourceLoader;
	//private ClassLoader classLoader;
	private FileOutputStream fos;
	private BufferedOutputStream bos;
	private ObjectOutputStream oos;
	
	private FileInputStream fis;
	private BufferedInputStream bis;
	private ObjectInputStream ois;
	
	
	public List<DVD> findAll(){
		System.out.println("Inside findAll() of Service");
		return dao.findAll();
	}
	
	public DVD addDVD(DVD dvd) {
		
		System.out.println("Inside addDVD() of Service");
		DVD d = dao.save(dvd);
		return d;
	}
	
	public DVD deleteById(int id) {
		System.out.println("Inside deleteById() of Service");
		DVD d = dao.deleteById(id);
		return d;
	}
	
	public DVD findById(int id) {
		System.out.println("Inside findById() of Dao");
		DVD d = dao.findById(id);
		return d;
	}
	
	public DVD editById(int id,String title, Date releaseDate, double mPAArating, String director, String studio) {
		System.out.println("Inside editById() of Dao");
		DVD d = dao.findById(id);
		d.setTitle(title);
		d.setReleaseDate(releaseDate);
		d.setMPAArating(mPAArating);
		d.setDirector(director);
		d.setStudio(studio);
		dao.save(d);
		return d;
	}
	
	
	
	public List<DVD> findByTitle(String title) {
		System.out.println("Inside findByTitle() of Service");
		List<DVD> dList = dao.findByTitle(title);
		
		return dList;
	}
	
	public void saveAllToFile() {
		System.out.println("Inside saveAllToFile() of Service");
		File file = new File("C:\\MyJava\\workspace\\DVDLib\\src\\main\\resources\\data.ser");
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(dao.findAll());
			 
			
		}  catch (FileNotFoundException e) {
			System.out.println("File is not FOUND");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
				bos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	
	}

	public void loadAllToFile() {
		
		File file = new File("C:\\MyJava\\workspace\\DVDLib\\src\\main\\resources\\data.ser");
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			List<DVD> obj = (List<DVD>)ois.readObject();
			for(DVD dvd: obj) {
				dao.save(dvd);
			}
			 
		}  catch (FileNotFoundException e) {
			System.out.println("File is not FOUND");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				oos.close();
				bos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
