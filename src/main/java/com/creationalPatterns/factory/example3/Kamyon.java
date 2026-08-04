package com.creationalPatterns.factory.example3;

class Kamyon implements Tasiyici{
    @Override
    public void teslimatYap(String urun) {
        System.out.println("[Kamyon] " + urun + " karayolu ile teslim ediliyor.");
    }
}
class Gemi implements Tasiyici {
    @Override
    public void teslimatYap(String urun) {
        System.out.println("[Gemi] " + urun + " denizyolu ile teslim ediliyor.");
    }
}
class Ucak implements Tasiyici {
    @Override
    public void teslimatYap(String urun) {
        System.out.println("[Uçak] " + urun + " havayolu ile teslim ediliyor.");
    }
}
class TasiyiciFactory {
    public static Tasiyici olustur(String tasimaTuru) {
        switch (tasimaTuru.toLowerCase()) {
            case "kara":
                return new Kamyon();
            case "deniz":
                return new Gemi();
            case "hava":
                return new Ucak();
            default:
                throw new IllegalArgumentException("Bilinmeyen taşıma türü: " + tasimaTuru);
        }
    }
}

class Uygulama {
    public static void main(String[] args) {
        Tasiyici tasiyici1 = TasiyiciFactory.olustur("kara");
        tasiyici1.teslimatYap("Elektronik eşya");

        Tasiyici tasiyici2 = TasiyiciFactory.olustur("deniz");
        tasiyici2.teslimatYap("Otomobil parçaları");

        Tasiyici tasiyici3 = TasiyiciFactory.olustur("hava");
        tasiyici3.teslimatYap("Acil tıbbi malzeme");
    }
}
