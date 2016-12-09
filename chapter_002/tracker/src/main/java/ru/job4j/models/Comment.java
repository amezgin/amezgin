package ru.job4j.models;

/**
 *The class Comment.
 * @author Alexander Mezgin
 * @since 08.12.2016
 * @version 1.0
 */
public class Comment {
    /**
     *Private fild for class Comment.
     */
    private String comment;

    /**
     *Default constructor for the class Comment.     *
     */
    public  Comment() {

    }
    /**
     *Constructor for the class Comment.
     *@param comment for the Constructor
     */
    public Comment(String comment) {
        this.comment = comment;
    }

    /**
    *Getter for the field "comment".
    *@return comment
    */
    public String getComment() {
        return comment;
    }

    /**
     *Setter for the field "comment".
     *@param comment of Comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
