package Section2.DailyCoding;
import java.util.*;

public class _27_treeBFS {
    public static void main(String[] args) {
        _27_treeBFS.tree root = new _27_treeBFS.tree("1");
        _27_treeBFS.tree rootChild1 = root.addChildNode(new _27_treeBFS.tree("2"));
        _27_treeBFS.tree rootChild2 = root.addChildNode(new _27_treeBFS.tree("3"));
        _27_treeBFS.tree leaf1 = rootChild1.addChildNode(new _27_treeBFS.tree("4"));
        _27_treeBFS.tree leaf2 = rootChild1.addChildNode(new _27_treeBFS.tree("5"));
        ArrayList<String> output = bfs(root);
        //System.out.println(output); // --> ["1", "2", "3", "4", "5"]

        leaf1.addChildNode(new _27_treeBFS.tree("6"));
        rootChild2.addChildNode(new _27_treeBFS.tree("7"));
        output = bfs(root);
        System.out.println(output);
    }

//    static ArrayList<String> bfs(tree node) {
//        ArrayList<String> result = new ArrayList<String>();
//        ArrayList<tree> queue = new ArrayList<tree>();
//        return bfs_circuit(node,result,queue);
//    }
//
//    static ArrayList<String> bfs_circuit(tree node, ArrayList<String> result,ArrayList<tree> queue){
//        queue.add(node);
//        while(queue.size() != 0){
//            tree tmp = queue.remove(0);
//            result.add(tmp.getValue());
//            if(tmp.getChildrenNode() != null) {
//                for (int i = 0; i < tmp.getChildrenNode().size(); i++) {
//                    queue.add(tmp.getChildrenNode().get(i));
//                }
//            }
//        }
//        return result;
//    }
//=======================================================================================

    static ArrayList<String> bfs(tree node) {
        Queue<tree> queue = new LinkedList<>();
        ArrayList<String> values = new ArrayList<>();
        queue.add(node);

        while(queue.size() > 0) {
            tree curNode = queue.poll();

            values.add(curNode.getValue());

            if(curNode.getChildrenNode() != null) {
                queue.addAll(curNode.getChildrenNode());
            }
        }
        return values;
    }


    //아래 클래스의 내용은 수정하지 말아야 합니다.
    static class tree {
        private String value;
        private ArrayList<tree> children;

        public tree(String data) {
            this.value = data;
            this.children = null;
        }

        public tree addChildNode(tree node) {
            if(children == null) children = new ArrayList<>();
            children.add(node);
            return children.get(children.size() - 1);
        }

        public String getValue() {      //현재 노드의 데이터를 반환
            return value;
        }

        public ArrayList<tree> getChildrenNode() {
            return children;
        }
    }
}
