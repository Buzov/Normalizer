
import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.ISynset;
import edu.mit.jwi.item.ISynsetID;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;
import edu.mit.jwi.item.Pointer;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author artur
 */
public class TestJWI {

    public static void main(String[] args) throws MalformedURLException, IOException {
        // construct the URL to the Wordnet dictionary directory
        String wnhome = System.getenv("./wordnet");
        //String path = wnhome + File.separator + "dict";
        String path = "./wordnet" + File.separator + "dict";
        URL url = new URL("file", null, path);
        // construct the dictionary object and open it
        IDictionary dict = new Dictionary(url);
        dict.open();
        // look up first sense of the word "dog"
        IIndexWord idxWord = dict.getIndexWord("canine", POS.NOUN);
        IWordID wordID = idxWord.getWordIDs().get(0);
        IWord word = dict.getWord(wordID);
        System.out.println("Id = " + wordID);
        System.out.println("Lemma = " + word.getLemma());
        System.out.println("Gloss = " + word.getSynset().getGloss());
        ISynset synset = word.getSynset();
        // get the hypernyms
        List<ISynsetID> hypernyms = synset.getRelatedSynsets(Pointer.HYPERNYM);
        // print out each hypernyms id and synonyms
        List<IWord> words;
        for (ISynsetID sid : hypernyms) {
            words = dict.getSynset(sid).getWords();
            System.out.print(sid + " {");
            for (Iterator<IWord> i = words.iterator(); i.hasNext();) {
                System.out.print(i.next().getLemma());
                if (i.hasNext()) {
                    System.out.print(", ");
                }
                System.out.println("}");
            }
        }
    }
}
