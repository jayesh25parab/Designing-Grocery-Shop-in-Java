
/**
 * Write a description of class Item here.
 * 
 * @author Pratik Garala
 * @version 1.1 22nd Oct,2015
 */

import java.io.*;
import java.util.*;

public class GroceryShop 
{
    // instance variables
    private ItemCollection itemCollection;
    private SupplierCollection supplierCollection;
    
    /**
     * Constructor for objects of class GroceryShop
     */
    public GroceryShop() 
    {
        itemCollection = new ItemCollection();
        supplierCollection = new SupplierCollection();
    } 
    
    /**
     * Method openShop - for start point for application
     * @Param none
     * @return none
    */
    public void openShop()
    {
        //Indicate whether user wants to Exit the shop or not
        boolean isExit = false;
        int option = 0;
        int supplierOption = 0;
        
        readFile();
        while (!isExit)
        {
            option = menuOptions();
            if (option != 0)
            {            
                switch (option)
                {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        listItems();
                        break;
                    case 3:
                        updateItem();
                        break;
                    case 4:
                        removeItem();
                        break;
                    case 5:
                        displayHelp();
                        break;
                    case 6:
                        fileWrite();
                        exitShop();
                        isExit = true;
                        break;
                    case 7:
                        supplierList();
                        break;
                    default:
                        System.out.println("Please choose the valid option..!!");
                        System.out.println("");
                        break;
                }
            }
        }
    }
    
    /**
     * Method readFile - for reading files of item list and supplier list
     * @Param none
     * @return none
    */
    public void readFile()
    {
        itemCollection = new ItemCollection();
        supplierCollection = new SupplierCollection();
        String itemListFileName = "items.txt";
        String supplierListFileName = "suppliers.txt";
        FileReadWrite fileReader = new FileReadWrite();
        fileReader.readItemsFromFile(itemListFileName,itemCollection);
        fileReader.readSuppliersFromFile(supplierListFileName, supplierCollection);
    }
    
    /**
     * Method menuOption - for displying all the main menu options
     * @Param none
     * @return selected option
    */
    public int menuOptions()
    {   
        int option = 0;
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the My Grocery Shop");
        System.out.println("==============================");
        System.out.println("(1) Add Items");
        System.out.println("(2) List Items");
        System.out.println("(3) Update Items");
        System.out.println("(4) Remove Items");
        System.out.println("(5) Display Help");
        System.out.println("(6) Exit Shop");
        System.out.println("(7) Suppliers");
        System.out.print("Choose an option : ");
        
        try
        {
            option = Integer.parseInt(console.nextLine());
            System.out.println("");
            System.out.print("\f");
            return option;
        }
        catch(Exception e)
        {
            System.out.println("");
            System.out.println("Please choose the valid option..!!");
            System.out.println("");
            option = 0;
            return option;
        }
    }

    /**
     * Method addItem - for adding a new item to item collection
     * @Param none
     * @return none
    */
    public void addItem()
    {
        String name = "";
        int id = 0;
        int cost = 0;
        int stockLevel = 0;
        int discount = 0;
        boolean isEqual = false;
        Scanner console = new Scanner(System.in);
        
        try
        {
            System.out.print("Enter item name :  ");
            name = console.nextLine();
            if (name.trim().length() == 0)
                throw new Exception();
            isEqual = itemCollection.checkName(name);
            if (isEqual)
            {
                System.out.println("Name " + name + " is already exist in the item collection..!!");
                throw new Exception();
            }
            
            System.out.print("Enter unique ID : ");
            id = Integer.parseInt(console.nextLine());
            if (id < 1 || id > 1000)
                throw new Exception();      
            isEqual = itemCollection.checkID(id);            
            if (isEqual)
            {
                System.out.println("ID " + id + " is already exist in the item collection..!!");
                throw new Exception();
            }
            
            System.out.print("Enter cost : ");
            cost = Integer.parseInt(console.nextLine());
            if (cost < 0)
                throw new Exception();  
            
            System.out.print("Enter stock level : ");
            stockLevel = Integer.parseInt(console.nextLine());
            if (stockLevel < 0 || stockLevel > 1000)
                throw new Exception();       
            System.out.println("");
            
            if (stockLevel >= 0 && stockLevel <= 10)
                discount = 0;
            else if(stockLevel >= 11 && stockLevel <= 20)
                discount = 10;
            else
                discount = 20;
            
            Item item = new Item(name, id, cost, stockLevel, discount);
            itemCollection.addItem(item);
            System.out.print("\f");
            System.out.println("Item: " + name + " ID: " + id + " Cost: " + cost + " Stock Level: " + stockLevel + " has been successfully added..!!" );
            System.out.println();
        }
        catch(Exception e)
        {
            System.out.println("Please enter valid details..!!");
            System.out.println("");
        }
    }
    
    /**
     * Method listItems - for listing items based on selected option (all, by name, by id, by cost, by stock level, by discount)
     * @Param none
     * @return none
    */
    public void listItems()
    {   
        int subOption = 0;
        // to check whether user has given wrong input or not
        boolean isNotError = false;
        
        while (!isNotError)
        {
            subOption = listOptions();
            switch (subOption)
            {
                case 1:
                    listAllItems();
                    isNotError = true;
                    break;
                case 2:
                    listByItemName();
                    isNotError = true;
                    break;
                case 3:
                    listById();
                    isNotError = true;
                    break;
                case 4:
                    listByCost();
                    isNotError = true;
                    break;
                case 5:
                    listByStockLevel();
                    isNotError = true;
                    break;
                case 6:
                    listByDiscount();
                    isNotError = true;
                    break;
                default:
                    System.out.println("Please Choode the valid option..!!");
                    
            }
        }
    }
    
    /**
     * Method updateItem - for updating item available in item collection
     * @Param none
     * @return none
    */
    public void updateItem()
    {
        String name = "";
        int id = 0;
        int cost = 0;
        int stockLevel = 0;
        int discount = 0;
        boolean isUpdated = false;
        boolean isEqual = false;
        Scanner console = new Scanner(System.in);
        
        try
        {
            System.out.print("Enter item name : ");
            name = console.nextLine();
            if (name.trim().length() == 0)
                throw new Exception();
            isEqual = itemCollection.checkName(name);
            if (!isEqual)
            {
                System.out.println("Name " + name + " is not exist in the item collection..!!");
                throw new Exception();
            }        
          
            System.out.print("Enter stock level : ");
            stockLevel = Integer.parseInt(console.nextLine());
            if (stockLevel <= 0)
                throw new Exception();
            System.out.println("");
            
            if (stockLevel >=0 && stockLevel <= 10)
                discount = 0;
            else if(stockLevel >=11 && stockLevel <= 20)
                discount = 10;
            else if (stockLevel >= 21)
                discount = 20;
            else
                discount = 0;
            
            Item item = new Item(name, id, cost, stockLevel, discount);
            isUpdated = itemCollection.updateItem(item);
            
            if  (isUpdated)
            {
                System.out.print("\f");
                System.out.println("Item " + name + " is updated successfully.");
            }
        }
        catch(Exception e)
        {
                System.out.println("Please enter valid details..!!");
                System.out.println("");
        }
    }
    
    /**
     * Method removeItem - for removing item which has stock level is less than 3 
     * @Param none
     * @return none
    */
    public void removeItem()
    {
        int id = 0;
        boolean isRemoved = false;
        boolean isEqual = false;
        Scanner console = new Scanner(System.in);
        
        try
        {              
            System.out.print("Enter unique ID : ");
            id = Integer.parseInt(console.nextLine());
            if (id < 1 || id > 1000)
                throw new Exception();
            isEqual = itemCollection.checkID(id);            
            if (!isEqual)
            {
                System.out.println("ID " + id + " is not exist in the item collection..!!");
                throw new Exception();
            }
            
            isRemoved = itemCollection.removeItem(id);
            if  (isRemoved)
            {
                System.out.println("\f");
                System.out.println("ID " + id + "is successfully removed..!!");
                System.out.println("");
            }
        }
        catch(Exception e)
        {
                System.out.println("Please enter valid details..!!");
                System.out.println("");
        }
    }
    
    /**
     * Method displayHelp - for displying help
     * @Param none
     * @return none
    */
    public void displayHelp()
    {
        System.out.println("Information fnding for option (1)");
        System.out.println("Using Option (1) a new item can be added to shop ");
        System.out.println("Item name, Item Id, Cost of Item, Count of items added, Discount on item");
        System.out.println(" ");
        System.out.println("Information about option (2)");
        System.out.println("Using Option (2) items can be listed by searching a particular type");
        System.out.println("You can list item by Name, Stock-Level or Discount");
        System.out.println(" ");
        System.out.println("Information about option (3)");
        System.out.println("Using Option (3) items can be updated");
        System.out.println("Then enter the updated information for the ID");
        System.out.println("Information must contain Cost of Item, Count of items added, Discount on item");
        System.out.println(" ");
        System.out.println(" Informaton for Option (4)");
        System.out.println("Using Option (4) items could be removed");
        System.out.println("Item ID of item whose information you need to delete");
        System.out.println("The item will be deleted");
        System.out.println(" ");
    }
    
    /**
     * Method exitShop - for doing exit time activities
     * @Param none
     * @return none
    */
    public void exitShop()
    {
        itemCollection.clearCollection();
        itemCollection = null;
        supplierCollection.clearCollection();
        supplierCollection = null;
    }
    
    /**
     * Method listOption - for displaying all the list suboptions 
     * @Param none
     * @return selected suboption
    */
    public int listOptions()
    {
        int subOption = 0;
        Scanner console = new Scanner(System.in);
        
        System.out.println("(1) List all the items");
        System.out.println("(2) List by item name");
        System.out.println("(3) List by item id");
        System.out.println("(4) List by cost");
        System.out.println("(5) List by stock level");
        System.out.println("(6) List by discount");
        System.out.print("Choose an option : ");
        
        try
        {
            subOption = Integer.parseInt(console.nextLine());
            System.out.print("\f");
            return subOption;
        }
        catch(Exception e)
        {
            System.out.println("");
            subOption = 0;
            return subOption;
        }
    }
    
    /**
     * Method listAllItems - for displaying all the items available in item collection
     * @Param none
     * @return none
    */
    public void listAllItems()
    {
        ArrayList<Item> items = itemCollection.getItemList();
        
        System.out.println("List of all the items..!!");
        System.out.println("==============================================");
        System.out.println("Item Name, Item ID, Cost, StockLevel, Discount");
        System.out.println("==============================================");
        for(Item item : items)
        {
            System.out.println(item.getName() + ", " + item.getId() + ", " + item.getCost() + ", " + item.getStockLevel() + ", " + item.getDiscount());
        }
        System.out.println("");
    }
    
    /**
     * Method listByItemName - for displaying all the items, available in item collection, by its name
     * @Param none
     * @return none
    */
    public void listByItemName()
    {
        String name = "";
        ArrayList<Item> items;
        Scanner console = new Scanner(System.in);
        
        try
        {
            System.out.print("Enter item name :  ");
            name = console.nextLine();
            if (name.trim().length() == 0)
                throw new Exception();
            System.out.println("");    
            
            items = itemCollection.getItemByName(name);
            System.out.println("List of all the items by Item Name with '" + name + "'..!!");
            System.out.println("==============================================");
            System.out.println("Item Name, Item ID, Cost, StockLevel, Discount");
            System.out.println("==============================================");
            for(Item item : items)
            {
                    System.out.println(item.getName() + ", " + item.getId() + ", " + item.getCost() + ", " + item.getStockLevel() + ", " + item.getDiscount());
            }
            System.out.println("");    
        }
        catch(Exception e)
        {
                console.nextLine();
                System.out.println("Please enter valid item name..!!");
                System.out.println("");
        }
    }
    
    /**
     * Method listById - for displaying all the items, available in item collection, by its id
     * @Param none
     * @return none
    */
    public void listById()
    {
        int id = 0;
        ArrayList<Item> items = itemCollection.getItemList();
        Scanner console = new Scanner(System.in);
        
        try
        {       
            System.out.print("Enter unique ID : ");
            id = Integer.parseInt(console.nextLine());
            if (id < 1 || id > 1000)
                throw new Exception();
            System.out.println("");
            items = itemCollection.getItemById(id);
            System.out.println("List of all the items by Item ID '" + id + "'..!!");
            System.out.println("==============================================");
            System.out.println("Item Name, Item ID, Cost, StockLevel, Discount");
            System.out.println("==============================================");
            for(Item item : items)
            {
                System.out.println(item.getName() + ", " + item.getId() + ", " + item.getCost() + ", " + item.getStockLevel() + ", " + item.getDiscount());
            }
            System.out.println("");
        }
        catch(Exception e)
        {
                System.out.println("Please enter valid ID..!!");
                System.out.println("");
        }
    }
    
    /**
     * Method listByCost - for displaying all the items, available in item collection, by its cost
     * @Param none
     * @return none
    */
    public void listByCost()
    {
        int cost = 0;
        int subOption = 0;
        ArrayList<Item> items = itemCollection.getItemList();
        Scanner console = new Scanner(System.in);
        
        try
        {   
            System.out.print("Enter cost : ");
            cost = Integer.parseInt(console.nextLine());
            if (cost < 0)
                throw new Exception();
            System.out.println("");
            
            subOption = moreOption("Cost",cost); 
            System.out.println("List of all the items by Item Cost '" + cost + "'..!!");
            System.out.println("==============================================");
            System.out.println("Item Name, Item ID, Cost, StockLevel, Discount");
            System.out.println("==============================================");            
            items = itemCollection.getItemByCost(subOption,cost);
            for(Item item : items)
            {
                System.out.println(item.getName() + ", " + item.getId() + ", " + item.getCost() + ", " + item.getStockLevel() + ", " + item.getDiscount());
            }
            System.out.println("");
        }
        catch(Exception e)
        {
                System.out.println("Please enter valid cost..!!");
                System.out.println("");
        }
    }
    
    /**
     * Method listByStockLevel - for displaying all the items, available in item collection, by its stock level
     * @Param none
     * @return none
    */
    public void listByStockLevel()
    {
        int stockLevel = 0;
        int subOption = 0;
        ArrayList<Item> items = itemCollection.getItemList();
        Scanner console = new Scanner(System.in);
        
        try
        {   
            System.out.print("Enter stock level : ");
            stockLevel = Integer.parseInt(console.nextLine());
            if (stockLevel < 0 || stockLevel > 1000)
                throw new Exception();
            System.out.println("");
            
            subOption = moreOption("Stock Level",stockLevel);
            System.out.println("List of all the items by stock level '" + stockLevel + "'..!!");
            System.out.println("==============================================");
            System.out.println("Item Name, Item ID, Cost, StockLevel, Discount");
            System.out.println("==============================================");  
            items = itemCollection.getItemByStockLevel(subOption,stockLevel);
            for(Item item : items)
            {
                System.out.println(item.getName() + ", " + item.getId() + ", " + item.getCost() + ", " + item.getStockLevel() + ", " + item.getDiscount());
            }
            System.out.println("");
        }
        catch(Exception e)
        {
                System.out.println("Please enter valid Stock Level..!!");
                System.out.println("");
        }
    }
    
    /**
     * Method listByDiscount - for displaying all the items, available in item collection, by its discount
     * @Param none
     * @return none
    */
    public void listByDiscount()
    {
        int discount;
        int subOption;
        ArrayList<Item> items = itemCollection.getItemList();
        Scanner console = new Scanner(System.in);
        
        try
        {               
            System.out.print("Enter discount : ");
            discount = console.nextInt();
            if (discount <= 0)
                throw new Exception();
            console.nextLine();    
            System.out.println("");            
            subOption = moreOption("Discount",discount);
            
            items = itemCollection.getItemByDiscount(subOption,discount);
            System.out.println("List of all the items by discount '" + discount + "'..!!");
            System.out.println("==============================================");
            System.out.println("Item Name, Item ID, Cost, StockLevel, Discount");
            System.out.println("==============================================");  
            for(Item item : items)
            {
                System.out.println(item.getName() + ", " + item.getId() + ", " + item.getCost() + ", " + item.getStockLevel() + ", " + item.getDiscount());
            }
            System.out.println("");
        }
        catch(Exception e)
        {
                console.nextLine();
                System.out.println("Please enter valid discount..!!");
                System.out.println("");
        }
    }
    
    /**
     * Method fileWrite - for writing to files of item list and supplier list
     * @Param none
     * @return none
    */
    public void fileWrite()
    {
        String itemListFileName = "items.txt";
        String supplierListFileName = "suppliers.txt";
        FileReadWrite fileWriter = new FileReadWrite();
        fileWriter.writeItemsToFile(itemListFileName,itemCollection);
        fileWriter.writeSuppliersToFile(supplierListFileName,supplierCollection);
    }
    
    /**
     * Method moreOption - for displaying more suboptions for List by cost, list by stock level, list discount
     * @Param none
     * @return selected suboption
    */
    public int moreOption(String key, int value)
    {
       boolean isNotError = false; 
       int subOption = 0;
       Scanner console = new Scanner(System.in);
       
       while(!isNotError)
       {
            System.out.println("Please select appropriate option..!!");
            System.out.println("(1) List of items where " + key +" is " + value);
            System.out.println("(2) List of items where " + key + " is greater than " + value);
            System.out.println("(3) List of items where " + key + " is less than " + value);
            System.out.print("Choose an option : ");
            try
            {
                subOption = Integer.parseInt(console.nextLine());
                System.out.print("\f");
                isNotError = true;
                return subOption;
            }
            catch(Exception e)
            {
                System.out.println("");
                subOption = 0;
                return subOption;
            }
       }
       return subOption;
    }
    
    /**
     * Method supplierList - for displaying supplier's related details 
     * @Param none
     * @return none
    */
    public void supplierList()
    {
        boolean isBack = false;
        int option = 0;
        while(!isBack)
        {
            option = supplierMenuOptions();
            switch (option)
            {
                case 1:
                    addSupplier();
                    break;
                case 2:
                    listSupplier();
                    break;
                case 3:
                    updateSupplier();
                    break;
                case 4:
                    removeSupplier();
                    break;
                case 5:
                    isBack = true;    
                    break;
            }
        }
        
    }
    
    /**
     * Method supplierMenuOptions - for displaying supplier's menu option
     * @Param none
     * @return selected option
    */
    public int supplierMenuOptions()
    {
        int option = 0;
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the My Grocery Shop");
        System.out.println("==============================");
        System.out.println("(1) Add Supplier");
        System.out.println("(2) List Supplier");
        System.out.println("(3) Update Supplier");
        System.out.println("(4) Remove Supplier");
        System.out.println("(5) Back");
        System.out.print("Choose an option : ");
        
        try
        {
            option = Integer.parseInt(console.nextLine());
            System.out.println("");
            System.out.print("\f");
            return option;
        }
        catch(Exception e)
        {
            System.out.println("");
            System.out.println("Please choose the valid option..!!");
            System.out.println("");
            option = 0;
            return option;
        }
    }
    
    /**
     * Method addSupplier - for adding a supplier to supplier collection
     * @Param none
     * @return none
    */
    public void addSupplier()
    {
        Supplier supplier = new Supplier();
        Scanner console = new Scanner(System.in);
        String supplierName = "";
        ItemCollection items = new ItemCollection();
        int supplierId = 0;
        String contactNo = "";
        boolean isEqual = false;
        int noOfItem = 0;
        String name = "";
        int id = 0;
        int cost = 0;
        int stockLevel = 0;
        int discount = 0;
        
        try
        {
            System.out.print("Please enter supplier name :  ");
            supplierName = console.nextLine();
            if (supplierName.trim().length() == 0)
                throw new Exception();
            isEqual = supplierCollection.checkName(supplierName);
            if (isEqual)
            {
                System.out.println("Name " + supplierName + " is already exist in supplier's collection..!!");
                throw new Exception();
            }
            
            System.out.print("Enter unique supplier ID : ");
            supplierId = Integer.parseInt(console.nextLine());
            if (supplierId < 1 || supplierId > 1000)
                throw new Exception();      
            isEqual = supplierCollection.checkID(id);            
            if (isEqual)
            {
                System.out.println("ID " + id + " is already exist in the item collection..!!");
                throw new Exception();
            }
            
            System.out.print("Enter Contact Number : ");
            contactNo = console.nextLine();
            if (contactNo.trim().length() == 0 || contactNo.trim().length() > 10)
                throw new Exception();  
            
            System.out.print("Enter number of items you want to enter : ");
            noOfItem = Integer.parseInt(console.nextLine());
            if (noOfItem < 0)
                throw new Exception();      
            
            while ( noOfItem != 0 )
            {
                noOfItem--;
                System.out.print("Enter item name :  ");
                name = console.nextLine();
                if (name.trim().length() == 0)
                    throw new Exception();
                isEqual = items.checkName(name);
                if (isEqual)
                {
                    System.out.println("Name " + name + " is already exist in the item collection..!!");
                    throw new Exception();
                }
                
                System.out.print("Enter unique ID : ");
                id = Integer.parseInt(console.nextLine());
                if (id < 1 || id > 1000)
                    throw new Exception();      
                isEqual = items.checkID(id);            
                if (isEqual)
                {
                    System.out.println("ID " + id + " is already exist in the item collection..!!");
                    throw new Exception();
                }
                
                System.out.print("Enter cost : ");
                cost = Integer.parseInt(console.nextLine());
                if (cost < 0)
                    throw new Exception();  
                
                System.out.print("Enter stock level : ");
                stockLevel = Integer.parseInt(console.nextLine());
                if (stockLevel < 0 || stockLevel > 1000)
                    throw new Exception();       
                System.out.println("");
                
                if (stockLevel >= 0 && stockLevel <= 10)
                    discount = 0;
                else if(stockLevel >= 11 && stockLevel <= 20)
                    discount = 10;
                else
                    discount = 20;
                
                Item item = new Item(name, id, cost, stockLevel, discount);
                items.addItem(item);
                System.out.print("\f");
                System.out.println("Item: " + name + " ID: " + id + " Cost: " + cost + " Stock Level: " + stockLevel + " has been successfully added..!!" );
                System.out.println();    
            }
            supplier.setName(supplierName);
            supplier.setId(id);
            supplier.setContactNo(contactNo);
            supplier.setItems(items.getItemList());
            supplierCollection.addItem(supplier);
            System.out.print("\f");
            System.out.println("Supplier " + supplierName + " has been successfully added..!!" );
            System.out.println();
        }
        catch(Exception e)
        {
            System.out.println("Please enter valid details..!!");
            System.out.println("");
        }
    }
    
    /**
     * Method listSupplier - for displaying supplier's based on selected options (all, by name)
     * @Param none
     * @return none
    */
    public void listSupplier()
    {
        int subOption = 0;
        // to check whether user has given wrong input or not
        boolean isNotError = false;
        
        while (!isNotError)
        {
            subOption = supplierListOptions();
            switch (subOption)
            {
                case 1:
                    listAllSuppliers();
                    isNotError = true;
                    break;
                case 2:
                    listBySupplierName();
                    isNotError = true;
                    break;
                default:
                    System.out.println("Please Choode the valid option..!!");
                    
            }
        }
    }
    
    /**
     * Method updateSupplier - for updating existing supplier to supplier collection
     * @Param none
     * @return none
    */
    public void updateSupplier()
    {
        String supplierName = "";
        int supplierId = 0;
        String contactNo = "";
        int noOfItem = 0;
        String name = "";
        int id = 0;
        int cost = 0;
        int stockLevel = 0;
        int discount = 0;
        boolean isUpdated = false;
        boolean isEqual = false;
        Scanner console = new Scanner(System.in);
        ItemCollection items = new ItemCollection(); 
        
        try
        {
            System.out.print("Please enter supplier name :  ");
            supplierName = console.nextLine();
            if (supplierName.trim().length() == 0)
                throw new Exception();
            isEqual = supplierCollection.checkName(supplierName);
            if (!isEqual)
            {
                System.out.println("Name " + supplierName + " is not exist in supplier's collection..!!");
                throw new Exception();
            }
            
            System.out.print("Enter number of items you want to enter : ");
            noOfItem = Integer.parseInt(console.nextLine());
            if (noOfItem < 0)
                throw new Exception();      
               
            while ( noOfItem != 0 )
            {
                noOfItem--;
                System.out.print("Enter item name : ");
                name = console.nextLine();
                if (name.trim().length() == 0)
                    throw new Exception();
                isEqual = items.checkName(name);  
                
                System.out.print("Enter stock level : ");
                stockLevel = Integer.parseInt(console.nextLine());
                if (stockLevel <= 0)
                    throw new Exception();
                System.out.println("");
                
                if (stockLevel >=0 && stockLevel <= 10)
                    discount = 0;
                else if(stockLevel >=11 && stockLevel <= 20)
                    discount = 10;
                else if (stockLevel >= 21)
                    discount = 20;
                else
                    discount = 0;
                
                Item item = new Item(name, id, cost, stockLevel, discount);
                items.addItem(item);
                 
            }
            Supplier supplier = new Supplier();
            supplier.setName(supplierName);
            supplier.setId(supplierId);
            supplier.setContactNo(contactNo);
            supplier.setItems(items.getItemList());
            
            isUpdated = supplierCollection.updateSupplier(supplier);
            
            if  (isUpdated)
            {
                System.out.print("\f");
                System.out.println("Supplier " + supplierName + " is updated successfully.");
            }
        }
        catch(Exception e)
        {
                System.out.println("Please enter valid details..!!");
                System.out.println("");
        }    
    }
    
    /**
     * Method removeSupplier - for removing existing supplier from supplier collection
     * @Param none
     * @return none
    */
    public void removeSupplier()
    {
        String supplierName = "";
        boolean isRemoved = false;
        boolean isEqual = false;
        Scanner console = new Scanner(System.in);
        
        try
        {              
            System.out.print("Please enter supplier name :  ");
            supplierName = console.nextLine();
            if (supplierName.trim().length() == 0)
                throw new Exception();
            isEqual = supplierCollection.checkName(supplierName);
            if (!isEqual)
            {
                System.out.println("Name " + supplierName + " is not exist in supplier's collection..!!");
                throw new Exception();
            }
            
            isRemoved = supplierCollection.removeSupplier(supplierName);
            if  (isRemoved)
            {
                System.out.print("\f");
                System.out.println("Supplier " + supplierName + " is successfully removed..!!");
                System.out.println("");
            }
        }
        catch(Exception e)
        {
                System.out.println("Please enter valid details..!!");
                System.out.println("");
        }
    }
    
    /**
     * Method supplierListOptions - for displying supplier list suboption
     * @Param none
     * @return selected suboption
    */
    public int supplierListOptions()
    {
        int subOption = 0;
        Scanner console = new Scanner(System.in);
        
        System.out.println("(1) List all the suppliers");
        System.out.println("(2) List by supplier name");
        System.out.print("Choose an option : ");
        
        try
        {
            subOption = Integer.parseInt(console.nextLine());
            System.out.print("\f");
            return subOption;
        }
        catch(Exception e)
        {
            System.out.println("");
            subOption = 0;
            return subOption;
        }
    }
    
    /**
     * Method listAllSupplier - for list all existing supplier from supplier collection
     * @Param none
     * @return none
    */
    public void listAllSuppliers()
    {
        ArrayList<Supplier> suppliers = supplierCollection.getSupplierList();
        
        for(Supplier supplier : suppliers)
        {
            System.out.println("Supplier Name : " + supplier.getName());
            System.out.println("Supplier ID : " + supplier.getId());
            System.out.println("Contact Number : " + supplier.getContactNo());
            
            ArrayList<Item> items = supplier.getItems();
            System.out.println("List of all the items..!!");
            System.out.println("==============================================");
            System.out.println("Item Name, Item ID, Cost, StockLevel, Discount");
            System.out.println("==============================================");
            for(Item item : items)
            {
                System.out.println(item.getName() + ", " + item.getId() + ", " + item.getCost() + ", " + item.getStockLevel() + ", " + item.getDiscount());
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    /**
     * Method listBySupplierName - for list all existing supplier from supplier collection by their name
     * @Param none
     * @return none
    */
    public void listBySupplierName()
    {
        String name = "";
        ArrayList<Supplier> suppliers;
        Scanner console = new Scanner(System.in);
        
        try
        {
            System.out.print("Enter supplier name :  ");
            name = console.nextLine();
            if (name.trim().length() == 0)
                throw new Exception();
            System.out.println("");    
            
            suppliers = supplierCollection.getSupplierByName(name);
            for(Supplier supplier : suppliers)
            {
                System.out.println("Supplier Name : " + supplier.getName());
                System.out.println("Supplier ID : " + supplier.getId());
                System.out.println("Contact Number : " + supplier.getContactNo());
                
                ArrayList<Item> items = supplier.getItems();
                System.out.println("List of all the items..!!");
                System.out.println("==============================================");
                System.out.println("Item Name, Item ID, Cost, StockLevel, Discount");
                System.out.println("==============================================");
                for(Item item : items)
                {
                    System.out.println(item.getName() + ", " + item.getId() + ", " + item.getCost() + ", " + item.getStockLevel() + ", " + item.getDiscount());
                }
                System.out.println("");
            }
            System.out.println("");    
        }
        catch(Exception e)
        {
                console.nextLine();
                System.out.println("Please enter valid item name..!!");
                System.out.println("");
        }
    }
    
}