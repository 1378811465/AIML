package bitoflife.chatterbean.aiml;

//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import org.springframework.web.context.ContextLoader;
//import org.springframework.web.context.WebApplicationContext;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;

import cn.net.hanmu.aiml.pojo.User;
import cn.net.hanmu.aiml.service.imp.UserServiceImp;
import bitoflife.chatterbean.AliceBot;
//
import bitoflife.chatterbean.Match;
//import cn.net.hanmu.aiml.dao.BotsDao;
//import cn.net.hanmu.aiml.pojo.Blog;
//import cn.net.hanmu.aiml.service.BotsService;
//import cn.net.hanmu.aiml.service.impl.BotsServiceImpl;
//import net.sf.json.JSONObject;

public class Query extends TemplateElement{
	
	//无参构造方法
	  public Query(){}
	
	  //有参
	  public Query(Attributes attributes){}
	  
	  //子标签
	  public Query(Object... children)
	  {
		
	    super(children);
	  }  
	  
	  //执行方法
	  public String process(Match match){
		  UserServiceImp us = new UserServiceImp();
		  String process = super.process(match);
		  List<User> list = new ArrayList<User>();
		  try {
			list = us.findAll(process);
		  } catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		  }
		  String a = "";
		  for(int i = 0;i < list.size();i++){
			  if(a == ""){
				  a = a + list.get(i).getData();
			  }
			  else{
				  a = a + ";" + list.get(i).getData();
			  }
		  }
		return a;
	  }
}
