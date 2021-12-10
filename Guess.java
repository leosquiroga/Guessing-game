/* This program will play a simple guessing game.
 * The user will guess, and the computer should print if
 * the guess was too high, too low, or correct.
 */
 
var correctNum = Randomizer.nextInt(1,100); // The computer picks a random number between 1-100 for the correct answer
var counter = 0;
var guessList = [];

/* This function plays a simple guessing game in which if the guessed number is below the answer
 * it will print out "Low", if guessed too high it will print out "High", and finally guessed
 * correct the while loop ends and the game is over. The code uses the correctNum and <, >, ==
 * operators to see if the guess is low, high, or correct.  
 */
 
function start(){
    var greating = println("Welcome to the Guessing Game.");    
    var greating = println("Your task is to guess a number between 0 and 100");
    
    while(true){
        var guess = readInt("Please enter your guess : ");
        guessList.push(guess);
        counter++;
        
        if(correctNum < guess){
            println("Too high "); // This if statement prints High if the number guessed is higher the correct number
        }
        if(correctNum > guess){ 
            println("Too low "); // This if statement prints low if the number guessed is lower the correct number
        }
        if(correctNum == guess){ //This if statement prints Correct and stops the while loop once guessed correct
            print("Correct! ");
            break;
        }
        if(-1 == guess){
            break;
        }
    }
    theEnd();
}

function theEnd(){
    var txt = new Text("Congratulations!", "30pt Arial");
    txt.setPosition(getWidth()/2 - txt.getWidth()/2, 200);
    txt.setColor(Color.blue);
    add(txt);
    
    var txt = new Text("You guessed the secret number!", "20pt Arial");
    txt.setPosition(getWidth()/2 - txt.getWidth()/2, 250);
    txt.setColor(Color.green);
    add(txt);
    
    var txt = new Text(correctNum, "20pt Arial");
    txt.setPosition(getWidth()/2, 300);
    txt.setColor(Color.purple);
    add(txt);
    
    var txt = new Text("It took you " + counter + " tries", "20pt Arial");
    txt.setPosition(getWidth()/2 - txt.getWidth()/2, 350);
    txt.setColor(Color.green);
    add(txt);
    
    //display guesses
    var guesstxt = new Text("Guesses: ", "20pt Arial");
    guesstxt.setPosition(20, 400);
    guesstxt.setColor(Color.purple);
    add(guesstxt);
    
    var xpos = guesstxt.getWidth() + 30;
    var ypos = 400 ;
    for (i = 0; i < guessList.length ; i ++){
        var txt = new Text(guessList[i] + " ", "10pt Arial");
        txt.setPosition(xpos, ypos);
        txt.setColor(Color.purple);
        add(txt);
        
        xpos += txt.getWidth() + 2 ;
        if (xpos > getWidth() - txt.getWidth()){
            ypos += 30 ;
            xpos = guesstxt.getWidth() + 30;
        }
    }
}
