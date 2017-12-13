package cn.net.hanmu.aiml.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitoflife.chatterbean.AliceBot;
import cn.net.hanmu.aiml.bots.AliceBotMother;
import cn.net.hanmu.aiml.dao.imp.UserDao_tsImp;
import cn.net.hanmu.aiml.pojo.User;
import cn.net.hanmu.aiml.service.imp.UserService_tsImp;
import cn.net.hanmu.aiml.utils.StringUtil;
import cn.net.hanmu.aiml.utils.Time;
import cn.net.hanmu.aiml.utils.UserUUID;

public class aimlServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static AliceBotMother mother = new AliceBotMother();
	private static final String BOT_SAY = "小V:";
	private static AliceBot bot = null;
	
	public void init(ServletConfig config) throws ServletException {
		String path = config.getServletContext().getRealPath("Bots");
		mother.setUp();
		try {
			bot = mother.newInstance(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置字符码为utf-8
		resp.setContentType("text/html;charset=utf-8");
		//实例化UserUUID的对象
		UserUUID ud = new UserUUID();
		//实例化UserSerice对象
		UserService_tsImp ts = new UserService_tsImp();
		//实例化UserDao_tsImp对象
		UserDao_tsImp dao = new UserDao_tsImp();
		//创建list集合
		List<User> list = new ArrayList<User>();
		//获取index输入框的内容
		String question = req.getParameter("say");
		//获取UserServlet设置的session的z值
		String user = (String) req.getSession().getAttribute("z");
		//获取随机生成id做String变量id初始化值
		String id = ud.takeUUID();
		//获取当前操作时间
		String time = Time.getTime();
		try {
			//查找用户权限
			list = dao.findUser_quanxian(user);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		//判断用户输入的内容是否与我想看历史人物相同，如果相同则进入方法
		if(question.equals("我想看历史人物")){	
			//判断此用户的权限是否有。如果没有，提示用户“对不起，你没有权向访问，请联系管理员”
			if(list.get(0).getQuanxian().equals("普通用户")){
				String respond = null;
				respond = "对不起，你是普通用户，没有权限访问,请联系管理员!";
				resp.getWriter().write(BOT_SAY+"<br />"+respond);
				resp.getWriter().flush();
			}else{//如果存在权限，则将用户权限设计的内容向用户列出来
				String respond = null;
				respond = "请输入我想看*(例:我想看李白)来查看故事："+"<br>"+"<br>"+"1、李白\t\t2、杜甫\n"+"3、李清照\t\t"+"4、张择端\n"+"5、郭守敬\t\t6、关汉卿";
				resp.getWriter().write(BOT_SAY+"<br />"+respond);
				resp.getWriter().flush();
			}
		}else{//我想看历史故事，这个模板是否有权限用户都可以查看
			if(question.equals("我想看历史故事")){
				String respond = null;
				respond = "请输入我想看*(例:我想看唐朝)来查看故事："+"<br>"+"<br>"+"1、夏朝\t\t2、商朝\n"+"\t\t\t"+"3、周朝\t\t4、秦朝\n"+"5、汉朝\t\t"+"<br>"+"<br>"+"6、西晋\n"+"7、南北朝\t\t8、隋朝\n"+"9、唐朝\t\t10、宋朝\n"+"<br>"+"<br>"+"11、元朝\t\t"+"12、明朝\n"+"13、清朝\t\t14、中华民国";
				resp.getWriter().write(BOT_SAY+"<br />"+respond);
				resp.getWriter().flush();
			}else{
				if(question.equals("我想看李白")){
					//判断此用户是否有权限设置
					if(list.get(0).getQuanxian().equals("普通用户")){
						String respond = null;
						respond = "对不起，你是普通用户,没有权限访问,请联系管理员!";
						resp.getWriter().write(BOT_SAY+"<br />"+respond);
						resp.getWriter().flush();
					}else{//如果存在权限，则将相关内容显示出来
						String respond = null;
						respond = "李白所作词赋，宋人已有传记（如文莹《湘山野录》卷上），就其开创意义及艺术成就而言，“李白词”享有极为崇高的地位。";
						resp.getWriter().write(BOT_SAY+"<br />"+respond);
						resp.getWriter().flush();
					}
				}else{
					String respond = null;
					if(StringUtil.isEmpty(question)){
						respond = bot.respond("welcome");
					}else{
						respond = bot.respond(question);
					}//判断用户问题是否与这些无关问题相同，如果不相同则可以存入到数据库，否则，存入不到！
					if(!question.equals("welcome")&&!respond.equals("对不起，我没明白你的意思。")&&!respond.equals("让我想一下...")&&!respond.equals("我想静静。")&&!question.equals("")&&!user.equals("null")){
						try {
							ts.tuiSong(id,user,question,respond,time);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					resp.getWriter().write(BOT_SAY+"<br />"+respond);
					resp.getWriter().flush();
				}
				
			}
			
			//如果用户问的问题是我想看李白，则进入方法
			if(question.equals("我想看李白")){
				//判断此用户是否有权限设置
				if(list.get(0).getQuanxian().equals("普通用户")){
					String respond = null;
					respond = "对不起，你是普通用户,没有权限访问,请联系管理员!";
					resp.getWriter().write(BOT_SAY+"<br />"+respond);
					resp.getWriter().flush();
				}else{//如果存在权限，则将相关内容显示出来
					String respond = null;
					respond = "李白所作词赋，宋人已有传记（如文莹《湘山野录》卷上），就其开创意义及艺术成就而言，“李白词”享有极为崇高的地位。";
					resp.getWriter().write(BOT_SAY+"<br />"+respond);
					resp.getWriter().flush();
				}
			}
			}
			
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
		
}
