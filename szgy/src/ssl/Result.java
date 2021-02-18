package ssl;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Result extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Result() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setType(Type.UTILITY);
		setBounds(100, 100, 454, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 424, 248);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea(Sslchecker.getRes());
		textArea.setEnabled(false);
		scrollPane.setViewportView(textArea);

		JButton btnVissza = new JButton("Vissza");
		btnVissza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				setVisible(false);
			}
		});
		btnVissza.setBounds(20, 259, 89, 23);
		contentPane.add(btnVissza);

		JButton btnCsvFilebars = new JButton("Txt FileWrite");
		btnCsvFilebars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// CsVFileWr.Writer();
				TxtWr.txt();
			}
		});
		btnCsvFilebars.setBounds(119, 259, 105, 23);
		contentPane.add(btnCsvFilebars);

		JButton btnKibocsjt = new JButton("Kibocs\u00E1jt\u00F3");
		btnKibocsjt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sslchecker.Issuer(Sslchecker.tan);
			}
		});
		btnKibocsjt.setBounds(234, 259, 99, 23);
		contentPane.add(btnKibocsjt);

		JButton btnValid = new JButton("Valid");
		btnValid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sslchecker.isServerTrusted(Sslchecker.tan);
			}
		});
		btnValid.setBounds(345, 259, 89, 23);
		contentPane.add(btnValid);
		
		JButton btnUrlAdatok = new JButton("URL adatok");
		btnUrlAdatok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sslchecker.Subject(Sslchecker.tan);
			}
		});
		btnUrlAdatok.setBounds(20, 292, 105, 23);
		contentPane.add(btnUrlAdatok);
	}
}
