package adventure;

import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.IOException;

public class RizeniHry {
    private Hra hra;
    
    public RizeniHry() { 
        hra = new Hra(); 
    }
    
    public void hraj() { 
        System.out.println(hra.vratUvitani()); 
        // základní cyklus programu - opakovaněse čtou příkazy 
        // a poté se provádějí do konce hry. 
        while (!hra.konecHry()) { 
            String radek = prectiString(); 
            Prikaz prikaz = new Prikaz(radek); 
            System.out.println(hra.zpracujPrikaz(prikaz)); 
        } 
        System.out.println(hra.vratEpilog()); 
    }
    
    private String prectiString() { 
        String vstupniRadek="";  
        System.out.print("> "); // vypíše se prompt 
        BufferedReader vstup = new BufferedReader(new InputStreamReader(System.in)); 
        try {  
            vstupniRadek = vstup.readLine(); 
        }  
        catch (java.io.IOException exc) { 
            System.out.println("Vyskytla se chyba během čtení příkazu:" + exc.getMessage()); 
        }  
        return vstupniRadek;  
    } 
}
