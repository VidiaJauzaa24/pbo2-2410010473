# P07 - Mini Proyek: Katalog Buku Perpustakaan

**Mata Kuliah:** Pemrograman Berbasis Objek 2 (TIF1508)
**Pertemuan:** 7 - Tabel, Menu, dan Mini Proyek GUI
**Nama:** Vidia Jauzaa Shadidah
**NPM:** 2410010473

Aplikasi desktop untuk mengelola katalog buku perpustakaan. Dibuat dengan Java Swing, FlatLaf, dan GUI Builder NetBeans. Tampilan disusun di tab Design; yang ditulis sendiri hanya kelas model, isi event handler, dan method bantu.

## Video Demo

Tautan video demo (maksimal 3 menit): (isi tautan video)

## Struktur Proyek

| File | Keterangan |
|---|---|
| `BisaDipinjam.java`, `StatusKoleksi.java`, `Koleksi.java`, `Buku.java` | Kelas dari Pertemuan 2, dipakai ulang. `Buku` mewarisi `Koleksi` yang menyimpan kode, judul, tahun terbit, dan status |
| `BukuTableModel.java` | `AbstractTableModel` yang menghubungkan daftar `Buku` dengan `JTable` |
| `DialogBuku.java` dan `.form` | JDialog Form modal untuk tambah dan ubah buku, dengan validasi |
| `KatalogBuku.java` dan `.form` | JFrame Form: tabel, menu bar, pencarian, dan label status |

## Fitur

| No | Fitur | Penerapan |
|----|-------|-----------|
| 1 | Tabel buku | Kolom kode, judul, penulis, tahun terbit, dan status memakai `BukuTableModel` |
| 2 | Data contoh | Enam buku saat aplikasi dibuka |
| 3 | Tambah dan ubah | `DialogBuku` modal; kode dan judul wajib diisi, kode tidak boleh kembar, tahun 1900 sampai tahun sekarang |
| 4 | Hapus | Dengan konfirmasi, memakai `convertRowIndexToModel` |
| 5 | Menu | Menu File dan Buku, dengan mnemonic F dan B, serta Ctrl+N, Ctrl+E, Ctrl+D |
| 6 | Pencarian | Menyaring kode, judul, atau penulis dengan `TableRowSorter` dan `RowFilter` |
| 7 | Status | Label jumlah buku yang ditampilkan dan jumlah buku yang tersedia |
| 8 | Tampilan | FlatLaf; tombol Ubah dan Hapus aktif hanya jika ada baris yang dipilih |

## Peta Event

**KatalogBuku (jendela utama)**

| Komponen | Menu Events | Aksi |
|----------|-------------|------|
| `tambahButton`, `tambahItem` | Action: `actionPerformed` | Memanggil `tambah()` |
| `ubahButton`, `ubahItem` | Action: `actionPerformed` | Memanggil `ubah()` |
| `hapusButton`, `hapusItem` | Action: `actionPerformed` | Memanggil `hapus()` dengan konfirmasi |
| `cariField` | Key: `keyReleased` | Memanggil `saring()` |
| `bukuTable` | Mouse: `mouseClicked` | Klik dua kali memanggil `ubah()` |
| `keluarItem` | Action: `actionPerformed` | Menutup jendela |

Pemilihan baris tabel tidak tersedia di menu Events, sehingga `ListSelectionListener` dipasang di konstruktor untuk mengatur status tombol Ubah dan Hapus (`perbaruiTombol()`).

**DialogBuku**

| Komponen | Menu Events | Aksi |
|----------|-------------|------|
| `simpanButton` | Action: `actionPerformed` | Memanggil `simpan()`: memeriksa kode, judul, dan tahun |
| `batalButton` | Action: `actionPerformed` | Menutup dialog tanpa menyimpan |
| `tahunField` | Key: `keyTyped` | `evt.consume()` untuk karakter bukan angka dan digit ke-5 |

Tombol dan item menu yang sama memanggil satu method (`tambah()`, `ubah()`, `hapus()`), sehingga logikanya tidak ditulis dua kali.

## Deklarasi Penggunaan AI

Saya menggunakan **Claude (Anthropic)** untuk memahami langkah pengerjaan berdasarkan modul, membantu menyusun dan menyesuaikan kode dengan studi kasus buku dan nama komponen pada form saya, serta menjelaskan kesalahan saat pembuatan. Seluruh kode saya jalankan dan uji sendiri, dan video demo saya rekam sendiri.
