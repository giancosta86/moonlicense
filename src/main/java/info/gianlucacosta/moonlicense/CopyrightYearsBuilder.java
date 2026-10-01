package info.gianlucacosta.moonlicense;

import java.util.Objects;

/**
 * Builds a "copyright years" string, via its toString() method, that complies with the following rules:
 * <ul>
 * <li>if inceptionYear == currentYear, that value is returned</li>
 * <li>if inceptionYear &lt; currentYear, {inceptionYear}-{currentYear} is returned</li>
 * <li>otherwise, an IllegalArgumentException is thrown</li>
 * </ul>
 */
public class CopyrightYearsBuilder {
    private Integer inceptionYear;
    private Integer currentYear;

    public CopyrightYearsBuilder setInceptionYear(Integer inceptionYear) {
        this.inceptionYear = inceptionYear;
        return this;
    }

    public CopyrightYearsBuilder setCurrentYear(Integer currentYear) {
        this.currentYear = currentYear;
        return this;
    }


    @Override
    public String toString() {
        if (inceptionYear == null) {
            throw new UnsupportedOperationException("Missing inceptionYear");
        }


        if (currentYear == null) {
            throw new UnsupportedOperationException("Missing currentYear");
        }


        if (inceptionYear > currentYear) {
            throw new IllegalArgumentException("inceptionYear cannot come after currentYear");
        }

        return (Objects.equals(currentYear, inceptionYear)) ?
                String.valueOf(currentYear)
                :
                String.format("%d-%d", inceptionYear, currentYear);
    }
}
