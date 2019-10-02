/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Alexis Jalabert
 */
public class MultiPGTest {
    private MultiPG game;
    
    @Before
    public void setUp() {
	game = new MultiPG();
    }
    
    /**
     * La partie n'a pas encore commencer, une exception doit être lever
     * @throws Exception 
     */
    @Test
    public void partieNonCommencer() throws Exception {
        System.out.println("TEST VISUEL");
        System.out.println(game.lancer(4));
    }  
    
    /**
     * La partie n'a pas de joueur, une exception doit être lever
     * @throws Exception 
     */
    @Test
    public void pasDeJoueur() throws Exception {
        String[] playerName = {};
        System.out.println("TEST VISUEL");
        System.out.println(game.startNewGame(playerName));
    }
    
    /**
     * La partie comporte un joueur
     * @throws Exception 
     */
    @Test
    public void unJoueur() throws Exception {
        String[] playerName = {"Roger"};
        System.out.println("TEST VISUEL ET NUMERIQUE");
        System.out.println(game.startNewGame(playerName));
        rollMany(12, 3);
        assertEquals(36, game.scoreFor("Roger"));
    }
    
    /**
     * La partie comporte plusieurs joueurs
     * @throws Exception 
     */
    public void plusieursJoueurs() throws Exception {
        String[] playerName = {"Roger", "Clement", "Alice"};
        System.out.println("TEST VISUEL ET NUMERIQUE");
        System.out.println(game.startNewGame(playerName));
        rollMany(12, 3);
        assertEquals(game.scoreFor("Roger"), 12);
        assertEquals(game.scoreFor("Clement"), 12);
        assertEquals(game.scoreFor("Alice"), 12);
    }
    
    
    private void rollMany(int n, int pins) throws Exception {
	for (int i = 0; i < n; i++) {
           System.out.println(game.lancer(pins));
        }
    }
}
