package Controller;

import Entity.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class PelangganController {


    public void updateData(int pilih,String param, int id){
        switch (pilih){
            case 1 -> AllObjectModel.pelangganModel.updateNama(param,id);
            case 2 -> AllObjectModel.pelangganModel.updateAlamat(param,id);
        }
    }

    public int deleteData(int id){
        return AllObjectModel.pelangganModel.deleteData(id);
    }

     ArrayList<PelangganEntity>getPelanggan(int id){
      return AllObjectModel.pelangganModel.getPelanggan(id);
    }

    public String getNamaPelanggan(int id){
        return AllObjectModel.pelangganModel.getNamaPelanggan(id);
    }

}
