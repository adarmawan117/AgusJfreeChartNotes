package cobajfreechart;

import Method.Database;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AfifLuthfiController extends Database {
    
    public Dataset getDataset(String query) {
        Dataset dataset = new Dataset();
        try{
            Class.forName(MYSQL_DRIVER);
            CONN = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
            STATEMENT = CONN.createStatement(); 
            // select namacustomer, namabarang, retu, terjual, tglup FROM sellin;
            RS = STATEMENT.executeQuery(query);
            
            String namaCustomer;
            String namaBarang;
            int retur;
            int terjual;
            String tglUp;
            
            while(RS.next()) {
                
                int isBarangAvail = -1;
                int jumlahData = dataset.getJumlahData();
                for(int i = 0; i < jumlahData; i++) {
                    if(dataset.getNamaBarang(i).equals(RS.getString("namabarang"))) {
                        System.out.println("sama");
                        isBarangAvail = i;
                        break;
                    }
                }
                
                namaCustomer = RS.getString("namacustomer");
                namaBarang = RS.getString("namabarang");
                retur = RS.getInt("retur");
                terjual = RS.getInt("terjual");
                tglUp = RS.getString("tglup");
                
                if(isBarangAvail == -1) {
                    dataset.addNamaCustomer(namaCustomer);
                    dataset.addNamaBarang(namaBarang);
                    dataset.addRetur(retur);
                    dataset.addTerjual(terjual);
                    dataset.addTanggal(tglUp);
                } else {
                    dataset.setRetur(isBarangAvail, dataset.getRetur(isBarangAvail) + retur);
                    dataset.setTerjual(isBarangAvail, dataset.getTerjual(isBarangAvail) + terjual);
                }
            }
            RS.close();
            STATEMENT.close();
            CONN.close();
        } catch(HeadlessException | ClassNotFoundException | SQLException e){
            dialog.exception(e);
        }
        
        return dataset;
    }
}
