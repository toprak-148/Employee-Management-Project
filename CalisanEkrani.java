
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

 
public class CalisanEkrani extends javax.swing.JDialog {
    
    DefaultTableModel MODEL;
    
    CalisanIslemleri CALISANISLEMLER = new CalisanIslemleri();
    

    
    public void calisanGoruntule(){
          
        //Tabloyu sıfırlamalıyız yoksa bazen hatalar çıkabilir.
        //Tabloyu ilk başta her zaman boşaltmalıyız.
        MODEL.setRowCount(0); // tablo her seferinde boş başlayacaktır.
        ArrayList<Calisan> CALISANLAR = new ArrayList<Calisan>();
        // Burada çalışan işlemleri içinde ki yazılan bir metodda bir tane Çalışan objeleri taşıyan bir array list dönecektir onun için
        //ArrayList objesi oluşturuldu
        CALISANLAR = CALISANISLEMLER.calisanlariGetir();
        if(CALISANLAR != null)
        {
            for(Calisan calisan : CALISANLAR)
            {
                Object[] EKLENECEK = {calisan.getID(),calisan.getAD(),calisan.getSOYAD(),calisan.getEMAIL(),calisan.getDEPARTMAN(),calisan.getMAAS()};
                MODEL.addRow(EKLENECEK);
                
            }
        }
        
    }
    
    public CalisanEkrani(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        MODEL =(DefaultTableModel) calisanTablosu.getModel(); //tekrar tekrar run edilmesini önledik
        calisanGoruntule();//tablo constructorun içinde direkt çalışsın ve çalışanlar direkt görünsün
        
    }

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        calisanTablosu = new javax.swing.JTable();
        arama_cubugu = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ad_alani = new javax.swing.JTextField();
        soyad_alani = new javax.swing.JTextField();
        email_alani = new javax.swing.JTextField();
        departman_alani = new javax.swing.JTextField();
        maas_alani = new javax.swing.JTextField();
        mesaj_yazisi = new javax.swing.JLabel();
        mesaj_alani = new javax.swing.JLabel();
        calisan_ekle = new javax.swing.JButton();
        guncelle = new javax.swing.JButton();
        sil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        calisanTablosu.setBackground(new java.awt.Color(204, 204, 255));
        calisanTablosu.setForeground(new java.awt.Color(255, 51, 0));
        calisanTablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "AD", "SOYAD", "E-MAIL", "DEPARTMAN", "MAAŞ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        calisanTablosu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calisanTablosuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(calisanTablosu);
        if (calisanTablosu.getColumnModel().getColumnCount() > 0) {
            calisanTablosu.getColumnModel().getColumn(0).setResizable(false);
            calisanTablosu.getColumnModel().getColumn(1).setResizable(false);
            calisanTablosu.getColumnModel().getColumn(2).setResizable(false);
            calisanTablosu.getColumnModel().getColumn(3).setResizable(false);
        }

        arama_cubugu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                arama_cubuguKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Ad");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Soyad");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("E-mail");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Departman");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Maaş");

        ad_alani.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        soyad_alani.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        soyad_alani.setText("              ");

        email_alani.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        departman_alani.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        maas_alani.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        calisan_ekle.setText("Yeni Çalışan Ekle");
        calisan_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calisan_ekleActionPerformed(evt);
            }
        });

        guncelle.setText("Çalışan Güncelle");
        guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncelleActionPerformed(evt);
            }
        });

        sil.setText("Çalışan Sil");
        sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(departman_alani, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(maas_alani, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(soyad_alani, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(ad_alani)
                            .addComponent(email_alani))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calisan_ekle)
                            .addComponent(guncelle)
                            .addComponent(sil, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(180, 180, 180))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mesaj_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mesaj_yazisi, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(arama_cubugu))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(arama_cubugu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ad_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calisan_ekle)
                    .addComponent(soyad_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(email_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(guncelle)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sil, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(departman_alani, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maas_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mesaj_yazisi)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mesaj_alani)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(248, 248, 248))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void dinamikAra(String ARA)
    {
        //Table üzerinde dinamik arama yapmak için TableRowSorter nesnesi
        TableRowSorter<DefaultTableModel> TR = new TableRowSorter<DefaultTableModel>(MODEL);
        //calisanTablosu üzerinde dinamik bir arama yapmak istediğimizi söylüyoruz
        calisanTablosu.setRowSorter(TR);
        
        
        // regexFilter string üzerinde belirli bir yapıyı arama modelidir. 
        TR.setRowFilter(RowFilter.regexFilter(ARA));
        
        
        
        //Sonuç olarak tablomuzu filtreleyerek arama işlemi yaptık
        
        
        
    }
    private void arama_cubuguKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_arama_cubuguKeyReleased
        
        String ARA = arama_cubugu.getText();
        dinamikAra(ARA);
    }//GEN-LAST:event_arama_cubuguKeyReleased

    
     
    private void calisan_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calisan_ekleActionPerformed
        mesaj_alani.setText("");
        String AD = ad_alani.getText();
        String SOYAD = soyad_alani.getText();
        String EMAIL = email_alani.getText();
        String DEPARTMAN = departman_alani.getText();
        String MAAS = maas_alani.getText();
        
        CALISANISLEMLER.calisanEkle(AD,SOYAD,EMAIL,DEPARTMAN,MAAS);
        calisanGoruntule();
        
        mesaj_alani.setText("Yeni Çalışan Başarı ile eklendi " + ad_alani.getText() + " " + soyad_alani.getText());
    }//GEN-LAST:event_calisan_ekleActionPerformed

    private void calisanTablosuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calisanTablosuMouseClicked
        //getSelectedRow işlemi ile çalışan tablosundaki satırın hangi satır seçilmiş ise onun indexini alıyoruz
        int SELECTED_ROW  = calisanTablosu.getSelectedRow();
        
        ad_alani.setText(MODEL.getValueAt(SELECTED_ROW,1).toString());
        soyad_alani.setText(MODEL.getValueAt(SELECTED_ROW,2).toString());
        email_alani.setText(MODEL.getValueAt(SELECTED_ROW,3).toString());
        departman_alani.setText(MODEL.getValueAt(SELECTED_ROW,4).toString());
        maas_alani.setText(MODEL.getValueAt(SELECTED_ROW, 5).toString());
        
        
    }//GEN-LAST:event_calisanTablosuMouseClicked

    private void guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncelleActionPerformed
        
        String AD = ad_alani.getText();
        String SOYAD = soyad_alani.getText();
        String EMAIL = email_alani.getText();
        String DEPARTMAN = departman_alani.getText();
        String MAAS = maas_alani.getText();
        
        int SELECTED_ROW = calisanTablosu.getSelectedRow();
        
        //Tıklanılan satırda birşey yoksa veya tablo direkt boş ise
        if(SELECTED_ROW == -1)
        {
            //Tablo boş mu ?
            if(MODEL.getRowCount() == 0){
                mesaj_alani.setText("Çalışanlar tablosu şu anda boş");
            }
            //Tablo boş değildir ama herhangi bir yere tıklanmamıştır.
            else{
                mesaj_alani.setText("Lütfen güncellenecek bir çalışan seç");
            }
           
        }
        else{
            //ID ' ye göre güncelleme işlemi yapıcaz çünkü ID primary key olarak atandı veri tabanında
            int ID  = (int) MODEL.getValueAt(SELECTED_ROW,0);//Seçilen satırır 0.kolonu ( ID ) yi aldık
            CALISANISLEMLER.calisanGuncelle(ID,AD,SOYAD,EMAIL,DEPARTMAN,MAAS);
            
            calisanGoruntule();
            mesaj_alani.setText("Çalışan başarıyla güncellendi");
            
        }
        

    }//GEN-LAST:event_guncelleActionPerformed

    private void silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silActionPerformed
        
        mesaj_alani.setText("");
        int SELECTED_ROW = calisanTablosu.getSelectedRow(); // seçili olan satırın indexini buldu
        
        if(SELECTED_ROW  == -1)
        {
            //Tablo boş ise
            if(MODEL.getRowCount() == 0)
            {
                mesaj_alani.setText("Çalışan Tablosu şu anda boş");
            }
            else{
                mesaj_alani.setText("Lütfen silinecek bir çalışan seçiniz");
            }
            
        }
        else{
            int ID = (int)MODEL.getValueAt(SELECTED_ROW,0);
            
            CALISANISLEMLER.calisanSil(ID);
            
            calisanGoruntule();
            mesaj_alani.setText("Çalışan başarı ile silindi" + ad_alani.getText());
        }
        
     }//GEN-LAST:event_silActionPerformed

     
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CalisanEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalisanEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalisanEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalisanEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CalisanEkrani dialog = new CalisanEkrani(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ad_alani;
    private javax.swing.JTextField arama_cubugu;
    private javax.swing.JTable calisanTablosu;
    private javax.swing.JButton calisan_ekle;
    private javax.swing.JTextField departman_alani;
    private javax.swing.JTextField email_alani;
    private javax.swing.JButton guncelle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField maas_alani;
    private javax.swing.JLabel mesaj_alani;
    private javax.swing.JLabel mesaj_yazisi;
    private javax.swing.JButton sil;
    private javax.swing.JTextField soyad_alani;
    // End of variables declaration//GEN-END:variables
}
