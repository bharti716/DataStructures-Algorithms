package tree;

public class TreeToCDDL {

    Node concatenate(Node leftList, Node rightList)
    {

        // If either of the list is empty, then
        // return the other list
        if (leftList == null)
            return rightList;
        if (rightList == null)
            return leftList;

        // Store the last Node of left List
        Node leftLast = leftList.left;

        // Store the last Node of right List
        Node rightLast = rightList.left;

        // Connect the last node of Left List
        // with the first Node of the right List
        leftLast.right = rightList;

        // Right of last node refers to the first
        // node of the List
        rightList.left = leftLast;
        leftList.left = rightLast;
        rightLast.right = leftList;

        // Return the Head of the List
        return leftList;
    }


    Node bTreeToClist(Node root)
    {
        // Recursively convert left and right subtrees
        if (root == null)
            return null;

        // Make a circular linked list of single node
        // (or root). To do so, make the right and
        // left pointers of this node point to itself
        Node left = bTreeToClist(root.left);
        Node right = bTreeToClist(root.right);

        // Make a circular linked list of single node
        // (or root). To do so, make the right and
        // left pointers of this node point to itself
        root.left = root.right = root;

        // Step 1 (concatenate the left list with the list
        //         with single node, i.e., current node)
        // Step 2 (concatenate the returned list with the
        //         right List)
        return concatenate(concatenate(left, root), right);
    }
}
