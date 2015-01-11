package homework1.danco.example.com.h251danco;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample name for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "John Galt"));
        addItem(new DummyItem("2", "Dagny Taggert"));
        addItem(new DummyItem("3", "Hank Rearden"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of name.
     */
    public static class DummyItem implements Parcelable {
        public String id;
        public String name;
        public String streetAddress;
        public String city;
        public String state;
        public String zip;
        public String birthDate;

        public DummyItem(String id, String name) {
            this.id = id;
            this.name = name;
            streetAddress = "123 Demo St";
            city = "Seattle";
            state = "WA";
            zip = "98101";
            birthDate = "01/05/2015";
        }

        @Override
        public String toString() {
            return name;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {

        }
    }
}