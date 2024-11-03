package Solution;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ContactApp
{
    private JFrame frame;
    private JList<String> contactList;
    private final DefaultListModel<String> listModel;
    private JLabel mobileLabel, workLabel, emailLabel;
    private ContactData contactData;

    // Constructor to set up the GUI
    public ContactApp()
    {
        // Set the Nimbus look and feel
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        contactData = new ContactData("contacts.txt");

        // Set up the main frame
        frame = new JFrame("Contact List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Contact list model and list
        listModel = new DefaultListModel<>();
        for (String contactName : contactData.getContactNames())
        {
            listModel.addElement(contactName);
        }
        contactList = new JList<>(listModel);
        contactList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contactList.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(new JScrollPane(contactList), BorderLayout.WEST);

        // Contact details panel
        JPanel detailPanel = new JPanel(new GridLayout(4, 1));
        mobileLabel = new JLabel("Mobile: ");
        workLabel = new JLabel("Work: ");
        emailLabel = new JLabel("Email: ");
        detailPanel.add(mobileLabel);
        detailPanel.add(workLabel);
        detailPanel.add(emailLabel);
        detailPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Search button to fetch contact details
        JButton searchButton = new JButton("Search");
        searchButton.setFocusPainted(false);
        searchButton.setMargin(new Insets(10, 20, 10, 20));
        searchButton.addActionListener((ActionEvent e) -> {
            String selectedName = contactList.getSelectedValue();
            if (selectedName != null)
            {
                String[] details = contactData.getContactDetails(selectedName);
                if (details != null)
                {
                    mobileLabel.setText("Mobile: " + details[0]);
                    workLabel.setText("Work: " + details[1]);
                    emailLabel.setText("Email: " + details[2]);
                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "Contact details not found.");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(frame, "Please select a contact to view details.");
            }
        });

        // Add panels and button to frame
        frame.add(detailPanel, BorderLayout.CENTER);
        frame.add(searchButton, BorderLayout.SOUTH);

        // Display frame
        frame.setVisible(true);
    }

    // Main method to run the application
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(ContactApp::new);
    }
}
