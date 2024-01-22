package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorLauncher extends JFrame implements ActionListener {

    public CalculatorLauncher() {
        initializeUI();
    }

    private void initializeUI() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField();
        Font bigFont = textField.getFont().deriveFont(Font.PLAIN, 25f);
        textField.setFont(bigFont);

        JButton ac = new JButton("C");
        JButton n0 = new JButton("0");
        JButton n1 = new JButton("1");
        JButton n2 = new JButton("2");
        JButton n3 = new JButton("3");
        JButton n4 = new JButton("4");
        JButton n5 = new JButton("5");
        JButton n6 = new JButton("6");
        JButton n7 = new JButton("7");
        JButton n8 = new JButton("8");
        JButton n9 = new JButton("9");
        JButton pb = new JButton("+");
        JButton mb = new JButton("-");
        JButton tb = new JButton("x");
        JButton db = new JButton("/");
        JButton rb = new JButton("B");
        JButton cb = new JButton(",");
        
        JButton sb = new JButton("=");

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridheight = 1;

        addComponent(buttonPanel, ac, gbc, 0, 0);
        addComponent(buttonPanel, tb, gbc, 1, 0);
        addComponent(buttonPanel, db, gbc, 2, 0);
        addComponent(buttonPanel, rb, gbc, 3, 0);
        addComponent(buttonPanel, n7, gbc, 0, 1);
        addComponent(buttonPanel, n8, gbc, 1, 1);
        addComponent(buttonPanel, n9, gbc, 2, 1);
        addComponent(buttonPanel, pb, gbc, 3, 1);
        addComponent(buttonPanel, n4, gbc, 0, 2);
        addComponent(buttonPanel, n5, gbc, 1, 2);
        addComponent(buttonPanel, n6, gbc, 2, 2);
        addComponent(buttonPanel, mb, gbc, 3, 2);
        addComponent(buttonPanel, n1, gbc, 0, 3);
        addComponent(buttonPanel, n2, gbc, 1, 3);
        addComponent(buttonPanel, n3, gbc, 2, 3);
        addComponent(buttonPanel, n0, gbc, 0, 4, 2, 1); // Ocupa duas colunas
        addComponent(buttonPanel, cb, gbc, 2, 4, 1, 1);
        addComponent(buttonPanel, sb, gbc, 3, 3, 1, 2);
        
        frame.setLayout(new BorderLayout());
        frame.add(textField, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        
        n0.addActionListener(this);
        n1.addActionListener(this);
        n2.addActionListener(this);
        n3.addActionListener(this);
        n4.addActionListener(this);
        n5.addActionListener(this);
        n6.addActionListener(this);
        n7.addActionListener(this);
        n8.addActionListener(this);
        n9.addActionListener(this);
        ac.addActionListener(this);
        pb.addActionListener(this);
        mb.addActionListener(this);
        tb.addActionListener(this);
        db.addActionListener(this);
        cb.addActionListener(this);
        rb.addActionListener(this);
        sb.addActionListener(this);

        frame.setSize(250, 300);
        frame.setVisible(true);
    }

    private void addComponent(JPanel panel, Component comp, GridBagConstraints gbc, int gridx, int gridy) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        panel.add(comp, gbc);
    }

    private void addComponent(JPanel panel, Component comp, GridBagConstraints gbc, int gridx, int gridy, int gridwidth, int gridheight) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        panel.add(comp, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks here
    }

    public static void main(String[] args) {
        new CalculatorLauncher();
    }
}