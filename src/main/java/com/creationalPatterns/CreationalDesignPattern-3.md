# Builder Pattern Nedir?

Builder karmaşık bir nesneyi adım adım inşa etmeyi sağlayan creational patterndir.
Özellikle bir nesnenin çok fazla alanı(özelliği) varsa ve bunların bir kısmı zorunluluk bir kısmı
opsiyonel ise kullanılır.



# Neden İhtiyaç Duyulur?

Diyelim ki bir Ev sınıfın var ve şunları içeriyor: oda_sayisi, banyo_sayisi, bahce_var_mi, garaj_var_mi, havuz_var_mi, kat_sayisi...
Bu kadar çok parametreli bir constructor yazmaya kalkarsan şöyle bir şey ile karşılaşırsın 

    Ev ev = new Ev(3, 2, true, false, true, 2, false, true, ...);

Bu satıra bakan biri, hangi true'nun neyi ifade ettiğini anlayamaz. Buna literatürde "telescoping constructor" (teleskopik constructor) 
problemi denir — parametre sayısı arttıkça constructor'lar okunmaz ve hataya açık hale gelir.

Alternatif olarak her kombinasyon için ayrı constructor yazmayı düşünebilirsin (bahçeli, bahçesiz, havuzlu, havuzsuz...) 
ama bu da kombinasyon sayısı arttıkça yönetilemez hale gelir.

Builder pattern tam olarak bu sorunu çözer.

# Nasıl Çalışır?(Mantık)
1. Ana nesnenin constructor'ı gizlenir (genelde private yapılır), böylece dışarıdan direkt new ile karmaşık şekilde oluşturulamaz.
2. Ayrı bir "Builder" sınıfı tanımlanır. Bu sınıf, ana nesnenin alanlarını adım adım, metot zincirleme (method chaining) yoluyla ayarlamanı sağlar. Her metot,
"kendini" (this/builder nesnesini) geri döndürür — böylece art arda çağrı yapılabilir.
3. Builder üzerinde istediğin alanları ayarladıktan sonra, en son bir build() metodu çağrılır. Bu metod, o ana kadar ayarlanan değerlerle gerçek nesneyi oluşturup döndürür.

Sonuç olarak kullanım şöyle bir hale gelir:

            Ev ev = new Ev.Builder()
            .odaSayisi(3)
            .bahceEkle(true)
            .havuzEkle(true)
            .build();
Bu satırı okuyan herkes, hangi değerin ne anlama geldiğini hemen anlar. Ayrıca sadece istediğin alanları set edip diğerlerini varsayılan (default) bırakabilirsin.

# Builder'ın Sağladığı Avantajlar
- Okunabilirlik: Metot isimleri sayesinde hangi parametrenin ne olduğu açıkça görülür.
- Esneklik: Zorunlu olmayan alanları atlayabilirsin; sırayı değiştirebilirsin.
- Değişmezlik (immutability) imkanı: Nihai nesne genelde build() çağrıldıktan sonra değiştirilemez hale getirilir (tüm alanlar final yapılabilir), bu da nesneyi güvenli hale getirir.
- Doğrulama (validation) imkanı: build() metodu içinde, nesne oluşturulmadan önce zorunlu alanların dolu olup olmadığı kontrol edilebilir (örneğin "oda sayısı olmadan ev oluşturulamaz" gibi bir kural koyabilirsin).

# Singleton ve Prototype Farkı 
- Singleton: Bu nesneden sadece bir tane olsun
- Prototype: Var olan nesneyi kopyalayarak yenisini oluşturur
- Builder: Karmaşık bir nesneyi adım adım okunabilir şekilde inşa et - sıfırdan da olabilir,
tek seferlik de olabilir , kopyalama değil , kurulum söz konusu

# Nerelerde Kullanılır?
- Çok parametreli konfigürasyon nesneleri: Örneğin bir HTTP isteği oluşturan RequestBuilder (URL, header, body, timeout gibi birçok opsiyonel alan).
- UI bileşenleri: Bir dialog/pencere oluştururken başlık, buton, ikon gibi birçok opsiyonel özelliğin adım adım ayarlanması.
- SQL sorgu oluşturucular: SELECT, WHERE, ORDER BY gibi parçaları zincirleme şekilde ekleyen query builder'lar.
- Yemek sipariş sistemleri: Bir hamburger/pizza siparişinde temel + opsiyonel malzemelerin adım adım eklenmesi.

