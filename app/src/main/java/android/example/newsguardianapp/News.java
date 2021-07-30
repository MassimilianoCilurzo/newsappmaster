package android.example.newsguardianapp;

public class News {
    /*
     * Web title of the news
     */
    private  String mWebTitle;

    /*
     * Section name of the news
     */
    private  String mSectionName;

    /*
     * Publication date of the news
     */
    private String mPublicationDate;
    /*
     * Author of the news
     */
       private String mAuthor;
    /*
     * Website URL of the news
     */
    private  String mUrl;

    /*
     * Create a News object.
     *
     * @param webTitle        is the web title of the news
     * @param sectionName     is the section name of the news
     * @param publicationDate is the publication date of the news
     * @param url             is the website URL to find more details about the news
     */
    public News(String webTitle, String sectionName, String author, String publicationDate, String url) {
        mWebTitle = webTitle;
        mSectionName = sectionName;
        mPublicationDate = publicationDate;
        mUrl = url;
    }

    /*
     * Returns the web title of the news
     */
    public String getWebTitle() {
        return mWebTitle;
    }
    /*
     * Returns the web title of the news
     */
    public String getAuthor() {
        return mAuthor;
    }
    /*
     * Returns the section name of the news
     */
    public String getSectionName() {
        return mSectionName;
    }


    /**
     * Returns the publication date of the news
     */
    public String getPublicationDate() {
        return mPublicationDate;
    }

    /**
     * Returns the website URL to find more information about the news.
     */
    public String getUrl() {
        return mUrl;
    }
}
