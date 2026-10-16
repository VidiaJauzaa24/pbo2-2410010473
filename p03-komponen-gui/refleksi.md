1. Apa perbedaan top-level container, intermediate container, dan atomic component?
  Top-level container adalah jendela utama berbingkai dan berjudul, contoh JFrame. Intermediate container adalah wadah untuk mengelompokkan komponen, contoh JPanel. Atomic component adalah komponen yang berinteraksi langsung dengan pengguna, contoh JButton
2. Mengapa kedua JRadioButton perlu diberi properti buttonGroup yang sama?
  Karena JRadioButton wajib berada dalam satu ButtonGroup supaya cuma satu pilihan yang bisa aktif dalam sekelompok opsi
3. Kapan memilih JComboBox dibandingkan JRadioButton?
  JComboBox dipakai untuk memilih satu dari banyak pilihan, sedangkan JRadioButton dipakai untuk memilih satu dari sedikit pilihan
4. Mengapa kode di dalam initComponents() tidak boleh diedit langsung, dan di mana kode tambahan seharusnya ditulis?
  Isi initComponents() selalu diregenerasi ulang oleh Form Editor, jadi edit manual di situ akan hilang. Kode tambahan ditulis di konstruktor setelah initComponents(), di luar blok abu-abu buatan NetBeans.
5. Mengapa FlatLightLaf.setup() harus dipanggil sebelum form dibuat?
  Karena tema FlatLaf perlu aktif lebih dulu supaya komponen yang dibuat langsung mengikuti tampilan tema tersebut sejak awal.
