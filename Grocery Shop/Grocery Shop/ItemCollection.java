/**
 * Write a description of class Item here.
 * 
 * @author Pratik Garala
 * @version 1.1 22nd Oct,2015
 */
import java.util.*;

public class ItemCollection 
{
    // instance variables
    private ArrayList<Item> itemList;

    /**
     * Constructor for objects of class ItemCollection
     */
    public ItemCollection() 
    {
        itemList= new ArrayList<Item>();
    }

    /**
     * Method getItemList - for getting Item list
     * @Param none
     * @return item list
    */
    public ArrayList<Item> getItemList() 
    {
        return itemList;
    }

    /**
     * Method setItemList - for setting item list
     * @Param item list
     * @return none
    */
    public void setItemList(ArrayList<Item> newItemList) 
    {
        itemList = newItemList;
    }
    
    /**
     * Method addItem - for adding item to item list
     * @Param item
     * @return none
    */
    public void addItem(Item newItem)
    {
        itemList.add(newItem);
    }
    
    /**
     * Method updateItem - for updating item list
     * @Param item
     * @return boolean true if updated/ false if not updated
    */
    public boolean updateItem(Item newItem)
    {        
        for (Item item : itemList)
        {
            if(item.getName().toUpperCase().equals(newItem.getName().toUpperCase()))
            {
                //item.setCost(newItem.getCost());
                item.setStockLevel(newItem.getStockLevel());
                item.setDiscount(newItem.getDiscount());
                return true;
            }
        }
        return false;    
    }
    
    /**
     * Method removeItem - for removing item from item list
     * @Param item name
     * @return boolean true if removed/false if not removed
    */
    public boolean removeItem(int newId)
    {
        for (Item item : itemList)
        {
            if(item.getId() == newId && item.getStockLevel() < 3)
            {
                itemList.remove(item);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method checkName - for checking item name is available in item list
     * @Param item name
     * @return boolean true if exist/ false if not exist
    */
    public boolean checkName(String newName)
    {
        for(Item item : itemList)
        {
            if (item.getName().toUpperCase().equals(newName.toUpperCase()))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method checkId - for checking item id is available in item list
     * @Param item id
     * @return boolean true if exist/ false if not exist
    */
    public boolean checkID(int newId)
    {
        for(Item item : itemList)
        {
            if (item.getId() == newId)
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method getItemByName - for getting item list by name
     * @Param item name
     * @return item list
    */
    public ArrayList<Item> getItemByName(String newName) 
    {
         ArrayList<Item> newItemList = new ArrayList<Item>();
        for(Item item : itemList)
        {
            if  (item.getName().toUpperCase().contains(newName.toUpperCase()))
                newItemList.add(item);
        }
        return newItemList;
    }
    
    /**
     * Method getItemById - for getting item list by id
     * @Param item id
     * @return item list
    */
    public ArrayList<Item> getItemById(int newId) 
    {
        ArrayList<Item> newItemList = new ArrayList<Item>();
        for(Item item : itemList)
        {
            if  (item.getId() == newId)
                 newItemList.add(item);
        }
        return newItemList;
    }
    
    /**
     * Method getItemByCost - for getting item list by cost
     * @Param option and item cost
     * @return item list
    */
    public ArrayList<Item> getItemByCost(int option, int newCost) 
    {
        ArrayList<Item> newItemList = new ArrayList<Item>();
        for(Item item : itemList)
        {
            switch (option)
            {
                case 1:
                    if  (item.getCost() == newCost)
                        newItemList.add(item);
                    break;
                case 2:
                    if  (item.getCost() > newCost)
                        newItemList.add(item);
                    break;
                case 3:
                    if  (item.getCost() < newCost)
                        newItemList.add(item);
                    break;
            }
        }
        return newItemList;
    }
    
    /**
     * Method getItemByStockLevel - for getting item list by stock level
     * @Param option and item stock level
     * @return item list
    */
    public ArrayList<Item> getItemByStockLevel(int option, int newStockLevel) 
    {
        ArrayList<Item> newItemList = new ArrayList<Item>();
        for(Item item : itemList)
        {
            switch (option)
            {
                case 1:
                    if  (item.getStockLevel() == newStockLevel)
                        newItemList.add(item);
                    break;
                case 2:
                    if  (item.getStockLevel() > newStockLevel)
                        newItemList.add(item);
                    break;
                case 3:
                    if  (item.getStockLevel() < newStockLevel)
                        newItemList.add(item);
                    break;
            }
        }
        return newItemList;
    }
    
    /**
     * Method getItemByDiscount - for getting item list by dicount
     * @Param option and item discount
     * @return item list
    */
    public ArrayList<Item> getItemByDiscount(int option, int newDiscount) 
    {
        ArrayList<Item> newItemList = new ArrayList<Item>();
        for(Item item : itemList)
        {
            switch (option)
            {
                case 1:
                    if  (item.getDiscount() == newDiscount)
                        newItemList.add(item);
                    break;
                case 2:
                    if  (item.getDiscount() > newDiscount)
                        newItemList.add(item);
                    break;
                case 3:
                    if  (item.getDiscount() < newDiscount)
                        newItemList.add(item);
                    break;
            }
        }
        return newItemList;
    }
    
    /**
     * Method clearCollection - for clearing item collection
     * @Param none
     * @return none
    */
    public void clearCollection()
    {
        itemList = null;
    }
}