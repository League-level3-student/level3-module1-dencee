package _03_IntroToStacks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class _01_IntroToStack implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField numLow = new JTextField("<low number>", 10);
	JTextField numHigh = new JTextField("<high number>", 10);
	JButton button = new JButton();
	JTextArea textArea = new JTextArea("<numbers>", 1, 40);
	Stack<Double> sd = new Stack<Double>();

	public static void main(String[] args) {
		new _01_IntroToStack().start();
	}

	void start() {
		// 1. Create a Stack of Doubles
		// Don't forget to import the Stack class
		// Stack<Double> sd = new Stack<Double>();
		Stack<Double> sd = new Stack<Double>();

		// 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		getRandDoubles(sd, 100);

		// 3. Ask the user to enter in two numbers between 0 and 100, inclusive.
		double dLow = Double.parseDouble( JOptionPane.showInputDialog("lower number between 0 and 100: ") );
		double dHigh = Double.parseDouble( JOptionPane.showInputDialog("higher number between 0 and 100: ") );

		frame.add(panel);
		panel.add(numLow);
		panel.add(numHigh);
		panel.add(button);
		panel.add(textArea);

		frame.setTitle("Stack of Doubles");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button.setText("Pop Stack");
		button.addActionListener(this);
		frame.pack();

		// 4. Pop all the elements off of the Stack. Every time a double is popped that
		// is
		// between the two numbers entered by the user, print it to the screen.
		popStackDoubles( sd, dLow, dHigh );

		// EXAMPLE:
		// NUM 1: 65
		// NUM 2: 75

		// Popping elements off stack...
		// Elements between 65 and 75:
		// 66.66876846
		// 74.51651681
		// 70.05110654
		// 69.21350456
		// 71.54506465
		// 66.47984807
		// 74.12121224
	}

	void getRandDoubles(Stack<Double> alDoubles, int numDoubles) {
		Random r = new Random();
		for (int i = 0; i < numDoubles; ++i) {
			alDoubles.push(r.nextDouble() * 100);
		}
	}

	void popStackDoubles(Stack<Double> alDoubles, double dLow, double dHigh) {
		String numbersStr = "";
		int number = 1;

		for (int i = 0; i < alDoubles.size(); ++i) {
			double poppedDouble = alDoubles.pop();
			if ((poppedDouble > dLow) && (poppedDouble < dHigh)) {
				// System.out.println(poppedDouble);
				if (!numbersStr.isEmpty()) {
					numbersStr += "\n";
				}
				numbersStr += number++ + ". " + poppedDouble;
			}
		}
		numbersStr.trim();

		if (numbersStr.isEmpty()) {
			numbersStr = "No Matching Doubles!";
		}

		textArea.setText(numbersStr);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (button == (JButton) e.getSource()) {
			double dLow = Double.parseDouble(numLow.getText());
			double dHigh = Double.parseDouble(numHigh.getText());

			if (dHigh < dLow || dLow > dHigh) {
				textArea.setText("ERROR: Invalid inputs!");
			} else {
				popStackDoubles(sd, dLow, dHigh);
				sd.clear();
				getRandDoubles(sd, 100);
			}
		}
	}
}
