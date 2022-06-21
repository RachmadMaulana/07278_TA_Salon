package GUI;

import Controller.DetailTransaksiController;
import Controller.PegawaiController;
import Controller.PelangganController;
import Controller.ProdukController;

public class AllObjectController {
    public static PelangganController pelangganController = new PelangganController();
    public static ProdukController produkController = new ProdukController();
    public static DetailTransaksiController detail = new DetailTransaksiController();
    public static PegawaiController pegawaiController = new PegawaiController();
}
