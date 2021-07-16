package MainPackage;

import cobajfreechart.AfifLuthfi;
import javax.swing.JTextField;

public class MainFrame extends javax.swing.JFrame {
    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dateDari = new com.toedter.calendar.JDateChooser();
        dateSampai = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxSatuanWaktu = new javax.swing.JComboBox<>();
        comboBoxRentangWaktu = new javax.swing.JComboBox<>();
        checkboxSatuanWaktu = new javax.swing.JCheckBox();
        checkboxRentangWaktu = new javax.swing.JCheckBox();
        btnTampilkan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dateDari.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(dateDari, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 105, 182, -1));

        dateSampai.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(dateSampai, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 105, 172, -1));

        jLabel1.setText("Dari");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 83, -1, -1));

        jLabel2.setText("Sampai");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        comboBoxSatuanWaktu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Tampilkan Berdasarkan --", "Satu hari", "Satu bulan", "Satu tahun" }));
        jPanel1.add(comboBoxSatuanWaktu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 200, -1));

        comboBoxRentangWaktu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Tampilkan Berdasarkan --", "Harian", "Bulanan", "Tahunan" }));
        comboBoxRentangWaktu.setEnabled(false);
        jPanel1.add(comboBoxRentangWaktu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 200, -1));

        checkboxSatuanWaktu.setSelected(true);
        checkboxSatuanWaktu.setText("Satuan Waktu");
        checkboxSatuanWaktu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxSatuanWaktuActionPerformed(evt);
            }
        });
        jPanel1.add(checkboxSatuanWaktu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        checkboxRentangWaktu.setText("Rentang Waktu");
        checkboxRentangWaktu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxRentangWaktuActionPerformed(evt);
            }
        });
        jPanel1.add(checkboxRentangWaktu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        btnTampilkan.setText("Tampilkan");
        btnTampilkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTampilkanActionPerformed(evt);
            }
        });
        jPanel1.add(btnTampilkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, -1));

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        jPanel1.add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkboxSatuanWaktuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxSatuanWaktuActionPerformed
        checkboxSatuanWaktu.setSelected(true);
        comboBoxSatuanWaktu.setEnabled(true);
        
        checkboxRentangWaktu.setSelected(false);
        comboBoxRentangWaktu.setEnabled(false);
        comboBoxRentangWaktu.setSelectedIndex(0);
    }//GEN-LAST:event_checkboxSatuanWaktuActionPerformed

    private void checkboxRentangWaktuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxRentangWaktuActionPerformed
        checkboxRentangWaktu.setSelected(true);
        comboBoxRentangWaktu.setEnabled(true);
        
        checkboxSatuanWaktu.setSelected(false);
        comboBoxSatuanWaktu.setEnabled(false);
        comboBoxSatuanWaktu.setSelectedIndex(0);
    }//GEN-LAST:event_checkboxRentangWaktuActionPerformed

    private void btnTampilkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTampilkanActionPerformed
        String query = "";
        String dari = ((JTextField)dateDari.getDateEditor().getUiComponent()).getText();
        String sampai = ((JTextField)dateSampai.getDateEditor().getUiComponent()).getText();
        
        if(checkboxSatuanWaktu.isSelected()) {
            String parameter = comboBoxSatuanWaktu.getSelectedItem().toString();
            if(parameter.equals("Satu hari")) {
                query = "SELECT namacustomer, namabarang, retur, terjual, tglup FROM sellin WHERE tglup = '"+ dari +"';";
            } else if(parameter.equals("Satu bulan")) {
                query = "SELECT namacustomer, namabarang, retur, terjual, tglup FROM sellin WHERE MONTH(tglup) = "+ dari.substring(5, 7) +";";
            } else if(parameter.equals("Satu tahun")) {
                query = "SELECT namacustomer, namabarang, retur, terjual, tglup FROM sellin WHERE YEAR(tglup) = "+ dari.substring(0, 4) +";";
            }
            
        } else if(checkboxRentangWaktu.isSelected()) {
            String parameter = comboBoxRentangWaktu.getSelectedItem().toString();
            if(parameter.equals("Harian")) {
                query = "SELECT namacustomer, namabarang, retur, terjual, tglup FROM sellin WHERE tglup between '"+ dari +"' AND '"+ sampai +"';";
            } else if(parameter.equals("Bulanan")) {
                query = "SELECT namacustomer, namabarang, retur, terjual, tglup FROM sellin WHERE MONTH(tglup) between '"+ dari.substring(5, 7) +"' AND '"+ sampai.substring(5, 7) +"';";
            } else if(parameter.equals("Tahunan")) {
                query = "SELECT namacustomer, namabarang, retur, terjual, tglup FROM sellin WHERE YEAR(tglup) between '"+ dari.substring(0, 4) +"' AND '"+ sampai.substring(0, 4) +"';";
            }
        } 
        
        if(!query.equals("")) {
            new AfifLuthfi("Laporan", query).setVisible(true);
        }
    }//GEN-LAST:event_btnTampilkanActionPerformed

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusLost

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        dateDari.setDate(null);
        dateSampai.setDate(null);
        checkboxSatuanWaktu.setSelected(true);
        comboBoxSatuanWaktu.setEnabled(true);
        comboBoxSatuanWaktu.setSelectedIndex(0);
        
        checkboxRentangWaktu.setSelected(false);
        comboBoxRentangWaktu.setEnabled(false);
        comboBoxRentangWaktu.setSelectedIndex(0);
    }//GEN-LAST:event_btnBatalActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnTampilkan;
    private javax.swing.JCheckBox checkboxRentangWaktu;
    private javax.swing.JCheckBox checkboxSatuanWaktu;
    private javax.swing.JComboBox<String> comboBoxRentangWaktu;
    private javax.swing.JComboBox<String> comboBoxSatuanWaktu;
    private com.toedter.calendar.JDateChooser dateDari;
    private com.toedter.calendar.JDateChooser dateSampai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
