package com.mycompany.app;

import java.util.ArrayList;

class App {

    public static boolean meaningFullFunct(ArrayList<Integer> nums1,
            ArrayList<Integer> nums2, String str1,
            String str2) {
        if (nums1.size() > str1.length() || nums2.size() > str2.length())
            return false;

        int intercetLength = Math.min(nums1.size(), nums2.size());

        for (int i = 0; i < intercetLength; i++) {
            if (str1.charAt(nums1.get(i)) != str2.charAt(nums2.get(i)))
                return false;
        }

        return true;
    }

}
