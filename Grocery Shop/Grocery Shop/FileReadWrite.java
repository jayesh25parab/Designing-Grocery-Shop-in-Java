/**
 * Write a description of class Item here.
 * 
 * @author Pratik Garala
 * @version 1.1 22nd Oct,2015
 */
import java.util.*;
import java.io.*;
public class FileReadWrite
{
    /**
     * Constructor for objects of class FileReadWrite
     */
    public FileReadWrite()
    {
        
    }
    
    /**
     * Method readItemsFromFile - for reading items file
     * @Param file name , item collection
     * @return none
    */
    public void readItemsFromFile(String fileName, ItemCollection newItemCollection)
    {
        ArrayList<Item> items;
        Item item;
        try
        {
            FileReader inputFile = new FileReader(fileName);
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine())
            {
                String itemLine = parser.nextLine();
                String[] fields = itemLine.split(",");
                items = newItemCollection.getItemList();
                item = new Item(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]),Integer.parseInt(fields[3]),Integer.parseInt(fields[4]));
                items.add(item);
            }
            inputFile.close();
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(fileName + " not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }
    
    /**
     * Method writeItemsToFile - for writing items file
     * @Param none
     * @return file name , item collection
    */
    public void writeItemsToFile(String fileName, ItemCollection newItemCollection)
    {
        ArrayList<Item> items;
        try
        {
            PrintWriter outputFile = new PrintWriter(fileName);
            items = newItemCollection.getItemList();
            for(Item item : items)
            {
                 outputFile.println(item.getName() + "," + item.getId() + "," + item.getCost() + "," + item.getStockLevel() + "," + item.getDiscount());
            }
            outputFile.close();
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }
    
    /**
     * Method readSupplierFromFile - for reading supplier file
     * @Param file name , supplier collection
     * @return none
    */
    public void readSuppliersFromFile(String fileName, SupplierCollection newSupplierCollection)
    {
        ArrayList<Supplier> suppliers = newSupplierCollection.getSupplierList();;
        Supplier supplier;
        ArrayList<Item> items;
        Item item;
        int index = 0;
        try
        {
            FileReader inputFile = new FileReader(fileName);
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine())
            {
                String supplierLine = parser.nextLine();
                String[] elements = supplierLine.split(",");
                supplier = new Supplier();
                items = new ArrayList<Item>();
                for(index = 0; index < elements.length; index++)
                {
                    switch(index)
                    {
                        case 0:
                            supplier.setName(elements[index]);
                            break;
                        case 1:
                            supplier.setId(Integer.parseInt(elements[index]));
                            break;
                        case 2:
                            supplier.setContactNo(elements[index]);
                            break;
                        default:
                            String itemLine = elements[index];
                            String[] fields = itemLine.split(" ");                            
                            item = new Item(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]),Integer.parseInt(fields[3]),Integer.parseInt(fields[4]));
                            items.add(item);
                            break;
                    }
                }
                supplier.setItems(items); 
                suppliers.add(supplier);
            }
            inputFile.close();
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(fileName + " not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }    
    }
    
    /**
     * Method writeSupplierToFile - for writing supplier file
     * @Param file name , supplier collection
     * @return none
    */
    public void writeSuppliersToFile(String fileName, SupplierCollection newSupplierCollection)
    {
        ArrayList<Supplier> suppliers;
        ArrayList<Item> items;
        int index = 0;
        try
        {
            PrintWriter outputFile = new PrintWriter(fileName);
            suppliers = newSupplierCollection.getSupplierList();
            for(Supplier supplier : suppliers)
            {
                items = supplier.getItems();
                outputFile.print(supplier.getName() + "," + supplier.getId() + "," + supplier.getContactNo() + ",");
                for(Item item : items)
                {
                     index++;
                     outputFile.print(item.getName() + " " + item.getId() + " " + item.getCost() + " " + item.getStockLevel() + " " + item.getDiscount());
                     if (index != items.size())
                        outputFile.print(",");
                }
                index = 0;
                outputFile.println("");
            }
            outputFile.close();
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }
}