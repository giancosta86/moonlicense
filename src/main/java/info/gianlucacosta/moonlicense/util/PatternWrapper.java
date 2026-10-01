package info.gianlucacosta.moonlicense.util;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Wraps a Pattern object to provide support for equals() and hashCode().
 */
public class PatternWrapper {
    private final Pattern pattern;

    public PatternWrapper(Pattern pattern) {
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return pattern;
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PatternWrapper)) {
            return false;
        }

        PatternWrapper other = (PatternWrapper) obj;

        return Objects.equals(pattern.pattern(), other.pattern.pattern());
    }

    @Override
    public int hashCode() {
        return pattern.pattern().hashCode();
    }


    public Matcher matcher(CharSequence input) {
        return pattern.matcher(input);
    }
}
