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

        final String[] answers = {"name", "descr"};
        final StubInput stubInput = new StubInput(answers);

        final Item item = new Item(
                stubInput.ask("Input the name of the item: "),
                stubInput.ask("Input the description of the item: "));

        final Item result = tracker.addItem(item);

        assertNotNull(tracker.getAllItem().get(0));
    }

    /**
     * Test removeItem.
     */
    @Test
    public void whenDeleteItemThenReturnEditedListItem() {
        final Tracker tracker = new Tracker();

        final String[] answers = {"1"};
        final StubInput stubInput = new StubInput(answers);

        final Item item = new Item("name", "descr");
        final Item item1 = new Item("name1", "descr1");

        tracker.addItem(item);
        tracker.addItem(item1);

        item.setId("1");
        item1.setId("2");

        final List<Item> checked = new ArrayList<>();
        checked.add(item1);

        tracker.removeItem(tracker.findById(stubInput.ask("Enter the id of the deleted item: ")));

        assertThat(tracker.getAllItem(), is(checked));
    }

    /**
     * Test editItem.
     */
    @Test
    public void whenEditItemThenReturnEditedItem() {
        final Tracker tracker = new Tracker();

        final String[] answers = {"1", "itemEdit", "descrEdit"};
        final StubInput stubInput = new StubInput(answers);

        final Item item = new Item("name", "descr");
        final Item item1 = new Item("name1", "descr1");

        tracker.addItem(item);
        tracker.addItem(item1);

        item.setId("1");

        final String id = stubInput.ask("Enter the id of the edited item: ");
        final Item itemEdit = new Item(
                stubInput.ask("Input the new name of the item: "),
                stubInput.ask("Input the new description of the item: "));

        itemEdit.setId(id);

        tracker.editItem(itemEdit);

        final List<Item> checked = new ArrayList<>();
        checked.add(itemEdit);
        checked.add(item1);

        assertThat(tracker.getAllItem(), is(checked));
    }

    /**
     * Test getAllItem.
     */
    @Test
    public void whenGetAllItemThenReturnSizeListItemOne() {
        final Tracker tracker = new Tracker();

        final Item item = new Item("name", "descr");

        tracker.addItem(item);

        assertThat(tracker.getAllItem().size(), is(1));
    }

    /**
     * Test findById.
     */
    @Test
    public void whenFindByIdThenReturnSearchedItem() {
        final Tracker tracker = new Tracker();

        final Item item = new Item("name", "descr");
        final Item item1 = new Item("name1", "descr1");

        tracker.addItem(item);
        tracker.addItem(item1);

        item.setId("1");
        item1.setId("2");

        final String[] answers = {"1"};
        final StubInput stubInput = new StubInput(answers);

        final String id = stubInput.ask("Enter the id of the searched item: ");

        assertThat(tracker.findById(id), is(item));
    }

    /**
     * Test findByName.
     */
    @Test
    public void whenFindByNameThenReturnSearchedItem() {
        final Tracker tracker = new Tracker();

        final Item item = new Item("name", "descr");
        final Item item1 = new Item("name1", "descr1");

        tracker.addItem(item);
        tracker.addItem(item1);

        final String[] answers = {"name1"};
        final StubInput stubInput = new StubInput(answers);

        final String name = stubInput.ask("Enter the name of the searched item: ");

        assertThat(tracker.findByName(name), is(item1));
    }

    /**
     * Test findByDescription.
     */
    @Test
    public void whenFindByDescriptionThenReturnSearchedListItem() {
        final Tracker tracker = new Tracker();

        final Item item = new Item("name", "descr");
        final Item item1 = new Item("name1", "desr1");
        final Item item2 = new Item("name2", "descr2");

        tracker.addItem(item);
        tracker.addItem(item1);
        tracker.addItem(item2);

        final List<Item> checked = new ArrayList<>();
        checked.add(item);
        checked.add(item2);

        final String[] answers = {"desc"};
        final StubInput stubInput = new StubInput(answers);

        final String descr = stubInput.ask("Enter the description of the searched item: ");

        assertThat(tracker.findByDescription(descr), is(checked));
    }

    /**
     * Test addComment.
     */
    @Test
    public void whenAddCommentThenReturnItemWithComment() {
        final Tracker tracker = new Tracker();

        final Item item = new Item("name", "descr");
        final Item item1 = new Item("name1", "desr1");

        tracker.addItem(item);
        tracker.addItem(item1);

        item.setId("1");
        item1.setId("2");

        final String[] answers = {"1","comment"};
        final StubInput stubInput = new StubInput(answers);

        final String id = stubInput.ask("Enter the id of the item to which to add a comment: ");
        final String comm = stubInput.ask("Enter the comment: ");

        final Comment comment = new Comment(comm);
        tracker.addComment(id, comment);

        assertThat(tracker.findById("1").getAllComments().get(0), is(comment));
    }
}
