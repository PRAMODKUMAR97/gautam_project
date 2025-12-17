package utils;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class UIStyles {
    // Color Palette
    public static final Color PRIMARY = new Color(79, 70, 229);      // Indigo
    public static final Color PRIMARY_DARK = new Color(67, 56, 202);
    public static final Color SECONDARY = new Color(16, 185, 129);   // Emerald
    public static final Color BACKGROUND = new Color(249, 250, 251);
    public static final Color CARD_BG = Color.WHITE;
    public static final Color TEXT_PRIMARY = new Color(17, 24, 39);
    public static final Color TEXT_SECONDARY = new Color(107, 114, 128);
    public static final Color BORDER = new Color(229, 231, 235);
    public static final Color DANGER = new Color(239, 68, 68);
    public static final Color WARNING = new Color(245, 158, 11);
    
    // Fonts
    public static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 28);
    public static final Font SUBTITLE_FONT = new Font("Segoe UI", Font.BOLD, 18);
    public static final Font BODY_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    public static final Font SMALL_FONT = new Font("Segoe UI", Font.PLAIN, 12);
    
    public static JButton createStyledButton(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setFont(BODY_FONT);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(140, 40));
        return btn;
    }
    
    public static JTextField createStyledTextField() {
        JTextField field = new JTextField();
        field.setFont(BODY_FONT);
        field.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER, 1, true),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        return field;
    }
    
    public static JPanel createCard(String title) {
        JPanel card = new JPanel();
        card.setBackground(CARD_BG);
        card.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BORDER, 1, true),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        card.setLayout(new BorderLayout(0, 10));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(SUBTITLE_FONT);
        titleLabel.setForeground(TEXT_PRIMARY);
        card.add(titleLabel, BorderLayout.NORTH);
        
        return card;
    }
}
