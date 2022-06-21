package Entity;

public class Detail_Transaksi_Entity {
    private String nama_pelanggan,nama_pegawai,nama_produk;
    private int jumlah_barang, jumlah_harga;

    public Detail_Transaksi_Entity(String nama_pelanggan, String nama_pegawai, String nama_produk, int jumlah_barang, int jumlah_harga) {
        this.nama_pelanggan = nama_pelanggan;
        this.nama_pegawai = nama_pegawai;
        this.nama_produk = nama_produk;
        this.jumlah_barang = jumlah_barang;
        this.jumlah_harga = jumlah_harga;
    }

    public Detail_Transaksi_Entity(){}

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }

    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }

    public String getNama_pegawai() {
        return nama_pegawai;
    }

    public void setNama_pegawai(String nama_pegawai) {
        this.nama_pegawai = nama_pegawai;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public int getJumlah_barang() {
        return jumlah_barang;
    }

    public void setJumlah_barang(int jumlah_barang) {
        this.jumlah_barang = jumlah_barang;
    }

    public int getJumlah_harga() {
        return jumlah_harga;
    }

    public void setJumlah_harga(int jumlah_harga) {
        this.jumlah_harga = jumlah_harga;
    }
}
