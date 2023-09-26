package init;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.AbstractAction;

public class JavaCalculator {
	// Format the result to remove ".0" if it's an integer
    static String formatResult(double result) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#.##########", symbols);
        String formattedResult = decimalFormat.format(result);
        return formattedResult.endsWith(".0") ? formattedResult.substring(0, formattedResult.length() - 2) : formattedResult;
    }

	public static void main(String[] args) {
		JFrame frame = new JFrame("Calculator");
        JPanel panel = new JPanel();
        
        panel.setBackground(Color.decode("#202020"));
        
        panel.setLayout(new FlowLayout());
        
        Font fieldFont = new Font("Segoe UI", Font.BOLD, 40);
        
        Font buttonFont = new Font("Segoe UI",Font.BOLD, 18);
        
        JTextField t1;
        t1 = new JTextField();
        t1.setFont(fieldFont);
        t1.setBackground(Color.decode("#202020"));
        t1.setForeground(Color.WHITE);
        t1.setHorizontalAlignment(SwingConstants.RIGHT);
        t1.setBorder(null);
        t1.setPreferredSize(new Dimension(0, 230));
        t1.setEditable(false);
        
        frame.add(t1, BorderLayout.NORTH);
        
        String[] button_text = {
                "DEL", "CE", "C", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "±", "0", ".", "="
        };
        
        List<JButton> buttons = new ArrayList<>();
        for (int i = 0; i < button_text.length; i++) {
            JButton button = new JButton(button_text[i]);
            buttons.add(button);

            if (i <= 3  || i == 7 || i == 11 || i == 15) {
                button.setBackground(Color.decode("#323232")); // Dark gray
                button.setForeground(Color.WHITE);
            } else if ((i >= 4 && i < 15) || (i >= 16 && i < 19)) {
                button.setBackground(Color.decode("#3b3b3b")); // Slightly lighter gray
                button.setForeground(Color.WHITE);
            } else if (i == 19) {
                button.setBackground(Color.decode("#76b9ed")); // Light blue
                button.setForeground(Color.BLACK);
            }

            button.setPreferredSize(new Dimension(74, 50));
            button.setFont(buttonFont);
            button.setBorderPainted(false);
            
            //frame.add(button);
            switch(button_text[i]) {
	            case "DEL":
	            	// Key DEL
	                Action pressButtonActionDel = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        button.doClick(); // Simulate a button click
	                    }
	                };
	                // Bind the "DEL" key to the pressButtonActionDel
	                t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "pressButtonActionDel");
	                t1.getActionMap().put("pressButtonActionDel", pressButtonActionDel);
	            	
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                        String currentText = t1.getText();
	                        if (currentText.length() > 0) {
	                            t1.setText(currentText.substring(0, currentText.length() - 1)); // Remove the last character
	                        }
	                    }
	                });
	                break;
	            case "CE":
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                        String currentText = t1.getText();
	
	                        if (currentText.length() > 1) {
	                            int lastIndex = currentText.lastIndexOf(' ');
	                            if (lastIndex > 0) {
	                                t1.setText(currentText.substring(0, lastIndex + 1));
	                            } else {
	                                t1.setText("");
	                            }
	                        } else {
	                            t1.setText("");
	                        }
	                    }
	                });
	                break;
	            case "C":
	            	// Key CE
	                Action pressButtonActionCE = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        button.doClick(); // Simulate a button click
	                    }
	                };
	                // Bind the "CE" key to the pressButtonActionCE
	                t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "pressButtonActionCE");
	                t1.getActionMap().put("pressButtonActionCE", pressButtonActionCE);
	            	
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                        t1.setText("");
	                    }
	                });
	                break;
	            case "/":
	            	// Key /
	                Action pressButtonActionSlash = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        button.doClick(); // Simulate a button click
	                    }
	                };
	                // Bind the "/" key to the pressButtonActionSlash
	                t1.getInputMap().put(KeyStroke.getKeyStroke('/'), "pressButtonActionSlash");
	                t1.getActionMap().put("pressButtonActionSlash", pressButtonActionSlash);
	            	
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                        String currentText = t1.getText();
	                        t1.setText(currentText + " / ");
	                    }
	                });
	                break;
	            case "7":
	            	// Key 7
	                Action pressButtonAction7 = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        button.doClick(); // Simulate a button click
	                    }
	                };
	                // Bind the "7" key to the pressButtonAction7
	                t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_7, 0), "pressButtonAction7");
	                t1.getActionMap().put("pressButtonAction7", pressButtonAction7);
	                
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    	String currentText = t1.getText();
	                        t1.setText(currentText + "7");
	                    }
	                });
	                break;
	            case "8":
	            	// Key 8
	                Action pressButtonAction8 = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        button.doClick(); // Simulate a button click
	                    }
	                };
	                // Bind the "8" key to the pressButtonAction8
	                t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_8, 0), "pressButtonAction8");
	                t1.getActionMap().put("pressButtonAction8", pressButtonAction8); 
	            	
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    	String currentText = t1.getText();
	                        t1.setText(currentText + "8");
	                    }
	                });
	                break;
	            case "9":
	            	// Key 9
	                Action pressButtonActio9 = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        button.doClick(); // Simulate a button click
	                    }
	                };
	                // Bind the "9" key to the pressButtonAction8
	                t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_9, 0), "pressButtonActio9");
	                t1.getActionMap().put("pressButtonActio9", pressButtonActio9);
	            	
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    	String currentText = t1.getText();
	                        t1.setText(currentText + "9");
	                    }
	                });
	                break;
	            case "*":
	            	// Key *
	                Action pressButtonActionMultiply = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        button.doClick(); // Simulate a button click
	                    }
	                };
	                // Bind the "*" key to the pressButtonActionSlash
	                t1.getInputMap().put(KeyStroke.getKeyStroke('*'), "pressButtonActionMultiply");
	                t1.getActionMap().put("pressButtonActionMultiply", pressButtonActionMultiply);
	            	
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    	String currentText = t1.getText();
	                        t1.setText(currentText + " * ");
	                    }
	                });
	                break;
	            case "4":
	            	// Key 4
	                Action pressButtonActio4 = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        button.doClick(); // Simulate a button click
	                    }
	                };
	                // Bind the "4" key to the pressButtonAction4
	                t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_4, 0), "pressButtonActio4");
	                t1.getActionMap().put("pressButtonActio4", pressButtonActio4);
	            	
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    	String currentText = t1.getText();
	                        t1.setText(currentText + "4");
	                    }
	                });
	                break;
	            case "5":
	            	// Key 5
	                Action pressButtonAction5 = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                    	button.doClick(); // Simulate a button click
	                    }
	                };

	                // Bind the "5" key to the pressButtonAction5
	                t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_5, 0), "pressButtonAction5");
	                t1.getActionMap().put("pressButtonAction5", pressButtonAction5);
	            	
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    	String currentText = t1.getText();
	                        t1.setText(currentText + "5");
	                    }
	                });
	                break;
	            case "6":
	            	// Key 6
	                Action pressButtonAction6 = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        button.doClick(); // Simulate a button click
	                    }
	                };

	                // Bind the "6" key to the pressButtonAction6
	                t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_6, 0), "pressButtonAction6");
	                t1.getActionMap().put("pressButtonAction6", pressButtonAction6);
	            	
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    	String currentText = t1.getText();
	                        t1.setText(currentText + "6");
	                    }
	                });
	                break;
	            case "-":
	            	// Key -
	                Action pressButtonActionMinus = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        button.doClick(); // Simulate a button click
	                    }
	                };

	                // Bind the "-" key to the pressButtonActionMinus
	                t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), "pressButtonActionMinus");
	                t1.getActionMap().put("pressButtonActionMinus", pressButtonActionMinus);
	            	
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    	String currentText = t1.getText();
	                        t1.setText(currentText + " - ");
	                    }
	                });
	                break;
	            case "1":
	            	// Key 1
	                Action pressButtonAction1 = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        button.doClick(); // Simulate a button click
	                    }
	                };

	                // Bind the "1" key to the pressButtonAction1
	                t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0), "pressButtonAction1");
	                t1.getActionMap().put("pressButtonAction1", pressButtonAction1);
	            	
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    	String currentText = t1.getText();
	                        t1.setText(currentText + "1");
	                    }
	                });
	                break;
	            case "2":
	            	// Key 2
	                Action pressButtonAction2 = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        button.doClick(); // Simulate a button click
	                    }
	                };

	                // Bind the "2" key to the pressButtonAction2
	                t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0), "pressButtonAction2");
	                t1.getActionMap().put("pressButtonAction2", pressButtonAction2);
	            	
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    	String currentText = t1.getText();
	                        t1.setText(currentText + "2");
	                    }
	                });
	                break;
	            case "3":
	            	// Key 3
	                Action pressButtonAction3 = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        button.doClick(); // Simulate a button click
	                    }
	                };

	                // Bind the "3" key to the pressButtonAction3
	                t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0), "pressButtonAction3");
	                t1.getActionMap().put("pressButtonAction3", pressButtonAction3);
	            	
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    	String currentText = t1.getText();
	                        t1.setText(currentText + "3");
	                    }
	                });
	                break;
	            case "±":
	            	// Key ±
	                Action pressButtonActionNegate = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        button.doClick(); // Simulate a button click
	                    }
	                };

	                // Bind the "±" key to the pressButtonActionNegate
	                t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_N, 0), "pressButtonActionNegate");
	                t1.getActionMap().put("pressButtonActionNegate", pressButtonActionNegate);
	            	
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    	String currentText = t1.getText();
	                    	double number = Double.parseDouble(currentText);
	                        // Add a minus sign before the number
	                        t1.setText("-" + formatResult(number));
	                    }
	                });
	                break;
	            case "+":
	            	// Key +
	                Action pressButtonActionPlus = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        button.doClick(); // Simulate a button click
	                    }
	                };

	                // Bind the "Plus" key to the pressButtonActionPlus
	                t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, 0), "pressButtonActionPlus");
	                t1.getActionMap().put("pressButtonActionPlus", pressButtonActionPlus);
	            	
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    	String currentText = t1.getText();
	                        t1.setText(currentText + " + ");
	                    }
	                });
	                break;
	            case "0":
	            	// Key 0
	                Action pressButtonAction0 = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        button.doClick(); // Simulate a button click
	                    }
	                };

	                // Bind the "0" key to the pressButtonAction0
	                t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_0, 0), "pressButtonAction0");
	                t1.getActionMap().put("pressButtonAction0", pressButtonAction0);
	            	
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    	String currentText = t1.getText();
	                        t1.setText(currentText + "0");
	                    }
	                });
	                break;
	            case ".":
	            	// Key dot
	                Action pressButtonActionDot = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        button.doClick(); // Simulate a button click
	                    }
	                };

	                // Bind the "dot" key to the pressButtonActionDot
	                t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0), "pressButtonActionDot");
	                t1.getActionMap().put("pressButtonActionDot", pressButtonActionDot);
	            	
	                button.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    	String currentText = t1.getText();
	                        t1.setText(currentText + ".");
	                    }
	                });
	                break;
	            case "=":
	            	// Key =
	                Action pressButtonActionEquals = new AbstractAction() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        button.doClick(); // Simulate a button click
	                    }
	                };

	                // Bind the "=" key to the pressButtonActionEquals
	                t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "pressButtonActionEquals");
	                t1.getActionMap().put("pressButtonActionEquals", pressButtonActionEquals);
	            	
	                button.addActionListener(new ActionListener() {
	                	public void actionPerformed(ActionEvent e) {
	                    	String expression = t1.getText();
	                        
	                        // Attempt to evaluate the expression
	                        try {
	                            double result = evaluateExpression(expression);
	                            t1.setText(formatResult(result));
	                        } catch (Exception ex) {
	                            t1.setText("Error"); // Handle any errors in expression evaluation
	                        }
	                    }
	                    private double evaluateExpression(String expression) {
	                        String[] parts = expression.split(" ");
	                        double operand1 = Double.parseDouble(parts[0]);
	                        String operator = parts[1];
	                        double operand2 = Double.parseDouble(parts[2]);

	                        switch (operator) {
	                            case "+":
	                                return operand1 + operand2;
	                            case "-":
	                                return operand1 - operand2;
	                            case "*":
	                                return operand1 * operand2;
	                            case "/":
	                                if (operand2 != 0) {
	                                    return operand1 / operand2;
	                                } else {
	                                    throw new ArithmeticException("Division by zero");
	                                }
	                            default:
	                                throw new IllegalArgumentException("Invalid operator");
	                        }
	                    }
	                    
	                });
	                break;
            }
            panel.add(button);
        }
        
        frame.add(panel);
        Image icon = Toolkit.getDefaultToolkit().getImage("img/icon.png");  
        frame.setIconImage(icon);
        frame.setSize(335, 550);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);
	}
}