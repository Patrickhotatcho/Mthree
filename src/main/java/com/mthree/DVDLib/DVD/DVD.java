package com.mthree.DVDLib.DVD;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="dvd")
public class DVD implements Serializable{
	@Id
	private Integer id;
	@Column(name="title")
	private String title;
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date releaseDate;
	@Column(name="MPAA_rating")
	private double MPAArating;
	@Column(name="director")
	private String director;
	@Column(name="studio")
	private String studio;
	@Column(name="comment")
	private String comment;
	
	public DVD() {};
	public DVD(String title, Date releaseDate, double mPAArating, String director, String studio) {
		super();
		this.title = title;
		this.releaseDate = releaseDate;
		MPAArating = mPAArating;
		this.director = director;
		this.studio = studio;
	}
	public DVD(Integer id, String title, Date releaseDate, double mPAArating, String director, String studio) {
		super();
		this.id = id;
		this.title = title;
		this.releaseDate = releaseDate;
		MPAArating = mPAArating;
		this.director = director;
		this.studio = studio;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public double getMPAArating() {
		return MPAArating;
	}
	public void setMPAArating(double mPAArating) {
		MPAArating = mPAArating;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "DVD [title=" + title + ", releaseDate=" + releaseDate + ", MPAArating=" + MPAArating + ", director="
				+ director + ", studio=" + studio + ", comment=" + comment + "]";
	}
	
	
}
