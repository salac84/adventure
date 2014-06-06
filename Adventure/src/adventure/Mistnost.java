package adventure;

import java.util.Set;
import java.util.HashSet;

class Mistnost { 
    private String nazev; 
    private String popis; 
    private Set<Mistnost> vychody; // obsahuje sousední místnosti 
   
    public Mistnost(String nazev, String popis) { 
        this.nazev = nazev; 
        this.popis = popis; 
        vychody = new HashSet<Mistnost>(); 
    }

    public void setVychod(Mistnost vedlejsi) { 
       vychody.add(vedlejsi);
    }

    public boolean equals (Object o) { 
        if (o instanceof Mistnost) { 
            Mistnost druha = (Mistnost)o; 
            return nazev.equals(druha.nazev); 
        }  
        else {  
             return false;
        } 
    }  
    
    public int hashCode() { 
        return nazev.hashCode();
    }
    
    public String getNazev() { 
        return nazev;
    }
    
    public String dlouhyPopis() { 
        return "Jsi v mistnosti/prostoru " + popis + ".\n" + seznamVychodu(); 
    }
    
    private String seznamVychodu() { 
        String vracenyText = "vychody:"; 
        for (Mistnost sousedni : vychody) { 
            vracenyText += " " + sousedni.getNazev(); 
        }     
        return vracenyText; 
    }
    
    public Mistnost sousedniMistnost(String jmenoSousedni) { 
        if (jmenoSousedni == null) { 
            return null; 
        } 
        for ( Mistnost sousedni :vychody ){ 
            if (sousedni.getNazev().equals(jmenoSousedni)) { 
                return sousedni; 
            } 
        } 
        return null; // místnost nenalezena 
    } 
}
