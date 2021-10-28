package com.example.btleproyecto;


import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * Utilidades
 * Fichero donde encontramos metodos para convertir los datos en otro tipo.
 * Alberto Valls Martinez
 * 27/10/21
 */
public class Utilidades {

    /**
     * Método que sirve para pasar una string a bytes
     * @param texto que es lo que queremos convertir a bytes
     * @return nos devuelve los bytes convertidos
     */
    public static byte[] stringToBytes ( String texto ) {
        return texto.getBytes();

    } // ()

    /**
     * Método que sirve para convertir una string UUID de 16 caracteres a onjeto UUID
     * @param uuid que queremos convertir
     * @throws Error que lanza si es menor de 16 caracteres
     * @return devolvemos el objeto uuid convertido
     */
    public static UUID stringToUUID( String uuid ) {
        if ( uuid.length() != 16 ) {//tiene que tener 16 caracteres
            throw new Error( "stringUUID: string no tiene 16 caracteres ");
        }

        String masSignificativo = uuid.substring(0, 8);
        String menosSignificativo = uuid.substring(8, 16);
        UUID res = new UUID( Utilidades.bytesToLong( masSignificativo.getBytes() ), Utilidades.bytesToLong( menosSignificativo.getBytes() ) );



        return res;
    } // ()

    /**
     * Metodo que sirve para convertir una UUID a una string
     * @param uuid que es el parámetro a convertir que le pasamos
     * @return nos devuelve el string convertido
     */
    public static String uuidToString ( UUID uuid ) {
        return bytesToString( dosLongToBytes( uuid.getMostSignificantBits(), uuid.getLeastSignificantBits() ) );
    } // ()

    /**
     * Metodo que sirce para convertir una uuid a una string hexadecimal
     * @param uuid el parámetro a convertir
     * @return nos devuelve el string hexadecimal de los bytes
     */
    public static String uuidToHexString ( UUID uuid ) {
        return bytesToHexString( dosLongToBytes( uuid.getMostSignificantBits(), uuid.getLeastSignificantBits() ) );
    } // ()

    /**
     * Metodo que convierte los bytes a una string
     * @param bytes parámetro a convertir
     * @return nos devuelve un string con los bytes
     */
    public static String bytesToString( byte[] bytes ) {
        if (bytes == null ) {//si no hay bytes
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append( (char) b );
        }
        return sb.toString();
    }

    /**
     *
     * Metodo que pone en un array los bytes mas y menos significativos
     * @param masSignificativos primeros 8 bytes
     * @param menosSignificativos ultimos 8 bytes
     * @return devuelve el array completo
     */
    public static byte[] dosLongToBytes( long masSignificativos, long menosSignificativos ) {
        ByteBuffer buffer = ByteBuffer.allocate( 2 * Long.BYTES );
        buffer.putLong( masSignificativos );
        buffer.putLong( menosSignificativos );
        return buffer.array();
    }

    /**
     * bytes->bytesToInt()->Z
     * Metodo que convierte los bytes a enteros
     * @param bytes que queremos convertir
     * @return devolvemos los bytes en bigInteger
     */
    public static int bytesToInt( byte[] bytes ) {
        return new BigInteger(bytes).intValue();
    }

    /**
     * bytes->bytesToLong()->R
     * Metodo que sirve para convertir bytes a numeros de 4 bytes
     * @param bytes parámetro que pasamos que queremos convertir
     * @return nos devuelve la conversión
     */
    public static long bytesToLong( byte[] bytes ) {
        return new BigInteger(bytes).longValue();
    }

    /**
     * bytes->bytesToIntOk()->Z
     *Metodo que convierte bytes a enteros comprobando su tamaño
     * @param bytes parametro que queremos convertir
     * @return nos devuelve el objeto entero
     */
    public static int bytesToIntOK( byte[] bytes ) {
        if (bytes == null ) {
            return 0;
        }

        if ( bytes.length > 4 ) {//si la longitud de los bytes es mayor que 4
            throw new Error( "demasiados bytes para pasar a int ");
        }
        int res = 0;



        for( byte b : bytes ) {

            res =  (res << 8) // * 16
                    + (b & 0xFF); // para quedarse con 1 byte (2 cuartetos) de lo que haya en b
        } // for

        if ( (bytes[ 0 ] & 0x8) != 0 ) {
            // si tiene signo negativo (un 1 a la izquierda del primer byte
            res = -(~(byte)res)-1; // complemento a 2 (~) de res pero como byte, -1
        }


        return res;
    } // ()

    /**
     *Metodo que convierte bytes a una string hexadecimal
     * @param bytes parametro que queremos convertir
     * @return nos devuelve la string hexadecimal
     */
    public static String bytesToHexString( byte[] bytes ) {

        if (bytes == null ) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
            sb.append(':');
        }
        return sb.toString();
    } // ()
} // class



