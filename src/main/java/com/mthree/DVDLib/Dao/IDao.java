package com.mthree.DVDLib.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.mthree.DVDLib.DVD.DVD;

public interface IDao {
	public List<DVD> findAll();
	public DVD save(DVD dvd);
	public DVD deleteById(int id);
	public DVD findById(int id);
	//public DVD editById(Integer id,String title, Date releaseDate, double mPAArating, String director, String studio);
	public List<DVD> findByTitle(String title);
}
