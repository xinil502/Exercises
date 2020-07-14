package leetcode;

public class QueueNode {
    TreeNode root;
    int level;

    public QueueNode() {
    }

    public QueueNode(TreeNode root, int level) {
        this.root = root;
        this.level = level;
    }
}
