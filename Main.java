import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

/* Kelas Utama */
public class Main {
    // List untuk menyimpan objek siswa
    private static List<Siswa> listSiswa = new ArrayList<>();

    /* method utama */
    public static void main(String[] args) {
        // variable untuk menyimpan pilihan user
        int pilihan;
        do {
            // Tampilkan menu
            cls();
            tampilkanMenu();
            // Baca input pilihan dari user
            pilihan = new Scanner(System.in).nextInt();
            // Proses sesuai dengan pilihan user
            switch (pilihan) {
                case 1:
                    cls();
                    tambahSiswa();
                    break;
                case 2:
                    cls();
                    lihatSiswa();
                    break;
                case 3:
                    cls();
                    ubahSiswa();
                    break;
                case 4:
                    cls();
                    hapusSiswa();
                    break;
                case 5:
                    cls();
                    hitungRataRata();
                    break;
                case 6:
                    cls();
                    keluar();
                    break;
                default:
                    cls();
                    System.out.println("Pilihan Tidak Valid.");
            }
        } while (pilihan != 6);
    }

    /* method untuk menampilkan menu */
    private static void tampilkanMenu() {
        System.out.println("---Program CRUD Nilai Siswa Kelas 2KA15---");
        System.out.println("1. Tambah Data Siswa");
        System.out.println("2. Lihat Data Siswa");
        System.out.println("3. Ubah Data Siswa");
        System.out.println("4. Hapus Data Siswa");
        System.out.println("5. Hitung Rata-Rata Nilai Siswa");
        System.out.println("6. Keluar");
        System.out.print("Masukkan pilihan: ");
    }

    /* method untuk menambahkan siswa ke list */
    private static void tambahSiswa() {      
        System.out.println("---TAMBAH SISWA---\n");
        // Membuat objek scanner untuk membaca input dari user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Nama Siswa  : ");
        // Membaca input nama dari user
        String nama = scanner.nextLine();
        System.out.print("Masukkan NPM Siswa   : ");
        // Membaca input npm dari user
        String npm = scanner.nextLine();
        System.out.print("Masukkan Nilai Siswa : ");
        // Membaca input nilai dari user
        double nilai = scanner.nextDouble();

        if(nilai > 100){
            cls();
            System.out.println("Nilai yang dimasukkan tidak boleh dari 100\n");
            System.out.println("Tolong masukkan data yang sesuai !");
            new Scanner(System.in).nextLine();
            cls();
            tambahSiswa();
        }else {
            // Membuat objek siswa baru dan menambahkan ke list
            listSiswa.add(new Siswa(nama, npm, nilai));
            System.out.println("\nData Siswa Berhasil Ditambahkan.");
            System.out.println("\n\n(Tekan apa saja untuk kembali ke tampilan awal...)");
            new Scanner(System.in).nextLine();
        }
        
    }

    /* method untuk mengubah data siswa */
    private static void ubahSiswa() {
        System.out.println("---UBAH DATA---\n");
        // Jika list siswa kosong, tampilkan pesan
        if (listSiswa.isEmpty()) {
            System.out.println("Data Siswa masih Kosong.");

            System.out.println("\n\n(Tekan apa saja untuk kembali ke tampilan awal...)");
            new Scanner(System.in).nextLine();
            return;
        }
        // Membuat objek scanner untuk membaca input dari user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan NPM Siswa Yang Akan Diubah : ");
        // Membaca input npm dari user
        String npm = scanner.nextLine();
        // Flag untuk menandakan apakah siswa ditemukan
        boolean isSiswaDitemukan = false;
        for (Siswa siswa : listSiswa) {
            // Jika siswa ditemukan
            if (siswa.getNPM().equals(npm)) {
                isSiswaDitemukan = true;
                System.out.print("Masukkan Nama Baru  : ");
                // Mengubah nama siswa
                siswa.setNama(scanner.nextLine());
                System.out.print("Masukkan Nilai Baru : ");
                // Mengubah nilai siswa
                siswa.setNilai(scanner.nextDouble());
                System.out.println("\nData Siswa Berhasil Diubah.");
                break;
            }
        }
        // Jika siswa tidak ditemukan
        if (!isSiswaDitemukan) {
            System.out.println("\nSiswa Dengan NPM " + npm + " Tidak Ditemukan.");
        }
        System.out.println("\n\n(Tekan apa saja untuk kembali ke tampilan awal...)");
        new Scanner(System.in).nextLine();
    }

    /* method untuk menghapus siswa */
    private static void hapusSiswa() {
        System.out.println("---HAPUS DATA---\n");
        // Jika list siswa kosong, tampilkan pesan
        if (listSiswa.isEmpty()) {
            System.out.println("Data siswa masih kosong.");

            System.out.println("\n\n(Tekan apa saja untuk kembali ke tampilan awal...)");
            new Scanner(System.in).nextLine();
            return;
        }
        // Membuat objek scanner untuk membaca input dari user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan NPM Siswa Yang Akan Dihapus : ");
        // Membaca input npm dari user
        String npm = scanner.nextLine();
        // Flag untuk menandakan apakah siswa ditemukan
        boolean isSiswaDitemukan = false;
        for (Siswa siswa : listSiswa) {
            // Jika siswa ditemukan
            if (siswa.getNPM().equals(npm)) {
                isSiswaDitemukan = true;
                // Menghapus siswa dari list
                listSiswa.remove(siswa);
                System.out.println("\nData Siswa Berhasil Dihapus.");
                break;
            }
        }
        // Jika siswa tidak ditemukan
        if (!isSiswaDitemukan) {
            System.out.println("\nSiswa Dengan NPM " + npm + " Tidak Ditemukan.");
        }
        System.out.println("\n\n(Tekan apa saja untuk kembali ke tampilan awal...)");
        new Scanner(System.in).nextLine();
    }

    /* method untuk menampilkan data siswa */
    private static void lihatSiswa() {
        System.out.println("---LIHAT DATA---\n");
        // Jika list siswa kosong, tampilkan pesan
        if (listSiswa.isEmpty()) {
            System.out.println("Data siswa masih kosong.");

            System.out.println("\n\n(Tekan apa saja untuk kembali ke tampilan awal...)");
            new Scanner(System.in).nextLine();
            return;
        }
        // Menampilkan header tabel
        System.out.println("+-----------------+-----------------+-------+");
        System.out.println("|      Nama       |       npm       | Nilai |");
        System.out.println("+-----------------+-----------------+-------+");
        // Menampilkan data siswa
        for (Siswa siswa : listSiswa) {
            System.out.printf("| %-15s | %-15s | %-5.2f |%n", siswa.getNama(), siswa.getNPM(), siswa.getNilai());
        }
        System.out.println("+-----------------+-----------------+-------+");

        System.out.println("\n\n(Tekan apa saja untuk kembali ke tampilan awal...)");
        new Scanner(System.in).nextLine();
    }

    /* method untuk menghitung rata-rata nilai siswa */
    private static void hitungRataRata() {
        System.out.println("---RATA-RATA NILAI DATA---\n");
        // Jika list siswa kosong, tampilkan pesan
        if (listSiswa.isEmpty()) {
            System.out.println("Data siswa masih kosong.");

            System.out.println("\n\n(Tekan apa saja untuk kembali ke tampilan awal...)");
            new Scanner(System.in).nextLine();
            return;
        }
        // variable untuk menyimpan total nilai
        double total = 0;
        for (Siswa siswa : listSiswa) {
            total += siswa.getNilai();
        }
        // Menghitung rata-rata nilai siswa
        double rataRata = total / listSiswa.size();
        System.out.printf("Rata-Rata Nilai Siswa : %.2f%n", rataRata);

        System.out.println("\n\n(Tekan apa saja untuk kembali ke tampilan awal...)");
        new Scanner(System.in).nextLine();
    }

    /* method untuk keluar dari program */
    public static void keluar() {
        System.out.println("Terima Kasih Telah Menggunakan Program Ini !");
        System.out.println("\n\n(Tekan apa saja untuk keluar...)");
        new Scanner(System.in).nextLine();
        System.exit(0);
    }

    /* method untuk membersihkan layar */
    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }
}
