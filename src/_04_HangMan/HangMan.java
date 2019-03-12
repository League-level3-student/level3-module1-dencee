// https://www.pixilart.com

package _04_HangMan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HangMan implements ActionListener{
    static final int width = 800;
    static final int height = 800;
    JFrame frame;
    JPanel panel;
    JLabel hangmanImage;
    JTextField field;
    JButton guess;
    GridBagConstraints c;
    
    public static void main(String[] args) throws Exception {
        new HangMan();
    }
    
    public HangMan() throws MalformedURLException {
        frame = new JFrame( "Hangman" );

    }
    
    private void drawMenu() {
        

    }
    
    private void drawGame() {
        panel = new JPanel();
        
        hangmanImage = createLabelImage( "pixil-frame-0.png" );
        field = new JTextField( 20 );
        guess = new JButton( "Guess" );
        c = new GridBagConstraints();
        frame.setVisible( true );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setPreferredSize( new Dimension( HangMan.width, HangMan.height ) );
        panel.setLayout( new GridBagLayout() );
        panel.setBackground( new Color(255, 125, 25) );
        
        frame.add( panel );
        
        c.gridx = 0;
        c.gridy = 0;
        panel.add( hangmanImage, c );
        
        c.gridx = 0;
        c.gridy = 1;
        panel.add( field, c );
        
        c.gridx = 0;
        c.gridy = 2;
        panel.add( guess, c );
        
        guess.addActionListener( this );
        
        frame.pack();
    }

    private JLabel createLabelImage(String fileName) throws MalformedURLException {
        URL imageURL = getClass().getResource(fileName);
        if (imageURL == null) {
            System.err.println("Could not find image " + fileName);
            return new JLabel();
        }
        Icon icon = new ImageIcon(imageURL);
        JLabel imageLabel = new JLabel(icon);
        return imageLabel;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    
}
