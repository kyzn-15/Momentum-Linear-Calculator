import java.util.Scanner;

interface DapatDihitung {
    double hitung();
}

abstract class BendaFisika implements DapatDihitung {
    private double massa;
    private double kecepatan;

    protected BendaFisika(double massa, double kecepatan) {
        this.massa = massa;
        this.kecepatan = kecepatan;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public double getKecepatan() {
        return kecepatan;
    }

    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }
}

class BendaKaku extends BendaFisika {
    public BendaKaku(double massa, double kecepatan) {
        super(massa, kecepatan);
    }

    @Override
    public double hitung() {
        return getMassa() * getKecepatan();
    }
}

class BendaLunak extends BendaFisika {
    private double koefisienGesekan;

    public BendaLunak(double massa, double kecepatan, double koefisienGesekan) {
        super(massa, kecepatan);
        this.koefisienGesekan = koefisienGesekan;
    }

    public double getKoefisienGesekan() {
        return koefisienGesekan;
    }

    public void setKoefisienGesekan(double k) {
        this.koefisienGesekan = k;
    }

    @Override
    public double hitung() {
        double momentum = getMassa() * getKecepatan();
        return momentum * (1 - koefisienGesekan);
    }
}

class Utils {
    private static Scanner scanner = new Scanner(System.in);

    public static double bacaDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Input tidak valid. " + prompt);
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static int bacaPilihan(String prompt, int min, int max) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Input tidak valid. " + prompt);
            scanner.next();
        }
        int pilihan = scanner.nextInt();
        if (pilihan < min || pilihan > max) {
            System.out.print("Pilihan di luar jangkauan. ");
            return bacaPilihan(prompt, min, max);
        }
        return pilihan;
    }

    public static void tampilkanInformasi() {
        System.out.println("\n=== Informasi Momentum Linear ===");
        System.out.println("Momentum adalah besaran yang menyatakan hasil kali massa dan kecepatan suatu benda.");
        System.out.println("Rumus umum momentum linear: p = m * v");
        System.out.println("Keterangan:");
        System.out.println("p = momentum (kg·m/s)");
        System.out.println("m = massa (kg)");
        System.out.println("v = kecepatan (m/s)");
        System.out.println();
        System.out.println("Untuk benda lunak, momentum dikoreksi dengan koefisien gesekan:");
        System.out.println("p = m * v * (1 - k)");
        System.out.println("k = koefisien gesekan (antara 0 dan 1)");
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Aplikasi Penghitung Momentum Linear ===");

        while (true) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Lihat Informasi dan Rumus Momentum");
            System.out.println("2. Hitung Momentum Benda Kaku");
            System.out.println("3. Hitung Momentum Benda Lunak");
            System.out.println("4. Keluar");

            int pilihan = Utils.bacaPilihan("Masukkan pilihan [1-4]: ", 1, 4);

            if (pilihan == 1) {
                Utils.tampilkanInformasi();
            } else if (pilihan == 2) {
                double massa = Utils.bacaDouble("Masukkan massa (kg): ");
                double kecepatan = Utils.bacaDouble("Masukkan kecepatan (m/s): ");
                DapatDihitung benda = new BendaKaku(massa, kecepatan);
                double hasil = benda.hitung();
                System.out.printf("Momentum benda kaku: %.2f kg·m/s%n", hasil);
            } else if (pilihan == 3) {
                double massa = Utils.bacaDouble("Masukkan massa (kg): ");
                double kecepatan = Utils.bacaDouble("Masukkan kecepatan (m/s): ");
                double k = Utils.bacaDouble("Masukkan koefisien gesekan (0-1): ");
                DapatDihitung benda = new BendaLunak(massa, kecepatan, k);
                double hasil = benda.hitung();
                System.out.printf("Momentum benda lunak: %.2f kg·m/s%n", hasil);
            } else if (pilihan == 4) {
                System.out.println("Terima kasih telah menggunakan aplikasi.");
                break;
            }
        }
    }
}
