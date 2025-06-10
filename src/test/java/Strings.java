
public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "Text @ is ready";

		System.out.println(s.split("@")[0].trim());

		String rev = new StringBuilder(s).reverse().toString();

		System.out.println(rev);
		
		String reversed="";
		
		
		for (int i=s.length()-1; i>=0;i-- )
		{

			 reversed += s.charAt(i);
	}

		System.out.println(reversed);
}}
