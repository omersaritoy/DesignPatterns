package com.strucuralPatterns.bridge.badexample;

abstract class Mesaj {
    abstract void gonder(String icerik);
}
class AcilMesajEmail extends Mesaj {
    @Override
    void gonder(String icerik) {
        System.out.println("[EMAIL - ACİL] " + icerik.toUpperCase() + " !!!");
    }
}
class AcilMesajSMS extends Mesaj {
    @Override
    void gonder(String icerik) {
        System.out.println("[SMS - ACİL] " + icerik.toUpperCase() + " !!!");
    }
}
class NormalMesajEmail extends Mesaj {
    @Override
    void gonder(String icerik) {
        System.out.println("[EMAIL - NORMAL] " + icerik);
    }
}

class NormalMesajSMS extends Mesaj {
    @Override
    void gonder(String icerik) {
        System.out.println("[SMS - NORMAL] " + icerik);
    }
}