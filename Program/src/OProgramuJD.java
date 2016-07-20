import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class OProgramuJD extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			OProgramuJD dialog = new OProgramuJD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public OProgramuJD() {
		setResizable(false);
		setTitle("O programu");
		Dimension dimEkrana=Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)(0.5*(dimEkrana.width-450)),(int)(0.5*(dimEkrana.height-278)), 450, 278);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JTextArea txtrprozoriIVrata = new JTextArea();
			txtrprozoriIVrata.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			txtrprozoriIVrata.setText("\r\n       \"Prozori i vrata\" je program za manipulaciju bazom podataka \"Magacin\".\r\n\r\n                          Napravljen je za potrebe SZR \"DRVO - OBRADA\".\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n                              \u00A9 Sini\u0161a Bubonja 2013. Sva prava zadr\u017Eana.");
			txtrprozoriIVrata.setEditable(false);
			txtrprozoriIVrata.setWrapStyleWord(true);
			GridBagConstraints gbc_txtrprozoriIVrata = new GridBagConstraints();
			gbc_txtrprozoriIVrata.fill = GridBagConstraints.BOTH;
			gbc_txtrprozoriIVrata.gridx = 0;
			gbc_txtrprozoriIVrata.gridy = 0;
			contentPanel.add(txtrprozoriIVrata, gbc_txtrprozoriIVrata);
		}
		
	}

}
