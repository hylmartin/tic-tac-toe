/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.player;

import game.board.BoardSymbol;

/**
 *
 * @author Martin Hyl
 */
public class Move {
    private final int  posX;
    private final int  posY;
    private final BoardSymbol symbol;

    public Move(int posX, int posY, BoardSymbol symbol) {
        this.posX = posX;
        this.posY = posY;
        this.symbol = symbol;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public BoardSymbol getSymbol() {
        return symbol;
    }
    
    
    
}
