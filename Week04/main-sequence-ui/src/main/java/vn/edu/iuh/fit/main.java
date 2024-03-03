package vn.edu.iuh.fit;
import jdepend.xmlui.JDepend;
import java.io.PrintWriter;
public class main {
    public static void main(String[] args) throws  Exception{
        JDepend depend =new JDepend(new PrintWriter("report/repost.xml"));
        depend.addDirectory("T:\\Library-Assistant");
        depend.analyze();
        System.out.println("DONE");
    }
}
