package com.example.btleproyecto.CasosDeUso;

import android.util.Log;

import com.example.btleproyecto.Datos.PeticionarioREST;
import com.example.btleproyecto.Modelo.MedicionPOJO;

public class LogicaFake {

    public void guardarMedicion(MedicionPOJO medicion){

        PeticionarioREST elPeticionario=new PeticionarioREST();

        String textoJSON = "{\"Medicion\":\""+medicion.getMedicion()+"\", \"Longitud\":\""+medicion.getLongitud() +"\", \"Latitud\": \""+medicion.getLatitud()+"\", \"Id_sensor\":\""+medicion.getId_sensor()+"\"}";
        elPeticionario.hacerPeticionREST("POST", "", textoJSON,
                new PeticionarioREST.RespuestaREST() {
                    @Override
                    public void callback(int codigo, String cuerpo) {
                        Log.d("","Medición subida correctamente a la BBDD");
                    }
                }
        );

    }
}
