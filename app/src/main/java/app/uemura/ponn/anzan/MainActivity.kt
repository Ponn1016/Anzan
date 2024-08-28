package app.uemura.ponn.anzan

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.uemura.ponn.anzan.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //バインディングクラスの変数
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //0~999の整数をランダムで生成
        val randomNumber1 = Random.nextInt(1000)
        val randomNumber2 = Random.nextInt(1000)

        //数字をTextViewに反映する
        binding.number1Text.text = randomNumber1.toString()
        binding.number2Text.text = randomNumber2.toString()
        
        //ランダムで正負を設定
        val randomOperator = Random.nextInt(2)

        //符号を表示する変数を設定
        var operatorText = ""

        //正解を表示する変数を設定
        var correctAnswer = 0

        //符号に関してのランダム設定 0⇒+/1⇒-
        if (randomOperator == 0){
            operatorText = "+"
            binding.signText.text = operatorText
            //正答の表示
            correctAnswer = randomNumber1 + randomNumber2
        }  else {
            operatorText = "-"
            binding.signText.text = operatorText
            //正答の表示
            correctAnswer = randomNumber1 - randomNumber2
        }


    }
}