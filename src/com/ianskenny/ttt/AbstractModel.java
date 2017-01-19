package com.ianskenny.ttt;
/**
 *
 * @author ianskenny
 * @since 14/15
 */

public abstract class AbstractModel
{
	/**
	 * The Map of cells representing the board.
	 */
	protected Map grid;

	/**
	 * The number of rows on the grid.
	 */
	protected int rows;

	/**
	 * The number of columns on the grid.
	 */
	protected int cols;

	/**
	 * Constructor.
	 * @param rows number of rows on the grid.
	 * @param cols number of columns on the grid.
	 */
	public AbstractModel(int rows, int cols)
	{
		this.rows = rows;
		this.cols = cols;

		grid = new Map(rows, cols);

		setInitialState();
	}

	/**
	 * Get the number of rows on the grid.
	 * @return the number of rows on the grid.
	 */
	public int getNumRows()
	{
		return rows;
	}

	/**
	 * Get the number of cols on the grid.
	 * @return the number of cols on the grid.
	 */
	public int getNumColumns()
	{
		return cols;
	}

	/**
	 * Resets the model for a new game.
	 */
	public void newGame()
	{
		grid.clear();
		setInitialState();
	}

	/**
	 * Clears the board of all non-EMPTY tokens and sets the initial configuration.
	 */
	protected abstract void setInitialState();

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
}
