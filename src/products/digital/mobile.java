package products.digital;

import saleing.IDiscountFeature;

public class mobile extends digitalProduct implements IDiscountFeature
{
    private int SIM_num;
    private String cameraQuantity;



    public mobile()
    {
        setEarmark(getEarmarkMaker()+1);
        setEarmarkMaker(getEarmarkMaker()+1);
        setCategory_model("digitalProduct_mobile");
    }

    public String myToString3()
    {
        return Integer.toString(SIM_num)+"\n"+cameraQuantity+"\n";
    }

    @Override
    public void readingFromFile(String[] info) {
        setName(info[0]);
        setBrand(info[1]);
        setPrice(Integer.parseInt(info[2]));
        setInStock(Integer.parseInt(info[3]));
        setEarmark(Integer.parseInt(info[4]));
        setCategory_model(info[5]);
        setInfo(info[6]);

        setRam_space(Integer.parseInt(info[7]));
        setMemory(Integer.parseInt(info[8]));
        setOperating_System(info[9]);
        setResolution(info[10]);
        setGuaranteeTime(Integer.parseInt(info[11]));
        setGuaranteeValue(Double.valueOf(info[12]));

        setSIM_num(Integer.parseInt(info[13]));
        setCameraQuantity(info[14]);

        setAddress(info[15]);
        setAddress2(info[16]);
        setDeleted_product(Boolean.parseBoolean(info[17]));
        setStar(Integer.parseInt(info[18]));
    }


    @Override
    public double discountAmount() {
        return 0.4;
    }

    @Override
    public double discountAmount2() {
        return 0.3;
    }

    @Override
    public String partOfDiscountCode() {
        return "mob";
    }

    public int getSIM_num() {
        return SIM_num;
    }

    public String getCameraQuantity() {
        return cameraQuantity;
    }

    public void setSIM_num(int SIM_num) {
        this.SIM_num = SIM_num;
    }

    public void setCameraQuantity(String cameraQuantity) {
        this.cameraQuantity = cameraQuantity;
    }
}
