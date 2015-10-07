package entity;

/**
 *
 * @author RT
 */
public class Word {
    private String word;
    private int frequency;
    private String transcription;
    private String translation;
    
    public Word() {
        
    }
    
    public Word(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }
    
    public Word(String word, int frequency, String translation) {
        this.word = word;
        this.frequency = frequency;
        this.translation = translation;
    }
    
    public Word(String word, int frequency, String transcription, String translation) {
        this.word = word;
        this.frequency = frequency;
        this.transcription = transcription;
        this.translation = translation;
    }

    /**
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * @param word the word to set
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * @return the frequency
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    /**
     * @return the translation
     */
    public String getTranslation() {
        return translation;
    }

    /**
     * @param translation the translation to set
     */
    public void setTranslation(String translation) {
        this.translation = translation;
    }

    /**
     * @return the transcription
     */
    public String getTranscription() {
        return transcription;
    }

    /**
     * @param transcription the transcription to set
     */
    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }
    
    
    
    
}
