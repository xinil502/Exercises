package leetcode;
/*
给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。

注意：如果对空文本输入退格字符，文本继续为空

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/backspace-string-compare
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.Scanner;

public class LeetCode_844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        sc.close();
        Solution_844 solution = new Solution_844();
        System.out.println(solution.backspaceCompare(str1, str2));
    }
}
class Solution_844 {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    String build(String C){
        char[] ch1 = C.toCharArray();
        char[] ch2 = new char[ch1.length];
        int i, j;
        for(i=0, j=0; i<ch1.length; ++i){
            if(ch1[i] == '#'){
                if(j == 0){
                    continue;
                }
                --j;
                continue;
            }
            ch2[j] = ch1[i];
            ++j;
        }
        if(j==0) { //如果为空数组，则不需要arraycopy
            return "";
        }
        char[] ch3 = new char[j];
        System.arraycopy(ch2, 0, ch3, 0, j);
        String str = String.valueOf(ch3);
        return str;
    }
}