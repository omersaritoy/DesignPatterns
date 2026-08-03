# Design Patterns – Java Örnekleri

Bu repo, **Gang of Four (GoF) Design Patterns**'ın Java ile yazılmış, açıklamalı ve çalıştırılabilir örneklerini içerir. Amaç, her pattern'i sadece kod olarak değil, **neden var olduğu, hangi problemi çözdüğü ve gerçek dünyada (Java standart kütüphanesi, Spring Boot vb.) nerede kullanıldığı** ile birlikte anlamaktır.

## 📚 İçindekiler

- [Genel Bakış](#-genel-bakış)
- [Creational Patterns (Yaratımsal)](#-creational-patterns-yaratımsal)
- [Structural Patterns (Yapısal)](#-structural-patterns-yapısal)
- [Behavioral Patterns (Davranışsal)](#-behavioral-patterns-davranışsal)
- [Proje Yapısı](#-proje-yapısı)
- [Nasıl Çalıştırılır](#-nasıl-çalıştırılır)
- [Katkıda Bulunma](#-katkıda-bulunma)

---

## 🧭 Genel Bakış

Design pattern'ler (tasarım desenleri), yazılım geliştirmede **sık karşılaşılan problemlere**, defalarca test edilmiş, tekrar kullanılabilir çözüm şablonlarıdır. GoF kitabında bu pattern'ler 3 ana kategoriye ayrılır:

| Kategori | Odaklandığı Soru | Örnek Pattern'ler |
|---|---|---|
| **Creational** | Nesne **nasıl oluşturulur**? | Singleton, Factory Method, Abstract Factory, Builder, Prototype |
| **Structural** | Nesneler/sınıflar **nasıl bir araya getirilir**? | Adapter, Decorator, Facade, Composite, Proxy, Bridge, Flyweight |
| **Behavioral** | Nesneler **birbiriyle nasıl iletişim kurar/davranır**? | Strategy, Observer, Command, State, Template Method, Iterator, Chain of Responsibility, Mediator, Memento, Visitor |

Her pattern klasörü şu formatta hazırlanmıştır:
- Kavramsal açıklama (README veya yorum satırları içinde)
- Sorunlu/naif kod örneği (pattern kullanılmadan önceki hal)
- Pattern uygulanmış çözüm
- Çalıştırılabilir `Demo`/`Main` sınıfı

---

## 🏗️ Creational Patterns (Yaratımsal)

Nesne oluşturma sürecini esnek, yeniden kullanılabilir ve kodun geri kalanından bağımsız hale getirmeyi amaçlar.

| Pattern | Ne İşe Yarar | Gerçek Dünya Örneği |
|---|---|---|
| **Singleton** | Bir sınıftan yalnızca bir nesne oluşturulmasını garanti eder | `Runtime.getRuntime()`, Spring bean'lerinin varsayılan scope'u |
| **Factory Method** | Nesne oluşturma işini alt sınıflara/fabrika metoduna bırakır | `Calendar.getInstance()`, `Collection.iterator()` |
| **Abstract Factory** | Birbiriyle ilişkili nesne ailelerini tutarlı şekilde üretir | `DocumentBuilderFactory`, Swing Look & Feel sistemi |
| **Builder** | Karmaşık bir nesneyi adım adım, okunabilir şekilde inşa eder | `StringBuilder`, Lombok `@Builder`, `WebClient.builder()` |
| **Prototype** | Var olan bir nesneyi kopyalayarak (clone) yeni nesne üretir | `Object.clone()` / `Cloneable` |

📁 Klasör: `/creational`

---

## 🧩 Structural Patterns (Yapısal)

Sınıfları ve nesneleri, daha büyük ve esnek yapılar oluşturacak şekilde bir araya getirmeyi amaçlar.

| Pattern | Ne İşe Yarar |
|---|---|
| **Adapter** | Uyumsuz iki arayüzü birbirine köprüler; var olan bir sınıfı, beklenen arayüze uydurur |
| **Decorator** | Bir nesneye, kalıtım kullanmadan çalışma zamanında ek davranış/özellik ekler |
| **Facade** | Karmaşık bir alt sistemi, basit ve tek bir arayüz arkasında gizler |
| **Composite** | Nesneleri ağaç yapısında gruplar; tekil nesne ile grup nesne aynı arayüzden yönetilir |
| **Proxy** | Bir nesneye erişimi kontrol eden, onun yerine geçen bir vekil nesne sağlar |
| **Bridge** | Soyutlama ile implementasyonu birbirinden ayırarak ikisinin bağımsız değişmesini sağlar |
| **Flyweight** | Çok sayıda benzer nesnenin bellek kullanımını, paylaşılan veriyle azaltır |

📁 Klasör: `/structural`

---

## 🎭 Behavioral Patterns (Davranışsal)

Nesneler arasındaki sorumluluk dağılımını ve iletişim şeklini düzenler.

| Pattern | Ne İşe Yarar |
|---|---|
| **Strategy** | Bir algoritma ailesini birbirinden bağımsız, değiştirilebilir hale getirir |
| **Observer** | Bir nesnedeki değişikliği, ona bağlı diğer nesnelere otomatik olarak bildirir |
| **Command** | Bir isteği/işlemi, geri alınabilir/kuyruğa alınabilir bir nesneye dönüştürür |
| **State** | Bir nesnenin davranışını, iç durumuna (state) göre değiştirir |
| **Template Method** | Bir algoritmanın iskeletini tanımlar, bazı adımlarını alt sınıfa bırakır |
| **Iterator** | Bir koleksiyonun elemanlarına, iç yapısını ifşa etmeden sırayla erişim sağlar |
| **Chain of Responsibility** | Bir isteği, işleyebilecek nesneye ulaşana kadar bir zincir boyunca iletir |
| **Mediator** | Nesneler arası doğrudan iletişimi azaltıp, merkezi bir aracı üzerinden yönetir |
| **Memento** | Bir nesnenin durumunu, kapsülleme bozulmadan kaydedip geri yükler |
| **Visitor** | Bir nesne yapısı üzerinde, yapıyı değiştirmeden yeni işlemler tanımlamayı sağlar |

📁 Klasör: `/behavioral`

---

## 📂 Proje Yapısı

```
design-patterns/
│
├── creational/
│   ├── singleton/
│   ├── factorymethod/
│   ├── abstractfactory/
│   ├── builder/
│   └── prototype/
│
├── structural/
│   ├── adapter/
│   ├── decorator/
│   ├── facade/
│   ├── composite/
│   ├── proxy/
│   ├── bridge/
│   └── flyweight/
│
├── behavioral/
│   ├── strategy/
│   ├── observer/
│   ├── command/
│   ├── state/
│   ├── templatemethod/
│   ├── iterator/
│   ├── chainofresponsibility/
│   ├── mediator/
│   ├── memento/
│   └── visitor/
│
└── README.md

## 📖 Kaynaklar

- *Design Patterns: Elements of Reusable Object-Oriented Software* – Gang of Four (Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides)
- [Refactoring.Guru – Design Patterns](https://refactoring.guru/design-patterns)
