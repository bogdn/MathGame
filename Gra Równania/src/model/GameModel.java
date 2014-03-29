package model;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import view.GameView;
/**
 * 
 * @author Bogdan Kostka
 *  Student AGH
 *
 */

public class GameModel {

	private ArrayList<String> fileInArray;
	private ArrayList<Integer> checkInt = new ArrayList<Integer>();
	private double gameScore;
	private int numberLine;
	private int gameTime = 299;
	private boolean scoreIsGood = false;
	
	public GameModel() {
	
		File file = new File("src/resources/base.dat");
		try {
			fileInArray = saveFileToArrayList(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

	public ArrayList<String> saveFileToArrayList(File file)
			throws IOException {

		fileInArray = new ArrayList<String>();

		BufferedReader inputStream = null;

		try {
			inputStream = new BufferedReader(new FileReader(file));

			String l;
			while ((l = inputStream.readLine()) != null) {
				fileInArray.add(l);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}

		}
		return fileInArray;

	}

	public int randomLineFromArrayList(ArrayList<String> list) {

		Random r = new Random(System.currentTimeMillis());

		int numberLine = 0;

		do {
			if (list.size() == checkInt.size())
				checkInt.clear();
			numberLine = r.nextInt(list.size());
		} while (checkInt.contains(numberLine) == true);

		checkInt.add(numberLine);

		return numberLine;

	}

	public String getOperation(int randomLine) {

		String line = fileInArray.get(randomLine);
		String operation = null;
		int equalsPos = line.indexOf("=");
		operation = line.substring(0, equalsPos);

		return operation+"=";

	}

	public String getResult(int randomLine) {

		String line = fileInArray.get(randomLine);
		String result = null;
		int equalsPos = line.indexOf("=");
		result = line.substring(equalsPos + 1);

		return result;

	}
	
	public String go() {
		
		
		numberLine = randomLineFromArrayList(fileInArray);
		String go = getOperation(numberLine);
		return go;
		
	}
	
	public String wynik() {
		return getResult(numberLine);
	}
	
	public int getActualLine() {
		return numberLine;
		
	}
	
	public void clear() {
		gameScore = 0;
		checkInt.clear();
	}
	
	public void setScore(double score) {
		gameScore+=score;
	}

	public void subScore() {
		gameScore -= 0.5;
	}
	
	public double getScore() {
		return gameScore;
		
	}
	
	public void startTimer(GameView view, int delay, ActionListener al) {
		
		  new Timer(delay, al).start();
		
	}
	
	public int getGameTime() {
		return gameTime;
	}
	public void timeDown() {
		gameTime--;
	}
	public void resetGameTime() {
		gameTime = 299;
	}
	
	public void resetScore() {
		gameScore=0;
	}
	
	public boolean isScoreGood() {
		if (scoreIsGood == true)
			return true;
		else 
			return false;
	}

	public void setIsGood(boolean b) {
		scoreIsGood = b;
		
	}
}
