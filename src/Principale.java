import javax.swing.JFrame;

public class Principale {

	public static void main(String[] args) {
		JFrame object = new JFrame(); //instance JFrame
		
		Action action = new Action();
		
		object.setBounds(10, 10, 900, 600); //Dimension de la fenetre
		object.setTitle("Double Pendulum"); //Titre de la fenetre
		
		object.setResizable(false); //Non redimensionable
		
		object.setVisible(true); //Creation d'une fenêtre
		
		object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		object.add(action);
	}
}
