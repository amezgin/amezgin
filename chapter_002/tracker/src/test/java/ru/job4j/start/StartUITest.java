package ru.job4j.start;

import org.junit.Test;
import ru.job4j.models.Comment;
import ru.job4j.models.Item;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Test for class StartUI with class StubInput.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 14.12.2016
 */
public class StartUITest {

    /**
     * Test addItem.
     */
    @Test
    public void whenAddItemThenAddedItemToTracker() {
        final Tracker tracker = new Tracker();

        final String[] answers = {"0", "name", "descr"};
        final StubInput stubInput = new StubInput(answers);

        MenuTracker menuTracker = new MenuTracker(stubInput, tracker);

        menuTracker.fillAction();

        final int key = Integer.valueOf(stubInput.ask("Question!"));

        menuTracker.select(key);

        assertNotNull(tracker.getAllItem().get(0));
    }

    /**
     * Test removeItem.
     */
    @Test
    public void whenDeleteItemThenReturnEditedListItem() {
        final Tracker tracker = new Tracker();

        final String[] answers = {"1", "1"};
        final StubInput stubInput = new StubInput(answers);

        MenuTracker menuTracker = new MenuTracker(stubInput, tracker);

        final Item item = new Item("name", "descr");
        final Item item1 = new Item("name1", "descr1");

        tracker.addItem(item);
        tracker.addItem(item1);

        item.setId("1");
        item1.setId("2");

        final List<Item> checked = new ArrayList<>();
        checked.add(item1);

        menuTracker.fillAction();

        final int key = Integer.valueOf(stubInput.ask("Question!"));

        menuTracker.select(key);

        assertThat(tracker.getAllItem(), is(checked));
    }

    /**
     * Test editItem.
     */
    @Test
    public void whenEditItemThenReturnEditedItem() {
        final Tracker tracker = new Tracker();

        final String[] answers = {"2", "1", "itemEdit", "descrEdit"};
        final StubInput stubInput = new StubInput(answers);
        MenuTracker menuTracker = new MenuTracker(stubInput, tracker);

        final Item item = new Item("name", "descr");
        final Item item1 = new Item("name1", "descr1");

        tracker.addItem(item);
        tracker.addItem(item1);

        item.setId("1");

        final Item itemEdit = new Item("itemEdit", "descrEdit");

        itemEdit.setId("1");

        final String checkedName = "itemEdit";

        menuTracker.fillAction();

        final int key = Integer.valueOf(stubInput.ask("Question!"));

        menuTracker.select(key);

        final String resultName = tracker.getAllItem().get(0).getName();

        assertThat(resultName, is(checkedName));
    }

    /**
     * Test getAllItem.
     */
    @Test
    public void whenGetAllItemThenReturnSizeListItemOne() {
        final Tracker tracker = new Tracker();

        final String[] answers = {"3"};
        final StubInput stubInput = new StubInput(answers);

        MenuTracker menuTracker = new MenuTracker(stubInput, tracker);

        final Item item = new Item("name", "descr");

        tracker.addItem(item);

        menuTracker.fillAction();

        final int key = Integer.valueOf(stubInput.ask("Question!"));

        menuTracker.select(key);

        assertThat(tracker.getAllItem().size(), is(1));
    }

    /**
     * Test findById.
     */
    @Test
    public void whenFindByIdThenReturnSearchedItem() {
        final Tracker tracker = new Tracker();

        final String[] answers = {"4", "1"};
        final StubInput stubInput = new StubInput(answers);

        MenuTracker menuTracker = new MenuTracker(stubInput, tracker);

        final Item item = new Item("name", "descr");
        final Item item1 = new Item("name1", "descr1");

        tracker.addItem(item);
        tracker.addItem(item1);

        item.setId("1");
        item1.setId("2");

        menuTracker.fillAction();

        final int key = Integer.valueOf(stubInput.ask("Question!"));

        menuTracker.select(key);

        assertThat(tracker.findById("1"), is(item));
    }

    /**
     * Test findByName.
     */
    @Test
    public void whenFindByNameThenReturnSearchedItem() {
        final Tracker tracker = new Tracker();

        final String[] answers = {"5", "name1"};
        final StubInput stubInput = new StubInput(answers);

        MenuTracker menuTracker = new MenuTracker(stubInput, tracker);
        final Item item = new Item("name", "descr");
        final Item item1 = new Item("name1", "descr1");

        tracker.addItem(item);
        tracker.addItem(item1);

        menuTracker.fillAction();

        final int key = Integer.valueOf(stubInput.ask("Question!"));

        menuTracker.select(key);

        assertThat(tracker.findByName("name1"), is(item1));
    }

    /**
     * Test findByDescription.
     */
    @Test
    public void whenFindByDescriptionThenReturnSearchedListItem() {
        final Tracker tracker = new Tracker();
        final String[] answers = {"6", "descr"};
        final StubInput stubInput = new StubInput(answers);

        MenuTracker menuTracker = new MenuTracker(stubInput, tracker);

        final Item item = new Item("name", "descr");
        final Item item1 = new Item("name1", "desr1");
        final Item item2 = new Item("name2", "descr2");

        tracker.addItem(item);
        tracker.addItem(item1);
        tracker.addItem(item2);

        final List<Item> checked = new ArrayList<>();
        checked.add(item);
        checked.add(item2);

        menuTracker.fillAction();

        final int key = Integer.valueOf(stubInput.ask("Question!"));

        menuTracker.select(key);

        assertThat(tracker.findByDescription("descr"), is(checked));
    }

    /**
     * Test addComment.
     */
    @Test
    public void whenAddCommentThenReturnItemWithComment() {
        final Tracker tracker = new Tracker();

        final String[] answers = {"7", "1", "comment"};
        final StubInput stubInput = new StubInput(answers);

        MenuTracker menuTracker = new MenuTracker(stubInput, tracker);

        final Item item = new Item("name", "descr");
        final Item item1 = new Item("name1", "desr1");

        tracker.addItem(item);
        tracker.addItem(item1);

        item.setId("1");
        item1.setId("2");

        final Comment comment = new Comment("comment");
        tracker.addComment("1", comment);

        menuTracker.fillAction();

        final int key = Integer.valueOf(stubInput.ask("Question!"));

        menuTracker.select(key);

        assertThat(tracker.findById("1").getAllComments().get(0), is(comment));
    }
}
