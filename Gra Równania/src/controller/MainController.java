package controller;

		import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.GameModel;
import view.GameView;

		/**
		 * 
		 * @author Student AGH
		 *
		 */
		public class MainController {
			
			private GameView view;
			private GameModel model;
			private Timer timer, timer2;
			
			public MainController(GameView view, GameModel model) {
				
				this.view = view;
				this.model = model;
				
				//Add listeners to buttons
				view.addConfirmListener(new ConfirmListener(view, model));
				view.addNewGameListener(new NewGameListener());
				view.addExitListener(new ExitListener(view));
				view.addNextButtonListener(new NextButtonListener(view, model));
				view.addMenuNewGameListener(new NewGameListener());
				view.addMenuExitListener(new ExitListener(view));
				view.addMenuRulesListener(new RulesListener(view));
				view.addMenuAboutGameListener(new AboutGameListener(view));
				view.addEndGameListener(new EndGameListener());
			
			}

			
			
			class NewGameListener implements ActionListener {
				
				

				@Override
				public void actionPerformed(ActionEvent e) {
					view.setEquation(model.go());
					view.enableAllGameButtons();
					model.setIsGood(false);
					view.disorenableNewgameClick(false);
					
					
					ActionListener Task = new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							int time = model.getGameTime();
							model.timeDown();
							
							view.setClockLabel(time+" sekund");
						}
					};
					
					timer = new Timer(300000, new EndGameListener());
					timer.start();
					timer.setRepeats(false);
					
					
					timer2 = new Timer(1000, Task);
					timer2.start();
					
				}
				
			}

			class EndGameListener implements ActionListener {

				@Override
				public void actionPerformed(ActionEvent e) {
					model.resetGameTime();
					timer2.stop();
					timer.stop();
					view.setClockLabel("STOP !!!");
					view.showGameScore(model.getScore());
					view.disableAllGameButtons();
					view.clearGame();
					model.setIsGood(false);
					view.disorenableNewgameClick(true);
					model.resetScore();
					view.clearResultArea();
					
				}
				
			}
			
			
			
		}
