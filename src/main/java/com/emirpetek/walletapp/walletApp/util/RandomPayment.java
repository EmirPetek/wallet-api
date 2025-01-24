package com.emirpetek.walletapp.walletApp.util;

import com.emirpetek.walletapp.walletApp.model.BillType;
import com.emirpetek.walletapp.walletApp.model.PaymentCompany;

import java.util.Random;

public class RandomPayment {

    public static PaymentCompany getRandomPaymentCompany() {
        PaymentCompany[] paymentCompany = PaymentCompany.values(); // Tüm enum sabitlerini al
        Random random = new Random();
        int randomIndex = random.nextInt(paymentCompany.length); // 0 ile toplam enum sayısı arasında bir indeks seç
        return paymentCompany[randomIndex]; // Rastgele bir enum sabitini döndür
    }

}
