import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PaginationHelper<I> {

    private HashMap<Integer, ArrayList<I>> pages = new HashMap<>();
    private int itemCount;
    private int pageCount;
    private int itemsPerPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        itemCount = collection.size();
        this.itemsPerPage = itemsPerPage;
        ArrayList<I> itemsOnPage = null;
        int pageNumber = 0;
        int current = 0;
        int counter = 0;
        boolean needNewList = true;
        for (I item : collection) {
            if (needNewList) {
                itemsOnPage = new ArrayList<>();
                needNewList = false;
            }
            // put in list
            itemsOnPage.add(item);
            current++;
            counter++;
            // check if enough
            if (current == itemsPerPage || counter == collection.size()) {
                pages.put(pageNumber, itemsOnPage);
                needNewList = true;
                pageNumber++;
                if (counter == collection.size()) pageCount = pageNumber;
                current = 0;
            }
        }
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return itemCount;
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return pageCount;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        try {
            return pages.get(pageIndex).size();
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= itemCount) return -1;
        return itemIndex / itemsPerPage;
    }

    public static void main(String[] args) {
        PaginationHelper<Character> helper = new PaginationHelper<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        System.out.println("Page count = " + helper.pageCount()); //should == 2
        System.out.println("Item count = " + helper.itemCount()); //should == 6
        System.out.println("Items on 0 page = " + helper.pageItemCount(0)); //should == 4
        System.out.println("Items on 1 page = " + helper.pageItemCount(1)); // last page - should == 2
        System.out.println("Items on 2 page = " + helper.pageItemCount(2)); // should == -1 since the page is invalid

        // pageIndex takes an item index and returns the page that it belongs on
        System.out.println("Item 5 on page = " + helper.pageIndex(5)); //should == 1 (zero based index)
        System.out.println("Item 2 on page = " + helper.pageIndex(2)); //should == 0
        System.out.println("Item 3 on page = " + helper.pageIndex(3)); //should == 0
        System.out.println("Item 4 on page = " + helper.pageIndex(4)); //should == 1
        System.out.println("Item 6 on page = " + helper.pageIndex(6)); //should == 1
        System.out.println("Item 20 on page = " + helper.pageIndex(20)); //should == -1
        System.out.println("Item -10 on page = " + helper.pageIndex(-10)); //should == -1
    }

}