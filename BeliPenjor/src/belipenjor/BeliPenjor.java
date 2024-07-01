package belipenjor;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Ekanesa
 * NIM : 2201010116
 */
public class BeliPenjor {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        int choice = JOptionPane.showOptionDialog(null, "PILIH MENU : \n1. Data Penjor\n2. Pembelian Penjor", "Pilihan Form", 
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Data Penjor", "Pembelian Penjor", "Cancel"}, "Data Penjor");

        switch (choice) {
            case 0:
                jForm1 jf1 = new jForm1();
                jf1.setResizable(false);
                jf1.setAlwaysOnTop(true);
                jf1.setVisible(true);
                break;
            case 1:
                jForm22 jf22 = new jForm22();
                jf22.setResizable(false);
                jf22.setAlwaysOnTop(true);
                jf22.setVisible(true);
                break;
            case 2:
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Pilihan tidak valid");
                break;
        }
    }
    
}
