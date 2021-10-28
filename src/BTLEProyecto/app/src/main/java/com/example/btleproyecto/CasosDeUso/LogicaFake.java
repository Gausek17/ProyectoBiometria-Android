package com.example.btleproyecto.CasosDeUso;

import android.util.Log;

import com.example.btleproyecto.Datos.PeticionarioREST;
import com.example.btleproyecto.Modelo.MedicionPOJO;
/**
 * Logica Fake
 * Fichero donde enviamos los datos de nuestra medicion
 * Alberto Valls Martinez
 * 27/10/21
 */


public class LogicaFake {

    /**
     * medicion->guardarMedicion()
     * Metodo para guardar la medicion querida
     * @param medicion que queremos guardar
     */
    public static void guardarMedicion(MedicionPOJO medicion){

        PeticionarioREST elPeticionario=new PeticionarioREST();

        String textoJSON = "[{" +
                "\"medicion\":" + medicion.getMedicion() + "," +
                "\"longitud\":" + medicion.getLongitud() + "," +
                "\"latitud\":" + medicion.getLatitud() +
                "}]";
        elPeticionario.hacerPeticionREST("POST", "http://192.168.85.219:8000/anyadirMedicion", textoJSON,
                new PeticionarioREST.RespuestaREST() {
                    @Override
                    public void callback(int codigo, String cuerpo) {
                        Log.d("","Medición subida correctamente");
                    }
                }
        );

    }
}
