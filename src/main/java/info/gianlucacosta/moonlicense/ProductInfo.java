package info.gianlucacosta.moonlicense;

/**
 * Information about a product.
 */
public class ProductInfo {
    private final String productName;
    private final int inceptionYear;
    private final String copyrightHolder;

    public ProductInfo(String productName, int inceptionYear, String copyrightHolder) {
        if (productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("productName cannot be null or empty");
        }


        if (inceptionYear == 0) {
            throw new IllegalArgumentException("inceptionYear cannot be empty");
        }


        if (copyrightHolder == null || copyrightHolder.isEmpty()) {
            throw new IllegalArgumentException("copyrightHolder cannot be null or empty");
        }

        this.productName = productName;
        this.inceptionYear = inceptionYear;
        this.copyrightHolder = copyrightHolder;
    }

    public String getProductName() {
        return productName;
    }

    public int getInceptionYear() {
        return inceptionYear;
    }

    public String getCopyrightHolder() {
        return copyrightHolder;
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ProductInfo)) {
            return false;
        }

        ProductInfo other = (ProductInfo) obj;

        return productName.equals(other.productName)
                && (inceptionYear == other.inceptionYear)
                && copyrightHolder.equals(other.copyrightHolder);
    }


    @Override
    public int hashCode() {
        return productName.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", productName, inceptionYear, copyrightHolder);
    }
}
