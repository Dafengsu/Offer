package com.hzau._68_commonparentIntree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/23
 */
public class CommonParentInTree {
    private boolean getPath(TreeNode pRoot, TreeNode node, LinkedList<TreeNode> path) {
        path.add(pRoot);
        if (pRoot == node) {
            return true;
        }
        boolean found;
        for (TreeNode child : pRoot.childs) {
            found = getPath(child, node, path);
            if (found) {
                return found;
            }
        }
        path.removeLast();
        return false;
    }

    private TreeNode getLastCommonNode(LinkedList<TreeNode> firstPath, LinkedList<TreeNode> secondPath) {
        TreeNode curNode = null;
        while (firstPath.size() > 1 && secondPath.size() > 1 && firstPath.peek() == secondPath.peek()) {
            curNode = firstPath.remove();
            secondPath.remove();
        }
        return curNode;
    }

    public TreeNode getLastParent(TreeNode pRoot, TreeNode first, TreeNode second) {
        LinkedList<TreeNode> firstPath = new LinkedList<>();
        LinkedList<TreeNode> secondPath = new LinkedList<>();
        getPath(pRoot, first, firstPath);
        getPath(pRoot, second, secondPath);
        return getLastCommonNode(firstPath, secondPath);
    }


}

class TreeNode {
    private int value;
    List<TreeNode> childs;

    public TreeNode(int value) {

        this.value = value;
        childs = new LinkedList<>();

    }

    public void putChild(TreeNode... childs) {
        this.childs.addAll(Arrays.asList(childs));
    }
}