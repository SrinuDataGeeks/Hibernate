package com.datageeks;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.datageeks.dao.FacebookDAO;
import com.datageeks.dao.FacebookPost;
import com.datageeks.dao.HBUtil;

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
			List<String> commentsList = fbPost.getComments();
			System.out.println("\n\nComments: ");
			for (String comment : commentsList) {
				System.out.println(comment);
			}
		}
		*/
    	fbDao.delete(2);	
    		
    		
    }
    
    public 	static List<String> getHBComments()
	{
		List<String> list = new ArrayList<String>();
		list.add("Hibernate is ORM tool.");
		list.add("Hibernate is Light weight");
		list.add("Hibernate is ORM tool.");
		list.add("Hibernate is Light weight");
				return list;
	}
	
    public static List<String> getJavaComments()
	{
		List<String> list = new ArrayList<String>();
		list.add("Java is OOPL");
		list.add("Java is Simple ...!");
		list.add("Java is Distributed !");
		list.add("Java is OOPL");
		list.add("Java is Simple ...!");
		list.add("Java is Distributed !");
		return list;
	}
	
}
