package com.example.chess23.GameBase.Chess.Figures;

import com.example.chess23.GameBase.Base.Coordinate;
import com.example.chess23.GameBase.Chess.ChessBoard;
import com.example.chess23.GameBase.Chess.ChessFigure;

public class Rook extends ChessFigure {
    private final ChessBoard board;

    public Rook(boolean colorIsWhite, Coordinate coordinateFrom, ChessBoard board) {
        super(colorIsWhite, colorIsWhite ? '\u2655' : '\u265b', coordinateFrom);
        this.board = board;
    }

    @Override
    public boolean canMove(Coordinate to) {
        boolean isDiagonal = Math.abs(from.getX() - to.getX()) == Math.abs(from.getY() - to.getY());

        int deltaX = to.getX() - from.getX();
        int deltaY = to.getY() - from.getY();

        boolean obstacle = false;
        if (isDiagonal) {
            if (deltaX < 0 && deltaY < 0) {
                for (int i = 1; i < Math.abs(deltaX); i++) {
                    if (board.getField()[from.getX()][i] != null) {
                        obstacle = true;
                        break;
                    }
                }
            } else if (deltaX < 0 && deltaY > 0) {
                for (int i = 1; i < Math.abs(deltaX); i++) {
                    if (board.getField()[from.getX() - i][from.getY() + i] != null) {
                        obstacle = true;
                        break;
                    }
                }
            } else if (deltaX > 0 && deltaY < 0) {
                for (int i = 1; i < Math.abs(deltaX); i++) {
                    if (board.getField()[from.getX()][i] != null) {
                        obstacle = true;
                        break;
                    }
                }
            } else if (deltaX > 0 && deltaY > 0) {
                for (int i = 1; i < Math.abs(deltaX); i++) {
                    if (board.getField()[from.getX()][i] != null) {
                        obstacle = true;
                        break;
                    }
                }
            }
    }
        if (obstacle) return false;
        else {
            if (board.getField()[to.getX()][to.getY()] == null) {
                return true;
            } else {
                return colorIsWhite != ((ChessFigure) board.getField()[to.getX()][to.getY()]).isColorIsWhite();
            }
        }

    }
}
