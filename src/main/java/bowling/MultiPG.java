package bowling;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
/**
 *
 * @author pedago
 */
public class MultiPG implements MultiPlayerGame {
    private static final String TURN = "Prochain tir : joueur %s, tour n° %d, boule n° %d"; // Constante message prochain tir
    private static final String END = "Partie terminée";
    
    private final Map<String, SinglePlayerGame> games; // Tous les joueurs de la partie
    private Iterator<String> player; 
    
    private String currentPlayer; // Joueur actuel
    private SinglePlayerGame currentGame; 
    private boolean gameFinished = true;
    
    public MultiPG(){
          games = new HashMap<>();
    }
    
    /**
     * Démarre une nouvelle partie pour un groupe de joueurs
     * @param playerName un tableau des noms de joueurs (il faut au moins un joueur)
     * @return une chaîne de caractères indiquant le prochain joueur,
     * de la forme "Prochain tir : joueur Bastide, tour n° 1, boule n° 1"
     * @throws java.lang.Exception si le tableau est vide ou null
     */
    @Override
    public String startNewGame(String[] playerName) throws Exception {
        
        if (playerName.length == 0){ // Aucun joueur exception
            throw new Exception("Partie sans joueur");
        }
        for(int i = 0 ; i < playerName.length ; i++){ // On rempli la hashmap de joueurs
            games.put(playerName[i],new SinglePlayerGame());
        }
        
        player = games.keySet().iterator();
        gameFinished = false;

        joueurSuivant(); // On passe au premier joueur
        
        
        return Message();
        
    
    }
    
    @Override
    public String lancer(int nombreDeQuillesAbattues) throws Exception {
        if(gameFinished){ // Si la game est fini, on passe une erreur parce que plus de lancer possible
                          // ou qu'elle n'a pas commencé
            throw new java.lang.Exception(END);
        }
        currentGame.lancer(nombreDeQuillesAbattues);
        
        if (currentGame.hasCompletedFrame() || currentGame.isFinished()){ // Quand le joueur a fini ses deux lancers, on passe au joueur suivant
            joueurSuivant();
        }
        
       return Message();
    }

    @Override
    public int scoreFor(String playerName) throws Exception {
         if(!games.containsKey(playerName)){
            throw new Exception("Joueur non enregistré");
        }
        SinglePlayerGame scoredGame = games.get(playerName);
        return scoredGame.score();
             
    }
    
    public String Message(){
        if (gameFinished){
            return(END);
        }
        else {
            SinglePlayerGame curGame=currentGame;            
            return(String.format(TURN,currentPlayer,curGame.getFrameNumber() , curGame.getNextBallNumber()));
        }
    }
    
    public void joueurSuivant(){
        if (!player.hasNext()){
            if (currentGame.isFinished()){
                gameFinished = true;
            }else{
                player = games.keySet().iterator();
            }          
        }
        currentPlayer=player.next();
        currentGame=games.get(currentPlayer);
    }
    
}