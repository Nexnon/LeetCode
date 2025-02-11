public class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int i = stringBuilder.indexOf(part);
        if(i != -1){
            stringBuilder.delete(i, i+part.length());
            stringBuilder = new StringBuilder(removeOccurrences(stringBuilder.toString(), part));
        }
        return stringBuilder.toString();
    }
}
