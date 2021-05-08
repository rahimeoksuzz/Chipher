package Cipher;
/**
* BIL122 - Project 02
* 
* @author Rahime, <rahimeoksuzz@gmail.com>
*/

public class Cipher {
    String keyword; //The secret key used to create a ciphertext alphabet that consists of only the letters of the alphabet
    String ciphertextAlphabet; //Alphabet generated using key
    final String plaintextAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    Cipher(String key) { 
        this.keyword = key;
        initCiphertextAlphabet();
    }
    //Returns a new string without repetition, removing repetitions from the given text.
    static String removeDups(String s) { 
        if(s.length() == 0){
            return s;
        }
        String result = new String();
        //Checks whether the result is available for each character in S. If not, it adds the character to the result.
        for(int i = 0; i < s.length(); i++){
            if(result.indexOf(s.charAt(i)) != -1)
                continue;
            //If not, it adds the character to the result.
            else{
                result += s.charAt(i);
            }      
        }
        return result;
    }
    //Starts the encrypted text alphabet from the secret key.
    String initCiphertextAlphabet() {
        if(keyword.length() == 0){
            return plaintextAlphabet;
        }
        ciphertextAlphabet = removeDups(keyword.toUpperCase());
        for(int i = 0; i < plaintextAlphabet.length(); i++){
            if (ciphertextAlphabet.indexOf(plaintextAlphabet.charAt(i)) == -1){
                ciphertextAlphabet += plaintextAlphabet.charAt(i);
            } 
        }
        return ciphertextAlphabet;
    }
    //Encrypt the message sent using Ciphertexti
    String encrypt(String message) { 
        if(keyword.length() == 0)
            return message.toUpperCase();
        if(message.length() == 0)
            return message;
        message = message.toUpperCase();
        String encryptMsg = new String();
        for(int i = 0; i < message.length(); i++){
            if(plaintextAlphabet.indexOf(message.charAt(i)) == -1){
                encryptMsg += message.charAt(i);
            }
            //Inserts the corresponding ciphertext letter into ciphertext for each plaintext letter in the message
            else{
                int character = plaintextAlphabet.indexOf(message.charAt(i));
                encryptMsg += ciphertextAlphabet.charAt(character);
            }
        }
        return encryptMsg;
    }
    //Decrypts the given message using ciphertext
    String decrypt(String ciphertext) { 
        if(keyword.length() == 0)
            return ciphertext.toUpperCase();
        if(ciphertext.length() == 0)
            return ciphertext;
        ciphertext = ciphertext.toUpperCase();
        String originalMsg = new String();
        for(int i = 0; i < ciphertext.length(); i++){
            //For each letter in ciphertext, inserts the plaintext letter corresponding to the decrypted text.
            if(ciphertextAlphabet.indexOf(ciphertext.charAt(i)) == -1){ 
                originalMsg += ciphertext.charAt(i);
            }
            //If the character is not in the scrambled alphabet, adds it to the decrypted text.
            else{
                int character = ciphertextAlphabet.indexOf(ciphertext.charAt(i));
                originalMsg += plaintextAlphabet.charAt(character);
            }
        }
        return originalMsg;
    }
    public static void main(String[] args) {
        
        String key ="medenıyet2021";
        Cipher m = new Cipher(key);
        String emesg = "THIS IS A SECRET";
        System.out.println(m.encrypt(emesg));
        String dmesg = "O20L 0L M LIDKIO";
        System.out.println(m.decrypt(dmesg));
    }
}
