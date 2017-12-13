package cn.net.hanmu.aiml.bots;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.Context;
import bitoflife.chatterbean.parser.AliceBotParser;
import bitoflife.chatterbean.util.Searcher;

public class AliceBotMother {
	 private ByteArrayOutputStream gossip;
	  
	  
	  public void setUp()
	  {
	    gossip = new ByteArrayOutputStream();
	  }
	  
	  public String gossip()
	  {
	    return gossip.toString();
	  }

	  public AliceBot newInstance(String path) throws Exception
	  {
	    Searcher searcher = new Searcher();
	    AliceBotParser parser = new AliceBotParser();
	    AliceBot bot = parser.parse(new FileInputStream(path+"/context.xml"),
	                                new FileInputStream(path+"/splitters.xml"),
	                                new FileInputStream(path+"/substitutions.xml"),
	                                searcher.search(path+"/mydomain", ".*\\.aiml"));

	    Context context = bot.getContext(); 
	    context.outputStream(gossip);
	    return bot;
	  }
}
