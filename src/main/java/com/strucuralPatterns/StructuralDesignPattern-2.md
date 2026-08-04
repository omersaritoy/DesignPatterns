# Adapter Pattern Nedir?

Uyumsuz iki arayüzü bir birine bağlayan bir köprü görevi görür.Elinde var olan bir sınıf var, ama bu sınıf arayüzü, senin siteminin
beklediği arayüze uymuyor.Adapter,bu iki farklı arayüz arasında bir çevirici (dönüştürücü) görevi görür.

# Günlük Hayattan Bir Benzetme
Türkiye'den Amerika'ya seyahat ettiğini düşün. Elektrikli cihazının fişi Türk prizine uygun ama Amerikan prizi farklı. 
Cihazını değiştirmiyorsun, prizi de değiştiremiyorsun — aralarına bir "adaptör" koyuyorsun. 
Adaptör, iki farklı standardı birbirine uydurur; cihaz ve priz kendileri değişmez.

Yazılımda da mantık aynıdır: var olan bir sınıfı değiştirmeden, onu beklenen arayüze uydurmak.

# Neden İhtiyaç Duyulur?
1. Üçüncü parti / eski (legacy) kod ile çalışırken: Kullandığın bir kütüphanenin sınıfı, senin sisteminin beklediği arayüze uymuyor olabilir.
   O kütüphanenin kaynak kodunu değiştiremezsin (senin değil, ya da riskli). Adapter, bu sınıfı değiştirmeden, senin sistemine uydurur.
2. İki farklı sistemi birbirine bağlarken: Örneğin eski bir ödeme sisteminin arayüzü ile yeni bir e-ticaret sisteminin beklediği arayüz farklı olabilir.
   İkisini birbirine entegre etmen gerekiyor ama her ikisini de değiştirmek istemiyorsun (biri eski, kararlı ve dokunulmaması gereken bir sistem olabilir).
3. Var olan kodu bozmadan yeni bir standarda geçerken: Sistemin yeni bir arayüz/standart kullanmaya başladı ama eski sınıflar hâlâ eski arayüze göre yazılmış.
   Her birini tek tek değiştirmek yerine, aralarına adapter koyarak eski kodu olduğu gibi kullanmaya devam edebilirsin.


# Nasıl Çalışır? (Mantık) 
1. Target (Hedef Arayüz): İstemci kodun beklediği, kullanmak istediği arayüz.
2. Adaptee (Uyarlanacak Sınıf): Var olan, ama Target arayüzüne uymayan sınıf. Bu sınıfın kendi metod isimleri, kendi çalışma şekli var — ve biz bunu değiştiremiyoruz.
3. Adapter: Target arayüzünü implemente eden, ama içeride Adaptee'nin metodlarını çağıran bir sınıf. Yani dışarıdan bakıldığında Target arayüzüne uyuyor gibi görünür, ama arka planda gerçek işi Adaptee'ye devrediyor.

İstemci kod, sadece Target arayüzünü bilir ve kullanır. Adapter'in arkasında hangi Adaptee'nin çalıştığını bilmesine gerek yoktur.

İki Türü Vardır (Kısaca)

Object Adapter (Kompozisyon ile): Adapter, Adaptee nesnesini kendi içinde bir alan olarak tutar ve metod çağrılarını ona yönlendirir. Java'da (çoklu kalıtım desteklenmediği için) en yaygın kullanılan türdür.
Class Adapter (Kalıtım ile): Adapter, hem Target'ı implemente eder hem de Adaptee'den kalıtım alır. Java'da bu, sadece Adaptee bir interface ise mümkündür (çünkü Java'da bir sınıf sadece bir sınıftan kalıtım alabilir).

Pratikte Java'da genelde Object Adapter tercih edilir çünkü daha esnektir (kalıtımın katılığından kaçınır).

Facade ile Karıştırılmaması Gereken Nokta


Bu ikisi sıkça karıştırılır, hemen ayrımını netleştirelim

Adapter: "Var olan bir arayüzü, beklenen başka bir arayüze dönüştürür." Amaç uyumluluk sağlamak.
Facade: "Karmaşık bir sistemi, daha basit bir arayüz arkasında gizler." Amaç basitleştirmek, uyumluluk sağlamak değil.

Yani Adapter "bu iki parça birbirine uymuyor, aralarına köprü kurayım" derken, Facade "bu sistem çok karmaşık, üstüne basit bir kapı koyayım" der.

# Nerelerde Kullanılır?

Java'nın kendi kütüphanesinde: Arrays.asList() bir dizi (array) alır ve onu List arayüzüne uyarlar.
Ödeme sistemi entegrasyonları: Farklı bankaların/ödeme sağlayıcılarının API'lerini, kendi sistemindeki ortak OdemeSaglayici arayüzüne uydurmak.
Eski (legacy) sistemlerin yeni sistemlere entegrasyonu: Örneğin eski bir XML tabanlı servisin çıktısını, yeni sistemin beklediği JSON tabanlı arayüze uydurmak.
Farklı log kütüphanelerini ortak bir arayüz arkasında birleştirmek: SLF4J tam olarak bunu yapar — Log4j, Logback gibi farklı log kütüphanelerini ortak bir arayüz arkasında adapte eder.

