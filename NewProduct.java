/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab12;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Lab12.ListProduct;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thuy Linh
 */
public class NewProduct extends javax.swing.JFrame {

    /**
     * Creates new form G2
     */
    ArrayList<Book> lst;
    static Book bk;
    ListProduct x;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public NewProduct() {
        initComponents();
        docFile();
    }

    public NewProduct(ListProduct frame) {
        initComponents();
        this.x = frame;
        this.lst = frame.lst;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void ktra() {
        if (Hepler.checkRong(txtLinhpttph16448, "Mã không đươc trống")) {
            return;
        }
        if(checkTrung(txtLinhpttph16448, "Đã có mã đó, nhập mã khác đê")) return;
        if (Hepler.checkRong(txtTen, "Tên không được trống")) {
            return;
        }
        if (Hepler.checkRong(txtSL, "Số lượng k được trống")) {
            return;
        }
        if (Hepler.checkSo(txtSL, "SL phải là số nguyên")) {
            return;
        }
        int sl = Integer.parseInt(txtSL.getText());
            if(sl<0){
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn hoặc bằng 0");
                return;
            }
        if (Hepler.checkRong(txtGia, "Giá không được trống")) {
            return;
        }
        if (Hepler.checkSo(txtGia, "giá phải là số")) {
            return;
        }
        BigDecimal gia = BigDecimal.valueOf(Double.parseDouble(txtGia.getText()));
        if (gia.equals(0)) {
            return;
        }
        if (gia.compareTo(new BigDecimal(0)) == -1) {
            JOptionPane.showMessageDialog(this, "giá phải lớn hơn 0");
            return;
        }
        if (Hepler.checkRong(txtNgayXB, "Ngày xuất bản không được trống")) {
            return;
        }
        if (Hepler.checkNgay(txtNgayXB, "Sai định dạng")) {
            return;
        }

        int ma = Integer.parseInt(txtLinhpttph16448.getText());
        String ten = txtTen.getText();

        Date ngayXB;
        try {
            ngayXB = sdf.parse(txtNgayXB.getText());
        } catch (Exception e) {
            return;
        }
        Date date = new Date();
        if (ngayXB.after(date)) {
            JOptionPane.showMessageDialog(this, "không được lớn hơn ngày hiện tại..");
            return;
        }

//        ListProduct lP = new ListProduct(ma, ten,sl, gia, txtNgayXB.getText());
//        lP.show();
        this.x.lst.add(new Book(ma, ten, sl, gia, ngayXB));
        this.x.model.addRow(new Object[]{ma, ten, sl, gia, this.x.lst.get(lst.size() - 1).getNgayXB()});
        JOptionPane.showMessageDialog(this, "Thêm mới thành công");
        this.dispose();
    }
    public boolean checkTrung(JTextField tf ,String mss){
        String ma = tf.getText();
        for (Book x : lst){
            if(ma.equals(String.valueOf(x.getMaSach()))){
                JOptionPane.showMessageDialog(this, mss);
               
                return true;
            }
        }
        return false;
    }
    public void ghiFile() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
            oos.writeObject(lst);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi ghi file");
        }
    }

    public void docFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
            lst = (ArrayList<Book>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi đoc file");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLinhpttph16448 = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNgayXB = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnPh16429 = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm mới sản phẩm");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("THÊM MỚI SẢN PHẨM");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setText("Mã sách");

        txtLinhpttph16448.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        txtTen.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel3.setText("Tên sách");

        txtSL.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel4.setText("Số Lượng");

        txtGia.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel5.setText("Đơn giá");

        txtNgayXB.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel6.setText("Ngày xuất bản");

        btnPh16429.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnPh16429.setText("Thêm mới");
        btnPh16429.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPh16429ActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                    .addGap(70, 70, 70)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtLinhpttph16448, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNgayXB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(btnPh16429)
                                .addGap(57, 57, 57)
                                .addComponent(btnHuy)))))
                .addContainerGap(135, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHuy, btnPh16429});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLinhpttph16448, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPh16429)
                    .addComponent(btnHuy))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPh16429ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPh16429ActionPerformed
        // TODO add your handling code here:
        ktra();

    }//GEN-LAST:event_btnPh16429ActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnPh16429;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtLinhpttph16448;
    private javax.swing.JTextField txtNgayXB;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
