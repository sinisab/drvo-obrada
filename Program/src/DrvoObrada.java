import javax.swing.UIManager;

public class DrvoObrada {	
		
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		PocetniJF pocetni=new PocetniJF();
		pocetni.setVisible(true);
		Baza.konekcija();
		if (Baza.conn!=null)
			Baza.ucitajStanje();
	}
}