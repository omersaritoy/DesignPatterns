package com.creationalPatterns.singletonPatterns.example3;

public class OdemeServisi {
    public void odemeYap() {
        Logger logger = Logger.getInstance();
        logger.log("Ödeme işlemi tamamlandı.");
    }
}