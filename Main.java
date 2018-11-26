import java.util.Scanner;
public class Main {

    public static boolean inFoyer = true;
    public static boolean inLibrary = false;
    public static boolean inConservatory = false;
    public static boolean chestOpen = false;
    public static boolean haveMatches = false;
    public static boolean lightMatches = false;
    public static boolean unlockFoyerdoor = false;
    public static boolean haveBook = false;
    public static boolean havePen = false;
    public static boolean unlockLibrarydoor = false;
    public static boolean trumpet = false;
    public static boolean piano = false;
    public static boolean unlockConservatorydoor = false;
    public static int oneTurn;


    public static void main(String[] args) {
        oneTurn = 30;
        System.out.println("You wake up in a foyer. The only things in the room are a bench with a note on top, a chest, and an unlit candle. A locked door sits in the north. What do you want to do first?");
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();
        turn();

    }

    public static void turn() {
        Scanner sc = new Scanner(System.in);
        System.out.print(">>");
        String command = sc.nextLine();
        if (inFoyer) {
            System.out.println(foyer(command));
        } else if (inLibrary) {
            System.out.println(library(command));
        } else if (inConservatory){
            System.out.println(conservatory(command));
        }else{
        System.out.println("You are free!");
        }

        oneTurn = oneTurn - 1;
        if (oneTurn > 0) {
            System.out.println("You have " + oneTurn + " turns left");
        } else {
            System.out.println("Oh no! You ran out of turns. You are stuck eternally.");
        }
    }

    public static String foyer(String tasks) {
        String output;
        switch (tasks) {
            case "help":
            case "Help":
                output = "verbs = open, close, light, read, write, play, look, get.   Nouns = door, room, bench, chest, candle, note, matches, shelves, book, pen, scroll, music, trumpet, piano, drum, lock.";
                break;
            case "look":
            case "Look":
                output = "The only things in the room are a bench with a note on top, a chest, and an unlit candle. A locked door sits in the north.";
                break;
            case "look bench":
            case "Look bench":
                output = "A note lies on the bench";
                break;
            case "Look chest":
            case "look chest":
                output = "The chest is unlocked. There may be something inside of it";
                break;
            case "look candle":
            case "Look candle":
                output = "The candle is unlit. I wondering if there is something to light it in here.";
                break;
            case "read note":
            case "Read note":
                output = "The note reads,'May my light show you the way'";
                break;
            case "open chest":
            case "Open chest":
                output = "Inside the chest sits a box of matches.";
                chestOpen = true;
                break;
            case "get matches":
            case "Get matches":
                if (chestOpen) {
                    output = "You took out the matches";
                    haveMatches = true;
                } else {
                    output = "What matches?";
                }
                break;
            case "light matches":
            case "Light matches":
                if (haveMatches) {
                    output = "you light the matches";
                    lightMatches = true;
                } else {
                    output = "What matches?";
                }
                break;
            case "light candle":
            case "Light candle":
                if (lightMatches) {
                    output = "You light the candle and the door unlocks to the north";
                    unlockFoyerdoor = true;
                } else if (haveMatches) {
                    output = "you can't light a candle with unlit matches";
                } else {
                    output = "With what? You dont have anything light it with";
                }
                break;
            case "open door":
            case "Open door":
                if (unlockFoyerdoor) {
                    output = "You open the door and find yourself in a library. You see a desk with a scroll and pen on top, shelves lined with books, and another locked door to the north. The door quickly shuts behind you. What do you do now?";
                    inFoyer = false;
                    inLibrary = true;
                } else {
                    output = "The door is locked";
                }
                break;
            default:
                output = "Weird. Nothing happened.";
                break;
        }
        return output;
    }

    public static String library(String task) {
        String output;
        switch (task) {
            case "help":
            case "Help":
                output = "verbs = open, close, light, read, write, play, look, get.   Nouns = door, room, bench, chest, candle, note, matches, shelves, book, pen, scroll, music, trumpet, piano, drum, lock.";
                break;
            case "look":
            case "Look":
                output = "You see a desk with a scroll and pen on top, shelves lined with books, and another locked door to the north.";
                break;
            case "look desk":
            case "Look desk":
                output = "On the desk sits the scroll and a pen.";
                break;
            case "read scroll":
            case "Read scroll":
                output = "The scroll says'Share your Story'";
                break;
            case "look shelves":
            case "Look shelves":
                output = "One book stands out in the book shelf. The title is 'The Autobiography of...'";
                break;
            case "get book":
            case "Get book":
                output = "You grab the book and place it on the desk";
                haveBook = true;
                break;
            case "Get pen":
            case "get pen":
                output = "You grab the pen.";
                havePen = true;
                break;
            case "write book":
            case "Write book":
                if (haveBook && havePen) {
                    output = "You write your name in the book and the door suddenly unlocks. Magical!";
                    unlockLibrarydoor = true;
                } else if (haveBook && !havePen) {
                    output = "You have nothing to write it with.";
                } else {
                    output = "What book?";
                }
                break;
            case "open door":
            case "Open door":
                if (unlockLibrarydoor) {
                    output = "You open the door and reach the Conservatory. In the conservatory there is a trumpet, piano, and a drum. A piece of sheet music lies on a stand. Once again their is a door to the north.";
                    inConservatory = true;
                    inLibrary = false;
                } else {
                    output = "The door is locked";
                }
                break;
            default:
                output = "Weird. Nothing happened.";
                break;
        }
        return output;
    }
    public static String conservatory(String task1){
        String output;
        switch(task1){
            case "help":
            case "Help":
                output = "verbs = open, close, light, read, write, play, look, get.   Nouns = door, room, bench, chest, candle, note, matches, shelves, book, pen, scroll, music, trumpet, piano, drum, lock.";
                break;
            case "look":
            case "Look":
                output = "You see a trumpet, piano, and a drum. A piece of sheet music lies on a stand. Once again their is a door to the north.";
                break;
            case "look piano":
            case "Look piano":
                output = "The piano looks ready to play.";
                break;
            case "look drum":
            case "Look drum":
                output = "The drum looks ready to play.";
                break;
            case "look trumpet":
            case "Look trumpet":
                output = "The trumpet looks ready to play.";
                break;
            case "read music":
            case "Read music":
                output = "The music is empty, but the stand reads, 'Timbre, tone, and time'";
                break;
            case "play trumpet":
            case "Play trumpet":
                output = "You play the trumpet and you hear a lock opens, but the door isn't fully unlocked.";
                trumpet = true;
                break;
            case "play piano":
            case "Play piano":
                if(trumpet){
                    output = "Another latch on the lock opens, but it is still isn't fully unlocked.";
                    piano = true;
                }else{
                    output = "You play the piano, but nothing happens.";
                }
                break;
            case "play drum":
            case "Play drum":
                if (trumpet && piano) {
                    output = "The last part of the lock unlocks! Open the door to freedom!";
                    unlockConservatorydoor = true;
                }else if(trumpet && !piano) {
                    output = "You play the drum and it resets the lock to its original state.";
                    trumpet = false;
                }else {
                output = "You play the drum and nothing happens.";
                }
                break;
            case "open door":
            case "Open door":
                if(unlockConservatorydoor) {
                    output = "You open the door and walk out into your freedom.";
                    inConservatory = false;
                }else {
                    output = "The door is locked";
                }
                break;
                default:
                    output = "Weird. Nothing happened";
                    break;
        }
        return output;
    }
}
