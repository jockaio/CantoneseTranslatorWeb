package com.translator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.database.Database;
import com.words.Word;
import com.words.WordRow;

public class TranslatorSQL {
	
	Database db = new Database();
	Connection con = db.getConnection();
	PreparedStatement ps = null; 
	
	public TranslatorSQL(){
		
	}
	
	public List<WordRow> getWordRows(String cantoString) throws SQLException{
		List<WordRow> wordRows = new ArrayList<WordRow>();
		List<String> stringRows = Arrays.asList(cantoString.split("\n"));
		for(String row : stringRows){
			WordRow wr = new WordRow(row, translateWords(row));
			wordRows.add(wr);
		}
		
		return wordRows;
	}
	
	public List<Word> translateWords(String cantoString) throws SQLException{
		
		String regEx = "([\\da-öA-Ö+-])";
		cantoString = cantoString.trim();
		cantoString = cantoString.replaceAll(regEx, "");
		List<String> characters = Arrays.asList(cantoString.split(""));
		List<Word> words = new ArrayList<Word>();
		
		System.out.println("Translating this: "+characters);
		
		for(String character : characters){
			ps = con.prepareStatement("SELECT * FROM CANTO.TRANS_WORDS WHERE cantonese = ?");
			if(!character.equalsIgnoreCase("")){
				ps.setString(1, character);
				ResultSet result = db.runViewQuery(ps);	
				if(!result.isBeforeFirst()){
					Word word = new Word(character);
					insertWord(word);
					words.add(word);
				}else{
					while(result.next()){
						System.out.println(result.getString(2)+" "+ result.getString(3)+result.getInt(5) +" "+ result.getString(4));
						Word word = new Word(result.getString(2), result.getString(3)+result.getInt(5), result.getString(4));
						words.add(word);
					}
				}
			}
			ps.close();
		}
		
		return words;
	}
	
	public void insertWord(Word word) throws SQLException{
		
		ps = con.prepareStatement("INSERT INTO CANTO.TRANS_WORDS (cantonese, jyutping, english, tone) "
				+ "VALUES(?,?,?,?)");
		
		ps.setString(1, word.getCantonese());
		ps.setString(2, word.getJpingNoTone());
		ps.setString(3, word.getEnglish());
		ps.setInt(4, word.getTone());
		
		db.runInsertQuery(ps);
		ps.close();
	}
	
	public List<Word> getAllWords() throws SQLException{
		
		List<Word> words = new ArrayList<Word>();
		
		ps = con.prepareStatement("SELECT * FROM CANTO.TRANS_WORDS");
				
		ResultSet result = db.runViewQuery(ps);	
		while(result.next()){
			Word word = new Word(result.getString(2), result.getString(3)+result.getInt(5), result.getString(4));
			words.add(word);
		}
		
		System.out.println(words);
		ps.close();
		return words;
	}
	
	public void updateWord(Word word) throws SQLException{
		
		ps = con.prepareStatement("UPDATE CANTO.TRANS_WORDS SET jyutping= ? ,english= ?, tone= ?"
				+ " WHERE cantonese=?");
		
		ps.setString(1, word.getJpingNoTone());
		ps.setString(2, word.getEnglish());
		ps.setInt(3, word.getTone());
		ps.setString(4, word.getCantonese());
		
		db.runInsertQuery(ps);
		ps.close();
	}
	
}
