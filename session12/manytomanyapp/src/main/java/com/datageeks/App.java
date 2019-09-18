package com.datageeks;

import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;

import com.datageeks.dao.Course;
import com.datageeks.dao.Student;
import com.datageeks.dao.StudentDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StudentDAO studentDAO = new StudentDAO();
    	
    	
    	/*
    	
    		Course java = new Course(1,"Java");
    		Course hadoop = new Course(2,"Hadoop");

    		Course spark = new Course(3,"Spark");
    		Course dataScience = new Course(4,"DataScience");
    		
    		Set<Course> venkatSet = new HashSet<Course>();
    		venkatSet.add(java);
    		venkatSet.add(spark);
    		
    		Set<Course> nareshSet = new HashSet<Course>();
    		nareshSet.add(java);
    		nareshSet.add(dataScience);
    		
    		Student venkat = new Student(1201,"Venkat");
    		venkat.setCourseSet(venkatSet);
    		
    		
    		Student naresh = new Student(1202,"Naresh");
    		naresh.setCourseSet(nareshSet);
    		
    		studentDAO.saveOrUpdate(venkat);
    		studentDAO.saveOrUpdate(naresh);
    	
    		*/
    //	studentDAO.delete(1201);
    	
    	Student student = studentDAO.get(1202);
    		if(student != null)
    		{
    			Set<Course> courseSet = student.getCourseSet();
    			System.out.println(student.getStudentId()+ " : "+student.getStudentName());
    			for(Course c : courseSet)
    			{
    				System.out.println(c.getCourseId()+ " : "+c.getCourseName());
    			}
    		}else
    		{
    			System.out.println(" Student ID 1202 does not exist");
    		}
    	
    	

    }
}
