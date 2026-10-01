package info.gianlucacosta.moonlicense;

import java.util.regex.Matcher;

/**
 * Basic implementation of StringNoticeService.
 */
public class DefaultStringNoticeService implements StringNoticeService {
    @Override
    public String setNotice(String sourceString, NoticeFormat noticeFormat, String notice) {
        String formattedNotice = noticeFormat.formatNotice(notice);

        Matcher existingMatcher = noticeFormat.matchNotice(sourceString);

        if (existingMatcher.find()) {
            return existingMatcher.replaceFirst(String.format("%s%s%s",
                    existingMatcher.group(1),
                    formattedNotice,
                    existingMatcher.group(3)
            ));
        } else {
            int insertionPoint = noticeFormat.getInsertionIndex(sourceString);

            return sourceString.substring(0, insertionPoint)
                    + formattedNotice
                    + sourceString.substring(insertionPoint, sourceString.length());
        }
    }

    @Override
    public String removeNotice(NoticeFormat noticeFormat, String sourceString) {
        Matcher existingMatcher = noticeFormat.matchNotice(sourceString);

        if (existingMatcher.find()) {
            return existingMatcher.replaceFirst(
                    existingMatcher.group(1) + existingMatcher.group(3)
            );
        } else {
            return sourceString;
        }
    }
}
