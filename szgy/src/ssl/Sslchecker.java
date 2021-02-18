package ssl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.security.Principal;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Sslchecker {
	private static String res;
	protected static X509Certificate[] tan;
	private static Date expiry;
	private static Principal subject;
	private static Principal issuer;

	public static void Checker() throws Exception {
		try {
			String value = Address.getCim();
			SSLContext ctx = SSLContext.getInstance("TLS");
			ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
			SSLContext.setDefault(ctx);
			URL url = new URL(value);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setHostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}
			});
			System.out.println(conn.getResponseCode());
			Certificate[] certs = conn.getServerCertificates();
			tan = (X509Certificate[]) conn.getServerCertificates();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(baos);
			PrintStream old = System.out;
			System.setOut(ps);
			int c = 0;
			for (Certificate cert : certs) {
				String t = cert.getType();
				System.out.println(String.format("\ncert[%d]: %s", c, t));
				c++;
				System.out.println(cert);
				if (cert instanceof X509Certificate) {
					X509Certificate x509cert = (X509Certificate) cert;
					System.out.println(x509cert.getSubjectDN().getName());
				}
			}
			System.out.flush();
			System.setOut(old);
			setRes(baos.toString());

			conn.disconnect();
		} catch (Exception x3) {
			NewURL.showMessage("Nem ellenõrizhetõ a megadott URL vagy hibás", 0);
			NewURL.setMarker(false);

		}
	}

	public static String getRes() {
		return res;
	}

	public static void setRes(String res) {
		Sslchecker.res = res;
	}

	public static class DefaultTrustManager implements X509TrustManager {

		@Override
		public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		}

		@Override
		public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	}

	public static boolean isServerTrusted(X509Certificate[] cert) {
		try {
			cert[0].checkValidity();
			expiry = cert[0].getNotAfter();
			NewURL.showMessage("A tanústvány érvényes aláírással rendelkezik!\n" + expiry + " idõpontig!", 1);
			return true;
		} catch (CertificateExpiredException e) {
			expiry = cert[0].getNotAfter();
			NewURL.showMessage("A tanúsítvány már nem érvényes!\n" + expiry + " idõpontban lejárt!", 0);
			return false;
		} catch (CertificateNotYetValidException e) {
			NewURL.showMessage("A tanúsítvány még nem volt aláírva a múltban,érvénytelen", 0);
			return false;
		}
	}

	public static void Subject(X509Certificate[] cert) {
		try {
			subject = cert[0].getSubjectDN();
			NewURL.showMessage("A Tanúsítványról tárolt bõvebb információk: \n" + subject, 1);
		} catch (Exception x5) {
			NewURL.showMessage("Nem lekerdezhetõ a Subject!", 0);
		}

	}
	public static void Issuer(X509Certificate[] cert) {
		try {
			issuer = cert[0].getIssuerDN();
			NewURL.showMessage("A Tanúsítvány kibocsájtója: \n" + issuer, 1);
		} catch (Exception x7) {
			NewURL.showMessage("Nem lekerdezheto!", 0);
		}
	}

}
