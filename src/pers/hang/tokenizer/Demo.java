package pers.hang.tokenizer;



import java.io.IOException;
import java.io.StringReader;
import java.util.Vector;

import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.cfg.DefaultConfig;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class Demo{
	
	public static void main(String[] args){
		
		//查看字典配置
		Configuration cfg = DefaultConfig.getInstance();
		
		System.out.println("主词典路径：" + cfg.getMainDictionary());
		System.out.println("量词词典路径："+ cfg.getQuantifierDicionary());
		System.out.println("拓展词典列表："+ cfg.getExtDictionarys());
		System.out.println("拓展停止词典列表"+ cfg.getExtStopWordDictionarys());
		
		String sentence = "让我来试一下分词的效果";
		tokenize(sentence);
		
	}
	
	
	public static Vector<String> tokenize( String sentence ) {
		
		Vector<String> words = new Vector<String>() ;
		
		try {
			
		    StringReader reader = new StringReader( sentence ); 
		    IKSegmenter ik = new IKSegmenter(reader,true); //use smart
		    Lexeme lexeme = null ;			
			
		    while( ( lexeme = ik.next() ) != null ) {
			    words.add( lexeme.getLexemeText() ); 
		    }			
			
		    if( words.size() == 0 ) {
		    	return null ;
		    }
		    
	 	   
		    System.out.println( "Before:" + sentence );
		    System.out.println( "After:" + words );
		    
		} catch ( IOException e ) {
			System.out.println();
		}
		return words;
	}
	
}