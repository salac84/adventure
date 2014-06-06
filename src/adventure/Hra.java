package adventure;

class Hra { 
   private SeznamPrikazu platnePrikazy; 
     // obsahuje seznam přípustných slov 
   private Mistnost aktualniMistnost; 
   private boolean konecHry = false;
   
    public Hra() { 
        zalozMistnosti();  
        platnePrikazy = new SeznamPrikazu(); 
    }
    
    private void zalozMistnosti() { 
        Mistnost hala; 
        Mistnost ucebna; 
        Mistnost bufet; 
        Mistnost chodba; 
        Mistnost kancelar;   
        // vytvářejí se jednotlivé místnosti 
        hala = new Mistnost("hala", "vstupni hala budovy VSE na Jiznim meste"); 
        ucebna = new Mistnost("ucebna", "prednaskova ucebna 103JM"); 
        bufet = new Mistnost("bufet", "bufet, kam si muzete zajit na svacinku"); 
        chodba = new Mistnost("chodba","spojovaci chodba"); 
        kancelar = new Mistnost("kancelar", "kancelar vaseho vyucujiciho Javy"); 
        // přiřazují se východy z místností (sousedící místnosti) 
        hala.setVychod(ucebna); 
        hala.setVychod(chodba); 
        hala.setVychod(bufet); 
        ucebna.setVychod(hala); 
        bufet.setVychod(hala); 
        chodba.setVychod(hala); 
        chodba.setVychod(kancelar); 
        kancelar.setVychod(chodba); 
        aktualniMistnost = hala; // hra začíná v místnosti hala 
    }
    
    public String vratUvitani() { 
        return  "Vitejte!\n" + 
                "Toto je nova, neuveritelne nudna adventura.\n" + 
                "Napiste 'napoveda', pokud si nevite rady, jak hrat dal.\n" +  
                "\n" + 
                aktualniMistnost.dlouhyPopis(); 
    }
    
    public String vratEpilog() { 
        return "Dik, ze jste si zahrali. Ahoj."; 
    } 

    public boolean konecHry() { 
        return konecHry;  
    }
    
    public String zpracujPrikaz(Prikaz prikaz) { 
        String textKVypsani=" .... "; 
        if (platnePrikazy.jePlatnyPrikaz(prikaz.getSlovoPrikazu())){ 
            String povel = prikaz.getSlovoPrikazu(); 
            if (povel.equals("napoveda")) { 
                textKVypsani = napoveda(); 
            } 
            else if (povel.equals("jdi")) { 
                textKVypsani = jdi(prikaz); 
            } 
            else if (povel.equals("konec")) { 
                textKVypsani = konec(prikaz); 
            } 
        } 
        else { 
            textKVypsani="Nevim co tim myslis, tento prikaz neznam?"; 
        } 
        return textKVypsani; 
    }
    
    private String konec(Prikaz prikaz) { 
        if (prikaz.maDruheSlovo()) {    
            return "Ukoncit co? Nechapu, proc jste zadal druhe slovo."; 
        } 
        else {
            konecHry = true; 
            return "hra ukončena příkazem konec"; 
        }  
    }
    
    private String napoveda() { 
        return  "Ztratil ses. Jsi sam(a). Toulas se\n" + 
                "po arealu skoly na Jiznim meste.\n" + 
                "\n" + 
                "Muzes zadat tyto prikazy:\n" + 
                platnePrikazy.vratSeznamPrikazu(); 
    }
    
    private String jdi(Prikaz prikaz) { 
        if (!prikaz.maDruheSlovo()) { 
        // pokud chybí druhé slovo (sousední místnost), tak 
            return "Kam mám jít? Musíš zadat jméno místnosti"; 
        }  
        String smer = prikaz.getDruheSlovo(); 
        // zkoušíme přejít do sousední místnosti 
        Mistnost sousedniMistnost = aktualniMistnost.sousedniMistnost(smer); 
        if (sousedniMistnost == null) {     
            return "Tam se odsud jit neda!"; 
        } 
        else { 
            aktualniMistnost = sousedniMistnost; 
            return aktualniMistnost.dlouhyPopis(); 
        } 
    } 
}
