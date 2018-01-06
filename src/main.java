import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.TreeViewer;
import java.io.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main 
{
	public static void main(String[] args) throws Exception 
	{
		String inputFile = null;
		if ( args.length>0 ) inputFile = args[0];
		InputStream is = System.in;
		if ( inputFile!=null ) is = new FileInputStream(inputFile);
		ANTLRInputStream input = new ANTLRInputStream(is);
		miniJavaLexer lexer = new miniJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		miniJavaParser parser = new miniJavaParser(tokens);
		ParseTree tree = parser.goal(); // parse; start at prog
		PrintStream ps = new PrintStream(new FileOutputStream(new File("d:"+File.separator+"test.txt")));
		ps.println(tree.toStringTree(parser));
		//System.out.println(tree.toStringTree(parser)); // print tree as text
		
		JFrame frame = new JFrame("Abstract Syntax Tree GUI");
	    JPanel panel = new JPanel();
	    TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);
	    viewer.setScale(1.0);//scale a little
	    panel.add(viewer);

	    frame.add(panel);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1366,768);
		
	}
}