import javax.swing.SwingUtilities;

import controller.MainController;
import view.GameView;
import model.GameModel;

/**
 * 
 * @author Bogdan Kostka
 * @author Student AGH
 *
 */
public class GameMain {
	
	public static void main(String [] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				GameView view;
				GameModel model = new GameModel();
				view = new GameView();
				MainController controller = new MainController(view, model);
				
			}
		});
		
	}

}
