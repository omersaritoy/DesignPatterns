package com.strucuralPatterns.adapter.example2;

class EskiBankaAPI {
    public void islemBaslat(String hesapNo, double miktar, String paraBirimi) {
        System.out.println(hesapNo + " hesabından " + miktar + " " + paraBirimi + " çekiliyor (Eski Banka API).");
    }
}