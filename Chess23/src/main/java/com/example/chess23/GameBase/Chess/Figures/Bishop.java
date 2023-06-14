package com.example.chess23.GameBase.Chess.Figures;

import com.example.chess23.GameBase.Base.Coordinate;
import com.example.chess23.GameBase.Chess.ChessBoard;
import com.example.chess23.GameBase.Chess.ChessFigure;

public class Bishop extends ChessFigure {
    private final ChessBoard board;

    public Bishop(boolean colorIsWhite, Coordinate coordinateFrom, ChessBoard board) {
        super(colorIsWhite, colorIsWhite ? '\u2655' : '\u265b', coordinateFrom);
        this.board = board;
    }

    @Override
    public boolean canMove(Coordinate to) {
        boolean isVertical = from.getX() == to.getX();
        boolean isHorizontal = from.getY() == to.getY();

        int deltaX = to.getX() - from.getX();
        int deltaY = to.getY() - from.getY();

        boolean obstacle = false;

        if (isVertical) {
            if (deltaY < 0) {
                for (int i = from.getY() - 1; i > to.getY(); i--) {
                    if (board.getField()[from.getX()][i] != null) {
                        obstacle = true;
                        break;
                    }
                }
            } else {
                for (int i = from.getY() + 1; i < to.getY(); i++) {
                    if (board.getField()[from.getX()][i] != null) {
                        obstacle = true;
                        break;
                    }
                }
            }
        } else if (isHorizontal) {
            if (deltaX < 0) {
                for (int i = from.getX() - 1; i > to.getX(); i--) {
                    if (board.getField()[from.getX()][i] != null) {
                        obstacle = true;
                        break;
                    }
                }
            } else {
                for (int i = from.getX() + 1; i < to.getX(); i++) {
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

