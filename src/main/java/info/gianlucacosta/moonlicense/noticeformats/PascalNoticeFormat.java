package info.gianlucacosta.moonlicense.noticeformats;

import info.gianlucacosta.moonlicense.DefaultNoticeFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Notice format for languages supporting Pascal comments - including OCaml.
 */
public class PascalNoticeFormat extends DefaultNoticeFormat {
    private static final Pattern licensePattern = Pattern.compile("(?s)^()\\s*(\\(\\*[§^].*?\\*\\))\\s*()");

    @Override
    public Matcher matchNotice(String content) {
        return licensePattern.matcher(content);
    }

    @Override
    public int getInsertionIndex(String content) {
        return 0;
    }

    @Override
    public String formatNotice(String notice) {
        return String.format("(*^%s%s*)%s%s",
                lineSeparator,
                notice,
                lineSeparator,
                lineSeparator);
    }
}
