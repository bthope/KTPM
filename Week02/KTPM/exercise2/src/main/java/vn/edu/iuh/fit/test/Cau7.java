package vn.edu.iuh.fit.test;

import java.io.File;
import java.util.Optional;

/**
 * @author Le Huu Bang
 * @created-date 1/2/2024
 *
 */
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import vn.edu.iuh.fit.examples.DirExplorer;

public class Cau7 {
	public static void listClasses(File projectDir) {
		new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
			System.out.println(path);
//		System.out.println(Strings.repeat("=", path.length()));
			try {
				new VoidVisitorAdapter<Object>() {
					@Override
					public void visit(MethodDeclaration n, Object arg) {
						super.visit(n, arg);
						 if (!n.getNameAsString().equals("hashCode") && !n.getNameAsString().equals("equals") &&
			                        !n.getNameAsString().equals("toString") && !n.isDefault() &&
			                        !n.getNameAsString().equals("main")) {
			                    if (hasMethodComment(n)) {
			                    	System.out.println("Method have comment:" + n.getName());
			                    }
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
	
	
	 private static boolean hasMethodComment(MethodDeclaration n) {
	        for (Comment comment : n.getAllContainedComments()) {
	            if (comment instanceof LineComment) {
	                return true;
	            }
	        }
	        return false;
	    }
	 static boolean checkLegalComment(Optional<Comment> comment) {
		 if(!comment.isPresent())
			 return false;
		 Comment cmt=comment.get();
		 if(cmt.getContent().trim().isEmpty())
			 return false;
		 return true;
	 }
}
