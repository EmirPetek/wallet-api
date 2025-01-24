package com.emirpetek.walletapp.walletApp.util.hashPassword;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {

    public String hashWithSHA256(String input) {
        try {
            // SHA-256 MessageDigest nesnesini oluştur
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Girdi verisini hashle ve byte dizisine dönüştür
            byte[] hash = digest.digest(input.getBytes());

            // Hashlenmiş byte'ları hex string'e çevir
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0'); // Tek karakterli hex değerleri için başa '0' ekle
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error while hashing with SHA-256", e);
        }
    }
}
