//import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*import java.io.BufferedReader;
 import java.io.FileInputStream;
 import java.io.IOException;
 import java.io.InputStreamReader;*/
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class GUIvasaradarinn extends JFrame {

	JLabel lpontunarNumer;

	JTextField txtPontunarNumer = new JTextField(15);// change to 6
	// JLabel lblVasaNumer = new JLabel("I Vasanum n :");
	JLabel txtFetchedVasaN = new JLabel();// put variable string from
											// Search method
	// try JTextField for lblFetchedVasaN instead and do .setEditable(false);

	JLabel lblTax = new JLabel("Velja adgerd: ");

	JButton bLeita = new JButton("Leita");
	String msgText;

	// JButton bDelete = new JButton("Fjarlaegja");

	public GUIvasaradarinn() {
		super("Vasaradarinn");
		lpontunarNumer = new JLabel(" Pontunar N: ");
		lpontunarNumer.setFont(new Font("Courier New", Font.ITALIC, 20));
		// lpontunarNumer.setForeground(Color.GRAY);
		JLabel lblVasaNumer = new JLabel(" I Vasanum N :");
		lblVasaNumer.setFont(new Font("Courier New", Font.ITALIC, 20));
		GridLayout gr = new GridLayout(3, 2, 1, 1);
		setLayout(gr);

		add(lpontunarNumer);
		add(txtPontunarNumer);
		add(lblVasaNumer);
		add(txtFetchedVasaN);

		add(bLeita);
		// add(bDelete);

		bLeita.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fetchVasa();

			}
		});
		// bDelete.addActionListener(this);
		txtPontunarNumer.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					fetchVasa();
				}
				// TODO Auto-generated method stub

			}
		});

		// Define, instantiate and register a WindowAdapter
		// to process windowClosing Event of this frame

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("Good bye!");
				System.exit(0);
			}
		});
	}

	public void fetchVasa() {
		String msgText;
		try {
			// put in a constractor to read a file in a prog sturtup
			StackReader sr = new StackReader();
			txtFetchedVasaN.setText(sr.SearchVasan(txtPontunarNumer.getText()));
			msgText= sr.SearchVasan(txtPontunarNumer.getText());
			
			
			/*try {
				UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Exception e) {
			}*/
			//UIManager.put("OptionPane.font", new Font("Tahoma", Font.BOLD, 20));
			int n = JOptionPane.showConfirmDialog(null, "I Vasa No. " + "\n"
			       
					+ msgText + "\n"
					+ " Delete?", null, JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				// StackReader sr = new StackReader();
				sr.DeletePontun(txtPontunarNumer.getText());

				txtPontunarNumer.setText("");
				txtFetchedVasaN.setText("");
			} else if (n == JOptionPane.NO_OPTION) {

			}

		} catch (NumberFormatException e) {
			txtFetchedVasaN.setText("Non-Numeric Data");
		} catch (Exception e) {
			txtFetchedVasaN.setText(e.getMessage());

		}

	}

	public static void main(String args[]) {
		try {
			
			UIManager
			.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");	} catch (Exception e) {
		}
		GUIvasaradarinn gvr = new GUIvasaradarinn();
		gvr.setSize(400, 150);
		gvr.setVisible(true);
	}
}
