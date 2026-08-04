# Bridge Pattern Nedir?

Bridge, soyutlama (abstraction) ile implementasyonu birbirinden ayırarak, ikisinin bağımsız şekilde değişebilmesini sağlayan bir structural pattern'dir.
Yani bir sınıf hiyerarşisini, "ne yapıldığı" (abstraction) ve "nasıl yapıldığı" (implementation) olmak üzere
iki ayrı hiyerarşiye böler ve bunları bir "köprü" (bridge) ile birbirine bağlar.

# Ne Değildir? (Adapter ile Karıştırılmaması İçin)

Bu ikisi çok sık karıştırılır, hemen ayrımını netleştirelim:
Adapter, sonradan ortaya çıkan bir uyumsuzluğu çözer — elinde zaten var olan, değiştiremediğin bir sınıf var, onu beklenen arayüze uydurursun. Yani Adapter genelde geriye dönük (retrofit) bir çözümdür.
Bridge, daha en baştan, tasarım aşamasında düşünülür — "bu iki boyut (ne yapıldığı ve nasıl yapıldığı) ileride bağımsız olarak çoğalacak, o yüzden onları en baştan ayrı tutayım" der. Yani Bridge, proaktif (önleyici) bir tasarım kararıdır.

# Neden İhtiyaç Duyulur?
Diyelim ki bir şekil çizme uygulaması yapıyorsun. Hem farklı şekiller var (Daire, Kare) hem de farklı çizim yöntemleri var (VektorelCizim, RasterCizim). Eğer bunu tek bir kalıtım hiyerarşisiyle çözmeye kalkarsan:
        
    Sekil
    ├── VektorelDaire
    ├── RasterDaire
    ├── VektorelKare
    └── RasterKare
Şimdi üçüncü bir şekil (Ucgen) eklemek istediğinde, hem VektorelUcgen hem RasterUcgen yazman lazım. 
Dördüncü bir çizim yöntemi (3BoyutluCizim) eklediğinde ise tüm şekiller için yeni bir alt sınıf yazman gerekir. 
Bu, matematikte "kartezyen çarpım" gibi büyür: 3 şekil × 3 çizim yöntemi = 9 sınıf, 4 şekil × 4 çizim yöntemi = 16 sınıf... 
Buna "sınıf patlaması" (class explosion) denir.

Bridge, bu problemi iki boyutu birbirinden ayırarak çözer: Sekil hiyerarşisi kendi başına büyür, CizimYontemi hiyerarşisi kendi başına büyür,
ve Sekil, içinde bir CizimYontemi referansı tutarak (kalıtımla değil, kompozisyonla) onunla "köprülenir."

# Nasıl Çalışır? (Mantık)

1. Abstraction (Soyutlama): Üst seviye kavramı temsil eden sınıf/arayüz (örneğin Sekil). Bu sınıf, işin "ne" yapıldığı kısmını temsil eder.
2. Implementor (Uygulayıcı arayüzü): Alt seviyedeki, "nasıl yapıldığı" kısmını temsil eden ayrı bir arayüz (örneğin CizimYontemi).
3. Concrete Implementor'lar: Implementor arayüzünü implemente eden somut sınıflar (VektorelCizim, RasterCizim).
4. Refined Abstraction: Abstraction'ı genişleten somut sınıflar (Daire, Kare). Bunlar, kendi içlerinde bir Implementor referansı tutar — yani Daire sınıfı,
   hangi çizim yönteminin kullanılacağını kendi içinde saklıyor, ama bu yöntemi kendisi implemente etmiyor, sadece ona delege ediyor.

Kritik nokta: Abstraction (Sekil), Implementor'ı (CizimYontemi) kalıtımla değil, kompozisyonla (yani "has-a" ilişkisiyle, bir alan olarak) kullanır. 
İşte bu "köprü" (bridge) tam olarak budur — iki hiyerarşiyi birbirine bir referans üzerinden bağlamak.

# Sağladığı Avantajlar
- Sınıf patlamasını önler: N şekil + M çizim yöntemi olsa bile, N×M değil, sadece N+M sınıf yazman yeterli.
- Bağımsız genişleme: Yeni bir şekil eklemek, çizim yöntemlerini etkilemez; yeni bir çizim yöntemi eklemek, şekilleri etkilemez.
- Çalışma zamanında değiştirilebilirlik: Bir Daire nesnesinin çizim yöntemini, çalışma zamanında (runtime) değiştirebilirsin (çünkü kompozisyon, kalıtımdan daha esnektir)
  — örneğin aynı Daire nesnesi önce VektorelCizim ile, sonra RasterCizim ile çizilebilir.
  

# Nerelerde Kullanılır?
- JDBC: Connection, Driver arayüzleri — üst seviye JDBC API'si (Abstraction) ile alt seviye veritabanı sürücü implementasyonları (MySQL, PostgreSQL driver'ları — Implementor) birbirinden bağımsız olarak gelişir.
- UI framework'leri: Bir "Pencere" (Abstraction) kavramı ile, işletim sistemine özel "Pencere çizim motoru" (Implementor) ayrımı.
- Uzaktan kumanda / cihaz örneği (ders kitaplarında klasik örnek): UzaktanKumanda (Abstraction) — TV, Radyo gibi farklı cihazları (Implementor) kontrol edebilir; hem kumanda türleri hem cihaz türleri birbirinden bağımsız çoğalabilir.

