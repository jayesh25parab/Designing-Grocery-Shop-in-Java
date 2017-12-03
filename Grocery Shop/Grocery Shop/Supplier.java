/**
 * Write a description of class Item here.
 * 
 * @author Pratik Garala
 * @version 1.1 22nd Oct,2015
 */
import java.util.*;

public class Supplier
{
    // instance variables
    private String name;
    private int id;
    private String contactNo;
    private ArrayList<Item> items;

    /**
     * Default Constructor for objects of class Supplier
     */
    public Supplier()
    {
        name = "";
        id = 0;
        contactNo = "";
        items = new ArrayList<Item>();
    }

    /**
     * Method setName - for setting supplier's name
     * @Param supplier's name
     * @return none
    */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * Method getName - for getting supplier's name
     * @Param none
     * @return supplier's name
    */
    public String getName()
    {
        return name;
    }
    
    /**
     * Method setId - for setting supplier's ID
     * @Param supplier's ID
     * @return none
    */
    public void setId(int newId)
    {
        id = newId;
    }
    
    /**
     * Method getId - for getting supplier's Id
     * @Param none
     * @return supplier's Id
    */
    public int getId()
    {
        return id;
    }
    
    /**
     * Method setContactNo - for setting supplier's Contact Number
     * @Param supplier's conatct Number
     * @return none
    */
    public void setContactNo(String newContactNo)
    {
        contactNo = newContactNo;
    }
    
    /**
     * Method getName - for getting supplier's contact number
     * @Param none
     * @return supplier's contact number
    */
    public String getContactNo()
    {
        return contactNo;
    }
    
    /**
     * Method setItems - for setting supplier's item list
     * @Param supplier's item list
     * @return none
    */
    public void setItems(ArrayList<Item> newItems) {
        items = newItems;
    }
    
    /**
     * Method getName - for getting supplier's item list
     * @Param none
     * @return supplier's item list
    */
    public ArrayList<Item> getItems() {
        return items;
    }
}
