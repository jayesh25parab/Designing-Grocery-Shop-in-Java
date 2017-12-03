/**
 * Write a description of class Item here.
 * 
 * @author Pratik Garala
 * @version 1.1 22nd Oct,2015
 */
import java.util.*;
public class SupplierCollection
{
    private ArrayList<Supplier> supplierList;

    /**
     * Constructor for objects of class SupplierCollection
     */
    public SupplierCollection()
    {
        supplierList = new ArrayList<Supplier>();
    }
    
    /**
     * Method getSupplierList - for getting supplier list
     * @Param none
     * @return supplier list
    */
    public ArrayList<Supplier> getSupplierList() {
        return supplierList;
    }

    /**
     * Method setSupplierList - for setting supplier list
     * @Param supplier list
     * @return none
    */
    public void setItemList(ArrayList<Supplier> newSupplierList) {
        supplierList = newSupplierList;
    }
    
    /**
     * Method checkName - for checking supplier name is available in supplier list
     * @Param supplier name
     * @return boolean true if exist/ false if not exist
    */
    public boolean checkName(String newName)
    {
        for(Supplier supplier : supplierList)
        {
            if (supplier.getName().toUpperCase().equals(newName.toUpperCase()))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method checkId - for checking supplier id is available in supplier list
     * @Param supplier id
     * @return boolean true if exist/ false if not exist
    */
    public boolean checkID(int newId)
    {
        for(Supplier supplier : supplierList)
        {
            if (supplier.getId() == newId)
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method addItem - for adding supplier to supplier list
     * @Param supplier 
     * @return none
    */
    public void addItem(Supplier newSupplier)
    {
        supplierList.add(newSupplier);
    }
    
     /**
     * Method getSupplierByName - for getting supplier list by name
     * @Param supplier name
     * @return supplier list
    */
    public ArrayList<Supplier> getSupplierByName(String newName) 
    {
         ArrayList<Supplier> newSupplierList = new ArrayList<Supplier>();
        for(Supplier supplier : supplierList)
        {
            if  (supplier.getName().toUpperCase().contains(newName.toUpperCase()))
                newSupplierList.add(supplier);
        }
        return newSupplierList;
    }
    
    /**
     * Method updateSupplier - for updating supplier list
     * @Param supplier
     * @return boolean true if updated/ false if not updated
    */
    public boolean updateSupplier(Supplier newSupplier)
    {
        
        for (Supplier supplier : supplierList)
        {
            if(supplier.getName().toUpperCase().equals(newSupplier.getName().toUpperCase()))
            {
                //item.setCost(newItem.getCost());
                supplier.setName(newSupplier.getName());
                
                for (Item item : supplier.getItems())
                {
                    for(Item newItem : newSupplier.getItems())
                    {
                        if(item.getName().toUpperCase().equals(newItem.getName().toUpperCase()))
                        {
                            item.setStockLevel(newItem.getStockLevel());
                            item.setDiscount(newItem.getDiscount());
                        }
                    }
                }
                return true;
            }
        }
        return false;    
    }
    
    /**
     * Method removeSupplier - for removing supplier from supplier list
     * @Param supplier name
     * @return boolean true if removed/false if not removed
    */
    public boolean removeSupplier(String newName)
    {
        for (Supplier supplier : supplierList)
        {
            if(supplier.getName().toUpperCase().equals(newName.toUpperCase()))
            {
                supplierList.remove(supplier);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method clearCollection - for clearing supplier collection
     * @Param none
     * @return none
    */
    public void clearCollection()
    {
        supplierList = null;
    }
}

