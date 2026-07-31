package com.creationalPatterns.abstractFactory.example3;

public class TeslaAraba implements Araba{
    @Override
    public void surus() {
        System.out.println("Tesla araba sessizce ve elektrikli sürüyor.");
    }
}
class TeslaMotor implements Motor{

    @Override
    public void calistir() {
        System.out.println("Tesla elektrikli motor çalıştı - sessiz.");
    }
}
class TeslaLastik implements Lastik{

    @Override
    public void yolTutus() {
        System.out.println("Tesla lastikleri yola sıkı tutunuyor - performans lastiği.");
    }
}

class ToyotaAraba implements Araba{
    @Override
    public void surus() {
        System.out.println("Toyota araba yakıt ile güvenle sürüyor.");
    }
}
class ToyotaMotor implements Motor{

    @Override
    public void calistir() {
        System.out.println("Toyota benzinli motor çalıştı - vınlıyor.");
    }
}
class ToyotaLastik implements Lastik{

    @Override
    public void yolTutus() {
        System.out.println("Toyota lastikleri yola dayanıklı tutunuyor - ekonomik lastik.");
    }
}
