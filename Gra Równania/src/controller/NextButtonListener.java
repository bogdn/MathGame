package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameModel;
import view.GameView;

public class NextButtonListener implements ActionListener {
	private GameView view;
	private GameModel model;
	
	public NextButtonListener(GameView view, GameModel model) {
		this.view = view;
		this.model = model;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(model.isScoreGood() == false)
			model.setScore(-0.5);
		view.clearResultArea();
		view.setPrompt("");
		view.setEquation(model.go());
		
	}
	
}
