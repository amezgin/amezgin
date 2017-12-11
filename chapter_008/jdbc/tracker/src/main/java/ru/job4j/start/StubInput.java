package ru.job4j.start;

/**
 *The class  StubInput.
 * @author Alexander Mezgin
 * @since 12.12.2016
 * @version 1.0
 */
public class StubInput implements Input {

    /**
     *Private fild the array of answers.
     */
    private final String[] answers;
    /**
     *Private fild position.
     */
    private int position = 0;

    /**
     * The class constructor.
     * @param answers the array of answers
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     *This method asks the user and return answer.
     *@param question is question
     *@return answer
     */
    @Override
    public String ask(String question) {
        return answers[position++];
    }

    /**
     *This method asks question and number of range the user.
     *@param question is question
     *@param range is range
     *@return question
     */
    @Override
    public int ask(String question, int[] range) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return -1;
    }
}
