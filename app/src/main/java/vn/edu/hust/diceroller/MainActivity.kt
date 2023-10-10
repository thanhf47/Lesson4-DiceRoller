package vn.edu.hust.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dices Rolled!", Toast.LENGTH_SHORT).show()

            //Do a dice roll when the app starts
            rollDice()
        }
        //Do a dice roll when the app starts
        rollDice()
    }

    private fun rollDice() {
        //Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        var diceRoll = dice.roll()

        //Update the screen with the dice roll
//        var resultTextView: TextView = findViewById(R.id.textView)
//        resultTextView.text = diceRoll.toString()
//
//        resultTextView = findViewById(R.id.textView2)
//        resultTextView.text = dice.roll().toString()

        //Find the ImageView in the layout
        var diceImage: ImageView = findViewById(R.id.imageView)
        //Determine which drawable resource ID to use based on the dice roll
        var drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        //update the content description
        diceImage.contentDescription = diceRoll.toString()

        diceRoll = dice.roll()
        drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage = findViewById(R.id.imageView2)
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        //update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int = (1..numSides).random()
}