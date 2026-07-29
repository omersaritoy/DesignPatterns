package com.creationalPatterns.prototype.example3;

public class Address {
    String city;
    String street;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
}

class Customer implements Cloneable {
    String name;
    Address address;

    public Customer(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    public void bilgiGoster(){
        System.out.println(name+" - "+address.city+" / "+address.street);
    }


    @Override
    public Customer clone() {
        try {
              //  return (Customer) super.clone(); //shallow copy

            Customer kopya = (Customer) super.clone();
            // Adres nesnesini de yeni bir nesne olarak oluşturuyoruz -> DEEP COPY
            kopya.address = new Address(this.address.city, this.address.street);
            return kopya;

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
    }
}