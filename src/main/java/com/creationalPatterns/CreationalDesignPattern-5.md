# Abstract Factory Pattern Nedir?

Abstract factory, birbiriyile ilişkili nesene ailelerini oluşturmak için kullanılan bir creational pattern'dir.
Factory methodun bir üst seviyesi gibi düşünülebilir.Factory tek bir nesene üretirken, Abstract factory birden fazla 
ilişkili nesenyi bir arada, tutarlı bir şekilde üretir.

# Neden İhtiyaç Duyulur?
Diyelim ki bir UI kütüphanesi yazıyorsun ve hem Windows hem Mac için bileşenler üretmen gerekiyor: Buton, CheckBox, ScrollBar gibi. 
Önemli olan şu: Eğer Windows Buton kullanıyorsan, aynı zamanda Windows CheckBox da kullanmalısın — Windows butonuyla Mac checkbox'ını karıştırmak istemezsin, 
çünkü bunlar bir "aile" oluşturuyor ve tutarlı olmaları gerekiyor.

Eğer bunu Factory Method ile ayrı ayrı çözmeye kalkarsan (bir ButonFactory, ayrı bir CheckBoxFactory...),
bu ailelerin tutarlılığını garanti edemezsin — biri yanlışlıkla Windows Buton + Mac CheckBox seçebilir. Abstract Factory, bu tutarlılığı tek bir fabrika üzerinden garanti eder.

# Nasıl Çalışır? (Mantık)
1. Her ürün türü için bir arayüz tanımlanır (örneğin Buton arayüzü, CheckBox arayüzü).
2. Her ürün türünün, her aile için somut bir implementasyonu olur (WindowsButon, MacButon, WindowsCheckBox, MacCheckBox gibi).
3. Soyut bir "Fabrika arayüzü" tanımlanır (GUIFactory gibi). Bu arayüz, ailedeki her ürün türü için bir oluşturma metodu içerir (butonOlustur(), checkBoxOlustur() gibi).
4. Her aile için somut bir fabrika sınıfı yazılır (WindowsFactory, MacFactory). Bu sınıflar, GUIFactory arayüzünü implemente eder ve kendi ailesine ait doğru ürünleri döndürür.
5. İstemci kod, sadece bir fabrika seçer (mesela işletim sistemine göre WindowsFactory ya da MacFactory), ve o fabrika üzerinden tüm ürünleri alır. 
Böylece hangi somut sınıfları kullandığını bilmesine bile gerek kalmaz — ve yanlışlıkla farklı ailelerden ürün karıştırma riski ortadan kalkar.

# Factory Method ile Temel Fark
Factory Method: Tek bir ürün türü için, hangi somut sınıfın oluşturulacağına karar verir. ("Bana bir Bildirim ver, email mi sms mi sen karar ver.")

Abstract Factory: Birden fazla ilişkili ürün türü için, hepsini aynı aileden tutarlı şekilde üretir. 
("Bana Windows'a ait TÜM UI bileşenlerini ver — buton da, checkbox da, hepsi Windows uyumlu olsun.")

# Sağladığı Avantajlar
Aile tutarlılığı garantisi: Yanlışlıkla birbiriyle uyumsuz ürünlerin (Windows buton + Mac checkbox) bir arada kullanılmasını engeller.
Kolay aile değişimi: Tüm uygulamanın Windows temasından Mac temasına geçmesi gerekiyorsa, sadece kullanılan fabrikayı değiştirmen yeterli — kod tabanının geri kalanına dokunmana gerek yok.
Gevşek bağlılık: İstemci kod, somut sınıflara değil, sadece soyut arayüzlere (Buton, CheckBox, GUIFactory) bağımlı.

# Nerelerde Kullanılır?
- Cross-platform UI kütüphaneleri: Windows/Mac/Linux için tutarlı bileşen setleri üretmek.
- Veritabanı sürücüleri: MySQL/PostgreSQL/Oracle için, her birinin kendi bağlantı, komut, transaction nesnelerini tutarlı şekilde üretmesi.
- Tema sistemleri: Açık tema/koyu tema gibi, birbiriyle uyumlu renk, ikon, font setlerini bir arada üretmek.
- Oyun geliştirme: Farklı "dünya" temaları için (Orman dünyası, Buz dünyası), o dünyaya ait düşman, eşya, arka plan gibi nesnelerin tutarlı şekilde üretilmesi.
