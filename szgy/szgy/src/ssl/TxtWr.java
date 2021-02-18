package ssl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TxtWr {


	public static void txt() {
		try {
			
			try {
				String str = Sslchecker.getRes();
				File newTextFile = new File("D:/" + random + ".txt");

				FileWriter fw = new FileWriter(newTextFile);
				fw.write(str);
				fw.close();
				NewURL.showMessage("Sikeres kiiras!\n A fajl ID-ja:" + random, 1);

			} catch (IOException iox) {
				// do stuff with exception
				iox.printStackTrace();
			}
		} catch (Exception x2) {
			NewURL.showMessage("Nem sikerult a Certificate kiirasa", 0);
		}
	}

	private static Random rand = new Random();
	private static int random = rand.nextInt(1000000);

}
