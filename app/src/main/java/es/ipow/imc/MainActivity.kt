package es.ipow.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import es.ipow.imc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b : ActivityMainBinding
    private var height = 100
    private var weight = 75
    private var doubleHeight = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.skbHeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                b.tvHeightValue.text = progress.toString().plus("/200")
                height = progress

            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                doubleHeight = height.times(height)/10000.0
                b.tvIMC.text = Math.round((weight/doubleHeight).times(100)).div(100.0).toString()
            }
        })

        b.skbWeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                b.tvWeightValue.text = progress.toString().plus("/150")
                weight = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                doubleHeight = height.times(height)/10000.0
                b.tvIMC.text = Math.round((weight/doubleHeight).times(100)).div(100.0).toString()
            }

        })
    }
}

