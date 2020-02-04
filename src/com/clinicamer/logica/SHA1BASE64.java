/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinicamer.logica;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Ing. Jorge Bermudez
 */
public final class SHA1BASE64 implements Serializable{
    
     public static String encode(String value) throws Exception {
        return Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode(String value) throws Exception {
        byte[] decodedValue = Base64.getDecoder().decode(value);  // Basic Base64 decoding
        return new String(decodedValue, StandardCharsets.UTF_8);
    }
    
    public static String encriptar(String textoplano) throws IllegalStateException, NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("SHA"); // Instancia de generador SHA-1
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e.getMessage());
        }

        try {
            md.update(textoplano.getBytes("UTF-8")); // Generaci�n de resumen de mensaje
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e.getMessage());
        }

        byte raw[] = md.digest(); // Obtenci�n del resumen de mensaje
        String hash = (new BASE64Encoder()).encode(raw); // Traducci�n a BASE64
        return hash;
    }
}
