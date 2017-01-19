package com.ianskenny.ttt;

public class TicTacToeView extends AbstractView
{
	/**
	 * The width of a board cell in pixels.
	 */
	public static final int cellWidth = 64;

	/**
	 * The height of a board cell in pixels.
	 */
	public static final int cellHeight = 64;

	/**
	 * The diameter of a player token in pixels.
	 */
	public static final int tokenDiameter = 50;

	/**
	 * The frame that contains the GUI elements.
	 */
	private TicTacToeFrame frame;

	/**
	 * The current player.
	 */
	private GamePiece player;

	/**
	 * The last player to cede control of the game.
	 */
	private GamePiece lastPlayerToCede;

	/**
	 * Constructor.
	 * @param controller The controller.
	 */
	public TicTacToeView(Controller controller)
	{
		super(controller);

		frame = new TicTacToeFrame(this, controller.getNumRows(), controller.getNumColumns());

		player = new GamePiece("BLACK");

		play();
	}

	/**
	 * Starts the game (from the GUI's perspective).
	 */
	private void startGame()
	{
		reset();

		player.setValue("BLACK");
	}

	/**
	 * Resets the game (from the GUI's perspective).
	 */
	private void reset()
	{
		lastPlayerToCede = null;

		frame.clearPlayerMessage();

		frame.clearStatusMessage();
	}

	/**
	 * Plays the game (from the GUI's perspective).
	 */
	public void play()
	{
		startGame();
	}

	/**
	 * Attempts to play at the chosen location. If the location is illegal a message to that effect is displayed.
	 * If the play is legal then a game over condition is checked for. If it is not game over the play switches
	 * to the next player.
	 * @param row The row number.
	 * @param col The column number.
	 */
	public void nextPlay(int row, int col)
	{
		if (!controller.attemptPlay(row, col, player))
		{
			frame.setStatusMessage("Try again.");
		}

		else if (controller.boardIsFull())
		{
			gameOver();
		}

		else
		{
			frame.clearStatusMessage();
			nextPlayer();
		}
	}

	/**
	 * Starts a new game.
	 */
	public void newGame()
	{
		controller.newGame();
		startGame();
		frame.repaint();
	}

	/**
	 * Switches control to the next player  (from the GUI's perspective).
	 */
	private void nextPlayer()
	{
		frame.clearStatusMessage();
		player.setValue(controller.getOpponent(player.getValue()));
		frame.setPlayerMessage(player.getValue() + " to play.");
		frame.repaint();
	}

	/**
	 * Cedes play to the opponent.
	 */
	public void cede()
	{
		if (lastPlayerToCede == null)
		{
			lastPlayerToCede = player;
			nextPlayer();
		}

		else gameOver();
	}

	/**
	 * Sets the 'game over' output.
	 */
	private void gameOver()
	{
		frame.clearPlayerMessage();
		if (controller.getWinner() == null)
			frame.setStatusMessage("The game was a draw.");
		else frame.setStatusMessage(controller.getWinner().toString() + " won.");
		frame.repaint();
	}
}
