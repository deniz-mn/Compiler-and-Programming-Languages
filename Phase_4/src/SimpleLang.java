import main.ast.core.Program;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import main.visitor.CodeGenerator;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class SimpleLang {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java SimpleLang <source-file>");
            System.exit(1);
        }

        CharStream reader = CharStreams.fromFileName(args[0]);
        SimpleLangLexer lexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleLangParser parser = new SimpleLangParser(tokens);
        Program program = parser.program().programRet;

        if (parser.getNumberOfSyntaxErrors() != 0)
            throw new IllegalStateException("Code generation stopped because parsing failed");

        program.accept(new CodeGenerator());
    }
}
