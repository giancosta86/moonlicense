package info.gianlucacosta.moonlicense;

import java.util.Objects;

/**
 * Provides shared behaviour for NoticeFormat implementations.
 */
public abstract class DefaultNoticeFormat implements NoticeFormat {
    protected static final String lineSeparator = System.lineSeparator();


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NoticeFormat)) {
            return false;
        }

        NoticeFormat other = (NoticeFormat) obj;

        return Objects.equals(
                toString(),
                other.toString()
        );
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
