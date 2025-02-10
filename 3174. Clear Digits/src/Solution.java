public class Solution {
    public String clearDigits(String s) {
        int[] str = s.chars().toArray();
        int count = str.length;
        for (int i = 0; i < str.length; i++){
            if(str[i] >= 48 && str[i] <= 57){
                if(i > 0){
                    for(int j = i-1; j >= 0; j--){
                        if(str[j] > 0){
                            str[j] = -1;
                            count--;
                            break;
                        }
                    }
                }
                count--;
                str[i] = -1;
            }
        }

        char[] new_str = new char[count];
        int index = 0;
        for(int i = 0; i < str.length; i++){
            if(str[i] > 0){
                new_str[index] = (char) str[i];
                index++;
            }
        }
        return new String(new_str);
    }


}
