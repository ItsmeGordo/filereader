package br.com.involves.filereader.utils;

import java.util.Collection;

public class PrintDataUtils {

    public static void printCollectionData(Collection<String> collection) {
    	StringBuffer sb = new StringBuffer();
    	for (String data : collection) {
			sb.append(data);
			sb.append(",");
		}
    	
    	System.out.println(sb.substring(0, sb.length() - 1));
    }
    
}
