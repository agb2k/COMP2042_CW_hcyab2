package Model;

/**
 * Newly created class to help with the creating of the score pop up
 */

public class RoundScore {

    int scoreColumn;
    String roundColumn;

    public int getScoreColumn() {
        return scoreColumn;
    }

    public void setScoreColumn(int scoreColumn) {
        this.scoreColumn = scoreColumn;
    }

    public String getRoundColumn() {
        return roundColumn;
    }

    public void setNameColumn(String roundColumnColumn) {
        this.roundColumn = roundColumnColumn;
    }

    public RoundScore(String nameColumn, int ScoreColumn){
        this.scoreColumn = ScoreColumn;
        this.roundColumn = nameColumn;
    }
}
