package com.emirpetek.walletapp.walletApp.util;

import com.emirpetek.walletapp.walletApp.model.BillType;

import java.util.Random;

public class RandomBill {

    public static BillType getRandomBillType() {
        BillType[] billTypes = BillType.values(); // Tüm enum sabitlerini al
        Random random = new Random();
        int randomIndex = random.nextInt(billTypes.length); // 0 ile toplam enum sayısı arasında bir indeks seç
        return billTypes[randomIndex]; // Rastgele bir enum sabitini döndür
    }
}
