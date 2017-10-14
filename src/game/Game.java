/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.board.Board;
import game.board.BoardSymbol;
import game.player.IMove;
import game.player.Move;

/**
 *
 * @author Martin Hyl
 */
public class Game {
    private Board board;
    private IMove player1;
    private IMove player2;           ;

    public Game(int boardSize, IMove player1, IMove player2) {
        board = new Board(boardSize);
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public void playGame()
    {
        Move move;
        for(;;){
            move = player1.makeMove(board, BoardSymbol.CIRCLE);
            board.setSymbolAccordingToMove(move);
            System.out.println(board);
            if(isWinner(board, move, player1)){
                System.out.println(player1.getName() + "WIN");
                return;
            }
            move = player2.makeMove(board, BoardSymbol.CROSS);
            board.setSymbolAccordingToMove(move);
            System.out.println(board);
            if(isWinner(board, move, player2)){
                System.out.println(player2.getName() + "WIN");
                return;
            }
            
        }
    }

    private boolean isWinner(Board board, Move move, IMove player) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int n = 0;
        boolean nRow = true;
        int s = 0;
        boolean sRow = true;
        int e = 0;
        boolean eRow = true;
        int w = 0;
        boolean wRow = true;
        int ne= 0;
        boolean neRow = true;
        int sw = 0;
        boolean swRow = true;
        int se = 0;
        boolean seRow = true;
        int nw = 0;
        boolean nwRow = true;
        for(int i = 1; i < 5; i++)
        {
            if(move.getPosX()-i > -1 && move.getPosY()-i > -1)
                if(board.getSymbolAtPosition(move.getPosX()-i,move.getPosY()-i) == move.getSymbol() && nwRow)
                    nw++;
                else
                    nwRow = false;
            
            if(move.getPosY()-i > -1)
                if(board.getSymbolAtPosition(move.getPosX(), move.getPosY()-i) == move.getSymbol() && nRow)
                    n++;
                else
                    nRow = false;
            
            if(move.getPosX()+i < board.getBoardSize() && move.getPosY()-i > -1 )
                if(board.getSymbolAtPosition(move.getPosX()+i, move.getPosY()-i) == move.getSymbol() && neRow)
                    ne++;
                else
                    neRow = false;
            
            if(move.getPosX()+i < board.getBoardSize())
                if(board.getSymbolAtPosition(move.getPosX()+i, move.getPosY()) == move.getSymbol() && eRow)
                    e++;
                else
                    eRow = false;
            
            if(move.getPosX()+i < board.getBoardSize() && move.getPosY()+i < board.getBoardSize() )
                if(board.getSymbolAtPosition(move.getPosX()+i, move.getPosY()+i) == move.getSymbol() && seRow)
                    se++;
                else
                    seRow = false;
            
            if(move.getPosY()+i < board.getBoardSize() )
                if(board.getSymbolAtPosition(move.getPosX(), move.getPosY()+i) == move.getSymbol() && sRow)
                    s++;
                else
                    sRow = false;
            
            if(move.getPosX()-i > -1 && move.getPosY()+i < board.getBoardSize() )
                if(board.getSymbolAtPosition(move.getPosX()-i, move.getPosY()+i) == move.getSymbol() && swRow)
                    sw++;
                else
                    swRow = false;
            
            if(move.getPosX()-i > -1 )
                if(board.getSymbolAtPosition(move.getPosX()-i, move.getPosY()) == move.getSymbol() && wRow)
                    w++;
                else
                    wRow = false;
            
        }
        return w+e >= 4 || s+n >= 4 || sw+ne >=4 || nw+se >=4;
    }
    
}
