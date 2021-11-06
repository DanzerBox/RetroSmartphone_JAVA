package puhelin_daniel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class SimpleCalculator {

	private JFrame frame;
	private JTextField textR;
	double n1;
	double n2;
	double result;
	String Op;
	String Ans;
	

	/**
	 * Launch the application.
	 * 
	 * Tähän asetataan ikkuna
	 */

	public void newcalc() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalculator window = new SimpleCalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SimpleCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().setForeground(Color.GRAY);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(250, 50, 900, 674);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		textR = new JTextField();
		textR.setBounds(141, 56, 327, 60);
		textR.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textR.setForeground(Color.BLACK);
		textR.setBackground(Color.WHITE);
		textR.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(textR);
		textR.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(114, 43, 640, 360);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnD = new JButton(":");
		btnD.setBounds(471, 94, 70, 70);
		panel.add(btnD);
		btnD.setBackground(Color.WHITE);
		
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n1 = Double.parseDouble(textR.getText());
				textR.setText("");
				Op="/";
						
			}
		});
		btnD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnE = new JButton("=");
		btnE.setBounds(471, 254, 70, 70);
		panel.add(btnE);
		btnE.setBackground(Color.WHITE);
		
			btnE.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					n2= Double.parseDouble(textR.getText());
					if(Op == "+")
					{
						result = n1+n2;
						Ans = String.format("%.2f", result);
						textR.setText(Ans);
						
					}
					if(Op == "-")
					{
						result = n1-n2;
						Ans = String.format("%.2f", result);
						textR.setText(Ans);
						
					}
					if(Op == "*")
					{
						result = n1*n2;
						Ans = String.format("%.2f", result);
						textR.setText(Ans);
						
					}
					if(Op == "/")
					{
						result = n1/n2;
						Ans = String.format("%.4f", result);
						textR.setText(Ans);
						
					}
					
					
				}
			});
			btnE.setForeground(Color.BLACK);
			btnE.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JButton btnMulti = new JButton("*");
			btnMulti.setBounds(471, 176, 70, 70);
			panel.add(btnMulti);
			btnMulti.setBackground(Color.WHITE);
			
			btnMulti.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					n1 = Double.parseDouble(textR.getText());
					textR.setText("");
					Op="*";
							
				}
			});
			btnMulti.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JButton btnOps = new JButton("+/-");
			btnOps.setBounds(383, 94, 70, 70);
			panel.add(btnOps);
			btnOps.setBackground(Color.WHITE);
			btnOps.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double ops =Double.parseDouble(String.valueOf(textR.getText()));
					ops = ops*(-1);
					textR.setText(String.valueOf(ops));
					
				}
			});
			btnOps.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JButton btnSub = new JButton("-");
			btnSub.setBounds(383, 174, 70, 70);
			panel.add(btnSub);
			btnSub.setBackground(Color.WHITE);
			
			btnSub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					n1 = Double.parseDouble(textR.getText());
					textR.setText("");
					Op="-";
							
				}
			});
			btnSub.setFont(new Font("Tahoma", Font.PLAIN, 25));
			
			JButton btnAdd = new JButton("+");
			btnAdd.setBounds(383, 254, 70, 70);
			panel.add(btnAdd);
			btnAdd.setBackground(Color.WHITE);
			
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					n1 = Double.parseDouble(textR.getText());
					textR.setText("");
					Op="+";
							
					
				}
			});
			btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
	
			
			JButton btnP = new JButton(".");
			btnP.setBackground(Color.WHITE);
			btnP.setBounds(134, 274, 150, 50);
			panel.add(btnP);
			btnP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(! textR.getText().contains("."))
			          {
			          textR.setText(textR.getText() + btnP.getText());
			          }
				}
				
			});
			
			
			
			btnP.setFont(new Font("Tahoma", Font.BOLD, 30));
			
			JButton btn6 = new JButton("6");
			btn6.setBounds(169, 155, 50, 50);
			panel.add(btn6);
			btn6.setBackground(Color.WHITE);
			btn6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String EnterNumber = textR.getText() + btn6.getText();
					textR.setText(EnterNumber);
				}
			});
			btn6.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JButton btn5 = new JButton("5");
			btn5.setBounds(109, 155, 50, 50);
			panel.add(btn5);
			btn5.setBackground(Color.WHITE);
			btn5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String EnterNumber = textR.getText() + btn5.getText();
					textR.setText(EnterNumber);
				}
			});
			btn5.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JButton btn9 = new JButton("9");
			btn9.setBounds(169, 95, 50, 50);
			panel.add(btn9);
			btn9.setBackground(Color.WHITE);
			btn9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String EnterNumber = textR.getText() + btn9.getText();
					textR.setText(EnterNumber);
				}
			});
			btn9.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JButton btn8 = new JButton("8");
			btn8.setBounds(109, 95, 50, 50);
			panel.add(btn8);
			btn8.setBackground(Color.WHITE);
			btn8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String EnterNumber = textR.getText() + btn8.getText();
					textR.setText(EnterNumber);
				}
			});
			btn8.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			//-----------ROW 3------------
			JButton btn4 = new JButton("4");
			btn4.setBounds(49, 155, 50, 50);
			panel.add(btn4);
			btn4.setBackground(Color.WHITE);
			btn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String EnterNumber = textR.getText() + btn4.getText();
					textR.setText(EnterNumber);
				}
			});
			btn4.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			
			//-----------ROW 4------------
			JButton btn1 = new JButton("1");
			btn1.setBounds(49, 215, 50, 50);
			panel.add(btn1);
			btn1.setBackground(Color.WHITE);
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String EnterNumber = textR.getText() + btn1.getText();
					textR.setText(EnterNumber);
				}
			});
			btn1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JButton btn2 = new JButton("2");
			btn2.setBounds(109, 215, 50, 50);
			panel.add(btn2);
			btn2.setBackground(Color.WHITE);
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String EnterNumber = textR.getText() + btn2.getText();
					textR.setText(EnterNumber);
				}
			});
			btn2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			
			//-----------ROW 5------------
			JButton btn0 = new JButton("0");
			btn0.setBackground(Color.WHITE);
			btn0.setBounds(49, 275, 75, 50);
			panel.add(btn0);
			btn0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String EnterNumber = textR.getText() + btn0.getText();
					textR.setText(EnterNumber);
				}
				
			});
			btn0.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JButton btn3 = new JButton("3");
			btn3.setBounds(169, 215, 50, 50);
			panel.add(btn3);
			btn3.setBackground(Color.WHITE);
			btn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String EnterNumber = textR.getText() + btn3.getText();
					textR.setText(EnterNumber);
				}
			});
			btn3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			//-----------ROW 2------------
			JButton btn7 = new JButton("7");
			btn7.setBounds(49, 95, 50, 50);
			panel.add(btn7);
			btn7.setBackground(Color.WHITE);
			btn7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String EnterNumber = textR.getText() + btn7.getText();
					textR.setText(EnterNumber);
				}
			});
			btn7.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			
			
			///---------ROW 1-------------
			JButton btnAC = new JButton("CLEAR");
			btnAC.setBounds(368, 21, 125, 49);
			panel.add(btnAC);
			btnAC.setBackground(Color.RED);
			btnAC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textR.setText(null);
				}
			});
			
			btnAC.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnAC.setBorder(null);
			btnAC.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnAC.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 886, 680);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\rusfi\\Desktop\\OLIO-ohjelmointi\\n97.png"));
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
	}
}
