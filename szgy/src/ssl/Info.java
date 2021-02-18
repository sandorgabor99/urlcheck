package ssl;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Info extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/**
	 * Launch the application.
	 */
	
	public Info() {

		setBounds(100, 100, 450, 422);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextArea infofield = new JTextArea("A program els\u0151dleges c\u00E9lja egy Url c\u00EDm tan\u00FAs\u00EDtv\u00E1ny\u00E1nak megvizsg\u00E1l\u00E1sa,ki\u00E9rt\u00E9kel\u00E9se.\r\n---------------------------------------------------------------------------------\r\n\r\n(1) A k\u00F6z\u00E9pen tal\u00E1lhat\u00F3 mez\u0151be sz\u00FCks\u00E9ges az urlc\u00EDm be\u00EDr\u00E1sa.\r\n\r\n(2) A felv\u00E9tel gomb megnyom\u00E1s\u00E1val felvehet\u0151 az adott c\u00EDm egy\u00FAttal megvizsg\u00E1l\u00E1sra ker\u00FCl hogy helyes-e a form\u00E1tuma.\r\n\r\n(3) A ki\u00E9rt\u00E9kel\u00E9s gomb megnyom\u00E1s\u00E1val lek\u00E9rdezhet\u0151 a weboldal inform\u00E1ci\u00F3i.\r\n\r\n(4) A megnyit\u00E1s gomb megnyom\u00E1s\u00E1val megnyithat\u00F3 a megadott Url c\u00EDm amennyiben a ki\u00E9rt\u00E9kel\u00E9s v\u00E9gbement.");
		infofield.setBounds(10, 11, 414, 272);
		infofield.setWrapStyleWord(true);
		infofield.setLineWrap(true);
		infofield.setEditable(false);
		contentPanel.add(infofield);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
