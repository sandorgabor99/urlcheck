package ssl;

import java.io.Serializable;

public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String cim;

	public Address(String cim) {
		Address.cim = cim;
	}

	public static String getCim() {
		return cim;
	}

	public static String setCim(String cim) {
		return cim;
	}

}
