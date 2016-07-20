import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;


public class VrataJF extends JFrame {

	private JPanel contentPane;
	private JRadioButton rBHdf;
	private JRadioButton rBMdf;
	private JRadioButton rBCrm;
	private JRadioButton rBFur;
	private JRadioButton rBMas;
	private JRadioButton rBBukH;
	private JRadioButton rBHrH;
	private JRadioButton rBTrH;
	private JRadioButton rBHrF;
	private JRadioButton rBBukF;
	private JRadioButton rBJasF;
	private JRadioButton rBOrF;
	private JRadioButton rBFal;
	private JRadioButton rBNeFal;
	private JRadioButton rBUs;
	private JRadioButton rBSir;
	private JRadioButton rBElAl;
	private JRadioButton rBIn;
	private JRadioButton rBKlj;
	private JRadioButton rBCil;
	private JRadioButton rBOrNij;
	private JRadioButton rBF5Nij;
	private JRadioButton rBTrNij;
	private JRadioButton rBZutNij;
	private JRadioButton rBBijNij;
	private JFormattedTextField fTFBajc;
	private JTextField fTFBrVr;
	private JButton bSkSaMag;
	
	void enablujDugme()
	{
		if (!bSkSaMag.isEnabled())
		{
			boolean t=true;
			t=t&(!(fTFBajc.getText().equals(""))&!(fTFBrVr.getText().equals("")));
			t=t&((rBHdf.isSelected())||(rBMdf.isSelected())||(rBCrm.isSelected())||(rBFur.isSelected())||(rBMas.isSelected()));
			if (rBHdf.isSelected())
				t=t&((rBBukH.isSelected())||(rBHrH.isSelected())||(rBTrH.isSelected()));
			if (rBFur.isSelected())
				t=t&((rBHrF.isSelected())||(rBBukF.isSelected())||(rBJasF.isSelected())||(rBOrF.isSelected()));
			t=t&((rBFal.isSelected())||(rBNeFal.isSelected()));
			t=t&((rBUs.isSelected())||(rBSir.isSelected()));
			t=t&((rBElAl.isSelected())||(rBIn.isSelected()));
			t=t&((rBKlj.isSelected())||(rBCil.isSelected()));
			t=t&((rBOrNij.isSelected())||(rBF5Nij.isSelected())||(rBTrNij.isSelected())||(rBZutNij.isSelected())||(rBBijNij.isSelected()));
			if(t)
			{
				bSkSaMag.setEnabled(true);
			}
		}
		else
		{
			boolean t=true;
			t=t&((fTFBajc.getText().equals(""))||(fTFBrVr.getText().equals("")));
			if(t)
			{
				bSkSaMag.setEnabled(false);
			}
		}
	}

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
					VrataJF frame = new VrataJF();
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
	public VrataJF() {
		setResizable(false);
		setTitle("Sobna vrata");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension dimEkrana=Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)(0.5*(dimEkrana.width-363)),(int)(0.5*(dimEkrana.height-587)), 363, 587);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{340, 120, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel pPlocMat = new JPanel();
		pPlocMat.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Vrsta plo\u010Dastog materijala", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pPlocMat = new GridBagConstraints();
		gbc_pPlocMat.gridwidth = 2;
		gbc_pPlocMat.insets = new Insets(0, 0, 5, 0);
		gbc_pPlocMat.fill = GridBagConstraints.BOTH;
		gbc_pPlocMat.gridx = 0;
		gbc_pPlocMat.gridy = 0;
		contentPane.add(pPlocMat, gbc_pPlocMat);
		pPlocMat.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		/*JRadioButton*/ rBHdf = new JRadioButton("HDF"); 
		pPlocMat.add(rBHdf);
		
		/*JRadioButton*/ rBMdf = new JRadioButton("MDF"); 
		pPlocMat.add(rBMdf);
		
		/*JRadioButton*/ rBCrm = new JRadioButton("CRM");
		pPlocMat.add(rBCrm);
		
		/*JRadioButton*/ rBFur = new JRadioButton("Furnir"); 
		pPlocMat.add(rBFur);
		
		/*JRadioButton*/ rBMas = new JRadioButton("Masiv"); 
		pPlocMat.add(rBMas);
		
		ButtonGroup VrPlMat=new ButtonGroup();
		VrPlMat.add(rBHdf);
		VrPlMat.add(rBMdf);
		VrPlMat.add(rBCrm);
		VrPlMat.add(rBFur);
		VrPlMat.add(rBMas);
		
		JPanel pHdf = new JPanel();
		pHdf.setBorder(new TitledBorder(null, "HDF", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("CheckBox.foreground")));
		GridBagConstraints gbc_pHdf = new GridBagConstraints();
		gbc_pHdf.gridwidth = 2;
		gbc_pHdf.insets = new Insets(0, 0, 5, 5);
		gbc_pHdf.fill = GridBagConstraints.BOTH;
		gbc_pHdf.gridx = 0;
		gbc_pHdf.gridy = 1;
		contentPane.add(pHdf, gbc_pHdf);
		
		/*JRadioButton*/ rBBukH = new JRadioButton("Bukva"); 
		pHdf.add(rBBukH);
		
		/*JRadioButton*/ rBHrH = new JRadioButton("Hrast");
		pHdf.add(rBHrH);
		
		/*JRadioButton*/ rBTrH = new JRadioButton("Tresnja");
		pHdf.add(rBTrH);
		
		ButtonGroup Hdf=new ButtonGroup();
		Hdf.add(rBBukH);
		Hdf.add(rBHrH);
		Hdf.add(rBTrH);
		
		rBBukH.setEnabled(false);
		rBHrH.setEnabled(false);
		rBTrH.setEnabled(false);
		
		JPanel pFurnir = new JPanel();
		pFurnir.setBorder(new TitledBorder(null, "Furnir", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pFurnir = new GridBagConstraints();
		gbc_pFurnir.gridwidth = 2;
		gbc_pFurnir.insets = new Insets(0, 0, 5, 0);
		gbc_pFurnir.fill = GridBagConstraints.BOTH;
		gbc_pFurnir.gridx = 0;
		gbc_pFurnir.gridy = 2;
		contentPane.add(pFurnir, gbc_pFurnir);
		
		/*JRadioButton*/ rBHrF = new JRadioButton("Hrast");
		pFurnir.add(rBHrF);
		
		/*JRadioButton*/ rBBukF = new JRadioButton("Bukva");
		pFurnir.add(rBBukF);
		
		/*JRadioButton*/ rBJasF = new JRadioButton("Jasen");
		pFurnir.add(rBJasF);
		
		/*JRadioButton*/ rBOrF = new JRadioButton("Orah");
		pFurnir.add(rBOrF);
		
		ButtonGroup furnir=new ButtonGroup();
		furnir.add(rBHrF);
		furnir.add(rBBukF);
		furnir.add(rBJasF);
		furnir.add(rBOrF);
		
		rBHrF.setEnabled(false);
		rBBukF.setEnabled(false);
		rBJasF.setEnabled(false);
		rBOrF.setEnabled(false);
		
		JPanel pVrata = new JPanel();
		pVrata.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Vrata", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pVrata = new GridBagConstraints();
		gbc_pVrata.insets = new Insets(0, 0, 5, 5);
		gbc_pVrata.fill = GridBagConstraints.BOTH;
		gbc_pVrata.gridx = 0;
		gbc_pVrata.gridy = 3;
		contentPane.add(pVrata, gbc_pVrata);
		GridBagLayout gbl_pVrata = new GridBagLayout();
		gbl_pVrata.columnWidths = new int[]{0, 0};
		gbl_pVrata.rowHeights = new int[]{0, 0, 0};
		gbl_pVrata.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pVrata.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		pVrata.setLayout(gbl_pVrata);
		
		/*JRadioButton*/ rBFal = new JRadioButton("Falcovana");
		GridBagConstraints gbc_rBFal = new GridBagConstraints();
		gbc_rBFal.anchor = GridBagConstraints.WEST;
		gbc_rBFal.insets = new Insets(0, 0, 5, 0);
		gbc_rBFal.gridx = 0;
		gbc_rBFal.gridy = 0;
		pVrata.add(rBFal, gbc_rBFal);
		
		/*JRadioButton*/ rBNeFal = new JRadioButton("Nefalcovana");
		GridBagConstraints gbc_rBNeFal = new GridBagConstraints();
		gbc_rBNeFal.anchor = GridBagConstraints.WEST;
		gbc_rBNeFal.gridx = 0;
		gbc_rBNeFal.gridy = 1;
		pVrata.add(rBNeFal, gbc_rBNeFal);
		
		ButtonGroup vrata=new ButtonGroup();
		vrata.add(rBFal);
		vrata.add(rBNeFal);
		
		JPanel pStok = new JPanel();
		pStok.setBorder(new TitledBorder(null, "\u0160tok", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("CheckBox.foreground")));
		GridBagConstraints gbc_pStok = new GridBagConstraints();
		gbc_pStok.insets = new Insets(0, 0, 5, 0);
		gbc_pStok.fill = GridBagConstraints.BOTH;
		gbc_pStok.gridx = 1;
		gbc_pStok.gridy = 3;
		contentPane.add(pStok, gbc_pStok);
		GridBagLayout gbl_pStok = new GridBagLayout();
		gbl_pStok.columnWidths = new int[]{0, 0};
		gbl_pStok.rowHeights = new int[]{0, 0, 0};
		gbl_pStok.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pStok.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pStok.setLayout(gbl_pStok);
		
		/*JRadioButton*/ rBUs = new JRadioButton("Uski");
		GridBagConstraints gbc_rBUs = new GridBagConstraints();
		gbc_rBUs.anchor = GridBagConstraints.WEST;
		gbc_rBUs.insets = new Insets(0, 0, 5, 0);
		gbc_rBUs.gridx = 0;
		gbc_rBUs.gridy = 0;
		pStok.add(rBUs, gbc_rBUs);
		
		/*JRadioButton*/ rBSir = new JRadioButton("\u0160iroki");
		GridBagConstraints gbc_rBSir = new GridBagConstraints();
		gbc_rBSir.anchor = GridBagConstraints.WEST;
		gbc_rBSir.gridx = 0;
		gbc_rBSir.gridy = 1;
		pStok.add(rBSir, gbc_rBSir);
		
		ButtonGroup stok=new ButtonGroup();
		stok.add(rBUs);
		stok.add(rBSir);
		
		JPanel pVrKv = new JPanel();
		pVrKv.setBorder(new TitledBorder(null, "Vrsta kvake", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pVrKv = new GridBagConstraints();
		gbc_pVrKv.insets = new Insets(0, 0, 5, 5);
		gbc_pVrKv.fill = GridBagConstraints.BOTH;
		gbc_pVrKv.gridx = 0;
		gbc_pVrKv.gridy = 4;
		contentPane.add(pVrKv, gbc_pVrKv);
		GridBagLayout gbl_pVrKv = new GridBagLayout();
		gbl_pVrKv.columnWidths = new int[]{0, 0};
		gbl_pVrKv.rowHeights = new int[]{0, 0, 0};
		gbl_pVrKv.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pVrKv.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pVrKv.setLayout(gbl_pVrKv);
		
		/*JRadioButton*/ rBElAl = new JRadioButton("Eloksirani aluminijum");
		GridBagConstraints gbc_rBElAl = new GridBagConstraints();
		gbc_rBElAl.anchor = GridBagConstraints.WEST;
		gbc_rBElAl.insets = new Insets(0, 0, 5, 0);
		gbc_rBElAl.gridx = 0;
		gbc_rBElAl.gridy = 0;
		pVrKv.add(rBElAl, gbc_rBElAl);
		
		/*JRadioButton*/ rBIn = new JRadioButton("Inoks");
		GridBagConstraints gbc_rBIn = new GridBagConstraints();
		gbc_rBIn.anchor = GridBagConstraints.WEST;
		gbc_rBIn.gridx = 0;
		gbc_rBIn.gridy = 1;
		pVrKv.add(rBIn, gbc_rBIn);
		
		ButtonGroup kvaka=new ButtonGroup();				
		kvaka.add(rBElAl);
		kvaka.add(rBIn);
		
		JPanel pBrava = new JPanel();
		pBrava.setBorder(new TitledBorder(null, "Brava", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("CheckBox.foreground")));
		GridBagConstraints gbc_pBrava = new GridBagConstraints();
		gbc_pBrava.insets = new Insets(0, 0, 5, 0);
		gbc_pBrava.fill = GridBagConstraints.BOTH;
		gbc_pBrava.gridx = 1;
		gbc_pBrava.gridy = 4;
		contentPane.add(pBrava, gbc_pBrava);
		GridBagLayout gbl_pBrava = new GridBagLayout();
		gbl_pBrava.columnWidths = new int[]{0, 0};
		gbl_pBrava.rowHeights = new int[]{0, 0, 0};
		gbl_pBrava.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pBrava.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pBrava.setLayout(gbl_pBrava);
		
		/*JRadioButton*/ rBKlj = new JRadioButton("Na klju\u010D");
		GridBagConstraints gbc_rBKlj = new GridBagConstraints();
		gbc_rBKlj.anchor = GridBagConstraints.WEST;
		gbc_rBKlj.insets = new Insets(0, 0, 5, 0);
		gbc_rBKlj.gridx = 0;
		gbc_rBKlj.gridy = 0;
		pBrava.add(rBKlj, gbc_rBKlj);
		
		/*JRadioButton*/ rBCil = new JRadioButton("Na cilindar");
		GridBagConstraints gbc_rBCil = new GridBagConstraints();
		gbc_rBCil.anchor = GridBagConstraints.WEST;
		gbc_rBCil.gridx = 0;
		gbc_rBCil.gridy = 1;
		pBrava.add(rBCil, gbc_rBCil);
		
		ButtonGroup brava=new ButtonGroup();
		brava.add(rBKlj);
		brava.add(rBCil);
		
		JPanel pNijBoj = new JPanel();
		pNijBoj.setBorder(new TitledBorder(null, "Nijansa boje", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("CheckBox.foreground")));
		GridBagConstraints gbc_pNijBoj = new GridBagConstraints();
		gbc_pNijBoj.gridwidth = 2;
		gbc_pNijBoj.insets = new Insets(0, 0, 5, 0);
		gbc_pNijBoj.fill = GridBagConstraints.BOTH;
		gbc_pNijBoj.gridx = 0;
		gbc_pNijBoj.gridy = 5;
		contentPane.add(pNijBoj, gbc_pNijBoj);
		
		/*JRadioButton*/ rBOrNij = new JRadioButton("Orah");
		pNijBoj.add(rBOrNij);
		
		/*JRadioButton*/ rBF5Nij = new JRadioButton("F5");
		pNijBoj.add(rBF5Nij);
		
		/*JRadioButton*/ rBTrNij = new JRadioButton("Tre\u0161nja");
		pNijBoj.add(rBTrNij);
		
		/*JRadioButton*/ rBZutNij = new JRadioButton("\u017Duta");
		pNijBoj.add(rBZutNij);
		
		rBBijNij = new JRadioButton("Bijela");
		pNijBoj.add(rBBijNij);
		
		ButtonGroup nijBajc=new ButtonGroup();
		nijBajc.add(rBOrNij);
		nijBajc.add(rBF5Nij);
		nijBajc.add(rBTrNij);
		nijBajc.add(rBZutNij);
		nijBajc.add(rBBijNij);		
		
		
		JPanel pBajc = new JPanel();
		pBajc.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Bajc [kg]", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pBajc = new GridBagConstraints();
		gbc_pBajc.gridwidth = 2;
		gbc_pBajc.insets = new Insets(0, 0, 5, 0);
		gbc_pBajc.fill = GridBagConstraints.BOTH;
		gbc_pBajc.gridx = 0;
		gbc_pBajc.gridy = 6;
		contentPane.add(pBajc, gbc_pBajc);
		
		JLabel lBajc = new JLabel("Unesite potrebnu koli\u010Dinu:");
		pBajc.add(lBajc);
		
		fTFBajc = new JFormattedTextField(java.text.DecimalFormat.getInstance());		
		pBajc.add(fTFBajc);
		fTFBajc.setColumns(10);
		
		JPanel pSkini = new JPanel();
		pSkini.setLayout(null);
		GridBagConstraints gbc_pSkini = new GridBagConstraints();
		gbc_pSkini.gridwidth = 2;
		gbc_pSkini.fill = GridBagConstraints.BOTH;
		gbc_pSkini.gridx = 0;
		gbc_pSkini.gridy = 7;
		contentPane.add(pSkini, gbc_pSkini);
		
		JLabel lBrVr = new JLabel("Unesite broj vrata:");
		lBrVr.setBounds(69, 11, 91, 14);
		pSkini.add(lBrVr);
		
		fTFBrVr = new JFormattedTextField(java.text.NumberFormat.getIntegerInstance());
		fTFBrVr.setBounds(165, 8, 86, 20);
		pSkini.add(fTFBrVr);
		fTFBrVr.setColumns(10);
		
		/*JButton*/ bSkSaMag = new JButton("Skini sa magacina"); 
		bSkSaMag.setBounds(95, 42, 141, 23);
		pSkini.add(bSkSaMag);		
		bSkSaMag.setEnabled(false);
		
		rBHdf.addMouseListener(new MouseAdapter() {
		 	public void mouseClicked(MouseEvent e) {
				rBBukH.setEnabled(true);
				rBHrH.setEnabled(true);
				rBTrH.setEnabled(true);
				rBHrF.setEnabled(false);
				rBBukF.setEnabled(false);
				rBJasF.setEnabled(false);
				rBOrF.setEnabled(false);
		 	}
		 });
		
		rBMdf.addMouseListener(new MouseAdapter() {
		 	public void mouseClicked(MouseEvent e) {
				rBBukH.setEnabled(false);
				rBHrH.setEnabled(false);
				rBTrH.setEnabled(false);
				rBHrF.setEnabled(false);
				rBBukF.setEnabled(false);
				rBJasF.setEnabled(false);
				rBOrF.setEnabled(false);
		 	}
		 });
		
		 rBCrm.addMouseListener(new MouseAdapter() {
			 	public void mouseClicked(MouseEvent e) {
			 		rBBukH.setEnabled(false);
					rBHrH.setEnabled(false);
					rBTrH.setEnabled(false);
					rBHrF.setEnabled(false);
					rBBukF.setEnabled(false);
					rBJasF.setEnabled(false);
					rBOrF.setEnabled(false);
			 	}
			 });
		 
		 rBFur.addMouseListener(new MouseAdapter() {
			 	public void mouseClicked(MouseEvent e) {
			 		rBBukH.setEnabled(false);
					rBHrH.setEnabled(false);
					rBTrH.setEnabled(false);
					rBHrF.setEnabled(true);
					rBBukF.setEnabled(true);
					rBJasF.setEnabled(true);
					rBOrF.setEnabled(true);
			 	}
			 });
		 
		 rBMas.addMouseListener(new MouseAdapter() {
			 	public void mouseClicked(MouseEvent e) {
			 		rBBukH.setEnabled(false);
					rBHrH.setEnabled(false);
					rBTrH.setEnabled(false);
					rBHrF.setEnabled(false);
					rBBukF.setEnabled(false);
					rBJasF.setEnabled(false);
					rBOrF.setEnabled(false);
			 	}
			 });
		 
		 rBHdf.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBMdf.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBCrm.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBFur.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBFur.addMouseListener(new MouseAdapter() {
			 	public void mouseClicked(MouseEvent e) {
			 		rBBukH.setEnabled(false);
					rBHrH.setEnabled(false);
					rBTrH.setEnabled(false);
			 	}
			 });
		 
		 rBMas.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBBukH.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBHrH.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBTrH.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBHrF.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBBukF.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBJasF.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBOrF.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBFal.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBNeFal.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBUs.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBSir.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBElAl.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBIn.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBKlj.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBCil.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBOrNij.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBF5Nij.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBTrNij.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBZutNij.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBBijNij.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 fTFBajc.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
					enablujDugme();
				}
			});
		 
		 fTFBrVr.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
					enablujDugme();
				}
			});		 
		 		 	 
		 bSkSaMag.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		Vrata vrata=new Vrata();
			 		if (rBHdf.isSelected())
			 		{
			 			vrata.model="hdf";
			 			if (rBBukH.isSelected())
			 				vrata.hdf="bukva";
			 			else
			 				if (rBHrH.isSelected())
				 				vrata.hdf="hrast";
			 				else
			 					if (rBTrH.isSelected())
					 				vrata.hdf="tresnja";
			 		}
			 		else
			 			if (rBMdf.isSelected())
			 				vrata.model="mdf";
			 			else
			 				if (rBCrm.isSelected())
			 					vrata.model="crm";
			 				else
			 					if (rBFur.isSelected())
			 					{
			 						vrata.model="furnir";
			 						if (rBHrF.isSelected())
						 				vrata.furnir="hrast";
						 			else
						 				if (rBBukF.isSelected())
							 				vrata.furnir="bukva";
						 				else
						 					if (rBJasF.isSelected())
								 				vrata.furnir="jasen";
						 					else
						 						if (rBOrF.isSelected())
									 				vrata.furnir="orah";
			 					}
			 					else
			 						if (rBMas.isSelected())
			 							vrata.model="masiv";
			 		vrata.falcovana=rBFal.isSelected();
			 		vrata.sirokiStok=rBSir.isSelected();
			 		if (rBOrNij.isSelected())
		 				vrata.nijansa="orah";
		 			else
		 				if (rBF5Nij.isSelected())
			 				vrata.nijansa="f5";
		 				else
		 					if (rBTrNij.isSelected())
				 				vrata.nijansa="tresnja";
		 					else
		 						if (rBZutNij.isSelected())
					 				vrata.nijansa="zuta";
		 						else
		 							if (rBBijNij.isSelected())
						 				vrata.nijansa="bijela";
			 		if (rBElAl.isSelected())
		 				vrata.kvaka="elal";
		 			else
		 				if (rBIn.isSelected())
			 				vrata.kvaka="inoks";
			 		if (rBKlj.isSelected())
		 				vrata.brava="kljuc";
		 			else
		 				if (rBCil.isSelected())
			 				vrata.brava="cilindar";
			 		vrata.bajc=Double.parseDouble(fTFBajc.getText());
			 		int brVr=Integer.parseInt(fTFBrVr.getText());
			 		if (Baza.provjeriStanjeV(vrata, brVr))
			 			Baza.povuciSaMagacinaV(vrata, brVr);
			 	}
			 });
		 
	}
}
