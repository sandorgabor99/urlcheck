package ssl;

import java.awt.Desktop;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.net.MalformedURLException;
import java.net.URL;

public class NewURL implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String mes = "Üzenet a programtol!";
	private static Boolean marker = false;

	public static void NewCim(JTextField urlcim) {
		if (!filled(urlcim)) {
			showMessage("Az url cim mezõ ures", 2);
			setMarker(false);
		} else if (!urlValidator(RF(urlcim))) {
			setMarker(false);
			showMessage("Hibas a megadott URL cim!", 2);
		} else {
			new Address(RF(urlcim));
			showMessage("Az URL felvetele megtörtént,kiértékelésre kész", 1);
			setMarker(true);
		}

	}

	public static void OpenUrl() {
		try {
			if (Sslchecker.isServerTrusted(Sslchecker.tan)) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					try {
						try {
							desktop.browse(new URI(Address.getCim()));
						} catch (IOException | URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (Exception x3) {
						NewURL.showMessage("Nem megnyitható az URL cím", 0);
					}
				} else {
					Runtime runtime = Runtime.getRuntime();
					try {
						runtime.exec("xdg-open " + Address.getCim());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {

			}
		} catch (Exception e5) {
			showMessage("Nincs megadva URL ami megnyitható lenne!", 1);
		}
	}

	public static String RF(JTextField a) {
		return a.getText().toString();
	}

	public static boolean filled(JTextField a) {
		String s = RF(a);
		if (s.length() > 0)
			return true;
		else
			return false;
	}

	public static void showMessage(String s, int i) {
		JOptionPane.showMessageDialog(null, s, mes, i);
	}

	public static boolean urlValidator(String url) {
		try {
			new URL(url).toURI();
			return true;
		} catch (URISyntaxException exception) {
			return false;
		} catch (MalformedURLException exception) {
			return false;
		}
	}

	public static Boolean getMarker() {
		return marker;
	}

	public static void setMarker(Boolean marker) {
		NewURL.marker = marker;
	}
}