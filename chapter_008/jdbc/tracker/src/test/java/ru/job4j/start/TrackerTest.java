package ru.job4j.start;

import org.junit.Test;
import ru.job4j.models.Comment;
import ru.job4j.models.Item;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class Tracker.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 08.12.2016
 */
public class TrackerTest {
    /**
     * Test addItem.
     */
    @Test
    public void whenAddItemThenReturnItem() {
        final Tracker tracker = new Tracker();

        final Item item  = new Item("item", "descr");

        final Item result = tracker.addItem(item);

        assertThat(result, is(item));
    }

    /**
     * Test editItem.
     */
    @Test
    public void whenEditItemThenReturnEditedItem() {
        final Tracker tracker = new Tracker();

        final Item item  = new Item("item", "descr");
        final Item item1  = new Item("item1", "descr1");

        tracker.addItem(item);
        tracker.addItem(item1);

        final Item editItem  = new Item("edit item", "edit desc");

        editItem.setId(item.getId());

        tracker.editItem(editItem);

        assertThat(tracker.getAllItem().get(0), is(editItem));
    }

    /**
     * Test removeItem.
     */
    @Test
    public void whenRemoveItemThenReturnEditedItem() {
        final Tracker tracker = new Tracker();

        final Item item  = new Item("item", "descr");
        final Item item1  = new Item("item1", "descr1");

        tracker.addItem(item);
        tracker.addItem(item1);

        final List<Item> checked = new ArrayList<>();
        checked.add(item1);

        tracker.removeItem(item);

        assertThat(tracker.getAllItem(), is(checked));
    }

    /**
     * Test getAllItem.
     */
    @Test
    public void whenGetAllItemThenReturnListItem() {
        final Tracker tracker = new Tracker();

        final Item item  = new Item("item", "descr");
        final Item item1  = new Item("item1", "descr1");
        final Item item2  = new Item("item2", "descr2");

        tracker.addItem(item);
        tracker.addItem(item1);
        tracker.addItem(item2);

        final List<Item> checked = new ArrayList<>();
        checked.add(item);
        checked.add(item1);
        checked.add(item2);

        final List<Item> result = tracker.getAllItem();

        assertThat(result, is(checked));
    }

    /**
     * Test findById.
     */
    @Test
    public void whenGetIdThenReturnItem() {
        final Tracker tracker = new Tracker();

        final Item item  = new Item("item", "descr");
        final Item item1  = new Item("item1", "descr1");
        final Item item2  = new Item("item2", "descr2");

        tracker.addItem(item);
        tracker.addItem(item1);
        tracker.addItem(item2);

        final Item checked = item1;

        final Item result = tracker.findById(item1.getId());

        assertThat(result, is(checked));
    }

    /**
     * Test findByName.
     */
    @Test
    public void whenGetNameThenReturnItem() {
        final Tracker tracker = new Tracker();

        final Item item  = new Item("item", "descr");
        final Item item1  = new Item("item1", "descr1");
        final Item item2  = new Item("item2", "descr2");

        tracker.addItem(item);
        tracker.addItem(item1);
        tracker.addItem(item2);

        final Item checked = item2;

        final Item result = tracker.findByName("item2");

        assertThat(result, is(checked));
    }

    /**
     * Test findByDescription.
     */
    @Test
    public void whenGetDescriptionThenReturnListItem() {
        final Tracker tracker = new Tracker();

        final Item item  = new Item("item", "descr");
        final Item item1  = new Item("item1", "description");
        final Item item2  = new Item("item2", "desc2");

        tracker.addItem(item);
        tracker.addItem(item1);
        tracker.addItem(item2);

        final List<Item> checked = new ArrayList<>();

        checked.add(item);
        checked.add(item1);

        final List<Item> result = tracker.findByDescription("descr");

        assertThat(result, is(checked));
    }

    /**
     * Test addComment.
     */
    @Test
    public void whenAddCommentThenReturnItemWithComment() {
        final Tracker tracker = new Tracker();

        final Item item  = new Item("item", "descr");
        final Item item1  = new Item("item1", "descr1");
        final Item item2  = new Item("item2", "descr2");

        tracker.addItem(item);
        tracker.addItem(item1);
        tracker.addItem(item2);

        final Item result = tracker.addComment(item2.getId(), new Comment("Danger"));

        final Item checked = item2;

        assertThat(result, is(checked));
    }
}
