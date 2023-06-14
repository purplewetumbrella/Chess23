package com.example.chess23.GameBase.Chess.Figures;

import com.example.chess23.GameBase.Base.Coordinate;
import com.example.chess23.GameBase.Chess.ChessFigure;

public class Knight extends ChessFigure {
    public Knight(boolean colorIsWhite, Coordinate coordinate) {
        super(colorIsWhite, colorIsWhite ? '\u2658' : '\u265e', coordinate);
    }

    @Override
    public boolean canMove(Coordinate to) {
        return (Math.abs(from.getX() - to.getX()) == 1 && Math.abs(from.getY() - to.getY()) == 3) ||
                (Math.abs(from.getX() - to.getX()) == 3 && Math.abs(from.getY() - to.getY()) == 1);
    }
}
