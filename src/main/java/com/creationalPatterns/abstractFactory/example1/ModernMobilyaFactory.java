package com.creationalPatterns.abstractFactory.example1;

public class ModernMobilyaFactory implements MobilyaFactory{
    @Override
    public Sandalye sandalyeOlustur() {
        return new ModernSandalye();
    }

    @Override
    public Masa masaOlustur() {
        return new ModernMasa();
    }
}

class KlasikMobilyaFactory implements MobilyaFactory {
    @Override
    public Sandalye sandalyeOlustur() {
        return new KlasikSandalye();
    }

    @Override
    public Masa masaOlustur() {
        return new KlasikMasa();
    }
}