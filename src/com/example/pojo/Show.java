package com.example.pojo;

import android.graphics.Bitmap;


public class Show {
	private String id; 
	private String title; 
	private Bitmap thumb; 
	private images images; 
	
	private trending trending;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public images getImages() {
		return images;
	}

	public void setImages(images images) {
		this.images = images;
	}

	public trending getTrending() {
		return trending;
	}

	public void setTrending(trending trending) {
		this.trending = trending;
	}

	public Bitmap getThumb() {
		return thumb;
	}

	public void setThumb(Bitmap thumb) {
		this.thumb = thumb;
	} 
	
	/*
	 {
		    "images": {
		      "cast": "http://gg-showcard-img.s3.amazonaws.com/tv_shows/ellen_degeneres_show_300x223.jpg",
		      "wide": "http://gg-showcard-img.s3.amazonaws.com/h3/AllPhotos/185048/p185048_b_h3_aa.jpg",
		      "square": "http://img.getglue.com/tv_shows/ellen_degeneres_show/small_tile.jpg",
		      "iphone": "http://gg-showcard-img.s3.amazonaws.com/h5/AllPhotos/185048/p185048_b_h5_aa.jpg",
		      "cast_retina": "http://gg-showcard-img.s3.amazonaws.com/tv_shows/ellen_degeneres_show_600x446.jpg",
		      "normal": "http://img.getglue.com/tv_shows/ellen_degeneres_show/normal.jpg",
		      "extra_large": "http://img.getglue.com/tv_shows/ellen_degeneres_show/xlarge.jpg",
		      "banner": "http://s3.amazonaws.com/gg-tv-img/banners/series/72194/Ellen.jpg",
		      "thumbnail": "http://img.getglue.com/tv_shows/ellen_degeneres_show/small.jpg",
		      "header_small": "http://s3.amazonaws.com/gg-tv-img/banners/series/72194/Ellen_323x60.jpg"
		    },
		    "trending": {
		      "total": 956.0,
		      "rank": 1
		    },
		    "id": "tv_shows/ellen_degeneres_show",
		    "title": "The Ellen DeGeneres Show"
		  },
*/
}
