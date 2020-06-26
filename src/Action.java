import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Action extends JPanel implements ActionListener {
	
	public Timer timer;
	public int delay = 20;
	DoublePendulum double_pendulum;
	
	
	public Action()
	{
		double_pendulum = new DoublePendulum(Math.PI / 2, Math.PI / 2);
		timer = new Timer(delay,this);
		timer.start();
	}
	
	public void paint(Graphics g)
	{
		
		g.setColor(Color.lightGray);
		g.fillRect(1, 1, 910, 610);
		
		double_pendulum.draw((Graphics2D) g);
		
		double_pendulum.first_position();
		double_pendulum.second_position();
		
		double_pendulum.acceleration1();
		double_pendulum.acceleration2();

		double_pendulum.v1 += double_pendulum.a1;
		double_pendulum.v2 += double_pendulum.a2;

		double_pendulum.theta1 += double_pendulum.v1;
		double_pendulum.theta2 += double_pendulum.v2;
		
		g.dispose();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		repaint();
	}
}
