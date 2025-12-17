package gui;

import models.Member;
import services.MemberService;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckInPanel extends JPanel {
    private JTextArea logArea;

    public CheckInPanel(MemberService service) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel header = new JLabel("Member Check-In", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        add(header, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.WHITE);
        JTextField idField = new JTextField(10);
        JButton checkInBtn = new JButton("Check In");
        checkInBtn.setBackground(new Color(52, 152, 219));
        checkInBtn.setForeground(Color.WHITE);

        inputPanel.add(new JLabel("Member ID:"));
        inputPanel.add(idField);
        inputPanel.add(checkInBtn);
        centerPanel.add(inputPanel, BorderLayout.NORTH);

        logArea = new JTextArea();
        logArea.setEditable(false);
        logArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        centerPanel.add(new JScrollPane(logArea), BorderLayout.CENTER);

        checkInBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                Member m = service.getMember(id);
                String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                if (m != null) {
                    logArea.append("[" + time + "] CHECK-IN: " + m.getName() + " (ID: " + id + ")\n");
                } else {
                    logArea.append("[" + time + "] ERROR: Member ID " + id + " not found\n");
                }
                idField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid ID");
            }
        });

        add(centerPanel, BorderLayout.CENTER);
    }
}
