/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p07;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Menghubungkan daftar Buku dengan JTable.
 * JTable bertanya kepada model: berapa baris, berapa kolom, dan apa isi setiap sel.
 */
public class BukuTableModel extends AbstractTableModel {

    private static final String[] KOLOM = {"Kode", "Judul", "Penulis", "Tahun", "Status"};
    private final List<Buku> daftar = new ArrayList<>();

    @Override
    public int getRowCount() {
        return daftar.size();
    }

    @Override
    public int getColumnCount() {
        return KOLOM.length;
    }

    @Override
    public String getColumnName(int kolom) {
        return KOLOM[kolom];
    }

    /** Kolom tahun bertipe Integer agar diurutkan sebagai angka, bukan sebagai teks. */
    @Override
    public Class<?> getColumnClass(int kolom) {
        return (kolom == 3) ? Integer.class : String.class;
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        Buku b = daftar.get(baris);
        return switch (kolom) {
            case 0 -> b.getKode();
            case 1 -> b.getJudul();
            case 2 -> b.getPenulis();
            case 3 -> b.getTahunTerbit();
            default -> teksStatus(b);
        };
    }

    /** Mengubah status buku menjadi teks yang tampil di tabel. */
    public static String teksStatus(Buku buku) {
        return (buku.getStatus() == StatusKoleksi.DIPINJAM) ? "Dipinjam" : "Tersedia";
    }

    public Buku get(int baris) {
        return daftar.get(baris);
    }

    public void tambah(Buku buku) {
        daftar.add(buku);
        int baris = daftar.size() - 1;
        fireTableRowsInserted(baris, baris); // tampilkan baris baru
    }

    public void ubah(int baris, Buku buku) {
        daftar.set(baris, buku);
        fireTableRowsUpdated(baris, baris);
    }

    public void hapus(int baris) {
        daftar.remove(baris);
        fireTableRowsDeleted(baris, baris);
    }

    /** Jumlah buku berstatus Tersedia, dipakai untuk label status di jendela utama. */
    public int jumlahTersedia() {
        int jumlah = 0;
        for (Buku b : daftar) {
            if (b.getStatus() == StatusKoleksi.TERSEDIA) {
                jumlah++;
            }
        }
        return jumlah;
    }
}
