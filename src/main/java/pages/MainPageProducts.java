package pages;
public class MainPageProducts {
    private String sectionId;
    private int productNumber;

    public MainPageProducts(String sectionId, int productNumber) {
        this.sectionId = sectionId;
        this.productNumber = productNumber;
    }

    public String getSectionId() {
        return sectionId;
    }
    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

}
