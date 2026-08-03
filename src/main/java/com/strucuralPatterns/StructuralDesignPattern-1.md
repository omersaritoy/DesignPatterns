# Structural Pattern (Yapısal Tasarım Deseni) Nedir?
Nesneler arasındaki ilişkileri ve bu ilişkileri organize etmek için çözümler sunan patternlerdir.

# Ne Değildir?
Bunu netleştirmek önemli, çünkü bazen creational veya behavioral pattern'lerle karıştırılır:
- Structural pattern, yeni bir nesnenin nasıl oluşturulacağını anlatmaz (bu creational'ın işi). 
Structural pattern'de nesneler zaten var, biz onları nasıl bir araya getireceğimizle ilgileniyoruz.
- Structural pattern, nesnelerin birbirine nasıl mesaj gönderdiğini / davranış akışını yönetmez 
(bu behavioral'ın işi — örneğin "A nesnesi B'ye bir olay bildirsin" gibi konular Observer'ın işi, structural'ın değil).
- Structural pattern, genelde kalıtım (inheritance) yerine kompozisyon (composition) tercih eder — yani "IS-A" (X, Y'dir) 
yerine "HAS-A" (X, Y'ye sahiptir) ilişkisini kullanmayı teşvik eder.


# Neden İhtiyaç Duyulur?
Gerçek projelerde sık karşılaşılan şu problemler var:
1. Uyumsuz arayüzler: Elindeki bir sınıf, ihtiyacın olan arayüze uymuyor (örneğin eski bir kütüphane sınıfı ile yeni sistemin beklediği arayüz farklı). 
Bunu kalıtımla çözmeye kalkarsan kod karmaşıklaşır, çünkü o sınıfı değiştiremezsin (belki senin kodun bile değil).
2. Kalıtımın katılığı: Diyelim ki bir Kahve sınıfın var, üzerine "süt ekle", "şeker ekle", "karamel ekle" gibi opsiyonel özellikler eklemek istiyorsun. 
Eğer her kombinasyon için ayrı bir alt sınıf yazarsan (SütlüKahve, SütlüSekerliKahve, SütlüSekerliKaramelliKahve...), kombinasyon sayısı arttıkça sınıf patlaması (class explosion) yaşarsın.
3. Karmaşık alt sistemlere basit erişim ihtiyacı: Bir sistemin içinde onlarca sınıf, servis, adım varsa, bunları kullanan kod da bu karmaşıklığı bilmek zorunda kalır. 
Oysa çoğu zaman istemci kodun sadece "şunu yap" demesi yeterli olmalı, arka planda ne kadar çok bileşen olduğunu bilmesine gerek yok.
4. Ağaç/hiyerarşi yapıları: Bir dosya sistemi düşün — klasörler içinde klasörler, dosyalar var. 
Tek bir dosyayı da, bir klasörü de (içindeki her şeyle birlikte) aynı şekilde işlemek istiyorsan, bunu nasıl modelleyeceksin?
5. Kaynak/performans kaygısı: Binlerce benzer nesne oluşturman gerekiyorsa (örneğin bir oyunda binlerce ağaç objesi), 
her birini ayrı ayrı bellekte tutmak yerine ortak veriyi paylaştırmak isteyebilirsin.
6. Erişim kontrolü / ek katman ihtiyacı: Bir nesneye doğrudan erişmek yerine, araya bir "vekil" koyup erişimi kontrol etmek (yetkilendirme, lazy loading, loglama gibi) isteyebilirsin.

Structural pattern'lerin her biri, bu problemlerden birine özel bir çözüm sunar. Kısa özet:

Pattern	Çözdüğü Problem:
Adapter	Uyumsuz arayüzleri birbirine uydurma
Decorator	Kalıtım kullanmadan, çalışma zamanında nesneye ek davranış ekleme
Facade	Karmaşık bir alt sistemi basit, tek bir arayüz arkasında gizleme
Composite	Tekil nesne ile nesne grubunu aynı arayüzden, ağaç yapısında yönetme
Proxy	Bir nesneye erişimi kontrol eden vekil nesne koyma
Bridge	Soyutlama ile implementasyonu ayırıp bağımsız değiştirebilme
Flyweight	Çok sayıda benzer nesnenin ortak verisini paylaştırıp bellek tasarrufu sağlama

Creational ile Kıyaslama (Farkı Netleştirmek İçin)
Creational: "Bu nesneyi nasıl oluşturayım?" (Singleton, Factory, Builder...)
Structural: "Elimde zaten olan nesneleri nasıl bir araya getireyim/organize edeyim?" (Adapter, Decorator, Facade...)

Yani creational pattern'ler bittiğinde elinde nesneler var; structural pattern'ler ise bu nesnelerin birbiriyle nasıl bir yapı kurduğuyla ilgilenir.

