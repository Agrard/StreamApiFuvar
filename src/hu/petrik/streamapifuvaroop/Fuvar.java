package hu.petrik.streamapifuvaroop;

public class Fuvar {
    private int taxiAzonosito;
    private String indulasIdopont;
    private int utazasIdotartama;
    private double meglettTavolsag;
    private double vetelDij;
    private double borravalo;
    private String fizetesModja;

    public Fuvar(int taxiAzonosito, String indulasIdopont, int utazasIdotartama, double meglettTavolsag, double vetelDij, double borravalo, String fizetesModja) {
        this.taxiAzonosito = taxiAzonosito;
        this.indulasIdopont = indulasIdopont;
        this.utazasIdotartama = utazasIdotartama;
        this.meglettTavolsag = meglettTavolsag;
        this.vetelDij = vetelDij;
        this.borravalo = borravalo;
        this.fizetesModja = fizetesModja;
    }

    public int getTaxiAzonosito() {
        return taxiAzonosito;
    }

    public String getIndulasIdopont() {
        return indulasIdopont;
    }

    public int getUtazasIdotartama() {
        return utazasIdotartama;
    }

    public double getMeglettTavolsag() {
        return meglettTavolsag;
    }

    public double getVetelDij() {
        return vetelDij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public String getFizetesModja() {
        return fizetesModja;
    }

    public double getBevetel(){
        return vetelDij + borravalo;
    }

    public double getArany(){
        return borravalo/vetelDij;
    }

    @Override
    public String toString() {
        return "Fuvar{" +
                "taxiAzonosito=" + taxiAzonosito +
                ", indulasIdopont='" + indulasIdopont + '\'' +
                ", utazasIdotartama=" + utazasIdotartama +
                ", meglettTavolsag=" + meglettTavolsag +
                ", vetelDij=" + vetelDij +
                ", borravalo=" + borravalo +
                ", fizetesModja='" + fizetesModja + '\'' +
                '}';
    }


}
