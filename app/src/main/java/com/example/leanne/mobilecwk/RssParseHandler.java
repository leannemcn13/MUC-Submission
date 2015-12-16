package com.example.leanne.mobilecwk;

/**
 * Created by leanne on 12/12/2015.
 */
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.example.leanne.mobilecwk.RSSItem;


public class RssParseHandler extends DefaultHandler {

    private List<RSSItem> rssItems;

    // Used to reference item while parsing
    private RSSItem currentItem;

    // Parsing title indicator
    private boolean parsingTitle;
    // Parsing link indicator
    private boolean parsingDescription;

    public RssParseHandler() {
        rssItems = new ArrayList<RSSItem>();
    }

    public List<RSSItem> getItems() {
        return rssItems;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("item".equals(qName)) {
            currentItem = new RSSItem();
        } else if ("title".equals(qName)) {
            parsingTitle = true;
        } else if ("description".equals(qName)) {
            parsingDescription = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("item".equals(qName)) {
            rssItems.add(currentItem);
            currentItem = null;
        } else if ("title".equals(qName)) {
            parsingTitle = false;
        } else if ("description".equals(qName)) {
            parsingDescription = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (parsingTitle) {
            if (currentItem != null)
                currentItem.setTitle(new String(ch, start, length));
        } else if (parsingDescription) {
            if (currentItem != null) {
                currentItem.setDescription(new String(ch, start, length));
                parsingDescription = false;
            }
        }
    }
}