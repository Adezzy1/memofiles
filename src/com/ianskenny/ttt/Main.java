package com.ianskenny.ttt;
public class Main
{
	private static final int ROWS = 3;
	private static final int COLS = 3;

	public static void main(String[] args)
	{
		// create the model
		TicTacToeModel model = new TicTacToeModel(ROWS, COLS);

		// create the controller
		Controller controller = new Controller(model);

		// create the view
		AbstractView view_= new TicTacToeView(controller);

		// play the game
		view_.play();
	}
}
