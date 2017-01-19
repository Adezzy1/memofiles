package com.ianskenny.ttt;
/**
 * This class represents a single cell on the grid. It has a location and a token value.
 * @author ianskenny
 * @since 14/15
 */
public class MapCell
{
	/**
	 * The GamePiece at this cell.
	 */
	private GamePiece token;

	/**
	 * The CellLocation of this cell.
	 */
	private MapLocation location;

	/**
	 * Constructor.
	 * @param row the row number.
	 * @param col the column number.
	 * @param token the GamePiece value.
	 */
	public MapCell(int row, int col, GamePiece token)
	{
		this.token = token;
		location = new MapLocation(row, col);
	}

	/**
	 * Sets the token value.
	 * @param token the GamePiece value.
	 */
	public void setGamePiece(GamePiece token)
	{
		this.token = token;
	}

	/**
	 * Set the value of the token in this cell.
	 * @param val the value of the token.
	 */
	public void setValue(String val)
	{
		this.token.setValue(val);
	}

	/**
	 * Gets the token value.
	 * @return the GamePiece at this cell.
	 */
	public GamePiece getGamePiece()
	{
		return token;
	}

	/**
	 * Get the MapLocation for this cell.
	 * @return the MapLocation for this cell.
	 */
	public MapLocation getLocation()
	{
		return location;
	}
}
