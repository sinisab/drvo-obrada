import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.io.PrintStream;

public class Baza {
	
	static final int max=56;
	static Stanje st[]=new Stanje[max+1];
	static Connection conn=null;
	static PreparedStatement pS;
	static ResultSet rs;
	static String ime="magacin";
	static String korisnickoIme = "root";	
    static String sifra = "JavaMySql";
    static String adresa = "jdbc:mysql://localhost:3307/"+ime;
    
    static public boolean backupDB(String dbName, String dbUserName, String dbPassword, String path) {
		  String executeCmd = "mysqldump -u " + dbUserName + " -p" + dbPassword + " --add-drop-database -B " + dbName + " -r " + path;
		  Process runtimeProcess;		  
		          try {		  
		              runtimeProcess = Runtime.getRuntime().exec(executeCmd);		  
		              int processComplete = runtimeProcess.waitFor();		  
		              if (processComplete == 0) 
		              {		  
		            	  JOptionPane.showOptionDialog(null, 
		            		        "Kopija baze je uspješno napravljena.", 
		            		        "Poruka", 
		            		        JOptionPane.OK_OPTION, 
		            		        JOptionPane.INFORMATION_MESSAGE, 
		            		        null, 
		            		        new String[]{"U redu"}, // this is the array
		            		        "default");		  
		                  return true;		 
		              } 
		              else 
		              {		  
		            	  JOptionPane.showOptionDialog(null, 
		            		        "Kopija baze nije uspješno napravljena!", 
		            		        "Poruka o grešci", 
		            		        JOptionPane.OK_OPTION, 
		            		        JOptionPane.ERROR_MESSAGE, 
		            		        null, 
		            		        new String[]{"U redu"}, // this is the array
		            		        "default");				  
		              }		  
		          } catch (Exception e) {
		              e.printStackTrace();		  
		          }	  
		          return false;	  
		      }

	  
	  static public boolean restoreDB(String dbUserName, String dbPassword, String source) {	   
		 
		          String[] executeCmd = new String[]{"mysql", "--user=" + dbUserName, "--password=" + dbPassword, "-e", "source "+source};
		          Process runtimeProcess;		 
		          try 
		          {	
		        	  runtimeProcess = Runtime.getRuntime().exec(executeCmd);		  
		              int processComplete = runtimeProcess.waitFor();		 
		              if (processComplete == 0) 
		              {
		            	  JOptionPane.showOptionDialog(null, 
		            		        "Prethodno stanje baze je uspješno vraćeno.", 
		            		        "Poruka", 
		            		        JOptionPane.OK_OPTION, 
		            		        JOptionPane.INFORMATION_MESSAGE, 
		            		        null, 
		            		        new String[]{"U redu"}, // this is the array
		            		        "default");			 
		                  return true;		  
		              } 
		              else 
		              {		  
		            	  JOptionPane.showOptionDialog(null, 
		            		        "Prethodno stanje baze nije uspješno vraćeno!", 
		            		        "Poruka o grešci", 
		            		        JOptionPane.OK_OPTION, 
		            		        JOptionPane.ERROR_MESSAGE, 
		            		        null, 
		            		        new String[]{"U redu"}, // this is the array
		            		        "default");				                   
		              }		  
		          } 
		          catch (Exception e) {		  
		              e.printStackTrace();		 
		          }	
		          return false;		 
		      }

        
    static void konekcija()
	   {		   
        try
        {
     	   Class.forName ("com.mysql.jdbc.Driver").newInstance ();
     	   conn = DriverManager.getConnection (adresa, korisnickoIme, sifra);
     	  /*JOptionPane.showOptionDialog(null, 
  		        "Konekcija sa bazom je uspostavljena.", 
  		        "Poruka", 
  		        JOptionPane.OK_OPTION, 
  		        JOptionPane.INFORMATION_MESSAGE, 
  		        null, 
  		        new String[]{"U redu"}, // this is the array
  		        "default");	*/	     	   
        }
        catch(Exception e)
        {
        	JOptionPane.showOptionDialog(null, 
      		        "Konekcija sa bazom nije uspostavljena!", 
      		        "Poruka o grešci", 
      		        JOptionPane.OK_OPTION, 
      		        JOptionPane.ERROR_MESSAGE, 
      		        null, 
      		        new String[]{"U redu"}, // this is the array
      		        "default");		              
        }  
	   }

    static void diskonekcija()
	   {
		   if (conn != null)
        {
            try
            {
                conn.close ();
                /*JOptionPane.showOptionDialog(null, 
          		        "Konekcija sa bazom je zatvorena.", 
          		        "Poruka", 
          		        JOptionPane.OK_OPTION, 
          		        JOptionPane.INFORMATION_MESSAGE, 
          		        null, 
          		        new String[]{"U redu"}, // this is the array
          		        "default");	*/	                
            }
            catch (Exception e)
            {
         	   //ignorisemo greske zatvaranja konekcije
            }            
        }
	   }  
    
    static void ucitajStanje()
    {
    	String podaciS;
		double podaciD;
    	try
    	{    				
    		pS=conn.prepareStatement("SELECT trsm FROM stanje");
    		/*ResultSet*/ rs = pS.executeQuery("SELECT nazm, trsm FROM materijal, stanje WHERE rbrm=rbrs");
    		int i=0;
    		while (rs.next()) {
    			i++;
    			st[i]=new Stanje();
	        	podaciS = rs.getString("nazm");
	        	st[i].nazivMaterijala=podaciS;
	        	podaciD = rs.getDouble("trsm");
	        	st[i].trenutnoStanje=podaciD;
	       }
    	}
    	catch (Exception e)
        {
    		JOptionPane.showOptionDialog(null, 
      		        "Pripremljene naredbe nisu uspješno izvršene!", 
      		        "Poruka o grešci", 
      		        JOptionPane.OK_OPTION, 
      		        JOptionPane.ERROR_MESSAGE, 
      		        null, 
      		        new String[]{"U redu"}, // this is the array
      		        "default");	           
        } 
        	finally {
                try {
                    if (pS!=null) {
                        pS.close();
                    }
                }
                catch (Exception e)
                {
                	JOptionPane.showOptionDialog(null, 
              		        "Pripremljene naredbe nisu uspješno zatvorene!", 
              		        "Poruka o grešci", 
              		        JOptionPane.OK_OPTION, 
              		        JOptionPane.ERROR_MESSAGE, 
              		        null, 
              		        new String[]{"U redu"}, // this is the array
              		        "default");	                    
                }
    	}
    }
    
    static void promjeniStanje(int brSt, double vr)
    {
    	try
    	{    		
    	  	pS = conn.prepareStatement("UPDATE stanje SET trsm=(?) WHERE rbrs=(?)");
    	  	pS.setDouble(1, vr);
    	  	pS.setInt(2, brSt);
    	  	pS.executeUpdate();
        }
    	catch (Exception e)
        {
    		JOptionPane.showOptionDialog(null, 
      		        "Pripremljene naredbe nisu uspješno izvršene!", 
      		        "Poruka o grešci", 
      		        JOptionPane.OK_OPTION, 
      		        JOptionPane.ERROR_MESSAGE, 
      		        null, 
      		        new String[]{"U redu"}, // this is the array
      		        "default");	             
        }
    	finally {
            try {
                if (pS!=null) {
                	pS.close();
                }
            }
            catch (Exception e)
            {
            	JOptionPane.showOptionDialog(null, 
          		        "Pripremljene naredbe nisu uspješno zatvorene!", 
          		        "Poruka o grešci", 
          		        JOptionPane.OK_OPTION, 
          		        JOptionPane.ERROR_MESSAGE, 
          		        null, 
          		        new String[]{"U redu"}, // this is the array
          		        "default");	                 
            }
    	}
    }
    
    static void dodajNaStanje(int brSt, double vr)
    {
    		st[brSt].trenutnoStanje=st[brSt].trenutnoStanje+vr;
    		promjeniStanje(brSt, st[brSt].trenutnoStanje); 
    		if (PocetniJF.stanje.isShowing())
    		{
    			int i=brSt;
    			if ((i>=1)&&(i<=18))
    				PocetniJF.stanje.tProzori.setValueAt(st[i].trenutnoStanje, i-1, 1);
    			/*else
    				if ((i>=38)&&(i<=43))
    				PocetniJF.stanje.tProzori.setValueAt(st[i].trenutnoStanje, i-28, 1);
    				else
    					if (i==53)
    						PocetniJF.stanje.tProzori.setValueAt(st[i].trenutnoStanje, 16, 1);*/
    					else
    						if ((i>=19)&&(i<=56))
    							PocetniJF.stanje.tVrata.setValueAt(st[i].trenutnoStanje, i-19, 1);
    						/*else
    							if ((i>=44)&&(i<=52))
    								PocetniJF.stanje.tVrata.setValueAt(st[i].trenutnoStanje, i-17, 1);*/
    		}
    } 
        
    static boolean provjeriStanje(int brSt, double vr)
    {
    	if (st[brSt].trenutnoStanje>=vr)
    		return true;
    		else
    		{
    			double r=vr-st[brSt].trenutnoStanje;
    			JOptionPane.showOptionDialog(null, 
    					"Na stanju nedostaje materijala: "+r+" ("+st[brSt].nazivMaterijala+")!", 
          		        "Upozorenje", 
          		        JOptionPane.OK_OPTION, 
          		        JOptionPane.WARNING_MESSAGE, 
          		        null, 
          		        new String[]{"U redu"}, // this is the array
          		        "default");	                   
                    return false;
    		}
    }
    
    static void skiniSaStanja(int brSt, double vr)
    {    	
    		double r=st[brSt].trenutnoStanje-vr;
    		st[brSt].trenutnoStanje=r;
    		promjeniStanje(brSt, r);
    		if (PocetniJF.stanje.isShowing())
    		{
    			int i=brSt;
    			if ((i>=1)&&(i<=18))
    				PocetniJF.stanje.tProzori.setValueAt(r, i-1, 1);
    			/*else
    				if ((i>=38)&&(i<=43))
    				PocetniJF.stanje.tProzori.setValueAt(r, i-28, 1);
    				else
    					if (i==53)
    						PocetniJF.stanje.tProzori.setValueAt(r, 16, 1);*/
    					else
    						if ((i>=19)&&(i<=56))
    							PocetniJF.stanje.tVrata.setValueAt(r, i-19, 1);
    						/*else
    							if ((i>=44)&&(i<=52))
    								PocetniJF.stanje.tVrata.setValueAt(r, i-17, 1);	*/
    		}
    }
    
    static boolean provjeriStanjeP(Prozor p, int brPr)
    {
    	boolean t=true;
    	t=t& provjeriStanje(7, brPr*p.sirina*0.01);//AL okapnica za stok [m]
    	t=t& provjeriStanje(8, brPr*p.sirina*0.01);//AL okapnica za krilo [m]
    	t=t& provjeriStanje(5, brPr*p.visina*p.sirina*0.0004);//Osnovni dihtung [m]
    	t=t& provjeriStanje(6, brPr*(p.brojDihtunga-1)*p.visina*p.sirina*0.0004);//Dodatni dihtung [m]
    	if (p.okov=="lijevi")
    		t=t& provjeriStanje(2, brPr);//Okov [paket]
    	if (p.okov=="desni")
    		t=t& provjeriStanje(3, brPr);    	
    	if (p.kvaka=="poluoliva")
    		t=t& provjeriStanje(9, brPr);
    	else
    		if (p.kvaka=="obicna")
    			t=t& provjeriStanje(10, brPr);
    	if (p.visina>160)
    		t=t& provjeriStanje(1, brPr*p.sirina*0.01+brPr*p.visina*p.sirina*0.0008);
    	else
    		t=t& provjeriStanje(1, brPr*p.visina*p.sirina*0.0008);//Prozorska stafla [m]
    		//Vuce jos kolika je sirina prozorske stafle, ako je h>160cm
    	if (p.dvokrilni)
    		{
    		t=t& provjeriStanje(4, brPr*2);//Roto ringla [komad]
    		t=t& provjeriStanje(26, brPr*2);//Baglama obicna [komad]
    		}
    	if (p.nijansa=="orah")
    		t=t& provjeriStanje(11, brPr*p.visina*p.sirina*0.00004);//Impregnacija orah [kg]
    	else
    		if (p.nijansa=="f5")
    			t=t& provjeriStanje(12, brPr*p.visina*p.sirina*0.00004);//Impregnacija f5 [kg]
    		else
    			if (p.nijansa=="tresnja")
    				t=t& provjeriStanje(13, brPr*p.visina*p.sirina*0.00004);//Impregnacija tresnja [kg]
    			else
    				if (p.nijansa=="zuta")
    					t=t& provjeriStanje(14, brPr*p.visina*p.sirina*0.00004);//Impregnacija zuta [kg]
    				else
    					if (p.nijansa=="bijela")
        					t=t& provjeriStanje(15, brPr*p.visina*p.sirina*0.00004);//Impregnacija bijela [kg]
    	if(p.lakiranje)
    	{
    		t=t& provjeriStanje(16, brPr*p.visina*p.sirina*0.00004);//Temeljni lak vodeni program [kg]
        	t=t& provjeriStanje(17, brPr*p.visina*p.sirina*0.00004);//Zavrsni lak vodeni program
    	}    	
    	t=t& provjeriStanje(18, brPr*p.visina*p.sirina*0.00004);//Ljepilo hladno [kg]
    	if (t)
    	return true;
    	else
    		return false;
    }

    static void povuciSaMagacinaP(Prozor p, int brPr)
    {
    	 skiniSaStanja(7, brPr*p.sirina*0.01);//AL okapnica za stok [m]
    	 skiniSaStanja(8, brPr*p.sirina*0.01);//AL okapnica za krilo [m]
    	 skiniSaStanja(5, brPr*p.visina*p.sirina*0.0004);//Osnovni dihtung [m]
    	 skiniSaStanja(6, brPr*(p.brojDihtunga-1)*p.visina*p.sirina*0.0004);//Dodatni dihtung [m]
    	 if (p.okov=="lijevi")//posebno za lijevi a posebno za desni
    		 skiniSaStanja(2, brPr);//Okov [paket]
    	 if (p.okov=="desni")//posebno za lijevi a posebno za desni
    		 skiniSaStanja(3, brPr);
    	if (p.kvaka=="poluoliva")
    		 skiniSaStanja(9, brPr);
    	else
    		if (p.kvaka=="obicna")
    			 skiniSaStanja(10, brPr);
    	if (p.visina>160)
    		skiniSaStanja(1, brPr*p.sirina*0.01+brPr*p.visina*p.sirina*0.0008);
    	else
    		skiniSaStanja(1, brPr*p.visina*p.sirina*0.0008);//Prozorska stafla [m]
    		//Vuce jos kolika je sirina prozorske stafle, ako je h>160cm
    	if (p.dvokrilni)
    		{
    			 skiniSaStanja(4, brPr*2);//Roto ringla [komad]
    			 skiniSaStanja(26, brPr*2);//Baglama obicna [komad]
    		}
    	if (p.nijansa=="orah")
    		 skiniSaStanja(11, brPr*p.visina*p.sirina*0.00004);//Impregnacija orah [kg]
    	else
    		if (p.nijansa=="f5")
    			 skiniSaStanja(12, brPr*p.visina*p.sirina*0.00004);//Impregnacija f5 [kg]
    		else
    			if (p.nijansa=="tresnja")
    				 skiniSaStanja(13, brPr*p.visina*p.sirina*0.00004);//Impregnacija tresnja [kg]
    			else
    				if (p.nijansa=="zuta")
    					 skiniSaStanja(14, brPr*p.visina*p.sirina*0.00004);//Impregnacija zuta [kg]
    				else
    					if (p.nijansa=="bijela")
       					 skiniSaStanja(15, brPr*p.visina*p.sirina*0.00004);//Impregnacija bijela [kg]
    	if(p.lakiranje)
    	{
    		skiniSaStanja(16, brPr*p.visina*p.sirina*0.00004);//Temeljni lak vodeni program [kg]
       	 	skiniSaStanja(17, brPr*p.visina*p.sirina*0.00004);//Zavrsni lak vodeni program [kg]
    	}
    	 
    	skiniSaStanja(18, brPr*p.visina*p.sirina*0.00004);//Ljepilo hladno [kg]
    }
    
    static boolean provjeriStanjeV(Vrata v, int brKr)
    {
    	boolean t=true;
    	t=t&provjeriStanje(24, brKr*5);//Dihtung za vrata [m]
    	if (v.falcovana)
    		t=t&provjeriStanje(26, brKr*2);//Baglama obicna [komad]
    	else
    		t=t&provjeriStanje(25, brKr*2);//Baglama leptir [komad]
    	//za sva vrata bajc se unosi rucno
    	if (v.model=="hdf")
    	{
    		if (v.hdf=="bukva")
    			t=t&provjeriStanje(27, brKr*3.75);//hdf bukva [m^2]
    		else
    			if (v.hdf=="hrast")
    				t=t&provjeriStanje(28, brKr*3.75);//hdf hrast [m^2]
    			else
    				if (v.hdf=="tresnja")
    					t=t&provjeriStanje(29, brKr*3.75);//hdf tresnja [m^2]
    		t=t&provjeriStanje(44, brKr);//Izolaciono sace [komad]
    		if (v.brava=="kljuc")
    			t=t&provjeriStanje(22, brKr);//brava na kljuc [komad]
    		else
    			if (v.brava=="cilindar")
    				t=t&provjeriStanje(23, brKr);//brava na cilindar [komad]
    		if (v.kvaka=="elal")
    			t=t&provjeriStanje(20, brKr);//kvaka eloksirani aluminujum [komad]
    		else
    			if (v.kvaka=="inoks")
    				t=t&provjeriStanje(21, brKr);//kvaka inoks [komad]
    		if (v.sirokiStok)
    			t=t&provjeriStanje(19, brKr*0.11);//Drvena ploca [m^3]
    		else
    			t=t&provjeriStanje(19, brKr*0.06);//Drvena ploca [m^3]
    		if (v.hdf=="bukva")
    			t=t&provjeriStanje(37, brKr*5);//Kant traka hdf bukva [m]
    		else
    			if (v.hdf=="hrast")
    				t=t&provjeriStanje(38, brKr*5);//Kant traka hdf hrast [m]
    			else
    				if (v.hdf=="tresnja")
    					t=t&provjeriStanje(39, brKr*5);//Kant traka hdf tresnja [m]
    		t=t&provjeriStanje(51, brKr*0.5);//Temeljni lak PU program [kg]
    		t=t&provjeriStanje(52, brKr*0.5);//Zavrsni lak PU program [kg]
    		t=t&provjeriStanje(53, brKr*0.5);//Herter [kg]
    		t=t&provjeriStanje(54, brKr*0.5);//Razredjivac [kg]
    		t=t&provjeriStanje(55, brKr*0.5);//Ljepilo toplo [kg]
    		if (v.nijansa=="orah")
    			t=t&provjeriStanje(46, brKr*v.bajc); //Bajc orah [kg]
    		else
    			if (v.nijansa=="f5")
    				t=t&provjeriStanje(47, brKr*v.bajc); //Bajc f5 [kg]
    			else
    				if (v.nijansa=="tresnja")
    					t=t&provjeriStanje(48, brKr*v.bajc); //Bajc tresnja [kg]
    				else
    					if (v.nijansa=="zuta")
    						t=t&provjeriStanje(49, brKr*v.bajc); //Bajc zuta [kg]
    					else
    						if (v.nijansa=="bijela")
        						t=t&provjeriStanje(50, brKr*v.bajc); //Bajc bijela [kg]
    	}
    	else
    	if (v.model=="mdf")
    	{
    		t=t&provjeriStanje(44, brKr);//Izolaciono sace [komad]
    		t=t&provjeriStanje(31, brKr*4);//MDF 10 mm [m^2]
    		if (v.brava=="kljuc")
    			t=t&provjeriStanje(22, brKr);//brava na kljuc [komad]
    		else
    			if (v.brava=="cilindar")
    				t=t&provjeriStanje(23, brKr);//brava na cilindar [komad]
    		if (v.kvaka=="elal")
    			t=t&provjeriStanje(20, brKr);//kvaka eloksirani aluminujum [komad]
    		else
    			if (v.kvaka=="inoks")
    				t=t&provjeriStanje(21, brKr);//kvaka inoks [komad]
    		if (v.sirokiStok)
    			t=t&provjeriStanje(19, brKr*0.11);//Drvena ploca [m^3]
    		else
    			t=t&provjeriStanje(19, brKr*0.06);//Drvena ploca [m^3]
    		t=t&provjeriStanje(51, brKr*0.5);//Temeljni lak PU program [kg]
    		t=t&provjeriStanje(52, brKr*0.5);//Zavrsni lak PU program [kg]
    		t=t&provjeriStanje(53, brKr*0.5);//Herter [kg]
    		t=t&provjeriStanje(54, brKr*0.5);//Razredjivac [kg]
    		t=t&provjeriStanje(55, brKr*0.5);//Ljepilo toplo [kg]
    		if (v.nijansa=="orah")
    			t=t&provjeriStanje(46, brKr*v.bajc); //Bajc orah [kg]
    		else
    			if (v.nijansa=="f5")
    				t=t&provjeriStanje(47, brKr*v.bajc); //Bajc f5 [kg]
    			else
    				if (v.nijansa=="tresnja")
    					t=t&provjeriStanje(48, brKr*v.bajc); //Bajc tresnja [kg]
    				else
    					if (v.nijansa=="zuta")
    						t=t&provjeriStanje(49, brKr*v.bajc); //Bajc zuta [kg]
    					else
    						if (v.nijansa=="bijela")
        						t=t&provjeriStanje(50, brKr*v.bajc); //Bajc bijela [kg]
    	}
    	else
    	if (v.model=="crm")
    	{
    		t=t&provjeriStanje(44, brKr);//Izolaciono sace [komad]
    		t=t&provjeriStanje(32, brKr*2);//CRM ploca [komad]
    		if (v.brava=="kljuc")
    			t=t&provjeriStanje(22, brKr);//brava na kljuc [komad]
    		else
    			if (v.brava=="cilindar")
    				t=t&provjeriStanje(23, brKr);//brava na cilindar [komad]
    		if (v.kvaka=="elal")
    			t=t&provjeriStanje(20, brKr);//kvaka eloksirani aluminujum [komad]
    		else
    			if (v.kvaka=="inoks")
    				t=t&provjeriStanje(21, brKr);//kvaka inoks [komad]
    		if (v.sirokiStok)
    			t=t&provjeriStanje(19, brKr*0.11);//Drvena ploca [m^3]
    		else
    			t=t&provjeriStanje(19, brKr*0.06);//Drvena ploca [m^3]
    		t=t&provjeriStanje(51, brKr*0.5);//Temeljni lak PU program [kg]
    		t=t&provjeriStanje(52, brKr*0.5);//Zavrsni lak PU program [kg]
    		t=t&provjeriStanje(53, brKr*0.5);//Herter [kg]
    		t=t&provjeriStanje(54, brKr*0.5);//Razredjivac [kg]
    		t=t&provjeriStanje(55, brKr*0.5);//Ljepilo toplo [kg]
    		if (v.nijansa=="orah")
    			t=t&provjeriStanje(46, brKr*v.bajc); //Bajc orah [kg]
    		else
    			if (v.nijansa=="f5")
    				t=t&provjeriStanje(47, brKr*v.bajc); //Bajc f5 [kg]
    			else
    				if (v.nijansa=="tresnja")
    					t=t&provjeriStanje(48, brKr*v.bajc); //Bajc tresnja [kg]
    				else
    					if (v.nijansa=="zuta")
    						t=t&provjeriStanje(49, brKr*v.bajc); //Bajc zuta [kg]
    					else
    						if (v.nijansa=="bijela")
        						t=t&provjeriStanje(50, brKr*v.bajc); //Bajc bijela [kg]
    	}
    	else
    	if (v.model=="furnir")
    	{
    		t=t&provjeriStanje(30, brKr*4);//MDF 6 mm [m^2]
    		if (v.furnir=="hrast")
    			t=t&provjeriStanje(33, brKr*4);//Prirodni furnir hrast [m^2]
    		else
    			if (v.furnir=="bukva")
    				t=t&provjeriStanje(34, brKr*4);//Prirodni furnir bukva [m^2]
    			else
    				if (v.furnir=="jasen")
    					t=t&provjeriStanje(35, brKr*4);//Prirodni furnir jasen [m^2]
    				else
    					if (v.furnir=="orah")
    						t=t&provjeriStanje(36, brKr*4);//Prirodni furnir orah [m^2]
    		if (v.furnir=="hrast")
    			t=t&provjeriStanje(40, brKr*5);//Kant traka prirodni furnir hrast [m]]
    		else
    			if (v.furnir=="bukva")
    				t=t&provjeriStanje(41, brKr*5);//Kant traka prirodni furnir bukva [m]
    			else
    				if (v.furnir=="jasen")
    					t=t&provjeriStanje(42, brKr*5);//Kant traka prirodni furnir jasen [m]
    				else
    					if (v.furnir=="orah")
    						t=t&provjeriStanje(43, brKr*5);//Kant traka prirodni furnir orah [m]
    		if (v.brava=="kljuc")
    			t=t&provjeriStanje(22, brKr);//brava na kljuc [komad]
    		else
    			if (v.brava=="cilindar")
    				t=t&provjeriStanje(23, brKr);//brava na cilindar [komad]
    		if (v.kvaka=="elal")
    			t=t&provjeriStanje(20, brKr);//kvaka eloksirani aluminujum [komad]
    		else
    			if (v.kvaka=="inoks")
    				t=t&provjeriStanje(21, brKr);//kvaka inoks [komad]
    		if (v.sirokiStok)
    			t=t&provjeriStanje(19, brKr*0.11);//Drvena ploca [m^3]
    		else
    			t=t&provjeriStanje(19, brKr*0.06);//Drvena ploca [m^3]
    		t=t&provjeriStanje(51, brKr*0.5);//Temeljni lak PU program [kg]
    		t=t&provjeriStanje(52, brKr*0.5);//Zavrsni lak PU program [kg]
    		t=t&provjeriStanje(53, brKr*0.5);//Herter [kg]
    		t=t&provjeriStanje(54, brKr*0.5);//Razredjivac [kg]
    		t=t&provjeriStanje(55, brKr);//Ljepilo toplo [kg]
    		t=t&provjeriStanje(45, brKr*2);//Stiropor [m^2]
    		if (v.nijansa=="orah")
    			t=t&provjeriStanje(46, brKr*v.bajc); //Bajc orah [kg]
    		else
    			if (v.nijansa=="f5")
    				t=t&provjeriStanje(47, brKr*v.bajc); //Bajc f5 [kg]
    			else
    				if (v.nijansa=="tresnja")
    					t=t&provjeriStanje(48, brKr*v.bajc); //Bajc tresnja [kg]
    				else
    					if (v.nijansa=="zuta")
    						t=t&provjeriStanje(49, brKr*v.bajc); //Bajc zuta [kg]
    					else
    						if (v.nijansa=="bijela")
        						t=t&provjeriStanje(50, brKr*v.bajc); //Bajc bijela [kg]
    	}
    	else
    	if (v.model=="masiv")
    	{
    		if (v.brava=="kljuc")
    			t=t&provjeriStanje(22, brKr);//brava na kljuc [komad]
    		else
    			if (v.brava=="cilindar")
    				t=t&provjeriStanje(23, brKr);//brava na cilindar [komad]
    		if (v.kvaka=="elal")
    			t=t&provjeriStanje(20, brKr);//kvaka eloksirani aluminujum [komad]
    		else
    			if (v.kvaka=="inoks")
    				t=t&provjeriStanje(21, brKr);//kvaka inoks [komad]
    		if (v.sirokiStok)
    			t=t&provjeriStanje(19, brKr*0.19);//Drvena ploca [m^3]
    		else
    			t=t&provjeriStanje(19, brKr*0.14);//Drvena ploca [m^3]
    		t=t&provjeriStanje(51, brKr*0.5);//Temeljni lak PU program [kg]
    		t=t&provjeriStanje(52, brKr*0.5);//Zavrsni lak PU program [kg]
    		t=t&provjeriStanje(53, brKr*0.5);//Herter [kg]
    		t=t&provjeriStanje(54, brKr*0.5);//Razredjivac [kg]
    		t=t&provjeriStanje(55, brKr*0.5);//Ljepilo toplo [kg]
    		if (v.nijansa=="orah")
    			t=t&provjeriStanje(46, brKr*v.bajc); //Bajc orah [kg]
    		else
    			if (v.nijansa=="f5")
    				t=t&provjeriStanje(47, brKr*v.bajc); //Bajc f5 [kg]
    			else
    				if (v.nijansa=="tresnja")
    					t=t&provjeriStanje(48, brKr*v.bajc); //Bajc tresnja [kg]
    				else
    					if (v.nijansa=="zuta")
    						t=t&provjeriStanje(49, brKr*v.bajc); //Bajc zuta [kg]
    					else
    						if (v.nijansa=="bijela")
        						t=t&provjeriStanje(49, brKr*v.bajc); //Bajc bijela [kg]
    	}
    	return t;
    }

    static void povuciSaMagacinaV(Vrata v, int brKr)
    {
    	skiniSaStanja(24, brKr*5);//Dihtung za vrata [m]
    	if (v.falcovana)
    		skiniSaStanja(26, brKr*2);//Baglama obicna [komad]
    	else
    		skiniSaStanja(25, brKr*2);//Baglama leptir [komad]
    	//za sva vrata bajc se unosi rucno
    	if (v.model=="hdf")
    	{
    		if (v.hdf=="bukva")
    			skiniSaStanja(27, brKr*3.75);//hdf bukva [m^2]
    		else
    			if (v.hdf=="hrast")
    				skiniSaStanja(28, brKr*3.75);//hdf hrast [m^2]
    			else
    				if (v.hdf=="tresnja")
    					skiniSaStanja(29, brKr*3.75);//hdf tresnja [m^2]
    		skiniSaStanja(44, brKr);//Izolaciono sace [komad]
    		if (v.brava=="kljuc")
    			skiniSaStanja(22, brKr);//brava na kljuc [komad]
    		else
    			if (v.brava=="cilindar")
    				skiniSaStanja(23, brKr);//brava na cilindar [komad]
    		if (v.kvaka=="elal")
    			skiniSaStanja(20, brKr);//kvaka eloksirani aluminujum [komad]
    		else
    			if (v.kvaka=="inoks")
    				skiniSaStanja(21, brKr);//kvaka inoks [komad]
    		if (v.sirokiStok)
    			skiniSaStanja(19, brKr*0.11);//Drvena ploca [m^3]
    		else
    			skiniSaStanja(19, brKr*0.06);//Drvena ploca [m^3]
    		if (v.hdf=="bukva")
    			skiniSaStanja(37, brKr*5);//Kant traka hdf bukva [m]
    		else
    			if (v.hdf=="hrast")
    				skiniSaStanja(38, brKr*5);//Kant traka hdf hrast [m]
    			else
    				if (v.hdf=="tresnja")
    						skiniSaStanja(39, brKr*5);//Kant traka v.hdf tresnja [m]
    		skiniSaStanja(51, brKr*0.5);//Temeljni lak PU program [kg]
    		skiniSaStanja(52, brKr*0.5);//Zavrsni lak PU program [kg]
    		skiniSaStanja(53, brKr*0.5);//Herter [kg]
    		skiniSaStanja(54, brKr*0.5);//Razredjivac [kg]
    		skiniSaStanja(55, brKr*0.5);//Ljepilo toplo [kg]
    		if (v.nijansa=="orah")
    			skiniSaStanja(46, brKr*v.bajc); //Bajc orah [kg]
    		else
    			if (v.nijansa=="f5")
    				skiniSaStanja(47, brKr*v.bajc); //Bajc f5 [kg]
    			else
    				if (v.nijansa=="tresnja")
    					skiniSaStanja(48, brKr*v.bajc); //Bajc tresnja [kg]
    				else
    					if (v.nijansa=="zuta")
    						skiniSaStanja(49, brKr*v.bajc); //Bajc zuta [kg]
    					else
    						if (v.nijansa=="bijela")
        						skiniSaStanja(50, brKr*v.bajc); //Bajc bijela [kg]
    	}
    	else
    	if (v.model=="mdf")
    	{
    		skiniSaStanja(44, brKr);//Izolaciono sace [komad]
    		skiniSaStanja(31, brKr*4);//MDF 10 mm [m^2]
    		if (v.brava=="kljuc")
    			skiniSaStanja(22, brKr);//brava na kljuc [komad]
    		else
    			if (v.brava=="cilindar")
    				skiniSaStanja(23, brKr);//brava na cilindar [komad]
    		if (v.kvaka=="elal")
    			skiniSaStanja(20, brKr);//kvaka eloksirani aluminujum [komad]
    		else
    			if (v.kvaka=="inoks")
    				skiniSaStanja(21, brKr);//kvaka inoks [komad]
    		if (v.sirokiStok)
    			skiniSaStanja(19, brKr*0.11);//Drvena ploca [m^3]
    		else
    			skiniSaStanja(19, brKr*0.06);//Drvena ploca [m^3]
    		skiniSaStanja(51, brKr*0.5);//Temeljni lak PU program [kg]
    		skiniSaStanja(52, brKr*0.5);//Zavrsni lak PU program [kg]
    		skiniSaStanja(53, brKr*0.5);//Herter [kg]
    		skiniSaStanja(54, brKr*0.5);//Razredjivac [kg]
    		skiniSaStanja(55, brKr*0.5);//Ljepilo toplo [kg]
    		if (v.nijansa=="orah")
    			skiniSaStanja(46, brKr*v.bajc); //Bajc orah [kg]
    		else
    			if (v.nijansa=="f5")
    				skiniSaStanja(47, brKr*v.bajc); //Bajc f5 [kg]
    			else
    				if (v.nijansa=="tresnja")
    					skiniSaStanja(48, brKr*v.bajc); //Bajc tresnja [kg]
    				else
    					if (v.nijansa=="zuta")
    						skiniSaStanja(49, brKr*v.bajc); //Bajc zuta [kg]
    					else
    						if (v.nijansa=="bijela")
        						skiniSaStanja(50, brKr*v.bajc); //Bajc bijela [kg]
    	}
    	else
    	if (v.model=="crm")
    	{
    		skiniSaStanja(44, brKr);//Izolaciono sace [komad]
    		skiniSaStanja(32, brKr*2);//CRM ploca [komad]
    		if (v.brava=="kljuc")
    			skiniSaStanja(22, brKr);//v.brava na kljuc [komad]
    		else
    			if (v.brava=="cilindar")
    				skiniSaStanja(23, brKr);//v.brava na cilindar [komad]
    		if (v.kvaka=="elal")
    			skiniSaStanja(20, brKr);//v.kvaka eloksirani aluminujum [komad]
    		else
    			if (v.kvaka=="inoks")
    				skiniSaStanja(21, brKr);//v.kvaka inoks [komad]
    		if (v.sirokiStok)
    			skiniSaStanja(19, brKr*0.11);//Drvena ploca [m^3]
    		else
    			skiniSaStanja(19, brKr*0.06);//Drvena ploca [m^3]
    		skiniSaStanja(51, brKr*0.5);//Temeljni lak PU program [kg]
    		skiniSaStanja(52, brKr*0.5);//Zavrsni lak PU program [kg]
    		skiniSaStanja(53, brKr*0.5);//Herter [kg]
    		skiniSaStanja(54, brKr*0.5);//Razredjivac [kg]
    		skiniSaStanja(55, brKr*0.5);//Ljepilo toplo [kg]
    		if (v.nijansa=="orah")
    			skiniSaStanja(46, brKr*v.bajc); //Bajc orah [kg]
    		else
    			if (v.nijansa=="f5")
    				skiniSaStanja(47, brKr*v.bajc); //Bajc f5 [kg]
    			else
    				if (v.nijansa=="tresnja")
    					skiniSaStanja(48, brKr*v.bajc); //Bajc tresnja [kg]
    				else
    					if (v.nijansa=="zuta")
    						skiniSaStanja(49, brKr*v.bajc); //Bajc zuta [kg]
    					else
    						if (v.nijansa=="bijela")
        						skiniSaStanja(50, brKr*v.bajc); //Bajc bijela [kg]
    	}
    	else
    	if (v.model=="furnir")
    	{
    		skiniSaStanja(30, brKr*4);//MDF 6 mm [m^2]
    		if (v.furnir=="hrast")
    			skiniSaStanja(33, brKr*4);//Prirodni furnir hrast [m^2]
    		else
    			if (v.furnir=="bukva")
    				skiniSaStanja(34, brKr*4);//Prirodni furnir bukva [m^2]
    			else
    				if (v.furnir=="jasen")
    					skiniSaStanja(35, brKr*4);//Prirodni furnir jasen [m^2]
    				else
    					if (v.furnir=="orah")
    						skiniSaStanja(36, brKr*4);//Prirodni furnir orah [m^2]
    		if (v.furnir=="hrast")
    			skiniSaStanja(40, brKr*5);//Kant traka prirodni furnir hrast [m]]
    		else
    			if (v.furnir=="bukva")
    				skiniSaStanja(41, brKr*5);//Kant traka prirodni furnir bukva [m]
    			else
    				if (v.furnir=="jasen")
    					skiniSaStanja(42, brKr*5);//Kant traka prirodni furnir jasen [m]
    				else
    					if (v.furnir=="orah")
    						skiniSaStanja(43, brKr*5);//Kant traka prirodni furnir orah [m]
    		if (v.brava=="kljuc")
    			skiniSaStanja(22, brKr);//brava na kljuc [komad]
    		else
    			if (v.brava=="cilindar")
    				skiniSaStanja(23, brKr);//brava na cilindar [komad]
    		if (v.kvaka=="elal")
    			skiniSaStanja(20, brKr);//kvaka eloksirani aluminujum [komad]
    		else
    			if (v.kvaka=="inoks")
    				skiniSaStanja(21, brKr);//kvaka inoks [komad]
    		if (v.sirokiStok)
    			skiniSaStanja(19, brKr*0.11);//Drvena ploca [m^3]
    		else
    			skiniSaStanja(19, brKr*0.06);//Drvena ploca [m^3]
    		skiniSaStanja(51, brKr*0.5);//Temeljni lak PU program [kg]
    		skiniSaStanja(52, brKr*0.5);//Zavrsni lak PU program [kg]
    		skiniSaStanja(53, brKr*0.5);//Herter [kg]
    		skiniSaStanja(54, brKr*0.5);//Razredjivac [kg]
    		skiniSaStanja(55, brKr);//Ljepilo toplo [kg]
    		skiniSaStanja(45, brKr*2);//Stiropor [m^2]
    		if (v.nijansa=="orah")
    			skiniSaStanja(46, brKr*v.bajc); //Bajc orah [kg]
    		else
    			if (v.nijansa=="f5")
    				skiniSaStanja(47, brKr*v.bajc); //Bajc f5 [kg]
    			else
    				if (v.nijansa=="tresnja")
    					skiniSaStanja(48, brKr*v.bajc); //Bajc tresnja [kg]
    				else
    					if (v.nijansa=="zuta")
    						skiniSaStanja(49, brKr*v.bajc); //Bajc zuta [kg]
    					else
    						if (v.nijansa=="bijela")
        						skiniSaStanja(50, brKr*v.bajc); //Bajc bijela [kg]
    	}
    	else
    	if (v.model=="masiv")
    	{
    		if (v.brava=="kljuc")
    			skiniSaStanja(22, brKr);//v.brava na kljuc [komad]
    		else
    			if (v.brava=="cilindar")
    				skiniSaStanja(23, brKr);//v.brava na cilindar [komad]
    		if (v.kvaka=="elal")
    			skiniSaStanja(20, brKr);//v.kvaka eloksirani aluminujum [komad]
    		else
    			if (v.kvaka=="inoks")
    				skiniSaStanja(21, brKr);//v.kvaka inoks [komad]
    		if (v.sirokiStok)
    			skiniSaStanja(19, brKr*0.19);//Drvena ploca [m^3]
    		else
    			skiniSaStanja(19, brKr*0.14);//Drvena ploca [m^3]
    		skiniSaStanja(51, brKr*0.5);//Temeljni lak PU program [kg]
    		skiniSaStanja(52, brKr*0.5);//Zavrsni lak PU program [kg]
    		skiniSaStanja(53, brKr*0.5);//Herter [kg]
    		skiniSaStanja(54, brKr*0.5);//Razredjivac [kg]
    		skiniSaStanja(55, brKr*0.5);//Ljepilo toplo [kg]
    		if (v.nijansa=="orah")
    			skiniSaStanja(46, brKr*v.bajc); //Bajc orah [kg]
    		else
    			if (v.nijansa=="f5")
    				skiniSaStanja(47, brKr*v.bajc); //Bajc f5 [kg]
    			else
    				if (v.nijansa=="tresnja")
    					skiniSaStanja(48, brKr*v.bajc); //Bajc tresnja [kg]
    				else
    					if (v.nijansa=="zuta")
    						skiniSaStanja(49, brKr*v.bajc); //Bajc zuta [kg]
    					else
    						if (v.nijansa=="bijela")
        						skiniSaStanja(50, brKr*v.bajc); //Bajc bijela [kg]
    	}
    }
    
    static void istampajStanje()
    {
    	Object[][] podaciRedovi={};
		String[] imenaKolona={"Naziv materijala", "Stanje na magacinu"};
		Object[] redovi;
		DefaultTableModel model=new DefaultTableModel(podaciRedovi, imenaKolona);
		for (int i=1;i<=56;i++)
		{	
			redovi = new Object[]{st[i].nazivMaterijala, Double.toString(st[i].trenutnoStanje)};
			model.addRow(redovi);
		}		
		JTable tabela = new JTable();
		tabela.setModel(model);	
		JScrollPane sPano = new JScrollPane();
		sPano.setViewportView(tabela);
		JFrame okvir=new JFrame();
		okvir.setTitle("Stanje na magacinu");
		Dimension dimEkrana=Toolkit.getDefaultToolkit().getScreenSize();
		okvir.setBounds((int)(0.5*(dimEkrana.width-400)),(int)(0.5*(dimEkrana.height-647)), 400, 647);
		okvir.getContentPane().add(sPano);
		okvir.setVisible(true);
		try {
		    tabela.print(); 
		    okvir.setVisible(false);
		} catch (java.awt.print.PrinterException e) {
				JOptionPane.showOptionDialog(null, 
					System.err.format("Cannot print %s%n", e.getMessage()), 
      		        "Poruka o grešci", 
      		        JOptionPane.OK_OPTION, 
      		        JOptionPane.ERROR_MESSAGE, 
      		        null, 
      		        new String[]{"U redu"}, // this is the array
      		        "default");	     	       
		}
    }
    
    static void napraviKopiju()
    {
    	String putanja="D://BackUp.sql";
		backupDB(ime, korisnickoIme, sifra, putanja);
    }
    
    static void vratiPrethodnoStanje()
    {
    	String putanja="D://BackUp.sql";
		restoreDB(korisnickoIme, sifra, putanja);
    }
}