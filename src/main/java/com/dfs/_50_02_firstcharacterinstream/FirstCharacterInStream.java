package com.dfs._50_02_firstcharacterinstream;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Dafengsu
 * @date: 2019/8/19
 */
public class FirstCharacterInStream {
    StringBuilder sb = new StringBuilder();
    Map<Character, Integer> map = new HashMap<>(256);
    //Insert one char from stringstream
    public void Insert(char ch) {
        sb.append(ch);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (sb.length() == 0) {
            return '#';
        }
        for (int i = 0; i < sb.length(); i++) {
            if (map.get(sb.charAt(i)) == 1) {
                return sb.charAt(i);
            }
        }
        return '#';
    }
}
