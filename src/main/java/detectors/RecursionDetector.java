package detectors;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.Objects;

class RecursionDetector extends VoidVisitorAdapter <BreakPoints> {

    private static BreakPoints b = new BreakPoints();

    @Override
    public void visit(MethodCallExpr m, BreakPoints b) {
        String methodName = m.getNameAsString();
        Node p = m.getParentNode().get();

        while (!(p instanceof MethodDeclaration)) {
            p = p.getParentNode().get();

        }

        if (Objects.equals( ((MethodDeclaration) p).getNameAsString(), methodName )) {
            b.addRecursive( methodName, m );
        }

    }
}
