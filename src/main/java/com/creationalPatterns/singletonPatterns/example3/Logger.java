package com.creationalPatterns.singletonPatterns.example3;

import java.util.ArrayList;
import java.util.List;

public class Logger {


    // 1. Tek nesneyi tutacak statik referans
    private static Logger instance;

    // Log kayıtlarını tuttuğumuz basit bir liste (gerçekte dosyaya da yazılabilir)
    private List<String> logKayitlari;

    // 2. Constructor private -> dışarıdan new ile oluşturulamaz
    private Logger() {
        logKayitlari = new ArrayList<>();
        System.out.println("Logger başlatıldı, log dosyası açıldı.");
    }

    // 3. Kontrollü erişim noktası
    public static Logger getInstance(){
        if(instance==null)
            instance=new Logger();
        return instance;
    }

    public void log(String message){
        String kayit="[LOG] "+message;
        logKayitlari.add(kayit);
    }
    public void tumLoglariGoster(){
        System.out.println("-----------Tüm Loglar----------");
        logKayitlari.forEach(System.out::println);
    }
}

