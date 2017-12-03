/**
 * Write a description of class Item here.
 * 
 * @author Pratik Garala
 * @version 1.1 22nd Oct,2015
 */
public class Item 
{
    // instance variables
    private String name;
    private int id;
    private int cost;
    private int stockLevel;
    private int discount;

    /**
     * Default Constructor for objects of class Item
     */
    public Item() 
    {
        name = "";
        id = 0;
        cost = 0;
        stockLevel = 0;
        discount = 0;
    }
    
    /**
     * Non Default Constructor for objects of class Item
     * @Param item name, id, cost, stock level and discount
     */
    public Item(String newName, int newId, int newCost, int newStockLevel, int newDiscount)
    {
        name = newName;
        id = newId;
        cost = newCost;
        stockLevel = newStockLevel;
        discount = newDiscount;
    }
    
    /**
     * Method getName - for getting item name
     * @Param none
     * @return item name
    */
    public String getName() 
    {
        return name;
    }

    /**
     * Method setName - for setting item name
     * @Param item name
     * @return none
    */
    public void setName(String newName) 
    {
        name = newName;
    }

    /**
     * Method getId - for getting item id
     * @Param none
     * @return item id
    */
    public int getId() 
    {
        return id;
    }

    /**
     * Method setId - for setting item Id
     * @Param item Id
     * @return none
    */
    public void setId(int newId) 
    {
        id = newId;
    }

    /**
     * Method getCost - for getting item cost
     * @Param none
     * @return item cost
    */
    public int getCost() 
    {
        return cost;
    }

    /**
     * Method setCost - for setting item cost
     * @Param item cost
     * @return none
    */
    public void setCost(int newCost) 
    {
        cost = newCost;
    }

    /**
     * Method getStockLevel - for getting item stock level
     * @Param none
     * @return item stock level
    */
    public int getStockLevel() 
    {
        return stockLevel;
    }

    /**
     * Method setStockLevel - for setting item stock level
     * @Param item stock level
     * @return none
    */
    public void setStockLevel(int newStockLevel) 
    {
        stockLevel = newStockLevel;
    }

    /**
     * Method getDiscount - for getting item discount
     * @Param none
     * @return item discount
    */
    public int getDiscount() 
    {
        return discount;
    }

    /**
     * Method setDiscount - for setting item discount
     * @Param item discount
     * @return none
    */
    public void setDiscount(int newDiscount) 
    {
        discount = newDiscount;
    }

}