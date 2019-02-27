package detectors;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.visitor.VoidVisitor;
import detectors.UselessControlFlowDetector.forEachCheck;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Driver {

    private static final String FILE_PATH = "/Users/markglasgow/Documents/GitHub/workshop3/src/main/java/detectors/Calculator.java";

    public static void main(String[] args) throws Exception {

        CompilationUnit cu = JavaParser.parse( new FileInputStream( FILE_PATH ) );

        VoidVisitor <?> methodNameVisitor = new UselessControlFlowDetector();
        methodNameVisitor.visit( cu, null );
        List <String> methodNames = new ArrayList <>();
        BreakPoints b = new BreakPoints();

        VoidVisitor <List <String>> methodNameCollector = new UselessControlFlowDetector();
        methodNameCollector.visit( cu, methodNames );
        methodNames.forEach( n -> System.out.println( "Method Name Collected: " + n ) );

        VoidVisitor <BreakPoints> forEachCheck = new forEachCheck();
        forEachCheck.visit( cu, b );

    }
}





