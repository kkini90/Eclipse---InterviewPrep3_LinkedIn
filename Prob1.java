package Linkedin;

/* This class will be given a list of words (such as might be tokenized
 * from a paragraph of text), and will provide a method that takes two
 * words and returns the shortest distance (in words) between those two
 * words in the provided text.
 * Example:
 *   WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
 *   assert(finder.distance("fox", "the") == 3);
 *   assert(finder.distance("quick", "fox") == 1);
 *
 * "quick" appears twice in the input. There are two possible distance values for "quick" and "fox":
 *     (3 - 1) = 2 and (4 - 3) = 1.
 * Since we have to return the shortest distance between the two words we return 1.
 */
public class WordDistanceFinder {
    HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
    
    public WordDistanceFinder (List<String> words) {
        // implementation here
        int index=0;
        for(String w : words){
            if(!map.containsKey(w){
                map.put(w,new ArrayList<Integer>());
            }
            map.get(w).add(index);
            index++;
        }
    }
    public int distance (String wordOne, String wordTwo) {
        // implementation here
        if(wordOne == null && wordTwo == null) return -1;
        int minDistance = Integer.MAX_VALUE;
        
        List<Integer> list1 = map.get(wordOne);
        List<Integer> list2 = map.get(wordTwo);
        int len1 = list1.size();
        int len2 = list2.size();
        // finder.distance("the", "quick")
        // (0,2), (1,4)
        
        for(int i=0;i<len1;i++){
            for(int j=0,j<len2;j++){
                minDistance = Math.min(Math.abs((list1.get(i) - list2.get(j))),minDistance);
            }
        }
        return minDistance;
        //--------------------------
    }
}
//http://www.programcreek.com/2014/08/page/4/