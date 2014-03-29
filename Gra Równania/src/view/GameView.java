package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * @author Bogdan Kostka
 * 
 * 
 *
 */

public class GameView extends JFrame{
	
	private JButton newGameButton;
	private JPanel container;
	private JButton exitButton;
	private JPanel leftButtons;
	private JPanel buttonsPanelBackground;
	private JMenuBar menuBar;
	private JMenu action;
	private JMenuItem newGameItem;
	private JMenuItem exitItem;
	private JPanel gamePanel;
	private JLabel orderLabel;
	private JLabel equationLabel;
	private JTextField equalsArea;
	private JPanel equalsPanel;
	private JLabel equalsLabel;
	private JPanel confirmAndEndButtonsPanel;
	private JButton confirmButton;
	private JButton endButton;
	private JLabel timeLabel;
	private JLabel clockLabel;
	private JLabel promptLabel;
	
	private JButton nextButton;
	private JMenu help;
	private JMenuItem rules;
	private JMenuItem aboutGame;
	public GameView() {
		
		
		
		setVisible(true);
		setResizable(false);
		setName("Gra matematyczna");
		setSize(600, 400);
		setPreferredSize(new Dimension(650,500));
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//main container
		container = new JPanel();
		add(container);
		container.setBackground(Color.pink);
		container.setLayout(new BorderLayout());
		
		// left background
		buttonsPanelBackground = new JPanel();
		buttonsPanelBackground.setBackground(Color.gray);
		container.add(buttonsPanelBackground, BorderLayout.LINE_START);
		
		// buttons on the left
		leftButtons = new JPanel();
		leftButtons.setLayout(new BoxLayout(leftButtons , BoxLayout.PAGE_AXIS));
		leftButtons.setBackground(Color.gray);
		buttonsPanelBackground.add(leftButtons);
		
		leftButtons.add(Box.createRigidArea(new Dimension(0, 30)));
		newGameButton = new JButton("Nowa Gra");
		newGameButton.setAlignmentX(CENTER_ALIGNMENT);
		leftButtons.add(newGameButton);
		
		leftButtons.add(Box.createRigidArea(new Dimension(0, 20)));
		
		exitButton = new JButton("Wyjście");
		exitButton.setAlignmentX(CENTER_ALIGNMENT);
		leftButtons.add(exitButton);
		
		leftButtons.add(Box.createRigidArea(new Dimension(0, 100)));
		
		timeLabel = new JLabel("Czas do zakończenia: ");
		timeLabel.setAlignmentX(CENTER_ALIGNMENT);
		timeLabel.setOpaque(true);
		timeLabel.setBackground(Color.yellow);
		timeLabel.setFont(new Font("Arial", Font.BOLD, 16));
		leftButtons.add(timeLabel);
		leftButtons.add(Box.createRigidArea(new Dimension(0, 10)));
		
		clockLabel = new JLabel("");
		clockLabel.setAlignmentX(CENTER_ALIGNMENT);
		clockLabel.setFont(new Font("Arial", Font.BOLD, 18));
		clockLabel.setForeground(Color.yellow);
		clockLabel.setBackground(Color.red);
		clockLabel.setOpaque(true);
		leftButtons.add(clockLabel);
		
		
		
		// menu bar
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// menu names
		action = new JMenu("Menu");
		menuBar.add(action);
		help = new JMenu("Pomoc");
		menuBar.add(help);
		
		//Menu Items
			//1. Menu
		newGameItem = new JMenuItem("Nowa Gra");
		action.add(newGameItem);
		action.addSeparator();
		exitItem = new JMenuItem("Wyjście");
		action.add(exitItem);
			//2. Help
		rules = new JMenuItem("Zasady gry");
		help.add(rules);
		help.addSeparator();
		aboutGame = new JMenuItem("O Programie");
		help.add(aboutGame);
		
		// main game panel
		gamePanel = new JPanel();
		gamePanel.setLayout(new BoxLayout(gamePanel , BoxLayout.PAGE_AXIS));
		gamePanel.setBackground(Color.lightGray);
		container.add(gamePanel, BorderLayout.CENTER);
		
		
		
		gamePanel.add(Box.createRigidArea(new Dimension(0, 20)));
		orderLabel = new JLabel("Przeczytaj Pomoc -> Zasady gry");
		orderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		orderLabel.setBackground(Color.yellow);
		orderLabel.setOpaque(true);
		orderLabel.setFont(new Font("Arial", Font.BOLD, 20));
		gamePanel.add(orderLabel);
		
		gamePanel.add(Box.createRigidArea(new Dimension(0, 80)));
		
		equationLabel = new JLabel("Kliknij \"Nowa Gra\"");
		equationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		equationLabel.setFont(new Font("Arial",Font.BOLD,30));
		//equationLabel.setSize(100, 20);
		equationLabel.setOpaque(true);
		equationLabel.setBackground(Color.orange);
		gamePanel.add(equationLabel);
		
		gamePanel.add(Box.createRigidArea(new Dimension(0, 50)));
		
		equalsPanel = new JPanel(new FlowLayout());
		equalsPanel.setBackground(Color.LIGHT_GRAY);
		gamePanel.add(equalsPanel);
		
		equalsLabel = new JLabel("Wynik:   ");
		equalsPanel.add(equalsLabel);
		
		equalsArea = new JTextField(6);
		equalsArea.setFont(new Font("Serif", Font.BOLD, 20));
		equalsPanel.add(equalsArea);
		
		promptLabel = new JLabel("");
		promptLabel.setFont(new Font("Serif", Font.PLAIN,18));
		promptLabel.setAlignmentX(CENTER_ALIGNMENT);
		promptLabel.setForeground(Color.red);
		gamePanel.add(promptLabel);
		
		gamePanel.add(Box.createRigidArea(new Dimension(0, 20)));
		confirmButton = new JButton("Sprawdź");
		gamePanel.add(confirmButton);
		gamePanel.add(Box.createRigidArea(new Dimension(0, 20)));
		
		confirmAndEndButtonsPanel = new JPanel(new FlowLayout());
		confirmAndEndButtonsPanel.setBackground(Color.LIGHT_GRAY);
		gamePanel.add(confirmAndEndButtonsPanel);
		nextButton = new JButton("Dalej");
		confirmAndEndButtonsPanel.add(nextButton);
		endButton = new JButton("Zakończ grę");
		confirmAndEndButtonsPanel.add(endButton);
		
		
		
		disableAllGameButtons();
		
		
		pack();
		
	}
	
	public void setPrompt(String prompt) {
		promptLabel.setText(prompt);
	}
	
	public void clearGame() {
		promptLabel.setText("");
		orderLabel.setText("");
		equationLabel.setText("Koniec gry !");
		
	}
	
	public void clearResultArea() {
		equalsArea.setText("");
	}
	
	public String getResultFromUser() {
		return equalsArea.getText();
	}
	
	public void setEquation(String equation) {
		equationLabel.setText(equation);
	}
	
	public void addNewGameListener(ActionListener al) {
		
		newGameButton.addActionListener(al);
	}
	
	public void addExitListener(ActionListener al) {
		exitButton.addActionListener(al);
	}
	public void addConfirmListener(ActionListener al) {
		confirmButton.addActionListener(al);
	}
	public void addEndGameListener(ActionListener al) {
		endButton.addActionListener(al);
	}
	
	public void addNextButtonListener(ActionListener al) {
		nextButton.addActionListener(al);
	}
	
	public void showGameScore(double gameScore) {
		JOptionPane.showMessageDialog(gamePanel, "Twój wynik to: "+gameScore, "Koniec Gry!!!", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public void disableAllGameButtons() {
		nextButton.setEnabled(false);
		confirmButton.setEnabled(false);
		endButton.setEnabled(false);
		
	}
	
	public void enableAllGameButtons() {
		nextButton.setEnabled(true);
		confirmButton.setEnabled(true);
		endButton.setEnabled(true);
		orderLabel.setText("Rozwiąż poniższe równanie: ");
		
	}
	
	public void disorenableNewgameClick(boolean b) {
		newGameButton.setEnabled(b);
		newGameItem.setEnabled(b);
	}
	
	public void setClockLabel(String text) {
		clockLabel.setText(text);
	}
	
	public void showRules() {
		
		String message = "Gra polega na rozwiązywaniu kolejnych równań, wylosowanych z bazy \n znajdującej "
				+ "się na komputerze. Po wylosowaniu równania wpisujemy wynik, klikamy\n SPRAWDZ, a następnie jeśli wynik "
				+ "jest poprawny klikamy dalej (dostajemy jeden punkt)\n lub gdy wynik jest niepoprawny, możemy spróbować jeszcze raz lub przejść"
				+ "\ndo kolejnego równania, ale wówczas tracimy pół punkta z puli zdobytych punktów. \n\nGra kończy się po upłynięciu 300 sekund"
				+ " (5 minut) lub po kliknięciu przycisku ZAKOŃCZ GRĘ";
		
		JOptionPane.showMessageDialog(this, message, "Zasady Gry", JOptionPane.INFORMATION_MESSAGE);
		
	}
	public void aboutGame() {
		String message = "Autor: Bogdan Kostka\n\n Wersja: 0.3\n\n";
		JOptionPane.showMessageDialog(this, message, "O Programie", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	// menu listeners
	
	public void addMenuNewGameListener(ActionListener al) {
		newGameItem.addActionListener(al);
		
	}
	
	public void addMenuExitListener(ActionListener al) {
		exitItem.addActionListener(al);
	}
	
	public void addMenuRulesListener(ActionListener al) {
		rules.addActionListener(al);
	}
	
	public void addMenuAboutGameListener(ActionListener al) {
		aboutGame.addActionListener(al);
	}
}

