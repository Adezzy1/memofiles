package com.ianskenny.ttt;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TicTacToePanel extends JPanel
{
	/**
	 * The BasicGUIView.
	 */
	private final TicTacToeView view;

	/**
	 * The number of rows on the grid. This information comes from the model.
	 */
	private int rows;

	/**
	 * The number of cols on the grid. This information comes from the model.
	 */
	private int cols;

	/**
	 * Constructor.
	 * @param view_ The BasicGUIView view.
	 */
	public TicTacToePanel(TicTacToeView view_, int rows, int cols)
	{
		this.view = view_;

		this.rows = rows;
		this.cols = cols;

		addMouseListener(new MouseAdapter()
		{
		    public void mouseClicked(MouseEvent e)
		    {
		    	view.nextPlay(e.getY()/TicTacToeView.cellWidth, e.getX()/TicTacToeView.cellHeight);
		    }
		});

		setBackground(Color.GREEN);

		setPreferredSize(new Dimension(TicTacToeView.cellWidth * cols +1,TicTacToeView.cellHeight * rows +1));
	}

	/**
	 * Paints the game into the panel.
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		// paint the grid
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(2));

		for (int i = 0; i < rows +1; i++)
		{
			g2d.drawLine(0, i*TicTacToeView.cellHeight, TicTacToeView.cellWidth * cols, i*TicTacToeView.cellHeight);

			for (int j = 0; j < cols+1; j++)
			{
				g2d.drawLine(j*TicTacToeView.cellWidth, 0, j* TicTacToeView.cellWidth, TicTacToeView.cellHeight * rows);
			}
		}

		int wShift = (TicTacToeView.cellWidth - TicTacToeView.tokenDiameter)/2;
		int hShift = (TicTacToeView.cellHeight - TicTacToeView.tokenDiameter)/2;


		// paint the tokens
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				GamePiece tok = view.getGamePiece(i, j);

				if (tok != null && tok.getValue().equals("WHITE"))
				{
					g2d.setColor(Color.WHITE);

					g2d.fillOval((j*TicTacToeView.cellWidth) + wShift, (i*TicTacToeView.cellHeight) +hShift, TicTacToeView.tokenDiameter, TicTacToeView.tokenDiameter);
				}

				else if (tok != null && tok.getValue().equals("BLACK"))
				{
					g2d.setColor(Color.BLACK);

					g2d.fillOval((j*TicTacToeView.cellWidth) + wShift, (i*TicTacToeView.cellHeight) + hShift, TicTacToeView.tokenDiameter, TicTacToeView.tokenDiameter);
				}
			}
		}
	}
}
