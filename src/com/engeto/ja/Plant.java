package com.engeto.ja;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.lang.Exception;


public class Plant {

    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequency;
    public class PlantException extends Exception {
        public PlantException(String message) {
            super(message);   // Prázdný řetězec pro poznámky
        }
    }
    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int frequency) throws PlantException {
        if (frequency <= 0){
            throw new PlantException("Frekvence zálivky musí být větší než nula");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new PlantException("Název rostliny nesmí být prázdný nebo null");
        }

        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequency = frequency;

    }
    public Plant(String name, int frequency) throws PlantException{
        this(name, "", LocalDate.now(), LocalDate.now(), frequency);
    }
    public Plant(String name) throws PlantException{
        this(name, "", LocalDate.now(), LocalDate.now(), 7);

    }

    public String getWateringInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");

        String lastWateringDate = watering.format(formatter);
        String nextWateringDate = watering.plusDays(frequency).format(formatter);

        return "Název rostliny: " + name +
                "\nDatum poslední zálivky: " + lastWateringDate +
                "\nDatum doporučené další zálivky: " + nextWateringDate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) {
        this.watering = watering;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

}


