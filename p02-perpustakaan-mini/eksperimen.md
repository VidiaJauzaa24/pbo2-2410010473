1. Buat object dari Koleksi langsung

Muncul error: "Koleksi is abstract; cannot be instantiated". Soalnya Koleksi itu abstract class, jadi tidak bisa langsung dibuat object-nya pakai new. Harus lewat subclass seperti Buku atau Majalah.

2. Ganti nama hitungDenda jadi hitungdenda

Waktu @Override masih ada, langsung error: "does not override or implement a method from a supertype", karena nama method beda sama yang ada di interface BisaDipinjam. Setelah @Override dihapus, errornya pindah jadi: "Buku is not abstract and does not override abstract method hitungDenda" — program tetap gagal compile karena Buku jadi tidak memenuhi kontrak interface-nya.

3. Tambah buku dengan judul kosong

Program berhasil compile, tapi pas dijalankan langsung crash kena IllegalArgumentException: Judul tidak boleh kosong. Ini karena constructor Koleksi memang sudah divalidasi supaya judul tidak boleh kosong.

4. Ubah status jadi public

Setelah status dibuat public, status buku B002 bisa diubah paksa jadi TERSEDIA langsung dari main, padahal masih dipinjam dan belum lewat kembalikan(). Ini melanggar enkapsulasi — harusnya status cuma boleh berubah lewat method pinjam() dan kembalikan() supaya datanya tetap konsisten.
