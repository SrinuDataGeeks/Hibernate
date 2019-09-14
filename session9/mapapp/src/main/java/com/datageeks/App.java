package com.datageeks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.datageeks.dao.FacebookDAO;
import com.datageeks.dao.FacebookPost;
	
/**	
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	FacebookDAO fbDao = new FacebookDAO();
		
    	/*
    	 
    	FacebookPost javaPost= new FacebookPost();		
    	javaPost.setPostName("What is Java..?");
    	javaPost.setPostedBy("Srinu");
    	javaPost.setComments(getJavaComments());
    	
    	FacebookPost hbPost= new FacebookPost();		
    	hbPost.setPostName("What is Hibernate..?");
    	hbPost.setPostedBy("Naresh");
    	hbPost.setComments(getHBComments());
    	
    	fbDao.saveOrUpdate(javaPost);
    	fbDao.saveOrUpdate(hbPost);	
    	 
    	 */
    	
    
/*
    
		List<FacebookPost> fbPostList = fbDao.getAll();
		for (FacebookPost fbPost : fbPostList) {
			System.out.println("\n\n" + fbPost.getPostName() + "\t " + "PostedBy :" + fbPost.getPostedBy());
			Map<String,String> commentsMap = fbPost.getComments();
			Set<String> set = commentsMap.keySet();
			System.out.println("\n\nComments: ");
			for (String key : set) {
				System.out.println(key + " : "+commentsMap.get(key));
			}
		}
		
		*/
    	fbDao.delete(1);	
    		
    		
    }
    
    public 	static Map<String,String> getHBComments()
	{
		Map<String,String> map = new HashMap<String,String>();
		map.put("HB is ORM","Venu");
		map.put("HB Light weight","Akash");
	
				return map;
	}
	
    public static  Map<String,String> getJavaComments()
	{
		Map<String,String> map = new HashMap<String,String>();
		map.put("Java is OOPL","Arun");
		map.put("Java is Simple","Mahesh");
		map.put("Java is Distributed","Kiran");
				return map;
	}
	
}
