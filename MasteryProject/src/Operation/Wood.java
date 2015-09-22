package Operation;

public class Wood extends Flooring {

    public Wood(String productType, double costPerSqFt, double laborPerSqFt, double area) {
        super(productType, costPerSqFt, laborPerSqFt, area);

    }

    @Override
    public double getMaterialCost(double area) {
        
        return costPerSqFt * area;
    }

    @Override
    public double getLaborCost(double area) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public double getTax(double CustomerTaxRate, double laborCost, double materialCost) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getTotal(double materialCost, double laborCost, double tax) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
