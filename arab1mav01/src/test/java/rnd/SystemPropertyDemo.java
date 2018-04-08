package rnd;

import java.io.File;

public class SystemPropertyDemo {

	public static void main(String[] args) {
		String dir = System.getProperty("user.home") + File.separator + "reports";
		System.out.println(dir);
		
		File dirPath = new File(dir);
		dirPath.mkdirs();

	}

	}
