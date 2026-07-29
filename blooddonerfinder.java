public class BloodDonorFinder extends JFrame implements ActionListener {

    JTextField nameField, cityField, phoneField;
    JComboBox<String> bloodGroupBox;
    JButton addButton, searchButton;
    JTable table;
    DefaultTableModel model;

    public BloodDonorFinder() {

        setTitle("Emergency Blood Donor Finder");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Blood Group"));
        bloodGroupBox = new JComboBox<>(new String[]{
                "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"
        });
        panel.add(bloodGroupBox);

        panel.add(new JLabel("City"));
        cityField = new JTextField();
        panel.add(cityField);

        panel.add(new JLabel("Phone"));
        phoneField = new JTextField();
        panel.add(phoneField);

        addButton = new JButton("Add Donor");
        searchButton = new JButton("Search Donor");

        addButton.addActionListener(this);
        searchButton.addActionListener(this);

        panel.add(addButton);
        panel.add(searchButton);

        add(panel, BorderLayout.NORTH);

        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Blood Group");
        model.addColumn("City");
        model.addColumn("Phone");

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {

            if (nameField.getText().isEmpty() ||
                    cityField.getText().isEmpty() ||
                    phoneField.getText().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }

            model.addRow(new Object[]{
                    nameField.getText(),
                    bloodGroupBox.getSelectedItem(),
                    cityField.getText(),
                    phoneField.getText()
            });

            JOptionPane.showMessageDialog(this, "Donor Added Successfully!");

            nameField.setText("");
            cityField.setText("");
            phoneField.setText("");
            bloodGroupBox.setSelectedIndex(0);
        }

        if (e.getSource() == searchButton) {

            String group = JOptionPane.showInputDialog(this,
                    "Enter Blood Group (Example: A+, O-)");

            if (group == null)
                return;

            boolean found = false;
            String result = "";

            for (int i = 0; i < model.getRowCount(); i++) {

                if (model.getValueAt(i, 1).toString().equalsIgnoreCase(group)) {

                    result += "Name : " + model.getValueAt(i, 0)
                            + "\nCity : " + model.getValueAt(i, 2)
                            + "\nPhone : " + model.getValueAt(i, 3)
                            + "\n-------------------------\n";

                    found = true;
                }
            }

            if (found) {
                JOptionPane.showMessageDialog(this, result);
            } else {
                JOptionPane.showMessageDialog(this,
                        "No Donor Found for Blood Group " + group);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BloodDonorFinder());
    }
}
