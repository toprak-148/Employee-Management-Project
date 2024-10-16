import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



//Çalışan işlemleri ve verileri alma işlemleri bu classta yapılmıştır
public class CalisanIslemleri {
    
    //Bağlantı oluşturmak için Connetion Objesi bize yardımcı olacaktır.
    private Connection con = null;
    
    
    
    //veri tabanında sorgularımızı çalıştırmak için kullandığımı obje
    private Statement STATEMENT = null;  
 
    
    
    //PreparedStatement SQL sorguları için kullanım kolaylığı syntax hatalarından kaçınmamızı sağlayan bir objedir
    private PreparedStatement PREPAREDSTATEMENT = null;
    
    
    public CalisanIslemleri()
    {
        //jbds:mysql://localhost:3306/demo ! ?unicode karakter sıkıntısı yaşamamak için
       String url = "jdbc:mysql://" + DataBase.HOST + ":" + DataBase.PORT + "/" + DataBase.DB_ISMI+ "?useUnicode=true&characterEncoding=utf8";
        
        //Bağlantı için yol verdik
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("Driver Bulunamadı" + ex);
        }
        
        //DriverManager.getConnection ile veri tabanına aldığımız parametrelerle eşliğinde bağlandık
        try{
            con = DriverManager.getConnection(url,DataBase.KULLANICI_ADI,DataBase.PASSWORD);
            System.out.println("bağlantı başarılı");
        
        }
        catch ( SQLException ex)
        {
            System.out.println("bağlantı başarısız" + ex);
           
        }
    }    
    
    
     
    
    public boolean girisYap(String KULLANICI_ADI,String PAROLA)
    {
        //Bir preparedstatemen oluşturarak kullanıcı adı ve parolayı göndereceğiz ve eğer böyle biri var ise result setten bir değer dönecek
        String SORGU ="Select * from adminler where username = ? and password = ?";
        try {
            PREPAREDSTATEMENT = con.prepareStatement(SORGU);
            PREPAREDSTATEMENT.setString(1,KULLANICI_ADI);
            PREPAREDSTATEMENT.setString(2,PAROLA);
            ResultSet RS = PREPAREDSTATEMENT.executeQuery();
            return RS.next();//RS bir değer dönerse true dönmez ise false olacaktır
        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false ; //eğer bir exception halinde false değeri dönecektir..
        }
        
         
    }
    
    
    public ArrayList<Calisan> calisanlariGetir()
    {
        //Database'den her bilgi aldığımızda çıktı objesine ekleyeceğiz ve bir çıktı döneceğiz.
        ArrayList<Calisan> CIKTI = new ArrayList<Calisan>();
        
        try {
             STATEMENT = con.createStatement();
            String SORGU = "Select * from calisanlar";
            
            ResultSet RS = STATEMENT.executeQuery(SORGU);
            
            while(RS.next())
            {
               int ID = RS.getInt("id");
               String AD = RS.getString("ad");
               String SOYAD = RS.getString("soyad");
               String EMAIL = RS.getString("email");
               String DEPARTMAN = RS.getString("departman");
               String MAAS = RS.getString("maas");
               
               //artık bundan sonra bizim her yeni çalışanımız buradaki çıktıya eklenecek
               CIKTI.add(new Calisan(ID,AD, SOYAD, EMAIL, DEPARTMAN, MAAS));
               
               
               
            }
            //Çalışanları döndermek için lazım
            return CIKTI;
                    
        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null; // Eğer exception oluşursa hiçbir şey dönme
        }
        
        
    }
    
    
    public void calisanEkle(String AD , String SOYAD,String EMAIL,String DEPARTMAN,String MAAS)
    {
        String SORGU = "insert into calisanlar (ad,soyad,email,departman,maas) values (?,?,?,?,?)";
        try {
            PREPAREDSTATEMENT = con.prepareStatement(SORGU);
            PREPAREDSTATEMENT.setString(1, AD);
            PREPAREDSTATEMENT.setString(2,SOYAD);
            PREPAREDSTATEMENT.setString(3, EMAIL);
            PREPAREDSTATEMENT.setString(4,DEPARTMAN);
            PREPAREDSTATEMENT.setString(5,MAAS);
            
            PREPAREDSTATEMENT.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void calisanGuncelle(int ID ,String YENI_AD,String YENI_SOYAD,String YENI_EMAIL,String YENI_DEPARTMAN,String YENI_MAAS)
    {
        String SORGU = "Update calisanlar set ad = ? , soyad = ? , email = ? , departman = ? , maas = ? where id = ?";
        try {
            PREPAREDSTATEMENT = con.prepareStatement(SORGU);
            PREPAREDSTATEMENT.setString(1, YENI_AD);
            PREPAREDSTATEMENT.setString( 2,YENI_SOYAD);
            PREPAREDSTATEMENT.setString(3, YENI_EMAIL);
            PREPAREDSTATEMENT.setString(4, YENI_DEPARTMAN);
            PREPAREDSTATEMENT.setString(5, YENI_MAAS);
            PREPAREDSTATEMENT.setInt(6,ID);
            
            PREPAREDSTATEMENT.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void calisanSil(int ID)
    {
        String SORGU = "Delete from calisanlar where id = ? ";
        try {
            PREPAREDSTATEMENT = con.prepareStatement(SORGU);
            PREPAREDSTATEMENT.setInt(1, ID);
            
            PREPAREDSTATEMENT.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
