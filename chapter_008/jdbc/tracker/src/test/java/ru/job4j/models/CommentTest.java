package ru.job4j.models;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class Comment.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 08.12.2016
 */
public class CommentTest {

    /**
     * Test getComment.
     */
    @Test
    public void whenGetCommentThenReturnComment() {
        Comment comment = new Comment("test comment one");

        final String checked = "test comment one";

        final String result = comment.getComment();

        assertThat(result, is(checked));
    }

    /**
     * Test setComment.
     */
    @Test
    public void whenSetCommentThenAddComment() {
        Comment comment = new Comment();

        comment.setComment("test comment two");

        final String checked = "test comment two";

        final String result = comment.getComment();

        assertThat(result, is(checked));
    }
}
