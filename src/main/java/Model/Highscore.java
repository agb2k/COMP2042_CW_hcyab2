package Model;

/**
 * Newly created class to help with the creating of the high score menu
 */

public class Highscore {

    int ScoreColumn;
    String nameColumn;

    public int getScoreColumn() {
        return ScoreColumn;
    }

    public void setScoreColumn(int scoreColumn) {
        ScoreColumn = scoreColumn;
    }

    public String getNameColumn() {
        return nameColumn;
    }

    public void setNameColumn(String nameColumn) {
        this.nameColumn = nameColumn;
    }

    public Highscore(String nameColumn, int ScoreColumn){
        this.ScoreColumn = ScoreColumn;
        this.nameColumn = nameColumn;
    }


}
