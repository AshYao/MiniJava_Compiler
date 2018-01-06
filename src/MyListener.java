import org.antlr.v4.runtime.*;

public class MyListener extends BaseErrorListener {
	// 可进行Syntax Error提醒的ErrorListener
	public static class SyntaxErrorListener extends BaseErrorListener {
		public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
				String msg, RecognitionException e) {
			System.err.println("[Syntax Error]");
			System.err.println("line " + line + ":" + charPositionInLine + " " + msg);
		}
	}
}