package turvaselain;

import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;

public class Nakyma extends JFrame{
    private Ohjain ohjain;         //Swing-komponentit
    
     JPanel sisaltopaneeli;
     JTextField alakentta;
     JTextField ylakentta;
     JTextArea sivukentta;
     JScrollPane tekstikentta;
    
    public Nakyma() {
        setTitle("Turva selain [ON ULTRASECURE MODE]");	                           //Käyttöliittymän rakennus ja käynnistäminen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        sisaltopaneeli=new JPanel();
        BorderLayout borderlayout = new BorderLayout();
        sisaltopaneeli.setLayout(borderlayout);
        alakentta = new JTextField("");
        ylakentta = new JTextField("");
        sivukentta = new JTextArea("",60,200);
        sivukentta.setLineWrap(true);
        tekstikentta = new JScrollPane(sivukentta);
                
        sisaltopaneeli.add(ylakentta, BorderLayout.NORTH);
        sisaltopaneeli.add(tekstikentta, BorderLayout.CENTER);
        sisaltopaneeli.add(alakentta, BorderLayout.SOUTH);
        getContentPane().add(sisaltopaneeli, BorderLayout.CENTER);
        setSize(180,80);
        setVisible(true);
        
        alakentta.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		ohjain.suoritaHaku();
        	}
        }); 
        
    }
             //Metodit syötteen hakemiseksi ja päivittämiseksi sekä Swing tapahtumien käsittelemiseksi              
    public void rekisteroiOhjain(Ohjain ohjain) {
    	this.ohjain=ohjain;
    }
    public void setYlakentta (String str) {
        ylakentta.setText(str);
    }
    public void setSivukentta(String str) {   
        sivukentta.setText(str);
    }
    public void setAlakentta (String str) {
    	alakentta.setText(str);
    }
    public String getAlakentta () {
    	return alakentta.getText();
    }
       
}
