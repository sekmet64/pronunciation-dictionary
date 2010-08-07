package org.dikso.server;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class DictionaryEntry {
	@Persistent
	private String englishWord;
	
	@Persistent 
	private String hungarianPronunciation;

	public DictionaryEntry(String englishWord, String hungarianPronunciation) {
		this.englishWord = englishWord;
		this.hungarianPronunciation = hungarianPronunciation;
	}

	public String getEnglishWord() {
		return englishWord;
	}

	public void setEnglishWord(String englishWord) {
		this.englishWord = englishWord;
	}

	public String getHungarianPronunciation() {
		return hungarianPronunciation;
	}

	public void setHungarianPronunciation(String hungarianPronunciation) {
		this.hungarianPronunciation = hungarianPronunciation;
	}
}
