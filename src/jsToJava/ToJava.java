package jsToJava;

public class ToJava {
	static boolean isArrow = false;
	static String js = "const add = (val) => {\r\n"
			+ "  input.innerHTML = val;\r\n"
			+ "};\r\n";
	
	public static void main(String[] args) {
		toJava();		
	}

	public static void toJava() {
		if(checkArrow()) {
			convertF();
			toJava();
		} else {
			convertJ();
		}
	}
	
	public static void convertJ() {
		
		js = js.replaceAll("function", "public static void");
		System.out.println(js);
		
	}
	
	public static void convertF() {
		
		js = js.replaceAll("const", "function")
//				.replaceAll(" = ()", "")
				.replaceAll(" => ", " ");
		
	}
	
	public static boolean checkArrow() {
		return js.indexOf("=>") > 0;
	}
}
