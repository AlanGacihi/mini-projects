import java.util.Scanner;
import java.util.Arrays;


class WordInfo {
    public String word;
    public String meaning;

    public WordInfo(String wd, String mng) {
        word = wd;
        meaning = mng;
    }
}

class Dictionary {
    private WordInfo Dict[] = new WordInfo[10000];
    private int SP;
    
    public Dictionary() {
        for (int i = 0; i < 10000; i++) {
            Dict[i] = new WordInfo("", "");
       }
    }

    public boolean add(String word, String meaning) {
        // Adds a new word to the dictionary
        WordInfo wd = new WordInfo(word.toLowerCase(), meaning.toLowerCase());

        if (binarySearch(Dict, 10000 - SP, 9999, word) != -1)
        {
            System.out.println("Word already exists");
            return false;
        }
        	            
        Dict[SP++] = wd;
        Arrays.sort(Dict, (a, b) -> a.word.compareTo(b.word));
        return true;
    }

    public boolean delete(String word) {
        for(int i = 10000 - SP; i < 10000; i++) {
            if(Dict[i].word.compareTo(word) == 0) {
                Dict[i] = new WordInfo("", "");
                SP--;
                Arrays.sort(Dict, (a, b) -> a.word.compareTo(b.word));
                System.out.printf("%s deleted!\n", word);
                return true;
            }
        }
        System.out.printf("%s not found!\n", word);
        return false;
    }

    public String getMeaning(String word) {
        // Request a word and print its meaning if found in the dictionary.
        int x = binarySearch(Dict, 1000 - SP, 9999, word);
        if(x == -1) {
            System.out.println("Word not found!");
            return null;
        }
        else
            return Dict[x].meaning;
    }

    public int getCount() {
        // Return the number of words in the dictionary
        return SP;
    }

    public String printWordList() {
        // returns a list of all the words stored in the dictionary in alphabetical order
        String words = new String();

        for (int i = 10000 - SP; i < 10000; i++) {
            if (Dict[i].word.length() != 0) {
                words += Dict[i].word;
                words += "\n";
            }
        }

        System.out.printf(words);
        return words;    
    }

    public void printDictionary() {
        // Prints word and meaning for each word in the dictionary (in ascending order).
        for (int i = 10000 - SP; i < 10000; i++) {
            if (Dict[i].word.length() != 0) {
                System.out.printf("%s : %s\n" , Dict[i].word, Dict[i].meaning);
            }
        }
    }

    public int binarySearch(WordInfo array[], int low, int high, String str) {
        // Repeat until the pointers low and high meet each other
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid].word.compareTo(str) == 0)
                return mid;

            if (array[mid].word.compareTo(str) < 0)
                low = mid + 1;
                
            else
                high = mid - 1;
        }

        return -1;
    }

}

class Main {
    public static void main(String[] args) {

        Dictionary dic = new Dictionary();
        int i = 1;

        while (i == 1) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n1. Add new word");
            System.out.println("2. Delete word");
            System.out.println("3. Get meaning");
            System.out.println("4. Dictionary List");
            System.out.println("5. Print Dictionary");
            System.out.println("6. Exit");
            System.out.printf("Select option: ");
            int option = sc.nextInt();
                        
            switch (option) {
                case 1:
                    System.out.printf("Enter Word: ");
                    sc.nextLine();
                    String word = sc.nextLine();
                    System.out.printf("Enter Meaning: ");
                    String meaning = sc.nextLine();
                    dic.add(word, meaning);
                    break;

                case 2:
                    System.out.printf("Enter Word to be deleted: ");
                    sc.nextLine();
                    String del_word = sc.nextLine();
                    dic.delete(del_word);
                    break;

                case 3:
                    System.out.printf("Enter Word: ");
                    sc.nextLine();
                    String m_word = sc.nextLine();
                    System.out.println(dic.getMeaning(m_word));
                    break;

                case 4:
                    dic.printWordList();
                    break;

                case 5:
                    dic.printDictionary();
                    break;

                case 6:
                    i = 0;
                    break;
            }          
        }
    }
}
