/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.board.Board;
import game.board.BoardSymbol;
import game.player.Human;
import game.player.IMove;
import game.player.Move;

/**
 *
 * @author Martin Hyl
 */
public class GUIGame extends Game{
    
    public GUIGame(int boardSize, IMove player1) {
        super(boardSize, player1, new Human());
    }
    
    public Board getBoard(){
        return board;
    }
    
    public boolean makeMove(Move move){
        board.setSymbolAccordingToMove(move);
        if(isWinner(board,move,player2)){
            return true;
        }
        return false;
    }
    
    
    
    public boolean makeMove(BoardSymbol symbol){
        return makeMove(player1, symbol);
    }
    
}
