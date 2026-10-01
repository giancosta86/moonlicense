package info.gianlucacosta.moonlicense;

import java.time.Year;

/**
 * Replaces all the placeholders within a template string.
 * <p>
 * The following placeholders are now supported:
 * <ul>
 * <li><b>%%%PRODUCT_NAME%%%</b> - the product name.</li>
 * <li><b>%%%COPYRIGHT_YEARS%%%</b> - the year range, starting from the product's inception year up to the current year.
 * Its format will be <i>inceptionYear</i> (if it's the same as <i>currentYear</i>)
 * or <i>inceptionYear-currentYear</i> (otherwise).</li>
 * <li><b>%%%COPYRIGHT_HOLDER%%%</b> - the copyright holder.</li>
 * </ul>
 */
public class ProductInfoInjector {
    private final ProductInfo productInfo;
    private final String copyrightYears;


    public ProductInfoInjector(ProductInfo productInfo) {
        this(productInfo, Year.now().getValue());
    }

    public ProductInfoInjector(ProductInfo productInfo, int currentYear) {
        if (currentYear < productInfo.getInceptionYear()) {
            throw new IllegalArgumentException("The inception year cannot come after the current year");
        }

        this.productInfo = productInfo;

        this.copyrightYears = new CopyrightYearsBuilder()
                .setInceptionYear(productInfo.getInceptionYear())
                .setCurrentYear(currentYear)
                .toString();
    }

    /**
     * Replaces all placeholder instances with the product info values.
     *
     * @param template The template string.
     * @return The string with all the placeholders replaced.
     */
    public String inject(String template) {
        return template
                .replaceAll("%%%PRODUCT_NAME%%%", productInfo.getProductName())
                .replaceAll("%%%COPYRIGHT_YEARS%%%", copyrightYears)
                .replaceAll("%%%COPYRIGHT_HOLDER%%%", productInfo.getCopyrightHolder());
    }
}
