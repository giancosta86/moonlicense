package info.gianlucacosta.moonlicense;

import info.gianlucacosta.moonlicense.util.Resources;

import java.io.IOException;
import java.util.Objects;

/**
 * Default license implementation, reading its templates from resources.
 * <p>
 * When inheriting, just implement the abstract methods and provide the following text files in the same package as
 * the subclass:
 * <ul>
 * <li>fullTemplate.txt</li>
 * <li>noticeTemplate.txt</li>
 * </ul>
 */
public abstract class DefaultLicense implements License {
    @Override
    public String getFullTemplate() {
        try {
            return Resources.getResourceAsString(getClass(), "fullTemplate.txt");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String getNoticeTemplate() {
        try {
            return Resources.getResourceAsString(getClass(), "noticeTemplate.txt");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof License)) {
            return false;
        }

        License other = (License) obj;

        return Objects.equals(
                getName(),
                other.getName()
        );
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", getName(), getUrl());
    }
}
