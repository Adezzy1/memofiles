package com.ianskenny.ttt;
/**
 * This class represents the game grid (board).
 * @author ianskenny
 * @since 14/15
 */

public class Map
{
	/**
	 * The number of rows in the grid.
	 */
	private int rows;

	/**
	 * The number of columns in the grid.
	 */
	private int cols;

	/**
	 * The Map as a 2d array of MapCell objects.
	 */
	private MapCell[][] cells;


	/**
	 * Constructor
	 * @param nrows the number of rows on this grid.
	 * @param ncols the number of columns on this grid.
	 */
  	public Map(int nrows, int ncols)
	{
  		rows = nrows;
  		cols = ncols;
  		cells = new MapCell[rows][cols];
  		clear();
	}

  	/**
  	 * Gets the number of rows on this grid.
  	 * @return the number of rows on this grid.
  	 */
  	public int getNumRows()
  	{
  		return rows;
  	}

  	/**
  	 * Gets the number of columns on this grid.
  	 * @return the number of columns on this grid.
  	 */
  	public int getNumColumns()
  	{
  		return cols;
  	}


	/**
	 * Clears the grid and sets all tokens to EMPTY
	 */
	public void clear()
	{
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				cells[i][j] = new MapCell(i, j, new GamePiece("EMPTY"));
			}
		}
	}

	/**
	 * Sets the given cell to the GamePiece value.
	 * @param row the row number.
	 * @param col the column number.
	 * @param value the GamePiece value.
	 */
	public boolean setGamePieceValue(int row, int col, String value)
	{
		 if (isOnMap(row, col))
		 {
			 cells[row][col].setValue(value);
			 return true;
		 }

		 return false;
	}

	/**
	 * Gets the GamePiece at the given cell.
	 * @param row the row number.
	 * @param col the column number.
	 * @return the GamePiece at the given cell.
	 */
	public GamePiece getGamePiece(int row, int col)
	{
		 if (isOnMap(row, col))
		 {
			 return cells[row][col].getGamePiece();
		 }

		 return null;
	}

	/**
	 * Tests if the cell represented by (row, col) is on the Map.
	 * @param row the row number.
	 * @param col the column number.
	 * @return true if the cell is on the grid, false otherwise.
	 */
	public boolean isOnMap(int row, int col)
	{
		 if (row >= 0 && row < rows && col >= 0 && col < cols)
		 {
			 return true;
		 }

		 else return false;
	}

	/**
	 * Checks if the Map is full.
	 * @return true if the Map is full, false otherwise (i.e. one or more EMPTY locations).
	 */
	public boolean gridIsFull()
	{
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				if (getGamePiece(i, j).getValue().equals("EMPTY"))
					return false;
			}
		}

		return true;
	}

	/**
	 * Checks if the Map contains only one colour.
	 * @return true if the Map contains a single colour, false otherwise.
	 */
	public boolean gridHasSingleValue()
	{
	    // find the first token
	    GamePiece checkGamePiece = null;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (!(getGamePiece(i, j).getValue().equals("EMPTY")))
                    checkGamePiece = getGamePiece(i, j);
            }
        }

		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				if (!getGamePiece(i, j).getValue().equals("EMPTY") && (!getGamePiece(i, j).getValue().equals(checkGamePiece.getValue())))
					return false;
			}
		}

		return true;
	}
}
