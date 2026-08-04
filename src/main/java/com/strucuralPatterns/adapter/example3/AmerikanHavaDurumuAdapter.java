package com.strucuralPatterns.adapter.example3;

public class AmerikanHavaDurumuAdapter implements HavaDurumuServisi {

    private AmerikanHavaDurumuAPI amerikanApi;


    public AmerikanHavaDurumuAdapter() {
        this.amerikanApi = new AmerikanHavaDurumuAPI();
    }

    @Override
    public double sicakligiGetir(String sehir) {

        double fahrenheit = amerikanApi.sicakligiFahrenheitGetir(sehir);
        double celsius = (fahrenheit - 32) * 5 / 9;

        return celsius;

    }
}
