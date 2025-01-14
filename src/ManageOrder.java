
import ınventory.management.system.InventoryManagementSystem;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import static common.OpenPdf.OpenById;
import dao.ConnectionProvider;
import java.awt.Color;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.table.TableModel;
import dao.InvertoryUtils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Emirhan
 */
public class ManageOrder extends javax.swing.JFrame {

    private int customerPk = 0;
    private int productPk = 0;
    private int finalTotalPrice = 0;
    private String orderId = "";

    /**
     * Creates new form ManageOrder
     */
    public ManageOrder() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void clearProductFields() {
        productPk = 0;
        txtProductName.setText("");
        txtProductPrice.setText("");
        txtProductDescription.setText("");
        txtOrderQuantity.setText("");

    }

    public String getUniqueId(String prefix) {
        return prefix + System.nanoTime();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCustomerMobileNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCustomerEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtProductDescription = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtOrderQuantity = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lblFinalTotalPrice = new javax.swing.JLabel();
        btnSaveOrderDetails = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        jLabel1.setText("SİPARİŞ YÖNETİMİ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Müşteri listesi");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 128, -1, -1));

        tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "İsim", "Telefon Numarası", "Email"
            }
        ));
        tableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCustomer);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 379, 242));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Ürün listesi");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 128, -1, -1));

        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "İsim", "Fiyat", "Miktar", "Tanım", "Kategori ID", "Kategori İsmi"
            }
        ));
        tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableProduct);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 480, 242));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Ana Liste");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1107, 123, 80, 25));

        tableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "İsim", "Miktar", "Fiyat", "Tanım", "Ara Toplam"
            }
        ));
        tableCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCartMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableCart);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 180, 460, 242));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Seçilen Müşteri:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 437, 110, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("İsim");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 30, 20));

        txtCustomerName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 486, 373, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Telefon Numarası");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 517, 110, -1));

        txtCustomerMobileNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtCustomerMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 545, 373, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Email");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 581, -1, -1));

        txtCustomerEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtCustomerEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 601, 373, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Seçilen Ürün");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 120, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Ürün İsmi");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, 100, 20));

        txtProductName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, 490, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Ürün Fiyatı");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 526, 100, 20));

        txtProductPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtProductPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, 490, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Ürün Açıklaması");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 600, 130, 20));

        txtProductDescription.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtProductDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 630, 490, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Sipariş Miktarı");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 670, -1, -1));

        txtOrderQuantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtOrderQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 700, 490, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Listeye Ekle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 740, 490, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Toplam tutar :");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 440, 140, -1));

        lblFinalTotalPrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblFinalTotalPrice.setText("00000");
        getContentPane().add(lblFinalTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 440, -1, -1));

        btnSaveOrderDetails.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSaveOrderDetails.setText("Sipariş Ayrıntılarını Kaydet");
        btnSaveOrderDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveOrderDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(btnSaveOrderDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 490, 440, 20));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Sıfırla");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 560, 440, 20));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Kapat");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 630, 440, 20));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1366x768-arsenic-solid-color-background.jpg"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        txtCustomerName.setEditable(false);
        txtCustomerMobileNumber.setEditable(false);
        txtCustomerEmail.setEditable(false);

        txtProductName.setEditable(false);
        txtProductPrice.setEditable(false);
        txtProductDescription.setEditable(false);

        DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
        DefaultTableModel productModel = (DefaultTableModel) tableProduct.getModel();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from customer");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("customer_pk"), rs.getString("name"), rs.getString("mobileNumber"), rs.getString("email")});

            }
            rs = st.executeQuery("select * from product inner join category on product.category_fk = category.category_pk");
            while (rs.next()) {
                productModel.addRow(new Object[]{rs.getString("product_pk"), rs.getString("name"), rs.getString("price"), rs.getString("quantity"), rs.getString("description"), rs.getString("category_fk"), rs.getString(8)});

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_formComponentShown

    private void txtProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductNameActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new ManageOrder().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseClicked
        // TODO add your handling code here:
        int index = tableCustomer.getSelectedRow();
        TableModel model = tableCustomer.getModel();
        String id = model.getValueAt(index, 0).toString();
        customerPk = Integer.parseInt(id);
        String name = model.getValueAt(index, 1).toString();
        txtCustomerName.setText(name);
        String mobileNumber = model.getValueAt(index, 2).toString();
        txtCustomerMobileNumber.setText(mobileNumber);
        String email = model.getValueAt(index, 3).toString();
        txtCustomerEmail.setText(email);
        //btnSave.setEnabled(false);
        //btnUpdate.setEnabled(true);
    }//GEN-LAST:event_tableCustomerMouseClicked

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
        // TODO add your handling code here:
        int index = tableProduct.getSelectedRow();
        TableModel model = tableProduct.getModel();
        String id = model.getValueAt(index, 0).toString();
        productPk = Integer.parseInt(id);

        String productName = model.getValueAt(index, 1).toString();
        txtProductName.setText(productName);
        String productPrice = model.getValueAt(index, 2).toString();
        txtProductPrice.setText(productPrice);
        String productDescription = model.getValueAt(index, 4).toString();
        txtProductDescription.setText(productDescription);

    }//GEN-LAST:event_tableProductMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String noOfUnits = txtOrderQuantity.getText();
        if (!noOfUnits.equals("")) {
            String productName = txtProductName.getText();
            String productDescription = txtProductDescription.getText();
            String productPrice = txtProductPrice.getText();

            int totalPrice = Integer.parseInt(txtOrderQuantity.getText()) * Integer.parseInt(productPrice);
            int checkStock = 0;
            int checkProductAlreadyExistInCart = 0;

            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from product where product_pk=" + productPk + "");
                while (rs.next()) {
                    if (rs.getInt("quantity") >= Integer.parseInt(noOfUnits)) {
                        checkStock = 1;

                    } else {
                        JOptionPane.showMessageDialog(null, "Ürün Stoklarımızda Kalmamıştır.Sadece" + rs.getInt("quantity") + "kalmıştır");
                    }

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            if (checkStock == 1) {
                DefaultTableModel model = (DefaultTableModel) tableCart.getModel();
                if (tableCart.getRowCount() != 0) {
                    for (int i = 0; i < tableCart.getRowCount(); i++) {
                        if (Integer.parseInt(model.getValueAt(i, 0).toString()) == productPk) {
                            checkProductAlreadyExistInCart = 1;
                            JOptionPane.showMessageDialog(null, "Ürün zaten sepette mevcuttur.");
                        }
                    }
                }
                if (checkProductAlreadyExistInCart == 0) {
                    model.addRow(new Object[]{productPk, productName, noOfUnits, productPrice, productDescription, totalPrice});
                    finalTotalPrice = finalTotalPrice + totalPrice;
                    lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
                    JOptionPane.showMessageDialog(null, "Başarıyla eklendi");
                }
                clearProductFields();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Adet ve ürün alanı numarası gerekli değildir");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCartMouseClicked
        // TODO add your handling code here:
        int index = tableCart.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Bu ürünü kaldırmak ister misiniz?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            TableModel model = tableCart.getModel();
            String subTotal = model.getValueAt(index, 5).toString();
            finalTotalPrice = finalTotalPrice - Integer.parseInt(subTotal);
            lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
            ((DefaultTableModel) tableCart.getModel()).removeRow(index);
        }


    }//GEN-LAST:event_tableCartMouseClicked

    private void btnSaveOrderDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveOrderDetailsActionPerformed
        // TODO add your handling code here:
        if (finalTotalPrice != 0 && !txtCustomerName.getText().equals("")) {
            orderId = getUniqueId("Bill-");

            DefaultTableModel dtm = (DefaultTableModel) tableCart.getModel();
            if (tableCart.getRowCount() != 0) {
                for (int i = 0; i < tableCart.getRowCount(); i++) {
                    try {
                        Connection con = ConnectionProvider.getCon();
                        Statement st = con.createStatement();
                        st.executeUpdate("update product set quantity=quantity-" + Integer.parseInt(dtm.getValueAt(i, 2).toString()) + " where product_pk=" + Integer.parseInt(dtm.getValueAt(i, 0).toString()));

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
            try {
                SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("insert into orderDetail(orderId,customer_fk,orderDate,totalPaid) values (?,?,?,?)");
                ps.setString(1, orderId);
                ps.setInt(2, customerPk);
                ps.setString(3, myFormat.format(cal.getTime()));
                ps.setInt(4, finalTotalPrice);
                ps.executeUpdate();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            //Döküman oluşturma
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            try {
                SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();
                PdfWriter.getInstance(doc, new FileOutputStream(InvertoryUtils.billPath + "" + orderId + ".pdf"));
                doc.open();
                Paragraph projectName = new Paragraph("                                                        Envanter Yonetim Sistemi\n");
                doc.add(projectName);
                Paragraph starLine = new Paragraph("****************************************************************************************************************");
                doc.add(starLine);
                Paragraph details = new Paragraph("\tOrder ID: " + orderId + "\nDate: " + myFormat.format(cal.getTime()) + "\nTotal Paid: " + finalTotalPrice);
                doc.add(details);
                doc.add(starLine);
                PdfPTable tb1=new PdfPTable(5);
                 PdfPCell nameCell=new PdfPCell(new Phrase("Isim"));
                PdfPCell descriptionCell=new PdfPCell(new Phrase("Tanim"));
                PdfPCell priceCell=new PdfPCell(new Phrase("Birim Basina Fiyat"));
                PdfPCell quantityCell=new PdfPCell(new Phrase("Miktar"));
                PdfPCell subTotalPriceCell=new PdfPCell(new Phrase("Ara Toplam Fiyat"));
                
                BaseColor bacgroundColor=new BaseColor(255,204,51);
                nameCell.setBackgroundColor(bacgroundColor);
                descriptionCell.setBackgroundColor(bacgroundColor);
                priceCell.setBackgroundColor(bacgroundColor);
                quantityCell.setBackgroundColor(bacgroundColor);
                subTotalPriceCell.setBackgroundColor(bacgroundColor);
                
                tb1.addCell(nameCell);
                tb1.addCell(descriptionCell);
                tb1.addCell(priceCell);
                tb1.addCell(quantityCell);
                tb1.addCell(subTotalPriceCell);
                
                for(int i=0; i< tableCart.getRowCount();i++)
                {
                    tb1.addCell(tableCart.getValueAt(i, 1).toString());
                    tb1.addCell(tableCart.getValueAt(i, 4).toString());
                    tb1.addCell(tableCart.getValueAt(i, 3).toString());
                    tb1.addCell(tableCart.getValueAt(i, 2).toString());
                    tb1.addCell(tableCart.getValueAt(i, 5).toString());
                }
                
                doc.add(tb1);
                doc.add(starLine);
                Paragraph thanksMsg=new Paragraph("TESEKKURLER TEKRAR BEKLERIZ");
                doc.add(thanksMsg);
                
                OpenPdf.OpenById(orderId);

                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            doc.close();
            setVisible(false);
            new ManageOrder().setVisible(true);

        }
        else
        {
            JOptionPane.showMessageDialog(null, "lütfen karta ürün ekleyin veya müşteriyi seçin");
        }
    }//GEN-LAST:event_btnSaveOrderDetailsActionPerformed

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
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveOrderDetails;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFinalTotalPrice;
    private javax.swing.JTable tableCart;
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTextField txtCustomerEmail;
    private javax.swing.JTextField txtCustomerMobileNumber;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtOrderQuantity;
    private javax.swing.JTextField txtProductDescription;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    // End of variables declaration//GEN-END:variables
}
