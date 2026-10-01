package info.gianlucacosta.moonlicense;

/**
 * A license - such as Apache 2 or GPLv3.
 * <p>
 * A few methods return templates - strings containing special placeholders whose instances will all be
 * replaced by {@link info.gianlucacosta.moonlicense.ProductInfoInjector}.
 */
public interface License {
    String getName();

    String getUrl();

    String getFullTemplate();

    String getNoticeTemplate();
}
