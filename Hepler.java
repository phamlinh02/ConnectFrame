/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab12;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Thuy Linh
 */
public class Hepler {
    public static boolean  checkRong(JTextField tf , String mss){
        if (tf.getText().equals("")){
            JOptionPane.showMessageDialog(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }
    public static boolean checkSo(JTextField tf , String mss){
        try { 
            int so = Integer.parseInt(tf.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }
    public static boolean checkNgay(JTextField tf , String mss){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date date = sdf.parse(tf.getText());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }
}
