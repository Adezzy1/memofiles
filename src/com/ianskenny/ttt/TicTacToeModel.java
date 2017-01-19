package com.ianskenny.ttt;
/**
 * The Tic Tac Toe class.
 * @author ianskenny.
 * @since 14/15.
 */

public class TicTacToeModel extends AbstractModel
{
	/**
	 * DefaultConstructor. Initialises the game grid.
	 */
	public TicTacToeModel(int rows, int cols)
	{
		super(rows, cols);
	}

	/**
	 * Clears the grid and sets the initial configuration.
	 */
	protected void setInitialState()
	{
		grid.clear();
	}

	/**
	 * Gets the token at the position given.
	 * @param row the row number.
	 * @param col the column number.
	 * @return the GamePiece at the position given.
	 */
	public GamePiece getGamePiece(int row, int col)
	{
		return grid.getGamePiece(row, col);
	}

	/**
	 * Attempts to play the GamePiece at the location specified. If the move is
	 * legal then the play will be made. If the move is not legal it won't be made.
	 * Thus if the move isn't legal the board will be left in the same state
	 * it was in prior to the method call.
	 *
	 * @param row the row number.
	 * @param col the column number.
	 * @param token the GamePiece to attempt to play.
	 * @return true if the play was legal, false otherwise.
	 */
	public boolean attemptPlay(int row, int col, GamePiece token)
	{		
		grid.setGamePieceValue(row, col, token.getValue());
		return true;
	}

	/**
	 * Checks if the board is full.
	 * @return true if the board is full, false otherwise (i.e. one or more EMPTY locations).
	 */
	public boolean gridIsFull()
	{
		return grid.gridIsFull();
	}

	/**
	 * Checks if the board contains only one colour of GamePiece.
	 * @return true if the board has only one colour of GamePiece, false otherwise.
	 */
	public boolean gridHasSingleValue()
	{
		return grid.gridHasSingleValue();
	}

	/**
	 * Gets the opponent of the token.
	 * @param player the token to find the opponent of.
	 * @return the opponent of the token passed in.
	 */
	public String getOpponent(String player)
	{
		if (player.equals("BLACK"))
			return "WHITE";

		if (player.equals("WHITE"))
			return "BLACK";

		else return "EMPTY";
	}

	/**
	 * Gets the winning GamePiece.
	 * @return the winning GamePiece. EMPTY if a draw.
	 */
	public String getWinner()
	{
		return "NONE"; // draw
	}

}



