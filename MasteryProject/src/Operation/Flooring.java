
package Operation;

public abstract class Flooring {
    
    private String productType;
    private double costPerSqFt;
    private double laborPerSqFt;
    private double area;
    
    public Flooring(String productType, double costPerSqFt, double laborPerSqFt, double area) {
        this.productType = productType;
        this.costPerSqFt = costPerSqFt;
        this.laborPerSqFt = laborPerSqFt;
        this.area = area;
    }

    public abstract double getMaterialCost(double area);
    public abstract double getLaborCost(double area);
    public abstract double getTax(double CustomerTaxRate, double laborCost, double materialCost);
    public abstract double getTotal(double materialCost, double laborCost, double tax);

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

}
