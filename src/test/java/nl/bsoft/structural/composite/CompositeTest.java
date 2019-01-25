package nl.bsoft.structural.composite;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompositeTest {
    private static final Logger logger = LoggerFactory.getLogger(CompositeTest.class);

    @Rule
    public TestName name = new TestName();

    @Test
    public void compositeTest() {
        logger.info("Start test: {}", name.getMethodName());
        HtmlTag parentTag = new HtmlParentElement("<html>");
        parentTag.setStartTag("<html>");
        parentTag.setEndTag("</html>");

        HtmlTag body = new HtmlParentElement("<body>");
        body.setStartTag("<body>");
        body.setEndTag("</body>");
        parentTag.addChildTag(body);

        HtmlTag div1 = new HtmlParentElement("<div class=\"class1\">");
        div1.setStartTag("<div class=\"class1\">");
        div1.setEndTag("</div>");
        body.addChildTag(div1);

        HtmlTag child1 = new HtmlElement("<P>");
        child1.setStartTag("<P>");
        child1.setEndTag("</P>");
        child1.setTagBody("Testing html tag library");
        div1.addChildTag(child1);

        child1 = new HtmlElement("<P>");
        child1.setStartTag("<P>");
        child1.setEndTag("</P>");
        child1.setTagBody("Paragraph 2");
        div1.addChildTag(child1);

        HtmlTag div2 = new HtmlParentElement("<div class=\"class2\">");
        div2.setStartTag("<div class=\"class2\">");
        div2.setEndTag("</div>");
        div1.addChildTag(div2);

        child1 = new HtmlElement("<P class=\"myclass\">");
        child1.setStartTag("<P class=\"myclass\">");
        child1.setEndTag("</P>");
        child1.setTagBody("Paragraph within div class 2");
        div2.addChildTag(child1);

        parentTag.generateHtml();

        logger.info("\n{}", parentTag.generateHtmlString());
        Assert.assertEquals("<html>\n" +
                " <body>\n" +
                "  <div class=\"class1\">\n" +
                "   <P>Testing html tag library</P>\n" +
                "   <P>Paragraph 2</P>\n" +
                "   <div class=\"class2\">\n" +
                "    <P class=\"myclass\">Paragraph within div class 2</P>\n" +
                "   </div>\n" +
                "  </div>\n" +
                " </body>\n" +
                "</html>", parentTag.generateHtmlString());


        logger.info("\n{}", body.generateHtmlString());
        Assert.assertEquals(" <body>\n" +
                "  <div class=\"class1\">\n" +
                "   <P>Testing html tag library</P>\n" +
                "   <P>Paragraph 2</P>\n" +
                "   <div class=\"class2\">\n" +
                "    <P class=\"myclass\">Paragraph within div class 2</P>\n" +
                "   </div>\n" +
                "  </div>\n" +
                " </body>", body.generateHtmlString());

        logger.info("\n{}", div1.generateHtmlString());
        Assert.assertEquals("  <div class=\"class1\">\n" +
                "   <P>Testing html tag library</P>\n" +
                "   <P>Paragraph 2</P>\n" +
                "   <div class=\"class2\">\n" +
                "    <P class=\"myclass\">Paragraph within div class 2</P>\n" +
                "   </div>\n" +
                "  </div>", div1.generateHtmlString());

        logger.info("End   test: {}", name.getMethodName());
    }
}
