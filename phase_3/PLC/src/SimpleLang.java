import main.ast.core.Program;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import main.visitor.nameAnalyzer.NameAnalyzer;
import main.visitor.typeAnalyzer.TypeAnalyzer;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class SimpleLang {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Please provide the input file path.");
            return;
        }

        CharStream reader = CharStreams.fromFileName(args[0]);
        SimpleLangLexer lexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleLangParser parser = new SimpleLangParser(tokens);

        Program program = parser.program().programRet;

        NameAnalyzer nameAnalyzer = new NameAnalyzer();
        program.accept(nameAnalyzer);

        TypeAnalyzer typeAnalyzer = new TypeAnalyzer();
        program.accept(typeAnalyzer);
    }
}
