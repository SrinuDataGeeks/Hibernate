package com.datageeks;

import java.util.LinkedHashSet;
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
    	//fbDao.delete(2);	
    		
    		
    }
    
    public 	static Set<String> getHBComments()
	{
		Set<String> set = new LinkedHashSet<String>();
		set.add("Hibernate is ORM tool.");
		set.add("Hibernate is Light weight");
		set.add("Hibernate is ORM tool.");
		set.add("Hibernate is Light weight");
				return set;
	}
	
    public static Set<String> getJavaComments()
	{
    	Set<String> set = new LinkedHashSet<String>();
    	set.add("Java is OOPL");
    	set.add("Java is Simple ...!");
    	set.add("Java is Distributed !");
    	set.add("Java is OOPL");
    	set.add("Java is Simple ...!");
    	set.add("Java is Distributed !");
		return set;
	}
	
}
