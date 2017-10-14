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
    protected Board board;
    protected IMove player1;
    protected IMove player2;           ;

    public Game(int boardSize, IMove player1, IMove player2) {
        board = new Board(boardSize);
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public void playGame()
    {
        for(;;){
            System.out.println(board);
            if(makeMove(player1, BoardSymbol.CIRCLE)){
                return;
            }
            System.out.println(board);
            if(makeMove(player2, BoardSymbol.CROSS)){
                return;
            }
            
        }
    }
    
    protected boolean makeMove(IMove player, BoardSymbol symbol){
        Move move = player.makeMove(board, symbol);
        board.setSymbolAccordingToMove(move);
        if(isWinner(board,move,player)){
            return true;
        }
        return false;
    }
    
    
    private final int moves[][] = {{1,1}, {0,1}, {-1,1}, {-1,0}};
    protected boolean isWinner(Board board, Move move, IMove player)
    {
        for (int j = 0; j < 4; j++ ) {
            int symbolsInRow = 1;
            for(int i = 1; i < 5; i++){
                if(!isSame(board, move.getSymbol(), move.getPosX() + i * moves[j][0], move.getPosY() + i * moves[j][1])){
                    break;
                }
                symbolsInRow++;
            }
            for(int i = -1; i > -5; i--){
                if(!isSame(board, move.getSymbol(), move.getPosX() + i * moves[j][0], move.getPosY() + i * moves[j][1])){
                    break;
                }
                symbolsInRow++;
            }
            if(symbolsInRow == 5){
                System.out.println("Winner: " + player.getName());
                return true;
            }
        }
        return false;
    }
    
    
    
    
    private boolean isSame(Board board, BoardSymbol symbol, int x, int y)
    {
        if(x < 0 || y < 0 || x >= board.getBoardSize() || y >= board.getBoardSize() )
            return false;
        if (board.getSymbolAtPosition( x, y) == symbol)
            return true;
        return false;
    }
    /*
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
    */
}
