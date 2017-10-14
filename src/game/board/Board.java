/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.board;

import game.player.Move;

/**
 *
 * @author Martin Hyl
 */
public class Board {
    private final int boardSize;
    private BoardSymbol [][] board;
    
    public Board(int boardSize) {
        this.boardSize = boardSize;
        board = new BoardSymbol[boardSize][boardSize];
    }

    public int getBoardSize() {
        return boardSize;
    }
    
    public BoardSymbol getSymbolAtPosition(int x, int y)
    {
        return board[x][y];
    }
    
    public void setSymbolAccordingToMove(Move move){
        if(board[move.getPosX()][move.getPosY()] == null) {
            board[move.getPosX()][move.getPosY()] = move.getSymbol();
        } else
        {
            System.err.println("Already a symbol");
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[j][i] == BoardSymbol.CIRCLE) {
                    sb.append('0');
                }else if (board[j][i] == BoardSymbol.CROSS) {
                    sb.append('X');
                }else {
                    sb.append('.');
                }
            }
            sb.append('\n');
        }
        
        
        return sb.toString();
    }
    
}
