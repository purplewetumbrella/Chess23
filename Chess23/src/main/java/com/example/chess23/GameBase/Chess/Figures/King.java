package com.example.chess23.GameBase.Chess.Figures;

import com.example.chess23.GameBase.Base.Coordinate;
import com.example.chess23.GameBase.Chess.ChessBoard;
import com.example.chess23.GameBase.Chess.ChessFigure;


public class King extends ChessFigure {
    private final ChessBoard board;
    public King(boolean colorIsWhite, Coordinate coordinateFrom, ChessBoard board) {
        super(colorIsWhite, colorIsWhite ? '\u2655' : '\u265b', coordinateFrom);
        this.board = board;
    }

    @Override
    public boolean canMove( Coordinate to) {int deltaX = Math.abs(to.getX() - from.getX());
        int deltaY = Math.abs(to.getY() - from.getY());
        if ((deltaX == 1 && deltaY == 0) || (deltaX == 0 && deltaY == 1) || (deltaX == 1 && deltaY == 1)) {

            if (board.getField()[to.getX()][to.getY()] == null) {
                return true;
            } else {
                return colorIsWhite != ((ChessFigure) board.getField()[to.getX()][to.getY()]).isColorIsWhite();
            }
        } else {
            return false;
        }
    }
}
