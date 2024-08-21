import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String nama;
    String nim;
    int nilai;

    Mahasiswa(String nama, String nim, int nilai) {
        this.nama = nama;
        this.nim = nim;
        this.nilai = nilai;
    }

    String getGrade() {
        if (nilai >= 85) return "A";
        else if (nilai >= 70) return "B";
        else if (nilai >= 55) return "C";
        else if (nilai >= 40) return "D";
        else return "E";
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", NIM: " + nim + ", Nilai: " + nilai + ", Grade: " + getGrade();
    }
}

public class Main {
    static ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("Data Nilai Mahasiswa Mata Kuliah Perpajakan");
            System.out.println("Menu:");
            System.out.println("1. Tambah data mahasiswa");
            System.out.println("2. Update data mahasiswa");
            System.out.println("3. Delete data mahasiswa");
            System.out.println("4. Lihat semua data mahasiswa");
            System.out.println("5. Cari data mahasiswa berdasarkan nama");
            System.out.println("6. Keluar dari program");
            System.out.print("Pilih opsi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahDataMahasiswa();
                    break;
                case 2:
                    updateDataMahasiswa();
                    break;
                case 3:
                    deleteDataMahasiswa();
                    break;
                case 4:
                    lihatSemuaDataMahasiswa();
                    break;
                case 5:
                    cariDataMahasiswa();
                    break;
                case 6:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 6);
    }

    static void tambahDataMahasiswa() {
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Nilai: ");
        int nilai = scanner.nextInt();
        scanner.nextLine(); 

        for (Mahasiswa m : dataMahasiswa) {
            if (m.nama.equalsIgnoreCase(nama)) {
                System.out.println("Nama mahasiswa sudah ada.");
                return;
            }
        }

        dataMahasiswa.add(new Mahasiswa(nama, nim, nilai));
        System.out.println("Data mahasiswa berhasil ditambahkan.");
    }

    static void updateDataMahasiswa() {
        System.out.print("Nama mahasiswa yang ingin diupdate: ");
        String nama = scanner.nextLine();

        for (Mahasiswa m : dataMahasiswa) {
            if (m.nama.equalsIgnoreCase(nama)) {
                System.out.print("Masukkan NIM baru: ");
                String nim = scanner.nextLine();
                System.out.print("Masukkan nilai baru: ");
                int nilai = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                m.nim = nim;
                m.nilai = nilai;
                System.out.println("Data mahasiswa berhasil diupdate.");
                return;
            }
        }

        System.out.println("Mahasiswa tidak ditemukan.");
    }

    static void deleteDataMahasiswa() {
        System.out.print("Nama mahasiswa yang ingin dihapus: ");
        String nama = scanner.nextLine();

        for (int i = 0; i < dataMahasiswa.size(); i++) {
            if (dataMahasiswa.get(i).nama.equalsIgnoreCase(nama)) {
                dataMahasiswa.remove(i);
                System.out.println("Data mahasiswa berhasil dihapus.");
                return;
            }
        }

        System.out.println("Mahasiswa tidak ditemukan.");
    }

    static void lihatSemuaDataMahasiswa() {
        if (dataMahasiswa.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa.");
        } else {
            for (Mahasiswa m : dataMahasiswa) {
                System.out.println(m);
            }
        }
    }

    static void cariDataMahasiswa() {
        System.out.print("Masukkan nama mahasiswa yang ingin dicari: ");
        String nama = scanner.nextLine();

        for (Mahasiswa m : dataMahasiswa) {
            if (m.nama.equalsIgnoreCase(nama)) {
                System.out.println(m);
                return;
            }
        }

        System.out.println("Mahasiswa tidak ditemukan.");
    }
}
