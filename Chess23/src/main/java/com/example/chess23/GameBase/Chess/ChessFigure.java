package com.example.chess23.GameBase.Chess;

import com.example.chess23.GameBase.Base.Coordinate;
import com.example.chess23.GameBase.Base.Figure;
import com.example.chess23.GameBase.Base.Movable;

public abstract class ChessFigure extends Figure implements Movable {
    protected boolean colorIsWhite;

    public ChessFigure(boolean colorIsWhite, char symbol, Coordinate coordinateFrom) {
        super(symbol, coordinateFrom);
        this.colorIsWhite = colorIsWhite;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

    public boolean isColorIsWhite() {
        return colorIsWhite;
    }
}
