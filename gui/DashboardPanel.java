package gui;

import utils.UIStyles;
import services.MemberService;
import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {
    public DashboardPanel() {
        setBackground(UIStyles.BACKGROUND);
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        // Header
        JLabel title = new JLabel("Dashboard");
        title.setFont(UIStyles.TITLE_FONT);
        title.setForeground(UIStyles.TEXT_PRIMARY);
        add(title, BorderLayout.NORTH);
        
        // Stats cards
        JPanel statsGrid = new JPanel(new GridLayout(1, 4, 20, 0));
        statsGrid.setOpaque(false);
        
        statsGrid.add(createStatCard("👥 Total Members", String.valueOf(MemberService.getInstance().getAllMembers().size()), UIStyles.PRIMARY));
        statsGrid.add(createStatCard("✅ Active Today", "12", UIStyles.SECONDARY));
        statsGrid.add(createStatCard("⏰ Expiring Soon", "5", UIStyles.WARNING));
        statsGrid.add(createStatCard("💰 Revenue", "$4,250", new Color(139, 92, 246)));
        
        JPanel centerPanel = new JPanel(new BorderLayout(0, 20));
        centerPanel.setOpaque(false);
        centerPanel.add(statsGrid, BorderLayout.NORTH);
        
        // Recent activity
        JPanel activityCard = UIStyles.createCard("Recent Activity");
        JTextArea activityLog = new JTextArea();
        activityLog.setEditable(false);
        activityLog.setFont(UIStyles.BODY_FONT);
        activityLog.setText("• John Doe checked in at 9:00 AM\n• Jane Smith membership renewed\n• New member: Mike Johnson\n• Equipment maintenance scheduled");
        activityLog.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        activityCard.add(new JScrollPane(activityLog), BorderLayout.CENTER);
        
        centerPanel.add(activityCard, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);
    }
    
    private JPanel createStatCard(String label, String value, Color accentColor) {
        JPanel card = new JPanel();
        card.setBackground(UIStyles.CARD_BG);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 4, 0, 0, accentColor),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        valueLabel.setForeground(UIStyles.TEXT_PRIMARY);
        
        JLabel nameLabel = new JLabel(label);
        nameLabel.setFont(UIStyles.BODY_FONT);
        nameLabel.setForeground(UIStyles.TEXT_SECONDARY);
        
        card.add(valueLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(nameLabel);
        
        return card;
    }
}
