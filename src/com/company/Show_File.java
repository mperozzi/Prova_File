package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Show_File {
    Show_File() {}

    public void WriteFile (String namefile) {
        int i;
        FileInputStream fis = null;
        PrintWriter pw = new PrintWriter(System.out, true);

        if (namefile.length() < 1) {
            pw.println("Specificare un nome di un file");
            return;
        }

        //apro il file e leggo di seguito fino a che non trovo eof (-1)
        try {
            fis = new FileInputStream(namefile);
            do {
                i = fis.read();
                if (i != -1) {
                    pw.println((char) i);
                }
            }   while (i != -1);

            //gestione delle eccezioni --> Generale
        } catch (java.io.IOException e) {
            pw.println("Errore: " + e);


        }   finally {
                try {
                    if (fis != null) fis.close();
                } catch (IOException e) {
                    pw.println("Errore di chiusura");
                }
        }
    }
}
