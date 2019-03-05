package detectors;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

class Driver {
    private static final String FILE_PATH = "/Users/markglasgow/iCloud Drive (Archive)/Documents/GitHub/workshop3/src/main/java/detectors/Calculator.java";

    public static void main(String[] args) {
        try {
            CompilationUnit cu = JavaParser.parse( new FileInputStream( FILE_PATH ) );
            BreakPoints breakpoints = new BreakPoints();

            UselessControlFlowDetector MethodDeclaration = new UselessControlFlowDetector();
            MethodDeclaration.visit( cu , breakpoints );

            UselessControlFlowDetector ClassOrInterfaceDeclaration = new UselessControlFlowDetector();
            ClassOrInterfaceDeclaration.visit( cu , breakpoints ); 

            UselessControlFlowDetector IfStmt = new UselessControlFlowDetector();
            IfStmt.visit( cu , breakpoints ); 

            UselessControlFlowDetector ForStmt = new UselessControlFlowDetector();
            ForStmt.visit( cu , breakpoints ); 

            UselessControlFlowDetector WhileStmt = new UselessControlFlowDetector();
            WhileStmt.visit( cu , breakpoints );

            UselessControlFlowDetector SwitchStmt = new UselessControlFlowDetector();
            SwitchStmt.visit( cu , breakpoints ); 

            UselessControlFlowDetector DoStmt = new UselessControlFlowDetector();
            DoStmt.visit( cu , breakpoints ); 

            System.out.println(breakpoints.toString());






        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

    }
}


/*

            new UselessControlFlowDetector().visit( cu, breakpoints );
            System.out.println( breakpoints.getOutput() );

            new UselessControlFlowDetector().visit(MethodDeclaration n, BreakPoints b) {
                setCurrMethod(n.getName().toString());
                super.visit(n, b);
            }
            new UselessControlFlowDetector().visit(ClassOrInterfaceDeclaration n, BreakPoints b) {
                setCurrClass(n.getName().toString());
                super.visit(n, b);
            }

            new UselessControlFlowDetector().visit(IfStmt n, BreakPoints b) {
                super.visit(n,b);
                if(controlFlowChecker(n))
                    b.addNode(n);

            }

            new UselessControlFlowDetector().visit(ForStmt n, BreakPoints b) {
                super.visit(n, b);
                if(controlFlowChecker(n))
                    b.addNode(n);

            }

            new UselessControlFlowDetector().visit(WhileStmt n, BreakPoints b) {
                super.visit(n, b);
                if(controlFlowChecker(n))
                    b.addNode(n);

            }

            new UselessControlFlowDetector().visit(SwitchStmt n, BreakPoints b) {
                super.visit(n, b);
                if(controlFlowChecker(n))
                    b.addNode(n);

            }

            @Override
            new UselessControlFlowDetector().visit(DoStmt n, BreakPoints b) {
                super.visit(n, b);
                if(controlFlowChecker(n))
                    b.addNode( currClass, currMethod, n.getBegin().get().line, n.getEnd().get().line );

            }

 */

