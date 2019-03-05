package detectors;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;

import java.util.List;

class RecursionDetector {

    private List<Node> leaves;

    RecursionDetector(List <Node> children, MethodDeclaration n, BreakPoints b) {
        recursionCheck(children, n, leaves);

    }

    private void recursionCheck(List <Node> children, Node node, List <Node> leaves) {
        if (children.isEmpty()) {
            this.leaves.add( node );
            System.out.println(this.leaves);
        } else {
            children.forEach( n1 -> recursionCheck( children, n1, this.leaves ) );
        }

    }
}

// ArrayList <Node> children, MethodDeclaration n, ArrayList <Node> leave