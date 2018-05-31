package com.yui;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class LearnTest {
	public static void main(String[] args) {
		File path = new File(".");
		String[] list ;
		if(args.length == 0)
			list = path.list();
		else
			list = path.list(new DirFiler(args[0]));
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for(String dirItrm:list){
			System.out.println(dirItrm);
		}
	
	}

}
class DirFiler implements FilenameFilter {
	private Pattern pattern;
	
	public DirFiler(String regex){
		pattern = Pattern.compile(regex);
	}
	
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
	
	
	
	
	
	
	
	
}