package detectors;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static detectors.RecursionDetector.recursiveTest;

class Driver {
    private static final String FILE_PATH = "/Users/markglasgow/iCloud Drive (Archive)/Documents/GitHub/workshop3/src/main/java/detectors/Calculator.java";

    public static void main(String[] args) {
        try {
            CompilationUnit cu = JavaParser.parse( new FileInputStream( FILE_PATH ) );
            BreakPoints breakpoints = new BreakPoints();


            UselessControlFlowDetector MethodDeclaration = new UselessControlFlowDetector();
            MethodDeclaration.visit( cu , breakpoints );

            //             cu.accept(new UselessControlFlowDetector(), breakpoints);
            /*
             calling visit will fall apart when your node is an abstract class.
             It doesn't have methods for those. The idea is that nodes are the ones to call visit,
             and that they automagically pick the right visit method because they know their own type.
             So yes, you can call visit, but that's not how it's supposed to work.
             You're supposed to call accept and let the node call the visitor.
             Since there's not much point in using both visit and accept, just use accept, it will always work.
             */



            UselessControlFlowDetector ClassOrInterfaceDeclaration = new UselessControlFlowDetector();
            ClassOrInterfaceDeclaration.visit( cu, breakpoints );

            UselessControlFlowDetector IfStmt = new UselessControlFlowDetector();
            IfStmt.visit( cu, breakpoints );

            UselessControlFlowDetector ForStmt = new UselessControlFlowDetector();
            ForStmt.visit( cu, breakpoints );

            UselessControlFlowDetector WhileStmt = new UselessControlFlowDetector();
            WhileStmt.visit( cu , breakpoints );

            UselessControlFlowDetector SwitchStmt = new UselessControlFlowDetector();
            SwitchStmt.visit( cu, breakpoints );

            UselessControlFlowDetector DoStmt = new UselessControlFlowDetector();
            DoStmt.visit( cu, breakpoints );

            System.out.println(breakpoints.toString());

            // RecursionDetector recursive = new RecursionDetector( cu.findFirst( BlockStmt.class ).get() );
            // System.out.println( recursive );


            recursiveTest( cu, breakpoints );




        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

    }
}
