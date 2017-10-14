/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.player;

import game.board.Board;
import game.board.BoardSymbol;
import java.util.Random;

/**
 *
 * @author Martin Hyl
 */
public class StupidPlayer implements IMove {

    @Override
    public Move makeMove(Board board, BoardSymbol yourTurn) {
        int posX, posY;
        Random rand = new Random();
        do {
            posX = rand.nextInt(board.getBoardSize());
            posY = rand.nextInt(board.getBoardSize());
        }while(board.getSymbolAtPosition(posX, posY) != null);
        return new Move(posX,posY,yourTurn);
    }

    @Override
    public String getName() {
        return "Random stupid player";
    }
    
}
