package cn.net.hanmu.aiml.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.net.hanmu.aiml.dao.UserDao_dl;
import cn.net.hanmu.aiml.dao.imp.UserDao_tsImp;
import cn.net.hanmu.aiml.pojo.User;
import cn.net.hanmu.aiml.service.imp.UserService_tsImp;
import cn.net.hanmu.aiml.utils.JsonUtils;
import cn.net.hanmu.aiml.utils.ResponseUtil;
import cn.net.hanmu.aiml.utils.UserUUID;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/*
		 * 设置字符编码为utf-8
		 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		/*
		 * 声明String变量methodname,通过request的getParameter方法获取index页面name为methodname的值
		 */
		String methodname = request.getParameter("methodName");
		System.out.println(methodname);
		/*
		 * 判断methodname变量是否与equals里面的形参相同
		 */
		if (methodname.equals("login")) {
			try {
				login(request, response);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (methodname.equals("dingyue")) {
			try {
				dingyue(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (methodname.equals("qx_dingyue")) {
			try {
				try {
					qxDingYue(request, response);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (methodname.equals("register")) {
				try {
					register(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
		} else if (methodname.equals("admin")) {
			try {
				admin(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else if (methodname.equals("updateQuanxian")) {
			try {
				updateQuanxian(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else if (methodname.equals("listDingYue")) {
			try {
				listDingYue(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else if (methodname.equals("selectHistor")) {
			try {
				selectHistor(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else if (methodname.equals("my_dingyue")) {
			try {
				my_dingyue(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else if (methodname.equals("updateApplyOne")) {
			try {
				updateApplyOne(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else if (methodname.equals("updateApplyTwo")) {
			try {
				updateApplyTwo(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else if (methodname.equals("listApply")) {
			try {
				listApply(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else if (methodname.equals("applyFor")) {
			try {
				insertApplyFor(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else if (methodname.equals("dingyue_muban")) {
			try {
				listdingyue_muban(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else if (methodname.equals("xiugaiPassword")) {
			try {
				xiugaiPassword(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void xiugaiPassword(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserDao_tsImp ud = new UserDao_tsImp();
		String user = (String) request.getSession().getAttribute("z");
		String password = request.getParameter("password");
		String passwordYan = "^[0-9A-Za-z]{3,16}$";
		Pattern p2 = Pattern.compile(passwordYan);
		Matcher m2 = p2.matcher(password);
		boolean r2 = m2.find();
		if(r2 == true){
			ud.xiugaiPassword(user,password);
			response.getWriter().write("成功");
		}
		if(r2 == false){
			request.setAttribute("a", "用户密码只能用3-12位的字母和数字组成");
			response.getWriter().write("失败");
		}
		
	}

	private void listdingyue_muban(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException  {
		UserDao_tsImp ud = new UserDao_tsImp();
		List<User> userlist = new ArrayList<User>();
		userlist = ud.listdingyue_muban();
		String list = JsonUtils.convertToString(userlist);
		response.getWriter().write(list);

	}

	private void insertApplyFor(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException  {
		UserDao_tsImp ud = new UserDao_tsImp();
		UserUUID uu = new UserUUID();
		String username = request.getParameter("name");
		List<User> list = new ArrayList<User>();
		list = ud.listApply_name(username);
		if(list.size()!=0){
			for(int i =0;i < list.size();i++){
				if(!list.get(i).getState().equals("1")){
					ud.insertApplyFor(username,uu.takeUUID());
				}
			}
		}else{
			ud.insertApplyFor(username,uu.takeUUID());
		}
		
	}

	private void listApply(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		UserDao_tsImp ud = new UserDao_tsImp();
		List<User> list = new ArrayList<User>();
		list = ud.listApply();
		JSONArray js = new JSONArray();
		JSONObject json = new JSONObject();
		for(int j = 0;j < list.size();j++){
			
			if(list.get(j).getState().equals("1")){
				System.out.println(list.get(j).getState());
				
					json.put("id",list.get(j).getId());
					json.put("username",list.get(j).getUsername());
					json.put("password",list.get(j).getPassword());
					json.put("reason",list.get(j).getReason());
					js.add(json);
				
			}
		}
		try {
			ResponseUtil.write(response, js);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private void updateApplyOne(HttpServletRequest request,
			HttpServletResponse response)throws ClassNotFoundException, SQLException, IOException  {
		UserDao_tsImp ud = new UserDao_tsImp();
		
		String id = request.getParameter("id");
		List<User> list = new ArrayList<User>();
		list = ud.getUserName(id);
		ud.updateApplyOne(id,list.get(0).getUsername());
	}
	private void updateApplyTwo(HttpServletRequest request,
			HttpServletResponse response)throws ClassNotFoundException, SQLException, IOException  {
		UserDao_tsImp ud = new UserDao_tsImp();
		String id = request.getParameter("id");
		ud.updateApplyTwo(id);
	}
	private void my_dingyue(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		UserDao_tsImp ud = new UserDao_tsImp();
		String username = request.getParameter("name");
		List<User> list = new ArrayList<User>();
		list = ud.my_dingyue(username);
		
		JSONArray json = new JSONArray();
	    json.addAll(list);
	    System.out.println(json);
	    response.setContentType("application/json; charset=utf-8");
	    response.getWriter().println(json);	
		
	}

	private void selectHistor(HttpServletRequest request,
			HttpServletResponse response)  throws ClassNotFoundException, SQLException, IOException{
		UserDao_tsImp ud = new UserDao_tsImp();
		List<User> list = new ArrayList<User>();
		String name = request.getParameter("name");
		list = ud.findSelect(name);
		 JSONArray json = new JSONArray();
		    json.addAll(list);
		    System.out.println(json);
		    response.setContentType("application/json; charset=utf-8");
		    response.getWriter().println(json);	
	}

	private void listDingYue(HttpServletRequest request,
			HttpServletResponse response)  throws ClassNotFoundException, SQLException{
		UserDao_tsImp ud = new UserDao_tsImp();
		List<User> list = new ArrayList<User>();
		list = ud.listDingYue();
		JSONArray js = new JSONArray();
		JSONObject json = new JSONObject();
		for(int i = 0;i < list.size();i++){
			json.put("id",list.get(i).getId());
			json.put("user",list.get(i).getUsername());
			json.put("name",list.get(i).getName());
			json.put("data",list.get(i).getData());
			js.add(json);
		}
		try {
			ResponseUtil.write(response, js);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateQuanxian(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException, SQLException  {
		UserDao_tsImp ud = new UserDao_tsImp();
		String id = request.getParameter("id");
		List<User> list = new ArrayList<User>();
		list = ud.getQuanxian(id);
		ud.updateQuanXian(id,list.get(0).getQuanxian());
	}

	private void admin(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException {
		UserDao_tsImp ud = new UserDao_tsImp();
		List<User> list = new ArrayList<User>();
		try {
			list = findAdmin(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		JSONArray js = new JSONArray();
		JSONObject json = new JSONObject();
		for(int i = 0;i < list.size();i++){
			json.put("id",list.get(i).getId());
			json.put("name",list.get(i).getName());
			json.put("password",list.get(i).getPassword());
			json.put("quanxian",list.get(i).getQuanxian());
			js.add(json);
		}
		try {
			ResponseUtil.write(response, js);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private List<User> findAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException,
			SQLException, ServletException, IOException {
		UserDao_tsImp ud = new UserDao_tsImp();
		List<User> list = new ArrayList<User>();
		list = ud.findUser();
		
		return list;

	}

	private void register(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items = upload.parseRequest(request);
		Iterator<FileItem> itr = items.iterator();
		String userName = "";
		String passWord = "";
		String uploadPath  = "";
		while (itr.hasNext()) {
			FileItem item = itr.next();
			if (item.isFormField()) {
				if(item.getFieldName().equals("userName")){
					userName = new String(item.getString().getBytes("iso8859-1"),"utf-8");
				}
				if(item.getFieldName().equals("passWord")){
					passWord = new String(item.getString().getBytes("iso8859-1"),"utf-8");
				}
			}
			else {
				if (item.getName()!=null&&!item.getName().equals("")) {
					File tempFile = new File(item.getName());
					File file = new File(request.getSession().getServletContext().getRealPath("/")+"image",tempFile.getName());
					System.out.println(file);
					if (!file.exists()) {
						file.createNewFile();
					}
					item.write(file);
					uploadPath = tempFile.getName(); 
				}
			}
		}
		// request.getParameter()根據name取值
		UserDao_dl ud = new UserDao_dl();
		UserUUID uu = new UserUUID();
		List<User> userList = null;// 创建ArrayList集合的对象
		// 给userDao的findAll方法传参，再将返回值传给userList
		userList = ud.findAll(userName);
		// 判断userList大小是否为零，如果为零说明传入的username参数在userDao的SQL语句中where里面没有找到相应的名称，故返回userLiSt值为零！
		if (userList.size() == 0) {
			//正则表达式，用于限制特殊字符和用户名密码位数
			String name = "^[a-zA-Z0-9]{3,12}$";
			String password = "^[0-9A-Za-z]{3,16}$";
			Pattern p1 = Pattern.compile(name);
			Pattern p2 = Pattern.compile(password);
			Matcher m1 = p1.matcher(userName);
			Matcher m2 = p2.matcher(passWord);
			boolean r1 = m1.find();
			boolean r2 = m2.find();
			if(r1 == true && r2 == true){
				User user = new User();
				user.setId(uu.takeUUID());
				user.setName(userName);
				user.setPassword(passWord);
				user.setQuanxian("普通用户");
				user.setImg(uploadPath);
				ud.addUser(user);
				request.getRequestDispatcher("denglu.jsp").forward(request,
						response);
			}
			if(r1 == false){
				request.setAttribute("a", "注册用户名只能用3-12位的字母和数字组成");
				// 跳转页面代码
				request.getRequestDispatcher("register.jsp").forward(request,
						response);
			}else if(r2 == false){
				request.setAttribute("a", "密码只能输入3-16位的字母或数字组成");
			}
		} else {
			request.setAttribute("a", "用户名已存在！");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		}

	}

	/*
	 * 取消订阅
	 */
	private void qxDingYue(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ClassNotFoundException, ServletException, IOException {
		UserDao_tsImp dao = new UserDao_tsImp();
		List<User> ts_dylist = new ArrayList<User>();
		String user = (String) request.getSession().getAttribute("z");

		String id = request.getParameter("id");
	    dao.qxDingYue(id);
		ts_dylist = dao.ts_Dy(user);
		request.setAttribute("dy", ts_dylist);
		findAll_Dy(request, response);

		JSONArray json = new JSONArray();
	    json.addAll(ts_dylist);
	    
	    System.out.println(json);
	    response.setContentType("application/json; charset=utf-8");
	    response.getWriter().println(json);	
		
	}

	/*
	 * 订阅
	 */
	private void dingyue(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserUUID ud = new UserUUID();
		UserDao_tsImp dao = new UserDao_tsImp();
		String user = (String) request.getSession().getAttribute("z");
		System.out.println(user+"12");
		String name = request.getParameter("name");
		List<User> dy_list = new ArrayList<User>();
		List<User> ts_dylist = new ArrayList<User>();
		ts_dylist = dao.ts_Dy(user);
		request.setAttribute("dy", ts_dylist);
		dy_list = dao.sl_Dy(name);
		List<User> list = new ArrayList<User>();// 创建ArrayList集合的对象
		list = dao.select_Dy(user, name);
		if (list.size() == 0) {
			dao.dingyue(ud.takeUUID(), user, name, dy_list.get(0).getData());
			request.setAttribute("a", "订阅成功！");
			findAll_Dy(request, response);
			request.setAttribute("dy", ts_dylist);
			ResponseUtil.write(response,"订阅成功！");
			

		} else {
			request.setAttribute("a", "你已经订阅过了！");
			findAll_Dy(request, response);
			request.setAttribute("dy", ts_dylist);
			ResponseUtil.write(response,"你已经订阅过了！");
			
		}
	}

	/*
	 * 根据用户查找订阅数据表，通过request的setAttribute的方法在jsp遍历出来
	 */
	private void findAll_Dy(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException,
			SQLException {
		UserDao_tsImp dao = new UserDao_tsImp();
		//通过session获取login方法里设置的session方法的键值对应的value值
		String user = (String) request.getSession().getAttribute("z");
		List<User> userlist = dao.selectDy();
		List<User> my_dylist = dao.findAllDy(user);
		//将获取到可订阅的模板的userlist变量的list集合存到setATTRibute键值为dylist里
		request.setAttribute("dylist", userlist);
		//将获取到用户的订阅内容的模板的my_dylist变量的list集合存到setATTRibute键值为my_dylist里
		request.setAttribute("my_dylist", my_dylist);
	}

	/*
	 *由登录页面的登录触发这个方法，实现判断登录用户账户、密码是否正确，并给订阅、历史记录功能提供用户名
	 */
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, ServletException,
			IOException {
		UserDao_dl dao = new UserDao_dl();
		//获取登录用户的用户名
		String username = request.getParameter("userName");
		//获取登录用户的面
		String userpassword = request.getParameter("passWord");
		//存推送用户的订阅内容
		List<User> ts_dy = new ArrayList<User>();
		// 存查看订阅list集合
		List<User> select_list = new ArrayList<User>();
		// 存我的订阅list集合
		List<User> my_list = new ArrayList<User>();
		List<User> userlist = new ArrayList<User>();
		List<User> selectList = new ArrayList<User>();
		List<User> list = new ArrayList<User>();// 创建ArrayList集合的对象
		list = dao.findAll(username);
		//判断list的大小是否为零，如果为零，说明没有从数据库查询到相应用户，故提示账户输入错误！
		if (list.size() == 0) {
			request.setAttribute("a", "账户输入错误，请重新输入！");
			request.getRequestDispatcher("denglu.jsp").forward(request,
					response);// 跳转页面代码
		} else {
			// get（0）取集合第一条数据，getpassword获得第一条数据的密码
			if (list.get(0).getName().equals("admin")) {
				UserDao_tsImp ud = new UserDao_tsImp();
				List<User> glList = new ArrayList<User>();
				glList = ud.findUser();
				request.setAttribute("admin", glList);
				request.getRequestDispatcher("admin-index.jsp").forward(request,
						response);
			} else {
				if (list.get(0).getPassword().equals(userpassword)) {
					// 通过setAttribute设置的值存到Session会话里;
					request.getSession().setAttribute("z", username);
					request.getSession().setAttribute("img", list.get(0).getImg());
					request.getSession().setAttribute("quanxian", list.get(0).getQuanxian());
					request.getSession().setAttribute("b", "欢迎进入");
					// 跳转页面
					ts_dy = ts_dy(username);// 订阅推送
					request.setAttribute("dy", ts_dy);
					select_list = selectDy(request, response);
					my_list = findAll(request, response);
					userlist = tuisong(username, request);
					selectList = findSelect(username);
					//通过setATTRibute方法将查看订阅设计的功能内容存放到键值为select里
					request.setAttribute("select", select_list);
					//通过setATTRibute方法将我的订阅的功能涉及的内容存放到键值为findAll里
					request.setAttribute("findAll", my_list);
					//通过setAttribute方法将推送内容存放到键值为list里
					request.setAttribute("list", userlist);
					//通过setAttribute方法将根据用户名查询到的历史记录村方法键值为selectList里
					request.setAttribute("selectList", selectList);
					request.setAttribute("n", selectList);
					//跳转到index页面
					request.getRequestDispatcher("index.jsp").forward(request,
							response);
				} else {
					request.setAttribute("a", "密码错误，请重新输入！");
					request.getRequestDispatcher("denglu.jsp").forward(request,
							response);
				}
			}
		}
	}
	/*
	 * 根据用户名查询历史记录
	 */
	private List<User> findSelect(String username)
			throws ClassNotFoundException, SQLException {
		UserService_tsImp ts = new UserService_tsImp();
		List<User> list = new ArrayList<User>();
		list = ts.findSelect(username);

		return list;
	}
	/*
	 * 根据用户名推送用户查询最多的
	 */
	private List<User> tuisong(String username, HttpServletRequest request) {
		UserService_tsImp ts = new UserService_tsImp();
		List<User> list = new ArrayList<User>();
		try {
			list = ts.tuisong(username);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("tuison", list);
		request.getSession().setAttribute("m", list);
		return list;

	}
	/*
	 * 通过session方法获取用户名查询用户订阅内容
	 */
	private List<User> findAll(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException,
			SQLException, ServletException, IOException {
		String user_name = (String) request.getSession().getAttribute("z");
		UserDao_tsImp dao = new UserDao_tsImp();
		List<User> my_list = new ArrayList<User>();
		my_list = dao.findAllDy(user_name);
		return my_list;
	}
	/*
	 * 查询出所有可订阅内容
	 */
	private List<User> selectDy(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException,
			SQLException, ServletException, IOException {
		UserDao_tsImp dao = new UserDao_tsImp();
		List<User> select_list = new ArrayList<User>();
		select_list = dao.selectDy();
		return select_list;

	}
	/*
	 * 查询出用户订阅的模板对应的内容
	 */
	public List<User> ts_dy(String user) throws ClassNotFoundException,
			SQLException {
		UserDao_tsImp dao = new UserDao_tsImp();
		List<User> list = new ArrayList<User>();
		list = dao.ts_Dy(user);

		return list;

	}

}
