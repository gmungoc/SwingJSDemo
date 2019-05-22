package swing.demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelloWorld2 extends JPanel 
{
	int lastX;
	int theta;
	int fontSize = 14;
	
	void display() 
	{
        JFrame frame = new JFrame("HelloWorld");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setPreferredSize(new Dimension(300, 250));
        
		this.addMouseMotionListener(new MouseAdapter() 
		{
			@Override
			public void mouseDragged(MouseEvent e) 
			{
				doDrag(e);
			}
		});
		setBackground(Color.WHITE);
        contentPane.add(this);

        frame.pack();
        frame.setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) 
	{
		int w = this.getWidth();
		int h = this.getHeight();
		g.setColor(Color.WHITE);
		g.fillRect(0,  0,  w,  h);
		
		int x = w / 2;
		int y = h / 2;
		g.setFont(new Font("Arial", Font.BOLD, fontSize));
		g.setColor(Color.BLUE);
		Graphics2D g2 = (Graphics2D) g;
		
		double radians = Math.toRadians(theta*10);
		g.translate(x, y);
		g2.rotate(radians);
		g2.drawString("Hello world", 0, 0);
		g2.rotate(-radians);
		g.translate(-x,  -y);
	}

	/**
	 * Drag left-right to rotate text,
	 * shift-drag left-right to change font size
	 */
	void doDrag(MouseEvent e) 
	{
		int x = e.getX();
		boolean shift = e.isShiftDown();
		int delta = x - lastX;
		lastX = x;
		if (delta > 0) 
		{
			if (shift)
			{
				fontSize++;
			} else
			{
				theta++;
			}
		} else if (delta < 0)
		{
			if (shift)
			{
				fontSize--;
				fontSize = Math.max(fontSize,  3);
			} else
			{
				theta--;
			}
		}
		repaint();
	}
}
