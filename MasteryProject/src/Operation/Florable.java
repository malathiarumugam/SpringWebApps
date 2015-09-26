/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operation;

/**
 *
 * @author apprentice
 */
public interface Florable {
     /**
     * @return the productType
     */
    public String getProductType(); 

    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType); 
    

    /**
     * @return the costPerSqFt
     */
    public double getCostPerSqFt(); 
    

    /**
     * @param costPerSqFt the costPerSqFt to set
     */
    public void setCostPerSqFt(double costPerSqFt);
    /**
     * @return the laborPerSqFt
     */
    public double getLaborPerSqFt();

    /**
     * @param laborPerSqFt the laborPerSqFt to set
     */
    public void setLaborPerSqFt(double laborPerSqFt);

    /**
     * @return the area
     */
    public double getArea();

    /**
     * @param area the area to set
     */
    public void setArea(double area);

    /**
     * @param materialCost the materialCost to set
     */
    public void setMaterialCost(double materialCost);
    /**
     * @param laborCost the laborCost to set
     */
    public void setLaborCost(double laborCost);

    /**
     * @param tax the tax to set
     */
    public void setTax(double tax);

    /**
     * @param total the total to set
     */
    public void setTotal(double total);
    
    public double getTotal(double tax);
    
    public double getTax(double TaxRate);
    
    public double getMaterialCost();
    
    public abstract double getLaborCost();
    
}
