package com.emirpetek.walletapp.walletApp.util.account;

import java.math.BigInteger;
import java.util.Random;

public class CreateAccountInformation {

    // Hesap numarası üreten fonksiyon
    public String generateAccountNumber() {
        Random random = new Random();

        // TR (Türkiye) IBAN formatında hesap numarası başlatılıyor
        StringBuilder accountNumber = new StringBuilder("TR");

        // 2 basamak kontrol basamağı için (şu an 00 ile başlatıyoruz)
        accountNumber.append("00");

        // 22 haneli rastgele hesap numarası oluştur
        for (int i = 0; i < 22; i++) {
            accountNumber.append(random.nextInt(10));
        }

        // Üretilen hesap numarasını döndür
        return accountNumber.toString();
    }
}
