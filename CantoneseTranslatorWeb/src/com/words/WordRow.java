package com.words;

import java.util.List;

public class WordRow {
	
	private List<Word> cantoWords = null;
	private String englishTranslation = null; 
	private String wordString;
	
	public WordRow(String words, List<Word> cantoWords){
		this.wordString = words;
		this.cantoWords = cantoWords;
	}

	public List<Word> getCantoWords() {
		return cantoWords;
	}

	public void setCantoWords(List<Word> cantoWords) {
		this.cantoWords = cantoWords;
	}

	public String getEnglishTranslation() {
		return englishTranslation;
	}

	public void setEnglishTranslation(String englishTranslation) {
		this.englishTranslation = englishTranslation;
	}

	public String getWordString() {
		return wordString;
	}

	public void setWordString(String wordString) {
		this.wordString = wordString;
	}

}
