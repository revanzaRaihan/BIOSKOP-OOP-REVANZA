package bioskopOOP;

public class Bayar {
    private double totalHarga;
    private double uangBayar;

    public Bayar(double totalHarga, double uangBayar){
        this.totalHarga = totalHarga;
        this.uangBayar = uangBayar;
    }

    public double hitungKembalian(){
        return uangBayar - totalHarga;
    }
}
