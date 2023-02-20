package Exercises6_DefiningClasses.P06PokemonTrainer;

import java.util.List;

public class Trainer {
    private String trainerName;
    private int badgesCount;
    private List<Pokemon> collectionOfPokemon;


    public Trainer(String trainerName, List<Pokemon> collectionOfPokemon) {
        this.trainerName = trainerName;
        this.badgesCount = 0;
        this.collectionOfPokemon = collectionOfPokemon;
    }

    public int getBadgesCount() {
        return badgesCount;
    }

    public void commandExecuting(String command) {

        if (isExist(command)) {
            badgesCount += 1;
        } else {

            for (int i = 0; i < collectionOfPokemon.size(); i++) {

                collectionOfPokemon.get(i).setHealth(collectionOfPokemon.get(i).getHealth() - 10);
                if (collectionOfPokemon.get(i).getHealth() <= 0){
                    collectionOfPokemon.remove(i);
                    i--;
                }
            }

        }
    }

    private boolean isExist(String command) {

        for (Pokemon pokemon : collectionOfPokemon) {

            if (pokemon.getElement().equals(command)) {

                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return trainerName + " " + badgesCount + " " + collectionOfPokemon.size();
    }
}

