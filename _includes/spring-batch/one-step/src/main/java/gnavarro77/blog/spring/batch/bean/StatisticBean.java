package gnavarro77.blog.spring.batch.bean;

public class StatisticBean {
	// player's name
	private String player;
	// season
	private String season;
	// average points per game
	private float appg;

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public float getAppg() {
		return appg;
	}

	public void setAppg(float appg) {
		this.appg = appg;
	}

}
