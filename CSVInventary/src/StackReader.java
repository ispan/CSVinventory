import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
//import java.io.Writer;
import java.util.ArrayList;

import java.util.HashSet;


import java.util.Set;

public class StackReader {

	private static BufferedReader cSVFileReader;
	// private static BufferedWriter cSVFileWriter;

	//ArrayList<DTOPontunVasar> allarpontunar = new ArrayList<DTOPontunVasar>();
	Set<DTOPontunVasar> allarpontunar = new HashSet<DTOPontunVasar>();
	// HASHtable hashmap key-value pairs
	ArrayList<String> vasaArray = new ArrayList<String>();
	private BufferedWriter out = null;
	private FileOutputStream fos = null;

	StackReader() { // throws IOException

		DTOPontunVasar temp = null;
		try {
			cSVFileReader = new BufferedReader(new FileReader("VasaSkra.DAT"));
			String dataRow = cSVFileReader.readLine();
			// ArrayList <DTOPontunVasar> allarpontunar = new
			// ArrayList<DTOPontunVasar>();
			String pontunarN = null;
			String vasaN = null;

			while (dataRow != null) {
				String[] dataArray = dataRow.split(",");
				for (String item : dataArray) {
					if (item.length() > 4) {
						pontunarN = item;
					} else {
						vasaN = item;

					}
					/*
					 * temp = new DTOPontunVasar(pontunarN, vasaN);
					 * allarpontunar.add(temp);
					 */
					// System.out.print(item + "\t");
				}
				temp = new DTOPontunVasar(pontunarN, vasaN);
				allarpontunar.add(temp);
				System.out.println(); // Print the data line.
				dataRow = cSVFileReader.readLine();
				
				
				// get rid of a double entries here 
				
				
				
				
			}
		} catch (IOException e) {
			// throw new IOException (e.getMessage());
		} finally {
			try {

				cSVFileReader.close();

			} catch (IOException e) {
				e.printStackTrace();

			}

		}
	}

	public String SearchVasan(String enteredPontun) {

		String vasaN = "";
		String tempVasaN = "";
		for (DTOPontunVasar pairValue : allarpontunar) {

			if (enteredPontun.equalsIgnoreCase(pairValue.getPontunarN())) {

				tempVasaN = pairValue.getVasaN();
			
				 vasaArray.add(tempVasaN);

			}

			
		}
		 Set<String> set = new HashSet<String>(vasaArray);

		    System.out.print("Remove duplicate result: ");

		    String[] result = new String[set.size()];
		    set.toArray(result);
		    for (String s : result) {
		    	String semicol = ";";
		      System.out.print(s + ", ");
		      // adding a "rekka msg to output for values bigger then 1000
		      // Ispan marking rekkar from 1 to 2999 . available figures are >=3000 
		      if (Integer.parseInt(s)<=3000){
		    	  vasaN = vasaN.concat(" Rekka#"+ s + semicol);
		    	  
		      }else{
		      vasaN=vasaN.concat(" inni-"+s.substring(1)+ semicol);
		      }
		    }

		return vasaN;
	}

	/*public String DoubleEntry(String v) {
		
		for (String va : vasaArray) {
			if (va.equalsIgnoreCase(v)) {

			}
		return v;
		}
		
		return null;
	}
*/
	

	public void DeletePontun(String pontunToDelete) {
	
		try {
			//FileOutputStream fos = null;
		
			fos = new FileOutputStream("VasaSkra.dat");
			out = new BufferedWriter(new OutputStreamWriter(fos));
			for (DTOPontunVasar pairToWrite : allarpontunar) {
				if (pontunToDelete.equalsIgnoreCase(pairToWrite.getPontunarN())) {

				} else {

					String coma = ",";
					out.write(pairToWrite.getPontunarN());
					out.write(coma);
					out.write(pairToWrite.getVasaN());
					out.write(coma);
					out.write("\n");
				}

			}

			// Flush the BUFFER !!!
			
			// finally  do  close 
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}
	}
}
