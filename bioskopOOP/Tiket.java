package bioskopOOP;

public class Tiket {
    private int jumlahTiket;
    private Film film;

    public Tiket(int jumlahTiket, Film film){
        this.jumlahTiket = jumlahTiket;
        this.film = film;
    }

    public double hitungTotal(){
        double total = film.getHarga() * jumlahTiket;
        return total;
    }
}
