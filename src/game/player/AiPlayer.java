/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.player;

import game.board.Board;
import game.board.BoardSymbol;

/**
 *
 * @author Martin Hyl
 */
public class AiPlayer implements IMove {

    @Override
    public Move makeMove(Board board, BoardSymbol yourTurn) {
        int posX,posY;
        posX = 0;
        posY = 0;
                
        
        return new Move(posX,posY,yourTurn);
    }

    @Override
    public String getName() {
        return "Robot";
    }
    
    public int longestRow(Board board) {
        return 0;
    }
    
}
