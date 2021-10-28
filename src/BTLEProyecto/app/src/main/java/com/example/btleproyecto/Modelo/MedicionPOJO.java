package com.example.btleproyecto.Modelo;
/**
 * MedicionPOJO
 * Fichero donde encontramos los valores de la medicion realizada
 * Alberto Valls Martinez
 * 27/10/21
 */

/**
 *Clase para recoger los valores de medicion
 */

public class MedicionPOJO {

    private int medicion;
    private String id_sensor;
    private double longitud;
    private double latitud;
    private String fecha;//retocar

    /**
     * Metodo para asignar los valores a la medicion
     * @param medicion valor recogido del sensor
     * @param id_sensor el sensor registrado
     * @param longitud la longitud registrada
     * @param latitud la latitud registrada
     */
    public MedicionPOJO(int medicion, double longitud, double latitud){

        this.medicion=medicion;
        this.id_sensor="1";
        this.longitud=longitud;
        this.latitud=latitud;
    }

    /**
     * getMedicion()->z
     * Metodo para obtener la medicion
     * @return devuelve la medicion
     */
    public int getMedicion(){
        return medicion;
    }

    /**
     * getId_sensor()->R
     * Metodo para obtener la id del sensor
     * @return devuelve la id del sensor
     */
    public String getId_sensor(){
        return id_sensor;
    }

    /**
     * getLongitud()->R
     * Metodo para obtener la longitud
     * @return devuelve la longitud
     */
    public double getLongitud(){
        return longitud;
    }

    /**
     * getLatitud()->R
     * Metodo para obtener la latitud
     * @return devuelve la latitud
     */
    public double getLatitud(){
        return latitud;
    }

}
