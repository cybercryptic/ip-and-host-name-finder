import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.awt.event.*;

class findip {
    static InetAddress GetIP;
    static JTextField HostNameField, HostAddressField;
    static void IPFinderGUI() {
        JFrame MainFrame = new JFrame("Net Tool");

        JPanel NamePanel = new JPanel();
        JPanel AddressPanel = new JPanel();
        JButton ResetBTN = new JButton("Reset");

        Font TheFont = new Font("Lato", Font.BOLD, 12);

        JLabel MainFrameHead = new JLabel("IP & Host Name Finder");
        MainFrameHead.setBounds(40, 30, 320, 40);

        JLabel HostName = new JLabel("Name :");
        HostName.setBounds(0, 0, 40, 40);
        JTextField HostNameField = new JTextField();
        HostNameField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        HostNameField.setBounds(50, 0, 180, 40);
        JButton NameSearch = new JButton("🔍");
        NameSearch.setBounds(240, 0, 50, 40);

        NamePanel.add(HostName);
        NamePanel.add(HostNameField);
        NamePanel.add(NameSearch);

        JLabel HostAddress = new JLabel("IP :");
        HostAddress.setBounds(0, 0, 40, 40);
        JTextField HostAddressField = new JTextField();
        HostAddressField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        HostAddressField.setBounds(50, 0, 180, 40);
        JButton AddressSearch = new JButton("🔍");
        AddressSearch.setBounds(240, 0, 50, 40);

        AddressPanel.add(HostAddress);
        AddressPanel.add(HostAddressField);
        AddressPanel.add(AddressSearch);

        NamePanel.setLayout(null);
        NamePanel.setBounds(40, 80, 320, 40);

        AddressPanel.setLayout(null);
        AddressPanel.setBounds(40, 140, 320, 40);

        ResetBTN.setBounds(150, 200, 100, 40);

        ResetBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HostNameField.setText("");
                HostAddressField.setText("");
            }
        });

        NameSearch.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String HostName = HostNameField.getText();
                try {
                    GetIP = InetAddress.getByName(HostName);
                } catch (UnknownHostException ea) {
                    ea.printStackTrace();
                }
                HostAddressField.setText(GetIP.getHostAddress());
            }
        });

        AddressSearch.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String HostAddress = HostAddressField.getText();
                try {
                    GetIP = InetAddress.getByName(HostAddress);
                } catch (UnknownHostException ea2) {
                    ea2.printStackTrace();
                }
                HostNameField.setText(GetIP.getHostName());
            }
        });

        MainFrame.add(MainFrameHead);
        MainFrame.add(NamePanel);
        MainFrame.add(AddressPanel);
        MainFrame.add(ResetBTN);
        MainFrame.setFont(TheFont);
        MainFrame.setLayout(null);
        MainFrame.setVisible(true);
        MainFrame.setSize(400, 400);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        IPFinderGUI();
    }
}