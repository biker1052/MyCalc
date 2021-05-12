package kg.tutorialapp.mycalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    lateinit var mathOperation: TextView
    lateinit var result: TextView
    lateinit var bt1: TextView
    lateinit var bt2: TextView
    lateinit var bt3: TextView
    lateinit var bt4: TextView
    lateinit var bt5: TextView
    lateinit var bt6: TextView
    lateinit var bt7: TextView
    lateinit var bt8: TextView
    lateinit var bt9: TextView
    lateinit var bt0: TextView
    lateinit var btPlus: TextView
    lateinit var btMinus: TextView
    lateinit var btMult: TextView
    lateinit var btDiv: TextView
    lateinit var btAC: TextView
    lateinit var btBack: TextView
    lateinit var btPoint: TextView
    lateinit var btEqual: TextView
    lateinit var btStartBracket: TextView
    lateinit var btEndBracket: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mathOperation = findViewById(R.id.mathOperation)
        result = findViewById(R.id.result)
        bt1 = findViewById(R.id.bt1)
        bt2 = findViewById(R.id.bt2)
        bt3 = findViewById(R.id.bt3)
        bt4 = findViewById(R.id.bt4)
        bt5 = findViewById(R.id.bt5)
        bt6 = findViewById(R.id.bt6)
        bt7 = findViewById(R.id.bt7)
        bt8 = findViewById(R.id.bt8)
        bt9 = findViewById(R.id.bt9)
        bt0 = findViewById(R.id.bt0)
        btPlus = findViewById(R.id.btPlus)
        btMinus = findViewById(R.id.btMinus)
        btDiv = findViewById(R.id.btDivision)
        btMult = findViewById(R.id.btMultiply)
        btPoint = findViewById(R.id.btPoint)
        btBack = findViewById(R.id.btBack)
        btAC = findViewById(R.id.btAC)
        btEqual = findViewById(R.id.btEqual)
        btStartBracket = findViewById(R.id.btStartBracket)
        btEndBracket = findViewById(R.id.btEndBracket)

        bt0.setOnClickListener { sttextFields("0") }
        bt1.setOnClickListener { sttextFields("1") }
        bt2.setOnClickListener { sttextFields("2") }
        bt3.setOnClickListener { sttextFields("3") }
        bt4.setOnClickListener { sttextFields("4") }
        bt5.setOnClickListener { sttextFields("5") }
        bt6.setOnClickListener { sttextFields("6") }
        bt7.setOnClickListener { sttextFields("7") }
        bt8.setOnClickListener { sttextFields("8") }
        bt9.setOnClickListener { sttextFields("9") }

        btPlus.setOnClickListener { sttextFields("+") }
        btMinus.setOnClickListener { sttextFields("-") }
        btDiv.setOnClickListener { sttextFields("/") }
        btMult.setOnClickListener { sttextFields("*") }
        btStartBracket.setOnClickListener { sttextFields("(") }
        btEndBracket.setOnClickListener { sttextFields(")") }
        btPoint.setOnClickListener { sttextFields(".") }
        btAC.setOnClickListener {
            mathOperation.setText("")
            result.setText("")
        }
        btBack.setOnClickListener {
            var str = mathOperation.text.toString()
            if (str.isNotEmpty()) {
                mathOperation.text = str.substring(0,(str.length-1))
            }
            result.setText("")
        }
        btEqual.setOnClickListener {
            try {
                val ex = ExpressionBuilder(mathOperation.text.toString()).build()
                val vresult = ex.evaluate()
                val longRes = vresult.toLong()
                if (vresult==longRes.toDouble())
                    result.text = longRes.toString()
                else result.text = vresult.toString()
            } catch (e:Exception) {
                Log.d("Ошибка","Сообщение ${e.message}")
                result.text="Ошибка ${e.message}"
            }
        }


    }



    fun sttextFields(str: String){
        if (result.text !="") {
            mathOperation.text = result.text
            result.text=""
        }
    mathOperation.append(str)
    }
}
