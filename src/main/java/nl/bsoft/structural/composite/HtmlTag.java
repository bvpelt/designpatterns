package nl.bsoft.structural.composite;

import java.util.List;

public abstract class HtmlTag {

    public abstract String getTagName();

    public abstract void setStartTag(String tag);

    public abstract void setEndTag(String tag);

    void setTagBody(String tagBody) {
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }

    public void addChildTag(HtmlTag htmlTag) {
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }

    public void removeChildTag(HtmlTag htmlTag) {
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }

    public List<HtmlTag> getChildren() {
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }

    public int getLevel() {
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }

    public void setLevel(int level) {
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }

    public abstract void generateHtml();


    public abstract String generateHtmlString();

    protected void addSpaces(StringBuffer buf, int level) {
        for (int i = 0; i < level; i++) {
            buf.append(" ");
        }
    }
}
