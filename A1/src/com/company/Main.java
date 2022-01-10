package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


    enum Size{
        Small,
        Medium,
        Large
    }


    public static class Kunde {

        private int Id;
        private String Unternehmensname;
        private Size Unternehmensgrosse;
        private int AnzahlMitarbeiter;
        private int Einkommen;
        private String Ort;

        public Kunde(int id, String unternehmensname, Size unternehmensgrosse, int anzahlMitarbeiter, int einkommen, String ort) {
            Id = id;
            Unternehmensname = unternehmensname;
            Unternehmensgrosse = unternehmensgrosse;
            AnzahlMitarbeiter = anzahlMitarbeiter;
            Einkommen = einkommen;
            Ort = ort;
        }

        public int getId() {
            return Id;
        }

        public String getUnternehmensname() {
            return Unternehmensname;
        }

        public Size getUnternehmensgrosse() {
            return Unternehmensgrosse;
        }

        public int getAnzahlMitarbeiter() {
            return AnzahlMitarbeiter;
        }

        public int getEinkommen() {
            return Einkommen;
        }

        public String getOrt() {
            return Ort;
        }

        public String toString() {
            return "Id=" + Id +
                    ", Unternehmensname='" + Unternehmensname + '\'' +
                    ", Unternehmensgrosse=" + Unternehmensgrosse +
                    ", AnzahlMitarbeiter=" + AnzahlMitarbeiter +
                    ", Einkommen=" + Einkommen +
                    ", Ort='" + Ort + '\'';
        }
    }

    public static ArrayList<Kunde> read_from_file(){

        /*List kunden witch will contain clients read from file kundendaten.txt*/
        ArrayList<Kunde> kunden = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("kundendaten"))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] spliter = line.split(",");
                Kunde kunde = new Kunde(Integer.parseInt(spliter[0]), spliter[1], Size.valueOf(spliter[2]), Integer.parseInt(spliter[3]), Integer.parseInt(spliter[4]), spliter[5]);
                kunden.add(kunde);
            }
            return kunden;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void write_to_file(String fileName, Kunde kunde) {
        try {
            FileWriter myWriter = new FileWriter(fileName, true);
            myWriter.write(kunde.getId() + "," + kunde.getUnternehmensname() + "," + kunde.getUnternehmensgrosse() + "," + kunde.getAnzahlMitarbeiter() + "," + kunde.getEinkommen() + "," + kunde.getOrt() + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ArrayList<Kunde> kunden;

        // a.) Read from file
        kunden = read_from_file();
        assert kunden != null;

        // b.) Sort clients after workers number
        List<Kunde> aux;
        aux = kunden.stream().sorted(Comparator.comparingInt(Kunde::getAnzahlMitarbeiter).reversed()).collect(Collectors.toList());

        // c.) Write clients into kundesortiert.txt
        for(Kunde a : aux) {
            write_to_file("kundensortiert.txt", a);
        }

        aux.clear();

        Map<String, Integer> maxEinkommen = kunden.stream().collect(Collectors.groupingBy(Kunde::getOrt, Collectors.collectingAndThen(
                                Collectors.groupingBy(Kunde::getEinkommen, Collectors.counting()),
                                map -> map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey()
                        )
                ));

        LinkedHashMap<String, Integer> sortedMaxEinkommen = new LinkedHashMap<>();
        maxEinkommen.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> sortedMaxEinkommen.put(x.getKey(), x.getValue()));

        Set<String> keys = sortedMaxEinkommen.keySet();

        for(String key : keys){
            try {
                FileWriter myWriter = new FileWriter("statistik.txt", true);
                myWriter.write(key + ": " + sortedMaxEinkommen.get(key) + "\n");
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
}
