package com.beans;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.translator.TranslatorSQL;
import com.words.Word;

@ManagedBean
@ViewScoped
public class GameBean {
	private List<Word> quizWords;
	private List<String> answers;
	private Word selectedWord; 
	private String answer;
	private int score;
	private int length;
	private TranslatorSQL t = null;
	
	public List<Word> getQuizWords() {
		return quizWords;
	}
	public void setQuizWords(List<Word> quizWords) {
		this.quizWords = quizWords;
	}
	public Word getSelectedWord() {
		return selectedWord;
	}
	public void setSelectedWord(Word selectedWord) {
		this.selectedWord = selectedWord;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void startGame(ActionEvent e) throws SQLException{
		if(t == null){
			t = new TranslatorSQL();
		}
		
		System.out.println("Getting "+length+" words.");
		quizWords = t.getRandomWords(length);
		for(Word word: quizWords){
			System.out.println(word.getCantonese());
		}
		selectedWord = quizWords.get(0);
		System.out.println("SelectedWord: "+selectedWord.getCantonese());
	}
	public void nextWord(ActionEvent e){
		int currentIndex = quizWords.indexOf(selectedWord);
		if(currentIndex < quizWords.size()-1){
			selectedWord = quizWords.get(currentIndex+1);
		}
	}
}
