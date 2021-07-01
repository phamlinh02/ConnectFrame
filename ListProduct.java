/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thuy Linh
 */
public class ListProduct extends javax.swing.JFrame {

    ArrayList<Book> lst = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
    DefaultTableModel model;
    private int ma, sl;
    private String ten, ngay;
    private BigDecimal gia;
    int index;

    public ListProduct() {
        initComponents();
        setLocationRelativeTo(null);
        lst.add(new Book(1, "Toán", 2, new BigDecimal(150000), new Date("02/12/1999")));
        lst.add(new Book(2, "Văn", 24, new BigDecimal(130000), new Date("02/11/1975")));
        lst.add(new Book(3, "Anh", 22, new BigDecimal(110000), new Date("11/04/2020")));
        lst.add(new Book(4, "Sử", 42, new BigDecimal(10000), new Date("03/12/2012")));
        lst.add(new Book(5, "Địa", 12, new BigDecimal(250000), new Date("10/01/1985")));
        model = (DefaultTableModel) tblSP.getModel();
        fillToTable();
        ghiFile();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void fillToTable() {
        model.setRowCount(0);
        for (Book x : lst) {
            model.addRow(new Object[]{x.getMaSach(), x.getTenSach(), x.getSoLuong(), x.getDonGia(), x.getNgayXB()});
        }

    }

    public void ghiFile() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
            oos.writeObject(lst);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi đọc file");
        }
    }

    public void docFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
            lst = (ArrayList<Book>) ois.readObject();
            if (!lst.isEmpty()) {
                fillToTable();
            }
            ois.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi ghi file");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblLinhptt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Danh sách sản phẩm");

        lblLinhptt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblLinhptt.setForeground(new java.awt.Color(0, 0, 255));
        lblLinhptt.setText("DANH SÁCH SẢN PHẨM");

        tblSP.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tblSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Số lượng", "Đơn giá", "Ngày xuất bản"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSP);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(lblLinhptt, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(btnThem)
                                .addGap(26, 26, 26)
                                .addComponent(btnSua)
                                .addGap(26, 26, 26)
                                .addComponent(btnXoa)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSua, btnThem, btnXoa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLinhptt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:

        NewProduct nw = new NewProduct(this);
        nw.show();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        try {
            index = tblSP.getSelectedRow();
            UpdateProduct uP = new UpdateProduct(this);
            uP.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chọn đê :v");
        }


    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        try {
            int[] chon = tblSP.getSelectedRows();
            int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?");
            if (hoi != JOptionPane.YES_OPTION) {
                return;
            } else {

                for (int i = 0; i < chon.length; i++) {
                    lst.remove(chon[i]);
                }
                fillToTable();
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chọn để xóa nèooo");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

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
            java.util.logging.Logger.getLogger(ListProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLinhptt;
    private javax.swing.JTable tblSP;
    // End of variables declaration//GEN-END:variables
}