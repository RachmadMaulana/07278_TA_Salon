package Controller;

public class PegawaiController {
    public int Login(String username, String password){
        return AllObjectModel.pegawaiModel.cekLogin(username, password);
    }

    public int TambahPelanggan(String nama, String alamat){
        return AllObjectModel.pegawaiModel.tambahPelanggan(nama, alamat);
    }

    public String getNamaPegawai(int id){
        return AllObjectModel.pegawaiModel.getNamaPegawai(id);
    }

    public int getStok(int id){
        return AllObjectModel.pegawaiModel.getStok(id);
    }
}
