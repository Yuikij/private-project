package com.yui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DemoTest4 {
	
	public static void main(String[] args) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
         
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, - 7);
        Date d = c.getTime();
        String day = format.format(d);
        System.out.println("过去七天："+day);
		
	
	}

}
