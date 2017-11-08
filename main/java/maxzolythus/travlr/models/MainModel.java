package maxzolythus.travlr.models;

import java.util.*;

/**
 *
 * Created by Maxzolythus on 2/6/2017.
 */
public class MainModel extends Observable{
    private HashMap<String,Groupable> checkList = new HashMap<>(); // Where it would be name, groupable object

    /**
     * Creates a new Entry
     * @param name Name of the entry
     * @param quantity Amount of the entry
     */
    public void addEntry(String name, int quantity){
        Entry newEntry = new Entry(name, quantity);
        checkList.put(name, newEntry);
    }

    /**
     * Creates a new Group
     * @param name Name of the group
     */
    public void addGroup(String name){
        Group newGroup = new Group(name);
        checkList.put(name, newGroup);
    }

    /**
     * Adds a groupable object to a group
     * @param itemName The name of the grouplable object
     * @param groupName Them name of the group
     */
    public void addToGroup(String itemName, String groupName){
        if(checkList.containsKey(itemName)) {
            Groupable item = checkList.get(itemName);
            checkList.remove(itemName); // An item only exists in one group at a time.
            Group grp = (Group) checkList.get(groupName);
            grp.addToList(item);
        }
        else{
            //TODO
            // What if the item is in another group and not the top level checkList?
        }
    }

    public HashMap<String, Groupable> getCheckList(){
        return checkList;
    }

    /**
     * Renames a groupable object's name in the hash
     * @param name The original name
     * @param newName The new name
     */
    public void rename(String name, String newName){
        Groupable temp = checkList.get(name);
        checkList.remove(name);
        temp.rename(newName);
        checkList.put(newName, temp);
    }

    public void changeQuantity(String name, int quantity){
        Entry item = (Entry) checkList.get(name);
        item.changeQuantity(quantity);
    }

    public void delete(String name){
        checkList.remove(name);
    }

    /**
     * Saves all objects to the database
     */
    public void saveAll(){
        //TODO
    }

    /**
     * Loads all objects from the database
     */
    public void loadAll(){
        //TODO
    }

}
