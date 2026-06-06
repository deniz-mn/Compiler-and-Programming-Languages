import org.antlr.v4.runtime.*;

import main.ast.core.Program;
import main.visitor.PrintVisitor;

import java.io.IOException;

public class SimpleLang {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Usage: java SimpleLang <input-file>");
            return;
        }

        CharStream input = CharStreams.fromFileName(args[0]);

        SimpleLangLexer lexer = new SimpleLangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleLangParser parser = new SimpleLangParser(tokens);

        Program program = parser.program().programRet;

        PrintVisitor printVisitor = new PrintVisitor();
        program.accept(printVisitor);

        System.out.print(printVisitor.getOutput());
    }
}