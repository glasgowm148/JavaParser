package detectors;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.Objects;

class RecursionDetector extends VoidVisitorAdapter <BreakPoints> {

    private boolean isEmpty;

    @Override
    public void visit(MethodCallExpr m, BreakPoints b) {
        super.visit( m, b );

        String methodName = m.getNameAsString();
        Node p = m.getParentNode().get();

        while (!(p instanceof MethodDeclaration)) p = p.getParentNode().get();

        if (Objects.equals( ((MethodDeclaration) p).getNameAsString(), methodName )) b.addRecursive( methodName, m );

    }
}

/**
 * //////#### Solution #2 - Node.findAncestor attempt
 * // System.out.println(m.findAncestor( BlockStmt.class ));
 * Optional <MethodDeclaration> MethodDeclarationParent = m.findAncestor( MethodDeclaration.class );
 * // System.out.println("MethodCallExprParent : " + MethodDeclarationParent);
 * // if so, check whether that statement is empty && contains our node
 * if (MethodDeclarationParent.isPresent()) {
 * Optional <Node> BlockStmt = MethodDeclarationParent.get().getParentNode();
 * if (BlockStmt.isPresent()) {
 * Optional <Node> sameNode = BlockStmt.get().findFirst( Node.class, n -> n == m );
 * if (sameNode.isPresent()) {
 * isEmpty = true;
 * System.out.println( "####" + m.getNameAsString() );
 * }
 * }
 * }
 * //////####
 * <p>
 * ///// Working Solution - best method?
 **/