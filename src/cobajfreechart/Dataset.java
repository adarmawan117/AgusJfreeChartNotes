package cobajfreechart;

import java.util.ArrayList;

public class Dataset {
    private ArrayList<String> listNamaCustomer;
    private ArrayList<String> listNamaBarang;
    private ArrayList<Integer> listRetur;
    private ArrayList<Integer> listTerjual;
    private ArrayList<String> listTanggal;

    public Dataset() {
        listNamaCustomer = new ArrayList<>();
        listNamaBarang = new ArrayList<>();
        listRetur = new ArrayList<>();
        listTerjual = new ArrayList<>();
        listTanggal = new ArrayList<>();
    }
    
    public int getJumlahData() {
        return listNamaCustomer.size();
    }
    
    public String getNamaCustomer(int idx) {
        return listNamaCustomer.get(idx);
    }
    
    public String getNamaBarang(int idx) {
        return listNamaBarang.get(idx);
    }
    
    public Integer getRetur(int idx) {
        return listRetur.get(idx);
    }
    
    public Integer getTerjual(int idx) {
        return listTerjual.get(idx);
    }
    
    public String getTanggal(int idx) {
        return listTanggal.get(idx);
    }
    
    public ArrayList<String> getListNamaCustomer() {
        return listNamaCustomer;
    }

    public ArrayList<String> getListNamaBarang() {
        return listNamaBarang;
    }

    public ArrayList<Integer> getListRetur() {
        return listRetur;
    }

    public ArrayList<Integer> getListTerjual() {
        return listTerjual;
    }

    public ArrayList<String> getListTanggal() {
        return listTanggal;
    }

    public void addNamaCustomer(String namaCustomer) {
        listNamaCustomer.add(namaCustomer);
    }
    
    public void addNamaBarang(String namaBarang) {
        listNamaBarang.add(namaBarang);
    }
    
    public void addRetur(Integer retur) {
        listRetur.add(retur);
    }
    
    public void addTerjual(Integer terjual) {
        listTerjual.add(terjual);
    }
    
    public void addTanggal(String tanggal) {
        listTanggal.add(tanggal);
    }

    public void setRetur(int idx, int newValue) {
        listRetur.set(idx, newValue);
    }
    
    public void setTerjual(int idx, int newValue) {
        listTerjual.set(idx, newValue);
    }
    
}
