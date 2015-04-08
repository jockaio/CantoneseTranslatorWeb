package com.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.translator.TranslatorSQL;
import com.words.Word;
import com.words.WordRow;

@ManagedBean
@ViewScoped
public class TranslationBean {
	
	private List<WordRow> translatedRows = new ArrayList<WordRow>();
	private String userInput;
	private Word selectedWord;
	private WordRow selectedRow;
	private TranslatorSQL t = new TranslatorSQL();
	
	public void translateWordsInterface(ActionEvent event){
		
		translatedRows = t.getWordRows(userInput);
		
		System.out.println(translatedRows);
	}
	
	public List<WordRow> getTranslatedRows(){
		return translatedRows;
	}
	
	public void updateWord(ActionEvent event) throws SQLException{
	
		System.out.println("Juytping = "+selectedWord.getJping());
		System.out.println("Tone of this word is "+selectedWord.getTone());
		
		System.out.println("Trying to update word:"+selectedWord.getCantonese());
		
		t.updateWord(selectedWord);
		
		selectedRow.setCantoWords(t.translateWords(selectedRow.getWordString()));

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
		System.out.println("Selected word: "+this.selectedWord.getCantonese()+" "+this.selectedWord.getJping());
	}

	public WordRow getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(WordRow selectedRow) {
		this.selectedRow = selectedRow;
	}

}
