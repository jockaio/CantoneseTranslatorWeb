package com.words;

import java.sql.SQLException;
import java.util.List;

import com.translator.TranslatorSQL;

public class WordRow {
	
	private List<Word> cantoWords = null;
	private String englishTranslation = null;
	private TranslatorSQL t = new TranslatorSQL(); 
	private String wordString;
	
	public WordRow(String words){
		wordString = words;
		try {
			this.setCantoWords(t.translateWords(words));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
