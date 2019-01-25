package nl.bsoft.structural.composite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HtmlElement extends HtmlTag {
    private static final Logger logger = LoggerFactory.getLogger(HtmlElement.class);

    private String tagName;
    private String startTag;
    private String endTag;
    private String tagBody;
    private int level;

    public HtmlElement(String tagName) {
        this.tagName = tagName;
        this.tagBody = "";
        this.startTag = "";
        this.endTag = "";
    }

    @Override
    public String getTagName() {
        return tagName;
    }

    @Override
    public void setStartTag(String tag) {
        this.startTag = tag;
    }

    @Override
    public void setEndTag(String tag) {
        this.endTag = tag;
    }

    @Override
    public void setTagBody(String tagBody) {
        this.tagBody = tagBody;
    }

    @Override
    public void generateHtml() {
        logger.info(startTag + "" + tagBody + "" + endTag);
    }

    @Override
    public String generateHtmlString() {
        StringBuffer sb = new StringBuffer();

        addSpaces(sb, level);
        sb.append(startTag);
        sb.append(tagBody);
        sb.append(endTag);
        return sb.toString();
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

}
