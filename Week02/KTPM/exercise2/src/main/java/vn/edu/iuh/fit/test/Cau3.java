package vn.edu.iuh.fit.test;

import java.io.File;
/**
 * @author Le Huu Bang
 * @created-date 1/2/2024
 *
 */
import java.util.Optional;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import vn.edu.iuh.fit.examples.DirExplorer;

public class Cau3 {
	public static void listClasses(File projectDir) {
		new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
			System.out.println(path);
//		System.out.println(Strings.repeat("=", path.length()));
			try {
				new VoidVisitorAdapter<Object>() {
					@Override
					public void visit(JavadocComment n, Object arg) {
						super.visit(n, arg);
						System.out.println("[ "+n.getBegin() + "] " +n+" [ "+n.getEnd());
						 if(!checkLegalComment(n.getComment()))
							 System.out.println("------------------------Method has comment ");
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
	 static boolean checkLegalComment(Optional<Comment> comment) {
		 if(!comment.isPresent())
			 return false;
		 Comment cmt=comment.get();
		 if(cmt.getContent().trim().isEmpty())
			 return false;
		 
		 if (cmt instanceof LineComment) {
             String commentContent = cmt.getContent().trim();
             if (commentContent.startsWith("created-date") && commentContent.contains("author")) {
                 return true;
             }
         }
		 return true;
	 }
}
