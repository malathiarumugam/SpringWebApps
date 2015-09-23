package Operation;

public class Wood extends Flooring {
    

    public Wood(String productType, double costPerSqFt, double laborPerSqFt, double area) {
        super(productType, costPerSqFt, laborPerSqFt, area);
    }

    @Override
    public double getMaterialCost() {
        return costPerSqFt * area;
    }

    @Override
    public double getLaborCost() {
        return laborPerSqFt * area;
    }

   
    @Override
    public double getTax(double taxRate) {
        return (taxRate / 100) * (costPerSqFt * area);
    }

    @Override
    public double getTotal(double tax) {
        return (costPerSqFt * area) + (laborPerSqFt * area) + ((tax / 100) * (costPerSqFt * area));
    }

}
