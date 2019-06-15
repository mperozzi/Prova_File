package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Show_File {
    Show_File() {}

    public void WriteFile (String namefile) {
        //variabile di istanza relativa al flusso di lettura del file
        int i;
        //contatore delle lettere C o c
        int Ccounter = 0;
        //contatore delle parole nel testo del file
        int Pcounter = 0;
        FileInputStream fis = null;
        PrintWriter pw = new PrintWriter(System.out, true);

        if (namefile.length() < 1) {
            System.out.print("Specificare un nome di un file");
            return;
        }

        //apro il file e leggo di seguito fino a che non trovo eof (-1)
        try {
            //istanza di un flusso per leggere il file
            fis = new FileInputStream(namefile);
            do {
                //leggo tramute il flusso i caratteri nel file
                i = fis.read();
                String s = String.valueOf((char) i);
                if (s.equals("c") || s.equals("C")) Ccounter++;
                //se non sono alla fine del file (eof = -1) stampo a schermo il carattere letto (che in realtà è intero e viene convertito)
                if (i != -1) {
                    System.out.print((char) i);
                    if (s.equals("\n") || s.equals(" ") || s.equals("")) Pcounter--;
                    else Pcounter++;
                }
            }   while (i != -1);

            //gestione delle eccezioni --> Generale --> Non mi interessa che tipo di errore è
        } catch (java.io.IOException e) {
            pw.println("Errore: " + e);


        }   finally {
                try {
                    if (fis != null) fis.close();
                } catch (IOException e) {
                    pw.println("Errore di chiusura");
                }
        }

        pw.println("\n" + "Le C o c sono: " + Ccounter);
        pw.println("Le parole del testo nel file sono " + Pcounter);

    }
}
