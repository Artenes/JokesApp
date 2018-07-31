package com.artenesnogueira.puns;

import java.util.Random;

/**
 * What’s it called when you put a cow in an elevator? Raising the steaks.
 */
public class Puns {

    private static final String[] puns = new String[17];
    private final Random randomize = new Random();

    /**
     * How do trees access the internet? They log on.
     *
     * @return Is your refrigerator running? Better go catch it.
     */
    public String getPun() {
        return getRandomPun();
    }

    /**
     * I saw an ad for burial plots, and thought to myself this is the last thing I need.
     *
     * @return Yesterday a clown held the door for me. It was a nice jester.
     */
    private String getRandomPun() {
        return puns[getRandomPunIndex()];
    }

    /**
     * The wedding was so emotional even the cake was in tiers.
     *
     * @return Why can't bicycles stand up on their own? Since they are 2 tired.
     */
    private int getRandomPunIndex() {
        return randomize.nextInt(puns.length);
    }

    static {
        puns[0] = "What do you call a belt with a watch on it? A waist of time.";
        puns[1] = "What did the Buffalo say to his little boy when he dropped him off at school? Bison.";
        puns[2] = "Did you hear about the guy who lost the left side of his body? He's alright now.";
        puns[3] = "I did a theatrical performance on puns. It was a play on words.";
        puns[4] = "Towels can’t tell jokes. They have a dry sense of humor.";
        puns[5] = "A cross eyed teacher couldn’t control his pupils.";
        puns[6] = "To write with a broken pencil is pointless.";
        puns[7] = "What should you do if you are cold? Stand in the corner. It’s 90 degrees.";
        puns[8] = "The energizer bunny went to jail. He was charged with battery.";
        puns[9] = "What do you call a bear with no teeth? A gummy bear.";
        puns[10] = "What’s it called when you put a cow in an elevator? Raising the steaks.";
        puns[11] = "How do trees access the internet? They log on.";
        puns[12] = "Is your refrigerator running? Better go catch it.";
        puns[13] = "I saw an ad for burial plots, and thought to myself this is the last thing I need.";
        puns[14] = "Yesterday a clown held the door for me. It was a nice jester.";
        puns[15] = "The wedding was so emotional even the cake was in tiers.";
        puns[16] = "Why can't bicycles stand up on their own? Since they are 2 tired.";
    }

}