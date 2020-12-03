package Model;

/**
 * Newly created class to help with the creating of the high score menu
 */

public class Highscore {

    int ScoreColumn;
    String nameColumn;

    /**
     * Getter for the score column
     * @return score column value
     */
    public int getScoreColumn() {
        return ScoreColumn;
    }


    /**
     * Setter for score column
     * @param scoreColumn the value to be assigned to the scoreColumn value
     */
    public void setScoreColumn(int scoreColumn) {
        ScoreColumn = scoreColumn;
    }

    /**
     * Getter for the name column
     * @return Name column value
     */
    public String getNameColumn() {
        return nameColumn;
    }


    /**
     * Setter for name column
     * @param nameColumn the value to be assigned to the nameColumn value
     */
    public void setNameColumn(String nameColumn) {
        this.nameColumn = nameColumn;
    }

    /**
     * Function to assign values to the high score menu
     * @param nameColumn name of player
     * @param ScoreColumn score of player
     */

    public Highscore(String nameColumn, int ScoreColumn){
        this.ScoreColumn = ScoreColumn;
        this.nameColumn = nameColumn;
    }
}
