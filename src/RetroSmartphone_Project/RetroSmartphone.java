package puhelin_daniel;


/**
 * Kokeile t‰lle pohjalle rakentaa omaa sovellusta t. Daniel
 * Muista p‰ivitt‰‰ sijainnit kuville ja hyv‰ksy‰ muutokset module-info
 * */


/*  T‰h‰n on importattu kaikki mahdolliset AWT, Swing, Util, SQL, Java GUI tyˆkalut.
 *  N‰ill‰ voi tehd‰ komentoja ja muokata visuaalisesti lis‰‰.
 *  "+" napista saat ne kaikki esille.
 * 
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.Label;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import java.awt.Canvas;
import javax.swing.JMenuBar;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JTree;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import java.awt.Panel;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;

public class RetroSmartphone {

	private JFrame frmPuhelin;
	private final Action action = new SwingAction();
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 * T‰st‰ k‰ynnistyy ohjelma kokonaisuudessaan ikkunassa.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetroSmartphone window = new RetroSmartphone();
					window.frmPuhelin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	
	
	/**
	 * Create the application.
	 * connection=sqliteConnection,dbConnector() hakee toisesta tiedostosta 
	 * yhteyden sql tietokantaan.
	 */
	public RetroSmartphone() {
		initialize();
		connection=sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 * JFrame on itse ikkunan kehys.
	 * IconImage lis‰‰ kuvan.
	 * setBounds s‰‰t‰‰ 250x 50y sijaintia ja kokoa 900px 674px.
	 * EXIT_ON_CLOSE ihan tavallinen ikkunan sulku.
	 */
	private void initialize() {
		frmPuhelin = new JFrame();
		frmPuhelin.getContentPane().setBackground(Color.WHITE);
		frmPuhelin.setTitle("Puhelin");
		frmPuhelin.setIconImage(Toolkit.getDefaultToolkit().getImage("images\\n97.png"));
		frmPuhelin.setBounds(250, 50, 900, 674);
		frmPuhelin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPuhelin.getContentPane().setLayout(null);
		
		
		
		/** JTabbedPane on itse tab-valikko ja siihen lis‰tt‰v‰t v‰lilehdet.
		 * 	Tabit ilmestyy kun lis‰‰t JPanel.
		 * 	setBounds, eli niin kuin aiemmin kerrottu s‰‰t‰‰ sijaintia ja kokoa.
		 * 	getContentPane().add lis‰‰ itse tab-taulukon.
		 */
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(115, 42, 638, 360);
		frmPuhelin.getContentPane().add(tabbedPane);
		
		/*
		 * Tab-valikkoon lis‰t‰‰n JPanel, eli paneeli johon tulee itse sis‰ltˆ.
		 *  setLayout asettaa valikon asettelua.
		 * */
		JPanel valikko = new JPanel();
		valikko.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Paavalikko", null, valikko, null);
		valikko.setLayout(null);
		
		/*
		 * app1 on ensimm‰isen sovellus-valikossa oleva v‰lilehti.
		 * 
		 * */
		JPanel app1 = new JPanel();
		tabbedPane.addTab("Sovellus1W", null, app1, null);
		app1.setLayout(null);
		
		//T‰ss‰ on ylim‰‰r‰inen nappi myˆhemp‰‰ k‰yttˆ‰ varten.
		JButton mysteeri = new JButton("New button");
		mysteeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e);
			}
		});
		mysteeri.setBounds(57, 23, 92, 85);
		app1.add(mysteeri);
		//------------------------------------
		
		
		
		/* KelloButton avaa kello-sovellus v‰lilehden.
		 * JButton on nappi, johon on sijoitettu kuva tekstin sijaan, siksi ("") pysyy tyhj‰n‰.
		 * ImageIcon asettaa kuvan sijainnin, napin nimeksi annettiin KelloButton (viittaa kellosovellukseen)
		 * ActionListener ns. kuuntelee "tekemisi‰‰n"
		 * eli t‰h‰n valittiin actionPerformed, jolla setSelectedComponent valittiin "app1" v‰lilehti.
		 */
				JButton KelloButton = new JButton("");
				KelloButton.setIcon(new ImageIcon("images\\kello_1.png"));
				KelloButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 tabbedPane.setSelectedComponent(app1);
					}
				});
				KelloButton.setBounds(10, 31, 150, 83);
				valikko.add(KelloButton);
				
		
		
		/* Takaisin p‰‰valikkoon.
		 * T‰h‰n on luotu ihan samanlainen nappi kuten aiemminkin, mutta se palauttaa k‰ytt‰j‰n
		 * takaisin p‰‰valikkoon "valikko".
		 * setBounds taas asettaa sijainnin ja koon.
		*/
		JButton btnBackButton_2 = new JButton("takaisin");
		btnBackButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 tabbedPane.setSelectedComponent(valikko);
			}
		});
		btnBackButton_2.setBounds(10, 274, 115, 50);
		app1.add(btnBackButton_2);
		
		
		/*
		 * uusi v‰lilehti paneeli Sovellus 2 (app2)
		 * */
		JPanel app2 = new JPanel();
		tabbedPane.addTab("Sovellus2W", null, app2, null);
		app2.setLayout(null);
		
		/*  T‰h‰n tulee itse sovelluksen aloitus, kun painaa start, se menee p‰‰lle.
		 *  T‰ss‰ on perinteinen nappi JButton, joka k‰ynnist‰‰ erillisen java tiedostosta methodin,
		 *  eli kutsuu toisen ikkunan jossa on laskin sovellus ja avaa sen p‰‰lle.
		 * 
		 */
		JButton StartLaskin = new JButton("Start Calculator");
		StartLaskin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				
		      SimpleCalculator mf = new SimpleCalculator();
		      mf.newcalc();
			}	
		});
		StartLaskin.setBounds(173, 97, 261, 107);
		app2.add(StartLaskin);
	
		
		/*
		 * Takaisin nappi, joka palauttaa k‰ytt‰j‰n p‰‰valikkoon. 
		 * 
		 * */
		JButton btnBackButton_3 = new JButton("takaisin");
		btnBackButton_3.setBounds(10, 273, 115, 50);
		app2.add(btnBackButton_3);
		btnBackButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			 tabbedPane.setSelectedComponent(valikko);
		}});
		
		
		/*
		 * Asetukset nappi on ylim‰‰r‰inen nappi. Ehk‰ myˆhemp‰‰ k‰yttˆ‰ varten? 
		 * 
		 * */
		JButton AsetuksetButton = new JButton("Options");
		AsetuksetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AsetuksetButton.setBounds(29, 286, 107, 33);
		valikko.add(AsetuksetButton);
		
	
		
		/* alkuosa
		 * Kolmas sovelluksen paneeli (app3)
		 */
		JPanel app3 = new JPanel();
		tabbedPane.addTab("Sovellus3W", null, app3, null);
		app3.setLayout(null);
		
		/*
		 * Nappi joka siirt‰ k‰ytt‰j‰n sovellus 2 (app2)
		 * */
		JButton LaskinButton = new JButton("");
		LaskinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					 tabbedPane.setSelectedComponent(app2);
				}
			});
		
		/*
		 *  P‰‰valikossa oleva laskin nappi, joka on korvattu kuvalla. 
		 *  P‰ivit‰ sijainti.
		 * */
		LaskinButton.setIcon(new ImageIcon("images\\laskin_1.png"));
		LaskinButton.setBounds(330, 31, 293, 83);
		valikko.add(LaskinButton);
		// loppuosa
		
		JButton btnBackButton_6 = new JButton("takaisin");
		btnBackButton_6.setBounds(10, 273, 115, 50);
		app3.add(btnBackButton_6);
		/*
		 * P‰‰valikossa oleva musiikki nappi, joka on korvattu kuvalla.
		 * P‰ivit‰ sijainti.
		 * */
		JButton MusicButton = new JButton("");
		MusicButton.setIcon(new ImageIcon("images\\music_1.png"));
		MusicButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 tabbedPane.setSelectedComponent(app3);
			}
		});
		MusicButton.setActionCommand("");
		MusicButton.setBounds(170, 31, 150, 83);
		valikko.add(MusicButton);
		
		
		/*
		 * Nelj‰nen sovelluksen paneeli 
		 * */
		JPanel app4 = new JPanel();
		tabbedPane.addTab("Sovellus4W", null, app4, null);
		app4.setLayout(null);
		
		
		//------------------------------
		/*
		 * SQL nappi, joka avaa nelj‰nteen v‰lilehteen.
		 * */
		JButton SQLButton = new JButton("");
		SQLButton.setIcon(new ImageIcon("images\\SQL_1.png"));
		SQLButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 tabbedPane.setSelectedComponent(app4);
			}
		});
		SQLButton.setBounds(170, 137, 150, 83);
		valikko.add(SQLButton);
		
		
		/*
		 * T‰ss‰ on JButton, joka painamalla hakee "sqliteConnection" yhteyden java tiedostosta.
		 * Yhteys muodestataan "nimi".db tiedostoon ja query k‰skee SQL kielt‰ k‰ytt‰en n‰ytt‰ytym‰‰n esiin.
		 * connection asettaa taulukon, DbUtils on osa rs2xml.jar tiedostoa joka mahdollistaa
		 * taulukon oikein asettautumista.
		 * */
		JButton btnLoadTable = new JButton("Load DataBase");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		// T‰ss‰ on toimiva linkitys SQL database tiedostoon.
				
				try {
					String query="SELECT * FROM Henkilot;";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch (Exception db) {
					db.printStackTrace();
				}
				
			}
		});
		btnLoadTable.setBounds(230, 27, 120, 40);
		app4.add(btnLoadTable);
		
		/* Skrollattava paneeli, eli siihen mihin ilmestyy taulukko.. riippuen
		 * tietenkin pituudesta menee alasp‰in skrollattavaksi.
		 * 
		 * */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 88, 536, 165);
		app4.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//------------
		/* Takaisin nappi p‰‰valikkoon
		 * 
		 * */
		
		JButton btnBackButton_1 = new JButton("Takaisin");
		btnBackButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 tabbedPane.setSelectedComponent(valikko);
			}
		});
		btnBackButton_1.setBounds(10, 278, 115, 50);
		app4.add(btnBackButton_1);

		
		/* Takaisin nappi p‰‰valikkoon
		 * 
		 * 
		 * */
		btnBackButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 tabbedPane.setSelectedComponent(valikko);
			}});
		
		
		//t‰h‰n tulee puhelimen taustakuva
		
		JLabel lblNewLabel = new JLabel("");
		
		lblNewLabel.setBounds(0, 0, 886, 680);
		frmPuhelin.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("images\\n97.png"));
		
		
		
		
		
	
		
		
		
		
	//yksi ylim‰‰rinen nappi, jota ei ole s‰‰detty
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//t‰h‰n tulee komento, mill‰ saa jotain avattua
			}
		});
		
		new JLabel("New label");
		
		new JButton("New button");
		
		
		
		
	}
	
 /*
  * Tavallaan POPup menu ei ole k‰ytˆss‰, kunhan roikkuu myˆhemp‰‰ k‰yttˆ‰ varten.
  */
	private static void addPopup(Component component, final JPopupMenu popup) {
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
