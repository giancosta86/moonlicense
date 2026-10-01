package info.gianlucacosta.moonlicense.noticeformats;

import info.gianlucacosta.moonlicense.DefaultNoticeFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Notice format for XML.
 * <p>
 * In particular, it preserves the XML declaration at the beginning, to comply the standard.
 */
public class XmlNoticeFormat extends DefaultNoticeFormat {
    private static final Pattern licensePattern = Pattern.compile("(?s)^\\s*((?:<\\?xml [^>]+\\?>(?:\r?\n){0,2})?)\\s*(<!--[§^].*?-->)()\\s*");
    private static final Pattern xmlPattern = Pattern.compile("(?s)^\\s*<\\?xml [^>]+\\?>\\s*");

    @Override
    public Matcher matchNotice(String content) {
        return licensePattern.matcher(content);
    }

    @Override
    public int getInsertionIndex(String content) {
        Matcher doctypeMatcher = xmlPattern.matcher(content);

        if (doctypeMatcher.find()) {
            return doctypeMatcher.end();
        } else {
            return 0;
        }
    }

    @Override
    public String formatNotice(String notice) {
        return String.format("<!--^%s%s-->%s%s",
                lineSeparator,
                notice,
                lineSeparator,
                lineSeparator);
    }
}
