package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<Character> delChars = new Stack<Character>();
	String startMessage = "You typed: ";
	String typedStr = startMessage;
	
	public static void main(String[] args) {
		new _02_TextUndoRedo().start();
	}

	void start() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		frame.getContentPane().add(panel);

		label.setText(typedStr);
		panel.add(label);

		frame.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char keyPressed = e.getKeyChar();

		if (keyPressed == KeyEvent.VK_BACK_SPACE) {
		    System.out.println( "backspace" );
	        
		    if( typedStr.length() > startMessage.length() ) {
		        delChars.push( typedStr.charAt( typedStr.length() - 1 ) );
		        typedStr = typedStr.substring( 0, typedStr.length() - 1 );
		    }
		    
		} else if (keyPressed == '\\' ) {
		    System.out.println( "alt" );
		    
		    if( !delChars.isEmpty() ) {
		        typedStr = typedStr + delChars.pop();
		    }
		} else {
		    System.out.println( keyPressed );
		    typedStr += keyPressed;
		}
		label.setText( typedStr );
		frame.pack();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
