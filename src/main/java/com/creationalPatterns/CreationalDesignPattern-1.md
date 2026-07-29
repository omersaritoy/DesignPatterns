# Creational Patterns

Creational Patterns, nesnelerin **nasıl oluşturulacağını** ele alan tasarım kalıplarıdır. Amaç; nesne oluşturma sürecini **esnek**, **yeniden kullanılabilir** ve **kodun geri kalanından bağımsız** hale getirmektir.

Yani `new` ile doğrudan nesne oluşturmak yerine, bu işlemi belirli kurallara göre yönetiriz.

## Başlıca 5 Creational Pattern

1. Singleton
2. Factory Method
3. Abstract Factory
4. Builder
5. Prototype

---

# 1. Singleton Pattern

Singleton, bir nesnenin program boyunca **yalnızca bir instance'ının oluşturulmasını** garanti eden bir **Creational Pattern**'dır.

Aynı zamanda bu tek nesneye uygulamanın her yerinden erişilebilmesini sağlar.

---

## Neden İhtiyaç Duyulur?

Bazı durumlarda birden fazla nesne oluşturmak hem mantıksız hem de zararlı olabilir.

### Veritabanı Bağlantısı

Her yerde yeni bir bağlantı açmak yerine tek bir bağlantıyı kullanmak daha mantıklıdır.

Aksi takdirde:

- Gereksiz kaynak tüketimi oluşur.
- Performans düşebilir.

### Konfigürasyon (Configuration) Yöneticisi

Uygulama ayarlarının tek bir yerden okunması gerekir.

Her sınıf kendi Configuration nesnesini oluşturursa:

- Veriler senkron olmaktan çıkabilir.
- Farklı sınıflar farklı ayarlar kullanabilir.

### Log Sistemi

Tüm uygulamanın aynı log nesnesini kullanması gerekir.

Böylece:

- Tüm loglar aynı dosyaya yazılır.
- Log kayıtlarında tutarsızlık oluşmaz.

### Cache

Aynı veriyi farklı cache nesnelerinde tutmak veri tutarsızlığına neden olabilir.

Bu yüzden uygulamanın tek bir cache nesnesi kullanması tercih edilir.

---

# Nasıl Çalışır?

Singleton temel olarak **3 kurala** dayanır.

## 1. Constructor'ı Gizle

Sınıfın constructor'ı (`private`) yapılır.

Böylece dışarıdan hiç kimse

```java
new Singleton();
```

şeklinde yeni nesne oluşturamaz.

---

## 2. Nesneyi Sınıfın İçinde Sakla

Sınıf, kendi oluşturduğu tek nesneyi statik (`static`) bir değişkende tutar.

Yani nesneyi dışarıdan değil, kendi içerisinde yönetir.

---

## 3. Kontrollü Erişim Noktası Sağla

Dışarıya yalnızca tek bir metot sunulur.

Genellikle bu metot:

```java
getInstance()
```

olarak adlandırılır.

Bu metodun çalışma mantığı şöyledir:

- Eğer nesne daha önce oluşturulmamışsa oluşturulur.
- Eğer daha önce oluşturulmuşsa mevcut nesne döndürülür.

Sonuç olarak, uygulamanın neresinden çağrılırsa çağrılsın her zaman **aynı nesneye ait referans** döner.

---

# Dikkat Edilmesi Gereken Noktalar

## 1. Thread Safety (İş Parçacığı Güvenliği)

Çok iş parçacıklı (Multi-threaded) uygulamalarda şu problem oluşabilir:

İki thread aynı anda

> "Henüz nesne oluşturulmamış."

kontrolüne girerse, ikisi de yeni nesne oluşturabilir.

Bunun sonucunda Singleton özelliği bozulur.

Bu nedenle gerçek uygulamalarda:

- `synchronized`
- Lock mekanizmaları
- Double Checked Locking
- Bill Pugh Singleton
- Enum Singleton

gibi thread-safe çözümler tercih edilir.

---

## 2. Test Edilebilirlik Sorunu

Singleton sınıfları global state taşıdığı için unit test yazmayı zorlaştırabilir.

Örneğin:

- Bir test Singleton'ın içindeki veriyi değiştirir.
- Sonraki test aynı nesneyi kullandığı için beklenmeyen sonuçlar oluşabilir.

Yani testler birbirini etkileyebilir.

---

## 3. Aşırı Kullanım Riski

Singleton'a her yerden kolay erişilebildiği için şu hataya düşülebilir:

> "Her sınıfı Singleton yapayım."

Bu yaklaşım:

- Bağımlılıkları gizler.
- Modülerliği azaltır.
- Kodun bakımını zorlaştırır.

Bu nedenle birçok yazılımcı Singleton'ı bazı durumlarda **Anti-Pattern** olarak da değerlendirir.

Singleton yalnızca gerçekten **tek bir nesnenin var olması gerektiği** durumlarda kullanılmalıdır.

---

# Özet

Singleton Pattern'in temel amacı şudur:

> "Bu nesneden uygulama boyunca yalnızca bir tane olmalı ve herkes aynı nesneyi kullanmalı."

Bu sayede:

- Gereksiz nesne oluşturulmaz.
- Kaynak kullanımı azalır.
- Uygulama genelinde ortak bir erişim noktası sağlanır.

Ancak;

- Thread Safety,
- Test edilebilirlik
- ve aşırı kullanım

gibi konular göz önünde bulundurularak dikkatli kullanılmalıdır.

Readonly, veya set edilmeyecek yerlerde kullanılması mantıklı