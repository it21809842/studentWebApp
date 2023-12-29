package com.student.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class commonUtil {
	
	public static final Properties properties = new Properties();
	
	static {
		try {
			properties.load(QueryUtil.class.getResourceAsStream(commonConstants.PROPERTY_FILE));
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public static String generateStudentIds(ArrayList<String>ids ) {
		String id;
		int next = ids.size();
		
		id = commonConstants.STUDENT_ID_PREFIX + next;
		if(ids.contains(id)) {
			next++;
			
			id = commonConstants.STUDENT_ID_PREFIX + next;
		}
		return id;
	}
	

}
