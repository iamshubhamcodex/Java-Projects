package css;

import java.util.HashMap;

public class Compiler {
	
	static String[] ar = new String[] { "padding", "margin", "height", "width", "top", "bottom", "justify-content", "position", "justify-items" };
	static HashMap<String, String> hm = new HashMap<>();
	static String css = ".container{"
			+ "p:5px; "
			+ "h:100px;"
			+ "w:100px;"
			+ "}"
			+ ""
			+ ".hi{"
			+ "	po:absolute"
			+ "}";
	static String style = "";
	
	public static void main(String[] args) {
		fillM();
		getCss();	
	}
	public static void getCss() {
		css = css.replaceAll("\n", "").replaceAll("\t", "").replaceAll(" ", "");
		int p1 = 0, p2 = 0;
		String tem = "";
		for(int a = 0; a< len(css); a++) {
			if(css.charAt(a) == '{') {
				p2 = a + 1;
				tem += css.substring(p1 + 1, p2) + "\n";
				p1 = p2;
			}else if(css.charAt(a) == '}'){
				p2 = a;
				tem += conv(css.substring(p1, p2)) + (a == len(css) - 1 ? "" : "}\n");
				p1 = p2;
			}
			if(css.charAt(a) == '.') {
			}
		}
		tem += css.substring(p1,len(css));
		
		System.out.println(tem);
	}
	
	public static int len(String val) {
		return val.length();
	}
	public static String conv(String style) {
		String spSty[] = style.split(";"), styleUp = "";

		for(int j = 0; j < spSty.length; j++) {
			String change[] = spSty[j].split(":");
			styleUp += "    " + hm.get(change[0]) + " : " + change[1] + ";\n"; 
		}
		return styleUp;
	}
	public static void fillM() {
		for (int i = 0; i < ar.length; i++) {
			String s, tar = ar[i], ars[] = tar.split("-");

			s = (tar.contains("-")) ? retSH(toS(ars[0].charAt(0)), toS(ars[1].charAt(0)), ars[0]) : retS(tar, toS(tar.charAt(0)));
			hm.put(s, tar);
		}
	}

	public static String retSH(String fir, String sec, String upf) {
		String ch = fir + "-" + sec;
		return check(ch) ? retSH(upf.substring(0, len(fir) + 1), sec, upf) : ch;

	}

	public static String retS(String val, String upv) {
		return (check(upv)) ? retS(val, val.substring(0, len(upv) + 1)) : upv;
	}

	public static boolean check(String s) {
		return hm.containsKey(s);
	}

	public static String toS(char s) {
		return Character.toString(s);
	}

}
