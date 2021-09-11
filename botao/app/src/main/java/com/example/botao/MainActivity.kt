package com.example.botao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /** Criei variavel para a UI Button é o que prepara para receber a Funcao qnd for clicado */
        val rollButton: Button = findViewById(R.id.button)
        /** Funcao em Bloco, é o que vai avisar o app que o Button foi clicado*/
        rollButton.setOnClickListener {
            /** Chamando a funcao private fun rollDice()*/
            rollDice()
        }
    }
    /** (Declarando é o mesmo que criando), Declarando a funcao rollDice*/
    private fun rollDice() {
        /**Criando a instancia Dice, (setando o valor)*/
        val dice = Dice(6)
        /** Chamando a funcao roll, criada abaixo*/
        val diceRoll = dice.roll()
        /** Variavel para o resultado aparecer*/
        val diceImage: ImageView = findViewById(R.id.imageView)
        /** toString para converter, pois ele espera receber um string e na classe Dice o parametro é Int*/
        when (diceRoll){
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
        val toast = Toast.makeText(this, "Rolou um dado!", Toast.LENGTH_SHORT)
        toast.show()
    }
}
/** Esta classe poderia ser feita em File-New-KotlinClass/file. O numero que ela ira receber esta instanciado na fun rollDice */
class Dice(val numSides: Int)
{
    /** Qnd tem o fun estou declarando ou seja criando. Esta e a funcao que sorteia o numero*/
    fun roll(): Int{
        return (1..numSides).random()
    }
}