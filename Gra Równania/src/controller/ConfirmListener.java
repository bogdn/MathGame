package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameModel;
import view.GameView;

public class ConfirmListener implements ActionListener{
	
	private GameView view;
	private GameModel model;
	
	public ConfirmListener(GameView view, GameModel model) {
		this.view = view;
		this.model = model;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(view.getResultFromUser().equals(model.wynik())) {
			model.setScore(1);
			view.setPrompt("Dobrze !!!");
			model.setIsGood(true);
			
			
		}
		else {
			view.setPrompt("Źleee...");
			//model.subScore();
		}
		
	}
	
}
