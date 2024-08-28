package app.uemura.ponn.anzan

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.uemura.ponn.anzan.databinding.ActivityAnswerBinding

class AnswerActivity : AppCompatActivity() {

    //バインディングクラスの変数
    private lateinit var binding: ActivityAnswerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAnswerBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //クイズ画面から問題を受け取る
        val displayQuestion = intent.getStringExtra("question")
        //入力された数字を受け取る
        val yourAnswer = intent.getStringExtra("answer")
        //正答を受け取る
        val correctAnswer = intent.getStringExtra("correct")


        //問題をTextViewに反映
        binding.questionText.text = displayQuestion
        //入力された数字をTextViewに反映
        binding.yourAnswerText.text = yourAnswer

        //入力された数字の正誤を判定する
        if (yourAnswer == correctAnswer) {
            //それぞれの場合で、〇×とランディの画像をImageViewに反映する
            binding.markImage.setImageResource(R.drawable.correct_image)
            binding.markImage.setImageResource(R.drawable.randy_happy_image)
        } else {
            binding.markImage.setImageResource(R.drawable.miss_image)
            binding.markImage.setImageResource(R.drawable.randy_sad_image)
        }


        //戻るボタンがタップされたときの処置
        binding.backButton.setOnClickListener() {
            //クイズ画面に情報を送る変数を準備
            val questionPage = Intent (this, MainActivity::class.java)
            //クイズ画面起動
            startActivity(questionPage)
            //アンサー画面を閉じる
            finish()
        }
    }
}