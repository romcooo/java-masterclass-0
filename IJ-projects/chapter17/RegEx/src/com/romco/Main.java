package com.romco;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String s = "asDQweHarry12";
        System.out.println(s.replaceAll("[^er]", "a"));
        System.out.println(s.replaceAll("(?i)[a-q3-8]", "X"));
    
        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");
    
        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());
        matcher.reset();
        
        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("ocurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }
    
        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher grouptMatcher = groupPattern.matcher(htmlText);
        System.out.println(grouptMatcher.matches());
        grouptMatcher.reset();
        
        while (grouptMatcher.find()) {
            System.out.println("Occurrence: " + grouptMatcher.group(1));
        }
    
        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2p = Pattern.compile(h2TextGroups);
        Matcher h2M = h2p.matcher(htmlText);
        
        while (h2M.find()) {
            System.out.println("Occurrence " + h2M.group(2));
        }
    
        String harry = "harry";
        System.out.println(harry.replaceAll("[H|h]arry", "Larry"));
        
        //not:
        // ^ or !
        
        String tvTest = "tstvtkt";
//        String tvNotRegExp = "t[^v]";
        String tvNotRegExp = "t(?!v)"; //lookahead syntax: (? )
        Pattern tNotVPattern = Pattern.compile(tvNotRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);
        
        count = 0;
        while (tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
            
        }
        
        //positive lookahead -> if you want to find matches but you don't want to include the match
        // t(?=v)
        
        
    }
}
