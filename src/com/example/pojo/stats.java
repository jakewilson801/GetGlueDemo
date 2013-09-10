package com.example.pojo;

public class stats {
	
	
	private int reviews; 
	private int checkins;
	private int dislikes;
	private int likes; 
	private boolean flagged; 

	public int getReviews() {
		return reviews;
	}
	public void setReviews(int reviews) {
		this.reviews = reviews;
	}
	public int getCheckins() {
		return checkins;
	}
	public void setCheckins(int checkins) {
		this.checkins = checkins;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public boolean isFlagged() {
		return flagged;
	}
	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}
}
