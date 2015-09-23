
package Operation;

public abstract class Flooring {
    
    protected String productType;
    protected double costPerSqFt;
    protected double laborPerSqFt;
    protected double area;
    
    private double materialCost;
    private double laborCost;
    private double tax;
    private double total;
    
    public Flooring(String productType, double costPerSqFt, double laborPerSqFt, double area) {
        this.productType = productType;
        this.costPerSqFt = costPerSqFt;
        this.laborPerSqFt = laborPerSqFt;
        this.area = area;
    }

    public abstract double getMaterialCost();
    public abstract double getLaborCost();
    public abstract double getTax(double TaxRate);
    public abstract double getTotal(double tax);

    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return the costPerSqFt
     */
    public double getCostPerSqFt() {
        return costPerSqFt;
    }

    /**
     * @param costPerSqFt the costPerSqFt to set
     */
    public void setCostPerSqFt(double costPerSqFt) {
        this.costPerSqFt = costPerSqFt;
    }

    /**
     * @return the laborPerSqFt
     */
    public double getLaborPerSqFt() {
        return laborPerSqFt;
    }

    /**
     * @param laborPerSqFt the laborPerSqFt to set
     */
    public void setLaborPerSqFt(double laborPerSqFt) {
        this.laborPerSqFt = laborPerSqFt;
    }

    /**
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * @param materialCost the materialCost to set
     */
    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

    /**
     * @param laborCost the laborCost to set
     */
    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(double tax) {
        this.tax = tax;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

}
