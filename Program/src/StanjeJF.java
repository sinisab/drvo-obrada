import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;
import javax.swing.JFormattedTextField;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import javax.swing.event.*;
import javax.swing.DefaultCellEditor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.print.PrinterException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import java.text.MessageFormat;

public class StanjeJF extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTable tProzori;
	static JTable tVrata;
	private JTextField tFFilter;
	private JFormattedTextField tFVr;
	private JTextField celija;
	private TableRowSorter sorterP;
	private TableRowSorter sorterV;
	private JComboBox cBMat;
	private JButton bDodaj;
	private JButton bSkini;
	
	private void newFilter() {
	    RowFilter rf = null;
	    //If current expression doesn't parse, don't update.
	    try {
	        rf = RowFilter.regexFilter("(?i)" + tFFilter.getText(), 0);
	    } catch (java.util.regex.PatternSyntaxException e) {
	        return;
	    }
	    sorterP.setRowFilter(rf);
	    sorterV.setRowFilter(rf);
	}

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		Baza.konekcija();
		Baza.ucitajStanje();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StanjeJF frame = new StanjeJF();
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
	
	
	public StanjeJF() {
		setResizable(false);
		setTitle("Stanje");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension dimEkrana=Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)(0.5*(dimEkrana.width-599)),(int)(0.5*(dimEkrana.height-370)), 599, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{213, 36, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 5);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		contentPane.add(tabbedPane, gbc_tabbedPane);
		Object[][] podaciRedoviP={};
		String[] imenaKolonaP={"Naziv materijala", "Stanje na magacinu"};
		Object[] redoviP;
		DefaultTableModel tModelP=new DefaultTableModel(podaciRedoviP, imenaKolonaP){

			 public boolean isCellEditable(int row, int column)
			 {
				 if (column==0)//prva kolona se ne moze uredjivati
					 return false;
				 else
					 return true;
			 }
			  };
			  
		for (int i=1;i<=18;i++)
		{	
			redoviP = new Object[]{Baza.st[i].nazivMaterijala, Double.toString(Baza.st[i].trenutnoStanje)};
			tModelP.addRow(redoviP);
		}		
		/*for (int i=38;i<=43;i++)
		{	
			redoviP = new Object[]{Baza.st[i].nazivMaterijala, Double.toString(Baza.st[i].trenutnoStanje)};
			tModelP.addRow(redoviP);
		}
		redoviP = new Object[]{Baza.st[53].nazivMaterijala, Double.toString(Baza.st[53].trenutnoStanje)};*/
		//tModelP.addRow(redoviP);
		Object[][] podaciRedoviV={};
		String[] imenaKolonaV={"Naziv materijala", "Stanje na magacinu"};
		Object[] redoviV;
		
		DefaultTableModel tModelV=new DefaultTableModel(podaciRedoviV, imenaKolonaV){

			 public boolean isCellEditable(int row, int column)
			 {
				 if (column==0)//prva kolona se ne moze uredjivati
					 return false;
				 else
					 return true;
			 }
			 
			  };
			  
	
		for (int i=19;i<=56;i++)
		{	
			redoviV = new Object[]{Baza.st[i].nazivMaterijala, Double.toString(Baza.st[i].trenutnoStanje)};
			tModelV.addRow(redoviV);
		}		
		/*for (int i=44;i<=52;i++)
		{	
			redoviV = new Object[]{Baza.st[i].nazivMaterijala, Double.toString(Baza.st[i].trenutnoStanje)};
			tModelV.addRow(redoviV);
		}*/
		
		JScrollPane sPProzori = new JScrollPane();
		tabbedPane.addTab("Prozori", null, sPProzori, null);
		
		tProzori = new JTable();
		tProzori.setModel(tModelP);	
		sPProzori.setViewportView(tProzori);
		
		TableColumn kolonaP = null;
		kolonaP = tProzori.getColumnModel().getColumn(0);
		kolonaP.setPreferredWidth(175); 
		TableColumn kolonaBrojP=tProzori.getColumnModel().getColumn(1);
		celija=new JTextField();
		celija.setTransferHandler(null);//nema copy i paste
		kolonaBrojP.setCellEditor(new DefaultCellEditor(celija));
		JScrollPane sPVrata = new JScrollPane();
		tabbedPane.addTab("Vrata", null, sPVrata, null);
		
		tVrata = new JTable();
		tVrata.setModel(tModelV);		
		sPVrata.setViewportView(tVrata);
		
		TableColumn kolonaV = null;
		kolonaV = tVrata.getColumnModel().getColumn(0);
		kolonaV.setPreferredWidth(175); 
		TableColumn kolonaBrojV=tVrata.getColumnModel().getColumn(1);
		kolonaBrojV.setCellEditor(new DefaultCellEditor(celija));
		
		JPanel pDodSkin = new JPanel();
		GridBagConstraints gbc_pDodSkin = new GridBagConstraints();
		gbc_pDodSkin.insets = new Insets(0, 0, 5, 0);
		gbc_pDodSkin.fill = GridBagConstraints.BOTH;
		gbc_pDodSkin.gridx = 1;
		gbc_pDodSkin.gridy = 0;
		contentPane.add(pDodSkin, gbc_pDodSkin);
		pDodSkin.setLayout(new MigLayout("", "[136px,left]", "[20px][][14px][][][][20px][][23px][][23px][][][][][][][][][][][][][][]"));
		
		
		/*JComboBox*/ cBMat = new JComboBox();
		pDodSkin.add(cBMat, "cell 0 1,growx,aligny top");
		for (int i=1;i<=56;i++)
			cBMat.addItem(Baza.st[i].nazivMaterijala);
		
		JLabel lVr = new JLabel("Unesi vrijednost:");
		lVr.setHorizontalAlignment(SwingConstants.CENTER);
		pDodSkin.add(lVr, "cell 0 7,growx,aligny top");
		
		/*TableRowSorter*/ sorterP = new TableRowSorter<DefaultTableModel>(tModelP);
		tProzori.setRowSorter(sorterP);
		/*TableRowSorter*/ sorterV = new TableRowSorter(tModelV);
		tVrata.setRowSorter(sorterV);
		
		tFVr = new JFormattedTextField(java.text.DecimalFormat.getInstance());
		tFVr.setHorizontalAlignment(SwingConstants.CENTER);
		pDodSkin.add(tFVr, "cell 0 9,growx,aligny top");
		tFVr.setColumns(10);
		
		/*JButton*/ bSkini = new JButton("Skini sa Stanja");
		bSkini.setEnabled(false);
		
		/*JButton*/ bDodaj = new JButton("Dodaj na stanje");
		bDodaj.setEnabled(false);
		
		pDodSkin.add(bDodaj, "cell 0 19,growx,aligny top");
		pDodSkin.add(bSkini, "cell 0 23,growx,aligny top");
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		
		JLabel lfilter = new JLabel("Filter tekst:");
		lfilter.setBounds(0, 11, 61, 14);
		panel.add(lfilter);
		
		tFFilter = new JTextField();
		
		tFFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = tFFilter.getText();
		        if (text.length() == 0) {
		          sorterP.setRowFilter(null);
		        } else 
		        {
		          sorterP.setRowFilter(RowFilter.regexFilter(text));
		          sorterV.setRowFilter(RowFilter.regexFilter(text));
		        }
			}
		});
		tFFilter.setBounds(62, 8, 138, 20);
		panel.add(tFFilter);
		tFFilter.setColumns(10);
		
		JButton bSac = new JButton("Sa\u010Duvaj promjene");
		bSac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=1;i<=18;i++)
					if(Baza.st[i].trenutnoStanje!=Double.parseDouble(tProzori.getModel().getValueAt(i-1, 1).toString()))
					{
						Baza.promjeniStanje(i,Double.parseDouble(tProzori.getModel().getValueAt(i-1, 1).toString()));
						Baza.st[i].trenutnoStanje=Double.parseDouble(tProzori.getModel().getValueAt(i-1, 1).toString());
						//tProzori.setValueAt(Double.parseDouble(tProzori.getModel().getValueAt(i-1, 1).toString()), i-1, 1);
					}	
				/*for (int i=38;i<=43;i++)
					if(Baza.st[i].trenutnoStanje!=Double.parseDouble(tProzori.getModel().getValueAt(i-28, 1).toString()))
					{
						Baza.promjeniStanje(i,Double.parseDouble(tProzori.getModel().getValueAt(i-28, 1).toString()));
						Baza.st[i].trenutnoStanje=Double.parseDouble(tProzori.getModel().getValueAt(i-28, 1).toString());
						//tProzori.setValueAt(Double.parseDouble(tProzori.getModel().getValueAt(i-27-1, 1).toString()), i-27-1, 1);
					}
				if(Baza.st[53].trenutnoStanje!=Double.parseDouble(tProzori.getModel().getValueAt(16, 1).toString()))
				{
					Baza.promjeniStanje(53,Double.parseDouble(tProzori.getModel().getValueAt(16, 1).toString()));
					Baza.st[53].trenutnoStanje=Double.parseDouble(tProzori.getModel().getValueAt(16, 1).toString());
					//tProzori.setValueAt(Double.parseDouble(tProzori.getModel().getValueAt(17-1, 1).toString()), 17-1, 1);
				}*/
				for (int i=19;i<=56;i++)
					if(Baza.st[i].trenutnoStanje!=Double.parseDouble(tVrata.getModel().getValueAt(i-19, 1).toString()))
					{
						Baza.promjeniStanje(i,Double.parseDouble(tVrata.getModel().getValueAt(i-19, 1).toString()));
						Baza.st[i].trenutnoStanje=Double.parseDouble(tVrata.getModel().getValueAt(i-19, 1).toString());
						//tVrata.setValueAt(Double.parseDouble(tVrata.getModel().getValueAt(i-10-1, 1).toString()), i-10-1, 1);
					}	
				/*for (int i=44;i<=52;i++)
					if(Baza.st[i].trenutnoStanje!=Double.parseDouble(tVrata.getModel().getValueAt(i-17, 1).toString()))
					{
						Baza.promjeniStanje(i,Double.parseDouble(tVrata.getModel().getValueAt(i-17, 1).toString()));
						Baza.st[i].trenutnoStanje=Double.parseDouble(tVrata.getModel().getValueAt(i-17, 1).toString());
						//tVrata.setValueAt(Double.parseDouble(tVrata.getModel().getValueAt(i-16-1, 1).toString()), i-16-1, 1);
					}*/
			}
		});
		bSac.setBounds(221, 7, 133, 23);
		panel.add(bSac);
		
		tFFilter.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void insertUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void removeUpdate(DocumentEvent e) {
                        newFilter();
                    }
                });
		
		bSkini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!tFVr.getText().equals(""))
				{
					tFFilter.setText("");
					int i=cBMat.getSelectedIndex()+1;
					if (Baza.provjeriStanje(i,Double.parseDouble(tFVr.getText())))
					{
						Baza.skiniSaStanja(i, Double.parseDouble(tFVr.getText()));
						/*if ((i>=1)&&(i<=10))
								tProzori.setValueAt(Baza.st[i].trenutnoStanje, i-1, 1);
						if ((i>=38)&&(i<=43))
							tProzori.setValueAt(Baza.st[i].trenutnoStanje, i-27-1, 1);
						if (i==53)
							tProzori.setValueAt(Baza.st[i].trenutnoStanje, 17-1, 1);
						if ((i>=11)&&(i<=37))
							tVrata.setValueAt(Baza.st[i].trenutnoStanje, i-10-1, 1);
						if ((i>=44)&&(i<=52))
							tVrata.setValueAt(Baza.st[i].trenutnoStanje, i-16-1, 1);	*/
					}									
				}					
			}
		});
		
		bDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!tFVr.getText().equals(""))
				{
					tFFilter.setText("");
					int i=cBMat.getSelectedIndex()+1;
					Baza.dodajNaStanje(i, Double.parseDouble(tFVr.getText()));
					/*if ((i>=1)&&(i<=10))
						tProzori.setValueAt(Baza.st[i].trenutnoStanje, i-1, 1);
				if ((i>=38)&&(i<=43))
					tProzori.setValueAt(Baza.st[i].trenutnoStanje, i-28, 1);
				if (i==53)
					tProzori.setValueAt(Baza.st[i].trenutnoStanje, 16, 1);
				if ((i>=11)&&(i<=37))
					tVrata.setValueAt(Baza.st[i].trenutnoStanje, i-11, 1);
				if ((i>=44)&&(i<=52))
					tVrata.setValueAt(Baza.st[i].trenutnoStanje, i-17, 1);*/
				}
			}
		});
		
		celija.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int brojZareza = celija.getText().replaceAll("[^.]", "").length();
				if((!Character.isDigit(e.getKeyChar()) && e.getKeyChar() !=KeyEvent.VK_BACK_SPACE && e.getKeyChar() !='.')||(e.getKeyChar() =='.' && brojZareza>0)||(e.getKeyChar() =='.' && celija.getText().equals("")))
				{
				celija.setEditable(false);
				celija.setBackground(Color.WHITE);
				}
				else
				{
				celija.setEditable(true);
				}
			}
		});
		
		tFVr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (!tFVr.getText().equals(""))
				{
					bDodaj.setEnabled(true);
					bSkini.setEnabled(true);
				}
				else
				{
					bDodaj.setEnabled(false);
					bSkini.setEnabled(false);
				}
			}
		});
		
	}
}
