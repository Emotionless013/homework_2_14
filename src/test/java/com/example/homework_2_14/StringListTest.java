package com.example.homework_2_14;

import com.example.homework_2_14.Exception.IncorrectIndexException;
import com.example.homework_2_14.Exception.IncorrectObjectException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringListTest {
    public final StringList stringList = new StringList();

    @BeforeEach
    public void addDefaultValues() {
        stringList.clear();
        stringList.add("one");
        stringList.add("one");
    }

    @Test
    public void returnsArrayFromStringlist() {
        String[] test = {"one", "one"};
        assertArrayEquals(test, stringList.toArray());
    }

    @Test
    public void returnsLengthEqualZeroWhenClear() {
        stringList.clear();
        assertEquals(0, stringList.size());
    }

    @Test
    public void returnFalseWhenStringListIsNotEmpty() {
        assertFalse(stringList.isEmpty());
    }

    @Test
    public void returnTrueWhenStringListIsEmpty() {
        stringList.clear();
        assertTrue(stringList.isEmpty());
    }

    @Test
    public void returnsSizeCorrectly() {
        assertEquals(2, stringList.size());
    }

    @Test
    public void returnsTrueForEqualStringList() {
        StringList test = new StringList();
        test.add("one");
        test.add("one");
        assertTrue(stringList.equals(test));
    }

    @Test
    public void returnsFalseForNotEqualStringList() {
        StringList test = new StringList();
        test.add("one");
        assertFalse(stringList.equals(test));
    }

    @Test
    public void throwsIncorrectIndexExceptionTryingToGetElementByWrongIndex() {
        assertThrows(IncorrectIndexException.class, () -> stringList.get(2));
    }

    @Test
    public void returnsCorrectStringByIndex() {
        assertEquals("one", stringList.get(0));
    }

    @Test
    public void indexOfreturnsIndexZeroAsIndexOfWordOne() {
        assertEquals(0, stringList.indexOf("one"));
    }

    @Test
    public void lastIndexOfreturnsIndexOneAsIndexOfWordOne() {
        assertEquals(1, stringList.lastIndexOf("one"));
    }

    @Test
    public void indexOfReturnsIndexMinusOneIfTheWordDoesntExist() {
        assertEquals(-1, stringList.indexOf("two"));
    }

    @Test
    public void lastIndexOfReturnsMinusOneIfTheWordDoesntExist() {
        assertEquals(-1, stringList.lastIndexOf("two"));
    }

    @Test
    public void containsReturnsTrueIfStringlistContainsElement() {
        assertTrue(stringList.contains("one"));
    }

    @Test
    public void containsReturnsFalseIfStringlistDoesntContainElement() {
        assertFalse(stringList.contains("two"));
    }

    @Test
    public void sizeReturnsThreeAfterExtend() {
        stringList.extend();
        assertEquals(3, stringList.size());
    }

    @Test
    public void sizeReturnsOneAfterContract() {
        stringList.contract();
        assertEquals(1, stringList.size());
    }

    @Test
    public void returnsZeroAfterAdd() {
        assertEquals("zero", stringList.add("zero"));
    }

    @Test
    public void zeroIsAddedToLastIndex() {
        stringList.add("zero");
        assertEquals(2, stringList.lastIndexOf("zero"));
    }

    @Test
    public void returnsZeroAfterAddByIndex() {
        assertEquals("zero", stringList.add(1,"zero"));
    }

    @Test
    public void zeroIsAddedToCorrectIndex() {
        stringList.add(1,"zero");
        assertEquals(1, stringList.lastIndexOf("zero"));
    }

    @Test
    public void throwsIncorrectIndexExceptionTryingToAddElementByWrongIndex() {
        assertThrows(IncorrectIndexException.class, () -> stringList.add(2, "zero"));
    }

    @Test
    public void returnsZeroAfterSetByIndex() {
        assertEquals("zero", stringList.set(1,"zero"));
    }

    @Test
    public void zeroIsSetAtCorrectIndex() {
        stringList.set(1,"zero");
        assertEquals(1, stringList.lastIndexOf("zero"));
    }

    @Test
    public void throwsIncorrectIndexExceptionTryingToSetElementByWrongIndex() {
        assertThrows(IncorrectIndexException.class, () -> stringList.set(2, "zero"));
    }

    @Test
    public void returnsOneAfterRemoval() {
        assertEquals("one", stringList.remove("one"));
    }

    @Test
    public void sizeWasContractedAfterRemoval() {
        stringList.remove("one");
        assertEquals(1, stringList.size());
    }

    @Test
    public void throwsIncorrectObjectExceptionTryingToRemoveElementThatDoesntExist() {
        assertThrows(IncorrectObjectException.class, () -> stringList.remove("zero"));
    }

    @Test
    public void returnsOneAfterRemovalByIndex() {
        assertEquals("one", stringList.remove(1));
    }

    @Test
    public void sizeWasContractedAfterRemovalByIndex() {
        stringList.remove(0);
        assertEquals(1, stringList.size());
    }

    @Test
    public void throwsIncorrectIndexExceptionTryingToRemoveElementByIndexThatDoesntExist() {
        assertThrows(IncorrectIndexException.class, () -> stringList.remove(5));
    }
}
