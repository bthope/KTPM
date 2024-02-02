package vn.edu.iuh.fit.examples;

import java.io.File;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class ListClassesExample {
	public static void listClasses(File projectDir) {
		new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
			System.out.println(path);
//		System.out.println(Strings.repeat("=", path.length()));
			try {
				new VoidVisitorAdapter<Object>() {
					@Override
					public void visit(ClassOrInterfaceDeclaration n, Object arg) {
						super.visit(n, arg);
						if(checkNameHoa(n.getNameAsString()))
							System.out.println("In " + n.getName());
					}
				}.visit(StaticJavaParser.parse(file), null);
				System.out.println(); // empty line
			} catch (Exception e) {
				new RuntimeException(e);
			}
		}).explore(projectDir);
	}

	public static void main(String[] args) {
		File projectDir = new File("..\\exercise2");
		listClasses(projectDir);
	}
	
	
	public static boolean checkNameHoa(String name) {
		char n = name.charAt(0);
		if (n >= 'A' && n <= 'Z') {
			return true;
		}
		return false;
	}
	
	public static boolean checkNameThuong(String name) {
		char n = name.charAt(0);
		if (n >= 'A' && n <= 'Z') {
			return true;
		}
		return false;
	}
	

}
