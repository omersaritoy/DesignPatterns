package com.creationalPatterns.factory.example4;


public interface Donusturucu {
    void donustur(String dosyaAdi);
}

class PdfDonusturucu implements Donusturucu {
    @Override
    public void donustur(String dosyaAdi) {
        System.out.println("[PDF] " + dosyaAdi + " dönüştürülüyor...");
    }
}

class WordDonusturucu implements Donusturucu {
    @Override
    public void donustur(String dosyaAdi) {
        System.out.println("[Word] " + dosyaAdi + " dönüştürülüyor...");
    }
}


class ExcelDonusturucu implements Donusturucu {
    @Override
    public void donustur(String dosyaAdi) {
        System.out.println("[Excel] " + dosyaAdi + " dönüştürülüyor...");
    }
}


class DonusturucuFactory {

    public static Donusturucu olustur(String dosyaAdi) {
        int sonNoktaIndex = dosyaAdi.lastIndexOf(".");

        if (sonNoktaIndex == -1 || sonNoktaIndex == dosyaAdi.length() - 1) {
            throw new IllegalArgumentException("Geçersiz dosya adı, uzantı bulunamadı: " + dosyaAdi);
        }

        String uzanti = dosyaAdi.substring(sonNoktaIndex + 1).toLowerCase();

        switch (uzanti) {
            case "pdf":
                return new PdfDonusturucu();
            case "doc":
            case "docx":
                return new WordDonusturucu();
            case "xls":
            case "xlsx":
                return new ExcelDonusturucu();
            default:
                throw new IllegalArgumentException("Desteklenmeyen uzantı: ." + uzanti);
        }
    }

}


