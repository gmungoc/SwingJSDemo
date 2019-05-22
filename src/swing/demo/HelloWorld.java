package swing.demo;
import java.awt.Color;
import java.awt.Container;
/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/*
 * downloaded 23 April 2019 from
 * https://docs.oracle.com/javase/tutorial/uiswing/examples/start/HelloWorldSwingProject/src/start/HelloWorldSwing.java
 * and modified
 */
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;        

public class HelloWorld 
{
	private Random rand = new Random();

	public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new HelloWorld().createAndShowGUI();
            }
        });
    }
	
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private void createAndShowGUI() 
    {
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.setPreferredSize(new Dimension(300, 250));

        contentPane.add(new JLabel("Hello World"));
		contentPane.add(makeClickMeButton());
		JLabel choice = new JLabel("Make a selection");
		JComboBox<String> choices = makeChoiceList(choice);
		contentPane.add(choices);
		contentPane.add(choice);
		contentPane.add(makeQuitButton(frame));
		
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Makes a combo box that writes the selected value to the given label
     * 
     * @param choice
     * @return
     */
    private JComboBox<String> makeChoiceList(JLabel choice) 
    {
    	JComboBox<String> combo = new JComboBox<>();
    	combo.addItem("Cream");
    	combo.addItem("Custard");
    	combo.addItem("Yoghurt");
    	combo.addActionListener(new ActionListener() 
    	{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				choice.setText("You chose " + combo.getSelectedItem());
				choice.repaint();
			}
    		
    	});
    	return combo;
	}

	/**
     * Makes a button that Quits the application when clicked
     * 
     * @param frame
     * @return
     */
	JButton makeQuitButton(JFrame frame) 
	{
		JButton quit = new JButton("Quit");
		quit.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
			}
		});
		return quit;
	}

	/**
	 * Makes a button that changes colour when clicked
	 * 
	 * @return
	 */
	JButton makeClickMeButton() 
	{
		JButton hello = new JButton("Click me!");
		hello.setOpaque(true);
		hello.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				hello.setForeground(makeColour());
				hello.setBackground(makeColour());
				hello.repaint();
			}
		});
		return hello;
	}

    /**
     * Makes a pseudo-random colour
     * 
     * @return
     */
    protected  Color makeColour() 
    {
    	return new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}
}