package adventure;

import java.util.Set; 
import java.util.TreeSet;

public class SeznamPrikazu {
    private Set<String> platnePrikazy;
    
    public SeznamPrikazu() { 
        platnePrikazy = new TreeSet<String>(); 
        platnePrikazy.add("jdi");  
        platnePrikazy.add("konec");  
        platnePrikazy.add("napoveda");  
    }
    
    public boolean jePlatnyPrikaz(String retezec) { 
        return platnePrikazy.contains(retezec);
    }
    
    public String vratSeznamPrikazu() { 
        String seznam = ""; 
        for (String slovoPrikazu : platnePrikazy){ 
            seznam += slovoPrikazu + " "; 
        } 
        return seznam; 
    }
}
