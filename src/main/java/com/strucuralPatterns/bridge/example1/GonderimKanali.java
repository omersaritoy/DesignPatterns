package com.strucuralPatterns.bridge.example1;

interface GonderimKanali {
    void gonder(String icerik);
}
class EmailKanali implements GonderimKanali {
    @Override
    public void gonder(String icerik) {
        System.out.println("[EMAIL] " + icerik);
    }
}
class SmsKanali implements GonderimKanali {
    @Override
    public void gonder(String icerik) {
        System.out.println("[SMS] " + icerik);
    }
}
abstract class Mesaj {
    protected GonderimKanali kanal; // KÖPRÜ - kalıtım değil, kompozisyon!

    public Mesaj(GonderimKanali kanal) {
        this.kanal = kanal;
    }

    abstract void gonder(String icerik);

    // Çalışma zamanında kanalı değiştirebilme imkanı
    public void kanalDegistir(GonderimKanali yeniKanal) {
        this.kanal = yeniKanal;
    }
}

class AcilMesaj extends Mesaj {
    public AcilMesaj(GonderimKanali kanal) {
        super(kanal);
    }

    @Override
    void gonder(String icerik) {
        // "Acil" mantığı SADECE BİR YERDE yazıldı, tüm kanallar için geçerli
        String isaretliIcerik = icerik.toUpperCase() + " !!!";
        kanal.gonder(isaretliIcerik); // işi kanala DELEGE ediyor
    }
}
class NormalMesaj extends Mesaj {
    public NormalMesaj(GonderimKanali kanal) {
        super(kanal);
    }

    @Override
    void gonder(String icerik) {
        kanal.gonder(icerik);
    }
}
class Uygulama {
    public static void main(String[] args) {
        Mesaj acilEmail = new AcilMesaj(new EmailKanali());
        acilEmail.gonder("Sunucu çöktü");

        Mesaj normalSms = new NormalMesaj(new SmsKanali());
        normalSms.gonder("Toplantı 15:00'te");

        // Çalışma zamanında kanal değiştirme
        System.out.println("--- Kanal değiştiriliyor ---");
        acilEmail.kanalDegistir(new SmsKanali());
        acilEmail.gonder("Email başarısız, SMS'e düşüldü");
    }
}