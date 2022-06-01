package products.house;

import products.IGuaranteeValue;
import products.Product;

abstract public class houseProducts extends Product implements IGuaranteeValue
{
    private int energy_Usage;
    private boolean garentie;
    private int guaranteeTime;
    private Double guaranteeValue;

    public houseProducts()
    {
        setEarmark(getEarmarkMaker()+1);
        setEarmarkMaker(getEarmarkMaker()+1);
    }
    public String myToString2()
    {
        return energy_Usage+"\n"+garentie+"\n"+guaranteeTime
                +"\n"+guaranteeValue+"\n";
    }

    @Override
    public Double calculateGuaranteeValue()
    {

        return (0.5)*this.getPrice()-this.energy_Usage*(0.04);
    }



    public int getEnergy_Usage() {
        return energy_Usage;
    }

    public boolean getGarentie() {
        return garentie;
    }

    public int getGuaranteeTime() {
        return guaranteeTime;
    }

    public void setGuaranteeTime(int guaranteeTime) {
        this.guaranteeTime = guaranteeTime;
    }

    public Double getGuaranteeValue() {
        return guaranteeValue;
    }

    public void setGuaranteeValue(Double guaranteeValue) {
        this.guaranteeValue = guaranteeValue;
    }

    public void setEnergy_Usage(int energy_Usage) {
        this.energy_Usage = energy_Usage;
    }

    public void setGarentie(boolean garentie) {
        this.garentie = garentie;
    }

    public boolean isGarentie() {
        return garentie;
    }

}