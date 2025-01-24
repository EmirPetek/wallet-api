package com.emirpetek.walletapp.walletApp.util.cardInformation;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Random;

public class CreateCardInformation {





    // Geçerli bir kart numarası üreten fonksiyon (String döner)
    protected static String generateCardNumber() {
        Random random = new Random();
        int[] cardNumber = new int[16];

        // İlk 15 haneyi rastgele oluştur
        for (int i = 0; i < 15; i++) {
            cardNumber[i] = random.nextInt(10); // 0-9 arasında rastgele bir sayı
        }

        // Son haneyi hesapla (Luhn Algoritması)
        cardNumber[15] = calculateLuhnCheckDigit(cardNumber);

        // Kart numarasını birleştirerek String'e dönüştür
        StringBuilder cardNumberStr = new StringBuilder();
        for (int digit : cardNumber) {
            cardNumberStr.append(digit);
        }

        return cardNumberStr.toString();
    }

    // Luhn Algoritması ile kontrol basamağını hesaplar
    private static int calculateLuhnCheckDigit(int[] cardNumber) {
        int sum = 0;
        boolean isDouble = true;

        // Kart numarasını tersten dolaş
        for (int i = cardNumber.length - 2; i >= 0; i--) {
            int digit = cardNumber[i];
            if (isDouble) {
                digit *= 2; // Her ikinci basamak ikiyle çarpılır
                if (digit > 9) {
                    digit -= 9; // 9'dan büyükse rakamlarını topla
                }
            }
            sum += digit;
            isDouble = !isDouble; // Bir sonraki basamağı çiftle
        }

        // Toplamın 10'a tamamlayanı kontrol basamağıdır
        return (10 - (sum % 10)) % 10;
    }

    // Rastgele bir CVV numarası üretir (3 haneli)
    protected static int generateCvv() {
        Random random = new Random();
        return 100 + random.nextInt(900); // 100-999 arasında rastgele sayı
    }

    // Rastgele geçerli bir son kullanma tarihi üretir
    protected static String generateExpireDate() {
        Random random = new Random();
        int currentYear = LocalDate.now().getYear();
        int year = currentYear + random.nextInt(5) + 1; // Şu andan itibaren 1-5 yıl sonrası
        int month = random.nextInt(12) + 1; // 1-12 ay arasında rastgele bir ay

        // Son kullanma tarihi MM/YY formatında döndürülür
        return String.format("%02d/%02d", month, year % 100);
    }

    // IBAN oluşturma

}
