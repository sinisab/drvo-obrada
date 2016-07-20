//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;

public class ProzorJF extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField fTFSir;
	private JFormattedTextField fTFVis;
	private JFormattedTextField fTFBrPr;
	private JRadioButton rB1Kr;
	private JRadioButton rB2Kr;
	private JRadioButton rB1Kv;
	private JRadioButton rB2Kv;
	private JRadioButton rBPol;
	private JRadioButton rBob;
	private JRadioButton rBDaK;
	private JRadioButton rBNeO;
	private JRadioButton rBDO;
	private JRadioButton rBLO;
	private JRadioButton rB1D;
	private JRadioButton rB2D;
	private JRadioButton rB3D;
	private JRadioButton rBOr;
	private JRadioButton rBF5;
	private JRadioButton rBTr;
	private JRadioButton rBZut;
	private JRadioButton rBBij;
	private JCheckBox cBLak;
	private JButton bSkSaMag;
	private JPanel pOkov;
		
	void enablujDugme()
	{
		if (!bSkSaMag.isEnabled())
		{
			boolean t=true;
			t=t&&(!(fTFSir.getText().equals(""))&&!(fTFVis.getText().equals("")));
			t=t&&!(fTFBrPr.getText().equals(""));
			t=t&&((rB1Kr.isSelected())||(rB2Kr.isSelected()));
			if (rB2Kr.isSelected())
				t=t&&((rB1Kv.isSelected())||(rB2Kv.isSelected()));
			t=t&&((rBPol.isSelected())||(rBob.isSelected()));
			t=t&&((rBDaK.isSelected())||(rBNeO.isSelected()));
			if (rBDaK.isSelected())
				t=t&&((rBDO.isSelected())||(rBLO.isSelected()));
			t=t&&((rB1D.isSelected())||(rB2D.isSelected())||(rB3D.isSelected()));
			t=t&&((rBOr.isSelected())||(rBF5.isSelected())||(rBTr.isSelected())||(rBZut.isSelected())||(rBBij.isSelected()));
			if(t)
			{
				bSkSaMag.setEnabled(true);
			}
		}
		else
		{
			boolean t=true;
			t=t&((fTFSir.getText().equals(""))||(fTFVis.getText().equals(""))||(fTFBrPr.getText().equals("")));
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
					ProzorJF frame = new ProzorJF();
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
	public ProzorJF() {
		setResizable(false);
		setTitle("Prozori");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension dimEkrana=Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)(0.5*(dimEkrana.width-315)),(int)(0.5*(dimEkrana.height-510)), 315, 510);
		
		contentPane = new JPanel();
		contentPane.setToolTipText("Dimenzije");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{264, 0};
		gbl_contentPane.rowHeights = new int[]{53, 57, 56, 0, 56, 46, 23, 73, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel pDim = new JPanel();
		FlowLayout fl_pDim = (FlowLayout) pDim.getLayout();
		fl_pDim.setAlignment(FlowLayout.LEADING);
		pDim.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dimenzije prozora [cm]", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pDim = new GridBagConstraints();
		gbc_pDim.fill = GridBagConstraints.BOTH;
		gbc_pDim.insets = new Insets(0, 0, 5, 0);
		gbc_pDim.gridx = 0;
		gbc_pDim.gridy = 0;
		contentPane.add(pDim, gbc_pDim);
		
		JLabel lSir = new JLabel("\u0160irina:");
		lSir.setHorizontalTextPosition(SwingConstants.LEFT);
		lSir.setVerticalAlignment(SwingConstants.TOP);
		pDim.add(lSir);
		
		fTFSir = new JFormattedTextField(java.text.DecimalFormat.getInstance());		
		pDim.add(fTFSir);
		fTFSir.setColumns(10);
		
		JLabel lVis = new JLabel("Visina:");
		pDim.add(lVis);
		
		fTFVis = new JFormattedTextField(java.text.DecimalFormat.getInstance());		
		pDim.add(fTFVis);
		fTFVis.setColumns(10);
		fTFVis.setText("");
		
		fTFSir.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				enablujDugme();
			}
		 });
		
		fTFVis.addKeyListener(new KeyAdapter() {
		 	public void keyReleased(KeyEvent e) {
		 		enablujDugme();
			}
		 });
		
		ButtonGroup tipPr;
		tipPr=new ButtonGroup();
				
		ButtonGroup brKV;
		brKV=new ButtonGroup();
		
		JPanel pTipPrBrKv = new JPanel();
		GridBagConstraints gbc_pTipPrBrKv = new GridBagConstraints();
		gbc_pTipPrBrKv.insets = new Insets(0, 0, 5, 0);
		gbc_pTipPrBrKv.fill = GridBagConstraints.BOTH;
		gbc_pTipPrBrKv.gridx = 0;
		gbc_pTipPrBrKv.gridy = 1;
		contentPane.add(pTipPrBrKv, gbc_pTipPrBrKv);
		GridBagLayout gbl_pTipPrBrKv = new GridBagLayout();
		gbl_pTipPrBrKv.columnWidths = new int[]{149, 0, 0};
		gbl_pTipPrBrKv.rowHeights = new int[]{0, 0};
		gbl_pTipPrBrKv.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pTipPrBrKv.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pTipPrBrKv.setLayout(gbl_pTipPrBrKv);
		
		JPanel pTipPr = new JPanel();
		pTipPr.setBorder(new TitledBorder(null, "Tip prozora", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("CheckBox.foreground")));
		GridBagConstraints gbc_pTipPr = new GridBagConstraints();
		gbc_pTipPr.insets = new Insets(0, 0, 0, 5);
		gbc_pTipPr.fill = GridBagConstraints.BOTH;
		gbc_pTipPr.gridx = 0;
		gbc_pTipPr.gridy = 0;
		pTipPrBrKv.add(pTipPr, gbc_pTipPr);
		GridBagLayout gbl_pTipPr = new GridBagLayout();
		gbl_pTipPr.columnWidths = new int[]{75, 65, 0};
		gbl_pTipPr.rowHeights = new int[]{39, 23, 0};
		gbl_pTipPr.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pTipPr.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pTipPr.setLayout(gbl_pTipPr);
		rB1Kr = new JRadioButton("Jednokrilni");
		
		GridBagConstraints gbc_rB1Kr = new GridBagConstraints();
		gbc_rB1Kr.gridwidth = 2;
		gbc_rB1Kr.anchor = GridBagConstraints.WEST;
		gbc_rB1Kr.insets = new Insets(0, 0, 5, 5);
		gbc_rB1Kr.gridx = 0;
		gbc_rB1Kr.gridy = 0;
		pTipPr.add(rB1Kr, gbc_rB1Kr);
		rB2Kr = new JRadioButton("Dvokrilni");
		
		GridBagConstraints gbc_rB2Kr = new GridBagConstraints();
		gbc_rB2Kr.gridwidth = 2;
		gbc_rB2Kr.insets = new Insets(0, 0, 0, 5);
		gbc_rB2Kr.anchor = GridBagConstraints.WEST;
		gbc_rB2Kr.gridx = 0;
		gbc_rB2Kr.gridy = 1;
		pTipPr.add(rB2Kr, gbc_rB2Kr);
		tipPr.add(rB1Kr);
		tipPr.add(rB2Kr);
		
		JPanel pBrKvaka = new JPanel();
		pBrKvaka.setBorder(new TitledBorder(null, "Broj kvaka", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("CheckBox.foreground")));
		GridBagConstraints gbc_pBrKvaka = new GridBagConstraints();
		gbc_pBrKvaka.fill = GridBagConstraints.BOTH;
		gbc_pBrKvaka.gridx = 1;
		gbc_pBrKvaka.gridy = 0;
		pTipPrBrKv.add(pBrKvaka, gbc_pBrKvaka);
		GridBagLayout gbl_pBrKvaka = new GridBagLayout();
		gbl_pBrKvaka.columnWidths = new int[]{63, 0};
		gbl_pBrKvaka.rowHeights = new int[]{39, 23, 0};
		gbl_pBrKvaka.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pBrKvaka.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pBrKvaka.setLayout(gbl_pBrKvaka);
		rB1Kv = new JRadioButton("1 kvaka");
		
				
		GridBagConstraints gbc_rB1Kv = new GridBagConstraints();				
		gbc_rB1Kv.anchor = GridBagConstraints.WEST;				
		gbc_rB1Kv.insets = new Insets(0, 0, 5, 0);				
		gbc_rB1Kv.gridx = 0;				
		gbc_rB1Kv.gridy = 0;				
		pBrKvaka.add(rB1Kv, gbc_rB1Kv);
				
		rB2Kv = new JRadioButton("2 kvake");				
		GridBagConstraints gbc_rB2Kv = new GridBagConstraints();
		gbc_rB2Kv.anchor = GridBagConstraints.WEST;
		gbc_rB2Kv.gridx = 0;
		gbc_rB2Kv.gridy = 1;
		pBrKvaka.add(rB2Kv, gbc_rB2Kv);
		brKV.add(rB1Kv);
		brKV.add(rB2Kv);
		
		rB1Kv.setEnabled(false);
		rB2Kv.setEnabled(false);
		
		rB1Kr.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		enablujDugme();
		 	}
		 });
		
		rB2Kr.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		enablujDugme();
		 	}
		 });
		
		 rB1Kv.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rB2Kv.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rB2Kr.addMouseListener(new MouseAdapter() {
			 	public void mouseClicked(MouseEvent e) {
			 		rB1Kv.setEnabled(true);
					rB2Kv.setEnabled(true);
			 	}
			 });
		 
		 rB1Kr.addMouseListener(new MouseAdapter() {
			 	public void mouseClicked(MouseEvent e) {
			 		rB1Kv.setEnabled(false);
					rB2Kv.setEnabled(false);
			 	}
			 });
				
		ButtonGroup vrKv;
		vrKv=new ButtonGroup();
		
		JPanel pVrKv = new JPanel();
		pVrKv.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Vrsta kvake", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("CheckBox.foreground")));
		GridBagConstraints gbc_pVrKv = new GridBagConstraints();
		gbc_pVrKv.fill = GridBagConstraints.BOTH;
		gbc_pVrKv.insets = new Insets(0, 0, 5, 0);
		gbc_pVrKv.gridx = 0;
		gbc_pVrKv.gridy = 2;
		contentPane.add(pVrKv, gbc_pVrKv);
		rBPol = new JRadioButton("Poluoliva");
		
		pVrKv.add(rBPol);
		rBob = new JRadioButton("Obi\u010Dna");
		
		pVrKv.add(rBob);
		vrKv.add(rBPol);
		vrKv.add(rBob);
		
		rBPol.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });	 
		
		rBob.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		
		ButtonGroup kip;
		kip=new ButtonGroup();
		
		ButtonGroup okov;
		okov=new ButtonGroup();
		
		JPanel pKipOk = new JPanel();
		GridBagConstraints gbc_pKipOk = new GridBagConstraints();
		gbc_pKipOk.fill = GridBagConstraints.BOTH;
		gbc_pKipOk.insets = new Insets(0, 0, 5, 0);
		gbc_pKipOk.gridx = 0;
		gbc_pKipOk.gridy = 3;
		contentPane.add(pKipOk, gbc_pKipOk);
		GridBagLayout gbl_pKipOk = new GridBagLayout();
		gbl_pKipOk.columnWidths = new int[]{0, 0, 0};
		gbl_pKipOk.rowHeights = new int[]{0, 0};
		gbl_pKipOk.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_pKipOk.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pKipOk.setLayout(gbl_pKipOk);
		
		JPanel pKip = new JPanel();
		pKip.setBorder(new TitledBorder(null, "Kipanje", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("CheckBox.foreground")));
		GridBagConstraints gbc_pKip = new GridBagConstraints();
		gbc_pKip.insets = new Insets(0, 0, 0, 5);
		gbc_pKip.fill = GridBagConstraints.BOTH;
		gbc_pKip.gridx = 0;
		gbc_pKip.gridy = 0;
		pKipOk.add(pKip, gbc_pKip);
		pKip.setLayout(new BoxLayout(pKip, BoxLayout.X_AXIS));
		rBDaK = new JRadioButton("Da");
		
		pKip.add(rBDaK);
		rBNeO = new JRadioButton("Ne");
		
		pKip.add(rBNeO);
		kip.add(rBDaK);
		kip.add(rBNeO);
		pOkov = new JPanel();
		pOkov.setBorder(new TitledBorder(null, "Okov", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("CheckBox.foreground")));
		GridBagConstraints gbc_pOkov = new GridBagConstraints();
		gbc_pOkov.fill = GridBagConstraints.BOTH;
		gbc_pOkov.gridx = 1;
		gbc_pOkov.gridy = 0;
		pKipOk.add(pOkov, gbc_pOkov);
		pOkov.setLayout(new BoxLayout(pOkov, BoxLayout.X_AXIS));
		rBLO = new JRadioButton("Lijevi");
		
		pOkov.add(rBLO);
		rBDO = new JRadioButton("Desni");
		
		pOkov.add(rBDO);
		
		rBLO.setEnabled(false);
		rBDO.setEnabled(false);
		okov.add(rBLO);
		okov.add(rBDO);
		
		rBDaK.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });	
		
		 rBNeO.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBLO.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBDO.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		 
		 rBDaK.addMouseListener(new MouseAdapter() {
			 	public void mouseClicked(MouseEvent e) {
			 		rBLO.setEnabled(true);
					rBDO.setEnabled(true);
			 	}
			 });
		 
		 rBNeO.addMouseListener(new MouseAdapter() {
			 	public void mouseClicked(MouseEvent e) {
			 		rBLO.setEnabled(false);
					rBDO.setEnabled(false);
			 	}
			 });
		
		ButtonGroup diht;
		diht=new ButtonGroup();
		
		JPanel pDiht = new JPanel();
		pDiht.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Broj dihtunga", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("CheckBox.foreground")));
		GridBagConstraints gbc_pDiht = new GridBagConstraints();
		gbc_pDiht.fill = GridBagConstraints.BOTH;
		gbc_pDiht.insets = new Insets(0, 0, 5, 0);
		gbc_pDiht.gridx = 0;
		gbc_pDiht.gridy = 4;
		contentPane.add(pDiht, gbc_pDiht);
		rB1D = new JRadioButton("1 dihtung");
		
		pDiht.add(rB1D);
		rB2D = new JRadioButton("2 dihtunga");
		
		pDiht.add(rB2D);
		rB3D = new JRadioButton("3 dihtunga");
		
		pDiht.add(rB3D);
		diht.add(rB1D);
		diht.add(rB2D);
		diht.add(rB3D);
		
		rB1D.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		
		rB2D.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		
		rB3D.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		
		ButtonGroup nij;
		nij=new ButtonGroup();

		JPanel pNijBoj=new JPanel();
		pNijBoj.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nijansa boje", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pNijBoj = new GridBagConstraints();
		gbc_pNijBoj.fill = GridBagConstraints.VERTICAL;
		gbc_pNijBoj.insets = new Insets(0, 0, 5, 0);
		gbc_pNijBoj.gridx = 0;
		gbc_pNijBoj.gridy = 5;
		contentPane.add(pNijBoj, gbc_pNijBoj);
		GridBagLayout gbl_pNijBoj = new GridBagLayout();
		gbl_pNijBoj.columnWidths = new int[]{49, 37, 61, 47, 0, 0};
		gbl_pNijBoj.rowHeights = new int[]{23, 0};
		gbl_pNijBoj.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pNijBoj.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pNijBoj.setLayout(gbl_pNijBoj);
		rBOr = new JRadioButton("Orah");
 
		GridBagConstraints gbc_rBOr = new GridBagConstraints();
		gbc_rBOr.anchor = GridBagConstraints.NORTHWEST;
		gbc_rBOr.insets = new Insets(0, 0, 0, 5);
		gbc_rBOr.gridx = 0;
		gbc_rBOr.gridy = 0;
		pNijBoj.add(rBOr, gbc_rBOr);
		rBF5 = new JRadioButton("F5");
		
		GridBagConstraints gbc_rBF5 = new GridBagConstraints();
		gbc_rBF5.anchor = GridBagConstraints.NORTHWEST;
		gbc_rBF5.insets = new Insets(0, 0, 0, 5);
		gbc_rBF5.gridx = 1;
		gbc_rBF5.gridy = 0;
		pNijBoj.add(rBF5, gbc_rBF5);
		rBTr = new JRadioButton("Tre\u0161nja");
		
		GridBagConstraints gbc_rBTr = new GridBagConstraints();
		gbc_rBTr.fill = GridBagConstraints.VERTICAL;
		gbc_rBTr.anchor = GridBagConstraints.WEST;
		gbc_rBTr.insets = new Insets(0, 0, 0, 5);
		gbc_rBTr.gridx = 2;
		gbc_rBTr.gridy = 0;
		pNijBoj.add(rBTr, gbc_rBTr);
		rBZut = new JRadioButton("\u017Duta");
				
		GridBagConstraints gbc_rBZut = new GridBagConstraints();
		gbc_rBZut.insets = new Insets(0, 0, 0, 5);
		gbc_rBZut.anchor = GridBagConstraints.NORTHWEST;
		gbc_rBZut.gridx = 3;
		gbc_rBZut.gridy = 0;
		pNijBoj.add(rBZut, gbc_rBZut);
		
		rBBij = new JRadioButton("Bijela");
		GridBagConstraints gbc_rBBij = new GridBagConstraints();
		gbc_rBBij.gridx = 4;
		gbc_rBBij.gridy = 0;
		pNijBoj.add(rBBij, gbc_rBBij);
		nij.add(rBOr);
		nij.add(rBF5);
		nij.add(rBTr);
		nij.add(rBZut);
		nij.add(rBBij);
		
		rBOr.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		
		rBF5.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		
		rBTr.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		
		rBZut.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		enablujDugme();
			 	}
			 });
		
		rBBij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enablujDugme();
			}
		});
		
		cBLak = new JCheckBox("Lakiranje");
		GridBagConstraints gbc_cBLak = new GridBagConstraints();
		gbc_cBLak.fill = GridBagConstraints.BOTH;
		gbc_cBLak.insets = new Insets(0, 0, 5, 0);
		gbc_cBLak.gridx = 0;
		gbc_cBLak.gridy = 6;
		contentPane.add(cBLak, gbc_cBLak);
		
		JPanel pSkSaMag = new JPanel();
		pSkSaMag.setLayout(null);
		GridBagConstraints gbc_pSkSaMag = new GridBagConstraints();
		gbc_pSkSaMag.fill = GridBagConstraints.BOTH;
		gbc_pSkSaMag.gridx = 0;
		gbc_pSkSaMag.gridy = 7;
		contentPane.add(pSkSaMag, gbc_pSkSaMag);
		bSkSaMag = new JButton("Skini sa magacina");
		
		bSkSaMag.setEnabled(false);
		bSkSaMag.setBounds(78, 39, 141, 23);
		pSkSaMag.add(bSkSaMag);
				
		JLabel lBrPr = new JLabel("Unesite broj prozora:");
		lBrPr.setBounds(51, 11, 102, 14);
		pSkSaMag.add(lBrPr);
		
		fTFBrPr = new JFormattedTextField(java.text.NumberFormat.getIntegerInstance());				
		fTFBrPr.setBounds(159, 8, 86, 20);
		pSkSaMag.add(fTFBrPr);
		fTFBrPr.setColumns(10);
		fTFBrPr.setText("");
		
		fTFBrPr.addKeyListener(new KeyAdapter() {
			 	public void keyReleased(KeyEvent e) {
			 		enablujDugme();
			}
			 });
		
		bSkSaMag.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		Prozor prozor=new Prozor();
			 		prozor.sirina=Double.parseDouble(fTFSir.getText());
			 		prozor.visina=Double.parseDouble(fTFVis.getText());
			 		prozor.dvokrilni=rB2Kr.isSelected();
			 		prozor.kipanje=rBDaK.isSelected();
			 		if ((rBDaK.isSelected())&&(rBLO.isSelected()))
			 			prozor.okov="lijevi";
			 		if ((rBDaK.isSelected())&&(rBDO.isSelected()))
			 			prozor.okov="desni";
			 		prozor.lakiranje=cBLak.isSelected();//da, ne
			 		if (rBOr.isSelected())
			 			prozor.nijansa="orah";//orah, f5, tresnja, zuta
			 		if (rBF5.isSelected())
			 			prozor.nijansa="f5";
			 		if (rBTr.isSelected())
						 prozor.nijansa="tresnja";
			 		if (rBZut.isSelected())
						 prozor.nijansa="zuta";	
			 		if (rBBij.isSelected())
						 prozor.nijansa="bijela";
			 		if (rBPol.isSelected())
			 			prozor.kvaka="poluoliva";//poluoliva, obicna
			 		if (rBob.isSelected())
			 			prozor.kvaka="obicna";
			 		if (rB1D.isSelected())
			 			prozor.brojDihtunga=1;//1, 2, 3
			 		if (rB2D.isSelected())
			 			prozor.brojDihtunga=2;
			 		if (rB3D.isSelected())
			 			prozor.brojDihtunga=3;
			 		if (rB1Kr.isSelected())
			 			prozor.brojKvaka=1;//1, 2
			 		if ((rB2Kr.isSelected())&&(rB1Kv.isSelected()))
			 			prozor.brojKvaka=1;
			 		if ((rB2Kr.isSelected())&&(rB2Kv.isSelected()))
			 			prozor.brojKvaka=2;
			 		int brPr=Integer.parseInt(fTFBrPr.getText());
			 		if (Baza.provjeriStanjeP(prozor, brPr))
			 			Baza.povuciSaMagacinaP(prozor, brPr);
			 	}
			 });

	}
}
