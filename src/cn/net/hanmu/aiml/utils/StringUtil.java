package cn.net.hanmu.aiml.utils;

import java.util.ArrayList;
import java.util.List;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;


/**
 * 字符串工具类
 * @author 梁李宝
 *
 */
public class StringUtil {

	/**
	 * 中文ansj分词
	 * @param str
	 * @return
	 */
	public static String StringToAnalysis(String str){
		//判断是否全是英文
		if(str.getBytes().length == str.length()){
			return str;
		}
		StringBuffer sb = new StringBuffer();
		Result result = ToAnalysis.parse(str);//分词结果，使用的ansj分词
		List<Term> iterator = result.getTerms();
		for(int i = 0;i<iterator.size();i++){
			sb.append(iterator.get(i).getName()+" ");//获取分词,空格分隔
		}
		return sb.toString().toUpperCase();
	}
	
	/**
	 * 是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 是否不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if((str!=null)&&!"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 格式化模糊查询
	 * @param str
	 * @return
	 */
	public static String formatLike(String str){
		if(isNotEmpty(str)){
			return "%"+str+"%";
		}else{
			return null;
		}
	}
	
	/**
	 * 过滤掉集合里的空格
	 * @param list
	 * @return
	 */
	public static List<String> filterWhite(List<String> list){
		List<String> resultList=new ArrayList<String>();
		for(String l:list){
			if(isNotEmpty(l)){
				resultList.add(l);
			}
		}
		return resultList;
	}
	/**
	 * 测试分词
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "今天的天气不错**";//result:今天 的 天气 不错 * * 
		System.out.println(StringToAnalysis(str));
	}

}
