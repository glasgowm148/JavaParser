package detectors;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

class RecursionDetector extends VoidVisitorAdapter {

    private List <Node> leaves = null;
    private List <Node> children;
    private List <Statement> nodes;

    public RecursionDetector(BlockStmt node) {
        for (BlockStmt childNode : node.findAll( BlockStmt.class ))
            if (!childNode.getChildNodes().isEmpty())
                RecursionDetector( childNode );
    }


    void RecursionDetector(Node node) {
        leaves.add( node );
    }
}


// ArrayList <Node> children, MethodDeclaration n, ArrayList <Node> leave