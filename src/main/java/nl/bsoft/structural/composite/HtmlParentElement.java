package nl.bsoft.structural.composite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class HtmlParentElement extends HtmlTag {
    private static final Logger logger = LoggerFactory.getLogger(HtmlParentElement.class);

    private String tagName;
    private String startTag;
    private String endTag;
    private List<HtmlTag> childrenTag;
    private int level;


    public HtmlParentElement(String tagName) {
        this.tagName = tagName;
        this.startTag = "";
        this.endTag = "";
        this.childrenTag = new ArrayList<>();
        this.level = 0;
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
    public void addChildTag(HtmlTag htmlTag) {
        htmlTag.setLevel(this.level + 1);
        childrenTag.add(htmlTag);
    }

    @Override
    public void removeChildTag(HtmlTag htmlTag) {
        childrenTag.remove(htmlTag);
    }

    @Override
    public List<HtmlTag> getChildren() {
        return childrenTag;
    }

    @Override
    public void generateHtml() {
        logger.info(startTag);
        for (HtmlTag tag : childrenTag) {
            tag.generateHtml();
        }
        logger.info(endTag);
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String generateHtmlString() {
        StringBuffer sb = new StringBuffer();

        addSpaces(sb, level);
        sb.append(startTag);

        sb.append("\n");
        for (HtmlTag tag : childrenTag) {
            sb.append(tag.generateHtmlString());
            sb.append("\n");
        }

        addSpaces(sb, level);
        sb.append(endTag);

        return sb.toString();
    }

}
