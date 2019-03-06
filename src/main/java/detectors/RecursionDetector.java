package detectors;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

class RecursionDetector extends VoidVisitorAdapter <BreakPoints> {

    private static BreakPoints b = new BreakPoints();

    static void recursiveTest(CompilationUnit arg, BreakPoints nodes) {
        List <BlockStmt> nodess = null;
        nodess = arg.findAll( BlockStmt.class );
        for (BlockStmt n : nodess)
            if (n.getChildNodes().isEmpty()) {
                b.addDNode( n );
                // nodess.remove( n );
            }
        recursiveTest( arg, nodes );
    }
}




