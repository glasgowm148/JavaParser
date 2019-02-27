package detectors;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

class Driver {
    private static final String FILE_PATH = "/Users/markglasgow/Documents/GitHub/ooseworkshop3/src/main/java/com/workshop3/testcode/Calculator.java";

    public static void main(String[] args) {
        try {
            CompilationUnit cu = JavaParser.parse( new FileInputStream( FILE_PATH ) );
            BreakPoints breakpoints = new BreakPoints();
            // cu.accept(new VoidVisitorAdapter<Breakpoints>;
            //  UselessControlFlowDetector uselessControlFlowDetector = new UselessControlFlowDetector();

            new UselessControlFlowDetector().visit( cu, breakpoints );
            System.out.println( breakpoints.getOutput() );


            //  Breakpoints.printNode(cu.toString()); - static

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

    }
}