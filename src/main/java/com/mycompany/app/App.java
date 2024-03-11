package com.mycompany.app;


import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

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
    /*
     * public static boolean search(ArrayList<Integer> array, int e) {
     * System.out.println("inside search");
     * if (array == null) return false;
     * 
     * for (int elt : array) {
     * if (elt == e) return true;
     * }
     * return false;
     * }
     */

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            // System.out.println(req.queryParams("input1"));
            // System.out.println(req.queryParams("input2"));

            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            while (sc1.hasNext()) {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s", ""));
                inputList.add(value);
            }
            System.out.println(inputList);

            String input2 = req.queryParams("input2");
            sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
            while (sc1.hasNext()) {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s", ""));
                inputList2.add(value);
            }
            System.out.println(inputList2);

            String input3 = req.queryParams("input3").replaceAll("\\s", "");
            String input4 = req.queryParams("input4").replaceAll("\\s", "");

            boolean result = App.meaningFullFunct(inputList, inputList2, input3, input4);

            Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());

        get("/compute",
                (rq, rs) -> {
                    Map map = new HashMap();
                    map.put("result", "not computed yet!");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; // return default port if heroku-port isn't set (i.e. on localhost)
    }
}
