import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class DoublePendulum {
	
	public double theta1, theta2, x1, x2, y1, y2, l1, l2, m1, m2, v1, v2, a1, a2, g;
	
	
	public DoublePendulum(double angle1, double angle2)
	{
		this.theta1 = angle1;
		this.theta2 = angle2;
		this.x1 = 0;
		this.x2 = 0;
		
		this.y1 = 0;
		this.y2 = 0;
		
		this.l1 = 200;
		this.l2 = 200;
		
		this.m1 = 40;
		this.m2 = 40;
		
		this.v1 = 0;
		this.v2 = 0;
		
		this.a1 = Math.PI / 2;
		this.a2 = Math.PI / 2;
		
		this.g = 1;
	}
	
	
	public void first_position()
	{
		this.x1 = this.l1 * Math.sin(this.theta1) + 450;
		this.y1 = this.l1 * Math.cos(this.theta1) + 150;
			
	}
	
	public void second_position()
	{
		this.x2 = this.l1 * Math.sin(this.theta1) + this.l2 * Math.sin(this.theta2) + 450;
		this.y2 = this.l1 * Math.cos(this.theta1) + this.l2 * Math.cos(this.theta2) + 150;
	}
	
	public void acceleration1()
	{
		double exp1 = -this.g * (2 * this.m1 + this.m2) * Math.sin(this.theta1);
		double exp2 = this.m2 * this.g * Math.sin(this.theta1 - 2 * this.theta2);
		double exp3 = 2 * Math.sin(this.theta1 - this.theta2) * this.m2 * (
                (this.v2 * this.v2) * this.l2 + (this.v1 * this.v1) * this.l1 * Math.cos(this.theta1 - this.theta2));
		
		double exp4 = this.l1 * (2 * this.m1 + this.m2 - this.m2 * Math.cos(2 * this.theta1 - 2 * this.theta2));
		
		this.a1 = (exp1 - exp2 - exp3) / (exp4);
	}
	
	public void acceleration2()
	{
		double exp1 = 2 * Math.sin(this.theta1 - this.theta2);
		double exp2 = (this.v1 * this.v1) * this.l1 * (this.m1 + this.m2);
		double exp3 = this.g * (this.m1 + this.m2) * Math.cos(this.theta1);
		double exp4 = (this.v2 * this.v2) * this.l2 * this.m2 * Math.cos(this.theta1 - this.theta2);
		double exp5 = this.l2 * (2 * this.m1 + this.m2 - this.m2 * Math.cos(2 * this.theta1 - 2 * this.theta2));

		this.a2 = (exp1 * (exp2 + exp3 + exp4)) / (exp5);
	}
	
	
	public void draw(Graphics2D g)
	{
		g.setStroke(new BasicStroke(2));
		
		g.setColor(Color.black);
		g.drawLine(450, 150, (int)this.x1, (int)this.y1);
		
		g.setColor(Color.black);
		g.fillOval((int)this.x1 - 20, (int)this.y1 - 20, (int)this.m1, (int)this.m1);
		
		g.setColor(Color.black);
		g.drawLine((int)this.x1, (int)this.y1, (int)this.x2, (int)this.y2);
		
	
		g.setColor(Color.black);
		g.fillOval((int)this.x2 - 20, (int)this.y2 - 20, (int)this.m2, (int)this.m2);
		
	
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
