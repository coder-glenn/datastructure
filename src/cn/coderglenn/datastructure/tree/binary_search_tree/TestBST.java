package cn.coderglenn.datastructure.tree.binary_search_tree;

/**
 * @author Glenn.Zheng
 * @date 2018/8/16 15:53
 */
public class TestBST {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] numbers = {5, 3, 6, 8, 4, 2};
        for(int num : numbers) {
            bst.add(num);
        }

        /////////////////////////
       //       5             //
      //      /   \          //
     //      3      6       //
    //     /  \      \     //
   //    2     4      8   //
  /////////////////////////

        bst.preTraverse();

        System.out.println();
        bst.middleTraverse();

        System.out.println();
        bst.postTraverse();

        System.out.println("==============");

        System.out.print(bst);
    }

}
