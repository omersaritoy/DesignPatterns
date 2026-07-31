# Factory Method Pattern Nedir?

Factory Method,nesne oluşturma işini bir alt sınıfa devreden bir creational pattern'dir.
Ana fikir:"Hangi sınıftan nesne oluşturuacağına, doğrudan new ile karar vermek yerine, bunu bir fabrika metoduna bırak"

# Neden İhtiyaç Duyulur?
Diyelim ki bir uygulamada farklı türde nesneler oluşturman gerekiyor 
(örneğin farklı bildirim türleri: Email, SMS, Push bildirim). 
Eğer kodun her yerinde şöyle yazarsan:  

            if (tur.equals("email")) {
                bildirim = new EmailBildirim();
            } else if (tur.equals("sms")) {
                bildirim = new SmsBildirim();
            }
Bu kod, her yeni bildirim türü eklediğinde her yerde değiştirilmesi gereken bir yapı oluşturur. Ayrıca istemci kod 
(bu if-else'i yazan kod), somut sınıfları (EmailBildirim, SmsBildirim) doğrudan bilmek zorunda kalır — bu da sıkı bağımlılık (tight coupling) yaratır.
Factory Method bu sorunu şöyle çözer: nesne oluşturma mantığını tek bir yere (fabrika metoduna) topla, 
istemci kod sadece "bana bir bildirim ver" desin, hangi somut sınıfın oluşturulacağını bilmesin.

# Nasıl Çalışır? (Mantık)
1. Ortak bir arayüz/soyut sınıf tanımlanır -- oluşturalacak tüm nesneler uyacağı ortak davranış (örneğin Bildirim arayüzü, gonder() metodu ile).
2. Her somut tür, bu arayüzü kendi şekilde implemente eder (örneğin EmailBildirim, SmsBildirim sınıfları, kendi gonder() mantıklarıyla).
3. Bir "Factory" (fabrika) sınıfı veya metodu tanımlanır. Bu metod, dışarıdan aldığı bir parametreye (örneğin bir tür bilgisi) göre, 
hangi somut sınıfın oluşturulacağına karar verir ve ortak arayüz tipinden bir nesne döndürür.
4. İstemci kod sadece fabrika metodunu çağırır, geriye dönen nesnenin gerçekte hangi somut sınıf olduğunu bilmesine 
gerek kalmaz — sadece ortak arayüzü (Bildirim gibi) kullanarak işlemine devam eder.

# Sağladığı Avantajlar 
- Gevşek bağlılık (loose coupling): İstemci kod, somut sınıflara değil, sadece ortak arayüze bağımlı olur.
- Genişletilebilirlik (Open/Closed Prensibi): Yeni bir tür eklemek istediğinde (örneğin PushBildirim), mevcut istemci kodu değiştirmen gerekmez — sadece yeni sınıfı yazıp fabrikaya bir satır eklersin.
- Merkezi kontrol: Nesne oluşturma mantığı tek bir yerde toplandığı için bakım kolaylaşır.

# Prototype/Builder ile Farkı
- Builder: "Karmaşık bir nesneyi adım adım kur." (Tek bir sınıfın farklı konfigürasyonlarını oluşturmak için)
- Prototype: "Var olan bir nesneyi kopyala."
- Factory Method: "Ortak bir arayüze uyan farklı sınıflardan hangisinin oluşturulacağına, bir parametreye göre karar ver." (Farklı türde ama ortak davranışlı nesneler arasında seçim yapmak için)

# Nerelerde Kullanılır?
- Bildirim sistemleri: Email/SMS/Push bildirimlerinden hangisinin gönderileceğine karar veren sistemler.
- Ödeme sistemleri: Kredi kartı, PayPal, havale gibi farklı ödeme yöntemlerini ortak bir arayüz üzerinden yöneten sistemler.
- UI bileşenleri: Farklı işletim sistemlerine göre (Windows/Mac) farklı buton/pencere nesneleri oluşturan sistemler.
- Doküman işleme: PDF, Word, Excel gibi farklı doküman türlerini ortak bir arayüzle işleyen sistemler.
