package com.translator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.words.Word;

public class CantoneseTranslator {

	public static void main(String[] args) throws SQLException, IOException {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Give me some Canto characters to translate, please:");
		
		String canto = in.next();
		
		in.close();
		
		TranslatorSQL translator = new TranslatorSQL();
		
		List<Word> translatedCharacters = translator.translateWords(canto);
		
		for(Word tC : translatedCharacters){
			System.out.println("Cantonese: "+tC.getCantonese()+" Juytping: "+tC.getJping()+" English: "+tC.getEnglish());
		}

	}

}
