import java.awt.*;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class PocetniJF extends JFrame {

	private JPanel contentPane;
	private ProzorJF prozori=null;
	private VrataJF vrata=null;
	static StanjeJF stanje=null;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PocetniJF frame = new PocetniJF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public PocetniJF() {
		setResizable(false);
		
		setTitle("Prozori i vrata");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PocetniJF.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dimEkrana=Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)(0.5*(dimEkrana.width-1108)),(int)(0.5*(dimEkrana.height-685)), 1108, 685);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMagacin = new JMenu("Magacin");
		menuBar.add(mnMagacin);
		mnMagacin.setHorizontalAlignment(SwingConstants.LEFT);
		
		JMenuItem mntmProzori = new JMenuItem("Prozori");	
		mnMagacin.add(mntmProzori);
		
		JMenuItem mntmVrata = new JMenuItem("Vrata");		
		mnMagacin.add(mntmVrata);
		
		JMenuItem mntmStanje = new JMenuItem("Stanje");
		mnMagacin.add(mntmStanje);
		
		JMenuItem mntmIstampaj = new JMenuItem("Istampaj");
		mntmIstampaj.setSelected(true);
		mnMagacin.add(mntmIstampaj);
		
		JMenu mnBaza = new JMenu("Baza");
		menuBar.add(mnBaza);
		
		JMenuItem mntmNapraviKopiju = new JMenuItem("Napravi kopiju");
		mnBaza.add(mntmNapraviKopiju);
		
		JMenuItem mntmVratiPrethodnoStanje = new JMenuItem("Vrati prethodno stanje");
		mnBaza.add(mntmVratiPrethodnoStanje);
		
		JMenu mnPomo = new JMenu("Pomo\u0107");
		mnPomo.setIconTextGap(2);
		menuBar.add(mnPomo);
		
		JMenuItem mntmOProgramu = new JMenuItem("O programu");
		mntmOProgramu.setIcon(null);
		mnPomo.add(mntmOProgramu);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{1330, 0};
		gbl_contentPane.rowHeights = new int[]{697, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		panel.add(new LoadImageApp("Slike/drvo.jpg"));//"src/Slike/drvo.jpg"
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		
		mntmProzori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((prozori==null)||(!prozori.isShowing()))
				{
					prozori=new ProzorJF();
					prozori.setVisible(true);
				}
			}
		});
        
		mntmVrata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((vrata==null)||(!vrata.isShowing()))
				{
					vrata=new VrataJF();
					vrata.setVisible(true);
				}
			}
		});
		
		mntmStanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((stanje==null)||(!stanje.isShowing()))
				{
					stanje=new StanjeJF();
					stanje.setVisible(true);
				}
			}
		});
		
		mntmIstampaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Baza.istampajStanje();
			      }
				
		});
		
		mntmNapraviKopiju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Baza.napraviKopiju();
				}
		});
        
		mntmVratiPrethodnoStanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Baza.vratiPrethodnoStanje();
				System.exit(0);
			}
		});
		
		mntmOProgramu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OProgramuJD oProgramu=new OProgramuJD();
				oProgramu.setVisible(true);
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Baza.diskonekcija();			
			}
		});
		
	}

}
