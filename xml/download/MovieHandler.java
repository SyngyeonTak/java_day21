/*
 * SAX 방식의 파싱을 지원하는 핸들러
 * 
 * */

package lecturer.day1113.xml.download;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MovieHandler extends DefaultHandler{
	ArrayList<Movie> movieList;
	Movie movie;
	
	boolean isTitle;
	boolean isUrl;
	//문서 시작
	public void startDocument() throws SAXException {
	
	}
	
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		if(tag.equals("movies")) {
			movieList = new ArrayList<Movie>();
		}else if(tag.equals("movie")) {
			movie = new Movie();
		}else if(tag.equals("title")) {
			isTitle = true;
		}else if(tag.equals("url")) {
			isUrl = true;
		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch, start, length);//캐릭터 배열을 문장열로 반환
		if(isTitle) {
			movie.setTitle(data);
		}else if(isUrl) {
			movie.setUrl(data);
		}
		
	}
	
	public void endElement(String uri, String localName, String tag) throws SAXException {
		if(tag.equals("title")) {
			isTitle = false;
		}else if(tag.equals("url")) {
			isUrl = false;
		}else if(tag.equals("movie")) {
			movieList.add(movie);
		}
	}
	
	public void endDocument() throws SAXException {
		for (Movie movie : movieList) {
			System.out.println(movie.getTitle());
			System.out.println(movie.getUrl());
			System.out.println("------------------------------------------------");
		}
	}
}























