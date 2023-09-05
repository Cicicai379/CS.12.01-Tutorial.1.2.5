public class WordScrambler {
    private String[] scrambledWords;

    public WordScrambler(String[] wordArr) {
        if (wordArr.length % 2 != 0) {
            throw new IllegalArgumentException("Word Array must contain an even number of elements!");
        }

        for (int i = 0; i < wordArr.length; i++) {
            if (wordArr[i].contains(" ")) {
                throw new IllegalArgumentException("Word Array must contain single words only! " + wordArr[i] + " contains more than one word!");
            }
        }

        scrambledWords = mixedWords(wordArr);
    }
    private String recombine(String word1, String word2){

        return word1.substring(0,word1.length()/2) + word2.substring(word2.length()/2,word2.length());
    }


    private String[] mixedWords(String[] words) {
        String[] ans = new String[words.length];
        for(int i=0; i < words.length; i+=2){
            ans[i] = recombine(words[i], words[i+1]);
            ans[i+1] = recombine(words[i+1], words[i]);
        }
        return ans;
    }

    public String[] getScrambledWords(){
        return  scrambledWords;
    }
}
