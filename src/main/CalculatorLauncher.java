package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.script.ScriptEngineManager;
import javax.swing.*;

public class CalculatorLauncher extends JFrame implements ActionListener {

    private JTextField textField;
	private String currentText = "";
	
	public CalculatorLauncher() {
        initializeUI();
    }

    private void initializeUI() {
        
        ScriptEngineManager manager = new ScriptEngineManager();
        manager.getEngineByName("js");
    	
    	JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        textField = new JTextField();
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
        addComponent(buttonPanel, n0, gbc, 0, 4, 2, 1);
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
        
    	JButton source = (JButton) e.getSource();
        String signals = "+-x/,";
        char lastChar;
        
        if(currentText.length() <= 0) {        	
        	lastChar = 0;
        } else {
        	lastChar = currentText.charAt(currentText.length() - 1);
        	if(lastChar == ' ') {
        		lastChar = currentText.charAt(currentText.length() - 2);
        	}
        };
        
        int exist = signals.indexOf(lastChar);
        switch(source.getText()) {
        	case "0": 
        		currentText += "0";
        		break;
        	case "1": 
        		currentText += "1";
        		break;
        	case "2": 
        		currentText += "2";
        		break;
        	case "3": 
        		currentText += "3";
        		break;
        	case "4": 
        		currentText += "4";
        		break;
        	case "5": 
        		currentText += "5";
        		break;
        	case "6": 
        		currentText += "6";
        		break;
        	case "7": 
        		currentText += "7";
        		break;
        	case "8": 
        		currentText += "8";
        		break;
        	case "9": 
        		currentText += "9";
        		break;
        	case "C": 
        		currentText = "";
        		break;
        	case "B": 
        		if(currentText.length() > 0) {
        			if(exist >= 0 && exist <= 4) {
        				if(lastChar != ',') {
        					currentText = currentText.substring(0, currentText.length() -3);
        				} else {
        					currentText = currentText.substring(0, currentText.length() -1);
        				}
        			} else {
    					currentText = currentText.substring(0, currentText.length() -1);
        			}
        		}
        		break;
        	case "+": 
        		if(lastChar != '+') {
	        		if(exist >= 0 && exist <= 4) {
	        			if(lastChar != ',') {
	        				currentText = currentText.substring(0, currentText.length() -3);
	        			} else {
	            			currentText = currentText.substring(0, currentText.length() -1);
	        			}
	        		}
	        		currentText += " + ";
        		}
        		break;
        	case "-": 
        		if(lastChar != '-') {
	        		if(exist >= 0 && exist <= 4) {
	        			if(lastChar != ',') {
	        				currentText = currentText.substring(0, currentText.length() -3);
	        			} else {
	            			currentText = currentText.substring(0, currentText.length() -1);
	        			}
	        		}
	        		currentText += " - ";
        		}
        		break;
        	case "x": 
        		if(lastChar != 'x') {
	        		if(exist >= 0 && exist <= 4) {
	        			if(lastChar != ',') {
	        				currentText = currentText.substring(0, currentText.length() -3);
	        			} else {
	            			currentText = currentText.substring(0, currentText.length() -1);
	        			}
	        		}
	        		currentText += " x ";
        		}
        		break;
        	case "/": 
        		if(lastChar != '/') {
	        		if(exist >= 0 && exist <= 4) {
	        			if(lastChar != ',') {
	        				currentText = currentText.substring(0, currentText.length() -3);
	        			} else {
	            			currentText = currentText.substring(0, currentText.length() -1);
	        			}
	        		}
	        		currentText += " / ";
        		}
        		break;
        	case ",": 
        		if(exist >= 0 && exist <= 4 && lastChar != ',') {
        			currentText = currentText.substring(0, currentText.length() -3);
            		currentText += ",";
        		} else if(lastChar != ',') {
            		currentText += ",";
        		}
        		break;
        	case "=":

            	String[] tokens = currentText.split("\\s+");

        		if(exist >= 0 && exist <= 4) {
        			if(lastChar != ',') {
        				currentText = currentText.substring(0, currentText.length() -3);
        			} else {
            			currentText = currentText.substring(0, currentText.length() -1);
        			}
        		}
        		
            	Stack<Double> stack = new Stack<>();
            	double result = 0;
            	double operand1; 
            	double operand2;
            	
            	for(int loop = 0; loop < tokens.length; loop = loop + 2) {
        			System.out.println(loop);
            		if(loop == 0) {
            			if (loop > 0 && tokens[loop - 1].equals("-")) {
            		        stack.push(-Double.parseDouble(tokens[loop].replace(',', '.')));
            		    } else {
            		    	stack.push(Double.parseDouble(tokens[loop].replace(',', '.')));
            		    }
						loop = loop + 2;
						stack.push(Double.parseDouble(tokens[loop].replace(',', '.')));
	                    operand2 = stack.pop();
        			} else {
						stack.push(Double.parseDouble(tokens[loop]));
	                    operand2 = result;
        			}
                    operand1 = stack.pop();
                    result = performOperation(operand1, operand2, tokens[loop - 1]);
                    currentText = String.format("%.2f", result);
        		};
        		break;
        	
        };
        
        textField.setText(currentText);
    };

    private static double performOperation(double operand1, double operand2, String operator) {

    	switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "x":
                return operand1 * operand2;
            case "/":
                if (operand1 != 0 || operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new ArithmeticException("Divisão por zero");
                }
            default:
                throw new IllegalArgumentException("Operador desconhecido: " + operator);
        }
    }
    
}