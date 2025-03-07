package org.example.CSV;

import org.example.model.Ticket;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class CSVWriter {
    public static void writeCsv(String path, Vector<Ticket> tickets) {
        try (FileWriter fw = new FileWriter(path)) {
            for (Ticket ticket : tickets) {
                fw.write(String.valueOf(ticket.getId()));
                fw.write(";");
                fw.write(ticket.getName());
                fw.write(";");
                fw.write(ticket.getCoordinates().toString());
                fw.write(";");
                fw.write(String.valueOf(ticket.getCreationDate()));
                fw.write(";");
                fw.write(String.valueOf(ticket.getPrice()));
                fw.write(";");
                fw.write(String.valueOf(ticket.getDiscount()));
                fw.write(";");
                fw.write(ticket.getType().getEng());
                fw.write(";");
                fw.write(ticket.getPerson().toString());
                fw.write(";");
                fw.write("\n");
            }
            System.out.println("Коллекция сохранена в файл: " + path);
        } catch (IOException ignored){
        }
    }
}
