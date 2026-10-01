package info.gianlucacosta.moonlicense;

/**
 * Sets or removes the license notice from a single string - which is usually (but not necessarily)
 * the content of a file.
 */
public interface StringNoticeService {
    /**
     * Sets the license notice within the given string.
     * <p>
     * If a license notice was already present (according to the specified
     * {@link info.gianlucacosta.moonlicense.NoticeFormat}), it will be overwritten.
     *
     * @param sourceString The source string.
     * @param noticeFormat The format to employ for the notice.
     * @param notice       The notice, still to be formatted.
     * @return The string with the formatted license notice in the right place, as specified by the NoticeFormat.
     */
    String setNotice(String sourceString, NoticeFormat noticeFormat, String notice);


    /**
     * Removes the license notice from the given string.
     *
     * @param noticeFormat The notice format used to find the notice to remove.
     * @param sourceString The source string.
     * @return The string without its formatted license notice.
     */
    String removeNotice(NoticeFormat noticeFormat, String sourceString);
}
