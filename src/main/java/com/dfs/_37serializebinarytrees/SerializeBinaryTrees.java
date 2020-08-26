package com.dfs._37serializebinarytrees;

/**
 * @description:    面试题37：序列二叉树
 * @author: Dafengsu
 * @date: 2019/8/9
 */
public class SerializeBinaryTrees {
    /**
     * 序列化
     * @param root  根节点
     * @return  返回二叉树的序列化字符串
     */
    String serialize(TreeNode root) {
        //如果头节点为空直接返回null
        if (root == null) {
            return "$,";
        }
        //输出当前节点的值
        return root.val + "," +
                //递归遍历左子树的值
                serialize(root.left) +
                //递归遍历右子树的值
                serialize(root.right);
    }

    /**
     * 字符串的全局子针
     */
    private int index;

    /**
     * 字符串的反序列化
     * @param str   字符串
     * @return  反序列化后，链表的头节点
     */
    TreeNode deserialize(String str) {
        //初始化字符串子针
        index = -1;
        //把字符串分拆成字符串数组
        String[] strings = str.split(",");
        //反序列化
        return deserializeCore(strings);
    }

    /**
     * 字符串反序列化的主要过程
     * @param str
     * @return
     */
    private TreeNode deserializeCore(String[] str) {
        //字符串子针移动1
        index++;
        //如果是“$”直接返回空值
        if ("$".equals(str[index]) ) {
            return null;
        }
        //创建一个新的节点
        TreeNode root = new TreeNode(Integer.parseInt(str[index]));
        //如果数组子针不越界，递归创建左子树
        if (index+1 < str.length) {
            root.left = deserializeCore(str);
        }
        //如果数组子针不越界，递归创建右子树
        if (index + 1 < str.length) {
            root.right = deserializeCore(str);
        }
        return root;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
