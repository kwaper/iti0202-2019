package ee.taltech.iti0202.testing;

import org.junit.Test;

import static org.junit.Assert.*;

public class SentenceTest {

    @Test
    public void testToString_EmptySentence_IsEmptyString() {
        Sentence sentence = new Sentence(); // Arrange

        String actual = sentence.toString(); // Act

        assertEquals("", actual); // Assert
    }

    @Test
    public void test_smallWord() {
        Sentence sentence = new Sentence(""); // Arrange
        String actual = sentence.toString(); // Act

        assertEquals("", actual); // Assert
    }


    @Test
    public void test_removeWord() {
        Sentence sentence = new Sentence("Hello"); // Arrange
        sentence.removeWord("Hello");
        assertFalse(sentence.removeWord("ahahaha"));
        String actual = sentence.toString(); // Act

        assertEquals("", actual); // Assert
    }

    @Test
    public void test_removeWord1() {
        Sentence sentence = new Sentence(); // Arrange
        sentence.addWord("World");
        sentence.addWord("hello");
        sentence.removeWord("World");
        String actual = sentence.toString(); // Act

        assertEquals("Hello...", actual); // Assert
    }

    @Test
    public void test_addWord() {
        Sentence sentence = new Sentence(); // Arrange
        sentence.addWord("hello");
        sentence.addWord("world");
        String actual = sentence.toString(); // Act

        assertEquals("Hello world...", actual); // Assert
    }

    @Test
    public void test_addPunctuation() {
        Sentence sentence = new Sentence("Hello"); // Arrange
        sentence.addPunctuation("!");
        String actual = sentence.toString(); // Act

        assertEquals("Hello!", actual); // Assert
    }

    @Test
    public void test_addWordAfterPunctuation() {
        Sentence sentence = new Sentence("Hello"); // Arrange
        sentence.addPunctuation("!");
        assertFalse(sentence.addWord("smth"));
        String actual = sentence.toString(); // Act

        assertEquals("Hello!", actual); // Assert
    }

    @Test
    public void test_removePunctuation() {
        Sentence sentence = new Sentence("Hello"); // Arrange
        sentence.addPunctuation("!");
        assertTrue(sentence.removePunctuation());
        sentence.addWord("world");
        String actual = sentence.toString(); // Act

        assertEquals("Hello world...", actual); // Assert
    }

    @Test
    public void test_addWordToPunctuation() {
        Sentence sentence = new Sentence("Hello!"); // Arrange
        assertFalse(sentence.addWord("world"));
    }

    @Test
    public void test_removeWithPunctuation() {
        Sentence sentence = new Sentence("Hello!"); // Arrange
        assertFalse(sentence.removeWord("Hello"));
        String actual = sentence.toString(); // Act

        assertEquals("Hello!", actual); // Assert
    }

    @Test
    public void test_firstAddPunctuation() {
        Sentence sentence = new Sentence(); // Arrange
        assertFalse(sentence.addPunctuation("!"));
        assertFalse(sentence.addPunctuation("."));
        assertFalse(sentence.addPunctuation("?"));
    }

    @Test
    public void test_ignoreWordsAfterPunctuation() {
        Sentence sentence = new Sentence("Hello! WORLD"); // Arrange
        assertFalse(sentence.addWord("smth"));
        String actual = sentence.toString(); // Act
        assertEquals("Hello!", actual); // Assert
    }

    @Test
    public void test_addWordSpace() {
        Sentence sentence = new Sentence("Hello"); // Arrange
        assertFalse(sentence.addWord(" "));
        assertFalse(sentence.addWord(""));
    }

    @Test
    public void test_addDoublePunctuation() {
        Sentence sentence = new Sentence("Hello!"); // Arrange
        assertFalse(sentence.addPunctuation("!"));
    }


    @Test
    public void test_ignoreSpaces() {
        Sentence sentence = new Sentence("Hello     world       hey"); // Arrange
        String actual = sentence.toString(); // Act
        assertEquals("Hello world hey...", actual); // Assert
    }


    @Test
    public void test_removeNoPunctuation() {
        Sentence sentence = new Sentence("Hello"); // Arrange
        assertFalse(sentence.removePunctuation());
        assertTrue(sentence.addPunctuation("!"));
        assertFalse(sentence.addPunctuation("."));
        assertFalse(sentence.addWord("smth"));
    }

    @Test
    public void test_total() {
        Sentence sentence = new Sentence(); // Arrange
        assertTrue(sentence.addWord("hello"));
        assertTrue(sentence.addWord("world"));
        assertTrue(sentence.addPunctuation("."));
        assertFalse(sentence.addWord("nooo"));
        assertFalse(sentence.addPunctuation("!"));
        assertTrue(sentence.removePunctuation());
        assertTrue(sentence.addWord("yes"));
        assertTrue(sentence.addPunctuation("?"));
        assertFalse(sentence.addPunctuation("!"));
        assertFalse(sentence.addWord("notYET"));
        assertFalse(sentence.removeWord("nonono"));
        assertFalse(sentence.removeWord("hello"));
        assertTrue(sentence.removePunctuation());
        assertTrue(sentence.removeWord("hello"));
        assertTrue(sentence.removeWord("world"));
        assertTrue(sentence.removeWord("yes"));

        String actual = sentence.toString(); // Act

        assertEquals("", actual); // Assert
    }

    @Test
    public void test_inStringDots() {
        Sentence sentence = new Sentence("so.me po.in.ts he,re but only end counts. yes?"); // Arrange
        String actual = sentence.toString(); // Act
        assertEquals("So.me po.in.ts he,re but only end counts.", actual); // Assert
    }

    @Test
    public void test_punctuationEquals() {
        Sentence sentence = new Sentence("Hello! alalalal! alalal"); // Arrange
        Sentence sentence1 = new Sentence("Hello");
        sentence.removePunctuation();
        String s1 = sentence1.toString();
        String s = sentence.toString();
        boolean eq = s1.equals(s);
        assertTrue(eq);
//        sentence1.addPunctuation("!");
//        String ss1 = sentence1.toString();
//        String ss = sentence.toString();
//        assertEquals(ss,ss1);

    }







}
