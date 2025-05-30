# Aplikasi Penghitung Momentum Linear

Console app untuk menghitung momentum linear dengan menu interaktif, mendukung:
1. Menampilkan informasi & rumus momentum  
2. Menghitung momentum benda kaku  
3. Menghitung momentum benda lunak (dengan koefisien gesekan)  
4. Keluar dari aplikasi

## Fitur Baru
- **Menu Utama** dengan 4 pilihan:
  1. Lihat Informasi dan Rumus Momentum  
  2. Hitung Momentum Benda Kaku  
  3. Hitung Momentum Benda Lunak  
  4. Keluar  
- **Informasi & Rumus**: penjelasan definisi momentum, rumus umum, dan rumus koreksi gesekan.  
- **Loop**: pengguna dapat melakukan beberapa perhitungan atau melihat informasi berkali-kali hingga memilih keluar.  

## Struktur Project

```
src/
├── Main.java          # Entry point dengan menu interaktif
├── Utils.java         # Kelas utilitas untuk input dan menampilkan informasi
├── DapatDihitung.java # Interface dengan method hitung()
├── BendaFisika.java   # Kelas abstrak dasar
├── BendaKaku.java     # Implementasi momentum benda kaku
└── BendaLunak.java    # Implementasi momentum benda lunak

````

## Prasyarat
- Java Development Kit (JDK) 8 atau lebih baru  
- Compiler dan runtime Java (`javac`, `java`)

## Cara Kompilasi dan Menjalankan

1. **Compile** semua file `.java`:
```bash
   javac src/*.java
````

2. **Jalankan** program:

```bash
   java -cp src Main
```

## Contoh Interaksi

```text
=== Aplikasi Penghitung Momentum Linear ===

Menu Utama:
1. Lihat Informasi dan Rumus Momentum
2. Hitung Momentum Benda Kaku
3. Hitung Momentum Benda Lunak
4. Keluar
Masukkan pilihan [1-4]: 1

=== Informasi Momentum Linear ===
Momentum adalah besaran yang menyatakan hasil kali massa dan kecepatan suatu benda.
Rumus umum momentum linear: p = m * v
Keterangan:
p = momentum (kg·m/s)
m = massa (kg)
v = kecepatan (m/s)

Untuk benda lunak, momentum dikoreksi dengan koefisien gesekan:
p = m * v * (1 - k)
k = koefisien gesekan (antara 0 dan 1)


Menu Utama:
1. Lihat Informasi dan Rumus Momentum
2. Hitung Momentum Benda Kaku
3. Hitung Momentum Benda Lunak
4. Keluar
Masukkan pilihan [1-4]: 2
Masukkan massa (kg): 4.5
Masukkan kecepatan (m/s): 2
Momentum benda kaku: 9.00 kg·m/s

Menu Utama:
1. Lihat Informasi dan Rumus Momentum
2. Hitung Momentum Benda Kaku
3. Hitung Momentum Benda Lunak
4. Keluar
Masukkan pilihan [1-4]: 3
Masukkan massa (kg): 5
Masukkan kecepatan (m/s): 3
Masukkan koefisien gesekan (0-1): 0.2
Momentum benda lunak: 12.00 kg·m/s

Menu Utama:
1. Lihat Informasi dan Rumus Momentum
2. Hitung Momentum Benda Kaku
3. Hitung Momentum Benda Lunak
4. Keluar
Masukkan pilihan [1-4]: 4
Terima kasih telah menggunakan aplikasi.
```

---
#### Kevin Wilbert Johan 11 IPA 1
# Momentum-Linear-Calculator
