
package com.example.btleproyecto;

import java.util.Arrays;

// -----------------------------------------------------------------------------------
// @author: Jordi Bataller i Mascarell
// -----------------------------------------------------------------------------------
public class TramaIBeacon {
    private byte[] prefijo = null; // 9 bytes
    private byte[] uuid = null; // 16 bytes
    private byte[] major = null; // 2 bytes
    private byte[] minor = null; // 2 bytes
    private byte txPower = 0; // 1 byte

    private byte[] losBytes;

    private byte[] advFlags = null; // 3 bytes
    private byte[] advHeader = null; // 2 bytes
    private byte[] companyID = new byte[2]; // 2 bytes
    private byte iBeaconType = 0 ; // 1 byte
    private byte iBeaconLength = 0 ; // 1 byte

    /**
     * Metodo para devolver el prefijo
     * @return nos devuelve el prefijo
     */
    public byte[] getPrefijo() {
        return prefijo;
    }

    /**
     * Metodo para devolver el UUID
     * @return nos devuelve el UUID
     */
    public byte[] getUUID() {
        return uuid;
    }

    /**
     * Metodo para devolver el mayor
     * @return nos devuelve el mayor
     */
    public byte[] getMajor() {
        return major;
    }

    /**
     * Metodo para devolver el menor
     * @return nos devuelve el menor
     */
    public byte[] getMinor() {
        return minor;
    }

    /**
     * Metodo para devolver el TxPower
     * @return nos devuelve el txPower
     */
    public byte getTxPower() {
        return txPower;
    }

    /**
     * Metodo para devolver losBytes
     * @return nos devuelve losBytes
     */
    public byte[] getLosBytes() {
        return losBytes;
    }

    /**
     * Metodo que proporciona el tamaño de los bytes que sigue(AD length)
     * @return devuelve el advFlags
     */
    public byte[] getAdvFlags() {
        return advFlags;
    }

    /**
     * Metodo que proporciona los 26 bits restantes y proporciona los datos del fabricante
     * @return devuelve el advHeader
     */
    public byte[] getAdvHeader() {
        return advHeader;
    }

    /**
     * Metodo para devolver el ID de la compañia
     * @return nos devuelve el id de la compañia
     */
    public byte[] getCompanyID() {
        return companyID;
    }

    /**
     * Metodo para devolver el tipo de Beacon
     * @return nos devuelve el tipo de Beacon
     */
    public byte getiBeaconType() {
        return iBeaconType;
    }

    /**
     * Metodo para devolver el tamaño del Beacon
     * @return nos devuelve su tamaño
     */
    public byte getiBeaconLength() {
        return iBeaconLength;
    }

    /**
     * Constructor para añadir los bytes a la trama del beacon
     * @param bytes que queremos añaair a su trama
     */
    public TramaIBeacon(byte[] bytes ) {
        this.losBytes = bytes;

        prefijo = Arrays.copyOfRange(losBytes, 0, 8+1 ); // 9 bytes
        uuid = Arrays.copyOfRange(losBytes, 9, 24+1 ); // 16 bytes
        major = Arrays.copyOfRange(losBytes, 25, 26+1 ); // 2 bytes
        minor = Arrays.copyOfRange(losBytes, 27, 28+1 ); // 2 bytes
        txPower = losBytes[ 29 ]; // 1 byte

        advFlags = Arrays.copyOfRange( prefijo, 0, 2+1 ); // 3 bytes
        advHeader = Arrays.copyOfRange( prefijo, 3, 4+1 ); // 2 bytes
        companyID = Arrays.copyOfRange( prefijo, 5, 6+1 ); // 2 bytes
        iBeaconType = prefijo[ 7 ]; // 1 byte
        iBeaconLength = prefijo[ 8 ]; // 1 byte

    } // ()
} // class



