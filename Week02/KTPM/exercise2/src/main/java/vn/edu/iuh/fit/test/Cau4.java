package vn.edu.iuh.fit.test;

import java.io.File;
/**
 * @author Le Huu Bang
 * @created-date 1/2/2024
 *
 */
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import vn.edu.iuh.fit.examples.DirExplorer;

public class Cau4 {
	public static void listClasses(File projectDir) {
		new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
			System.out.println(path);
//		System.out.println(Strings.repeat("=", path.length()));
			try {
				new VoidVisitorAdapter<Object>() {
					@Override
					public void visit(FieldDeclaration n, Object arg) {
						super.visit(n, arg);
						if (n.getVariables().get(0).getNameAsString().matches("[a-z][a-zA-Z]*")) {
		                   System.out.println("Field: " + n.getVariables().get(0).getNameAsString());
		                }
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
}
