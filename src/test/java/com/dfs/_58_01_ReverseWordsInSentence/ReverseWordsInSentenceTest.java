package com.dfs._58_01_ReverseWordsInSentence;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/21
 */
class ReverseWordsInSentenceTest {
    /**
     * 创建实例
     */
    ReverseWordsInSentence reverseWordsInSentence = new ReverseWordsInSentence();
    @Test
    void reverseSentence() {
        String res = reverseWordsInSentence.ReverseSentence("I am a student.");
        System.out.println(res);
    }
}
