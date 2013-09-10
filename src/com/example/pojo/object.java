package com.example.pojo;


public class object {

	
	private String status; 
	private stats stats;
	private links links; 
	private String title; 
	private String trailer_link; 
	private String summary; 
	private images images; 
	private String id;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public stats getStats() {
		return stats;
	}
	public void setStats(stats stats) {
		this.stats = stats;
	}
	public links getLinks() {
		return links;
	}
	public void setLinks(links links) {
		this.links = links;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTrailer_link() {
		return trailer_link;
	}
	public void setTrailer_link(String trailer_link) {
		this.trailer_link = trailer_link;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public images getImages() {
		return images;
	}
	public void setImages(images images) {
		this.images = images;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

	
	/*
		   "object":{
		      "status":"continuing",
		      "stats":{
		         "reviews":1400,
		         "checkins":1163426,
		         "dislikes":5772,
		         "likes":396082,
		         "flagged":false
		      },
		      "links":{
		         "hulu":"http://www.hulu.com/the-ellen-show",
		         "amazon":"http://www.amazon.com/Pilot/dp/B001S2AICE%3FSubscriptionId%3D07GG2103RY5KFCY09GG2%26tag%3Dhttp://getglue.com%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB001S2AICE",
		         "trailer":"http://www.youtube.com/v/D74GhWMiClY?version=3&f=videos&app=youtube_gdata"
		      },
		      "title":"The Ellen DeGeneres Show",
		      "trailer_link":"http://www.youtube.com/v/D74GhWMiClY?version=3&f=videos&app=youtube_gdata",
		      "summary":"A talk/variety show features Ellen in the studio speaking with celebrity guests, newsmakers and ordinary people with extraordinary talents.  Additionally, segments include performances from top music acts, and audience and man-on-the-street interviews.",
		      "images":{
		         "cast":"http://gg-showcard-img.s3.amazonaws.com/tv_shows/ellen_degeneres_show_300x223.jpg",
		         "wide":"http://gg-showcard-img.s3.amazonaws.com/h3/AllPhotos/185048/p185048_b_h3_aa.jpg",
		         "square":"http://img.getglue.com/tv_shows/ellen_degeneres_show/small_tile.jpg",
		         "iphone":"http://gg-showcard-img.s3.amazonaws.com/h5/AllPhotos/185048/p185048_b_h5_aa.jpg",
		         "cast_retina":"http://gg-showcard-img.s3.amazonaws.com/tv_shows/ellen_degeneres_show_600x446.jpg",
		         "normal":"http://img.getglue.com/tv_shows/ellen_degeneres_show/normal.jpg",
		         "extra_large":"http://img.getglue.com/tv_shows/ellen_degeneres_show/xlarge.jpg",
		         "banner":"http://s3.amazonaws.com/gg-tv-img/banners/series/72194/Ellen.jpg",
		         "thumbnail":"http://img.getglue.com/tv_shows/ellen_degeneres_show/small.jpg",
		         "header_small":"http://s3.amazonaws.com/gg-tv-img/banners/series/72194/Ellen_323x60.jpg"
		      },
		      "id":"tv_shows/ellen_degeneres_show"
		   }
		*/
}
