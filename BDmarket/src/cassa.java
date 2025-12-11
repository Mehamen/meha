public class cassa {
    private int id_cassa;
    private String naim;
    private String adres;

    public cassa(int id_cassa, String naim, String adres) {
        this.id_cassa = id_cassa;
        this.naim = naim;
        this.adres = adres;
    }

    // Конструктор без id — для вставки
    public cassa(String naim, String adres) {
        this.naim = naim;
        this.adres = adres;
    }

    public int getId_cassa() {
        return id_cassa;
    }

    public String getNaim() {
        return naim;
    }

    public String getAdres() {
        return adres;
    }

    public void setNaim(String naim) {
        this.naim = naim;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
