package algorithm.leetcode.l1_100.l51_100.l_71;

/***********************************************************                                          *
 * Time: 2022/5/20
 * Author: HuHong
 * Desc: 简化路径
 ***********************************************************/

class Solution {
    public String simplifyPath(String path) {
        path = path + "/";
        StringBuilder res = new StringBuilder(), name = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            char t = path.charAt(i);
            if (t != '/') name.append(t);
            else {
                if (name.toString().equals("..")) {
                    // 如果是..则删除上一个路径（如果存在）
                    while (res.length() > 0 && res.charAt(res.length() - 1) != '/') res.deleteCharAt(res.length() - 1);
                    if (res.length() > 0) res.deleteCharAt(res.length() - 1);
                } else if (name.length() != 0 && !name.toString().equals(".")) {
                    // 只有上一个路径非空并且不为.才是合法的，需要将上一个路径加入栈
                    res.append("/").append(name);
                }
                name.delete(0, name.length());
            }
        }
        if (res.length() == 0) res.append("/");
        return res.toString();
    }
}

//class Solution {
//    public String simplifyPath(String path) {
//        path = path + "/";
//        Stack<String> q = new Stack<>();
//        q.add("/");
//        StringBuilder pre = new StringBuilder();
//        for (int i = 1; i < path.length(); i++) {
//            char t = path.charAt(i);
//            if (t == '/') {
//                if (path.charAt(i - 1) == '/' || pre.length() == 0) {
//                    pre.delete(0, pre.length());
//                    continue;
//                }
//                if (pre.toString().equals(".")) {
//                    pre.delete(0, pre.length());
//                    continue;
//                } else if (pre.toString().equals("..")) {
//                    if (q.size() > 0 && !q.peek().equals("/")) {
//                        q.pop();
//                    }
//                } else {
//                    q.push(pre.toString());
//                }
//                pre.delete(0, pre.length());
//            } else {
//                pre.append(t);
//            }
//        }
//        StringBuilder res = new StringBuilder();
//        Object[] array = q.toArray();
//        for (int i = 0; i < array.length; i++) {
//            if (i > 1) res.append("/");
//            res.append(array[i]);
//        }
//        return res.toString();
//    }
//}