/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progazienda;

/**
 *
 * Scrivere un programma che permetta di memorizzare i dipendenti di un azienda. Ogni dipendente è caratterizzato da un nome, da un cognome, 
 * da un Dipartimento in cui lavora (produzione, commerciale, amministrazione), da uno stipendio annuale e da un livello (che può valere un numero da 1 a 7).
 * Ogni dipendente viene assunto dal livello 1 con stipendio base mensile di 1300 euro per produzione e commerciale e 1500 euro per amministrazione 
 * su 13 mensilità.
 * Prevedi un metodo che permetta di aumentare del 10% lo stipendio al passaggio di livello. 
 * Inoltre quando il dipendente raggiunge il 5 livello ottiene 1000 euro di premio.
 * Prevedi un metodo che permetta di visualizzare i dati del dipendente.
 * @author gabriel.ricaldone
 */


public class Dipendente {
    private String nome;
    private String cognome;
    private String dipartimento;
    private int stipendioAnnuale;
    private int livello;
    
    Dipendente(String nome, String cognome, String dipartimento) {
        this.nome = nome;
        this.cognome = cognome;
        this.dipartimento = dipartimento.toLowerCase();
        livello = 1;
        if (dipartimento.equals("produzione") || dipartimento.equals("commerciale"))
            stipendioAnnuale = 1300*13;
        else if (dipartimento.equals("amministrazione")) 
            stipendioAnnuale = 1500*13;
        else 
        {
            System.out.println("Errore, dipartimento non esistente. Il codice potrebbe malfunzionare.");
            stipendioAnnuale = -1;
        }
    }
    
    public void aumentoStipendio() {
        int stipendioMensile = stipendioAnnuale / 13;
        int aumento = 10;
        stipendioMensile += stipendioMensile/100 * aumento;
        stipendioAnnuale = stipendioMensile * 13;
    }
    
  
    
    
    
    
    
    public String getNome() {
        return nome;
    }
    
    public String getCognome() {
        return cognome;
    }
    
    public String getDipartimento() {
        return dipartimento;
    }
    
    public int getStipendioAnnuale() {
        return stipendioAnnuale;
    }
    
    public int getLivello() {
        return livello;  
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    public void setDipartimento(String dipartimento) {
        this.dipartimento = dipartimento.toLowerCase();
        livello = 1;
        
        if (dipartimento.equals("produzione") || dipartimento.equals("commerciale")) {
            stipendioAnnuale = 1300*13;
        } else if (dipartimento.equals("amministrazione")) { 
            stipendioAnnuale = 1500*13;
        } else 
        {
            System.out.println("Errore, dipartimento non esistente. Il codice potrebbe malfunzionare.");
            stipendioAnnuale = -1;
        }
    }
    
    public void setStipendioAnnuale(int stipendioMensile) {
        stipendioAnnuale = stipendioMensile*13;
    }
    
    public int setLivello(int livello) {
        int stipendioMensile;
        boolean bonus = false;
        this.livello = livello;

        if (dipartimento.equals("produzione") || dipartimento.equals("commerciale")) {
            stipendioAnnuale = 1300*13;
           
        } else if (dipartimento.equals("amministrazione")) { 
            stipendioAnnuale = 1500*13; 
   
        } else {
            System.out.println("Errore, dipartimento non esistente. Il codice potrebbe malfunzionare.");
            stipendioAnnuale = -1;
          
        }
        
        for (int i = 0; i < livello; i++) {
            aumentoStipendio();
            if (i == 4) {
                bonus = true;
            }
        }
        if (bonus) {
            return 1000;
        } else {
            return 0;
        }
    }
    
    
    
}
