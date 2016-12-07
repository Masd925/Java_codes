package turvaselain;  // Swing/awt tekniikoilla tehty turvallinen Internet selain joka näyttää vain tekstisisällön

public class Ohjain {
    private Malli malli;
    private Nakyma nakyma;
    
    public Ohjain (Malli malli, Nakyma nakyma) {
    	this.malli=malli;
    	this.nakyma=nakyma;
    }
    
    public static void main (String[]args) {
    	Malli malli = new Malli();
    	Nakyma nakyma = new Nakyma();
    	Ohjain ohjain = new Ohjain(malli,nakyma);
    	nakyma.rekisteroiOhjain(ohjain);
    	ohjain.paivitaKentat();
    }
    
                              //Metodit käyttöliittymän tapahtumiin reagoimiseksi ja mallin päivittämiseksi
    public void suoritaHaku() {
    	String alateksti=nakyma.getAlakentta();
    	if (alateksti.trim().length()<1) {
    		malli.asetaPerusUrl();
    		paivitaAlakentta();
    		}
    	else {
    		malli.setAlateksti(alateksti);
    		malli.haeSivu();
    		malli.setAlateksti("");
    		malli.vaihdaHamaysUrl();
    	    paivitaKentat();	
    	}  
    	
    }
    
    private void paivitaKentat () {
    	paivitaYlakentta();
    	paivitaSivukentta();
    	paivitaAlakentta();
    }
    private void paivitaYlakentta () {
    	nakyma.setYlakentta(malli.getYlateksti());
    }
    private void paivitaSivukentta () {
    	nakyma.setSivukentta(malli.getSivuteksti());
    }
    private void paivitaAlakentta () {
    	nakyma.setAlakentta(malli.getAlateksti());
    }
    
    
}
