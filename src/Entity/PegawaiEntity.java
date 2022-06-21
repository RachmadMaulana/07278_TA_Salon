package Entity;

public class PegawaiEntity {
    private String nama,alamat,password;

    public PegawaiEntity(String nama, String alamat, String password) {
        this.nama = nama;
        this.alamat = alamat;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
