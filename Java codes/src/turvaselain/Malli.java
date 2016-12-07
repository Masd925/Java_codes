package turvaselain;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class Malli {
                       //data
	private String ylateksti;
	private String sivuteksti;
	private String alateksti;
	private int laskuri;
	
	private static String PERUSURL = "http://";
	private static String [] HAMAYS_URL = {"http://www.pirkka.fi","http://www.nykyposti.fi","http://www.suomi24.fi"};
	
	public Malli() {
		laskuri= (int)(Math.random() * HAMAYS_URL.length);
        ylateksti = HAMAYS_URL[laskuri];
        sivuteksti="Klikkaa alapalkkia, paina Enter ja aloita turvallinen Internet selaus.";
        alateksti="";
        
	}
		                   //metodit datan muokkaukseen
	public void asetaPerusUrl () {
		alateksti = PERUSURL;
	}
	public void vaihdaHamaysUrl () {
		if (laskuri == HAMAYS_URL.length-1) laskuri=0;
		else laskuri++;
		ylateksti = HAMAYS_URL[laskuri];
	}
	public void haeSivu() {
		String tulos=null;
		try {
    	    StringBuilder teksti = new StringBuilder("");
			URL sivu=new URL(alateksti);
    	    InputStream in = sivu.openStream();
    	    Reader reader = new InputStreamReader(in,"UTF-8");
    	    BufferedReader br = new BufferedReader(reader);
    	    String rivi;
    	    while ((rivi=br.readLine())!=null) teksti.append(rivi);
    	    tulos=teksti.toString();
    	    br.close();
    	}catch (Exception e) {
    		e.printStackTrace();
    		sivuteksti="Sivua ei löydy";
    	}
		if (tulos!=null) {
		    tulos=poistaTyhjat(tulos);
		    tulos=poistavastakkaiset(tulos, '<', '>');
		    tulos=poistavastakkaiset(tulos, '{', '}');
		    tulos=poistaTyhjat(tulos);
		    sivuteksti= tulos;
		}
		
	}
	
	private String poistaTyhjat(String str) {
	    StringBuilder tulos = new StringBuilder();
	    boolean space = false;
	    for (int i = 0; i<str.length(); i++) {
	      if (!space && str.charAt(i)==' ') {
	        tulos.append(' ');
	        space = true;
	      } else if (str.charAt(i) != ' ') {
	        tulos.append(str.charAt(i));
	        space = false;
	      }
	    }
	    return tulos.toString();
	  }
	
	public String poistavastakkaiset (String str, char vas, char oik) {
		boolean loytyi=true;
		String tulos=null;
		while (loytyi) {
			loytyi=false;
			tulos=poistaVastakkainen(str, vas, oik);
			if (!tulos.equals(str)) {
				loytyi=true;
				str=tulos;
			}
		}
		return str;
	}
	
	public String poistaVastakkainen (String str, char vas, char oik) {
		boolean resultFound=false;
		int pointer=0, first, second;
		boolean pairFound=true;
		while (pairFound==true && resultFound==false && pointer<(str.length()-1)) {
			pairFound=false;
			first=str.indexOf(vas,pointer);
			if (first!=-1 && first<str.length()-1) second=findFirst(str, first+1, vas, oik);
			else second=-1;
			System.out.println("first: "+first+" second: "+second);
			if (first!=-1 && second!=-1) {
				pairFound=true;
				pointer=second;
				if (str.charAt(second)==oik){
					resultFound=true;
					System.out.println("Poistettavaa löytyi: "+str.substring(first, second+1));
					str = str.substring(0, first)+str.substring(second+1);
				}
			}
		}
		return str;
	}
	
	public int findFirst (String str, int start, char firstChar, char secondChar) {
		int first = str.indexOf(firstChar, start);
		int second = str.indexOf(secondChar, start);
		int result=-1;
		if (first!=-1) {
			result=first;
		    if (second!=-1 && second<first) result=second;	
		}else {
			if (second!=-1) result=second;
		}
		return result;
	}
	
	public String getYlateksti() {
		return ylateksti;
	}

	public void setYlateksti(String ylateksti) {
		this.ylateksti = ylateksti;
	}

	public String getSivuteksti() {
		return sivuteksti;
	}

	public void setSivuteksti(String sivuteksti) {
		this.sivuteksti = sivuteksti;
	}

	public String getAlateksti() {
		return alateksti;
	}

	public void setAlateksti(String alateksti) {
		this.alateksti = alateksti;
	}
	
}
