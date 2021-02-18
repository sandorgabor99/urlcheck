package ssl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Prog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmUrlChecker;
	private JTextField urlcim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prog window = new Prog();
					window.frmUrlChecker.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Prog() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUrlChecker = new JFrame();
		frmUrlChecker.setResizable(false);
		frmUrlChecker.getContentPane().setBackground(Color.WHITE);
		frmUrlChecker.setTitle("URL CHECKER");
		frmUrlChecker.getContentPane().setEnabled(false);
		frmUrlChecker.getContentPane().setLayout(null);

		urlcim = new JTextField();
		urlcim.setBounds(170, 178, 244, 20);
		frmUrlChecker.getContentPane().add(urlcim);
		urlcim.setColumns(10);

		JButton Felvetel = new JButton("Felvetel");
		Felvetel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NewURL.NewCim(urlcim);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		Felvetel.setBounds(246, 209, 89, 23);
		frmUrlChecker.getContentPane().add(Felvetel);

		JButton KiertekelBTN = new JButton("Kiertekel");
		KiertekelBTN.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (NewURL.getMarker()) {
					try {
						Sslchecker.Checker();
						if (NewURL.getMarker()) {
							Result en = new Result();
							en.setVisible(true);
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					NewURL.showMessage("Nincs megadva URL!", 0);
				}
			}

		});
		KiertekelBTN.setBounds(246, 253, 89, 23);
		frmUrlChecker.getContentPane().add(KiertekelBTN);

		JLabel lblrjaBeA = new JLabel("\u00CDrja be a k\u00EDv\u00E1nt URL-c\u00EDmet");
		lblrjaBeA.setBounds(219, 126, 171, 14);
		frmUrlChecker.getContentPane().add(lblrjaBeA);

		JButton btnopen = new JButton("Megnyitas");
		btnopen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewURL.OpenUrl();
			}
		});
		btnopen.setBounds(246, 303, 89, 23);
		frmUrlChecker.getContentPane().add(btnopen);

		JLabel lblSndorGbor = new JLabel("S\u00E1ndor G\u00E1bor VGP19I   (2021) 0.3");
		lblSndorGbor.setBounds(349, 389, 229, 14);
		frmUrlChecker.getContentPane().add(lblSndorGbor);

		JButton btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Info e1 = new Info();
				e1.setVisible(true);
			}
		});
		btnInfo.setBounds(10, 11, 72, 23);
		frmUrlChecker.getContentPane().add(btnInfo);

		JButton remove = new JButton("X");
		remove.setBackground(Color.RED);
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				urlcim.setText("");

			}
		});
		remove.setBounds(421, 177, 53, 23);
		frmUrlChecker.getContentPane().add(remove);
		frmUrlChecker.setBounds(100, 100, 594, 453);
		frmUrlChecker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
