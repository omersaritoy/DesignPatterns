    package com.strucuralPatterns.adapter.example3;

    import java.util.ArrayList;
    import java.util.List;

    public class YerelHavaDurumuServisi implements HavaDurumuServisi{
        @Override
        public double sicakligiGetir(String sehir) {
            System.out.println(sehir+" için : "+22.0);
            return 22.0;
        }
    }
