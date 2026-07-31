# Prototype Pattern Nedir?
Prototype,yeni bir nesne oluştururken sıfırdan `new` ile inşa etmek yerine,var olan
bir nesneyi kopyalayarak (clone'layarak) yeni nesne üretme yöntemidir. Yani "bir şablon nesnen var,
ondan aynısını çoğalt" mantığı.

# Neden İhtiyaç Duyulur ?

Bazı nesneleri sıfırdan oluşturmak maliyetlidir veya karmaşıktır.

- Ağır işlem gerektiren nesneler:Bir nesne oluştururken veritabanından veri çekiliyor,
  dosyalardan okuma yapılıyor veya karmaşık hesaplamalar yapılıyorsa, her seferinde sıfırdan
  oluşturmak yavaş olur.Var olan bir nesneyi kopyalamak çok daha hızlıdır.
- Karmaşık nesne yapıları: Bir nesnenin çok fazla alanı (field) varsa ve bunların çoğu zaten aynı kalacaksa,
  her seferinde tüm bu alanları tek tek doldurmak yerine, mevcut bir nesneyi kopyalayıp sadece farklı olan birkaç alanı değiştirmek daha pratiktir.
- Runtime'da nesne türü belirsizse: Bazen hangi sınıftan nesne oluşturacağınızı derleme zamanında değil, çalışma zamanında (runtime) bilirsiniz. 
  Elinizde bir nesne varsa, onun clone() metodunu çağırarak aynı türden yeni bir kopya alabilirsiniz — hangi sınıf olduğunu bilmenize bile gerek kalmaz.

# Nasıl çalışır?
1. Kopyalanabilir olma özeliği:Sınıf kendisinin kopyalanabileceğini belirtir.
2. Klonlama metodu:Sınıfın içinde,kendi kopyasını oluşturup döndüren bir metod bulunur.Bu metot çağırldığında:
   - Mevcut alanın tüm değerlerini okur
   - Bu değerlerle yeni bir nesne oluşturulur 
   - Yeni nesne orjinaliyle aynı veriye sahip ama bellleğin farkli bir yerinde duran bağımsız bir nesnedir.
3. Kullanım:İhtiyaç duyulduğunda,sıfırdan nesne oluşturmak yerine var olan "prototip" nesne üzerinden clone() çağrılır ve yeni kopya elde edilir

# Önemli Ayrım: Shallow vs Deep Copy
Bu Prototype pattern'da en önemli konudur:
- Shallow Copy(Sığ kopya):Nesnenin basit alanları(sayı,string gibi) kopyalanır, ama nesnenin içinde başka bir nesneye referans
varsa(örneğin bir liste veya başa bir obje),o referans aynısı kopyalanır.
Yani orijinal ve kopya, aynı iç nesneyi paylaşmaya devam eder. Birini değiştirirsen diğeri de etkilenir — bu istenmeyen bir durum olabilir.

- Deep Copy (derin kopya): Nesnenin içindeki referans tipi alanlar da kendi içinde yeniden oluşturulur. Yani orijinal ile kopya tamamen bağımsız hale gelir; 
biri değişirse diğeri etkilenmez.

Prototype pattern kullanırken hangi tür kopyalamaya ihtiyacınız olduğuna dikkatle karar vermek gerekir — çoğu gerçek dünya hatası burada, 
yanlışlıkla shallow copy yapıp içteki nesnelerin paylaşılmasından kaynaklanır.

# Nerelerde Kullanılır ?
- Grafik/oyun uygulamaları: Aynı türden birçok nesne (örneğin bir oyun karakterinin düşman kopyaları) oluşturulacaksa, her birini sıfırdan kurmak yerine bir prototipten kopyalanır.
- Belge/şablon sistemleri: Bir şablon belge var, kullanıcı her yeni belge oluşturduğunda şablon kopyalanıp üzerinde değişiklik yapılır (örnekte gösterdiğim gibi).
- Konfigürasyon nesneleri: Varsayılan bir ayar nesnesi var, farklı senaryolar için bu nesne kopyalanıp sadece birkaç alanı değiştirilir.

# Singleton ile Karşılaştırma (Farkı Netleştirmek İçin)
Singleton: "Bu nesneden sadece bir tane olsun, herkes aynısını kullansın."
Prototype: "Bu nesneden istediğin kadar kopya oluşturabilirsin, ama sıfırdan değil, var olan bir örnekten çoğaltarak."