package Model;

/**
 * Newly created class to help with the creating of the score pop up
 */

public class RoundScore {

    private int scoreColumn;
    private String roundColumn;

    /**
     * Getter for the scoreColumn from round scores
     * @return The values from the table column, scoreColumn
     */
    public int getScoreColumn() {
        return scoreColumn;
    }

    /**
     * Setter for the scoreColumn table column
     * @param scoreColumn The value to be placed in the table column, scoreColumn
     */
    public void setScoreColumn(int scoreColumn) {
        this.scoreColumn = scoreColumn;
    }

    /**
     * Getter for the roundColumn from round scores
     * @return The values from the table column, roundColumn
     */
    public String getRoundColumn() {
        return roundColumn;
    }

    /**
     * Setter for the roundColumn table column
     * @param roundColumn The value to be placed in the table column, roundColumn
     */
    public void setRoundColumn(String roundColumn) {
        this.roundColumn = roundColumn;
    }

    /**
     * Helps with storing the values
     * @param roundColumn roundColumn values
     * @param ScoreColumn scoreColumn values
     */
    public RoundScore(String roundColumn, int ScoreColumn){
        this.scoreColumn = ScoreColumn;
        this.roundColumn = roundColumn;
    }
}
