package bioskopOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bioskop {
    private List<Film> daftarFilm = new ArrayList<>();

    public void tambahFilm(Film film){
        daftarFilm.add(film);
    }

    public void tampilkanDaftarFilm(){
        System.out.println("Daftar Film");
        for (Film film : daftarFilm) {
            System.out.println(film.getId() + ". " + film.getJudul() + " - " + film.getHarga());
        }
    }

    public void prosesPembelian(){
        Scanner input = new Scanner(System.in);
        boolean lagi = true;
while (lagi) {
    

        tampilkanDaftarFilm();
        System.out.println("====================");
        System.out.print("Pilih ID Film: ");
        int idFilm = input.nextInt();

        System.out.print("Masukan Jumlah Tiket: ");
        int jumlahTiket = input.nextInt();

        Film pilih = null;
        for (Film film : daftarFilm) {
            if (film.getId() ==  idFilm) {
                pilih = film;
            }
        }
        if (pilih == null) {
            System.out.println("Film tidak ada.");
        }

        // objek tiket
        Tiket tiket = new Tiket(jumlahTiket, pilih);
        
        // hitung total
        double totalHarganya = tiket.hitungTotal();
        System.out.println("Total harganya : Rp. " + totalHarganya);

        // bayar
        System.out.print("Masukan uang pembayaran : Rp. ");
        double uangUser = input.nextDouble();

        // kembalian
        Bayar bayar = new Bayar(totalHarganya, uangUser);
        double kembalian = bayar.hitungKembalian();

        if (uangUser < 0) {
            System.out.println("Uang anda tidak cukup.");
        }else{
            System.out.println("Pembayaran berhasil. Kembalian : Rp. " + kembalian);
        }
        System.out.print("Apakah anda ingin membeli tiket lagi? (y/n) : ");
        String jawab = input.next();
        System.out.println("====================");
        lagi = jawab.equalsIgnoreCase("y");
    }
    System.out.println("Terima kasih sudah mampir.");
    input.close();
    }
    public static void main(String[] args) {
        
        bioskop bioskop = new bioskop();

        bioskop.tambahFilm(new Film(1, "Tangled", 35000));
        bioskop.tambahFilm(new Film(2, "Moana 2", 35000));
        bioskop.tambahFilm(new Film(3, "Frozen ", 35000));

        bioskop.prosesPembelian();
    }
}
