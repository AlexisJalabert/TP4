/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pedago
 */
public class MultiPG implements MultiPlayerGame {
    
    private Map<String,SinglePlayerGame> player = new HashMap<>();
    
    /**
    * Démarre une nouvelle partie pour un groupe de joueurs
    * @param playerName un tableau des noms de joueurs (il faut au moins un joueur)
    * @return une chaîne de caractères indiquant le prochain joueur,
    * de la forme "Prochain tir : joueur Bastide, tour n° 1, boule n° 1"
    * @throws java.lang.Exception si le tableau est vide ou null
    */
    @Override
    public String startNewGame(String[] playerName) throws Exception {
        if(playerName == null) {
            throw new Exception("Pas de noms");
        }
        for(int i = 0 ; i < playerName.length ; i++) {
            player.put(playerName[i], new SinglePlayerGame());
        }
        return "";
    }
    /**
    * Enregistre le nombre de quilles abattues pour le joueur courant, dans le frame courant, pour la boule courante
    * @param nombreDeQuillesAbattues : nombre de quilles abattue à ce lancer
    * @return une chaîne de caractères indiquant le prochain joueur,
    * de la forme "Prochain tir : joueur Bastide, tour n° 5, boule n° 2",
    * ou bien "Partie terminée" si la partie est terminée.
    * @throws java.lang.Exception si la partie n'est pas démarrée.
    */
    @Override
    public String lancer(int nombreDeQuillesAbattues) throws Exception {
        
        return "";
    }
    /**
     * Donne le score pour le joueur playerName
    * @param playerName le nom du joueur recherché
    * @return le score pour ce joueur
    * @throws Exception si le playerName ne joue pas dans cette partie
    */
    @Override
    public int scoreFor(String playerName) throws Exception {
        return 0;
    }
    
}
