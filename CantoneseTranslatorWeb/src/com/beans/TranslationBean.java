package com.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.translator.TranslatorSQL;
import com.words.Word;

@ManagedBean
@ViewScoped
public class TranslationBean {
	
	private List<Word> translatedWords = new ArrayList<Word>();
	private String userInput;
	private Word selectedWord;
	private TranslatorSQL t = new TranslatorSQL();

	public List<Word> getTranslatedWords() {
		return translatedWords;
	}

	public void setTranslatedWords(List<Word> translatedWords) {
		this.translatedWords = translatedWords;
	}
	
	public void translateWordsInterface(ActionEvent event){
		
		try {
			translatedWords = t.translateWords(userInput);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(translatedWords);
	}
	
	public void updateWord(ActionEvent event) throws SQLException{
		
		String jping = selectedWord.getJpingNoTone();
		selectedWord.setJping(jping.substring(0, jping.length()-1));
		System.out.println("Juytping = "+jping);
		int tone = Integer.parseInt(jping.substring(jping.length()-1, jping.length()));
		System.out.println("Tone of this word is "+tone);
		selectedWord.setTone(tone);
		
		System.out.println("Trying to update word:"+selectedWord.getCantonese());
		
		t.updateWord(selectedWord);
		
		t.translateWords(userInput);

	}

	public String getUserInput() {
		return userInput;
	}

	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}

	public Word getSelectedWord() {
		return selectedWord;
	}

	public void setSelectedWord(Word selectedWord) {
		this.selectedWord = selectedWord;
		System.out.println("Selected word: "+this.selectedWord.getCantonese());
	}

}
