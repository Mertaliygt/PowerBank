
package powerbank;

import com.sun.org.apache.xalan.internal.xsltc.cmdline.getopt.GetOpt;
import com.sun.prism.paint.Stop;
import static java.time.Clock.system;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import jdk.nashorn.internal.ir.BreakNode;
import jdk.nashorn.internal.ir.ContinueNode;


public class Powerbank {
     
   
    
    
   final static int kapasite = 100;
   final static int minsarj = 0;
   final static int maxsarj = 100;
   
   public int toplamfiyat;
   public int dene; 
   public int sarjoluyor;
   static int anliksarj;
   static int sayac = 0;
   static Timer myTimer = new Timer();
   static TimerTask gorev1 ;
   
   
    
    
    
    static void baslangic () {
       Scanner scanner = new Scanner(System.in);
        
        System.out.println("İşlemleri görmek için bekleyiniz...");
        
        
        System.out.println(" 1 : Şarjımı Doldur \n " + 
                 "2 : İade \n " + 
                 "3 : Fiyat Tarifesini Gör \n " +
                 "4 : İşlemi İptal Et \n ");
        
        System.out.print("İşlem :");
          
          int islemler = scanner.nextInt();
           
          switch(islemler) {
              
             
              case 1 :
                  
                  System.out.print("Şarjınız Belirtiniz :");
                  int x = scanner.nextInt();
                  
                  anliksarj = x;
                  
                  zaman();
                  break;
              case 3:
                  tarife();
                 
              case 4:
                  yazdırma();
                   break;
              case 2 :
                  System.out.println("Toplam Ücret 5 TL...");
                  break;
               
                       
          
          }
        
        
    }
    
    
    static void ücret(){
        
        
        if(sayac > 60 ) {
            
            System.out.println("Toplam Fiyatınız " + (35+sayac )+ " TL");
        }
        else if (sayac < 61)
        {
            System.out.println("Toplam Ücretiniz 35 TL...");
        }
    }
    
    static void tarife () {
        
        System.out.println("Fiyat Tarifemiz : \n"
                + "1 Saat Kullanım 30 TL \n"
                + "1 Saat Üstü Kullanım Dakika Başı 1 TL \n"
                + "Başlangıç Ücreti 5 TL...");
    }
    static void yazdırma () {
        
        System.out.println("Tekrardan bekleriz... ");
        
        
    }
    
    static void powerBankŞarjı () {
        
        int kapasite = (int)(Math.random() * 101)  ;
        
        if(kapasite < 0 ) {
            System.out.println("PowerBank Şarjınız Bitti...");
            System.err.println("Lütfen Yeni Bir Cihaz Alınız...");
       
        
        }
         
        
    }
   
    
        
            
            
    static void baslat () {
        
        System.out.println("Anlık Şarjınızı Belirtiniz ");
        
        Scanner s = new Scanner(System.in);
        
        int b = s.nextInt();
        
        anliksarj = b;
        
    }
    
   
    
    
    static void zaman () {
       powerBankŞarjı();
        //BURADAN AŞAĞISI ZAMAN KAVRAMINI BELİRTİYOR
        int random = (int)(Math.random() * 9875);
        gorev1 = new TimerTask() {
           @Override
           public void run() {
               System.out.println("Şarj Oluyor : "   +anliksarj);
               sayac++;
               anliksarj++;
               
               if( anliksarj == 101 ) {
                   System.err.println("Şarjınız Fullendi...");
                   System.err.println("PowerBank ID : " + random);
                   ücret();
                   myTimer.cancel();
                  
               
               }
           
           }
       
       };
        
         myTimer.schedule(gorev1, 0, 2000);
        
    }
    
    
    
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
        
        
       baslangic();
       
        
       
       
    }
    
}
