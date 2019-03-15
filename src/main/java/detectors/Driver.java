package detectors;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

class Driver {

    private static final String FILE_PATH = "/Users/markglasgow/Desktop/Calculator.java";

    public static void main(String[] args) {
        try {
            CompilationUnit cu = JavaParser.parse( new FileInputStream( FILE_PATH ) );

            BreakPoints breakpoints = new BreakPoints();

            // .accept() will iterate through all the methods in UselessControlFlow
            cu.accept( new UselessControlFlowDetector(), breakpoints );

            // Print out the methods with useless control flow.
            System.out.println(breakpoints.toString());

            // RecursiveDetector call
            cu.accept( new RecursionDetector(), breakpoints );
            System.out.println( "Recursive Methods ::" );
            System.out.println( breakpoints.toString() );

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

    }
}
