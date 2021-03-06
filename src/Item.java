import java.util.ArrayList;
import java.util.List;

public class Item {
    int _ID;
    String _name;

    Item(int ID, String name) {
        this._ID = ID;
        this._name = name;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "\nID=" + _ID +
                "\nname='" + _name + '\'' +
                "\n}";

    }
}

