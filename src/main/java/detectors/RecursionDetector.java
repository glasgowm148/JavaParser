package detectors;

import com.github.javaparser.ast.Node;

import java.util.ArrayList;
import java.util.List;

class RecursionDetector {

    public void recursionCheck(Node node, ArrayList <Node> leaves) {
        /**
         * method object as a parameter
         * Check each parent of the node to see if it is a method and has the same name as the current method
         * If so := recursive
         */

        List <Node> children = node.getChildNodes();
        if (children.isEmpty()) {
            leaves.add( node );
        } else {
            children.forEach( c1 -> {
                recursionCheck( c1, leaves );
            } );
        }

    }
}
