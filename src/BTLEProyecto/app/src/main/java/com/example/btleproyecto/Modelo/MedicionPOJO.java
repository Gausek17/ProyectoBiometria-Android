package com.example.btleproyecto.Modelo;

public class MedicionPOJO {

    private int medicion;
    private String id_sensor;
    private double longitud;
    private double latitud;
    private String fecha;//retocar

    public MedicionPOJO(int medicion, String id_sensor, double longitud, double latitud){

        this.medicion=medicion;
        this.id_sensor=id_sensor;
        this.longitud=longitud;
        this.latitud=latitud;
    }

    public int getMedicion(){
        return medicion;
    }

    public String getId_sensor(){
        return id_sensor;
    }

    public double getLongitud(){
        return longitud;
    }

    public double getLatitud(){
        return latitud;
    }

}
