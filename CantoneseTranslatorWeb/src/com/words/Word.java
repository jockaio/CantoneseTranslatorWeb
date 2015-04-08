package com.words;

public class Word {
	
	private String cantonese;
	private String jping;
	private String english;
	private int tone;
	
	public Word(String cantonese, String jping, String english){
		this.setCantonese(cantonese);
		this.setJping(jping);
		this.setEnglish(english);
	}
	
	public Word(String cantonese){
		this.cantonese = cantonese;
	}

	public String getCantonese() {
		return cantonese;
	}

	public void setCantonese(String cantonese) {
		this.cantonese = cantonese;
	}
	
	public String getJpingNoTone(){
		return jping;
	}

	public String getJping() {
		return jping+tone;
	}

	public void setJping(String jping) {	
		this.jping = jping.substring(0, jping.length() -1);
		this.setTone(Integer.parseInt(jping.substring(jping.length()-1, jping.length())));
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public int getTone() {
		return tone;
	}

	public void setTone(int tone) {
		this.tone = tone;
	}

}
