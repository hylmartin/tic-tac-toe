/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv2;

import game.Game;
import game.board.Board;
import game.board.BoardSymbol;
import game.player.IMove;
import game.player.Move;
import game.player.StupidPlayer;
import game.player.Human;

/**
 *
 * @author Martin Hyl
 */
public class Cv2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Game game = new Game(10, new StupidPlayer(), new Human());
        game.playGame();
        
        
    }
}
