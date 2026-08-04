package com.strucuralPatterns.adapter.example2;

public class EskiBankaAdapter implements OdemeSistemi{
    private EskiBankaAPI eskiBanka;
    private String hesapNo;
    private String paraBirimi;

    public EskiBankaAdapter() {
        this.eskiBanka = new EskiBankaAPI();
        this.hesapNo = "TR123456789"; // sabit hesap no
        this.paraBirimi = "TRY";      // sabit para birimi
    }

    @Override
    public void odemeYap(double tutar) {
        eskiBanka.islemBaslat(hesapNo, tutar, paraBirimi);
    }

}
