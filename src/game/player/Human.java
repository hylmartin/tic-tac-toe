/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.player;

import game.board.Board;
import game.board.BoardSymbol;
import java.util.Scanner;

/**
 *
 * @author Martin Hyl
 */
public class Human implements IMove{

    @Override
    public Move makeMove(Board board, BoardSymbol yourTurn) {
        int posX, posY;
        Scanner sc  = new Scanner(System.in);
        do {
            System.out.println("Insert position of your symbol:");
            posX = sc.nextInt();//sc.scanner
            posY = sc.nextInt();//rand.nextInt(board.getBoardSize());
            if( !(posX < board.getBoardSize() && posX > -1 && posY < board.getBoardSize() && posY > -1))
            {
                System.err.println("Out of range");
                continue;
            }
            if(board.getSymbolAtPosition(posX, posY) != null)
            {
                System.err.println("Already a symbol");
                continue;
            }
            break;
        }while(true);
        
        return new Move(posX,posY,yourTurn);
    }

    @Override
    public String getName() {
        return "Human";
    }
    
    
    
}
