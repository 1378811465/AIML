package bitoflife.chatterbean.parser;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SplitterHandler extends DefaultHandler
{
  /*
  Attribute Section
  */
  
  private List<String> splitters;
  
  /*
  Constructor Section
  */
  
  public SplitterHandler()
  {
    splitters = new ArrayList<String>(4);
  }
  
  public SplitterHandler(List<String> splitters)
  {
    this.splitters = splitters;
  }
  
  /*
  Event Section
  */

  public void startElement(String namespace, String name, String qname, Attributes attributes) throws SAXException
  {
    if (qname.equals("splitter") && !"word".equals(attributes.getValue("type")))
      splitters.add(attributes.getValue(0));
  }

  /*
  Method Section
  */
  
  public void clear()
  {
    splitters.clear();
  }
  
  public List<String> parsed()
  {
    return new ArrayList<String>(splitters);
  }
}