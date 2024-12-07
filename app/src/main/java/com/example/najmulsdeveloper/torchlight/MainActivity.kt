package com.example.najmulsdeveloper.torchlight

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.text.method.Touch
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var toggleButton : ToggleButton
    private lateinit var displayText : TextView

    private lateinit var cameraManager: CameraManager
    private lateinit var cameraId : String






    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        toggleButton = findViewById(R.id.toggleButton)
        displayText = findViewById(R.id.textView)


        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        cameraId = cameraManager.cameraIdList[0]

        toggleButton.setOnClickListener {
            if (toggleButton.isChecked){
                cameraManager.setTorchMode(cameraId, true)
                Toast.makeText(this, "TORCH ON", Toast.LENGTH_SHORT).show()
                displayText.text = "TORCH ON"

            }


            else{
                cameraManager.setTorchMode(cameraId, false)
                Toast.makeText(this, "TORCH OFF", Toast.LENGTH_SHORT).show()
                displayText.text = "TORCH OFF"


            }
        }



    }
}

