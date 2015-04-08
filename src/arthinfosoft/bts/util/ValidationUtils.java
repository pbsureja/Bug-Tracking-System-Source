package arthinfosoft.bts.util;

public class ValidationUtils {

	public static boolean isEmpty(String param){
		boolean isEmpty = false;
		
		if(param == null || param.trim().length()==0){
			isEmpty = true;
			
		}
		
		return isEmpty;
	}
	
	
}
