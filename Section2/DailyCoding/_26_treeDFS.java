package Section2.DailyCoding;
import java.util.*;

public class _26_treeDFS {
    public static void main(String[] args) {
        _26_treeDFS.tree root = new _26_treeDFS.tree("1");
        _26_treeDFS.tree rootChild1 = root.addChildNode(new _26_treeDFS.tree("2"));
        _26_treeDFS.tree rootChild2 = root.addChildNode(new _26_treeDFS.tree("3"));
        _26_treeDFS.tree leaf1 = rootChild1.addChildNode(new _26_treeDFS.tree("4"));
        _26_treeDFS.tree leaf2 = rootChild1.addChildNode(new _26_treeDFS.tree("5"));
        ArrayList<String> output = dfs(root);
        //System.out.println(output); // --> ["1", "2", "4", "5", "3"]

        leaf1.addChildNode(new _26_treeDFS.tree("6"));
        rootChild2.addChildNode(new _26_treeDFS.tree("7"));
        output = dfs(root);
        System.out.println(output);
    }
//    static ArrayList<String> dfs(tree node) {
//        ArrayList<String> contain_ = new ArrayList<>();
//        return dfs_re(node,contain_);
//    }
//
//    static ArrayList<String> dfs_re(tree node, ArrayList<String> contain_){
//        if(node == null) return contain_;
//
//        contain_.add(node.getValue());
//        if(node.getChildrenNode() != null) {
//            for (int i = 0; i < node.getChildrenNode().size(); i++) {
//                contain_ = dfs_re(node.getChildrenNode().get(i),contain_);
//            }
//        }
//        return contain_;
//    }
//============================================================================

    static ArrayList<String> dfs(tree node) {
        ArrayList<String> values = new ArrayList<>();
        values.add(node.getValue());

        if(node.getChildrenNode() != null) {
            for(int i = 0; i < node.getChildrenNode().size(); i++) {
                ArrayList<String> curList = dfs(node.getChildrenNode().get(i));
                values.addAll(curList);
            }
        }
        return values;
    }







    //아래 클래스의 내용은 수정하지 말아야 합니다.
    public static class tree {
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
