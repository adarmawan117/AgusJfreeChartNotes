package Method;

import javax.swing.JOptionPane;

public class Dialog {
    
    public void information(String pesan) {
        JOptionPane.showMessageDialog(null, pesan, "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void warning(String pesan) {
        JOptionPane.showMessageDialog(null, pesan, "Warning", JOptionPane.WARNING_MESSAGE);
    }
    
    public void error(String pesan) {
        JOptionPane.showMessageDialog(null, pesan, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void exception(Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
    }
}
