package com.translator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database.Database;
import com.words.Word;

public class Test {
	
	public List<Word> findThisInDatabase(String where) throws SQLException{
		ResultSet result = null;
		List<Word> words = new ArrayList<Word>();
		Database db = new Database();
	
		Word word = null;
		
		
		try {
			if(!result.isBeforeFirst()){
				System.out.println("No data");
			}else{
				
				while(result.next()){
					System.out.println(result.getString(1)+ result.getString(2)+ result.getString(3));
					try {
						word = new Word(result.getString(1), result.getString(2), result.getString(3));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println(word.getCantonese()+word.getEnglish());
				
				return words;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
