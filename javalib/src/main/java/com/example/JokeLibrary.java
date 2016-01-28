package com.example;

import java.util.Random;

public class JokeLibrary {

    private String[] jokeArray;
    private Random random;


    public JokeLibrary() {
        jokeArray = new String[10];
        jokeArray[0] = "A physicist, an engineer and a programmer were in a car driving over a steep alpine pass when the brakes failed.\n" +
                "The car was getting faster and faster, they were struggling to get round the corners and once or twice only the feeble crash barrier saved them from crashing down the side of the mountain.\n" +
                "They were sure they were all going to die, when suddenly they spotted an escape lane. They pulled into the escape lane, and came safely to a halt./n" +
                "The physicist said \"We need to model the friction in the brake pads and the resultant temperature rise, see if we can work out why they failed\". The engineer said \"I think I've got a few spanners in the back./n" +
                "I'll take a look and see if I can work out what's wrong\". The programmer said \"Why don't we get going again and see if it's reproducible?\" ";
        jokeArray[1] = "A programmer started to cuss\n" +
                "Because getting to sleep was a fuss\n" +
                "As he lay there in bed\n" +
                "Looping 'round in his head was:\n" +
                "while(!asleep()) sheep++;";
        jokeArray[2] = "A good programmer is someone who always looks both ways before crossing a one-way street.";

        jokeArray[3] = "A wife calls her programmer husband and tells him, \"While you're out, buy some milk.\" \n" +
                "\n" +
                "He never returns home.";

        jokeArray[4] = "Q: Why do programmers always mix up Halloween and Christmas?\n" +
                "A: Because Oct 31 = Dec 25.";

        jokeArray[5] = "After recently having become a father, a programmer is asked by his buddy \"Is it a girl or a boy?\"\n" +
                "To which he replies: \"Yes.\" ";

        jokeArray[6] = "A programmers wife tells him, \"Run to the store and pick up a loaf of bread. If they have eggs, get a dozen.\" So the programmer comes home with twelve loafs of bread.";

        jokeArray[7] = "Q: Why did the programmer quit his job?\n" +
                "\n" +
                "A: Because he didn't get arrays.";

        jokeArray[8] = "Q: How did the programmer die in the shower?\n" +
                "\n" +
                "A: He read the shampoo bottle instructions: Lather. Rinse. Repeat.\n";

        jokeArray[9] = "Q: How many programmers does it take to change a light bulb?\n" +
                "\n" +
                "A: None, that's a hardware problem";

        random = new Random();

    }

    public String[] getJokeArray() {
        return jokeArray;
    }

    public String getJoke() {

        return jokeArray[random.nextInt(jokeArray.length)];
    }


}
