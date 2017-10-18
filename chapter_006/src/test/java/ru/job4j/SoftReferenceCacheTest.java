package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class SoftReferenceCacheTest.
 *
 * @author Alexander Mezgin.
 * @version 1.0.
 * @since 18.10.2017.
 */
public class SoftReferenceCacheTest {

    /**
     * Test.
     */
    @Test
    public void whenGetFileThenReturnThisFromCache() {
        SoftReferenceCache softReferenceCache = new SoftReferenceCache("d://temp");
        String separ = System.getProperty("line.separator");
        String str1 = softReferenceCache.getText("1.txt");
        String str2 = softReferenceCache.getText("1.txt");

        String result = String.format("dddffg%s89062931081%sovda@mail.ru%s", separ, separ, separ);

        assertThat(result, is(str1));
        assertThat(result, is(str2));
    }
}
