package com.words;

import java.io.Serializable;
import java.util.List;

public class WordRow implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5289559607290299910L;
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
