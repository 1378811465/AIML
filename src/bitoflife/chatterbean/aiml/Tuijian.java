package bitoflife.chatterbean.aiml;


import java.sql.SQLException;

import org.xml.sax.Attributes;

import cn.net.hanmu.aiml.service.imp.UserService_tsImp;
import bitoflife.chatterbean.Match;
public class Tuijian extends TemplateElement{
	//无参构造方法
	  public Tuijian(){}
	
	  //有参
	  public Tuijian(Attributes attributes){}
	  
	  //子标签
	  public Tuijian(Object... children)
	  {
		
	    super(children);
	  }  
	  
	  
	  //执行方法
	 
	  public String process(Match match){
		  UserService_tsImp us = new UserService_tsImp();
		  String fanhui = null;
		  try {
				fanhui = us.fanHui();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		  return fanhui;
	  }
}
