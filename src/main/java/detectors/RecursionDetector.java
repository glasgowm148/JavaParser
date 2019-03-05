package detectors;

import com.github.javaparser.ast.Node;

import java.util.ArrayList;
import java.util.List;

class RecursionDetector {

    private void recursionCheck(Node node, ArrayList <Node> leaves) {

        List <Node> children = node.getChildNodes();
        if (children.isEmpty()) {
            leaves.add( node );
        } else {
            children.forEach( c1 -> recursionCheck( c1, leaves ) );
        }

    }
}
