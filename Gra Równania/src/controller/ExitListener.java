package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GameView;

public class ExitListener implements ActionListener {
	
	private GameView view;
	
	public ExitListener(GameView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		view.dispose();
		
	}
	
}
