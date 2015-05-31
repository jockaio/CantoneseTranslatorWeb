package com.translator;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.words.Word;

public class RwHTML {
	
	public static Word scrapeWordDetails(Word word) throws IOException{
		
		String character = word.getCantonese();
		
		String url = "http://www.mdbg.net/chindict/chindict.php?page=chardict&cdcanoce=0&cdqchi="+character;
		
		Document doc = Jsoup.connect(url).get();
		System.out.println("Fetching: "+url);
		
		Elements pinyin = doc.getElementsByClass("pinyin");
		Elements english = doc.getElementsByClass("defs");
		
		if(!pinyin.isEmpty()){
			String jyutping = pinyin.get(1).text();
			System.out.println("Jyutping fetched: "+jyutping);
			word.setJping(jyutping);
		}
		
		if(!english.isEmpty()){
			String eng = english.get(0).text();
			System.out.println("English fetched: "+eng);
			word.setEnglish(eng);
		}
		
		return word;
		
	}
	
}
